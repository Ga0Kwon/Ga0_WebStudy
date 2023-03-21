<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- 부트 스트랩 반응형 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 부트 스트랩 CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
	 
	<!-- 모든 페이지 공통 CSS -->
	<link href = "/jspWeb/css/index.css" rel = "stylesheet">
	<!-- 폰트어썸 -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
	
	<!-- 모달 CSS -->
	<link href = "/jspWeb/css/modal.css" rel = "stylesheet">
</head>
<body>
	<div class = "container"><!-- bs 박스권 -->
		<div class = header>
			<!-- 로고 -->
			<div class = "mainLogo">
				<a href = "/jspWeb/index.jsp">
					<img src = "/jspWeb/img/logo.png">
				</a>
			</div>
			<!-- 본메뉴 -->
			<ul class = "mainmenu">
				<li> <a href = "/jspWeb/board/list.jsp?cno=1">공지사항</a> </li>
				<li> <a href = "/jspWeb/board/list.jsp?cno=2">커뮤니티</a> </li>
				<li> <a href = "/jspWeb/board/list.jsp?cno=3">QnA</a> </li>
				<li> <a href = "/jspWeb/board/list.jsp?cno=4">노하우</a> </li>
				<li> <a href = "/jspWeb/js/api/api.jsp">Api1</a> </li>
				<li> <a href = "/jspWeb/js/api/api2.jsp">Api2</a> </li>
				<li> <a href = "/jspWeb/practice/api과제/api3.jsp">Api3[과제]</a> </li>
				<li> <a href = "#">기능메뉴5</a> </li>
			</ul>
			<!-- 서브 메뉴 -->
			<div class = "submenu">
				<!-- bs : 드롭다운 [JS가 들어감] -->
			</div>
		</div>
		
	</div>
	
	
	
	<!-- 모든 페이지 공톤 JS -->
	<!-- 1. JQUERY (ajax 사용하기 위해) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 부트 스트랩 JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	  
	<!-- 사용자 정의 JS -->
	<script src = "/jspWeb/js/header.js" type="text/javascript"></script>

	<!-- 사용자 정의 modal js -->
	<script src = "/jspWeb/js/modal.js"></script>
</body>
</html>






<!-- 모든 페이지 공통 메뉴 -->
	<%-- <% String login = (String)request.getSession().getAttribute("login"); %>
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
			<a href = "/jspWeb/member/logout.jsp">로그아웃</a>
	<%
		}else{
		
	%>
			<a href = "/jspWeb/index.jsp">메인페이지</a>
			<a href = "/jspWeb/member/logout.jsp">로그아웃</a>
	<%
		}
	%> --%>