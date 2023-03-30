<%@page import="controller.memberDto"%>
<%@page import="controller.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	th, td{
		text-align : center;
	}
</style>
<body>

	<%@include file = "header.jsp" %>
	<center>
		<h1>회원매출조회</h1>
	
		<table border = "1" style = "width : 50%">
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			
			<%
				Dao dao = new Dao();
			
				ArrayList<memberDto> membersumlist = dao.getSumlist();
				
				for(memberDto dto : membersumlist){
			
			%>
			<tr>
				<td name = "custno"><%=dto.getCustno()%></td>
				<td name = "custname"><%=dto.getCustname()%></td>
				<td name = "grade"><%=dto.getGrade()%></td>
				<td name = "totalprice"><%=dto.getSum()%></td>
			</tr>
			
			<%} %>
			
		</table>
	</center>
	<%@include file = "footer.jsp" %>
	
</body>
</html>