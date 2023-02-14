package 과제.과제4_싱글톤.view;

import java.util.Scanner;

import 과제.과제4_싱글톤.contoller.MController;

public class Front {
	private Scanner scanner = new Scanner(System.in);
	
	// * 싱글톤 
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	//1. 메인페이지
	public void index() {
		while(true) {
			System.out.println("-----------------------커뮤니티--------------------");
			System.out.print("1. 회원가입 2. 로그인 3. 마이페에지 4. 비밀번호 찾기 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) {signup_page();}
			else if(choice == 2) {login_page();}
			else if(choice == 3) {findId_page();}
			else if(choice == 4) {findPw_page();}
		}//while e
	}
	
	//2. 회원가입 페이지
	public void signup_page() {
		//1. 입력
		System.out.println("아이디 : ");  String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		System.out.println("비밀번호 확인 : "); String confirmPw = scanner.next();
		System.out.println("이름 : "); String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		//2. contoller에 전달
		int result = MController.getInstance().signup(id, pw, confirmPw, name, phone);
		
		if(result == 0) {
			System.out.println("[알림] 회원가입 성공. 감사합니다.");
		}else if(result == 1) {
			System.err.println("[알림] 회원가입 실패. 비밀번호가 서로 다릅니다.");
		}
	}
	
	//3. 로그인 페이지
	public void login_page() {
		//1. 입력
		System.out.println("아이디 : ");  String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		
		int result = MController.getInstance().login(id, pw);
		
		if(result == -1) {
			System.err.println("[알림] 로그인 실패. 비밀번호가 올바르지 않습니다.");
		}else if(result == -2) {
			System.err.println("[알림] 로그인 실패. 아이디가 올바르지 않습니다.");
		}else { //그 외
			System.out.println("[알림] 로그인 성공. 안녕하세요.");
			//로그인 성공시 다음 front 메소드로 이동 => 게시물을 볼 수 있도록 board_page()로 이동
			board_page(); 
		}
	}
	
	//4. 아이디 찾기 페이지
	public void findId_page() {
		//1. 입력
		System.out.println("이름 : ");  String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		String result = MController.getInstance().findId(name, phone);
		
		if(result == null) {
			System.err.println("[알림] 아이디 찾기 실패");
		}else {
			System.out.println("[알림] 아이디 찾기 성공. 아이디는" + result + "입니다.");
		}
		
	}
	
	//5. 비밀번호 찾기 페이지
	public void findPw_page() {
		//1. 입력
		System.out.println("아이디 : ");  String id = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		String result = MController.getInstance().findPw(id, phone);
		
		if(result == null) {
			System.err.println("[알림] 비밀번호 찾기 실패");
		}else {
			System.out.println("[알림] 비밀번호 찾기 성공. 비밀번호는" + result + "입니다.");
		}
		
	}
	
	//6. 로그인 성공시 게시물 출력페이지
	public void board_page() {
		
	}
	
	//7. 게시물 쓰기 페이지
	public void board_write() {
		
	}
	
	//8. 게시물 상세 페이지
	public void board_view() {
		
	}
	
	//9. 게시물 수정 페이지 
	public void board_update() {
		
	}
}
