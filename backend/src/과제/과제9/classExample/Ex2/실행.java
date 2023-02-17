package 과제.과제9.classExample.Ex2;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		VIP회원 vip = new VIP회원();
		RVIP회원 rvip = new RVIP회원();
		VVIP회원 vvip = new VVIP회원();
		vvip.views = 40;
		rvip.views = 20;
		vip.views = 10;
		
		vvip.point = 9; //vvip는 point가 9씩 쌓임
		rvip.point = 6; //rvip는 point가 6씩 쌓임
		vip.point = 3; //vip는 point가 3씩 쌓임
		
		while(true) {
			System.out.println("회원님의 등급을 선택해주세요.");
			System.out.println("1. vip  2. rvip 3. vvip 4. 회원별 해택 보기");
			int choice = scanner.nextInt();
			if(choice == 1) {
				System.out.println("vip 존");
				System.out.println("영화를 관람하시겠습니까?");
				System.out.println("1. YES 2.NO");
				int ch = scanner.nextInt();
				if(ch == 1) {
					
					vip.viewMovies();
					
				}else if(ch == 2) {
					continue;
				}
				
			}else if(choice == 2) {
				System.out.println("rvip 존");
				System.out.println("영화를 관람하시겠습니까?");
				System.out.println("1. YES 2.NO");
				int ch = scanner.nextInt();
				if(ch == 1) {
					rvip.viewMovies();
					
				}else if(ch == 2) {
					continue;
				}
			}else if(choice == 3) {
				System.out.println("vvip 존");
				System.out.println("영화를 관람하시겠습니까?");
				System.out.println("1. YES 2.NO");
				int ch = scanner.nextInt();
				if(ch == 1) {

					vvip.viewMovies();
					
				}else if(ch == 2) {
					continue;
				}
			}else if(choice == 4) {
				System.out.println("1. vip 2. rvip 3. vvip");
				int ch  = scanner.nextInt();
				if(ch == 1) {
					vip.printInfo();
				}else if(ch == 2) {
					rvip.printInfo();
				}else if(ch == 3) {
					vvip.printInfo();
				}
			}
			

		}

		
	}

	
}
