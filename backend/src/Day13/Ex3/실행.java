package Day13.Ex3;

public class 실행 {
	public static void main(String[] args) {
		//1. 구현 객체
		//RemoteControl 인터페이스 변수 선언 및 구현 객체 대입
		RemoteControl rc = new SmartTelevision();
		
		//RemoteControl 인터페이스에 선언된 추상 메소드만 호출 가능
		//현재 타입이 RemoteControl이기 때문에 Searchable을 쓸 수 없다.
		
		//but, RemoteControl이 Searchable로부터 상속을 받는다면
		//rc.search("https://www.youtube.com"); 이 가능해진다.
		
		rc.turnOn();
		rc.turnOff();
		
		//Searchable 인터페이스 변수 선언 및 구현 객체 대입
		Searchable searchable = new SmartTelevision();
		//Searchable 인터페이스에 선언된 추상 메소드만 호출 가능
		searchable.search("https://www.youtube.com");
		
		
	
	}
}
