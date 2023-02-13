package Day09.Ex3;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		
		//1. 객체 생성
			//1) 객체의 필드를 초기화 하는 방법
				//1> 필드 [직접 => 잘 안씀]
		Car car = new Car();
		car.gas = 6;
		
				//2> 생성자 [간접] : 객체의 필수 데이터
		Car myCar = new Car(6);
		
				//3> 메소드[간접] : 객체 생성후 데이터
		Car yourCar = new Car();
		yourCar.setGas(6);
		
		if(yourCar.isLetfGas()) {
			System.out.println("출발합니다.");
			yourCar.run();
		}
		
		System.out.println("가스를 주입하세요.");
		
		
	}//main e
}//class e
