package Day02; //현재 class(클래스)가 존재하는 패키지

// ! : 자바는 무조건 class 단위!
	// 자바를 100% 객체지향을 만들려고!
	// 클래스 기반으로 메모리가 할당 : 객체
	// 클래스 : 객체 설계도
public class Ex1_출력 { //class s
	
	/* int a = 10; */ //코드는 칠 수 있지만, 실행되는 코드는 main함수안에 있어야한다.
	//main 함수에 main 스레드를 가지고 있기 때문, main()밖에 있는 것은 변수 선언해서 사용하는 것도(main함수안에서 변수를 호출) 불가능
	public static void main(String[] args) { //main s
		//1. syso + ctrl + spacebar -> 자동완성
		System.out.println();
			//System : 시스템 클래스 [ 관련 메소드 제공]
				//out : 출력 vs in : 입력
					//println() : 출력후 자동 줄 바꿈 처리 [js : console.log() 역할]
					//print() : 출력만
					//printf() : 형식 출력
		
		//1) print() : 줄바꿈 처리가 안됨.
		System.out.print("프린트함수1");
		System.out.print("프린트함수2");
		
		//2) println() : 줄바꿈 처리 O
		System.out.println("프린트함수1"); //출력후 \n
		System.out.println("프린트함수2");
		
		//3) printf() 
		int value = 123;
		System.out.printf("상품 가격 : %d원\n", value); //해당 정수를 출력한다.
		System.out.printf("상품 가격 : %6d원\n", value); //6자리 정수이고, 왼쪽 빈자리 공백을 둔다
		System.out.printf("상품 가격 : %-6d원\n", value); //6자리 정수이고, 오른쪽 빈자리 공백을 둔다
		System.out.printf("상품 가격 : %06d원\n", value);  //6자리 정수이고 왼쪽의 빈자리를 0으로 채운다
		
		double area = 3.141592*10 *10;
		System.out.printf("반지름이 %d이고 넓이가 %10.2f인 원\n", 10, area); //10.2면 10-2 = 8-1 즉, 정수 7자리 소수점 2자리의 실수이면서 왼쪽 자리 공백
		System.out.printf("반지름이 %d이고 넓이가 %-10.2f인 원\n", 10, area);//10.2면 10-2 = 8-1 즉, 정수 7자리 소수점 2자리의 실수이면서 오른쪽 빈자리 공백
		System.out.printf("반지름이 %d이고 넓이가 %010.2f인 원\n", 10, area);//10.2면 10-2 = 8-1 즉, 정수 7자리 소수점 2자리의 실수이면서 왼쪽의 빈자리를 0을 채움
		
		String name = "가나다";
		String job = "학생";
		String hobby = "그림그리기";
		System.out.printf("%6s | %-10s | %10s | %s\n", "번호", "이름", "직업", "취미");
		//%s : 문자열
		//%10s : 10자리 문자열이고, 왼쪽 빈자리 공백
		//%-10s : 10자리 문자열이고, 오른쪽 빈자리 공백
		System.out.printf("%6d | %-10s | %10s | %s\n", 1, name, job, hobby); 
	}//main e
}//class e

/*
  String : 문자열 클래스 
  System : 시스템 클래스
  
  제어문자/이스케이프 문자
  	\n : 줄바꿈
  	\t : 들여쓰기
  	\" : 큰 따옴표 출력
  	\' : 작은 따옴표 출력
  그외 특수문자 
  	%% : % 출력
  	
  	 
  
 */