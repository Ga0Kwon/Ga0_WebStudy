package 과제.과제2;

import java.util.Scanner;

public class Ex1_키오스크 { //class s
	public static void main(String[] args) {//main s
		
		/*각 음료 재고*/
		int coke = 10; int sprite = 8; int fanta = 15;
		
		int buyCoke = 0; int buySprite = 0; int buyFanta = 0;
		int customerPrice =  10000; //고객이 가지고 있는 재산
		
		//입력 객체
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------------------<<제품 선택>>-----------------------");
			System.out.println("----1. 콜라[300] 2. 사이다[400] 3. 환타[500] 4. 결제 5. 종료----");
			System.out.println("----------------------------------------------------------");
			
			System.out.print(">> 고객 선택 : ");
			int customerChoice = scanner.nextInt(); //고객 선택 변수
			
			if(customerChoice == 1) { //콜라를 선택했을 경우
				
				System.out.print(">> 콜라 구입 개수 : ");
				
				int buyCounts = scanner.nextInt();//현재 구입할 개수 [바로 입력한]
				
				
				if(coke < buyCounts) {
					System.out.println(">>[재고 부족] 현재 콜라 재고 : " +coke);
				}else {
					buyCoke += buyCounts; //total 살 coke의 개수
					coke -= buyCounts; //재고가 부족한 문제가 없다면, 개수만큼 빼준다.
				}
				
			}
			else if(customerChoice == 2) { //사이다를 선택했을 경우
				
				System.out.print(">> 사이다 구입 개수 : ");
				
				int buyCounts = scanner.nextInt();//현재 구입할 개수 [바로 입력한]
				
				if(sprite < buyCounts) {
					System.out.println(">>[재고 부족] 현재 사이다 재고 : " +sprite);
				}else {
					buySprite += buyCounts; //total 살 sprite의 개수
					sprite -= buyCounts; //재고가 부족한 문제가 없다면, 개수만큼 빼준다.
				}
				
			}
			else if(customerChoice == 3) { //환타를 선택했을 경우
				
				System.out.print(">> 환타 구입 개수 : ");
				
				int buyCounts = scanner.nextInt(); //현재 구입할 개수 [바로 입력한]
				
				
				if(fanta < buyCounts) { 
					System.out.println(">>[재고 부족] 현재 환타 재고 : " +fanta);
				}else {
					buyFanta += buyCounts; //total 살 fanta의 개수
					fanta -= buyCounts; //재고가 부족한 문제가 없다면, 개수만큼 빼준다.
				}
				
			}
			else if(customerChoice == 4) { //결제를 선택했을 경우
				System.out.println("-----------------------<<장바구니 현황>>----------------------");
				System.out.println("1. 콜라[300] : " +buyCoke);
				System.out.println("2. 사이다[400] : " +buySprite);
				System.out.println("3. 환타[500] : " + buyFanta);
				System.out.println("----------------------------------------------------------");
				
				System.out.println(">>[결제 선택] 1. 결제 2. 주문취소");
				System.out.print(">> 고객 선택 : ");
				int cartChoice =  scanner.nextInt();
				
				if(cartChoice == 1) { //4. 결제에서 결제를 선택했을 경우
					
					int buyPrice = buyCoke*300 + buySprite*400 + buyFanta*500; //사려는 제품을 모두 합친 값.
					
					if(customerPrice < buyPrice) {
						System.out.println(">>[잔액 부족] 잔액이 부족합니다.");
						System.out.println(">> 부족한 금액 : " + (buyPrice - customerPrice));
					}
					else if(buyPrice == 0){
						System.out.println(">>[에러] 장바구니가 비워있습니다.");
					}
					else{
						customerPrice -= buyPrice; 
						System.out.println(">>[결제 완료] 현재 사용자의 잔액 : "  + customerPrice);
						
					}
					
				}else if(cartChoice == 2) { //4. 결제에서 주문취소를 선택했을 경우
					
					System.out.println(">>[주문 취소] 장바구니에 있는 모든 목록을 삭제합니다.");
					coke += buyCoke; sprite += buySprite;  fanta += buyFanta;
					buyCoke = 0; buySprite = 0; buyFanta = 0;
					System.out.println(">>[주문 취소] 주문취소가 완료되었습니다.");
					
				}else { //그외
					System.out.println(">>[에러] 알 수 없는 번호입니다.");
				}
			}
			else if(customerChoice ==5) { //종료를 선택했을 경우
				System.out.println(">>[종료] 키오스크 시스템을 종료합니다.");
				System.out.println("----------------------------------------------------------");
				break; //반복문 나옴.
			}
			else { //그 외
				System.out.println(">>[에러] 알 수 없는 번호입니다.");
				System.out.println("----------------------------------------------------------");
			}
			
			
		}
		
	}//main e
}//class e
