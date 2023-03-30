<%@page import="controller.memberDto"%>
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
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		Dao dao = new Dao();
		
		memberDto dto  = dao.getMember(custno);
	%>
	<center>
		<h1>홈쇼핑 회원 수정</h1>
	
		<form name = "updateform" action="/HRD_exam1/join" method = "get" > <!-- 전송을 위해 form -->
			<table border = "1" style = "width : 55%">
				<tr>
					<td class = "nameTitle">회원번호</td>
					<td class = "realinfo"><input value="<%=dto.getCustno()%>" name = "custno" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">회원성명</td>
					<td class = "realinfo"><input value="<%=dto.getCustname()%>" name = "custname" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">회원전화</td>
					<td class = "realinfo"><input value="<%=dto.getPhone()%>" name = "phone" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">회원주소</td>
					<td class = "realinfo"><input value="<%=dto.getAddress()%>" name = "address" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">가입일자</td>
					<td class = "realinfo"><input value="<%=dto.getJoindate()%>" name = "joindate" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">고객등급(A:VIP, B: 일반, C:직원)</td>
					<td class = "realinfo"><input value="<%=dto.getGrade()%>" name = "grade" type = "text"></td>
				</tr>
				<tr>
					<td class = "nameTitle">도시코드</td>
					<td class = "realinfo"><input value="<%=dto.getCity()%>" name = "city" type = "text"></td>
				</tr>
				<tr>
					<td colspan="2"> <!-- 병합 -->
						<center>
							<button onclick = "update()"type = "button">수정</button>
								<a href = "view.jsp"><button type = "button">조회</button></a>
						</center>
					</td>
				</tr>
				
			</table>
		</form>
	</center>
	<script src = "update.js" type="text/javascript">
		
	</script>
	<%@include file = "footer.jsp" %>
	
</body>
</html>