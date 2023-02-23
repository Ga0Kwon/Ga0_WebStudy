package Day17.Ex3_달력;

import java.util.Calendar;
import java.util.Scanner;

public class Ex3_달력 {
	public static void main(String[] args) {
		//- static 멤버는 인스턴스 멤버 호출 X => static은 메모리가 있는 상태
			//1. [해당 멤버(메소드/필드)가 static 멤버] run() 메소드도 정적 멤버하자
//		Run();
		
			//2. [해당 멤버(메소드/필드)가 인스턴스 멤버] 아래처럼 객체[인스턴스] 생성해서 호출하자.
		Ex3_달력 ex3_달력 = new Ex3_달력();
		ex3_달력.Run2();
		
	}
	
	//1. 달력함수
//	static void Run() {
//		
//	}
	
	//1. 달력함수
	void Run2() {
		//1. 현재 날짜
		Calendar cal = Calendar.getInstance(); //현재 날짜 가져오기
		
		//2. 현재 연도
		int year = cal.get(Calendar.YEAR);
		
		//3. 현재 월
		int month = cal.get(Calendar.MONTH) + 1;
		
		//4. 현재 일
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			// *** 현재 월의 1일 날짜 요일
			cal.set(year, month-1, 1); //현재 연도/월의 1일 날짜 형식으로 변경
			int findStartWeek = cal.get(Calendar.DAY_OF_WEEK); //현재 연도/월의 1일의 요일
			
			// *** 현재 월의 마지막 일
			int findEndDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); //현재 월의 마지막 최대 일수를 구할 수있음
			
			System.out.printf("##################### %d년 %d 월 #####################\n", year, month);
			System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토");

//			int count = 0; => 줄바꿈 코드
			// 해당 월 1일 전까지 공백으로 채우기
			
			for(int i = 1; i < findStartWeek; i++) {
				System.out.print(" \t");
//				count++;
			}
						
			for(int i = 1; i < findEndDay; i++) {
				System.out.printf("%2d \t" , i);
//				count++;
				if(findStartWeek % 7 == 0) { // 토요일[7] 마다 줄바꿈
					System.out.println("\n");
				}
				findStartWeek++;
			}
			System.out.println();
			System.out.println("#######################################################");
			System.out.print("1. 이전 달 \t 2. 다음 달 \t 3. 검색 : ");
			int choice = scanner.nextInt();
			if(choice == 1) { //1. 이전 달
				month--;
				//만약에 월이 0이면 월 = 12 연도 1차감
				
				if(month < 1) {
					month =12;
					year--;
				}
			}else if(choice == 2) {//2. 다음 달
				month++;
				if(month > 12) {
					month = 1;
					year++;
				}
			}else if(choice == 3) {
				System.out.print("연도 : "); int inPutY = scanner.nextInt();
				System.out.print("월 : "); int inPutM = scanner.nextInt();
				
				if(inPutY >= 1900 && inPutY <= 9999 && inPutM >= 0 && inPutM <= 12) {
					year = inPutY;
					month = inPutM;
				}else {
					System.out.println("표현할 수 없는 달력입니다.");
				}
			}
		}
	}
}
