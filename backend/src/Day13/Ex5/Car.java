package Day13.Ex5;

public class Car {
	//타입 : 인터페이스 [해당 인터페이스를 구현한 클래스들의 구현객체를 여러개 대입]
	//필드
	Tire tire1 = new HankookTire();
	Tire tire2 = new HankookTire();

	//메소드
	void run() {
		tire1.roll();
		tire2.roll();
	}
}