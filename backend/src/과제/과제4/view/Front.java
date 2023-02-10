package 과제.과제4.view;

import java.util.Scanner;

import 과제.과제4.controller.BContoller;
import 과제.과제4.controller.MController;
import 과제.과제4.model.Board;

//* print scanner [ 입출력 담당]
public class Front {
	
	Scanner scanner = new Scanner(System.in); // 입력 객체
	
	MController memberContoller = new MController();
	
	BContoller boardContoller = new BContoller();
	
	//1. 메인 페이지
	public String index() { // public 전 범위
		while(true) {
			System.out.println("1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호 찾기");
			System.out.print("선택 : "); int choice = scanner.nextInt();
			
			if(choice == 1) {//1. 회원가입을 클릭시
				signup();
			}else if(choice == 2) {//2. 로그인을 클릭시
				String check = login();
				return check;
			}else if(choice == 3) {//3. 아이디찾기 클릭시
				findId();
			}else if(choice == 4) {//4. 비밀번호 찾기 클릭시
				findPassword();
			}else {
				System.err.println("[안내] 1~4번 중에 선택해주세요.");
			}
		}
	}// index e
	
	//2. 회원가입 페이지
	public void signup() {
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String password = scanner.next();
		System.out.print("비밀번호 확인 : "); String cofirmPassword = scanner.next();
		System.out.print("성명 : "); String name = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		int result = memberContoller.signup(id, password, cofirmPassword, name, phone);
		
		if(result == 1) { // 회원 가입 실패시
			System.err.println("[안내] 비밀번호가 다릅니다.");
		}else if(result == 2) { // 중복된 아이디일 경우
			System.err.println("[안내] 이미 있는 아이디입니다.");
		}else if(result == 0) { //회원가입 성공시
			System.out.println("[회원가입 성공] 환영합니다.");
		}
		
	}
	//3. 로그인 페이지
	public String login() {
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String password = scanner.next();
		
		int result = memberContoller.login(id, password);
		
		if(result == -1) { // 패스워드가 다를 경우
			System.err.println("[안내]비밀번호가 올바르지 않습니다.");
			return "-1";
		}else if(result == -2) { // 아이디가 다를 경우
			System.err.println("[안내]없는 아이디입니다.");
			return "-1";
		}else if(result >= 0) { // 로그인 성공시
			System.out.println("[로그인 성공] 환영합니다!");
		}
		
		return id;
		
	}
	
	//4. 아이디 찾기 페이지
	public void findId() {
		System.out.print("성명 : "); String name = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		String result = memberContoller.findId(name, phone);
		
	    if(result.equals("0")) {
			System.err.println("[안내]해당 정보로 회원을 찾을 수 없습니다.");
		}else {
			System.out.println(name + "회원님의 ID : " + result);
		}
		
		
	}
	//5. 비밀번호 찾기 페이지
	public void findPassword() {
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		String result = memberContoller.findPassword(id, phone);
		
	     if(result.equals("0")) {
			System.err.println("[안내]해당 정보로 회원을 찾을 수 없습니다.");
		}else {
			System.out.println(id + "의 비밀번호 : " + result);
		}
		
	}
	
	/*로그인 성공 -> 게시판 출력*/
	public void printBoard(String userId) {
		System.out.println("------------ 커뮤니티 -------------");
		for(int i = 0; i < boardContoller.nextBoard().size(); i++) {
			System.out.printf("%d\t%s\t%s\t%s\n", 
					i,
					boardContoller.nextBoard().get(i).view, 
					boardContoller.nextBoard().get(i).writer, 
					boardContoller.nextBoard().get(i).title);
		}
		System.out.print("메뉴> 1. 글쓰기 2.글보기 3. 로그아웃 : ");
		int choice = scanner.nextInt();
		
		if(choice == 1) { //1. 글쓰기 선택했을 경우
			writeBoard(userId);
		}else if(choice == 2) { //2. 글보기 선택했을 경우
			 viewBoard(userId);
		}else if(choice == 3) { //3. 로그아웃 선택했을 경우
			logOut();
		}else{//그외
			System.err.println("[안내]1~3번 중에 선택해주세요.");
		}
		
	}
	
	public void writeBoard(String userId) { //글쓰기 함수
		System.out.println("------------ 글 쓰기 -------------");
		System.out.print("제목 : "); String title = scanner.next(); scanner.nextLine();
		System.out.print("내용 : "); String content = scanner.nextLine();
		
		int result = boardContoller.writeBoard(title, content, userId);
		
		if(result == 0) {//성공
			System.out.println("게시물이 등록되었습니다.");
			printBoard(userId); //게시물이 등록되었으면 게시물 창으로 다시 돌아간다.
			
		}else if(result == 1) {//실패
			System.err.println("[안내] 게시물을 등록하지 못하였습니다.");
		}
	}
	
	public void viewBoard(String userId) {// 글보기 함수
		System.out.println("------------ 글 보기 -------------");
		System.out.print("보고싶은 인덱스 : "); int index = scanner.nextInt();
		Board selectBoard = boardContoller.viewBoard(index);
		System.out.println("------------ 글 상세 -------------");
		System.out.println("제목 : " + selectBoard.title);
		System.out.printf("작성자 : %s \t 조회수 : %d\n", selectBoard.writer, selectBoard.view);
		System.out.println("내용 : " + selectBoard.content);
		
		System.out.print("메뉴> 1.글삭제 2.글수정 3.뒤로가기 : ");
		int choice = scanner.nextInt();
		
		if(choice == 1) { //1. 글삭제를 눌렀을 경우
			deleteBoard(userId, index);
		}else if(choice == 2) {//2. 글 수정을 눌렀을 경우
			changeBoard(userId);
		}else if(choice == 3) {//3. 뒤로 가기를 눌렀을 경우 -> viewBoard()
			printBoard(userId);
		}else {
			System.err.println("[안내] 1~3번 중에 선택해주세요.");
		}
	}
	
	/*글 삭제 함수*/
	public void deleteBoard(String userId, int index) { 
		//아이디는 해당 작성자가 맞는지 확인용. index는 삭제할 인덱스 가져오기
		int successOX = boardContoller.deleteBoard(userId, index);
		
	}
	
	/*글 수정 함수*/
	public void changeBoard(String userId) {
		
	}
	public void logOut() {//로그아웃 함수
		index();//index로 돌아감
	}
	
}
