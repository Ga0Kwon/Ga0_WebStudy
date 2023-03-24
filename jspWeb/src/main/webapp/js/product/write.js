console.log('제품 등록?!');

//값을 onWrite에서 쓰려고 가져옴 
let plat = 0; //위도
let plng = 0; //경도

//제품 등록 함수
function onwrite(){
	//1) 폼전송
	let writeForm = document.querySelectorAll('.writeform')[0];
	//2) 폼 데이터 객체 선언
	let writeFormData = new FormData(writeForm);
	
	//3. 좌표 [위도/경도 추가]
	//폼 데이터 객체에 필드 추가 
	writeFormData.set("plat" , plat)
	writeFormData.set("plng" , plng)
	console.log(writeFormData)
	$.ajax({
		url : "/jspWeb/product/info",
		method : "post",
		data : writeFormData,
		contentType : false,
		processData : false,
		success : (r) => {
			if(r == 'true'){
				alert('등록성공!'); location.href="/jspWeb/index.jsp"
			}else{
				alert('등록 실패')
			}
		}
	})

}

/*-------------------------- 카카오 마커 API -------------------------- */

// 카카오 지도롤 표시할 div 객체
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
      	center: new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표.
        level: 6 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


// 지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);


// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    plat = latlng.getLat(); // 위도
    
    plng = latlng.getLng()  // 경도
    
});
/*---------------------------------------------------------------- */