package Day13.Ex2;

public interface RemoteControl {
	//상수 필드 [인터페이스는 변수 X -> 1. 인스턴스필드(객체 있어야 쓸 수 있는) 2. 정적멤버(객체 없어도 쓸 수 있는)]
		// 인터페이스는 new 연산자를 사용하지 X -> 생성자가 없다는 것! -> 인스턴스 X -> static밖에 못쓴다는 것.
		// 상수 : public static final : java에서 상수 //고정된 값o => 초기값 필수 : 변수 선언시 값 대입
		// 인터페이스에서는 생략
	public static final int MAX_VOLUME = 10; //상수는 무조건 대문자.
	int MIN_VOLUME = 0; //자동으로 상수(public static final)가 자동으로 붙음
	
	// 추상 메소드
		// 리턴 타입, 메소드명, 매개변수만 선언
		// { } 선언 안한다.
		//public abstract 생략시 자동으로 들어감
		//해당 클래스들이 implements 했을때 -> 오버라이딩 필수!
	
	//1. 
	public abstract void turnOn(); // { } 없다.
	void turnOff(); //public abstract 생략 가능
	void setVolume(int volume);
	
	//디폴트 메소드
		//클래스에서 사용하는 메소드 동일
		//선언부 앞에 default 선언
	
	//이 디폴트 메소드는 구현클래스가 구현하지 않아도 에러X 
	// 해당 클래스들이 implements 했을 때 -> 오버라이딩 필수X
	
	//2.[일반 함수와 동일]
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리합니다.");
			setVolume(0);
		}else {
			System.out.println("무음 해제합니다.");
		}
	}
	
	//정적 메소드
		//구현 객체가 필요없다. -> implements 없이 사용
		//해당 클래스들이 implements 안하고 사용.
		//static 선언
	//3.
	static void changeBattery() {
		System.out.println("리모콘 건전지를 교환합니다.");
	}
}
