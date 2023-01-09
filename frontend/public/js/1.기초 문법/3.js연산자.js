/*
	JS 연산자
		1. 산술 연산자 : +더하기 - 빼기 *곱하기 /나누기 %나머지
		2. 연결 연산자 : +
			숫자 + 숫자 : 산술 / 문자+숫자 : 연결 / 문자+문자 : 연결
		3. 비교 연산자 : > 초과[크다] / < 미만[작다] / >=이상[크거나 같다] / <= 이하[작거나 같다] 
						== 같다.[데이터만 비교]/ ===같다[자료형/데이터 비교] /!= 같지 않다. 
						!==같지않다.[데이터/자료형 비교]
						
		4. 관계 연산자 : 비교 연산자가 2개 이상일 때
					&& : and 이면서 면서 이고 모두 그리고 [비교 연산자 결과가 모두 참이면 참]
					|| : or 이거나 거나 또는 하나라도  [비교 연산자 결과가 하나라도 참이면 참]
					! : 부정 반대 [비교 연산자 결과가 모두 참이면 부정, 부정이면 참]
					
		5. 대입 연산자 :
					= 대입[오른쪽에서 왼쪽으로 대입]
					+= 더한 후에 대입 [오른쪽 데이터를 왼쪽에 더한 후 대입]
						변수명 = 변수명 + 3 vs. 변수명 += 3
					-=, *=, /=, %=
		6. 증감 연산자 :
					변수++ [후위 1증가] 변수--[후위 1감소]
					++변수 [선위 1증가] --변수[선위 1감소]
					
		-> [변수++] = [변수+=1] = [변수 = 변수 + 1]
		
		7. 삼항 연산자 : 만약에 조건이 참[true]이면 참 반환 / 거짓[false]이면 거짓 반환
					1. 조건 ? 참 : 거짓
						ex) 나이>=19 ? '성인' : '청소년'
					2. 중첩
						조건1 ? 참1 : 
							조건2 ? 참2 :
								 조건3 ? 참3 : 거짓
						ex)나이 <= 19 ? '청소년' :
												나이 <= 40 ? '청년' :
																나이 <= 60 ? '중년' : '노년'
 */

/* //1. 산술 연산자
console.log(3+3) //숫자 + 숫자 => 숫자 
console.log('더하기 : ' +3 + 3 ); //문자 + 숫자 => 문자 + 숫자 => 문자
console.log('더하기 :' +(3+3)); //[괄호] 숫자 + 숫자 => 숫자 + 문자 => 문자
console.log('빼기 :' +(3-2));  //3 - 2 =1
console.log('곱하기 :' +(3*3)); // 3 x 3 = 9
console.log('나누기 :' +(3/2));  //3 / 2 = 몫 1
console.log('나머지 :' +(3%2));  // 3 % 2 = 나머지 1
    

//2. 비교 연산자
console.log('초과 : ' + (10>3));  //true
console.log('미만 : ' + (10<3));  //false
console.log('이상 : ' + (10>=3)); //true
console.log('이하 : ' + (10<=3)); //false
console.log('같다 : ' + (10==3)); //false
console.log('같지 않다. : ' + (10!=3)); //false

//3.관계 연산자
console.log('이면서 : ' + (10>3 && 10>5)); // T and T => T
console.log('이거나 : ' + (10>3 || 10<5)); //T or F => T
console.log('부정 : ' + !(10>3)); // T =>(부정) F

//4.대입 연산자
let data1 = 10;

data1 += 2;
console.log(" += 대입 후 : " + data1)

data1 -= 5;
console.log(" -= 대입 후 : " + data1)

data1 *= 2;
console.log(" *= 대입 후 : " + data1)

data1 /= 3;
console.log(" /= 대입 후 : " + data1)

data1 %= 5;
console.log(" %= 대입 후 : " + data1)

let html = '<h3> JS 작성된 코드 </h3>' //html 마크업 저장할 변수 선언
html += '<div> 안녕하세요 </div>'  //변수에 마크업 추가
document.write(html); //해당 변수를 html 출력

//5. 증감 연산자
let data2 = 10;
console.log("변수 값 : " + data2) //10
console.log("변수++ : " + (data2++) ) //10 : 출력 후 증가
console.log("변수 값 : " + data2)  //11
console.log("++변수 : " + ++(data2++)) //12 : 출력 전 증가

console.log("변수-- :" + (data2--)) //12 : 출력 후 감소
console.log("변수 값 : " + data2) //11
console.log("--변수" + (--data2)) //10 : 출력 전 감소
console.log("변수 값 : " + data2) //10

//6. 삼항 연산자 [조건 ? 참 : 거짓]
let age = 38;
let 나이대 = age <= 19 ? '청소년' : '성인' // 조건이 false니까 '성인' 대입
console.log("38의 나이대 : " + 나이대)

let 점수 = 78;
let 등급 = 점수 >= 90 ? 'A등급' : 점수 >= 80 ? 'B등급' : 점수>=70 ? 'C등급' : '탈락'

console.log('78점수의 등급 : ' + 등급);
*/

/*
	문제9 : 정수를 입력받아서 '홀수'인지 '짝수'출력
	문제 10 : 점수 2개를 받아 더 큰 수를 출력
	문제 11 : 전수 3개를 입력받아 가장 큰 수를 출력
	문제 12 : 정수 3개를 입력받아 오름차순으로 출력

 */
// 문제 9
let number9 =   prompt('숫자를 입력해주세요.');
let result9 = (number9%2==0) ? '짝수' : '홀수'
console.log("문제 9> 정수 : " + result9)

//문제 10
let number10_1 = prompt("숫자를 입력해주세요");
let number10_2 = prompt("숫자를 입력해주세요");
let result10 = (number10_1>number10_2) ? number10_1 : (number10_2>number10_1) ? number10_2 : '두수는 같다';

console.log("문제 10> 큰수 : " + result10)

//문제 11
let number11_1 = prompt("숫자를 입력해주세요.");
let number11_2 = prompt("숫자를 입력해주세요.");
let number11_3 = prompt("숫자를 입력해주세요.");

let max = number11_1;
max = max < number11_2 ? number11_2 : max;
max = max < number11_3 ? number11_3 : max;

//문제 12
let number12_1 = prompt("숫자를 입력해주세요.");
let number12_2 = prompt("숫자를 입력해주세요.");
let number12_3 = prompt("숫자를 입력해주세요.");

let temp1 = number12_1;

number12_1 > number12_2 ? (temp1 = number12_2) : number12_2 = temp1;
//number12_1이 number12_2보다 크면 temp1에 number12_1이 들어가있음

number12_2 > number12_3 ? (temp1 = number12_3) : number12_3 = temp1;

number12_1 > number12_3 ? (temp1 = number12_1) : number12_1 = temp1;











