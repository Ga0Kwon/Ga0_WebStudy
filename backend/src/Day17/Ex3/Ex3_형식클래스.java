package Day17.Ex3;

import java.text.DecimalFormat;

public class Ex3_형식클래스 {
	public static void main(String[] args) {
		double num = 1234567.89;

		DecimalFormat df;
		
		//정수 자리까지 표기 => * 천 단위 쉼표 만들기
		df = new DecimalFormat("#,###");
		System.out.println( df.format(num) );
		
		//무조건 소수 첫째 자리까지 표기
			//0 : 만일 숫자가 없는 자리면 0으로 채움
			//# : 만일 숫자가 없는 자리면 공백[생략]
		df = new DecimalFormat("#,###.0");
		System.out.println( df.format(num));
		
		double num2 = 1234567;
		df = new DecimalFormat("#,###.#");
		System.out.println(df.format(num2));
		
		// 금액의 천단위 쉼표 : #, ##0
		df = new DecimalFormat("#,##0원");
		System.out.println(df.format(123456));
		System.out.println(df.format(1));
	}
}
