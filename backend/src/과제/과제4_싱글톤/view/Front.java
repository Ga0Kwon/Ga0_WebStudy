package 과제.과제4_싱글톤.view;

import java.util.Scanner;

import Day09.Ex10_게시판.contoller.Bcontroller;
import 과제.과제4_싱글톤.contoller.BController;
import 과제.과제4_싱글톤.contoller.MController;
import 과제.과제4_싱글톤.model.Board;

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
		System.out.print("아이디 : ");  String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		System.out.print("비밀번호 확인 : "); String confirmPw = scanner.next();
		System.out.print("이름 : "); String name = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
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
		System.out.print("아이디 : ");  String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		
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
		System.out.print("이름 : ");  String name = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
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
		System.out.print("아이디 : ");  String id = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		String result = MController.getInstance().findPw(id, phone);
		
		if(result == null) {
			System.err.println("[알림] 비밀번호 찾기 실패");
		}else {
			System.out.println("[알림] 비밀번호 찾기 성공. 비밀번호는" + result + "입니다.");
		}
		
	}
	
	//6. 로그인 성공시 게시물 출력페이지
	public void board_page() { 
		while(true) {//[종료조선 : 3입력시 break;]
			System.out.println("---------------------게시글-------------------");
			System.out.println("번호\t조회수\t작성자\t제목");
			int i = 0; //인덱스 용도
			for(Board b : BController.getInstance().getList()) {
				System.out.println(i + "\t" + b.getView() + "\t" + b.getMember().getId() + 
						"\t" + b.getTitle());
			}
			//메뉴
			System.out.print("1. 쓰기 2. 글보기 3. 로그아웃 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 쓰기
				board_write();
			}else if(choice == 2) { //2. 글보기
				board_view();
			}else if(choice == 3) {// 3. 로그아웃
				MController.getInstance().logOut(); 
				break; 
			}
		}
//		System.out.println("로그아웃 후 : " + MController.getInstance().getLogSeasion().toString());
	}
	
	//7. 게시물 쓰기 페이지
	public void board_write() {
		System.out.println("--------------------------글쓰기 페이지-----------------------");
		System.out.print("제목 : "); String title = scanner.next();
		System.out.print("내용 : "); String content = scanner.next();
		boolean result = BController.getInstance().write(title, content);
		
		if(result) {
			System.out.println("[알림] 글 작성 성공");
		}else {
			System.err.println("[알림] 글 작성 실패");
		}
	}
	
	//8. 게시물 상세 페이지
	public void board_view() {
		System.out.println("*이동할 게시물 번호[인덱스] : ");
		int bno = scanner.nextInt();
		Board result = BController.getInstance().getBoard(bno);
		
		System.out.println("제목 : " + result.getTitle());
		System.out.println("작성자 : " + result.getMember().getId() + "\t\t조회수 : " + result.getView());
		System.out.println("내용 : " + result.getContent());
		
		System.out.print("1. 삭제 2. 수정 3. 뒤로가기 : ");
		int choice = scanner.nextInt();
		
		if(choice == 1) {//1. 삭제
			board_delete();
		}else if(choice == 2) {//2. 수정
			board_update();
		}else if(choice == 3) {//3. 뒤로가기
			return;
		}
		
	}
	
	//9. 게시물 수정 페이지 
	public void board_update() {
		
	}
	
	//10. 글 삭제 페이지
	public void board_delete() {
		
	}
}
