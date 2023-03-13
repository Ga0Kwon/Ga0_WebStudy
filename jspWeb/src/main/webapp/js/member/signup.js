/*alert('signup js 열림');*/

/* 
	JS 정규 표현식 : 문자 특정 규칙, 패턴, 집합 표현할 때 사용되는 언어
		-- 문법
			/^ : 정규표현식 시작 
			$/ : 정규표현식 끝
			[a-z] : 소문자 a-z 패턴
			[A-Z] : 대문자 A-Z 패턴
			[0-9] : 숫자 0-9 패턴 <----------------> \d : 정수라는 의미
			[가-힣] : 한글 패턴
			{ 최소길이, 최대길이 } : 문자열 길이 패턴 
			+ : 앞에 있는 패턴이 1개 이상 반복
			? : 앞에 있는 패턴이 0개 혹은 1개 이상 반복
			* : 앞에 있는 패턴이 0개 반복
			
			
			-- 영문만 입력 
			[a-zA-Z] 
			-- 영문+숫자 입력
			[a-zA-Z0-9]
			-- 영문+숫자+한글 입력
			[a-zA-Z0-9가-힣]
			-----
			1개 이상 문자가 포함되어야 하는 경우
			(?=.*[a-z]) : 소문자 한개 이상 입력해야함
			(?=.*[A-Z]) : 대문자 한개 이상 입력해야함
			(?=.*[0-9]) : 숫자 한개 이상 입력해야함
			(?=.*[!@#$%^&*]) : 해당하는 특수문자 한개 이상 입력해야함 
			
		-- 패턴 검사 함수
			정규표현식.test(데이터) : 패턴이 적합하면 true / 아니면 false
			ex)
				/^[a-z]$/.test(qwe) => true
				/^[a-z]$/.test(QWE) => false
*/
// * 첨부파일 이미지 미리보기 [업로드와 상관없음]
// onchange : 바뀌었을 때 
// 정책 : 사용자[클라이언트]에 운영체제 접근 불가  
/*document.addEventListener('change', (e)=>{
	
})*/
function premimg(object){ // object : 해당 함수를 실행시킨 태그 객체
	/*console.log('첨부파일 바뀜' + object);*/
	
	/*둘 중에 하나 쓰면 됨 */
	//1-1). 현재 이벤트를 실행한 input의 파일명을 호출 
	/*console.log(object.files[0]); */
	//1-2). input의 파일명을 호출 
	/*console.log(document.querySelector('.mimg').files[0])*/
	//1. JS 파일 클래스
	let file = new FileReader(); //파일 읽기 클래스 
	//2. 해당 첨부된 파일 읽어오기(file.readAsDataURL(첨부파일))
	file.readAsDataURL(object.files[0]) //해당 파일 읽어오기 / files[0] : 첨부파일 1개
	//3.읽어온 파일 꺼내기 바이트단위
	file.onload = (e) => {
		/*console.log(e.target.result) */// 바이트 단위 나옴
		//e.target -> file.onload : 읽어온 파일
		//e.tartget.result : 읽어온 파일의 바이트 결과
		//4. 이미지 태그에 src 이미지 바이트  대입 
		document.querySelector('.premimg').src = e.target.result;
	}
}

// * checkconfirm span 모두 가져오기 --> 여러개의 span이 배열/리스트 객체에 대입
let checkconfirm = document.querySelectorAll('.checkconfirm');
/* 1 인덱스 : 아이디 checkconfirm 
   2 인덱스 : 비밀번호 checkconfirm
   3 인덱스 : 비밀번호 확인 checkconfirm
   4 인덱스 : 이메일 checkconfirm
*/

//2. 아이디 유효성 검사 [1. 문자 체크 2. 중복 검사]
function idCheck(){
	
	//1. 입력할때마다 입력값 가져오기
	let mid = document.querySelector('.mid').value;
	
	//2. 정규표현식 [영문 소문자 + 숫자, 길이 : 5~30글자]
	let midj = /^[a-z0-9]{5,30}$/;
	
	//3. 정규표현식
	if(midj.test(mid)){
		//아이디 중복 검사 [js-> 서블릿 -> dao 에게 해당 아이디 검색 select]
		$.ajax({
			url : "/jspWeb/mconfirm",
			method : "get",
			data : {"mid" : mid},
			success : (r) => {
	/*			console.log(r) //응답결과 [있으면 true / 없으면 false]*/
				if(r == 'true'){
					checkconfirm[0].innerHTML = "사용중인 아이디";
				}else{
					checkconfirm[0].innerHTML = "O";		
				}
			}
		})
		
	}else{
		checkconfirm[0].innerHTML = "영소문자+숫자 조합 5~30글자 사이로 입력해주세요.";
	}
}

