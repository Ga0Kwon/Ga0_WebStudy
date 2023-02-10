package Day08.Ex3;

public class Car {
	//1. 필드
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	//2. 생성자
		// 오른쪽 클릭 -> souuce -> Generate Contstuctor using Fields -> 필드 선택
	
	//1) 생성자 : 빈 생성자 매개변수 없다
	public Car() {
		
	}
	
	// 2) 생성자 : 1개의 매개변수
	public Car(String model) {
		this.model = model;
	}

	// 3) 생성자 : 2개의 매개변수
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	// 4) 생성자 : 3개의 매개변수
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	
	//5) 생성자 : 모든 필드  매개변수
	public Car(String company, String model, String color, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	//3 메소드
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxSpeed=" + maxSpeed + "]";
	}
	
	
	
}
