package Day15.Ex9_MVC;

import Day15.Ex9_MVC.view.Front;

public class Start {
	public static void main(String[] args) {
		Front.getInstance().index();
	}
}

/*
 	new : 메모리 할당
 
  내부에서 메소드[멤버] 호출 방법
  
  	1. 메소드명();
  	
  외부에서 메소드[멤버] 호출 방법
  
  	1. 인스턴스 메소드 [new -> 힙]
  		클래스명 객체명 = new 생성자(); -- 변수명이 존재하기 때문에 재호출 가능
  		객체.메소드명(); 
  			vs.
  		new 생성자().메소드명(); -- 단발성
  		
	2. 정적[static] 메소드
		클래스명.메소드명();
		
	3.싱글톤내 메소드 호출 [new -> 힙]
		클래스명.get싱글톤.메소드명();
	
	싱글톤은 내부에서 new를 한다.
		
		 			JVM
		   [현재 사용중인 메모리[클래스] : 컴파일한 파일과 + import 클래스]
		   
	메소드 영역                               스택 영역                       힙 영역
		전역에서 사용						  기본 자료형 데이터
										  힙 주소 저장
		: 클래스 멤버 정보  					  클래스명 객체명 			=		new 생성자();
		: static 멤버 정보													new 생성자().메소드명();
			- 정적 메소드
		public static void index()
		클래스명.메소드명()
			- 정적 필드
		static 타입 필드명
		static View view										= 		new View(); => new는 무조건 힙
*/
