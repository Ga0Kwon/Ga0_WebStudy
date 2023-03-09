/*alert('login js 열림');*/

function login(){
	
	//1. 입력받은 값 
	let mid = document.querySelector('.mid').value;
	let mpwd = document.querySelector('.mpwd').value;
	
	console.log(mid , mpwd)
	
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
				alert('[로그인 실패] 아이디 혹은 비밀번호가 틀렸습니다.')
			}
		}
	})
	
	
}