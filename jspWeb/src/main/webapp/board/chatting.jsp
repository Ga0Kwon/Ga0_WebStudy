<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->
	

		
	<div class = "container">
		<!-- 채팅 내용물이 표시되는 구역 -->
		<div class = "cbox">
			
		</div>
		<div>
			<!-- 채팅입력창  -->
			<textarea class = "msgbox" rows="" cols=""></textarea>
			<!-- 채팅 전송 버튼 -->
			<button onClick = "msgSend()" type = "button">전송</button>
		</div>
		
		
	</div>
		
	<script src = "/jspWeb/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>