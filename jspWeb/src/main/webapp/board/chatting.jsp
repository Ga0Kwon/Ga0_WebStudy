<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "/jspWeb/css/chatting.css" rel = "stylesheet">

</head>
<body>
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->
	
	<div class = "container">
	
		<div class = "chattingbox"> <!-- 채팅 구역 -->
			<div class = "contentbox"> <!-- 채팅창 -->
				
				
			</div>
			<div>
				<!-- 채팅입력창  -->
				<!-- form-control : 부트 스트랩 -->
				<textarea onkeyup = "enterKey()" class = "form-control msgbox" rows="" cols=""></textarea>
				
				<div class = "sendContentBtn">
					<div></div> <!-- 이모티콘 -->
					<div></div> <!-- 첨부파일 -->
					<!-- 채팅 전송 버튼 -->
					<button class = "sendbtn" onClick = "msgSend()" type = "button">보내기</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 
	

				<div class = "sendcontent">
					<div class = "date">오전 10:07</div>
					<div class = "content">안녕하세요.</div>
				</div>
				

				<div class = "alerm">
					<div>강호동님이 입장 하셨습니다.</div>
				</div>
					

				<div class = "tocontent">
					<div><img class = "hpimg" src = "/jspWeb/member/pimg/basic.jpg"></div>
					<div class = "rcontent">
						<div class = "name">강호동</div>
						<div class = "contentdate">
							<div class = "content">메시지</div>
							<div class = "date">오전 10:18</div>
						</div>
					</div>
				</div>
	
	 -->

	<script src = "/jspWeb/js/board/chatting.js" type="text/javascript"></script>
</body>
</html>