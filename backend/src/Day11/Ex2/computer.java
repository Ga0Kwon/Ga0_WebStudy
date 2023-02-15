package Day11.Ex2;

public class computer extends Calculator{
	//오버라이딩 : 부모 클래스의 메소드를 재정의
	@Override //생략 가능[이클립스에서 제공] @ : 메타데이터
	public double araCircle(double r) {
		System.out.println("자식 객체 재 정의");
		return Math.PI*r*r;
	}
}
