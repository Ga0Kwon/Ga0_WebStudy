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
		<h3> 회원 정보 </h3>
		<div>
			<div>
				<img class= "mimg" alt="" src="">
			</div>
			<div>
				<div>아이디</div>
				<div class = "mid"></div>
			</div>
			<div>
				<div>이메일</div>
				<div class = "memail"></div>
			</div>
			<div>
				<div>보유포인트</div>
				<div class = "mpoint"></div>
			</div>
			
			<button type = "button">회원 수정 </button>
			<button type = "button">회원 탈퇴 </button>
		</div>
	</div>
	
	<!-- 사용자 정의 JS[info.js] -->
	<script src ="/jspWeb/js/member/info.js" type="text/javascript"></script>
</body>
</html>

<!-- 
	동일한 HTML에서 열리는 JS 파일은 메모리 공유
		* 단 먼저 호출된 JS 순
			-> AJAX는 조금 느림...
		* 주의 ajax
			1. $.ajax({}) : 비동기통신[요청보내고 응답을 기다리지 않음]
			
				요청 			응답
		   --------------------------	
				요청1 ====>
				|			요청1 처리
				|
				|
				요청2 ====>
				|			요청2 처리
				|
				|<====== 	요청 2응답
				|
				|
		    2. ajax({async : false}) : 동기 통신
		    
		    	요청 			응답
		    ----------------------------
		    	요청1 ======> 
		    				요청 1 처리
		    				|
		    				|
		    				|
		     	   <======  요청 1 응답
	     	    |
	     	    |
	     	   요청2 =======> 
	     	   				요청 2 처리
	     	   				|
	     	   				|
	     	   				|
	     	   |  <======== 요청 2 응답
	     	   	  
 -->