alert('signup js 열림');

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
				alert('[회원가입 성공]');
				document.querySelector('.mid').value = '';
				document.querySelector('.mpwd').value = '';
				document.querySelector('.mpwdconfirm').value = '';
				document.querySelector('.memail').value = '';
				document.querySelector('.mimg').value = '';
				checkconfirm[0].innerHTML = '';
			}else{
				alert('[회원가입 실패] 관리자에게 문의하세요.');
			}
		}
	})
	
	
}
//3. 비밀번호 유효성 검사
function pwdCheck(){
	console.log("pwdCheck 입력중");
	//1. 입력받은 값 가져오기
	let mpwd =document.querySelector('.mpwd').value;
	console.log("mpw : " + mpwd)
	//2. 정규표현식 : 영대소문자+숫자 조합 5~20글자 0-9대신 \d 써도 똑같다. ex) [\dA-Z] 이런식으로
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/ //정규표현식
	/*첫글자는 영 대소문자 중에 시작해야하고, 뒤부터는 숫자는 반드시 포함해야한다. 영대소문자+숫자 조합으로 */
	console.log(mpwdj.test(mpwd));
	
	if(mpwdj.test(mpwd)){
		//checkconfirm[1]은 비밀번호와 비밀번호 확인을 같이 씀 그래서 성공해도 pwdconfirmCheck() 호출해야함
		checkconfirm[1].innerHTML = 'O'; pwdconfirmCheck();
	}else{
		checkconfirm[1].innerHTML = '영대소문자+숫자 조합 5~20글자로 입력해주세요.'
	}
	
}

//4. 비밀번호 확인 유효성 검사
function pwdconfirmCheck(){
	console.log("pwdconfirmCheck 입력중");
	let mpwdconfirm =document.querySelector('.mpwdconfirm').value;
	console.log("mpwdconfirm : " + mpwdconfirm);
	let mpwd =document.querySelector('.mpwd').value;
	////2. 정규표현식 : 영대소문자+숫자 조합 5~20글자 0-9대신 \d 써도 똑같다. ex) [\dA-Z] 이런식으로
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/ //정규표현식
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