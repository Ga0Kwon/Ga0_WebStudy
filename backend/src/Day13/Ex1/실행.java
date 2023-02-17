package Day13.Ex1;

public class 실행 {
	public static void main(String[] args) {
		//1. 인터페이스를 사용하는 구현 객체
			//1) 인터페이스는 타입이므로 변수처럼 사용 가능
			//2) 참조하지 않고 있는 변수는 null 대입
		RemoteControl control1 = null;
		
			//3) 해당 인터페이스를 implements 선언한 객체의 주소 대입 O
		RemoteControl control2 = new Television();
		
			//4) 해당 인터페이스를 implements 선언하지 않는 객체의 주소 대입 X
//		RemoteControl control3 = new Radio(); -> 구현하지 않아서 할 수 없다.
		
		// 2. 구현 객체 만들기 
		RemoteControl rc; //1) 인터페이스 변수 선언 [ 스택 영역 변수 선언 ]
		rc = new Television(); 
		
//		= RemoteControl rc = new Television();
		
			// new Television(); [힙 영역에 객체 선언하고 주소를 반환]
			// 반환된 주소를 'rc' 스택 영역의 변수 대입
		
		//3. 구현객체를 이용한 메소드 실행
		rc.turnOn(); 
		
		//스택 없이 사용 힙영역에 객체 선언하고 바로 사용 -> 하지만 이름이 없기 때문에 재사용 X 
		new Television().turnOn(); //변수 이름은 스택에 들어감! [ 한번 쓸때는 이거 사용하면 됨 ]
		
		//4. 리모콘 교체 
		rc = new Audio();
		rc.turnOn();
		
		new Audio().turnOn();
	}
}
