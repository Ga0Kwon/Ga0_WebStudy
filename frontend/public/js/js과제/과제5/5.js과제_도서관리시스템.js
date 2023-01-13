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
				2		이것이자바다			대여가능		도서대여버튼/도서반납버튼
				3		열혈 C언어			대여가능		도서대여버튼/도서반납버튼
			


*/
console.log("도서관리 시스템 실행") //연동 확인용

let 도서목록 = ['혼자공부하는자바', '이것이자바다']
let 대여목록 = ['혼자공부하는자바']

/*-----------------------------------20230113 권가영------------------------------------- */
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
								<td id = "customerNote"><button onClick = "returnClick(${i})" class = "whatBtn" id = "returnBtn" style = "background-color: #FF3939;">도서반납버튼</button></td>
					</tr>`
		}
		else{ //대여할 수 있는 경우
			html += `<tr>
								<td>${i +1}</td>
								<td>${도서목록[i]}</td>
								<td><p class = "rentalOX" id ="retalOK">대여가능</p></td>
								<td id = "customerNote"><button onClick = "rentalClick(${i})" class = "whatBtn" id = "rentalBtn">도서대여버튼</button></td>
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


//도서반납버튼  클릭시 처리하는 함수 [해당 인덱스를 인수를 받는다.]
function returnClick(i){
	
	let bookIndex  = 대여목록.indexOf(도서목록[i]);
	
	console.log(bookIndex)
	let inputInfo = confirm("반납하시겠습니까?"); //확인을 누르면 true반환, 취소를 누르면 false
	
	if(inputInfo == true){ //반납하겠다는 뜻
		document.querySelector(".noticeText").innerHTML = "";	
		대여목록.splice(i, 1); //대여목록에 있는 해당 인덱스의 도서를 삭제한다.
		printContent(); //화면을 다시 프린트해준다. (갱신 -> 정보가 바뀌었으니)
	}else{
		//반납을 도중에 취소하면 알림으로 알려줌
		document.querySelector(".noticeText").innerHTML = `<p> << ${대여목록[bookIndex]} >>  반납을 취소하였습니다 </p>`
	}
}

// 도서대여버튼 클릭시 처리하는 함수 [해당 인덱스를 인수를 받는다.]
function rentalClick(i){
	let inputInfo = confirm("대여하시겠습니까?"); //확인을 누르면 true반환, 취소를 누르면 false
	
	if(inputInfo == true){ //대여하겠다는 뜻
		document.querySelector(".noticeText").innerHTML = "";
		대여목록.push(도서목록[i]);//대여목록에 해당 인덱스에 해당하는 도서를 넣는다
		console.log(대여목록)
		printContent(); //화면을 다시 프린트해준다. (갱신 -> 정보가 바뀌었으니)
	}else{
		//대여를 도중에 취소하면 알림으로 알려줌
		document.querySelector(".noticeText").innerHTML = `<p style = "color :blue"> << ${도서목록[i]} >> 대여를 취소하였습니다 </p>`
	}
}

/*-----------------------------------20230113 권가영------------------------------------- */

