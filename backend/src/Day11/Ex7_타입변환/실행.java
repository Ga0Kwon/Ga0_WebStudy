package Day11.Ex7_타입변환;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 기본타입의 자동타입 변환
		byte value1 = 10;
		short value2 = value1;
		int value3 = value2;
		long value4 = value3;
		float value5 = value4;
		double value6 = value5;
		
		//2. 기본타입의 강제타입 변환 ---> 캐스팅( )
		double vlaue7 = 10.111;
		float value8 = (float)vlaue7;
		long value9 = (long)value8;
		int value10 = (int)value9;
		short value11 = (short)value10;
		byte value12 = (byte)value11;
		
		//3.매개변수, 리턴타입
		//자동 타입 변환 byte --> double
		//리턴 타입 자동 변환 int ---> double
		double result = 함수1(value1); 
		//value3은 int => 강제 타입 변환 필요!!
		//함수2의 리턴타입도 double이여서 byte 변수에 리턴[double]값을 저장하려면,,,
		//넣는 데이터값에 캐스팅(강제 타입변환)을 해주어야한다.
		byte result2 = (byte)함수2((byte)value3);
		
		
		//4.배열
		double[]배열 = new double[3];
		배열[0] = 3.3; 배열[1] = 3;
		
	}//main e
	
	public static int 함수1(double 매개변수) {
		return 3;
	}
	
	 public static double 함수2(byte 매개변수) {
		 return 3;
	 }
}//class e

/*
  타입 종류
  	1. 기본 타입 - 스택 저장
  		boolean, char, byte, short, int, long, float, double
	
	2. 참조 타입 - 힙 저장 -> 힙 주소를 스택에 저장
		배열, 클래스[ex)String], 인터페이스
		
	타입 변환
		1. 자동타입 변환
			
		2. 강제타입 변환
  			
 */
 