//1. 회원 가입
function signup(){
	let count = 0;
	for(let i = 0; i < checkconfirm.length; i++){
		if(checkconfirm[i].innerHTML == 'O'){count++}
	}
	
	if(count != 3){alert('정상적으로 입력되지 않은 데이터가 있습니다.'); return;}
	
	//1) [첨부파일 있을 때] html file 직접적으로 조작 불가능
		//1> form 객체를 가져오기
	let signupForm = document.querySelectorAll('.signupForm')[0]; //첫번째 form 가져오기
		//2> form 안에 있는 data 객체 호출 {js API}
	let signupFormData = new FormData(signupForm);
	
	//2. [첨부파일 있을 때] ajax 
	$.ajax({
		url : "/jspWeb/member",
		method : "post", // 첨부파일은 무조건 post/put
		data : signupFormData, // FormData라는 객체 전송
		// 첨부파일이 있을 때 추가되는 속성
		contentType : false, // 기본값 : true [매개변수 형식의 문자열 전송]
								//form-urlencoded 해제 
		processData : false, // false : 해제
								//multipart/form 형식으로 전송
		success : (r) => {
			/*console.log('ajax 응답');*/
			if(r == 'true'){
				openModal();
				location.href = "/jspWeb/member/login.jsp";
			}else{
				alert('[회원가입 실패] 관리자에게 문의하세요.');
			}
		}
	})
	
	
}
//3. 비밀번호 유효성 검사
function pwdCheck(){

	//1. 입력받은 값 가져오기
	let mpwd =document.querySelector('.mpwd').value;

	//2. 정규표현식 : 영대소문자+숫자 조합 5~20글자 0-9대신 \d 써도 똑같다. ex) [\dA-Z] 이런식으로
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/ //정규표현식
	/*첫글자는 영 대소문자 중에 시작해야하고, 뒤부터는 숫자는 반드시 포함해야한다. 영대소문자+숫자 조합으로 */

	
	if(mpwdj.test(mpwd)){
		//checkconfirm[1]은 비밀번호와 비밀번호 확인을 같이 씀 그래서 성공해도 pwdconfirmCheck() 호출해야함
		checkconfirm[1].innerHTML = 'O'; pwdconfirmCheck();
	}else{
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20글자로 입력해주세요.'
	}
	
}

//4. 비밀번호 확인 유효성 검사
function pwdconfirmCheck(){

	let mpwdconfirm =document.querySelector('.mpwdconfirm').value;

	let mpwd =document.querySelector('.mpwd').value;
	////2. 정규표현식 : 영대소문자+숫자 조합 5~20글자 0-9대신 \d 써도 똑같다. ex) [\dA-Z] 이런식으로
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/ //정규표현식
	/*  /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/  
		1. (?=.*[A-Za-z]) : 영 대소문자 한개 이상 입력
		2. (?=.*\d) vs (?=.*[0-9]) : 슷지 한개 이상 입력
		3. [A-Za-z\d] vs. [A-Za-z0-9] : 영대소문자 + 숫자 
		---> 영문 1개 + 숫자 1개 필수로 갖는 5~20글자 사이
		
		(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{5,20}
		---> 영대문자 1개 + 영소문자 1개 + 숫자 1개 + 특정특수문자 1개 필수로 갖는 5~20글자 사이
	*/
	//3. 제어
	if(mpwdj.test(mpwdconfirm)){
		//두 비밀번호간의 동일성 체크
		if(mpwdconfirm == mpwd){ //두 비밀번호가 같으면 
			checkconfirm[1].innerHTML = 'O';
		}else{ //두 비밀번호가 같지 않으면
			checkconfirm[1].innerHTML = '두 비밀번호가 일치하지 않습니다.';
		}
	}else{
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20글자로 입력해주세요.'
	}
	
	
}
//이메일 유효성 검사 [이메일 형식 유효성 검사]
function emailCheck(){
	let memail = document.querySelector('.memail').value;
	
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9]+$/;
	
	if(memailj.test(memail)){
		checkconfirm[2].innerHTML ='이메일 형식이 맞습니다. 인증해주세요.'
		document.querySelector('.authBtn').disabled = false; //인증 버튼 사용
	}else{
		checkconfirm[2].innerHTML ='이메일 형식으로 입력해주세요.'
		document.querySelector('.authBtn').disabled = true;//형식이 틀리면 인증 버튼 사용 X 
	}
	//아이디 구역
	// [a-zA-Z0-9_-] : 영문 + 숫자 + _ + -
	// +@ : 아이디와 도메인 사이의 @
	// 도메인 구역
	//[a-zA-Z0-9-]   : 영문 + 숫자 + - (ex> naver)
	//기능이 있는 점은 슬래시와 함께 적어줘야한다. 
	// +\. : 점이 필수 도메인 앞 부분 .com/.co.kr/.net [도메인 중간에 .] (ex>.)
	// [a-zA-Z0-9-] : 영문+숫지 + - (ex> com)
	// + : .1개이상 (ex> co.kr)
}

