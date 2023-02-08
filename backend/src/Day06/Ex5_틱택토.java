package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {//class s
	public static void main(String[] args) {//main s
		
		//입력객체
		Scanner scanner = new Scanner(System.in);
		
		//1) 배열선언 : 자료형 타입 []배열명 =  {허용범위내데이터1, 허용범위내데이터2, 허용범위내데이터3}
		
		/*게임판 9칸 문자열 선언*/
		String []게임판 = {"[ ]","[ ]", "[ ]",
						 "[ ]", "[ ]","[ ]",
						 "[ ]","[ ]","[ ]"};
		
		/*승리판단 결과 저장 변수*/
		boolean 결과 = false; //결과 없을 경우 false
		
		//2) 배열 데이터 호출 [게임판 출력]
//		for(int i = 0; i < 게임판.length; i++) {
//			System.out.print(게임판[i]);
//			/*3칸마다 줄바꿈 => 인덱스가 0부터 시작하기 때문에 2, 5, 8은 3으로 나눌때 나머지 2*/
//			if(i%3 == 2) {
//				System.out.println();
//			}
//		}
		
		//3) 알두기
		game : while(true) {//무한반복 [ 종료 조건 : 승리판단 있을 경우]
			//[게임판 출력]
			for(int i = 0; i < 게임판.length; i++) {
				System.out.print(게임판[i]);
				/*3칸마다 줄바꿈 => 인덱스가 0부터 시작하기 때문에 2, 5, 8은 3으로 나눌때 나머지 2*/
				if(i%3 == 2) {
					System.out.println();
				}
			}
			
			
			/*-----------사용자----------*/
			while(true) {//사용자가 정상적으로 알을 둘때까지 [사용자가 정상 알 두기를 했을 때]
				System.out.print("사용자 알 입력[0~8] : ");  int 위치 = scanner.nextInt();
				
				
				//유효성 검사 [ 1. 0~8사이만 2. 위치 중복(알이 존재하는 위치인지) ---> 다시 입력]
				if(위치 < 0 || 위치 > 8) { // 0~8 사이의 수가 아닐 경우
					System.err.println("[알림] 허용 범위내 입력해주세요.");
					continue;
				}
				
				if(!게임판[위치].equals("[ ]")) { //이미 알이 있는 경우
					System.err.println("[알림] 이미 자리에 알이 있습니다.");
					continue;
				}
				
				게임판[위치] = "[O]";
				break;
			}
			
			/*
			 * if(결과 == true) {break;} //결과가존재하면 나가야한다.
			 */					
			/*-----------컴퓨터----------*/
			while(true) {//컴퓨터가 정상적으로 알을 둘때까지 [사용자가 정상 알 두기를 했을 때]
				Random random = new Random(); //난수 관련된 메소드 제공
				int 위치 = random.nextInt(9); // 0~9
				/* 위치 = (int)Math.random()*9; */
				
				//유효성 검사 [2. 위치 중복(알이 존재하는 위치인지) ---> 다시 입력] => 컴퓨터는 어차피 0~8까지만 설정
				
				if(!게임판[위치].equals("[ ]")) { //이미 알이 있는 경우
					continue;
				}
				
				게임판[위치] = "[X]";
				break;
				
			}
			//4)승리자 판단[1. 승리 2. 패배 3. 무승부]
			for(int i = 0; i < 2; i++) {
				if(게임판[i].equals("[ ]") && 게임판[i] == 게임판[i+3] && 게임판[i+3] == 게임판[i+6]) {
					if(게임판[i].equals("[X]")) {
						System.out.println("컴퓨터 승리");
						/* 결과 = true; */
						break game;
					}else if(게임판[i].equals("[O]")) {
						System.out.println("사용자 승리");
						/* 결과 = true; */
						break game;
					}
				}
			}
			for(int i = 0; i < 6; i++) {
				if(게임판[i].equals("[ ]") && 게임판[i] == 게임판[i+1] && 게임판[i+1] == 게임판[i+2]) {
					if(게임판[i].equals("[X]")) {
						System.out.println("컴퓨터 승리");
						/* 결과 = true; */
						break game;
					}else if(게임판[i].equals("[O]")) {
						System.out.println("사용자 승리");
						/* 결과 = true; */
						break game;
					}
				}
			}
			if(게임판[2] == 게임판[4] && 게임판[6] == 게임판[4]) {
				if(게임판[2].equals("[X]")) {
					System.out.println("컴퓨터 승리");
					/* 결과 = true; */
					break game;
				}else if(게임판[2].equals("[O]")) {
					System.out.println("사용자 승리");
					/* 결과 = true; */
					break game;
				}
			}
			
			if(게임판[0] == 게임판[4] && 게임판[4] == 게임판[8]) {
				if(게임판[0].equals("[X]")) {
					System.out.println("컴퓨터 승리");
					/* 결과 = true; */
					break game;
				}else if(게임판[0].equals("[O]")) {
					System.out.println("사용자 승리");
					/* 결과 = true; */
					break game;
				}
			}
			//1. 무승부 : 알이 9개면 무승부
			int check = 0;
			for(int i = 0; i < 게임판.length; i++) {
				if(!게임판[i].equals("[ ]")) {
					check++;
				}
				if(check == 9) {
					System.out.println("무승부");
					break game;
				}
			}
			
		}
		
	}//main e
} //class e
