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
	<%	
		/*JAVA 코드가 들어가는 자리 => 이 기능을 JSP가 제공*/
		
		//http://localhost:8080/jspWeb/board/view.jsp?bno=1 
		// => 주소에서 bno를 빼와야함
		//1. JSP를 이용한 HTTP URL 변수 호출
		String bno = request.getParameter("bno");
	%>
	
<%-- 	<%=bno%> <!-- JAVA코드를 HTML에서 출력하는 코드 --> --%>
	<div class = "container">
		<h3>게시물 조회/보기</h3>
		<div>
			<div>게시물 번호</div>
			<div class = "bno"><%=bno%></div>
		</div>
		<div>
			<div>작성일| 조회수 | 좋아요 | 싫어요 </div>
			<div class = "infoBox"></div>
		</div>
		<div>
			<div>제목</div>
			<div class = "btitle"></div>
		</div>
		<div>
			<div>작성자[프로필]</div>
			<div class = "pimgBox"></div>
		</div>
		<div>
			<div>내용</div>
			<div class = "bcontent"></div>
		</div>
		<div>
			<div>첨부파일</div>
			<div class = "bfile"></div>
		</div>
		<div class = "btnBox">
		</div>
		<br/>
		<div>
			<textarea class = "rcontent" rows="" cols=""></textarea>
			<button onClick = "rWrite()" type = "button">댓글 작성</button>
		</div>
		<br/>
		<div class = "replayListBox">
			
		</div>
	</div>
	
	<script src = "/jspWeb/js/board/view.js"></script>
	
</body>
</html>