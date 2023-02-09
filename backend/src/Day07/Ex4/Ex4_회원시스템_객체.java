package Day07.Ex4;

import java.util.Scanner;

public class Ex4_회원시스템_객체 {//class s
	public static void main(String[] args) {//main s
		Scanner scanner = new Scanner(System.in);
		
		Member[] memberList = new Member[3]; //Member 객체 3개 저장하는 배열
		
		while(true) {//무한 반복 while s
			
			// 출력
			System.out.println("번호\t회원명\t전화번호");
			for(int i = 0; i  < memberList.length; i++) {
				if(memberList[i] != null) {
					System.out.printf("%d \t %s \t %s", i, memberList[i].name, memberList[i].phone);
				}
			}
			
			System.out.print("1. 회원 등록  2. 회원 삭제 : ");
			int choice= scanner.nextInt();
			
			if(choice == 1) {
				System.out.print("회원명 : "); String name = scanner.next();
				System.out.print("전화번호 : ");String phone = scanner.next();
				
				/* name + "," + phone; => 문제점이 많음. [X]
				   객체 만들기 [ O ] */
				for(int i = 0; i < memberList.length; i++) {
					if(memberList[i] == null) { //비어 있으면
						Member member = new Member(); //객체 생성
						member.name = name; // 객체에 입력받은 값을 해당 필드에 대입
						member.phone = phone; // 객체에 입력받으 값을 해당 필드에 대입
						memberList[i] = member; //객체를 배열에 저장
						break;
					}
				}
			}else if(choice == 2) {
				
			}else {
				
			}
		}//while e
	}//main e
}//class e
