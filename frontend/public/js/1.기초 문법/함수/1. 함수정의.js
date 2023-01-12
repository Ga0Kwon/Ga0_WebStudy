/*
	함수 :
		1. 함 : 상자 			수: 숫자
			- 상자안에 들어있는 수 / 코드
			- 누군가 미리 상자에 넣어둔 수 / 코드
			- 미리 정의된 수 / 코드
		2. 역할
			1. 재활용성 : 한번 만들면 반복적으로 사용가능
			2. 인수/반환 : 인수에 따른 서로 다른 반환 값 얻을 수 있다.
				인수 : 들어갈 수 / 코드 : 상자 안으로 들어오는 수
 				반환 : 나오는 수 / 코드 : 상자 밖으로 나가는 수 
 					- 함수가 종료되면서 
			3. 메모리의 효율성이 높을때 : 
				함수 { }안에서 '{' 실행되고 시작되고'}' 끝나면 메모리 초기화
		3. 함수 선언 방법
			1. function 함수명 ( 인수1, 인수2, 인수3...){
				
				코드 정의
				return 값; //갑을 안넣으면 그냥 함수 종료만
			}
		4. 함수 호출 방법
			1. 함수명(인수1, 인수2, 인수3)
			2. 주의할점 : 정의된 인수의 개수와 동일해야함.
		예) 1. 내가 2*X 라는 수식으로 함수 정의 [함수 만들기]
			2. 조건은 해당 수식을 쓸려면 숫자 1개[x]만 사용
			3. 조건은 수식의 결과를 반환 [반환 return]			

*/
//1. 함수의 선언 [1. 재활용성]
//호출이 안됨 -> 재활용성 X
console.log(2*1)
console.log(2*2)
console.log(2*3)
console.log(2*4)
console.log(2*5)

function 함수1(x){console.log(2*x)}

//함수 호출 가능
함수1(1); //2*1 = 2

//2. 함수 호출
//함수 정의/선언
function 함수2(x, y){ //인수(함수 안으로 들어오는 수/코드) 2개짜리 함수 정의
	console.log(x, y);
}
// 함수 호출
함수2(3, 5); //함수 호출시 = 함수명(전달할 인수1, 전달할 인수2)


//3.함수의 반환

function 함수3(x, y, z){ //인수 3개 함수 정의
	let result = x + y + z;
	return result; //result값을 반환
}

/*console.log("함수 안에서 선언된 변수를 함 수 밖에서 호출 : " + result);*/ //안됨 함수밖에서 쓸 수 없는 변수

let 결과 = 함수3(1, 2, 3); //리턴값을 변수에 저장
console.log('함수 실행 후 return[반환값] 출력 : ' + 결과); //이렇게는 됨.