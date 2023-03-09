<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%@include file = "../header.jsp" %> <!-- 상대 경로 --> --%>
	<%@include file = "/header.jsp" %> <!-- (webapp이하 생략)절대 경로 -->
	<h3> 모든 회원 명단 </h3>
	<div class = "memberList">
		<table class = "memberTable" border = "1">
			
		</table>
	</div>
	
	<!-- 2. 사용자 정의 js -->
	<script src = "/jspWeb/js/admin/info.js" type = "text/javascript"></script>
	
</body>
</html>