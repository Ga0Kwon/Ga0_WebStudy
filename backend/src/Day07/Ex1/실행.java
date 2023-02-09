package Day07.Ex1; //현재 클래스가 위치한 패키지명

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 클래스 이용한 객체 만들기
		//클래스명 변수명 = new 생성자();
			// = new (인스턴스화 : 힙영역에 메모리를 생성후 주소를 반환)
			// 생성자() : 생성할때 사용하는 함수 : 객체 생성시 사용되는 매소드
		
		/* 
		   객체를 어떻게 생성[생성자]하고 
		   객체가 가져야 할 데이터[필드] 무엇이고
		   객체의 동작[메소드]은 무엇인가 정의
		*/	
		
		Student student = new Student();
		Student student2 = new Student();
		
		System.out.println(student);
		System.out.println(student2);
	}//main e
}//class e
