<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 모든 페이지 공통 CSS -->
<link href = "/jspWeb/css/list.css" rel = "stylesheet">
</head>
<body>
	<!-- jsp 태그; JSP 페이지 포함 --> 
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->
		
	<%
		//HTTP GET <a href ="URL경로?변수명=값"> 전달된 매개변수 가져오기
		String cno = request.getParameter("cno");
		//표현식을 이용한 input, div 등등에 대입
	%>
	<!-- cno을 숨겨서 js에게 전달 -->
	<%--  <%=cno%> 띄어쓰기 절대 금지! --%>
	<!-- type = "hidden"을 쓰면 칸도 안쓰고 레이아웃도 안먹음! 안보임 -->
	<input type = "hidden" type = "text" class = "cno" value="<%=cno%>">
	
	<!-- html/css -->
	<div class = "container">
		<div class = "boardbox">
			<div class = "boardtoptitle">	
				<h3 class = "cname"></h3>
				<p>다양한 사람들과 정보를 공유 해보세요</p>
			</div>
		
		<div class = "boardtopetc">
			<a href = "write.jsp">
				<button class = "bbtn" type = "button"><i class="fas fa-feather-alt"></i> 글쓰기</button>
			</a>
			<div>
				<span class = "searchCount">게시물 수 : </span>
				<button onClick = "setSearch()" class = "bbtn" type = "button">전체보기</button>
				<select onChange = "setListSize()" class ="bbtn listSize" onChange = "setListSize()" class = "listSize">
					<option>3</option>
					<option>5</option>
					<option>10</option>
				</select>
		
			</div>
		</div>
		<div>
			<div class = "boardTable">
				 <!-- 게시물 출력 -->
			</div>
		</div>
		</div>
	</div>
	
	
	<div class = "container">
		<div class = "container" style = "text-align : center;">
			<!-- 페이징 처리 버튼들 -->
			<div class = "pageBox">
			</div>
			
			<div class = "searchBox" style = "display : flex; justify-content: center">
				<select class ="bbtn key"> <!-- select 시 사용되는 조건의 필드명 -->
					<option value = "b.btitle">제목</option>
					<option value = "b.bcontent">내용</option>
					<option value = "m.mid">작성자</option>
				</select>
				<div>
					 <!-- select 시 사용되는 조건의 데이터 -->
					<input class = "keyword" type = "text" placeholder="검색">
					<button class = "bbtn" onClick = "getSearch()">검색</button>
				</div>
			</div>
		</div>
	</div>
	
	<script src = "/jspWeb/js/board/list.js" type="text/javascript"></script>
	
</body>
</html>