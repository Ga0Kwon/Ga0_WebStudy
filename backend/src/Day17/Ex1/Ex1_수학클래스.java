package Day17.Ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Ex1_수학클래스 {
	public static void main(String[] args) {
		//1. Math 클래스 : 수학 계산에 사용할 수 있는 메소드 제공
		// Math클래스의 함수들이 static이기 때문에 new 없이 사용 가능
		
			// 1. ceil() : 올림 [기본적으로 소수 첫째자리만 됨]
			// 2. floor() : 내림 [기본적으로 소수 첫째자리만 됨]
		double v1 = Math.ceil(5.3);
		double v2 = Math.floor(5.3);
		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		
			// 3. max(값1, 값2) : 최댓값
			// 4. min(값1, 값2) : 최솟값
		long v3 = Math.max(3, 7);
		long v4 = Math.min(3, 7);
		System.out.println("v3 = " + v3);
		System.out.println("v4 = " + v4);
		
			// 5. round(값) : 반 올림 [기본적으로 소수 첫째자리만 됨]
			// 소수 셋째자리에서 반올림해서 두 자리까지 표시
		double value = 12.3456;
		double temp1 = value * 100; // => 소수 첫째자리밖에 안되서 100을 곱한 것. 1234.5로 바꾼 다음
		long temp2 = Math.round(temp1); //=> 반올림하면 1235가 됨
		double v5 = temp2 / 100.0; // 그리고 100으로 나누면 12.35
		System.out.println("v5=" + v5); //12.35
		
		//String.format("%.소수자리수f", 값) : 반올림하고 문자로 표현함.
		System.out.println(String.format("%.2f", 3.141592));
		
		
		// 클래스 : 서로 다른 자료형/타입 한 곳에 저장하기 위한 클래스에 저장
		// 배열/리스트 : 동일한 자료형의 데이터 여러개 저장하기 위한 리스트/배열[객체]에 저장  
		//int형 변수 6개 저장할 수 있는 배열 [고정 길이, 다양한 메소드 제공X]
		int[] selectNumber = new int[6];
			//vs.
		//int형 변수를 6개 저장할 수 있는 리스트 [가변 길이, 다양한 메소드 제공O, 선언시 기본 길이 : 10 => add하면 1씩 늘어남.]
		ArrayList<Integer> selectNumber2 = new ArrayList<>(6); // => ()빈 칸으로 두면 10이라는 소리
			// 포장 클래스 : 기본자료형 -> 클래스 [특정 API클래스중 기본 자료형 사용 불가]
		
		//Random() 괄호안에 seed라는 종자값이 같게 주면 같은 난수를 가지고, 다르면 다른 값을 가짐.
		Random random = new Random(); // 난수 관련 메소드 제공하는 클래스
		System.out.print("선택번호: ");
		for(int i=0; i<6; i++) {
			selectNumber[i] = random.nextInt(45) + 1; // 1~45 사이의 정수 난수
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();

		
		int[] winningNumber = new int[6];
		random = new Random();
		System.out.print("당첨번호: ");
		for(int i=0; i<6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
			System.out.print(winningNumber[i] + " ");
		}
		System.out.println();

		
		// 배열 정렬
			// 1. Arrays.sort(배열) : 해당 배열내 데이터를 오름차순 저열
			// 2. Arrays.toString(배열) : 해당 배열내 데이터를 출력
			// 3. Arrays.equals(배열1, 배열2) : 두 배열이 모두 일치하면 true/false
		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);
		boolean result = Arrays.equals(selectNumber, winningNumber);
		System.out.print("당첨여부: ");
		if(result) {
			System.out.println("1등에 당첨되셨습니다.");
		} else {
			System.out.println("당첨되지 않았습니다.");
		}
		
	}
}
