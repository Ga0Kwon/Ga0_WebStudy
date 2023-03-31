<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<div class = "container">
		
		<button type = "button" onclick = "setPay(10000)">10000원</button>
		<button type = "button" onclick = "setPay(50000)">50000원</button>
			
	
		<button type = "button" onclick = "requestPay()">결제처리</button>
	</div>
	
	<!-- 포트원 본인인증 API -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.4.js"></script>

	<!-- 포트원 결제 API -->
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	
	<!-- 사용자 정의 JS -->
	<script src = "/jspWeb/js/member/point.js" type="text/javascript"></script>
	
</body>
</html>