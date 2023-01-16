alert("js 실행");

//board 객체를 여러개 저장하는 배열 / 함수 밖에 있는 이유 : 누적 저장 [베열 선언]
let boardArray = []
	//예시 [{ 속성 : 값 }, { 속성 : 값 }, { 속성 : 값 }]

//1. 작성 버튼 클릭시 실행되는 함수
function 작성(){
	console.log('작성');
	
	//1. 입력받은 데이터 가져오기
	let 작성자 = document.querySelector('.name').value;
	let 내용 = document.querySelector('.content').value;
	let 비밀번호 = document.querySelector('.password').value;
	
	console.log(작성자)
	console.log(내용)
	
	//2. 입력받은 3개의 데이터를 하나로 객체화
	let board = {
		writer : 작성자,
		content : 내용,
		password : 비밀번호
	}
	
	//3. 객체를 배열에 저장 [여러개 객체를 저장]
	boardArray.push(board);
	console.log(boardArray)
	
	printContent();
	
}

//비밀번호 체크 함수
function checkingPassword(i){
	let checkPassword = prompt("비밀번호를 입력해주세요.");
	if(boardArray[i].password == checkPassword){
		return true;
	}else{
		alert("비밀번호가 올바르지 않습니다.")
	}
}

//삭제 버튼 함수
function onDelete(i){
	if(checkingPassword(i)){
		boardArray.splice(i,1);
		printContent();
	}
}

function printContent(){
	//4. 배열내 객체 출력
		//1) 테이블의 제목행 만들기 
	let html = `<tr>			
					<th style="padding : 5px 20px; width :100px; text-align : center">번호</th>
					<th style="padding : 5px 20px; width :100px; text-align : center">내용</th>
					<th style="padding : 5px 20px; width :100px; text-align : center">작성자</th>
					<th style="padding : 5px 20px; width :100px; text-align : center">비고</th>
				</tr>`
	//2. 반복문을 이용한 배열 내 모든 요소를 행 만들기 [누적]
		//1) 반복을 이용하여 배열내 객체 하나씩 호출 : boardArray[i] 
		//2)객체내 속성 호출 boardArrray[i].속성명
	for( let i = 0; i <boardArray.length; i++){ // 5. 내용추가 [ 반복 이용한 배열내 요소 출력 ]
		html += `<tr>
					<td style="padding : 5px 20px; width :100px; text-align : center">${ i+1 }</td>
					<td style="padding : 5px 20px; width :100px; text-align : center">${ boardArray[i].content}</td>
					<td style="padding : 5px 20px; width :100px; text-align : center">${ boardArray[i].writer}</td>
					<td style="padding : 5px 20px; width :100px; text-align : center">
											<button onclick="onDelete( ${i} )">삭제</button>		
											<button onclick="onChange( ${i} )">수정</button></td>
				</tr>`	
	} // for end 
	document.querySelector('.noticeTable').innerHTML = html // 6. 위에서 구성된 html를 해당 마크업에 대입

	document.getElementById("name").value ='';
	document.getElementById("content").value ='';
	document.getElementById("password").value ='';
}

//수정 버튼 함수
function onChange(i){
	if(checkingPassword(i)){
		let 수정할내용 = prompt("수정할 내용을 입력해주세요.");
		if(수정할내용.trim() == "" || 수정할내용 == " "){
			alert("내용을 입력해주세요.")
			onChange(i) //다시 수정 버튼 재귀
		}else{
			boardArray[i].content = 수정할내용;
			printContent();
		}
	}
}