<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<%@include file = "/header.jsp" %> <!-- 절대 경로 -->
	<h3>로그인 페이지.</h3>
	아이디 : <input maxlength = "30" type = "text" class = "mid" name = "mid"> <br/>
	비밀번호 : <input maxlength = "20" type = "password" class = "mpwd" name = "mpwd"> <br/>
	<button type = "button" onClick = "login()">로그인</button>
	
	<!-- 사용자 정의 js -->
	<script src = "/jspWeb/js/member/login.js" type="text/javascript"></script>
</body>
</html>