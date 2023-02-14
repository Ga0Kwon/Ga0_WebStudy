package 과제.과제5.view;

import java.util.Scanner;

public class Front {
	//* 싱글톤
	private Scanner scanner = new Scanner(System.in);
	
	private static Front front  = new Front();
	
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	public void index() {
		System.out.println("-------------------------중고 마켓-----------------------");
		System.out.print("1. 회원가입 2. 로그인 3. 마이페이지 : ");
		
	}
	/*회원가입*/
	public void signUp() {
		//1. 입력 [ 아이디와 비밀번호]
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
	}
	/*제품 등록*/
	public void prodSubmit() {
		System.out.println("--------------------------제품 등록 페이지-----------------------");
		System.out.print("제품 이름 : "); String title = scanner.next(); scanner.nextLine();
		System.out.print("제품 설명 : "); String content = scanner.nextLine();
		System.out.print("제품 가격 : "); int price = scanner.nextInt();
	}
}
