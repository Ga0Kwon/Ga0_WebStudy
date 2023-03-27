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
	
	<div class = "container">
		<form class = "writeform" name = "pname">
			제품명 : <input type = "text" name = "pname"><br/>
			제품 설명 : <input type = "text" name = "pcomment"><br/>
			제품 가격 : <input type = "text" name = "pprice"><br/>
	   		거래 위치 : 
			<div id="map" style="width:100%;height:350px;"></div>
			
			<!-- 첨부파일 1개 -->
			<!-- <div>첨부파일 1개</div>
			<input type = "file" name = "pfile" accept = "image/*"> image/* : 이미지 파일만 가능 audio넣으면 audio만 -->
			
			<!-- 첨부파일 여러개 -->
			<!-- <div>첨부파일 여러개 []pfile 여러개]</div>
			<input type = "file" name = "pfile1" accept = "image/*"> image/* : 이미지 파일만 가능 audio넣으면 audio만
			<input type = "file" name = "pfile2" accept = "image/*"> image/* : 이미지 파일만 가능 audio넣으면 audio만
			<input type = "file" name = "pfile3" accept = "image/*"> image/* : 이미지 파일만 가능 audio넣으면 audio만 -->
			
			<!-- 첨부파일 여러개 -->
			<div>첨부파일 여러개 [multiple : cos 불가능 / commons 가능]</div>
			<input type = "file" name = "pfiles" multiple="multiple" accept = "image/*"> <!-- 멀티플의 경우 여러개 한꺼번에 선택 가능 -->
			<br/>
			<button onClick = "onwrite()" type = "button">제품 등록</button>
		</form>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=064ef969f91610e805d9aeeb1a4ccb95"></script>
	<script src = "/jspWeb/js/product/write.js" type="text/javascript"></script>
</body>
</html>