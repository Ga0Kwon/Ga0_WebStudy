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
	
	<div class = "container chattingwrap">
		<div class = "connectlist"> <!-- 접속 명단 표시 구역 -->
		</div>
		
		<div class = "chattingbox"> <!-- 채팅 구역 -->
			<div class = "contentbox"> <!-- 채팅창 -->
				
				
			</div>
			
			<div>
				<!-- 채팅입력창  -->
				<!-- form-control : 부트 스트랩 -->
				<textarea onkeyup = "enterKey()" class = "form-control msgbox" rows="" cols=""></textarea>
				
				<div class = "sendContentBtn">
					<!-- 
						bs : 드롭다운
							클릭위치 : data-bs-toggle="dropdown"
							드롭다운시 표시할 위치 : class = "dropdown-menu"
								
					 -->
					<!-- 드롭다운 버튼 -->
					<button onClick = "getEmo()" class = "emobtn" type = "button" data-bs-toggle = "dropdown">
						<i class="fas fa-laugh-squint"></i>
					</button>
					
					<!-- 드롭다운 버튼 클릭시 보이는 구역 -->
					<div class = "dropdown-menu enolist">
						
					</div>
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