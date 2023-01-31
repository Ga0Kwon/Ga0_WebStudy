/*
	new Date() 날짜/시간 관련된 클래스	
		1. let date = new Date() : 현재 날짜/시간 객체
		2. let date = new Date(2023, 01, 31) : 사용자 정의 날짜/시간 객체
		3. let date = new Date(연도, 월, 0) : 사용자 정의 연도와 월 날짜에 따른 마지막날
		4. let date = new Date(연도, 월, 1) : 사용자 정의 연도와 월 날짜에 따른 1일 날짜
			1) get 함수 제공	
				-date.getFullYear() : 연도 
				-date.getMonth() : 월 [0 ~ 11 0 : 1월 ~ 11 : 12월]
				-date.getDate() : 일
				-date.getDay() : 요일 [0 : 일요일 ~ 6 : 토요일]

	let date = new Date(); console.log('date : ' +date)
	
	let date2 = new Date(2020, 0, 31); console.log('date2 : ' + date2)
	console.log('연도 : ' +date.getFullYear());
	console.log('월 : ' +date.getMonth()+1);
	console.log('일 : ' +date.getDate());
	console.log('요일 : ' +date.getDay());
	


*/
/* 일정 목록 */
let contents = [
	{date : '20230101', content : '새해맞이 여행'},
	{date : '20230103', content : '친구 만나기'},
	{date : '20230101', content : '새해 기념으로 친구만나서 쇼핑하기'},
]

/*--------------------전역변수 : 모든 함수{ } 공용으로 사용되는 메모리 [변수] ----------------*/

//1. js열렸을 때 현재 연도와 월을 구해서 변수에 저장
let year = new Date().getFullYear(); //기본 값 : 현재 연도 //이전/다음 버튼 클릭에 따른 변경
let month = new Date().getMonth()+1; //기본 값 : 현재 월 // 이전/다음 버튼 클릭에 따른 변경

cal_print();

//2. 캘린더 상단에 표시 [1. 스크립트 열렸을 때, 2. 이전/다음 버튼 클릭했을마다 ]
function cal_print(){
	//1. 현재 캘린더에 설정된 날짜를 상단 월/일 표시
	document.querySelector('.top_date').innerHTML = `${year}년 ${month}월`;
	
	//2. 현재 캘린더에 설정된 날짜 객체 만들기 -> 마지막날짜 데이트 함수 끝에 0을 넣으면 마지막날짜를 넣어줌.
	let lastDay = new Date(year, month, 0).getDate(); console.log("현재 설정된 마지막 일 :"+lastDay);
	
	//3. 기본 html 구성
	let html =  `<div class = "day weekDay sunday">일</div>
				<div class = "day weekDay">월</div>
				<div class = "day weekDay">화</div>
				<div class = "day weekDay">수</div>
				<div class = "day weekDay">목</div>
				<div class = "day weekDay">금</div>
				<div class = "day weekDay saturday">토</div>`
	
	//* 2. 시작 요일 구하기 -> 현재 설정된 날짜의 1일 시작 요일
	let weekDay = new Date(year, month-1, 1).getDay();
	
	//2. 시작 요일 전에 공백 채우기
	for(let bDay = 0; bDay < weekDay; bDay++){
		html += `<div class = "day"> </div>`
	}
	
	//1. 일 만들기 [ 1 ~ 마지막 일[월마다 다름]까지 ]
	for(let day = 1; day <= lastDay; day++){
		//4. 날짜 확인
/*		let date = new Date(year, month-1, day);
		console.log(date)*/
		
		let formatDate = date_Format(new Date(year, month-1, day));
/*		console.log(formatDate)*/
		
		html += `<div onClick="openModal(${formatDate})"class = "day"> ${day}${contents_print(formatDate)}</div>`
	}
	
	//html 마크업 출력
	document.querySelector('.calendar_day').innerHTML = html;
}

