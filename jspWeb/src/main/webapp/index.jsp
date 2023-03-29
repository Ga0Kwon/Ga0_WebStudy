<%@page import="model.dto.MemberDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%">	<!-- 가로/세로 사이즈 생략시 auto( 내용물크기만큼 ) -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
</head>
<body style="height: 100%">
	<%@ include file = "/header.jsp" %>	<!-- JSP 페이지 포함 -->
	
	<!-- 모달창 -->
	<div class = "searchbox">
		검색창
	</div>
	
	<div style="display: flex; width: 100%; height: 80%">
		<!-- 지도 -->
		<div class = "contentbox" id="map"></div>
		<!-- 사이드바 -->		
		
		<div class="produclistbox">
			
		</div>
	
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=064ef969f91610e805d9aeeb1a4ccb95&libraries=clusterer"></script>
	<script src="/jspWeb/js/index.js" type="text/javascript"></script>

</body>
</html>


<!-- 


	<div class = "productbox">
		<div class = "pimgbox">
			<img alt="" src="/jspWeb/member/pimg/basic.jpg">
		</div>
		<div class = "pcontentbox">
			<div class = "pdate">2023-03-28</div>
			<div class ="pname" >LG 노트북 팝니다.</div>
			<div class = "pprice">300000원</div>
			<div class = "petc">
				<span><i class="far fa-eye"></i><span class = "bview">30</span></span>
				<span><i class="far fa-thumbs-up"></i><span class = "blike">5</span></span>
				<span><i class="far fa-comment-dots"></i><span class = "rcount">3</span></span>
			</div>
		</div>
	</div>


 -->
 
 
 
 <!-- 
 
 	<div class = "pviewbox">
					<div class ="pviewinfo">
						<div class = "mimgbox">
							<img class = "mimg hpimg" src="/jspWeb/member/pimg/basic.jpg">
							<span class = "mid">qwe123</span>
						</div>
					
						<div class = "">
							<button class = "pbadge" type = "button">목록보기</button>
						</div>
					</div>
			
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
					  <div class="carousel-inner">
						    <div class="carousel-item active">
						      <img src="/jspWeb/product/pimg/boss.jpg" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="/jspWeb/product/pimg/boss.jpg" class="d-block w-100" alt="...">
						    </div>
						    <div class="carousel-item">
						      <img src="/jspWeb/product/pimg/boss.jpg" class="d-block w-100" alt="...">
						    </div>
					</div>
					  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
					  </button>
					  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
					  </button>
				</div>
				
				<div class = "pdate">2023-03-28</div>
				<div class = "pname">제목</div>
				<div class = "pcomment">내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물내용물</div>
				<div class = "pstate"><span class = "pbadge">판매중</span></div>
				<div class = "pprice">3000원</div>
				<div class = "petc">
					<span><i class="far fa-eye"></i><span class = "bview">30</span></span>
					<span><i class="far fa-thumbs-up"></i><span class = "blike">5</span></span>
					<span><i class="far fa-comment-dots"></i><span class = "rcount">3</span></span>
				</div>
				<div class = "pviewbtnbox">
					<button type = "button"><i class="far fa-heart"></i></button>
					<button type = "button">채팅</button>
				</div>
			</div>	
 
 
  -->
  
  
  
  <!-- 
  
  
  	<div class = "chatbox">
		<div class ="pviewinfo">
			<div class = "mimgbox">
				<img class = "mimg hpimg" src="/jspWeb/product/pimg/boss.jpg">
				<span class = "pname">boss QC45 헤드셋</span>
			</div>
			<div>
				<button class = "pbadge" type = "button">목록보기</button>
			</div>
		</div>
		<div class = "chatcontent">
			<div class = "sendbox">구매가능할까요?</div>
			<div class = "receviebox">네 구매 가능합니다.</div>
		</div>
		<div class = "chatbtn">
			<textarea rows="" cols=""></textarea>
			<button class = "bbtn" type = "button">전송</button>
		</div>
	</div>
  
  
   -->
 <!-- 
   해당 제품으로부터 체팅을 받은 목록 
	<div class = "chatlist">
		<div class = "frommimg">
			<img alt="" src="/jspWeb/member/pimg/basic.jpg" class ="hpimg">
		</div>
		<div class = "frominfo">
			<div class = "fromndate">2023-03-29 10:01</div>
			<div class = "frommid">qwe123</div>
			<div class = "fromncontent">구매할 수 있을 까요?</div>
		</div>
	</div> 
-->