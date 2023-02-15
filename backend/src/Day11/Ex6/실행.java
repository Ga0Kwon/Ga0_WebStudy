package Day11.Ex6;

public class 실행 {
	public static void main(String[] args) {
		Tire tire = new Tire();
		
		//1. 자동차 객체 만들기
		Car myCar = new Car();
		//자동차 객체에 타이어 객체 1개 포함
		//2. 기본 타이어 장착
		myCar.tire = new Tire();
		myCar.run();
		
		Tire result = myCar.parking(tire);
		result.roll();
		
//		myCar.parking(myCar.tire);
		
		//3. 한국 타이어 교체
		myCar.tire = new HankookTire();
		myCar.run();
		
//		tire = myCar.tire;
//		myCar.parking(tire);
		
		HankookTire hankookTire = new HankookTire();
		/*parking함수의 매개변수(인수,인자)값이 타입이 Tire이다.
		 * 따라서, 강제타입 변환을 하지않으면 Tire의 자식 클래스인 HankookTire로 바꿀 수 없다.*/
		HankookTire result1 = (HankookTire)myCar.parking(hankookTire);
		System.out.println(result1 instanceof Tire); //상속받았는지 result1이 Tire에게
		System.out.println(tire instanceof Object);//상속받았는지 Tire이 Object에게
		System.out.println(result1 instanceof Object); //상속받았는지 result1이 Object에게
		result1.roll();
		
//		myCar.parking(myCar.tire);
		
		//4.금호 타이어 교체
		myCar.tire = new KumhoTire();
		myCar.run();
		
//		tire = myCar.tire;
//		myCar.parking(tire);
		
		myCar.parking(myCar.tire);
	}
}
