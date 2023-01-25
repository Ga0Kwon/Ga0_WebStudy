console.log('1.js 열림')
/*
	-날짜 함수
		1. new Date() : 현재 날짜/시간 반환
		2. 연도/월/일 
			1) getFullYear() : 날짜에서 연도만 추출
			2) getMonth() : 날짜에서 월만 추출
				[0~11 / 0 : 1월 ~~~~~~~~~> 11: 12월]
			3) getDate() : 날짜에서 일만 추출
			3) getDay() : 날짜에서 요일만 추출
				[0 : 일 ~~~~~~~~~~~~~~~~> 6 : 토]
		3. 시/분/초
			1).getHours() : 시간에서 시만 추출
			2).getMinutes() : 시간에서 분만 추출
			3).getSeconds() : 시간에서 초만 추출


 */

// "함수 밖에 만드는 이유 : 전역변수 : 모든 함수에서 동일한 메모리를 사용."
let contents = [];
onPrint(); //1. js열렸을 때 
// 이벤트함수
	// 1. <button type = "button" onClick = "onWrite()">글 동록</button>
	/*function onWrite(){ } */
	// 2.<button type = "button"  class = "onWriteBtn">글 동록</button
	/*document.querySelector('.onWriteBtn').addEventListener('click', (e) =>{ })*/

/*1. 글 등록 함수 => 글 등록버튼을 눌렀을 때 실행*/
function onWrite(){ //f onWrite() s
	console.log('글동록 버튼 눌림.');
	
	
	//1) 입력받은 4개의 데이터를 하나의 객체 선언
	let info = { //let 객체명(아무거나) = {속성명 : 데이터, 속성명 : 데이터, 속성명 : 데이터}
		writer: document.querySelector('.bwriter').value,
		password : document.querySelector('.bpassword').value,
		title : document.querySelector('.btitle').value,
		content : document.querySelector('.bcontent').value,
		date :  new Date(), //현재 날짜, 현재 시간 반환
		view : 0
	}

	console.log(info) //객체 정보 출력시 문자열 연결연산자 금지 
	
	
	//2) 유효성 검사 / 객체명.속성명
		//1> 입력받은 데아터 길이 체크
	if(info.writer.length <= 0 || info.password.length <= 0 || 
		info.title.length <= 0 || info.content.length <= 0  ){
		alert('작성이 안된 구역이 있습니다. 작성해주세요.')
		return; //함수 종료... 해당 함수에서 아래로 진행 불가능
	}
	
	//3) 배열에 저장 *추후 : 백엔드 통신
	contents.push(info); //마지막 인덱스 뒤에 들어간다.
	alert('글 등록 성공')
	
	//4) 초기화.
	document.querySelector('.bwriter').value = ""
	document.querySelector('.bpassword').value = ""
	document.querySelector('.btitle').value = ""
	document.querySelector('.bcontent').value =""
	
	console.log(contents)
	
	onPrint(); //2. 글 등록(성공)했을 때
	
} //f onWrite() e

/*2. 글 출력 함수 => js 열렸을 때, 글 등록했을 때, 글 삭제했을 때, 글 수정했을 때 */
function onPrint(){ //f onPrint() s
	console.log('onPrint 실행')
	//1) 기본 html 구성
	let html = `<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th style = "width : 55%">작성일</th>
					<th>조회수</th>
				</tr>`
	//2) 내용 html 구성
	for(let i = 0; i < contents.length; i++){
			
		let date = contents[i].date.getFullYear() + '년'
				+ (contents[i].date.getMonth()+1) + "월" +
				contents[i].date.getDate() + "일" +
				contents[i].date.getHours() + ":" + 
				contents[i].date.getMinutes() + ":" +
				contents[i].date.getSeconds()
				
		html += `<tr onClick = "onView(${i})">
					<td>${i}</td>
					<td>${contents[i].title}</td>
					<td>${contents[i].writer}</td>
					<td style = "width : 55%" >${date}</td>
					<td >${contents[i].view}</td>
				</tr>`
	}
	
	//3) 마크업 html 대입
	document.querySelector('.boardTable').innerHTML = html
}//f onPrint() e

/*3. 글 보기 함수[조회수 증가] => 글 목록에서 해당을 행을 클릭했을 때*/
function onView(i){  //f onView() s
	alert(i+"행을 선택")
	
	contents[i].view += 1; /*조회수 증가*/ onPrint(); /*조회수 반영을 위해 글 출력 함수 호출 */
	
	let html = `<div>제목 : ${contents[i].title}</div>
				<div>내용 : ${contents[i].content} </div>
				<div>작성자 :  ${contents[i].writer}</div>
				<div><button onClick = "onDelete(${i})">삭제</button></div>`
				
	document.querySelector('.viewBox').innerHTML = html;
}//f onView() e

/*4. 글 삭제 함수 => 해당 행에 글 삭제 버튼을 눌렀을 경우 */
function onDelete(i){//f onDelete() s
	if(contents[i].password == prompt('비밀번호를 입력해주세요.')){ //입력 비밀번호와 객체내 비밀번호가 일치하면
		contents.splice(i, 1); //삭제
		onPrint(); //글 출력 갱신
		document.querySelector('.viewBox').innerHTML = ''; //글 보기 페이지 테이블 공백으로 바꿔줌.
		alert('삭제 성공')
	}else{
		alert('[삭제 실페] 비밀번호가 틀렸습니다.')
	}
}//f onDelete() e