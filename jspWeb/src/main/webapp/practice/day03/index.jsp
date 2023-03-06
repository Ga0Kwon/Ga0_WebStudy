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
	
	<!-- 
		과제 
		JSP, JS, dao 기존 파일 사용
		dao , dto, servlet 새로 파일 만들기
		
			1. 제품 등록 [제품명, 가격]
			2. 제품 출력 [테이블에 모두 출력]
			3. 제품 삭제 [제품번호를 이용한 삭제]
			4. 제품 수정 [제품 번호를 이용한 제품명, 가격 수정 => prompt 수정할 데이터 입력 받기]
	-->
	
	<h3> 과제 : </h3>
	제품명 : <input type = "text" class = "productName">
	가격 : <input type = "number" class = "productPrice">
	<button onClick = "insertProduct()" type = "button"> 제품 등록 </button>
	
	<h4> 제품 목록 </h4>
	<div class = "productList"></div>

	<!-- 1. JQUERY (ajax 사용하기 위해) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자 정의 js -->
	<script src = "index.js" type = "text/javascript"></script>
</body>
</html>