package Day09.Ex5;

/*
  객체 내부 멤버 호출시 this
  	*다른 변수/메소드/생성자의 이름과 식별하기 위해 사용한다.
  	1. 내부 필드 호출 this.필드명
  	2. 내부 함수 호출 this.함수명
  	3. 내부 생성자 호출  this()
  
  
 */
public class Car {//class s
	//인스턴스 멤버
	//1. 필드
	String model;
	int speed;
	
	//2. 생성자
	Car(String model){ //model : 매개변수 => 매개변수 필드명이랑 맞추는 게 좋음!
		this.model = model;
		//멤버필드 = 매개변수
	}
	
	//3. 메소드	
	void setSpeed(int speed) {
		this.speed = speed;
		//멤버필드 = 매개변수
	}
	
	void run() {
		this.setSpeed(100);
		//본인꺼 불러옴.
		System.out.println(this.model + "가 달립니다. 시속 : " +this.speed);
	}
	
}//class e
