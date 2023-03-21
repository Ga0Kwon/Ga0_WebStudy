/*-------------------------- 지도 옵션 설정 --------------------------*/

var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스

var options = { //지도를 생성할 때 필요한 기본 옵션
	center: new kakao.maps.LatLng(37.32129610877492,126.80742541843482), //지도의 중심좌표.
	level: 4 //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

/* ----------------------- 마커 디자인 변경 -----------------------*/

var imageSrc = '/jspWeb/img/pillpin.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)

/* ----------------------- 클러스터 생성 ----------------------- */


var clusterer = new kakao.maps.MarkerClusterer({
	map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 8 // 클러스터 할 최소 지도 레벨 
});

$.ajax({
	url : "https://api.odcloud.kr/api/3035882/v1/uddi:5fae3cf5-bc15-4eba-87d8-8289b74e659b_201912202015?page=1&perPage=292&returnType=json&serviceKey=yGK0ktRbG%2BTL3dCkYWNRIAi0bHut%2FYjDdi8lXd9MeZnPxhXf8rkoOMfgZJQfrB0f%2B%2BGERokC79iVDaO%2BexWAlw%3D%3D",
	method : "get",
	async : false,
	success : (r) => {
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		r.data.forEach( (o) =>{
		
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch( o.주소, function(result, status) {
					
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
				    
				    	// 결과값으로 받은 위치를 마커로 표시합니다
				        let marker =  new kakao.maps.Marker({
				            position : new kakao.maps.LatLng(result[0].y, result[0].x),
				            image : markerImage
				        });
				        
				        kakao.maps.event.addListener(marker, 'click', function() {
					     	//모달에 정보 담기
					     	document.querySelector('.modal_title').innerHTML = o.약국명;
					     	document.querySelector('.modal_content').innerHTML = o.대표전화 + "로 문의주세요";
					     	//모달 띄우기
					     	openModal();
						});
				        
				        clusterer.addMarker(marker);
				    } 
				});
		})

	}
})



