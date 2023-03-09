<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 헤더 -->
	<%@include file = "/header.jsp" %> <!-- 절대 경로 -->
	<% 
		// 모든 세션 지우기[초기화]
			// request.getSession().invalidate();
	
		//특정 세션 지우기 [동일한 이름으로 null 대입 -> GC가 삭제해줌]
		request.getSession().setAttribute("login", null);
	%>
	
	<script type="text/javascript">
		location.href = "/jspWeb/index.jsp";
	</script>
</body>
</html>