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
		//JSP 로그인 여부 제어
		Object o = request.getSession().getAttribute("login");
		if(o == null){
			response.sendRedirect("/jspWeb/member/login.jsp");
		}
		String bno = request.getParameter("bno");
	%>
	
	<%-- <%=bno%> <!-- JAVA코드를 HTML에서 출력하는 코드 --> --%>
	<input type = "hidden" type = "text" class = bno value="<%=bno%>">
	
	<div class = "container">
		<h3>글수정</h3>
		<form class = "updateForm">
		<!-- 방법1 -->
<%-- 		<input type = "hidden" type = "text" class = bno value="<%=bno%>"> --%>
			<div>
				카테고리 :
				<select name = "cno" class = "cno" >
					<option value = "1">공지사항</option>
					<option value = "2">커뮤니티</option>
					<option value = "3">QnA</option>
					<option value = "4">노하우</option>
				</select>
			</div>
			<div>
				제목 :
				<input name = "btitle" class = "btitle" type = "text">
			</div>
			<div>
				내용 :
				<textarea name = "bcontent" class = "bcontent" rows="7" cols="30"></textarea>
			</div>
			<div class = "bfileBox">

			</div>
			<button onClick = "bUpdate()" type = "button">수정</button>
		</form>
	</div>
	
	<script src = "/jspWeb/js/board/update.js" type="text/javascript"></script>
</body>
</html>