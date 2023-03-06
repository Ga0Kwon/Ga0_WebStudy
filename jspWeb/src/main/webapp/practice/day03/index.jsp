<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> 예제 1 : HTTP 메소드 </h3>
	<button onClick = "doPost()" type = "button"> POST 메소드 </button>
	<button onClick = "doGet()" type = "button"> GET 메소드 </button>
	<button onClick = "doPut()" type = "button"> PUT 메소드 </button>
	<button onClick = "doDelete()" type = "button"> DELETE 메소드 </button>
	
	<h3> 예제 2 : 비회원 방문록 </h3>
	내용 : <input type = "text" class = "content">
	작성자 : <input type = "text" class = "writer">
	<button onClick = "onWrite()" type = "button"> 방문록 등록 </button>
	
	<h4> 방문록 목록 </h4>
	<div class = "boardList"></div>



	<!-- 1. JQUERY (ajax 사용하기 위해) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자 정의 js -->
	<script src = "index.js" type = "text/javascript"></script>
</body>
</html>