/*
 	입력 
 		1. confirm('메시지') : 확인(true)/ 취소(false) 입력받는 메시지 
 		2. prompt('메시지') : 데이터 입력받는 메시지
 		
	입력받은 데이터 저장[변수]
		let 변수 = confirm("메시지");
		let 변수 = prompt("메시지");
		
	숫자형 입력받을 때 
		Number(prompt('메시지'))
		
	논리형을 입력받을 때 
		Boolean(prompt('메시지'))
		
	문자형을 입력받을 때
		prompt('메시지')
	
 */

/* 1. confirm("실행하시겠습니까?");*/

//1. 입력 메시지에 대한 확인/취소 결과를 변수에 저장 
let result1 =  confirm("실행하시겠습니까?");
console.log("결과 1 : " +result1);

/* 2. prompt('데이터 입력')*/

//2. 입력 메시지에 입력된 데이터를 변수에 저장
let result2 =   prompt('데이터 입력');
console.log("결과 2 : " +result2);


/*
	문제1.
	1. 국어, 영어, 수학 점수를 입력받아 변수에 저장
	2. 총점 출력 , 평균 출력
 */

let k_score = Number(prompt("국어점수를 입력해주세요."));

let e_score = Number(prompt("영어점수 입력해주세요."));

let m_score = Number(prompt("수학점수 입력해주세요."));

let total_score = (k_score + e_score + m_score)
let avg_score = (k_score + e_score + m_score)/3;

console.log("총점 :" + total_score + " 평균 : " + avg_score);


/*
	뮨제2 : prompt 함수로 반지름을 입력받아서 원넓이[(반지름 x 반지름) x 3.14] 출력
	
*/

let radius = Number(prompt("반지름을 입력해주세요."));

let circle = radius*radius*3.14;
console.log("원의 넓이 :" + circle);

/*
	문제 3 : prompt 함수로 두 실수를 입력받아서 앞 실수의 값이 뒤 실수의 값의 몇%인지 출력
		- 54.5 84.8 64% (앞 실수의 값이 뒤 실수의 값의 몇 %인지)
 */

let number3_1 = Number(prompt("첫번째 실수를 입력해주세요."));

let number3_2 = Number(prompt("두번째 실수를 입력해주세요."));

console.log((number3_1/number3_2)*100);

 /*
 	문제 4 : prompt 함수로 정수를 입력받아 홀수[true] 짝수[false] 여부 출력 ]
 */
 let number4 = Number(prompt("정수를 입력해주세요."));
 
 console.log((number4%2==0));

 
/*
 	문제 5 : prompt 함수로 정수를 입력받아 7배수면[true] 7배수 아니면[false 여부 출력 ]
*/
 
let number5 = Number(prompt("정수를 입력해주세요."));
  
console.log((number5%7==0));
 
// 문제 6 : prompt 함수로 십만원 단위의 금액을 입력받아 지폐 개수 세기 [천원까지만]
// 몫을 구하는 방법 [parseInt()]
 
  
let price = Number(prompt("십만원 단위의 금액을 입력해주세요."));



console.log("십만원 : " + parseInt(price/100000));
console.log("만원 : " + parseInt((price%100000)/10000));
console.log("천원 : " + parseInt(((price%100000)%10000)/1000));

/*
	문제 7 : prompt로 아이디와 비밀번호를 입력받아 아이디가 admin이고 비밀번호가 1234이면 true 출력 
	아니면 false 출력
 */

let id = prompt("아이디를 입력해주세요.");
let password = prompt("비밀번호를 입력해주세요.");

console.log("로그인 : " + ((id=="admin")&&(password==1234)));

/*
	문제8 : prompt 함수로 정수를 입력받아 홀수이면서 7의 배수이면 true
*/ 

let number8 = Number(prompt("정수를 입력해주세요."));

console.log(((number8%2==0)&&(number8%7==0)));