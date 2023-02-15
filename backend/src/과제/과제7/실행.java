package 과제.과제7;

import java.util.ArrayList;
import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		ArrayList<은행> bankDB = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("------------- 계좌 관리 ---------------");
			System.out.println("은행명\t계좌번호\t\t\t예금액");
			for(int i =0; i < bankDB.size(); i++) {
				
				String bankCode = bankDB.get(i).code;
				
				String bankName = "";
				
				if(bankCode.equals("03")) {
					bankName = "신한";
				}else if(bankCode.equals("04")) {
					bankName = "국민";
				}else if(bankCode.equals("05")) {
					bankName = "우리";
				}
				
				System.out.printf("%s\t%s\t\t%d\n", 
						bankName,
						bankDB.get(i).account,
						bankDB.get(i).amount);
			}
			System.out.print("메뉴 > 1.계좌생성 2.예금 : ");
			int choice = scanner.nextInt();
			if(choice == 1) { //1.계좌생성
				System.out.println("------------- 계좌 생성 ---------------");
				
				System.out.print("1. 신한은행 2.국민은행 3.우리은행 : ");
				int bankChoice = scanner.nextInt();
				
				if(bankChoice == 1) { //1. 신한 은행
					System.out.print("이름 : "); String name = scanner.next();
					System.out.print("비밀번호 : "); String pw = scanner.next();
					
					신한 계좌 = new 신한(name,pw);
					bankDB.add(계좌);
				}else if(bankChoice == 2) { //2. 국민 은행
					System.out.print("이름 : "); String name = scanner.next();
					System.out.print("비밀번호 : "); String pw = scanner.next();
					
					국민 계좌 = new 국민(name,pw);
					bankDB.add(계좌);
				}else if(bankChoice == 3) { //3. 우리 은행 
					System.out.print("이름 : "); String name = scanner.next();
					System.out.print("비밀번호 : "); String pw = scanner.next();
					
					우리 계좌 = new 우리(name,pw);
					bankDB.add(계좌);
				}
				
			}else if(choice == 2) {//2. 예금
				System.out.print("계좌번호 : "); String account = scanner.next();

				for(int i = 0; i < bankDB.size(); i++) {
					if(bankDB.get(i).account.equals(account)) {
						System.out.print("예금액 : ");  int money = scanner.nextInt();
						bankDB.get(i).amount += money;
					}
				}
			}
		}
	}

}
