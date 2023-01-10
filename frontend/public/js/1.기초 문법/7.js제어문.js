/*
	삼항연산자 : 조건 ? 참 : 거짓
	제어문 
		IF : 만약에 ~~ [경우의 수 판단]
		1. 형태
			1) if( 조건 ) [참]실행문;
			2) if(조건) { [true=참]실행문1; 실행문2, 실행문3;}
				* 실행문 2개 이상일 때 { } 이용한 묶음처리 하자.
			3) if(조건) {[true]실행문;}
			   else{[false=거짓]실행문;}
		   	4) if(조건) {[true]실행문;}
		   	   else if(조건2){[true2]실행문;}
		   	   else if(조건3){[true3]실행문;}
		   	   else if(조건4){[true4]실행문;}
		   	   else{[false]실행문;}
	   	   5) 중첩
	   	   		if(조건){ 
					  if(조건2){
						  
						  if(조건3){
							  
						  }
						  
					  }
			    }
	

*/
//1. if 형태1
/*
	; : 세미콜론[명령어단위 마침표]
	: : 콜론
	실행문; -> 한 줄에  하나 쓸때는 세미콜론 생략 가능
	실행문; 실행문; -> 한 줄에 두개일 경우 세미콜론으로 구분을 해주어야한다. (if 제외)
	if() [참]실행문
	if(); [참]실행문 [if()뒤에 ; 하지 말기]

 */
if(10 > 3) console.log('[참] 10이 더크다.')
if(10 > 20) console.log('[참] 10이 더 크다.')
//세미콜론은 어떤 명령어의 구분선으로 따라서 if따로 실행문 따로 되어서 안나오게 됨.
if(10 > 20); console.log('[참] 10이 더크다. ') 

//2. if 형태2
if(10 > 3) console.log('참1'); console.log('1. 10이 더 크다.'); //2번째 console if랑 상관없이 무조건 실행
if(10 > 20) console.log('참2'); console.log('2. 10이 더크다') //2번째 console if랑 상관없이 무조건 실행
if(10 > 20){ //다 실행안됨.
	console.log('참3');
	console.log('3. 10이 더 크다.'); 
}

//3. if 형태3
if(10 > 3){console.log('[true] 10이 더 크다.');}
else{console.log("[false] 10이 더 작다.")}
//vs. 삼항연산자 [코드가 길어지면 가독성이 떨어짐.]
10 > 3 ? console.log("[true]") : console.log("[false]");

//4. if 형태4
if(10 >= 20 ){console.log('[true1] 10이 20보다 크다.');} //만약에 10>=20 이면
else if(10 >= 15 ){console.log('[true2] 10이 15보다 크다.');} //아니면서 만약에 10>=15이면
else if(10 >= 10 ){console.log('[true3] 10이 10보다 이상이다..');} //아니면서 만약에 10>=10이면
else{console.log("[false] 10이 10미만이다.")} //그외
//vs 삼항연산자.
10>=20 ? console.log('[true1] 10이 20보다 크다.') :
	 10 >= 15 ? console.log('[true2] 10이 15보다 크다.'):
	 	10>= 10 ? console.log('[true3] 10이 10보다 이상이다..') : console.log("[false] 10이 10미만이다.");
	 	
	 	
/*
	1. prompt 로 정수 1개 입력받아 90이상이면 합격 아니면 탈락 출력
	2. prompt 로 성별을 입력받아 'M' 또는 '남' 또는 '남자' 또는 'm' 일 경우 '남자 이군요' 출력
							'W' 또는 '여' 또는 '여자' 또는 'w' 일 경우 '남자 이군요' 출력
							그 외 '남자 : m, M, 남, 남자 여자 : W, w, 여, 여자로 입력해주세요.' 출력
	
	3.prompt 로 정수 1개 입력받아
			90점 이상 : A
			80점 이상 : B
			70점 이상 : C
			그외 : '탈락'
			
	
			


 */

 //1. 
 let value1 = Number(prompt("점수를 입력해주세요."));
 if(value1 >= 90 ){console.log("합격")}
 else{console.log("탈락")}
 
//2.
let value2 = prompt("성별을 입력해주세요.");
if(value2 == '남'|| value2 == 'm' || value2 == '남자' || value2 == 'M'){
	 console.log("남자이군요.")
}
else if(value2 == '여'|| value2 == 'W' || value2 == '여자' || value2 == 'w'){
	 console.log("여자이군요.")
}
else{
	console.log('남자 : m, M, 남, 남자 / 여자 : W, w, 여, 여자로 입력해주세요.');
}


//3.
let value3 = Number(prompt("점수를 입력해주세요."));
if(value3 >= 90){
	 console.log("A")
}
else if(value3 >= 80){
	 console.log("B.")
}
else if(value3 >= 70){
	 console.log("C")
}
else{
	console.log("탈락")
}


