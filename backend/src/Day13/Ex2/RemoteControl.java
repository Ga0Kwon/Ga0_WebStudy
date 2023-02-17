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
	
	//1. 
	public abstract void turnOn(); // { } 없다.
	void turnOff(); //public abstract 생략 가능
	void setVolume(int volume);
}
