<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file = "/header.jsp" %> <!-- 절대 경로 -->
	<h3> 회원가입 </h3>
	
	<form class = "signupForm"> <!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
		아이디 : <input onkeyup = "idCheck()" maxlength = "30" type = "text" class = "mid" name = "mid"> 
			<span class = "checkconfirm"></span><br/>
		비밀번호 : <input onkeyup = "pwdCheck()" maxlength = "20" type = "password" class = "mpwd" name = "mpwd"> <br/>
		비밀번호 확인 : <input onkeyup = "pwdconfirmCheck()" maxlength = "20" type = "password" class = "mpwdconfirm" name = "mpwdconfirm"> <br/>
			<span class = "checkconfirm"></span><br/>
		이메일 :  <input onkeyup = "emailCheck()" type = "text" class = "memail" name = "memail"> <br/>
			<span class = "checkconfirm"></span><br/>
		프로필 : <input onchange = "premimg(this)" type = "file" class = "mimg" name = "mimg"><br/>
		<h5>미리보기</h5>  
			<img class = "premimg" src="/jspWeb/member/pimg/basic.jpg" width = "20%"> <br/>
		<button type = "button" onClick = "signup()"> 가입 </button>
	</form>
	
	
	<!-- 2. 사용자 정의 js -->
	<script src = "/jspWeb/js/member/signup.js" type = "text/javascript"></script>
	
	
</body>
</html>