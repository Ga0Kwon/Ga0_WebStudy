<%@page import="controller.Dao"%>
<%@page import="controller.memberDto"%>
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
	<form> 
		<center>
			<h1>회원목록조회/수정</h1>
		
			<table border = "1">
				<tr>
					<th style = "width : 9%">회원번호</th>
					<th style = "width : 9%">회원성명</th>
					<th style = "width : 13%">전화번호</th>
					<th style = "width : 30%">주소</th>
					<th style = "width : 13%">가입일자</th>
					<th style = "width : 13%">고객등급</th>
					<th style = "width : 13%">거주지역</th>
				</tr>
				
				<%
					//반복문 돌리기
					Dao dao = new Dao();
					ArrayList<memberDto> memberlist = dao.getmemberList();
					
					for(memberDto dto : memberlist){
						
					
					
				%>
				<tr>
					<!-- a href = "URL ? 변수명=데이터&변수명데이터-->
					<td name = "custono" ><a href ="update.jsp?custno=<%=dto.getCustno()%>"><%=dto.getCustno()%></a></td>
					<td name = "custname"><%=dto.getCustname()%></td>
					<td name = "phone"><%=dto.getPhone()%></td>
					<td name = "address"><%=dto.getAddress()%></td>
					<td name = "joindate"><%=dto.getJoindate()%></td>
					<td name = "grade"><%=dto.getGrade()%></td>
					<td name = "city"><%=dto.getCity()%></td>
				</tr>
				
				<%} %> <!-- 여기서 반복문을 닫야한다. -->
			</table>
		</center>
	</form>
	<%@include file = "footer.jsp" %>
	
</body>
</html>