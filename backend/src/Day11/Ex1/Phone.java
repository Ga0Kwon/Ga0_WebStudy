package Day11.Ex1;

public class Phone {
	//클래스 멤버
		//1. 인스턴스 멤버 : 객체를 이용한 멤버 사용
			// 클래스 객체명 = new 생성자() --> 객체명.멤버	
		//2. 정적 멤버[static] : 객체 없이 이용하는 멤버
			//클래스명.멤버
	
		//지역변수는 외부에서 호출할 수 없으나, 필드는 외부에서 호출 가능
	
	//1. 멤버 종류
		//1) 필드 : 객체의 데이터를 저장하는 곳
			// 접근제한자(static/final) 타입 변수명;
	public String model;
	public String color;
		//2) 생성자 : 객체 생성시 초기화 담당[지역변수]
			// 접근제한자 클래스명(매개변수1, 매개변수){ } 
	
		//3) 메소드 : 객체의 행위 [지역변수]
			// 접근제한자 반환타입 메소드명(매개변수1, 매개변수2){ }
	
	public void bell() {//모든 곳에서 호출 가능한 함수, 매개변수x 리턴x
		System.out.println("벨이 울립니다.");
	}
	
	public void sendVoice(String message) {
		System.out.println("자기 : " + message);
	}
	
	public void receiveVoice(String message) {
		System.out.println("상대방 : " + message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊습니다.");
	}
	// 2. 멤버 접근제한자
		// public : 모든 곳에서 호출 가능
		// private : 해당 클래스에서만 사용 가능
		// default : 동일한 패키지내에서만 호출 가능[생략되었을 때 기본적으로 들어가는 것] 
		// protected : 동일한 패키지내에서만 호출 가능 [*자식은 예외]
}
