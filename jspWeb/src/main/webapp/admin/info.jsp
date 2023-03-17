<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%@include file = "../header.jsp" %> <!-- 상대 경로 --> --%>
	<%@include file = "/header.jsp" %> <!-- (webapp이하 생략)절대 경로 -->
	<h3> 모든 회원 명단 </h3>
	
	<button onClick = "clearSearch()" type = "button">전체보기[검색제거]</button>
	
	<select onChange = "setListSize()" class = "listSize">
			<option>3</option>
			<option>5</option>
			<option>10</option>
	</select>
		
	<div class = "memberList">
		<table class = "memberTable" border = "1">
			
		</table>
	</div>
	<div class = "container" style = "text-align : center;">
		<!-- 페이징 처리 버튼들 -->
		<div class = "adminpageBox">
		</div>
		
		<div class = "searchBox" style = "display : flex; justify-content: center">
			<select class ="key"> <!-- select 시 사용되는 조건의 필드명 -->
				<option value = "m.mno">회원번호</option>
				<option value = "m.mid">회원아이디</option>
				<option value = "m.memail">회원이메일</option>
			</select>
			<div>
				 <!-- select 시 사용되는 조건의 데이터 -->
				<input class = "keyword" type = "text" placeholder="검색">
				<button onClick = "getSearch()">검색</button>
			</div>
		</div>
	</div>
		
	<!-- 2. 사용자 정의 js -->
	<script src = "/jspWeb/js/admin/info.js" type = "text/javascript"></script>
	
</body>
</html>