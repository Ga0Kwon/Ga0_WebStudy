package 과제.과제9.interfaceExample.Ex3;

import java.util.Scanner;

public class 실행 {
	static Scanner scanner = new Scanner(System.in);
	static 앱 앱구동;
	public static void main(String[] args) {
		while(true) {
			System.out.println("휴대폰을 전원을 켭니다.");
			System.out.print("1. 카카오톡 2. 인스타그램 3. 유튜브 4 전원 끄기: ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				카카오톡 카카오톡 = new 카카오톡();
				앱구동(카카오톡);
				
			}else if(choice == 2){
				인스타그램 인스타그램 = new 인스타그램();
				앱구동(인스타그램);
			}else if(choice == 3) {
				유튜브 유튜브 = new 유튜브();
				앱구동(유튜브);
			}else if(choice  == 4) {
				System.out.println("휴대폰을 전원을 끕니다.");
				break;
			}
		}
	}
	
	public static void 앱구동(앱 앱대상) {
		앱구동 = 앱대상;
		앱대상.turnOnApp();
		while(true) {
			System.out.print("1. 앱사용 2. 앱 끄기 : ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				if(앱구동 instanceof 카카오톡) {
					System.out.print("채팅할 친구 : ");
					String name = scanner.next();
					((카카오톡) 앱구동).chat(name);
				}else if(앱구동 instanceof 인스타그램) {
					System.out.print("좋아요할 아이디 : ");
					String id = scanner.next();
					((인스타그램) 앱구동).like(id);
				}else if(앱구동 instanceof 유튜브) {
					System.out.print("시청할 영상 제목 : ");
					String title = scanner.next();
					((유튜브) 앱구동).video(title);
				}
			}else if(choice == 2) {
				앱대상.turnOffApp();
				break;
			}
		}
	}
}
