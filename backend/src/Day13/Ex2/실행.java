package Day13.Ex2;

public class 실행 {
	public static void main(String[] args) {
		
		System.out.println("리모콘 최대 볼륨 : " +RemoteControl.MAX_VOLUME);
		System.out.println("리모콘 최소 볼륨 : " +RemoteControl.MIN_VOLUME);
		
		//1. 인터페이스 변수 선언
		RemoteControl rc;
		
		//2. 인터페이스[리모콘]에 텔레비전[구현객체]연결
		rc = new Televsion();
		
		//3. 인터페이스[리모콘]에 기능[메소드] 사용
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		//2. 인터페이스[리모콘]에 오디오[구현객체]연결
		rc = new Audio();
		
		//3. 인터페이스[리모콘]에 기능[메소드] 사용
		rc.turnOn();
		rc.setVolume(11);
		rc.turnOff();
		
	}
}
