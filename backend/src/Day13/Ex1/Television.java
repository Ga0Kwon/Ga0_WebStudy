package Day13.Ex1;

public class Television implements RemoteControl{
	//클래스명 implements 인터페이스명: 구현[추상적인 것을 구체적인 것으로 만듬]하다.
		//인터페이스 안에 추상된 메소드를 해당 클래스가 구현하겠다!
		//필수 작업 : 추상 메소드 구현해야함! @Override
		// 상속은 메소드 구현 해도 되고 안해도 되지만, 인터페이스는 필수다.
		// Television : 구현 객체
	
	//1. 인터페이스 추상 메소드를 구현
	@Override
	public void turnOn() {
		System.out.println("TV를 켭니다.");
		
	}
	
	
}
