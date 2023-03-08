<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 회원가입 </h3>
	
	<form class = "signupForm"> <!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		아이디 : <input onkeyup = "idCheck()" maxlength = "30" type = "text" class = "mid" name = "mid"> 
		<span class = "idcheckconfirm"></span><br/>
		비밀번호 : <input type = "password" class = "mpwd" name = "mpwd"> <br/>
		비밀번호 확인 : <input type = "password" class = "mpwdconfirm" name = "mpwdconfirm"> <br/>
		이메일 :  <input type = "text" class = "memail" name = "memail"> <br/>
		프로필 : <input type = "file" class = "mimg" name = "mimg"><br/>
		
		<button type = "button" onClick = "signup()"> 가입 </button>
	</form>
	
	<!-- 1. JQUERY (ajax 사용하기 위해) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자 정의 js -->
	<script src = "/jspWeb/js/member/signup.js" type = "text/javascript"></script>
	
	
</body>
</html>