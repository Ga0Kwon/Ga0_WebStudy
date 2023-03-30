<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="controller.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.nameTitle{
		text-align : center;
		width: 40%;
	}
	.realinfo{
		width: 60%;
	}
</style>

<body>

	<%@include file = "header.jsp" %>
	<%
		//JSP 이용한 서블릿 대체
		
		//1. 마지막번호 +1 호출
		Dao dao = new Dao();
		int lastcustno = dao.getcustno();
		
		//2. 오늘 날짜
		Date date = new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String now = format.format(date);
		
	%>
	<center>
		<h1>홈쇼핑 회원 등록</h1>
		<form name = "joinform" action = "/HRD_exam1/join" method = "post"> <!-- 전송을 위해 form -->
			<table border = "1" style = "width : 55%">
				<tr>
					<td class = "nameTitle">회원번호(자동발생)</td>
					<td class = "realinfo"><input value = "<%=lastcustno%>" name = "custno" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">회원성명</td>
					<td class = "realinfo"><input name = "custname" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">회원전화</td>
					<td class = "realinfo"><input name = "phone" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">회원주소</td>
					<td class = "realinfo"><input name = "address" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">가입일자</td>
					<td class = "realinfo"><input value = "<%=now%>" name = "joindate" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">고객등급(A:VIP, B: 일반, C:직원)</td>
					<td class = "realinfo"><input name = "grade" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">도시코드</td>
					<td class = "realinfo"><input name = "city" type = "text"></td>
				</tr>
				<tr>
					<td colspan="2"> <!-- 병합 -->
						<center>
							<button onclick = "join()" type = "button">등록</button>
							<a href = "view.jsp"><button type = "button">조회</button></a>
						</center>
					</td>
				</tr>
				
			</table>
		
		</form>
	</center>
	<%@include file = "footer.jsp" %>
	
	<script src = "join.js" type="text/javascript"></script>
</body>
</html>