package 과제.과제9.interfaceExample.Ex2;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		동물 동물;
		while(true) {
			System.out.println("동물들이 어케 우나?");
			System.out.print("1. 고양이 2. 강아지 3. 돼지 : ");
			int choice = scanner.nextInt();
			if(choice == 1) {
				동물 = new 고양이();
				동물.울음소리();
			}else if(choice == 2) {
				동물 = new 강아지();
				동물.울음소리();
			}else if(choice == 3) {
				동물 =  new 돼지();
				동물.울음소리();
			}
		}
	}
}
