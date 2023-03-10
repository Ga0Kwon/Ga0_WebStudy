/*
	- 데이터 1개 저장할 수 잇는 메모리 공간
	- 준비물 : 
		1. 자료형(키워드)
		2. 이름(식별을 위해)	
		3. 저장할 데이터
		4. = : 대입 연산자 [오른쪽 데이터를 왼쪽에 넣기]
		
	변수 : 변하는 수
		1. let 키워드 사용	
			형태 : let 변수명 = 데이터
		2. var [쓰지 않는 것이 좋음]
		
	상수 : 변하지 않는 수 [고정된 수 ]
		1. const
			형태 : const 변수명 = 데이터
			대입 후에 변경 불가능 
			
	선언 방법
		1. let or const
		2. 변수/상수명 정의[만들기] -> 이름 중복 불가능
		3. = : 대입 연산자
		4. 데이터
 */

 //1. 변수 선언.
 //1) let or const
 //2) 변수명 정의 => 현재 범위 내 동일한 이름이 있는지 확인[중복안됨]
 //3) 대입연산자[=]
 //4) 데이터
 
//1. 변수 선언
let value1 = 10; //'value1' 이라는 변수 상자에 10을 대입했다. 

//2. 변수 호출
console.log("변수 value1 값 : " + value1); //변수 'value1' 이라는 변수 상자에 값을 호출 

//3. 변수 값 변경
/* let value1 = "20";*/ //'value1'이라는 변수명이 존재하기 때문에 오류 발생 
value1 = 20; //'value1'이라는 변수 상자에 새로운 값[20] 대입
console.log("수정 후 변수 value1 값 : " + value1);

//4. 변수 연산
/*
	+ : 1. 더하기[산술] 2. 붙이기[연결]
		숫자 + 숫자 = 숫자
		문자 + 숫자 = 문자
		문자 + 문자 = 문자
 */
console.log('변수 값 더하기 5' + value1+5); //문자열 + 숫자 + 숫자 
// -> 순서대로 처리하기 때문에 연산을 문자열로 처리 
console.log('변수 값 더하기 5' + (value1+5)); //문자열 + (숫자 + 숫자) 
// -> 괄호를 썼기 때문에 숫자 더하기 숫자에 문자열을 더했음으로 마지막엔 연결!

let value2 = 30;
let result = value1 + value2; //변수들의 값을 저해서 변수 result에 대입 
console.log("변수들의 연산" + result);

//1. 상수 선언
const data1 =10;
/*data1 = 20;*/ //에러 발생 -> 값을 바꿀 수 없음. [변경 불가/ 수정X / 상수]
console.log(data1); 

const data2 = 20;

const result2 = data1 + data2 //이것은 가능. -> result2의 값을 아직 지정하지 않아서.
 