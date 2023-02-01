package Day01; //패키지 명 

/*변수*/
public class Ex2_변수 { //class s
	//main 함수 : 코드를 읽어주는 역할함수[m + ctrl + 스페이스바]
	public static void main(String[] args) { //main s
		
		/*변수가 초기화되지 않은 경우 에러가 난다.*/
		/*
		 * int value; //변수 선언 : 자료형[타입] 변수명 
		 * 초기화 되지 않은 변수는 사용 불가
		 * System.out.println(value); // syso + ctrl +스페이스바
		 * 
		 * int result = value + 10;
		 * System.out.println(result);
		 */		
		
		int hour = 3; //변수 선언 : int형 자료형 변수에 'hour'이라는 이름으로 3 저장
		int minute = 5; //변수 선언 : int형 자료형 변수에 'minute' 이름으로 5 저장
		
		System.out.println(hour+ "시간"+ minute + "분");
		
		int totalMinute =  hour*60 + minute;
		System.out.println("총" + totalMinute + "분");
		
		int x = 3;
		int y = 5;
		System.out.println("[스왑전] x : " + x + " y : " + y);
		
		int temp = x;
		x = y;
		y = temp;
		System.out.println("[스왑후] x : " + x + " y : " + y);
		
		
	}//main e
} //class e

/*
  
  변수 : 데이터 1개를 저장할 수 있는 메모리 공간
  	1.자료형
  	2.변수명
  	3.초기값
  	4. 값
  	- 변수 선언
  	자료형 변수명 = 초기값; : 값이 존재하기 때문에 사용가능
  	자료형 변수명;   :값이 존재하지 않기때문에 사용불가능
  	
  	-변수 호출
  		변수명; 
  	
  java : 자료형/타입 직접 선언
  	int 변수명 = 19;
  	char 변수명 = 'A';
  		
  		vs
  		
  JS : 자료형/타입 자동 관리
  	let 변수명 = 10;
  	let 변수명 = A;
  
  
 	
 */