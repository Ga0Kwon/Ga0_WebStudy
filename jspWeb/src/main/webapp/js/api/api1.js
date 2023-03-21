

/*AJAX를 이용한 데이터 포털[js]의 데이터 가져오기*/
/*공공데이터 자체가 json을 받아 드리기 때문에 바로 써도 됨 [어처피 json을 제공]*/
/*$.ajax({
	url : "신청한 공공데이터 Request URL",
	method : "get",
	success : (r) =>{
		console.log(r);
	}
})*/

/*첫번째 API - 안산시 전기차 충전소 API */

getApi1();

function getApi1(){
	$.ajax({
	url : "https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=yGK0ktRbG%2BTL3dCkYWNRIAi0bHut%2FYjDdi8lXd9MeZnPxhXf8rkoOMfgZJQfrB0f%2B%2BGERokC79iVDaO%2BexWAlw%3D%3D",
	method : "get", //공공데이터를 가져오려면 get방식!
	success : (r) =>{
		console.log(r); //뭐가 들어있는지 확인해야 사용가능
		let html = ``;
		
		document.querySelector('.totalCount').innerHTML = "안산시 전기차 충전소 개수 : " + r.totalCount;
		
		html += `<tr>
					<th>경도(WGS84)</th>
					<th>소재지도로명주소</th>
					<th>소재지우편번호</th>
					<th>소재지지번주소</th>
					<th>시군명</th>
					<th>운영기관명</th>
					<th>위도(WGS84)</th>
					<th>충전기타입명</th>
					<th>충전소명</th>
				 </tr>`
		if(r != null){
			r.data.forEach((o) => {
				/*경도(WGS84) => js는 이걸 함수 호출로 판단한다 => 에러!
					객체내 필드 호출하는 방법 :
						1) 객체명.필드명
						2) 객체명['필드명'] */
				html += `<tr>
							<td>${o['경도(WGS84)']}</td>
							<td>${o.소재지도로명주소}</td>
							<td>${o.소재지우편번호}</td>
							<td>${o.소재지지번주소}</td>
							<td>${o.시군명}</td>
							<td>${o.운영기관명}</td>
							<td>${o['위도(WGS84)']}</td>
							<td>${o.충전기타입명}</td>
							<td>${o.충전소명}</td>
						 </tr>`
			})
		}
		
		document.querySelector('.api1').innerHTML = html;
	}
})
}

/*두번째 API - 한국환경공단_에어코리아_대기오염정보 시도별 실시간 측정정보 조회*/
getApi2();

function getApi2(){
	$.ajax({
		url : "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty?serviceKey=yGK0ktRbG%2BTL3dCkYWNRIAi0bHut%2FYjDdi8lXd9MeZnPxhXf8rkoOMfgZJQfrB0f%2B%2BGERokC79iVDaO%2BexWAlw%3D%3D&returnType=json&numOfRows=100&pageNo=1&sidoName=%EA%B2%BD%EA%B8%B0&ver=1.0",
		method : "get",
		success : (r) =>{
			console.log(r);
			console.log(r.response.body.items); //실제 사용할 데이터
			
		}
	})
}

