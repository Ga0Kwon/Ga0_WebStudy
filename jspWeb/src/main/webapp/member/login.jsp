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
	<link href = "/jspWeb/css/signup.css" rel = "stylesheet">

</head>
<body>
	<!-- 헤더 -->
	<%@include file = "/header.jsp" %> <!-- 절대 경로 -->
	
	<div class = "container"> <!-- bs : 박스권 -->
		<form class = "signupForm"> <!-- 폼 전송시 자식 input의 매개변수 식별 : name -->
			<h3> KGY Comunity </h3>
			<p>환영합니다. 다양한 커뮤니티 플랫폼을 제공합니다.</p>
			
			<div class = "title">아이디</div>
			<input maxlength = "30" type = "text" class = "mid" name = "mid"> 
			
			<div class = "title">비밀번호</div>
			<input maxlength = "20" type = "password" class = "mpwd" name = "mpwd">
			<div class = "checkconfirm"></div>
			
			<div class = "subBtnBox">
				<a href = "/jspWeb/member/findid.jsp">아이디 찾기</a>
				<a href = "/jspWeb/member/findpwd.jsp">비밀번호 찾기</a>
			</div>
			
			<button class = "signupBtn" type = "button" onClick = "login()"> 로그인 </button>
			
		</form>
	</div>
	
	<!-- 사용자 정의 js -->
	<script src = "/jspWeb/js/member/login.js" type="text/javascript"></script>
</body>
</html>