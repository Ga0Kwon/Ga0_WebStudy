package Day07.Ex2;
/*클래스는 두가지 사용목적 : 2. 실행(main 함수)*/
public class 실행 {//class s
	public static void main(String[] args) {//main s
		// 1. 클래스를 이용한 객체 생성
		Car myCar = new Car(); //ex. 32번지에 메모리생성
		//클래스명  변수명 = new 생성자명();
		
		//2. 객체의 필드 호출 [. : 접근 연산자]
		System.out.println("모델명 : " +myCar.model);
		System.out.println("시동여부 : " +myCar.start);
		System.out.println("현재속도 : " +myCar.spped);
		
		//3. [설계는 같지만 객체는 다르다.]
		Car yourCar = new Car(); //ex. 33번지에 메모리생성
		
		yourCar.model = "현대자동차";
		yourCar.spped = 60;
		yourCar.start = true;
		
		//2. 객체의 필드 호출 [. : 접근 연산자]
		System.out.println("yourCar 모델명 : " +yourCar.model);
		System.out.println("myCar 모델명 : " +myCar.model);
		
		System.out.println("yourCar 시동여부 : " +yourCar.start);
		System.out.println("myCar 시동여부 : " +myCar.start);
		
		System.out.println("yourCar 현재속도 : " +yourCar.spped);
		System.out.println("myCar 현재속도 : " +myCar.spped);
	}//main e
}//class e
