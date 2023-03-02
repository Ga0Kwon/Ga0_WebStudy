<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	jsp 웹 프로젝트 [ctrl + f11]
	
	<h3> 예제1 : [C : 쓰기]입력받은 데이터 -> Js -> 서블릿  -> Dao </h3>
		<!-- <input> : 입력 Tag class : 식별자 [id, class, name] -->
	data : <input type = "text" class = "inputData"> 
		<!-- <button> : 버튼 tag type = "button" onClick = "js작성"-->
	<button type = "button" onclick="예제()">예제1 실행</button>
	
	<!-- js 가져오기 [경로 : /프로젝트명/[webapp폴더 생략]/폴더/파일명 -->
	<script src = "js/index.js" type = "text/javascript"></script>
</body>
</html>