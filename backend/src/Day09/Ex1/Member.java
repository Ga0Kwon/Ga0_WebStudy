package Day09.Ex1;
/*
  클래스 사용 용도
  1. 라이브러리 : 다른 클래스로부터 사용되는 클래스
  		협업에서 사용되는 디자인 패턴 : MVC
  		
  2. 실행클래스 : main 함수 가지고 있는 클래스
  
  JVM
  	메소드 영역                vs.             스택영역                   vs.                힙영역
  	  String                          String name ; -- 변수
  	                                  String name ; -- 변수                     = new String("유재석");
  	  클래스                                  지역변수                                      객체
  	
  
  
  지역 변수             vs              필드
   메소드 {} 선언                         클래스 {} 선언
   메소드 실행시 존재                       객체 생성시 존재
   메소드 {}에서만 사용                     객체 내*외부에서 사용
   
  필드는 객체 생성시 초기화를 자동으로 해주고,
  로컬변수[지역변수]는 초기화를 자동으로 해주지 X
     -> 즉, 로컬[지역]변수는 초기화를 직접 해줘야 함
    
  필드 : 객체의 데이터 저장하는 곳 [지역 변수와 비슷하지만 사용되는 목적 다르다.]
  
  필드 사용
  	객체 내부 : 생성자, 메소드
  	객체 외부 : 객체명.필드명
  
 */
public class Member {//class s
	//클래스 멤버
		//1. 필드
	/*
	   정수의 초기값은 0
  	   실수의 초기값은 0.0
       논리의 초기값은 false
       배열, 객체 문자열, 인터페이스의 초기값은 null 
	 */
	String name; //null
	int num; //0
	double num2; //0.0
	boolean check; //false
	String[] array = new String[3]; //null null null
	
	
		//2. 생성자
	
		//3. 메소드
	void setName() {
		String inputName; //로컬 변수[String은 로컬변수이면서 객체이다.]
		System.out.println(name);
//		System.out.println(inputName); -> 초기화를 안해서 에러
	}
	
	void getName() {
		
	}
}//class e