// 이메일 인증 함수
function getAuth(){
	/*메일*/
	
	/*----------------------- 1. 메일 인증 쓸 경우 ------------------------- */
	//* ajax가 java에게 이메일 전송 후 인증코드 받기
/*	$.ajax({
		url :"/jspWeb/email",
		method : "post",
		data : {"memail" : document.querySelector('.memail').value},
		success : (r) =>{
			let html = `<div class = "timeBox"></div>
				<input type = "text" class = "authInput" placeholder="인증코드">
				<button onClick = "authConfirm()" type = "button">확인</button>`
				
			auth = r; //인증 코드 대입[이메일에게 보낸 난수 대입
			
			document.querySelector('.authBox').innerHTML = html;
		}
	})*/
	/*----------------------- 2. 메일 인증 쓰지 않을 경우 ------------------------- */
	
	// 인증 구역 html 구성
	let html = `<div class = "timeBox"></div>
				<input type = "text" class = "authInput" placeholder="인증코드">
				<button onClick = "authConfirm()" type = "button">확인</button>`
				
	// html 대입
	document.querySelector('.authBox').innerHTML = html;
	
	//3. 타이머 함수 실행
	auth = 1234; //*인증 임시 코드 대입 [이메일에게 전송 보내는]
	timer = 60*2; //인증 시간 대입
	setTimer(); //타이머 함수 실행
}

let auth =  0;

let timer = 0; //인증 시간 변수
let timerInterval; //Interval 함수를 저장할 변수
//타이머 함수
function setTimer(){
	
	// setInterval : 특정 시간마다 함수 실행
	//setInterval(() => {}, 시간/밀리초)
	//clearInterval : Interval 종료 
	//timerInterval이라는 변수를 안쓰면 재사용이 불가능함.
	// -> setInterval이 두개면 어느 것을 삭제할지 식별이 안됨. 
	//즉, 이름을 만들어 식별하여 사용
	timerInterval = setInterval(() => {
		let minutes = parseInt(timer/60); //분 계산[소수점 안쓰기 때문]
		let seconds = timer%60; //분 계산후 나머지가 초
		
		// 한자리 수 이면 0 추가
		minutes = minutes < 10 ? "0" + minutes : minutes;
		seconds = seconds < 10 ? "0" + seconds : seconds;
		
		let timeHTML = minutes + ":" + seconds; // 분 : 초 형식으로 html 구성
		
		//html에 대입
		document.querySelector('.timeBox').innerHTML = timeHTML;
		
		//1초 차감
		timer--;
		
		if(timer <= 30){
			document.querySelector('.timeBox').style.color = "red";
		}
		
		//만약에 인증 시간이 0보다 작아지면
		if(timer < 0){
			clearInterval(timerInterval); 
			checkconfirm[2].innerHTML = "인증 실패";
			document.querySelector('.authBox').innerHTML = ""; //auth 내 html 지우기
		}
		
	}, 1000); //1초마다 {}코드 실행
}
//인증 -> 확인 버튼 눌렀을 때 [인증코드 확인]
function authConfirm(){
	console.log("authConfirm() 실행");
	//1. 입력받은 인증코드 가져오기
	let authInput = document.querySelector('.authInput').value;
	
	//2. 발급된 인증코드와 입력한 인증코드 비교
	if(authInput == auth){//인증코드 일치
		checkconfirm[2].innerHTML = 'O';
		clearInterval(timerInterval); //인증 타이머 clear
		document.querySelector('.authBox').innerHTML = ""; //인증 구역 숨기기
		document.querySelector('.authBtn').innerHTML = "완료";
		document.querySelector('.authBtn').disabled = true;
		document.querySelector('.authBtn').style.backgroundColor = "#87a381";
		
	}else{//인증 코드 불일치
		checkconfirm[2].innerHTML = "인증 코드가 일치하지 않습니다.";
	}
}


//1)[첨부파일 없을 때] 입력값을 모두 가져와서 객체화
/*	let info = {
		mid : document.querySelector('.mid').value,
		mpwd : document.querySelector('.mpwd').value,
		mpwdconfirm : document.querySelector('.mpwdconfirm').value,
		memail : document.querySelector('.memail').value,
		mimg : document.querySelector('.mimg').value
	}
		console.log(info);
		
	//2)[첨부파일 없을 때] ajax 통신을 이용한 서블릿에게 데이터를 보내고 응답 받기
	$.ajax({
		url : "/jspWeb/member", // 서블릿 클래스의 @WebServlet("/member")
		method : "post", // 메소드 선택
		data : info,
		success : (r) => {
			console.log('ajax 응답');
			console.log(r);
			if(r == 'true'){
				alert('회원가입 성공!');
				location.href = "/jspWeb/index.jsp"; // 회원 가입 성공하면 메인 페이지로 이동
			}else{
				alert('회원가입 실패')
			}
		}
	})
	*/