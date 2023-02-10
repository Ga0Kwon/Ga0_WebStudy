package Day08.Ex4;

public class Calculator {
	//1. 필드
	//2. 생성자
	//3. 메소드
	
		//1) 반환x 인수x
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
		//2) 반환x 인수x
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	
		//3) 인수 : x, y / 반환 int
	int plus(int x, int y) {
		return x+y;
	}
	
	int minus(int x, int y) {
		if(x >= y) {
			return x-y;
		}else {
			return y-x;
		}
	}
	
		//4) 인수 : x, y / 반환 : double
	double divide(int x, int y) {
		return (double)x/(double)y; 
	}
		//5) 인수 x, y / 반환 x
	void multiply(int x, int y) {
		double result = (double)x * (double)y;
		System.out.println(result);
	}
	
		//6) 반환 : String 인수는 X
	String info() {
		return "이젠컴퓨터 계산기";
	}
	
		//7) 내부에서 함수호출
	void 함수호출() {
		plus(1, 2); //=> 함수호출! [내부에서 함수 호출 시 : 함수명();]
	}
	
	
	
}

/*
  함수 = 메소드
  - js 선언부
  function 함수명(인수명){ }  
  
  - js 호출 
  함수명 (인수1, 인수2)
  
  - java 선언부
  리턴타입 함수명(인수1, 인수2){ }
  
  - java 내부 호출
  함수명(인수1, 인수2);
  
  - java 외부 호출 [ 객체명 필요 ]
  객체명.함수명(인수1, 인수2); => 다른 객체의 것을 사용할 경우
  
  
  1) 인수 x 반환 x
  	void 함수명(){}
  	
  2) 인수 o, 인수 x
  	void 함수명(인수1, 인수2){}
  	
  3) 인수x 반환 o
  	리턴타입 함수명( return 반환값;}
  	
  4) 인수 o 반환 o
  	리턴타입 함수명(인수1, 인수2){return 반환값;}
 */
 