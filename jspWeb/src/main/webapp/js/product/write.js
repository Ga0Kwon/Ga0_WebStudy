console.log('제품 등록?!');

//회원제 페이지
if(memberInfo.mid == null){
	alert('로그인 후 제품 등록 가능합니다.')
	location.href = "/jspWeb/member/login.jsp";
}

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
	//폼 데이터 객체에 필드 추가 [set 필드명 중복 불가능]
	writeFormData.set("plat" , plat) 
	writeFormData.set("plng" , plng)
	console.log(writeFormData)
	
	if(plat == 0 || plng == 0){
		alert('위치를 선택후 등록해주세요');
		return;
	}
	
	if(fileList.length < 1){
		alert('최소 하나 이상의 이미지를 등록해주세요')
		return;
	}
	
	//폼에 [드래그된 파일들] 첨부파일 등록
	fileList.forEach((f) => {
		//배열에 존재하는 파일들을 하나씩 폼에 등록
		writeFormData.append('fileList', f); //append는 필드명 중복 가능
	})
	
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

/* ------------------------- 드래그앤드랍 구현 ------------------------- */


//1. 드래그앤드랍할 구역[DOM] 객체 호출
let fileDrop = document.querySelector('.fileDrop');

//* 해당 구역에 드래그된 파일들을 저장하는 리스트/배열
let fileList = [];

//2. 해당 구역에 이벤트 등록
	//1) dragenter
fileDrop.addEventListener('dragenter', (e) => {
	console.log('드래그 요소가 해당 구역에 닿았을때')
	e.preventDefault(); //고유 이벤트 제거[해당 구역에]
})

	//2) dragover
fileDrop.addEventListener('dragover', (e) => {
	console.log('드래그 요소가 해당 구역에 위치했을때')
	e.preventDefault(); //고유 이벤트 제거[해당 구역에]
	fileDrop.style.backgroundColor = '#D9DFD9';
})

	//3) dragleave
fileDrop.addEventListener('dragleave', (e)=>{
	console.log('드래그 요소가 해당 구역에 나갔을때')
	e.preventDefault(); //고유 이벤트 제거[해당 구역에]
	fileDrop.style.backgroundColor = '#ffffff';
})

	//4) drop
fileDrop.addEventListener('drop', (e)=>{
	console.log('드래그 요소가 해당 구역에 드랍되었을 때')
	//문제점 : 브라우저 영역에 드랍(요소를 놓다)했을 때 해당 페이지가 열림 [브라우저 이벤트가 먼저 실행]
	e.preventDefault(); //고유 이벤트 제거[해당 구역에]
	//1) 드랍된 파일을 호출
	let files = e.dataTransfer.files //forEach 사용 불가 -> files가 배열요소가 아니기때문에
	
	
	
	for(let i = 0; i < files.length; i++){
		if(files[i] != null && files[i] != undefined){
			//비어있지 않고 정의되어있으면[파일이 존재하면]
			fileList.push(files[i]); //각 파일들을 하나씩 배열에 저장
		}
	}
	
	printfiles();
	fileDrop.style.backgroundColor = '#ffffff';
	console.log(files)
})

//3. 해당 구역에 드랍딘 파일 목록 출력
function printfiles(){
	let html = ``;
	
	fileList.forEach((f, i) => {
		let fname = f.name; //파일명 호출
		let fsize = (f.size/1024).toFixed(3); //파일 용량[바이트/1024 => KB로 변경]
		//toFixed(표시할 소수자리수)
		html += `<div>
					<span>${fname} </span>
					<span>${fsize}KB</span>
					<span><button type = "button" onClick = "fileDelete(${i})">삭제</button></span>
				</div>`
	})
	
	fileDrop.innerHTML = html
}


//4. 드래그드랍된 파일 목록에 특정 파일 제거
function fileDelete(index){
	fileList.splice(index, 1); //i번째 하나 삭제
	printfiles(); //적용했다면 다시 렌더링
}
