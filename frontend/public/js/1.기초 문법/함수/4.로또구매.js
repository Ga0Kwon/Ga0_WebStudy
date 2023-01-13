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
	//해당 <div>에 '' 공백을 변경하기
	document.querySelector(".btnBoxList").innerHTML = " ";
	
	//취소 버튼이 안보이게 비활성화
	document.querySelector(".delBtn").style.display = "none"
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
		purpase();
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
		purpase();
		console.log('현재 선택 번호목록 :' + selctbtnList)
	}

}
//4. 선택번호 목록 출력 및 추첨 버튼 활성화
function purpase(){
	// 추첨버튼 활성화/비활성화
	if(selctbtnList.length == 6){
		document.querySelector(".lotteryBtn").style.display = 'inline'
	}else{
		document.querySelector(".lotteryBtn").style.display = 'none'
	}
	document.querySelector('.selectBtnBox').innerHTML = selctbtnList
}



