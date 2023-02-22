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
			System.out.print("1.등록[C] 2.출력[R] 3.수정[U] 4.삭제[D] : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 등록
				signup();
			}else if(choice == 2) { //2. 출력
				list();
			}else if(choice == 3) { //3.수정
				changePw();
			}else if(choice == 4) {//4. 삭제
				delete();
			}
		}
	}
	
	//회원 가입
	public void signup() {
		System.out.println("------------등록[C]------------");
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
		System.out.println("------------출력[R]------------");
		//1. 컨트롤에게 모든 [여러개-ArrayList]회원[MemberDto]들의 요청
		ArrayList<MemberDto> memberDB = MController.getInstance().list();
		System.out.printf("%2s \t %2s \t %5s \n", "no", "id", "password");
		for(MemberDto dto : memberDB) {
			System.out.printf("%2d \t %s \t %s \n",
					dto.getMno(), dto.getMid(), dto.getMpw());
//			System.out.println(dto.getMno() +"\t"+ dto.getMid() +"\t"+ dto.getMpw());
		}
	}
	
	//비밀번호 변경
	public void changePw() {
		System.out.println("------------수정[U]------------");
		System.out.print("회원 번호 : "); int no = scanner.nextInt();
		System.out.print("바꿀 비밀번호 : "); String changePw = scanner.next();
		
		boolean result = MController.getInstance().changePw(no, changePw);
		
		if(result) {
			System.out.println(no + "번 회원의 비밀번호가 바뀌었습니다.");
		}else {
			System.err.println("[에러]회원님의 비밀번호를 바꾸지 못하였습니다.[없는 회원이거나 DB에러]");
		}
	}
	
	//회원 삭제
	public void delete() {
		System.out.println("------------삭제[D]------------");
		System.out.print("삭제할 회원 번호 :"); int no = scanner.nextInt();
		
		boolean result = MController.getInstance().delete(no);
		
		if(result) {
			System.out.println(no + "번 회원이 삭제되었습니다.");
		}else {
			System.err.println("[에러]회원님을 삭제하지 못했습니다.[없는 회원이거나 DB에러]");
		}
	}
	//로그인
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
