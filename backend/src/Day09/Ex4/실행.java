package Day09.Ex4;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		계산기 my계산기 = new 계산기();
		
		double result1 = my계산기.areaRectangle(10);
		double result2 = my계산기.areaRectangle(10, 20);
		
		System.out.println(result1);
		System.out.println(result2);
	}//main e
}//class e
