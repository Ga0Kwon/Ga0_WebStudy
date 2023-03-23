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
			제품명 : <input type = "text" name = "pname">
			제품 설명 : <input type = "text" name = "pcomment">
			제품 가격 : <input type = "text" name = "pprice">
	   		거래 위치 : 
			<div id="map" style="width:100%;height:350px;"></div>
			<button onClick = "onwrite()" type = "button">제품 등록</button>

		</form>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=064ef969f91610e805d9aeeb1a4ccb95"></script>
	<script src = "/jspWeb/js/product/write.js" type="text/javascript"></script>
</body>
</html>