package Day04;

import java.util.Scanner;

public class Ex2_예금 { //class s
	public static void main(String[] args) { //main s
		Scanner scanner = new Scanner(System.in);
		
		/*계좌번호*/
		String account = "123-1234";
		
		/*비밀번호*/
		short password = 1234;
		
		/*예금액 [ 누적이 되어야 하기때문에] while 밖에 선언*/
		int customerPrice = 0;
		
		while(true) {//무한 루프 s [종료조건 : 4 입력시]
			System.out.println("-----------------------------------------");
			System.out.println("--------1. 예금 2. 출금 3. 잔고 4. 종료-------");
			System.out.println("-----------------------------------------");
			System.out.print(">> 선택 : ");
			
			/*-------------------------------예금 구역 s-------------------------------*/
			int customerChoice = scanner.nextInt();
			if(customerChoice == 1) { //1. 예금 입력시
				System.out.print(">>예금할 계좌번호 : ");
				String inputAccount = scanner.next();
				if(account.equals(inputAccount)) { //계좌번호와 입력받은 계좌번호가 같으면
					System.out.print(">>예금할 금액 : ");
					customerPrice += scanner.nextInt();
					System.out.println(">>예금후 금액 : " + customerPrice);
				}else {
					System.out.println(">>[에러]없는 계좌번호입니다.");
				}
			}
			/*-------------------------------예금 구역 e-------------------------------*/
			/*-------------------------------출금 구역 s-------------------------------*/
			else if(customerChoice == 2) {//2. 출금 입력시 else if s
				System.out.print(">>출금할 계좌번호 : ");
				if(account.equals(scanner.next())) { //계좌번호와 입력받은 계좌번호가 같으면 if1 s
					System.out.print(">>패스위드 : ");
					if(password == scanner.nextShort()) { //if2 s
						System.out.print(">>출금할 금액 : ");
						int outPrice = scanner.nextInt();
						if(customerPrice < outPrice) { //if3 s
							System.out.println(">>[잔액 부족] 출금할 금액이 잔고보다 더 큽니다.");
						} //if3 e
						else { //else3 s
							customerPrice -= outPrice;
							System.out.println(">>출금후 금액 : " +customerPrice);
						}//else3 e
					}//if2 e
					else {//else2 s
						System.out.println(">>[에러]잘못된 비밀번호입니다..");
					} ////else2 e
					
				} //if1 e
				else { //else1 s
					System.out.println(">>[에러]없는 계좌번호입니다.");
				}//else1 e

			} //else if e
			/*-------------------------------출금 구역 e-------------------------------*/
			/*-------------------------------잔고 구역 s-------------------------------*/
			else if(customerChoice == 3) {//3. 잔고 입력시
				System.out.print(">>잔고 확인 할 계좌번호 : ");
				
				if(account.equals(scanner.next())){ //계좌번호와 입력받은 계좌번호가 같으면
					System.out.print(">> 잔고[잔액] : " + customerPrice);
					System.out.println();
				}else {
					System.out.println(">>[에러]없는 계좌번호입니다.");
				}
				
			}
			/*-------------------------------잔고 구역 e------------------------------*/
			/*-------------------------------종료 구역 s------------------------------*/
			else if(customerChoice == 4) {//4. 종료 입력시
				System.out.println(">>[종료]시스템을 종료합니다.");
				break;
			}/*-------------------------------종료 구역 e------------------------------*/
			 /*-------------------------------그외 구역 s------------------------------*/
			else {//그 외 
				System.out.println(">>[에러]알 수 없는 번호 입니다.");
			}
			/*-------------------------------그외 구역 e------------------------------*/
		}//무한 루프 e
		
	}//main e
}//class e

/*
  1. if 중첩 
  2. 자료형[char] == '안' == '안'
  	 클래스[String] : 객체A.equals(객체B)
 					"안녕" == "안녕: [X]
 					"안녕".equals("안녕") [O]
 */