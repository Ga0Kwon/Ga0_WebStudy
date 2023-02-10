package Day08.Ex1;
//2. 클래스의 설계 목적

//클래스 선언
	// 1. 첫글자 대문자인 영문 시작
	// 2. 띄어쓰기X, 숫자로 시작X
	// 3. 멤버 : 1) 필드 2) 생성자 3) 메소드

public class Car {//class s
	
	//1. 필드
	String model;
	String color;
	int maxSpeed;
	
	//2. 생성자
		//1) 생성자가 1개도 선언이 없을 때 기본 생성자
		//2) 생성자 이름은 클래스명과 동일!! 다르면 함수[메소드]가 된다
		//3) 기본 생성자[깡통] , 풀생성자 -> 관례적으로 만들고 시작
		//4) 오버로딩 : 이름이 동일할 경우 시그니처(매개변수 개수, 타입[유형])을 구분해서 식별 가능
			// vs. 오버라이딩 : 부모의 메소드를 재정의(리모델링)
	
	// 빈생성자 -> 객체 생성시 매개변수가 없다 -> 초기값!
	Car(){}
	
	// 생성자 -> 2개의 매개변수를 받는다.
	Car(String model, String color){
		//클래스 입장에서 this.model 즉, 필드 model은 내부이고
		//매개변수로 받은 model은 외부이다.
		//즉, 내부를 의미하는 this.를 쓴다. [식별[구분]해야하기 때문]
		// this를 쓸 것이냐, 매개변수의 이름을 필드와 다르게 작성할 것인가? => this를 권장
		this.model = model; //this.내부필드명 = 매개변수;
		this.color = color;
	}
		
	// 생성자 -> 3개의 매개변수를 받는다.
	Car(String model, String color, int maxSpeed ){
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	//3. 메소드
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "model = " + model +" color = "+ color +" maxSpeed = "+ maxSpeed;
		}
}//class e
