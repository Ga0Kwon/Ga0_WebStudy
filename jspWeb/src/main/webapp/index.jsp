<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>jsp 웹 프로젝트 [ctrl + f11]</p>
	<p>강력 새로고침 [ctrl +f5]</p>
	
	<h3> 예제1 : [C : 쓰기]입력받은 데이터 -> Js -> 서블릿  -> Dao </h3>
		<!-- <input> : 입력 Tag class : 식별자 [id, class, name] -->
	data : <input type = "text" class = "inputData"> 
		<!-- <button> : 버튼 tag type = "button" onClick = "js작성"-->
	<button type = "button" onclick="예제()">예제1 실행</button>
	
	<h3>예제2 : [R : 읽기] DAO -> 서블릿[JAVA] -> JS -> HTML</h3>
	<div class = "ex2box">
		<!-- 서블릿에게 받은 데이터 표시되는 구역 -->
	</div>
	
	<!-- 
		[C]
		1. HTML에서 데이터 1개 입력받기 
		2. HTML에서 입력받은 데이터를 JS이동
		3. JS데이터를 서블릿으로 이동[AJAX]
		4. 서블릿 데이터를 DAO에게 전달 [SAVE]
		
		[R]
		1. DAO에서 모든 데이터를 호출
		2. DAO에서 출력한 데이터를 서블릿으로 반환
		3. DAO결과를 서블릿에서 JS로 이동[AJAX 사용]
		4. JS에서 HTML로 출력
		
	 -->
	
	<h3>과제3 : </h3>
	<h5>[C]</h5>
	
	DATA : <input type = "text" class = "inputData2">
	<button type = "button" onClick = "과제post()">과제3 실행</button>
	
	<h5>[R]</h5>
	<div class = "q1box">
	
	</div>
		
	<!-- 최신 jquery[js 라이브러리] 가져오기 -->
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- js 가져오기 [경로 : /프로젝트명/[webapp폴더 생략]/폴더/파일명 -->
	<script src = "js/index.js" type = "text/javascript"></script>
</body>
</html>