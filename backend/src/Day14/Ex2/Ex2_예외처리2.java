package Day14.Ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex2_예외처리2 {
	public static void main(String[] args) {
		//1. Class.forName("패키지명.클래스명") : 해당 클래스가 있는지 없는지 
			//일반예외 : 컴파일전에 예외 확인
		try {
			
			Class.forName("java.lang.String"); //클래스 여부 찾기 
			System.out.println("java.lang.String 클래스 존재");
			
		} catch (ClassNotFoundException e) { //* 해당 클래스를 못찾았을 때
			
			e.getMessage();
//			e.printStackTrace();
			
		} 
		
		//------------------------
		System.out.println();
		try {
			
			Class.forName("java.lang.String2"); // java.lang.String2라는 것은 없음 => 즉 catch로 간다.
			System.out.println("java.lang.String2 클래스 존재");
			
		}catch(ClassNotFoundException e){
			
			System.out.println(e.getMessage());
//			e.printStackTrace();
			
		}
		
		//2.catch 다중 처리
			//배열 : 타입[] 배열명 = {데이터1, 데이터2, 데이터3... }
		String []array = {"100", "1oo"}; // 영어 o 숫자 0
			//배열 for : 인덱스 0, 길이는 1부터
		for(int i =0; i <= array.length; i++) {
			try {
				
				int value = Integer.parseInt(array[i]); //스트링을 number로 바꾸지 X
				//Integer.parseInt(문자열) - > 정수형
				//예외 발생 : "100" => 100 가능 / "1oo" => 불가능
				System.out.println("array[" + i + "] = " + value);
				
			} /*
				 * catch (Exception e){ //* 슈퍼클래스 Exception가 다 가져가기 때문에 아래 catch문이 쓸모가 없어져서 빨간줄
				 * 
				 * System.out.println("예외 발생 : " + e);
				 * 
				 * }
				 */
			catch(NumberFormatException e) {
				
				System.out.println("숫자로 반환할 수 없음 : " + e);
				e.printStackTrace();
				
			}catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println("인덱스 초과 : " + e);
				e.printStackTrace();
				
			}catch(Exception e){ //상위 클래스(슈퍼클래스)는 이렇게 가장 아래에 작성해야한다. => 물론 catch문 다 삭제하고 이것만 사용해도 OK
				System.out.println("예외 발생 : " + e);
			}
		}
		
		//3.
		while(true) {
			try {
				Scanner scanner = new Scanner(System.in);
				int cn = scanner.nextInt();//숫자를 입력받는데 숫자가 아닌 것을 입력하게 되면 예외
			}catch(InputMismatchException e){
				System.out.println("잘못된 입력입니다.");
			}
			
		}
	}
}
