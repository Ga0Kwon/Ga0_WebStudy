package Day15.Ex4;

import java.io.IOException;

public class System클래스 {
	public static void main(String[] args) {
		//1.
		System.out.println("출력"); //콘솔에 출력
		System.err.println("에러"); // 콘솔에 에러[빨강] 출력
		
		int value1 = 100; //int에 100 대입 가능 [정수니까 가능]
		/* int value2 = "100"; */ //int에 "100" 대입 불가능 [문자니까 불가능]
		String value2 = "100";
			// 문자열 ---> 기본타입 변환
		int value3 = Integer.parseInt(value2);
		try { // try{}에 예외[오류]가 발생할 것 같은 코드 [*경험]
			
			int value4 = Integer.parseInt("1oo"); //문자는 변환X
			
		}catch(NumberFormatException e) { // try{}에서 예외[오류] 발생했을 때 catch{} 실행
			
			System.err.println("변환할 수 없습니다.");
			System.err.println("예외 내용 : " + e.getMessage());
		}
		
		//2.
		int speed = 0;
		int keyCode = 0;

		while(true) {
			//Enter 키를 읽지 않았을 경우에만 실행
			if(keyCode != 13 && keyCode != 10) { // 엔터[13,10]
				if (keyCode == 49) { 				//숫자 1[49] 키를 읽었을 경우
					speed++;
				} else if (keyCode == 50) {			//숫자 2[50] 키를 읽었을 경우
					speed--;
				} else if (keyCode == 51) { 		//숫자 3[51] 키를 읽었을 경우
					System.out.println("프로그램 종료");
					System.exit(0); //0이면 정상 종료, 1 or -1이면 비정상 종료
				}
				System.out.println("-----------------------------");
				System.out.println("1. 증속 | 2. 감속 | 3. 중지");
				System.out.println("-----------------------------");
				System.out.println("현재 속도= " + speed);
				System.out.print("선택: ");
			}
			
			try {
				//키를 하나씩 읽음
				keyCode = System.in.read(); //입력받아 코드로 변환 [*예외처리 필수]
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		//아래 코드 에러 [System.exit(0)때문]
//		System.out.println("프로그램 종료"); => system.exit()할 경우 아래꺼 실행 조차도 안됨 => 프로세스[프로그램 자체]를 강제 종료시키는 거니까.
		
	}
}
