/*alert('login js 열림');*/

//1. 로그인
function login(){
	
	//1. 입력받은 값 
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	//2. 
	$.ajax({
		url : "/jspWeb/login",
		method : "post",
		data : {"mid" : mid, "mpwd" : mpwd},
		success : (r) => {
			if(r == 'true'){
				location.href = "/jspWeb/index.jsp";
				alert('[로그인 성공] 환영합니다.');
			}else{
				document.querySelector('.checkconfirm').innerHTML = "로그인 정보가 틀립니다.";
			}
		}
	})
}


//2. 아이디 찾기
function findId(){
	console.log('findId');
	
	let memail = document.querySelector('.memail').value;
	
	/*비슷한 기능끼리는 서블릿을 여러개를 만들지 않기 위해 type을 나눔.
		type 1은 아이디 찾기
		type 2면 비밀번호 찾기
	 */
	$.ajax({
		url : "/jspWeb/find",
		method : "get",
		data : {"type" : 1, "memail" : memail},
		success : (r) => {
			if(r == 'false'){
				document.querySelector('.checkconfirm').innerHTML = '해당 정보를 찾을 수 없습니다.';
			}else{
				document.querySelector('.checkconfirm').innerHTML = '회원님의 아이디 : ' + r;
			}
		}
	})
}

//3. 비밀번호 찾기
function findPwd(){
	console.log('findPwd');
	let info = {
		type : 2,
		mid : document.querySelector('.mid').value,
		memail : document.querySelector('.memail').value
	}
	
	$.ajax({
		url : "/jspWeb/find",
		method : "",
		data : info,
		success : (r) => {
			if(r == "false"){
				document.querySelector('.checkconfirm').innerHTML = '해당 정보를 찾을 수 없습니다.';
			}else{
				/*임시 비밀번호 버전*/
				/*document.querySelector('.checkconfirm').innerHTML = '임시 비밀번호를 이메일로 전송했습니다.';*/
				document.querySelector('.checkconfirm').innerHTML = '임시 비밀번호 : ' + r;
				
				/*비밀번호 변경 버전 */
/*				let html = `
				<h3> 비밀번호 변경 </h3>
				<p>회원님의 비밀번호를 변경해주세요.</p>
				<div class = "changePwdBox">
					<div class = "title">새 비밀번호</div>
					<input onkeyup = "pwdCheck()" maxlength = "20" type = "password" class = "mpwd" name = "mpwd"> 
					<div class = "checkconfirm"></div>
					
					<div class = "title">새 비밀번호 확인</div>
					<input onkeyup = "pwdconfirmCheck()" maxlength = "20" type = "password" class = "mpwdconfirm" name = "mpwdconfirm">
					<div class = "checkconfirm"></div>
					
					<button class = "signupBtn" type = "button" onClick = "changePwd()"> 비밀번호 변경 </button>
				</div>`
				
				document.querySelector('.signupForm').innerHTML = html;*/
				
			}
		}
	})
}

//4. 비밀번호 변경
function changePwd(){
	if(document.querySelector('.checkconfirm') == 'O'){
		let mpwd = document.querySelector('.mpwd');
		
		$.ajax({
			url :"/jspWeb/find",
			method : "post",
			data : {'mpwd' : mpwd},
			success : (r) => {
				
			} 
		})
	}
}