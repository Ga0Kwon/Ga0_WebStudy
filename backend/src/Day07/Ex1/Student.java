package Day07.Ex1; //현재 클래스가 위치한 패키지명

public class Student {//class s [클래스는 첫글자 대문자]
	
	//필드[저장소], 생성자[객체초기화], 메소드[구성] 구성
	//- 생성자 생략시 기본생성자 자동 Student() => Object 상속으로 인해
	
}//class e

/*
  객체(object) : 식별 가능한 형태 [상태 = 필드, 행동 = 메소드/함수]
  객체지향프로그래밍[OOP] : 부품[객체]를 먼저 만들고 부품[객체]들을 조립해서 하나의 제품[프로그램]을 생성
  
  클래스 : 설계도[객체의 설계도]
  		인스턴스화(new 연산자)
  		
  인스턴스 : [메모리 관점] 
  객체 : [추상적] 
  
  변수, 인스턴스, 객체
  스택영역에서 선언된 것은 모두 변수
  힙영역에 있는 것은 인스턴스[실체 존재하는 것이 메모리가 생겼다는 것 = 즉, 인스턴스] => 구현이 되었다는 것은 메모리가 있다!
  인스턴스화할 대상을 객체이다. [인스턴스화 하기 전이 객체] => 구현 하고자하는 대상을 객체라고 함.
  JVM 관점
  	  [스택영역]    =    [힙영역]  
  	클래스명 변수명   =   new 생성자();
  	String str    =   new String("유재석");
  		   <------주소------
  	new : 메모리를 만들고 주소를 넘기는 역할을 함.[인스턴스화 시키는 것]
  	
  	ex.) String str = new String("유재석"); => 객체
  		 String str => 변수
  		 new String("유재석"); => 인스턴스
  
 */
