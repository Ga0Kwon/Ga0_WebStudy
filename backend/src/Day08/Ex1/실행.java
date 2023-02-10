package Day08.Ex1;
//1. 클래스 실행 목적 : main 함수 가지고 있는 클래스
public class 실행 { //class s
	public static void main(String[] args) {//main s
		//1. Car 클래스를 이용한 객체 생성
		// 클래스명 변수명 = new 생성자명();
		
		/*
		  Car(String 인수1, String 인수2, int 인수3 ){} : Car.java에 이걸 생성하니 
		  Car car = new Car(); => 빨간 줄이 생김.
		  생성자 선언을 했을 때 기본 생성자를 새로 또 만들어줘여한다. 
		  하나도 없으면 Car 기본 생성자 만들지만, 하나라도 있으면 기본생성자 생성X
		 */
		
		//1) 기본 생성자
		Car car = new Car(); 
		System.out.println(car.toString());
		
		//2) 2개 매개변수 생성자
		Car car2 = new Car("그랜저", "검정");
//		car.color = "검정"; car.model = "그랜저"; => 같은 결과값 
		// 다이렉트 vs. 간접적
		// 관례적으로 생성자를 사용 -> 캡슐화해야하기 때문! => 필드를 숨겨야하기 때문에[은닉화]
		// 직접 접근은 쓰지 않음. => 간접적으로 쓰면 필터링[즉, 조건문]도 추가할 수 있기 때문에
		// 유효성 검사가 필요하면 생성자 필수! -> 그냥 생성자를 쓰는게 좋다.
		System.out.println(car2.toString());
		
		//3) 3개 매개변수 생성자
		Car car3 = new Car("그랜저", "검정", 250);
		System.out.println(car3.toString());
		
		
	}//main e
}//class e
