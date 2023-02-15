package Day11.Ex2;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//
		int r = 10;
		
		//1. 부모 객체
		Calculator calculator = new Calculator();
		System.out.println(calculator.araCircle(r));
		
		//2. 자식 객체
		computer computer = new computer();
		System.out.println(computer.araCircle(r));
	}//main e
}//class e