//5. 일정 출력 함수
function contents_print(fDay){
	console.log(fDay)
	//1) 인수로 전달된 날짜와 동일한 일정 날짜 찾기
		//1> html 
	let html =``
	
	contents.forEach((o) => { //일정목록 반복문 foreach start
		if(fDay == o.date){ //만약에 인수로 전달된 날짜와 일정목록에서 동일한 날짜가 존재하면
			html += `<div class = "content">${o.content}</div>`
		}
	}) //foreach end
	
	return html;
	
}


//3. 이전 달 다음 달 버튼 클릭 이벤트에 따른 연도와 월이 변경
document.querySelector('.prev_button').addEventListener('click', (e) =>{
/*	console.log('이전달 버튼 클릭')*/
	//1. 월을 1차감 했을 경우 만약에 0이면 연도를 1차감시키고 12로 가야한다.
	month--;
	
	if(month < 1){
		year--
		month = 12;
	}
	
	cal_print()
})

document.querySelector('.next_button').addEventListener('click', (e) =>{
/*	console.log('다음 버튼 클릭');*/
	month++;
	if(month > 12){ //1. 월을 1증가 했을 경우 만약에 13이면 연도를 1증가시키고 1로 가야한다.
		year++
		month = 1;
	}
	cal_print()
})

/*날짜 포맷 함수 [인수 : 날짜 -----[포맷]---->반환 : 변경된 날짜 형식]*/
function date_Format(date){
	let d_year = date.getFullYear()
	//만약에 월/요일이 한자리 수 (<= 9)이면 앞에 0붙이기
	let d_month = (date.getMonth()+1) <= 9 ? `0` + (date.getMonth()+1) : (date.getMonth()+1) ;
	let d_day = (date.getDate()) <= 9 ? `0` + (date.getDate()) : (date.getDate()) ;
	
	return `${d_year}${d_month}${d_day}`;
}

//6. 모달 열기 함수
function openModal(fdate){
	/*alert(fdate + "열음");*/
	
	document.querySelector('.modal_wrap').style.display = "flex";
	
	printModalTable(fdate)
	
	//2. 모달에 선택되 날짜 표시하기
	document.querySelector('.modal_date').innerHTML = fdate;
	
}

//7. 모달 닫기 함수
document.querySelector('.modal_close').addEventListener('click', (e) => {
	document.querySelector('.modal_wrap').style.display = "none";
})

/*8. 모달에서 내용 입력[등록] 함수 */
document.querySelector('.modal_write').addEventListener('click', (e) => {
	//1) 입력받은 내용과 선택된 날짜를 가져와서 객체화를 한다.
	let inputContent = {
		date : document.querySelector('.modal_date').innerHTML, /*value값이 아님. HTML에 입력된 내용을 가져온다.*/
		content : document.querySelector('.modal_input').value
	}
/*	console.log(content)*/
	//2) 유효성 검사 생략
	
	//3) 배열에 저장
	contents.push(inputContent);
	//4) 화면 업데이트
		//1> 입력된 데이터 초기화
	document.querySelector('.modal_input').value = ""
		//2>모달 닫기
	document.querySelector('.modal_wrap').style.display = "none";
		//3> 캘린더 재 출력
	cal_print()

})
/*날짜마다 입력한 일정 출력하기 */
function printModalTable(fdate){
	// html 구성
	let html =`<tr>
					<th width = "5%">#</th>
					<th>일정내용</th> 
					<th width = "20%">비고</th>
				</tr>`
	
	for(let i = 0; i < contents.length; i++){
		if(contents[i].date == fdate){
			html += `<tr>
						<td  width = "5%">${i+1}</td>
						<td>${contents[i].content}</td>
						<td width = "20%"><button onClick = "mDelete(${i})"type = "button">삭제</button></td>
					</tr>`
		}
	}
	document.querySelector('.modal_table').innerHTML = html;
}

/*일정 삭제 함수. */
function mDelete(index){
	if(confirm('해당 일정을 삭제하시겠습니까?')){
		contents.splice(index, 1);
		alert('삭제되었습니다.')
		//화면 업데이트
		document.querySelector('.modal_wrap').style.display = "none";
		cal_print();
	}
}