package Day04; //현재 클래스의 패키지 위치 표시
import java.util.Random;
/*
  System : java.lang에 있는 클래스 -> import안해도 되는 이유는 기본으로 import하고 있기 때문
 */
import java.util.Scanner; //해당 클래스를 사용하기 위한 패키지로 부터 클래스 가져오기

public class Ex1_가위바위보 { //class s[클래스 시작]
	public static void main(String[] args) { //main s [메인 함수 시작]
		
		/*3. 입력 객체 [클래스 위의 import java.util.Scanner; 필수!*/
		Scanner scanner = new Scanner(System.in);
		
		// 8.변수의 사용범위 : 지역 변수 특징 { }밖으로 몬나감
		int uWin = 0; //사용자가 이긴 횟수
		int cWin = 0; //컴퓨터가 이긴 횟수
		int play = 0; //총 몇판했는지ㄴ
		// * : while 안에서 선언된 변수는 반복문 돌때마다 선언
		
//		for(int i = 0; true; i++) {//조건이 true여서 무한 반복[무한루프]
//			System.out.println("무한");
//		}
		
		//while이 무한루프 쓰는데 편함 
		while(true) { //1. 무한루프[종료조건 :]
			play++;
			//2. 출력 : syso + 자동완성
			System.out.println("----------가위(0) 바위(1) 보(2) 종료(3)-----------");
			//3. 입력 Scanner 클래스 -> scanner 객체 필요! 
			//4. 저장 [변수]
			System.out.print(play+"판째 사용자 :");
			byte userPlayer = scanner.nextByte(); //키보드로부터 입력받은 객체를 byte형으로 반환하여 변수에 저장
			System.out.println("사용자가 낸 수 >" + userPlayer);
			
			//5. 제어문 [흐름 제어 - 경우의 수 (정상 입력(0~2), 종료(3))
			if(userPlayer == 3) { //userPlayer가 종료(3)을 입력했을시
				System.out.println("총 : " +play + "판");
				System.out.println("사용자가 이긴 횟수 : " + uWin + "\n컴퓨터가 이긴 횟수 : " +cWin);
				
				if(uWin > cWin) {
					System.out.println("[게임결과] 사용자 최종 승리!");
				}else if(uWin < cWin) {
					System.out.println("[게임결과] 컴퓨터 최종 승리");
				}else {
					System.out.println("[게임결과] 무승부");
				}
				
				System.out.println("-----------------가위바위보 종료------------------");
				break; //종료
			}
			//6. 난수 생성 [ 1. Math 클래스 2. random 클래스]
//			Random random = new Random();
//			int computerPlayer = random.nextInt(3); // 0 ~ 2 까지의 난수
			
			byte computerPlayer =  (byte)(Math.random()*3);
			System.out.println("컴퓨터가 낸 수 >" + computerPlayer );
			
			//7. 승리 판단 
			if(userPlayer == 0) { //사용자가 0(가위)를 냈을 경우
				if(computerPlayer == 1) {//컴퓨터가 1(바위)를 냈을 경우
					System.out.println("컴퓨터 승!"); cWin++;
				}else if(computerPlayer == 2) {//컴퓨터가 2(보)를 냈을 경우
					System.out.println("사용자 승!"); uWin++;
				}else if(computerPlayer == 0){//컴퓨터가 0(가위)를 냈을 경우
					System.out.println("무승부");
				}
			}else if(userPlayer == 1) {//사용자가 1(바위)를 냈을 경우
				if(computerPlayer == 0) {//컴퓨터가 0(가위)를 냈을 경우
					System.out.println("사용자 승!");uWin++;
				}else if(computerPlayer == 1) {//컴퓨터가 1(바위)를 냈을 경우
					System.out.println("무승부");
				}else if(computerPlayer == 2) {//컴퓨터가 2(보)를 냈을 경우
					System.out.println("컴퓨터 승!");cWin++;
				}
			}else if(userPlayer == 2) {//사용자가 2(보)를 냈을 경우
				if(computerPlayer == 0) {//컴퓨터가 0(가위)를 냈을 경우
					System.out.println("컴퓨터 승!");cWin++;
				}else if(computerPlayer == 1) {//컴퓨터가 1(바위)를 냈을 경우
					System.out.println("사용자 승!");uWin++;
				}else if(computerPlayer == 2) {//컴퓨터가 2(보)를 냈을 경우
					System.out.println("무승부");
				}
			}
			
		}
		
		
		
	}//main e[메인 함수 끝]
}//class e[클래스 끝]

/*
	* 예제에서 중요한 코드 
	1. 승리자 판단
	2. 지역변수 특징 
	3. Scanner 클래스 , Random 클래스 
*/
