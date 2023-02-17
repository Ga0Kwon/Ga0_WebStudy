package 과제.과제9.interfaceExample.Ex1;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		계산기 계산;
		while(true) {
			System.out.println("수를 입력해주세요.");
			System.out.print("첫번째 수 : "); int fNm = scanner.nextInt();
			System.out.print("두번째 수 : "); int sNm = scanner.nextInt();
			System.out.println("1. 더하기 2. 곱하기 3. 빼기 4. 나누기");
			int choice = scanner.nextInt();
			if(choice == 1) {
				계산 = new 더하기();
				계산.calculation(fNm, sNm);
			}else if(choice == 2) {
				계산 = new 곱하기();
				계산.calculation(fNm, sNm);
			}else if(choice == 3) {
				계산 = new 빼기();
				계산.calculation(fNm, sNm);
			}else if(choice == 4){
				계산 = new 나누기();
				계산.calculation(fNm, sNm);
			}
		}
		
	}
}
