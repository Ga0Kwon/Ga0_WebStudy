package Day02;

import java.util.Scanner;

public class Ex2_입력 { //class s
	public static void main(String[] args) { //main s
		//1. 입력
			//scan + 자동완성
			//객체 생성 : 클래스명 객체명(아무거나/변수명) = new 생성자명(인수);
			//입력 객체 : Scanner scanner = new Scanner(System.in);
				//{ }별 1번만 선언하면 됨!
		
		//입력 객체
		Scanner scanner = new Scanner(System.in);
		
		//입력 메소드 -> 변수 저장[자료형 맞춰야함]
		String 문자열1 = scanner.next(); //문자열 [띄어쓰기 불가능] 입력받기 함수
		System.out.println("문자열 : " + 문자열1);
		
		scanner.nextLine();
		
		String 문자열2 = scanner.nextLine(); //문자열[띄어쓰기 가능] 입력받기 함수=> nextLine()앞에 다른 next() 하나로 취급
		System.out.println("문자열 : " + 문자열2);  // -> 해결 방안 : 앞에 의미가 없지만 있는 nextLine()을 적는다. -> 비어주는 것
		
		char 문자하나 = scanner.next().charAt(0); //한글자 입력받기 함수 .next()문자열중에서 .charAt(0) 첫글자만 반환
		System.out.println("문자 : " + 문자하나);
		
		int 정수1 = scanner.nextInt();  //정수형 입력받기
		System.out.println("정수 : " + 정수1);
		
		short 정수2 = scanner.nextShort(); //정수형 입력받기
		System.out.println("정수 : " + 정수2);
		
		long 정수3 = scanner.nextLong(); //정수형 입력받기
		System.out.println("정수 : " + 정수3);
		
		float 실수1 = scanner.nextFloat(); //실수 입력받기
		System.out.println("실수 : " + 실수1);
		
		double 실수2 = scanner.nextDouble(); //실수 입력받기
		System.out.println("실수 : " + 실수2);
		
		boolean 불린 = scanner.nextBoolean();//논리 입력받기 함수
		System.out.println("불린 : " + 불린);
		
		byte 바이트 = scanner.nextByte(); //바이트 입력받기 함수
		System.out.println("바이트 : " + 바이트);
		
		scanner.nextLine();
		
		System.out.print("x값을 입력 : ");
		int x = Integer.parseInt(scanner.nextLine()); //입력받은 값을 변수에 저장
		System.out.printf("입력받은 x 값 : %d", x);
		
		//문자열[String 객체] 비교 => String은 클래스이므로 기본 자료형과 다르다. [비교연산자 불가능]
		String 아이디 = "asd"; //아이디는 객체 -> 연산자 불가능
		System.out.println(아이디 == "asd"); //false;
		System.out.println(아이디.equals("asd")); //문자열.equals("비교할문자열"); 으로 해야함
		
		//기본자료형 비교 [비교연산자 가능]
		int 비밀번호 = 1234;
		System.out.println(비밀번호 == 1234); //true
	} //main e
} //class e

/*
  System  import java.lang 패키지 생략
  String  import java.lang 패키지 생략
  Scanner import java.util.Scanner;
  
 
 */