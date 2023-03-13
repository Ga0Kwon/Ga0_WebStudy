<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<body>
	<!-- jsp 태그; JSP 페이지 포함 --> 
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->
	
	<div class = "container">
		<h3> 회원 정보 수정 </h3>
		<form class = "updateForm">
			<div>
				<div>
					<img width = "20%" class= "mimg" alt="" src="">
					<br> 프로필 변경 <input onchange = "premimg(this)" type = "file" name = "newmimg" class = "newmimg">
					<br>기본 프로필 사용 여부 <input onclick = "onChecked()" class = "defaultimg" type = "checkbox">
				</div>
				
				<div>
					<div>아이디</div>
					<div class ="mid"></div>
				</div>
				
				<div>
					<div>현재 비밀번호</div>
					<input maxlength = "20" type = "password" class = "mpwd" name = "mpwd">
				</div>
				
				<div>
					<div>새 비밀번호</div>
					<input onkeyup = "pwdCheck()" maxlength = "20" type = "password" class = "newmpwd" name = "newmpwd">
				</div>
				
				<div>
					<div>새 비밀번호 확인</div>
					<input onkeyup = "pwdCheck()" maxlength = "20" type = "password" class = "newmpwdconfirm" name = "newmpwdconfirm">
				</div>
				
				<div class = "checkconfirm"></div>
				
				<div>
				<div>새 이메일</div>
					<input onkeyup = "emailCheck()" type = "text" class = "newmemail" name = "newmemail">
					<button class = "authBtn" type = "button"> 인증 </button>
				</div>
				
				<div class = "checkconfirm"></div>
				
				<button onClick = "setUpdate()" type = "button">회원수정</button>
			</div>
		</form>
	</div>	
	
	<!-- 사용자 정의 js -->
	<script src = "/jspWeb/js/member/update.js" type="text/javascript"></script>
</body>
</html>