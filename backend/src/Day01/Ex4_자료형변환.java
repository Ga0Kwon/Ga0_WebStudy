package Day01;

public class Ex4_자료형변환 { //class s
	public static void main(String[] args) {//main s
		
		//1. 자동 타입 변환 [작은 타입 -> 큰 타입]
		byte b1 = 10; int il = b1; //byte ---> int 가능
		char c1 = '가'; int i2 = c1; //char ----> int 가능
		int i3 = 50; long l1 = i3; //int ----> long 가능
		long l2 = 1000; float f1 = l2; //long -----> float 가능
		float f2 = 100.5f; double d1 = f2; //float ----> double 가능
		
		//2. 강제 타입 변환
		int i4 = 2000000000; byte b2 = (byte)i3; //그냥 int -----> byte 불가능 [ 강제 ]
		System.out.println("강제 타입 변환 int -> byte : " +b2); //데이터 손실이 있을 수밖에 없음.
		long l3 = 300; int i5 = (int)l3; //그냥 long -----> int 불가능 [ 강제 ]
		System.out.println("강제 타입 변환 long -> int : " +i5); 
		int i6 = 65; char c3 = (char)i6; //그냥 int -----> char 불가능 [ 강제 ] ; 65(아스키코드) = A
		System.out.println("강제 타입 변환 int -> c3 : " +c3); 
		double d2 = 3.14; int i7 = (int)d2; //그냥 double -----> int 불가능 [ 강제 ]
		System.out.println("강제 타입 변환 double -> int : " +i7); //소수점 날라감 -> 데이터 손실 있음.
		
		//3. 연산시 자동 타입 변환
		byte bv1 = 10;
		byte bv2 = 20;
		int result1 = bv1 + bv2; //byte + byte = int (byte끼리 더하면 무조건 int)
		
		byte bv3 = 10;
		int iv1 = 100;
		long lv1 = 1000L;
		long result2 = bv3 + iv1 + lv1; //byte + int + long = long (가장 큰것)
		
		
		char cv1 = 'A';
		char cv2 = 1;
		int result3 = cv1 + cv2; //char + char = int (char끼리 더하면 무조건 int)
		
		int iv2 =10;
		int result4 = iv2 + iv2; //int + int = int 
		
		int iv3 = 10;
		double result5 = iv3/3.0; //int / double = doubld => double + int  = double
		
		//4. 문자열 타입 변환
		String str1 = "10";
		byte 바이트1 = Byte.parseByte(str1); //Sting   ->   byte
		short 쇼트1 = Short.parseShort(str1); //Sting   ->  short
		int 인트1 = Integer.parseInt(str1); //Sting   ->  int
		long 롱1 = Long.parseLong(str1); //Sting   ->  long
		float 플룻1 = Float.parseFloat(str1); //Sting   ->  float
		double 더블1 = Double.parseDouble(str1); //Sting   ->  double
		
		// "10" 문자열타입의 숫자 10 ---> 10 : 정수형 타입의 숫자 10
		//"ABC" : 문자열 타입의 문자A   ----> X 불가능
		String str2 = "안녕";
		int 인트2 = Integer.parseInt(str2); System.out.println(인트2); //불가능
		
		/*int 인트3 = (Integer)str1;*/ //불가능
		
	}//main e 
}//class e

/*
  	자료형/타입 변환
  		- 크기 순서
  		 byte[1] > short, char[2] > int[4] > long[8] > float[4] > double[8]
  		  => 서로 다른 자료형끼리 연산을 한다면, 가장 큰 것으로 따라간다. (but, byte와 short는 자기들끼리 더했을때 자기자신이 나오는 게 아니라 무조건 int!)
  		 -> 소수점이라서 float가 4바이트인데 8바이트 long보다 더 크다.
  		 
  		 1. 자동 타입 변환[캐스팅]
  		 	- 작은 타입 -----> 큰 타입 [자동]
  		 	
  		 2. 강제 타입 변환[캐스팅]
  			- 손실 있더라도 강제로 변환
  			(새로운 타입)변환할 데이터
  			
  			직은 허용범위 타입 = 큰 허용범위 타입[X]
  			작은 허용범위 타입 = (작은 허용범위 타입)
  			
		3. 연산시 자동 타입 변환
			- 피연산자 중 큰타입을 결과 반환
			1. 정수
				1) int보다 작은 byte, short 연산시 무조건 int 결과!! => byte와 short는 자기와 자기를 더해도 int!!
					short + int = int
					byte + int = int
				2) long 연산시
					int + long = long;
			2. 실수
				1) float/double 연산시
					float + int = float
					float + double = double
					float + float = float
  		
  		4.문자열 타입변환!
  			
  
  

 */