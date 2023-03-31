
let pageObject = {
	page : 1, //기본 페이지 값은 1
	key : "", //기본으로는 검색키없음
	keyword : "", //기본으로는 검색키워드 없음
	listSize : 3, //처음은 3개씩만 출력
	
}
/*alert('관리자 JS 실행');*/

printMember(1); //JS실행시 첫번째 페이지먼저 보여줌

//1. 정보띄우기
function printMember(page){
	pageObject.page = page;
	console.log(pageObject)
	$.ajax({
		url : "/jspWeb/member",
		method : "get",
		data : pageObject,
		success : function(result){
			//1. 응답 데이터 처리
			if(result != null){
				console.log(result)
				//1) 테이블 헤더 구성
				let html = `<tr>
								<th width ="10%">회원번호</th>
								<th width ="10%">회원프로필</th>
								<th width ="10%">회원아이디</th>
								<th width ="10%">회원이메일</th>
								<th width ="10%">비고</th>
							</tr>`
							
				result.memberList.forEach((o) => {
					if(!(o.mid == 'admin')){ //관리자는 출력X
						//2) 테이블 내용물 추가 구성
						//만약에 회원의 mimg 프로필 이미지가 null이면 기본 프로필 사용 / 아니면 mimg 사용
						html += `<tr>
								<td width ="10%">${o.mno}</td>
								<td width ="10%"><img src = "/jspWeb/member/pimg/${o.mimg == null ? 'basic.jpg' : o.mimg}" width = "50%"></td>
								<td width ="10%">${o.mid}</td>
								<td width ="10%">${o.memail}</td>
								<td width ="10%"></td>
							</tr>`	
					}
				})
				//3) 구성된 html를 table 대입
				document.querySelector('.memberTable').innerHTML = html;
			}else{
				alert('게시물을 조회할 수 없네요.')
			}
			
			//---------------------------- 페이지 버튼 구역 ----------------------------
			
			html ='';//기존에 들어있는 내용 제거
			
			//맨앞
			html += `<button onClick = "printMember(1)" type = "button">맨앞</button>`	
			
			//이전버튼 [만약에 이전 페이지가 1 혹은 1 이하이면 더이상 이전페이지 없음]
			html += page <=1 ? 
				`<button onClick = "printMember(${page})" type = "button">이전</button>`	
				:
				`<button onClick = "printMember(${page-1})" type = "button">이전</button>`	
			
			//페이징 버튼 번호들
			for(let i = result.startBtn; i <= result.endBtn; i++){ //시작 버튼 번호부터 마지막 버튼 번호까지 버튼 생성
				html += `
					<button onClick = "printMember(${i})" type = "button">${i}</button>`	
			}
			
			//다음버튼 [만약에 다음 페이지가 totalpage 혹은 totalpage 이상이면 더이상 다음페이지 없음]
			html += page >= result.totalpage ?
			` <button onClick = "printMember(${page})" type = "button">다음</button>`	
			:	
			` <button onClick = "printMember(${page+1})" type = "button">다음</button>`	
			
			//맨뒤
			html += `<button onClick = "printMember(${result.totalpage})" type = "button">맨뒤</button>`
			
			document.querySelector('.adminpageBox').innerHTML = html;
		}
	})
}

//2. 검색 조회
function getSearch(){
	//검색이랑 페이징이랑 같이 사용해야한다.
	// * 입력받은 데이터를 전역객체 필드에 대입
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	
	// 게시물 호출
	printMember(1); //검색 결과에 맞는 1페이지
}

//3. 검색 지우기
function clearSearch(){
	pageObject.key = "";
	pageObject.keyword = "";
	
	document.querySelector('.keyword').value = '';
	printMember(1);
}

//4. 몇개씩 출력한 것인지 
function setListSize(){
	pageObject.listSize = document.querySelector('.listSize').value;
	
	printMember(1);
}	

/* ------------------------------ CHART ------------------------------ */

//5.chart.js 
	//new Chart('dom객체', {차트옵션});
	// {type : '차트 이름', data : {차트에 표시할 데이터}, options : {차트옵션}}
	
/*
	JSON = JS 객체
	
	1) g
*/
	
const ctx = document.getElementById('myChart'); //여러 스크립트에서 쓰이기 위해 getElementById을 씀
	
//get 방식 ajax
$.get("/jspWeb/point" , (r) => {
	console.log(r); //r : object => for문 못돌림
	console.log(Object.keys(r))
	console.log(Object.values(r))
	
	 new Chart(ctx, {
	    type: 'bar', //bar : 막대차트 / line : 선차트 등등
	    data: {
	      labels: Object.keys(r),
	      datasets: [
			{
		        label:'포인트 충전 내역',
		        data: Object.values(r),
		        borderWidth: 1,
		        borderColor: '#64BC34',
		        backgroundColor: '#F4B556',
	     	 }]
	    },
	    options: {
	      scales: {
	        y: {
	          beginAtZero: true
	        }
	      }
	    }
	  });
  
})


 


