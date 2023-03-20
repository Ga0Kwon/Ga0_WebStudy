<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href = "/jspWeb/css/view.css" rel = "stylesheet">
</head>
<body>
	<!-- jsp 태그; JSP 페이지 포함 --> 
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->
	<%	
		/*JAVA 코드가 들어가는 자리 => 이 기능을 JSP가 제공*/
		
		//http://localhost:8080/jspWeb/board/view.jsp?bno=1 
		// => 주소에서 bno를 빼와야함
		//1. JSP를 이용한 HTTP URL 변수 호출
		String bno = request.getParameter("bno");
	%>
	<input type = "hidden" type = "text" class = "bno" value="<%=bno%>">
	<div class = "container">
		<div class = "boardbox">
			<div class = "viewtop">
				<div>
					<img class = "hpimg mimg" src = "/jspWeb/member/pimg/basic.jpg">
				</div>
				<div class = "viewtopright">
					<div class = "mid"></div>
					<div>
						<span class = "bwritedate">2023-03-20</span>
						<span><i class="far fa-eye"></i><span class = "bview"></span></span>
						<span onClick = "bIncrease(2)"><i class="far fa-thumbs-up"></i><span class = "blike"></span></span>
						<span onClick = "bIncrease(3)"><i class="far fa-thumbs-down"></i><span class = "bhate"></span></span>
					</div>
				</div>
				</div>
				<div class = "btitle"></div>
				<div class = "bcontent"></div>
				<div class = "bfile"></div>
				<div class ="btnBox"></div>
				<div class = "replycount"></div>
				<div class = "replyWritebox">
					<textarea  class = "rcontent" rows="" cols=""></textarea>
					<button class = "bbtn replyBtn" onClick = "rWrite()" type = "button">댓글 작성</button>
				</div>
				<div class = "replayListBox">댓글출력</div>
		</div>
	</div>
	
	<script src = "/jspWeb/js/board/view.js"></script>
	
</body>
</html>