package Day11.Ex1;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//phone 객체
		Phone phone = new Phone();
		// phone 객체의 인스턴스멤버 호출
		phone.color = "빨강";
		System.out.println(phone.color);
		phone.bell();
		phone.receiveVoice("안녕하세요.");
		
		// phone 클래스는 smartPhone 멤버 호출 
		// phone.wifi; 
		// * 부모객체는 자식클래스의 멤버 호출 할수 없다.
		
		SmartPhone smartPhone = new SmartPhone();
		//  smartphone 클래스는 phone 멤버 호출 
		// * 자식객체는 부모클래스의 멤버 호출 할수 있다.
		smartPhone.color = "은색";
		System.out.println(smartPhone.color);
		smartPhone.bell();
		smartPhone.receiveVoice("안녕하세요. 스마트폰");
		
		//자식클래스로 객체 만들기
		SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
		
		// 자식클래스로 부모클래스의 멤버 호출
		System.out.println("모델 : " + myPhone.model);
		System.out.println("색상 : " + myPhone.color);
		
		//자식 클래스가 본인 멤버 호출
		System.out.println("와이파이 상태 :" + myPhone.wifi);
		
		//자식 클래스로 부모클래스의 멤버 호출
		myPhone.bell();
		myPhone.sendVoice("여보세요.");
		myPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		myPhone.sendVoice("와~ 반갑습니다.");
		
		//자식 클래스 본인 멤버 호출
		myPhone.setWifi(true);
		myPhone.internet();
	}//main e
}//class e

/*
  	자동 완성 메뉴
  		필드 : 필드명, 자료형, 클래스명
  		메소드 : 함수명(매개변수), 반환타입, 클래스명
 */
