<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 모든 페이지 공통 CSS -->
<link href = "/jspWeb/css/list.css" rel = "stylesheet">
</head>
<body>
	<!-- jsp 태그; JSP 페이지 포함 --> 
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->

	<div class = "container">
		<h3>게시글 목록</h3>
		<a href = "write.jsp">글쓰기</a>
	</div>
	
	<script src = "/jspWeb/js/board/list.js" type="text/javascript"></script>
</body>
</html>