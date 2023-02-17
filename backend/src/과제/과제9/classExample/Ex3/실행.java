package 과제.과제9.classExample.Ex3;

import java.util.Scanner;

public class 실행 {
	static 트레이너 트레이너 = new 트레이너();
	static 헬스방문객 방문객  = new 헬스방문객();
	static 헬스회원 회원 = new 헬스회원();
	
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		while(true) {
			System.out.println("-------------헬스장------------");
			System.out.println("1. 트레이너 2. 헬스장회원 3. 방문객");
			System.out.print("헬스장 이용 대상 선택 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) {
				trainer();
			}else if(choice == 2) {
				System.out.print("이름을 입력 : ");
				String name = scanner.next();
				member(name);
			}else if(choice == 3) {
				visitor();
			}
		}
	}
	
	public static void trainer() {
		트레이너.entrance();
		while(true) {
			System.out.print("1. 회원 시간 체크 2. 운동[가르치기] 3. 퇴근 : ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				트레이너.checkTime();
			}else if(choice == 2) {
				if(회원.name == null) {
					System.out.println("아직 헬스장에 도착하신 회원이 없습니다");
				}else {
					트레이너.teach(회원);
				}
				
			}else if(choice == 3) {
				트레이너.leave();
				break;
			}
		}
	}
	
	public static void member(String name) {
		회원.entrance();
		회원.name = name;
		while(true) {
			System.out.print(" 1. 운동[배우기/혼자] 2. 퇴장 : ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				System.out.print("1. 배우기 2. 혼자 : ");
				int ch = scanner.nextInt();
				if(ch == 1) {
					회원.exercise(1);
				}else if(ch == 2) {
					회원.exercise(2);
				}
			}else if(choice == 2) {
				회원.leave();
				break;
			}
		}
	}
	
	public static void visitor() {
		방문객.entrance();
		while(true) {
			System.out.print(" 1. 상담 2. 이용권 결제 3. 퇴장 : ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				방문객.consults();
			}else if(choice == 2) {
				System.out.print("[이용권] 개월 수 [숫자로만] : ");
				int months = scanner.nextInt();
				방문객.payment(months);
			}else if(choice == 3) {
				방문객.leave();
				break;
			}
		}
	}
}
