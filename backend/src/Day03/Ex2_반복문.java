package Day03;

import java.util.Scanner;

public class Ex2_반복문 {//class  s
	public static void main(String[] args) {//main s
		
		//1. 같은 연산식을 이렇게 적어 누적더하기 하면, 좋지 않음 -> 속도적으로도.
			//모양이 비슷하다면, for문 사용!!
		int sum1 = 0;
		sum1 = sum1 + 1;
		sum1 = sum1 + 2;
		sum1 = sum1 + 3;
		sum1 = sum1 + 4;
		sum1 = sum1 + 5;
		System.out.println("반복문 사용X[1~5까지] >"+sum1);
		
		//2.
		int sum2 = 0;
		for(int i =1; i <= 100; i++) {
			sum2 += i;
		}
		System.out.println("반복문 사용[1~100까지] >"+sum2);
		
		//3.
		for(int i = 1; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//4.
		int sum4 = 0;
		int i4 ;
		
		for(i4 =1; i4 <= 100; i4++) {
			sum4 += i4;
		}
		
		System.out.println("1~" + (i4-1)+ "합 : "+ sum4);
		
		//5.
		for(float x = 0.1f; x <=1.0f; x+=0.1f) {
			System.out.println(x);
		}
		
		//6. 구구단
		for(int m = 2; m <= 9; m++) {
			System.out.println("----" + m + "단 ----");
			for(int n = 1; n <= 9; n++) {
				System.out.println(m + " X " + n + " = " + (m*n));
			}
		}
		
		//6-1 break : 반복문 탈출 / return : 함수 종료
		while(true) { //무한 루프
			int num6 = (int)(Math.random()*6) + 1;
			System.out.println(num6);
			if(num6 == 6) { //난수값이 6이 나오면
				break; //while문을 탈출한다.
			}
		}
		
		//6-2 break(1)
		for(char upper = 'A'; upper <= 'Z'; upper++) {
			//'A' ~ 'Z' 까지 문자 하나씩 증가 반복\
			System.out.println(upper);
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println("\t " + lower);
				if(lower == 'g') { //lower이 g일때
					break; //가까운 lower의 반복문이 종료된다. 
				}
			}
		}
		
		//6-2 break(2)
		Outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			//'A' ~ 'Z' 까지 문자 하나씩 증가 반복\
			System.out.println(upper);
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println("\t " + lower);
				if(lower == 'g') { //lower이 g일때
					break Outter; //Outter을 넣어주면 Outter이 있는 부분을 종료해준다. [A의 g에서 모드 끝남.)
				}
			}
		}
		
		//6-2 break(3)
			// 이름 : for(
			// break 이름;
			//1) for1
		첫번째for1 : for(char upper = 'A'; upper <= 'Z'; upper++) {
			//'A' ~ 'Z' 까지 문자 하나씩 증가 반복\
			System.out.println(upper);
			//for2
			두번째for2 : for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println("\t " + lower);
				if(lower == 'g') { //lower이 g일때
					break 첫번째for1; //Outter을 넣어주면 Outter이 있는 부분을 종료해준다. [A의 g에서 모드 끝남.)
				}
			}
		}
		
		//6-3 continue(1)
		for(int i = 1; i <= 10; i++) {
			if(i%2 != 0) { //i가 홀수이면
				continue; //만나면 더 이상 내려가지 않고 가장 가까운 반복문으로 이동
			}
			System.out.println(i + " ");
		}
		
		//6-3 continue(2)
		forname : for(int i = 1; i <= 10; i++) {
			if(i%2 != 0) { //i가 홀수이면
				continue; //만나면 더 이상 내려가지 않고 가장 가까운 반복문으로 이동
			}
			System.out.println(i + " ");
			
			for(char j = 'a'; j <= 'z'; j++) {
				if(j == 'g') { //i가 홀수이면
					continue forname; //만나면 더 이상 내려가지 않고 가장 가까운 반복문으로 이동
				}
				System.out.println(j + " ");
			}
		}
		
		//7.while문
		int i7 = 1;
		while(i7 <= 10) {
			System.out.print(i7 + " ");
			i7++;
		}
		System.out.println();
		
		//8. 
		int sum8 = 0;
		int i8 = 1;
		
		while(i8 <= 100) {
			sum8 += i8;
			i8++;
		}
		System.out.println("1 ~ " + (i8-1) + "까지의 합 : " +sum8);
		
		//9.
		Scanner scanner = new Scanner(System.in);
		
		boolean run =  true;
		int speed = 0;
		
		while(run) {
			System.out.println("---------------------------");
			System.out.println(" 1. 종속 | 2. 감속 | 3. 중지 ");
			System.out.println("---------------------------");
			System.out.print("선택 :");
			
			String input = scanner.nextLine();
			
			if(input.equals("1")) {
				speed++;
				System.out.println("현재 속도 : " + speed);
			}else if(input.equals("2")) {
				speed--;
				System.out.println("현재 속도 : " + speed);
			}else if(input.equals("3")) {
				run = false;
				System.out.println("멈춥니다.");
			}else {
				System.out.println("1~3에서 선택해주세요.");
			}
		}
		
		
		
	}//main e
}//class e
