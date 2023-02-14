package 과제.과제5.view;

import java.util.Scanner;

import 과제.과제5.controller.MembController;
import 과제.과제5.controller.ProdContoller;

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
		int choice = scanner.nextInt(); //중고마켓 메뉴 선택
		
		
	}
	/*회원가입*/
	public void signUp() {
		//1. 입력 [ 아이디와 비밀번호]
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		System.out.print("비밀번호 확인 : "); String confirmPw = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		boolean result = MembController.getInstance().signUp(id, pw, pw, phone);
		
		if(result) {
			System.out.println("[안내] 회원가입 성공! 감사합니다.");
		}else {
			System.err.println("[안내] 회원가입 실패. 비밀번호가 다릅니다.");
		}
	}
	/*로그인*/
	public void logIn() {
		//1. 로그인
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		
		int result = MembController.getInstance().logIn(id, pw);
		
		if(result == -1) {
			System.err.println("[안내] 비밀번호가 올바르지 않습니다.");
		}else if(result == -2) {
			System.err.println("[안내] 없는 아이디입니다.");
		}else {
			System.out.println("[안내] 로그인 성공! 안녕하세요.");
		}
	}
	
	/*마이페이지*/
	public void myPage() {
		System.out.println("-------------------------마이 페이지-------------------------");
		System.out.print("1. 받은 쪽지함 \t\t 2. 보낸 쪽지함 : "); int choice = scanner.nextInt();
		if(choice == 1) { //1. 받은 쪽지함
			
		}else if(choice == 2) { //2. 보낸 쪽지함
			
		}
	}
	/*받은 쪽지함*/
	public void receiveMemoBox() {
		
	}
	
	/*보낸 쪽지함*/
	public void sendMemoBox() {
		
	}
	/*제품 등록*/
	public void registerProduct() {
		System.out.println("--------------------------제품 등록 페이지-----------------------");
		System.out.print("제품 이름 : "); String title = scanner.next(); scanner.nextLine();
		System.out.print("제품 설명 : "); String content = scanner.nextLine();
		System.out.print("제품 가격 : "); int price = scanner.nextInt();
		
		int result = ProdContoller.getInstance().registerProduct(title, price, content);
		
		if(result == -1) {// 로그인이 안된 상태 => 로그인 해야 이 화면을 보여지기에 의미없는 코드임
			System.err.println("[안내] 로그인을 해주세요");
		}else if(result == -2) {
			System.err.println("[안내] 회원님의 정보를 찾지 못했습니다.");
		}else {
			System.out.println("[안내] 제품 등록이 완료되었습니다.");
		}
	}
}
