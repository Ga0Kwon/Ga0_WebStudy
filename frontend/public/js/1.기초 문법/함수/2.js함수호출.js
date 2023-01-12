// - 함수 호출
	// 1. 호출할 함수의 이름이 존재
	
	/*
		1. 인수X 반환X 인 함수
			정의 
			function 함수명(){} -> 호출 : 함수명()
			
		2. 인수O 반환X 인 함수
			정의
			function 함수명(x){} -> 호출 : 함수명(x)
			
		3. 인수X 반환O 함수
			정의
			function 함수명(x){retrun 리턴할 값;} -> 호출 let result = 함수명()
			
		4. 인수O 반환 O 함수
			-정의
			function 함수명(x){return 리턴할 값;} -> 호출 let result = 함수명(x)
			
		예) prompt() 함스 예시
			1. 
				prompt(인수) : 인수 : 메시지창에 출력할 텍스트
			2.
				let 반환 = prompt(인수) : 반환ㄱ밧 : 메시지창에 입력된 텍스트"
	
	*/
//1. 인수가 없는 함수 선언
function 함수1(){ //함수1 s
	console.log("함수1 실행");
}//함수1 e

//1. js 함수 호출 [함수 호출 : 함수명()]
함수1()

//2. 인수가 1개인 함수 선언
function 함수2(x){
	console.log("함수2 실행 인수 :" + x);
}

//2. js에서 함수 호출
함수2(7)

//3. 인수가 2개인 함수 선언
function 함수3(x,y){
	console.log("함수 3 실행 인수 : " +( x + y));
}

//3. js에서 함수 호출
함수3( 5, 7);

//4. 반환이 있는 함수 선언
function 함수4(x, y, z){
	let result = x+ y+z;
	return result;
}

//4. js에서 함수 호출
let 결과 = 함수4(1,2,3);
console.log("함수 4 실행 인수 : " + 결과); // = console.log(함수4(1,2,3)); 

// class가 btn5인 html에서 가져오고 이벤트 처리를 한다..
document.querySelector('.btn5').addEventListener('Click',{
	
}) //버튼을 가져와서 이벤트 처리