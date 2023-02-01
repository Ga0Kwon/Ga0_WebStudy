package Day01;

public class Ex3_자료형 {
	public static void main(String[] args) {
		
		//1. java 진수를 표현하는 방법
		 int var1 = 0b1011; System.out.println("2진수 : "+var1);
		 //1011[2진수] ------> 11[10진수]
		 int var2 =  0206; System.out.println("8진수 : "+var2);
		 //13[8진수]   ------> 134[10진수]
		 int var3 = 365; System.out.println("10진수 : "+var3);
		 //365[10진수]
		 int var4 = 0xB3; System.out.println("16진수 : "+var4);
		 //B3[16진수]  ------> 179[10진수]
		 
		 
		 //2. byte 자료형
		 byte b1 = -128; System.out.println("byte 자료형 :"+ b1);
		 byte b2 = 127; System.out.println("byte 자료형 :"+ b2);
		/* byte b3 = 128; System.out.println("byte 자료형 :"+ b3); *///=> 오류가 생김 -128 ~ 127 범위만 됨. 0(양수쪽)을 포함하기 때문[범위 벗어남 에러]
		 
		 //3. short 자료형 [+- 3만 2천 정도]
		 short s1 = 32000; System.out.println("short 자료형 :"+ s1);
		/* short s2 = 33000; System.out.println("short 자료형 :"+ s2); */ // => 오류 생김[범위 벗어남] => +- 32000 가능
		 
		 //4. int 자료형 [+- 21억 정도]
		 int i1 = 2000000000; System.out.println("int 자료형 :"+ i1);
		/* int i2 = 3000000000; System.out.println("int 자료형 :"+ i2); */  // => 오류 생김[범위 벗어남] => +- 20억 가능
		 
		 //5. long 자료형 [+- 21억 이상]
		 long l1 = 10; System.out.println("long 자료형 :"+ l1);
		 long l2 = 10000000000L; System.out.println("long 자료형 :"+ l2); //=> 뒤에다 L을 붙여야됨. 대입하는 값이 [기본값]int여서 에러가 남
		/* long l3 = 1000000000; System.out.println("long 자료형 :"+ i3); */  // => 오류 생김[범위 벗어남] => +- 20억 가능
		 
		 //6. char 자료형 [각 국문자 0 ~ 65535]
		 char c1 = 'A'; System.out.println("short 자료형 : " + c1); //문자를 쓸때는 '' , 문자열을 쓸땐 ""
		 char c2 = 65; System.out.println("short 자료형 : " + c2); // 아스키 코드로 65 -> A
		/* char c3 = 'AB'; System.out.println("short 자료형 : " + c3); */ //char은 문자 하나만 가능하다.
		 char c4 = '가'; System.out.println("short 자료형 : " + c4);
		 char c5 = 44032; System.out.println("short 자료형 : " + c5);
		 
		 //7. string 클래스 [문자 여러개 (문자열) 저장]
		 /* 문자열을 사용할때는 "" 큰따옴표를 사용하며, 다른 자료형과 달리 String은 첫글자가 S 대문자인 이유는 자료형이 아닌 클래스이기 때문이다. -> 클래스 첫글자는 대문자*/
		 String str1 = "안녕하세요"; System.out.println("String 클래스 : "+ str1); //2byte(char용량)*문자수
		 
		 //8. float 자료형
		 float f1 = 0.12345678912345678f; System.out.println("float 자료형 : "+ f1);//기본값이 double인데 큰 자료형 값 을 작은 자료형에 넣으려고 하면 오류 발생 => 즉, F or f를 뒤에 넣어주어야한다.
		 /*float : 소수점 8자리까지 표현*/
		 double d1 = 0.123456789123456789123456; System.out.println("double 자료형 : "+ d1);
		 /*double : 소수점 17자리까지 표현*/
		 
		 //9. boolean 논리 [true of false]
		 boolean bull1 = true; System.out.println("boolean 자료형 : " + bull1);
		/* boolean bull2 = 3; System.out.println("boolean 자료형 : " + bull2); */ //무조건 데이터는 true or false만 저장가능하여 오류 발생! 
		 
	}
}

/*
  - 용량 단위
  		Bit : 0, 1			-> 8bit
  		Byte : 0101010101	-> 1024Byte
  		KByte : 1024kyte    
  		MByte : 1024kbyte
  		GByte : 1024mbyte
  	
  - 최상위 bit => 부호역할
  		[최상위bit] 0101011
  		0 :양수 1 : 음수
  
  - 진수 : 컴퓨터의 표현 단위
  		2진수 : 0, 1   => 기계어/이진코드/bit       : 0b
  		8진수 : 0 ~ 7 						   : 0
  		10진수 : 0 ~ 9	: 사람				   : 
  		16진수 : 0 ~ 9 a b c d e f : 메모리주소체계 : 0x
  		
  
 */
