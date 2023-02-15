package Day11.Ex1;

public class SmartPhone extends Phone{//class s
	//자식클래스명 extends 부모클래스
	//부모클래스명 멤버들을 자식클래스가 사용할 수 있다.
	
	//1. 필드
	public boolean wifi;
	
	//2. 생성자
		//=> 부모에 기본 생성자 없이, 인수두개받는 생성자만 있다 가정하면,
		// 자식의 생성자들에 에러가 생긴다.
		//=> 부모 생성자에 기본 생성자가 없으면, 자식 생성자에 super을 쓰지 못한다.
		//모든 객체는 생성자를 호출해야만 생성 -> 부모 객체의 생성자는 어디서 호출?
		//=>자식클래스의 super()[생략가능]에 의해 호출 
	public SmartPhone() {
		
	}

	public SmartPhone(String model, String color) {
//		super(); //생략가능 -> 컴파일시 자동 추가
		this.model = model;
		this.color = color;
	}
	
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("와이파이 상태를 변경했습니다.");
	}
	
	public void internet() {
		System.out.println("인터넷에 연결합니다.");
	}
	
}//class e
