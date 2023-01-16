/*alert("js 실행");*/

//2. 함수 호출 : 함수명()
	//1) js : 함수명()
	//2) html : <마크업 이벤트 속성 = "함수명()"/>
/*클릭이벤트();*/

//4. 배열선언 [버튼의 목록 상태를 저장하는 배열 ; null : 빈자리]
let 버튼목록현황 = [null, null, null,
				null, null, null,
				null, null, null];
				
//1. 함수 정의/만들기
function 클릭이벤트(putnumber){
// function : 함수 정의할 때 사용하는 키워드
// 클릭이벤트 : 함수명[아무거나]
// ( ) : 인수 : 해당 함수를 호출할 때 함수로 들어오는 값/데이터
// return : 반환값 : 해당 함수가 종료될 때 호출했던 곳으로 보내는 값/데이터
/*	alert("js 클릭함수 실행");*/

	//1. 선택된 번호와 알모양을 앞두기 함수 전달하고 반환이 false이면 알두기 실패 / true 성공 후 컴퓨터 차례
	
	//1. 사용자 차례
	if(!알두기(putnumber, "O")){
		return;
	}
	
	if(결과()){ return; }
	//1) 난수 생성
	
	//2. 컴퓨터 차례 / 무한루프 [정상적으로 알을 두기 전까지 무한루프]
	 while(true){
	 	/*Math.random()*9 */// 0~9사이의 실수를 랜덤 생성
		let computerNumber = parseInt(Math.random()*9) + 1; //1~9까지 나옴. (10전까지 나옴.)
		if(알두기(computerNumber, "X")){
			결과();
			return;
		}
	 }
} //f e

/*//2. 컴퓨터 알 두기 함수
function 컴퓨터알두기(){
	//1) 난수 생성
	Math.random()*9 // 0~9사이의 실수를 랜덤 생성
	let number = parseInt(Math.random()*9)
	//2. <div> 버튼 목록 가져와서 배열저장
	let 버튼목록 = document.querySelectorAll('.버튼');
	//3. 
	if(버튼목록현황[number] != null){
		alert("이미 알이 존재하는 자리입니다.");
		컴퓨터알두기();
		return 0;
	}else{
		버튼목록현황[number] = "X"
		버튼목록[number].innerHTML = "X"
	}
}
*/

//2. 컴퓨터와 사용자가 알을 두는 함수
// [반환값 : 알을 두었는지 확인 -> false:0: 실패/ true:0: 성공]
function 알두기(number, 알모양){
	//2. <div> 버튼 목록 가져와서 배열에 저장 [div 9개 호출]
	let 버튼목록 = document.querySelectorAll(".버튼");
/*	console.log(버튼목록);*/
	
	
	//5. 배열에 상태 변경
	
	//1)이미 선택된 번호면 불가능
		
	if(버튼목록현황[number-1] != null){
		return false;
	}
	
	//3. 인덱스 : 0 번호 : 1 부터 시작
	// 클릭된 번호의 div 찾기 [선택번호 -1]
	버튼목록[number-1].innerHTML = 알모양;
	버튼목록현황[number-1] = 알모양;
	console.log(버튼목록현황);
	
	return true; //성공했으면 true를 반환
}

//3. 결과 함수 [승리자 판단 => 1.승 2.패 3. 무승부[빈자리 없으면]]
function 결과(){
	// 1. 가로 승리자 판단 
	// * 배열의 초기값이 모두 null 이기 때문에 null 제외
	for( let i = 0 ; i<=6 ; i+=3 ){ // i는 0부터 6까지 3씩증가 반복처리 -> 3회반복 : 0 3 6 
		if( 버튼목록현황[i] != null && 버튼목록현황[i] == 버튼목록현황[i+1] && 버튼목록현황[i+1] == 버튼목록현황[i+2]  ){
			결과출력(  버튼목록현황[i] ) // 버튼목록현황[i] : 승리자의 알모양[]
			return true; // * 승리자 존재 하는 신호;
		} // if e 
	} // for e
	//세로
	for(let i = 0; i <=2; i+=1){
		if(버튼목록현황[i] != null && 버튼목록현황[i] == 버튼목록현황[i+3] && 버튼목록현황[i+3] == 버튼목록현황[i+6]){
			승리자출력(버튼목록현황[i]);
			return true;
		}
	}
	
	//대각선 
	if(버튼목록현황[4] != null && 버튼목록현황[0] == 버튼목록현황[4] && 버튼목록현황[4] == 버튼목록현황[8]){
		승리자출력(버튼목록현황[4]);
		return true;
	}
	//대각선
	if(버튼목록현황[2] != null && 버튼목록현황[2] == 버튼목록현황[4] && 버튼목록현황[6] == 버튼목록현황[4]){
		승리자출력(버튼목록현황[2]);
		return true;
	}
	
	//null값 카운트 -> null이 없으면 무승부.
	let count = 0;
	//무승부 판단
	for( 버튼 of 버튼목록현황) {
		if(버튼== null){
			count++;
		}
	}
	if(count == 0){
		승리자출력("-")
		return true;
	}
	return false;
	
} 

//4. 게임 승리자 출력
function 승리자출력(알모양){
	//1. 출력할 위치의 <div>호출
	let 게임판 = document.querySelector(".게임판");
	
	if(알모양 == "-"){
		게임판.innerHTML = "무승부"
	}else{
		게임판.innerHTML = 알모양 + "승리";
	}
}

/*
	버튼 목록 현황
	[0] [1] [2]
	[3] [4] [5]
	[6] [7] [8]
	
	승리판단 3가지
		1) 가로로 이겼을 때
			0 1 2 모양이 모두 동일하면
			3 4 5 모양이 모두 동일하면
			6 7 8 모양이 모두 동일하면
		2) 세로로 이겼을 때
			0 3 6 / 1 4 7 / 2 5 8
		3) 대각선으로 이겼을 때
			0 4 8 / 2 4 6
			
	무승부 : 알이 모두 존재햇을 때 = null 0개 일때
	
*/