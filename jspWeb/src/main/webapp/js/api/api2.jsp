<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kakao 지도 시작하기</title>

</head>
<body>
	<!-- jsp 태그; JSP 페이지 포함 --> 
	<%@ include file = "/header.jsp" %> <!-- 헤더 포함 -->
	

		
	<div class = "container">
		<!-- 모달 HTML -->
		<div class="modal_wrap">
			<div class="modal_box">
				<h3 class="modal_title">
					<!-- 제목이 들어가는 자리  -->
				</h3>
				<div class="modal_content">
					<!-- 내용이 들어가는 자리  -->
				</div>
				<div class="modal_btns">
					<button class="modal_check" 	type="button">확인</button>
					<button onclick="closeModal()" class="modal_cencel" type="button">닫기</button>
				</div>
			</div>
		</div>	
		<p><em>지도를 클릭해주세요!</em></p> 
		<div id="clickLatlng"></div>
		<!-- 카카오 지도가 표시되는 구역 -->
		<div id="map" style="width:100%;height:600px;"></div>
	</div>
	
	
	
	<!-- 카카오 지도에 필요한 클래스/메소드 가지고 있는 js라이브러리 -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=064ef969f91610e805d9aeeb1a4ccb95&libraries=clusterer"></script>
	
	<!-- 사용자 정의 js[사용자 정의는 마지막!] -->
	<script src = "/jspWeb/js/api/api2.js" type="text/javascript"></script>

</body>
</html>