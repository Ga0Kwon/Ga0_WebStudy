package Day09.Ex6;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 인스턴스 멤버 호출
			//객체 -> 인스턴스멤버 호출
		Calculator mycal = new Calculator();
		System.out.println(mycal.no);
		System.out.println(mycal.getNo());
		
		//2. 정적 멤버 호출
		System.out.println(Calculator.pi);
		double result1 = 10*10*Calculator.pi;
		System.out.println(result1);
		System.out.println(Calculator.plus(10, 5));
		System.out.println(Calculator.minus(10, 5));
		
		System.out.println(Calculator.info);
		
	}//main e
}//class e
