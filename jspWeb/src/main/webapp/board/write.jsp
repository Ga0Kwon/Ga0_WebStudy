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
	
	<!-- 방법1[로그인 여부 확인]-->
	<script>
		// JSP[HTML] 이 실행되고 JS가 실행되기 때문에 잠깐 반짝하고 보이는 경우가 있다.
		// 즉, 이렇게 < script >태그를 통해 미리 JSP[HTML]에 넣어주면 덜하다.
		
		if(memberInfo.mid == null){
			alert('회원제 기능입니다. 로그인 후 작성해주세요.');
			location.href = "/jspWeb/member/login.jsp";
		}
	</script> 
	
	<!-- 방법 2[로그인 여부 확인]-->
<%-- 	<%
		//JSP 로그인 여부 제어
		Object o = request.getSession().getAttribute("login");
		if(o == null){
			response.sendRedirect("/jspWeb/member/login.jsp");
		}
	%> --%>
	
	<div class = "container">
		<h3>글쓰기</h3>
		<form class = "writeForm">
			카테고리 :
			<select name = "cno" class = "cno">
				<option value = "1">공지사항</option>
				<option value = "2">커뮤니티</option>
				<option value = "3">QnA</option>
				<option value = "4">노하우</option>
			</select>
			제목 :
			<input name = "btitle" type = "text">
			내용 :
			<textarea name = "bcontent" rows="3" cols="3"></textarea>
			첨부파일 :
			<input name = "bfile" type = "file">
			<button onClick = "bWrite()" type = "button">쓰기</button>
		</form>
		
		<!-- 
			HTML =====> form[동기식 : 페이지전환이 있음]
			<form action = "통신할 URL" method = "HTTP 메소드">
				<form 태그 안>
				1. enctype="application/x-www-form-urlencoded" : 기본 폼 전송 방식
				2. enctype="multipart/form-data" 
			- 주의 form 태그 안에있는 <button> type을 생략시 type = "submit" (폼 보내기)
				=> 생략시 전송이 두번 감 submit자체가 누르면 바로 form으로 들어가기 때문에
				=> 즉, 함수처리[헤서 폼전송] + 폼전송 ; 두번 전송됨.
			- form 태그 안에있는 <button type = "button"> 필수 [JS사용시!]
			vs. JS =====> AJAX [비동기식, 동기식]
 
		 -->
	</div>
	
	<script src = "/jspWeb/js/board/write.js" type="text/javascript"></script>
</body>
</html>