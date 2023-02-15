package Day11.Ex3;

public class SportsCar extends Car{
	@Override
	public void speedUp() {
		// TODO Auto-generated method stub
		super.speedUp(); //부모 함수 호출
	}
	
	//부모 클래스에서 final이 있는 메소드는 오버라이딩이 안된다.
//	@Override
//	public void stop() {
//		super.stop();
//	}
}
