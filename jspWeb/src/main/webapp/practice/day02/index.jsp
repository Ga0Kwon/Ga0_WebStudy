<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DAY02 JSP</title>
</head>
<body>
	<h2>과제 : 학생 등록 시스템</h2>
	
	<h3>[C- 학생 정보 등록]</h3>
	<p>이름[문자열] :   <input type = "text" class = "name"></p><br/>
	<p>전화번호[문자열] : <input type = "text" class = "phoneNumber"></p><br/>
	<p>키[실수] :  <input type = "text" class = "height"></p><br/>
	<p>나이[정수] :  <input type = "number" class = "age"></p><br/>
	<p>등록일[날짜] :   <input type = "date" class = "signDate"></p><br/>
	<p>성별[남/여] :  <input type = "radio" name = "sex" value = "M"> 남
						 <input type = "radio" name = "sex" value = "F"> 여 </p><br/>
	<p>개인정보동의[false/true] : <input type = "checkbox" class = "agree"> 동의 </p><br/>
	<p>사는 지역[선택] :   <select class = "location">
									<option>안산</option><option>안양</option><option>수원</option>
							</select></p><br/><br/>
	<p>자기 소개 : <textarea class = "introduce" rows="2" cols="50"></textarea></p><br/>

	<button type = "button" onclick="signup()">등록</button>
	
	
	<h3>[R- 학생 등록 테이블]</h3>
	<div class = "studentInfo"></div>
	<h3>예1) [C] HTML -document.querySelector-> JS -AJAX-> servlet -메소드-> dao</h3>
	DATA1[문자열] : <input type = "text" class = "data1"><br/>
	
	DATA2[패스워드] : <input type = "password" class = data2><br/>
	
	DATA3[실수] : <input type = "text" class = "data3"><br/>
	
	DATA4[정수] : <input type = "number" class = "data4"><br/>
	
	DATA5[날짜] : <input type = "date" class = "data5"><br/>
	
	DATA6[날짜/시간] : <input type = "datetime-local" class = "data6"><br/>
	
	<!-- 라디오는 name이 같아야 복수 선택을 막을 수 있다. -->
	DATA7[선택 상자] : <input type = "radio" name = "data7" value = "남"> 남
					<input type = "radio" name = "data7" value = "여"> 여 <br/>
					
	DATA8[체크 상자] : <input type = "checkbox" class = "data8"> 승인<br/>
	
	DATA9[목록 상자] : <select class = "data9">
						<option>안산</option><option>수원</option><option>성남</option>
					</select><br/><br/>
					
	DATA10[긴글 상자] : <textarea class = "data10" rows="2" cols="40"></textarea><br/>
	
	<button type = "button" onclick="ex1()">전송</button>
	
	<h3>예1) [R] DAO -메소드-> servlet -AJAX-> js -document.querySelector-> HTML</h3>
	<h4>[DTO X]</h4> <div class = "ex2Box"></div><br/><br/>
	<h4>[DTO O]</h4> <div class = "ex2_1Box"></div>
	
	<!-- 1. JQUERY (ajax 사용하기 위해) -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	
	<!-- 2. 사용자 정의 js -->
	<script src = "index.js" type = "text/javascript"></script>
</body>
</html>