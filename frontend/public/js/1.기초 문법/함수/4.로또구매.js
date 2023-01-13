console.log("1. 로또구매 js 실행");

	
/* 1.숫자 버튼을 출력하는 함수*/
function btnClick(){ //로또구매 버튼 누를시
	console.log('2. 로또구매 버튼 작동');
	
	let btnList = '';
	
	for(let i = 1; i <= 45; i++){
		//i는 1부터 45까지 1씩 증가 반복처리
		console.log('3.' +i);
		//1. html 문자열  ~~~~~~~~'+ 변수 + 'html문자열' +변수 + 'html문자열'
		//'<button onclick="btnClick('+i+')">' +i '</button>'
		//2. 백틱을 이용한 문자열 처리
			// `(백틱 - esc 아래) : 작은 따옴표 아님
			//1. 전체를 백틱으로 감싼다.
			//2. 변수는 ${}감싼다.
			/*`<button onclick="btnClick('${i}')">${i}</button>`*/
		
		
		btnList += `<button onclick="numberBtnClick(${i})" style = "width : 100px">${i}</button>`
		document.querySelector(".btnBoxList").innerHTML = btnList;
		
		//만약에 5배수이면 줄바꿈
		if(i % 5 == 0){
			btnList += '<br/>'
		}
		
		//취소 버튼이 보이게 활성화
		document.querySelector(".delBtn").style.display = "inline"
	}
	console.log("4.버튼 목록 : " + btnList);
} //btnClick end

/* 2. 숫자 버튼 없애는 함수 */
function btnDelete(){
	//해당 <div>에 '' 공백으로 변경하기
	document.querySelector(".btnBoxList").innerHTML = " ";
	//선택한 번호 목록 공백 변경
	document.querySelector(".selectBtnBox").innerHTML = " ";
	//추첨 번호 목록 공백 변경
	document.querySelector(".lotteryNumberList").innerHTML = " ";
	//추첨 맞은 개수 텍스트 공백으로 변경
	document.querySelector(".checkLotto").innerHTML = " ";
	
	//취소 버튼이 안보이게 비활성화
	document.querySelector(".delBtn").style.display = "none"
	//추첨 버튼 안보이게 비활성화
	document.querySelector(".lotteryBtn").style.display = "none"
	
	//배열내 모든 요소를 제거
	selctbtnList.splice(0); //0번 인덱스부터 (개수) 생략했을 때 모두 제거
	lottoPurpase(); //html상으로 배열이 안나오게됨.
	
	lotteryList.splice(0)
	
}

//1. 선택한 숫자를 6개 저장하는 배열
let selctbtnList = []

/* 3. 버튼 클릭 함수 */
function numberBtnClick(number){
	/*console.log(i + "번을 선택하셨습니다.")*/

	//1.중복 검사 [배열명.indexOf(데이터) : 찾은 데이터의 인덱스 번호 반환, 있으면 인덱스, 없으면 -1]
	if(selctbtnList.indexOf(number) >= 0){
		alert("이미 선택한 번호입니다. 해당 버튼을 취소하겠습니다.");
		selctbtnList.splice(selctbtnList.indexOf(number), 1);
		console.log('현재 선택 번호목록 :' + selctbtnList);
		lottoPurpase();
		document.querySelector('.selectBtnBox').innerHTML = selctbtnList;
	}
	//2. 6개까지만 저장 [배열명.length : 배열 내 데이터 총 개수]
	//여기안에 추첨버튼 비활성화/활성화를 하면... 버튼을 적어도 7번을 클릭했을 때 추첨버튼을 띄우게 된다.
	else if(selctbtnList.length == 6){
		alert('이미 모두[6개]를 선택했습니다.');
	}
	else{
		//위 2가지 유효성 검사를 충족하지 않았을 때 저장
		selctbtnList.push(number);
		lottoPurpase();
		console.log('현재 선택 번호목록 :' + selctbtnList)
	}

}

function lottoPurpase(){
// 추첨버튼 활성화/비활성화
	if(selctbtnList.length == 6){
		document.querySelector(".lotteryBtn").style.display = 'inline'
	}else{
		document.querySelector(".lotteryBtn").style.display = 'none'
	}
	document.querySelector('.selectBtnBox').innerHTML = selctbtnList
}

//추첨 번호 목록
let lotteryList = [];

//4. 선택번호 목록 출력 및 추첨 버튼 활성화[1. 구매취소 2.버튼 클릭시 숫자 등록, 3. 버튼 클릭시 숫자 취소]
//5. 추첨버튼을 클리했을 때
function purpase(){

	//1. 컴퓨터가 난수 발생 [1 ~ 45 사이의 수 6개]
	for(let i = 1; i <=6; i++){ //i는 6까지 1씩 증가하면서 반복
	
		let randomNumber = parseInt(Math.random()*44+1)
		
		//*중복 검사
		if(lotteryList.indexOf(randomNumber) >= 0){
			i--; //등록을 못했으니까 없으면 i--해줘야 6개까지 저장될 수 있음.
		}else{
			if(lotteryList.length < 6){
				lotteryList.push(randomNumber);
			}
		}
	} //for end
	
	document.querySelector('.lotteryNumberList').innerHTML = lotteryList
	checkLottery();
	console.log(lotteryList);
} //function end

let count = 0;

//몇개가 맞았는지 확인하는 함수
function checkLottery(){
	//1. 
	for(let i = 0; i <lotteryList.length; i++ ){
		for(let j = 0; j<selctbtnList.length; j++){
			console.log(lotteryList[i] + " : " + selctbtnList[j]);
			if(lotteryList[i] == selctbtnList[j]){count++}
		}
	}
	//2.
/*	for(let i = 1; i <=lotteryList.length; i++){
		if(lotteryList.indexOf(selctbtnList[i])>=0){
			count++;
		}
	}*/
	//3. for (반복 변수 of 배열) : 배열 내 요소 하나씩 마지막 요소까지 반복 변수에 대입
/*	for(let value of lotteryList){
		console.log(value)
		if(selctbtnList.includes(value)){count++}
	}*/
	document.querySelector('.checkLotto').innerHTML = count + "개 맞았습니다.";
	//추첨버튼을 계속누리면 맞은 개수만큼 계속 증가한다. 따라서 출력했다면 count를 0으로 바꿀 필요가 있다.
	count = 0;
}

/*
	난수 만들기
		1. Math 클래스 [미리 만들어둔 설계도/코드]
			1) random()함수 [Math클래스가 제공하는 미리 만들어둔 함수]
			예시) 
				Math.random() : 0~1 사이의 실수 난수 발생
				Math.random()+1 : 1~2 사이의 실수 난수 발생
				Math.random()*45 : 0~45 사이의 실수 난수 발생
				Math.random()*45+1 :1~46 사이의 실수 난수 발생
				Math.random()*44+1 :1~45 사이의 실수 난수 발생
			2) floor(): 버림 함수 (소숫점을 버린다.)
			예시)
				Math.floor(3.14) : 3
				
		2. parseInt() : 정수로 변환 함수
			parseInt(3.14) : 3

	두 배열 비교
		1. 
			배열1 : 3 7 2 5
			베열 : 1 5 3 4
				3 -> 1 
				3 -> 5
				3 -> 3
				3 -> 4
				
*/

