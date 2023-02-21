package Day15.Ex9_MVC.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day15.Ex9_MVC.controller.MController;
import Day15.Ex9_MVC.model.MemberDto;

public class Front {
	private Scanner scanner = new Scanner(System.in);
	
	// * 싱글톤
	private static Front front = new Front();
	
	private Front() {}
	
	public static Front getInstance() {
		return front;
	}
	
	//메인 페이지
	public void index() {
		while(true) {
			System.out.println("------------------------------");
			System.out.print("1.등록 2.출력 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 등록
				signup();
			}else if(choice == 2) { //2. 출력
				list();
			}else if(choice == 3) {
				
			}else if(choice == 4) {
				
			}
		}
	}
	
	//회원 가입
	public void signup() {
		System.out.print("ID : "); String id = scanner.next();
		System.out.print("PASSWORD : "); String pw = scanner.next();
		
		boolean result = MController.getInstance().signup(id, pw);
		
		if(result) {
			System.out.println("회원 가입 성공");
		}else {
			System.err.println("회원 가입 실패");
		}
	}
	//출력
	public void list() {
		ArrayList<MemberDto> memberDB = MController.getInstance().list();
		
		for(MemberDto dto : memberDB) {
			System.out.println(dto.getMno() +"\t"+ dto.getMid() +"\t"+ dto.getMpw());
		}
	}
	//회원 가입
	public void login() {
		System.out.print("ID : "); String id = scanner.next();
		System.out.print("PASSWORD : "); String pw = scanner.next();
		
		int result = MController.getInstance().logIn(id, pw);
		
		if(result == -2) {
			System.out.println("[로그인 실패] DB 에러");
		}else if(result == -1) {
			System.err.println("[로그인 실패] 해당 계정을 찾을 수 없음.");
		}else {
			System.out.println("로그인 성공");
		}
	}
	
	
}
