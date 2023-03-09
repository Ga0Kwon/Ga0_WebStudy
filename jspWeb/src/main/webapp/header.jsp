<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<!-- 모든 페이지 공통 CSS -->
</head>
<body>
	<h3>헤더입니다.</h3>
	<!-- 모든 페이지 공통 메뉴 -->
	<% String login = (String)request.getSession().getAttribute("login"); %>
	<%=login %>님 안녕하세요.<br/>
	<!-- 모든 페이지 공통 메뉴[사용자마다 나누기] -->
	<%
		//자바 구역
		if(login == null){ //로그인 안했다.
	%>
			<!-- HTML 구역... -->
			<a href = "/jspWeb/member/signup.jsp">회원가입</a>
			<a href = "/jspWeb/member/login.jsp">로그인</a>
	<%
		//자바 구역
		}else if(login.equals("admin")){
	%>
			<a href = "/jspWeb/admin/info.jsp">관리자페이지</a>
	<%
		}else{
		
	%>
			<a href = "/jspWeb/index.jsp">메인페이지</a>
			<a href = "/jspWeb/member/logout.jsp">로그아웃</a>
	<%
		}
	%>
	
	
	<!-- 모든 페이지 공톤 JS -->
	<!-- 1. JQUERY (ajax 사용하기 위해) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
</body>
</html>