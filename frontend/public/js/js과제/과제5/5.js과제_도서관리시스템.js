/*
	코드 작성시 : 날짜와 누가 만들었는지 적기! 
			//20230113 : 권가영
	*배열 2개만
		let 도서목록 = ['혼자공부하는자바', '이것이자바다']
		let 대여목록 = ['혼자공부하는자바']
		
	*함수 정의 : 원하는대로
	*변수 정의 : 원하는대로
	
	1. 관리자 입장
		- 기능
			input 하나
			1. 도서 등록 [도서명]
				1. 동일한 도서명은 안된다. [중복검사]
				2. 5~10글자 사이만 도서명 입력가능[5<=length<=10]
				예시) 1. 번호 2. 도서명 3. 도서대여여부 4. 삭제
						번호 		도서				도서대여여부		비고
						1		혼자공부하는자바		대여중			삭제버튼
						2		이것이자바다		대여가능			삭제버튼
						3		열혈 C언어			대여가능			삭제버튼
						
			2. 도서 현황 출력
				1) 번호
				2) 도서명
				3) 도서대여여부
				4) 삭제
				
	2. 고객 입장
		- 기능
			input 없음
			1. 도서 목록
				1. 번호 2. 도서명 3. 도서대여여부 4. 도서대여버튼/도서반납버튼 
			2. 도서 대여
				1) 대여중인 도서 불가능
			3.도서 반납
				1) 대여중인 도서가 아니면 불가능
			예시)	
				번호		도서				도서대여여부		비고
				1		혼자공부하는자바		대여중			도서대여버튼/도서반납버튼
				2		이것이자바다		대여가능			도서대여버튼/도서반납버튼
				3		열혈 C언어			대여가능			도서대여버튼/도서반납버튼
			


*/
console.log("도서관리 시스템 실행") //연동 확인용

let 도서목록 = ['혼자공부하는자바', '이것이자바다']
let 대여목록 = ['혼자공부하는자바']

//고객체이지 테이블 안을 채우는 함수
function printContent(){
	let html = `<tr>	
						<th class = "index">번호</th>
						<th class = "book">도서</th>
						<th class = "rental">도서대여여부</th>
						<th class = "note">비고</th>
				</tr>`
	for(let i = 0; i<도서목록.length; i++){
		if(rentalBtnOnOff(도서목록[i]) == 0){ //대여할 수 없는 경우
			html += `<tr>
								<td>${i +1}</td>
								<td>${도서목록[i]}</td>
								<td><p class = "rentalOX" id ="retalNO">대여중</p></td>
								<td id = "customerNote"><input onClick = "btnClick()"type = "button" class = "whatBtn" id = "returnBtn" value = "도서반납버튼" ></input></td>
						</tr>`
		}
		else{ //대여할 수 있는 경우
			html += `<tr>
								<td>${i +1}</td>
								<td>${도서목록[i]}</td>
								<td><p class = "rentalOX" id ="retalOK">대여가능</p></td>
								<td id = "customerNote"><input onClick = "btnClick()" type = "button" class = "whatBtn" id = "rentalBtn" value = "도서대여버튼" ></input></td>
						</tr>`
		}
	}	
	document.querySelector('.customerTable').innerHTML = html 
}
printContent()


//대여여부를 알려주는 함수
function rentalBtnOnOff(x){
	if(대여목록.indexOf(x)>= 0){
		 return 0; //만약 책을 대여해서 대여할 수 없다면 0을 반환
	}else{
		return 1; //만약 책을 대여한 사람이 업어서 대여할 수 있다면 1을 반환
	}
}

