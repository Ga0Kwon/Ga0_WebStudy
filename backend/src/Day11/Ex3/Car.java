package Day11.Ex3;

public class Car {
	public int speed;
	
	public void speedUp() {
		speed++;
	}
	
	// final : 오버라이딩 불가능 함수 만들기
	public final void stop() {
		System.out.println("차가 멈춥니다.");
		speed = 0;
	}
}
