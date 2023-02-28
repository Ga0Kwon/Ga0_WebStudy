package Day20.gallery.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import Day20.gallery.controller.MemberController;

public class IndexView {
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static IndexView iv = new IndexView();
	private IndexView() {}
	public static IndexView getInstance() {
		return iv;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	//1. 메인 페이지
	public void index() {
		while(true) {
			System.out.println("========================== 갤러리 ==========================");
			
			System.out.print("1. 회원 가입   2. 로그인 : ");
			try {
				int choice = scanner.nextInt();
				if(choice == 1) { //1.회원 가입
					signUp();
				}else if(choice == 2) {//2. 로그인
					login();
				}
			}catch(Exception e) {
				System.err.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	//회원 가입 페이지
	public void signUp() throws Exception{ // 만일 해당 메소드에서 예외[오류] 발생하면 해당 메소드를 호출했던 곳으로 예외 이동
		System.out.println("========================== 회원가입 ==========================");
		System.out.print("아이디 : "); String memberId = scanner.next();
		System.out.print("비밀번호 : "); String memberPw = scanner.next();
		System.out.print("이름 : "); String memberName = scanner.next();
		System.out.print("전화번호 : "); String memberPhone = scanner.next();
		
		int result = MemberController.getInstance().signUp(memberId, memberPw, memberName, memberPhone);
		
		if(result == 1) {
			System.out.println("[성공] 회원가입이 되었습니다.");
		}else if(result == 2) {
			System.err.println("[실패] 사용중인 아이디입니다.");
		}else if(result == 3) {
			System.err.println("[실패] 데이터 시스템 오류 : 관리자에게 문의하세요.");
		}
	}
	
	//로그인
	public void login() throws Exception{
		System.out.println("========================== 로그인 ==========================");
		System.out.print("아이디 : "); String memberId = scanner.next();
		System.out.print("비밀번호 : "); String memberPw = scanner.next();
		
		String result = MemberController.getInstance().login(memberId, memberPw);
		
		if(result == null) {
			System.err.println("[실패] 없는 회원 입니다.");
		}else if(result.equals("ERROR")) {
			System.err.println("[실패] 데이터 시스템 오류 : 관리자에게 문의하세요.");
		}else {
			System.out.println("[성공] "+result + "님 환영합니다.");
			//게시물 초기화면으로 이동 [로그인 성공시]
			BoardView.getInstance().index(); 
		}
	}
}
