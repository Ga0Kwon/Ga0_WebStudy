package Day08.Ex4;

public class 실행 { //class s
	public static void main(String[] args) {//main s
		
//		powerOn(); //=> 메모리할당 전임으로 에러!
		
		// 외부에 있는 객체 Calculator을 쓰려면!
		// 객체를 생성안하면 Calculator의 메소드는 설계도일 뿐이고, 사용할 수 X
		// 객체가 메모리에 들어와야 생성하는것
		//1.외부에서 함수 호출 -> 객체 필요
		Calculator calculator = new Calculator();
		
		//2. 객체를 통한 멤버 함수 호출
		calculator.powerOn();
		
		
		int plusResult = calculator.plus(2, 5);
		System.out.println("더한 값 : " + plusResult);
		
		int minusResult = calculator.minus(6, 5);
		System.out.println("차이 값 : " + minusResult);
		
		double divideResult = calculator.divide(3, 5);
		System.out.println("나눈 값 : " + divideResult);
		
		calculator.multiply(10, 9);
		
		System.out.print(calculator.info()+ " ");
		calculator.powerOff();
		
	}//main e
}//class e
