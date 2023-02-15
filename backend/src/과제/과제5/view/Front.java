package 과제.과제5.view;

import java.util.Scanner;

import 과제.과제5.controller.MembController;
import 과제.과제5.controller.ProdContoller;
import 과제.과제5.model.Product;

public class Front {
	//* 싱글톤
	private Scanner scanner = new Scanner(System.in);
	
	private static Front front  = new Front();
	
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	public void index() {
		while(true) {
			System.out.println("-------------------------중고 마켓-----------------------");
			System.out.print("1. 회원가입 2. 로그인 3. 마이페이지 : ");
			int choice = scanner.nextInt(); //중고마켓 메뉴 선택
			
			if(choice == 1) {//1. 회원가입
				signUp();
			}else if(choice == 2) {//2. 로그인
				logIn();
			}else if(choice == 3) {//3. 마이페이지 
				myPage();
			}
		}
		
	}
	/*회원가입*/
	public void signUp() {
		//1. 입력 [ 아이디와 비밀번호]
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String pw = scanner.next();
		System.out.print("비밀번호 확인 : "); String confirmPw = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		boolean result = MembController.getInstance().signUp(id, pw, confirmPw, phone);
		
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
		
		if(result == -1) {//비밀번호가 틀렸을 경우
			System.err.println("[안내] 비밀번호가 올바르지 않습니다.");
		}else if(result == -2) { //없는 아이디일 경우
			System.err.println("[안내] 없는 아이디입니다.");
		}else {//로그인 성공시
			System.out.println("[안내] 로그인 성공! 안녕하세요.");
			printProduct();
		}
	}
	
	/*마이페이지*/
	public void myPage() {
		System.out.println("-------------------------마이 페이지-------------------------");
		System.out.print("1. 받은 쪽지함 \t\t 2. 보낸 쪽지함 : "); int choice = scanner.nextInt();
		if(choice == 1) { //1. 받은 쪽지함
			printRecvMemo();
		}else if(choice == 2) { //2. 보낸 쪽지함
			printSendMemo();
		}
	}
	/*받은 쪽지함*/
	public void printRecvMemo() {
		
	}
	
	/*보낸 쪽지함*/
	public void printSendMemo() {
		
	}
	
	/*제픔 목록*/
	public void printProduct() {
		while(true) {
			System.out.println("--------------------------제품 목록 리스트-----------------------");
			System.out.println("제품이름 \t\t\t 제품 가격 \t\t\t 제품상태");
			for(int i = 0; i < ProdContoller.getInstance().getList().size(); i++) {
				System.out.printf("%d \t\t %s \t\t %d \t\t %s",
						i,
						ProdContoller.getInstance().getList().get(i).getProdName(),
						ProdContoller.getInstance().getList().get(i).getProdPrice(),
						ProdContoller.getInstance().getList().get(i).getProdState() ? "판매중" : "판매완료");
			}
			System.out.print("1. 제품 등록 2. 제품 상세 보기 3. 뒤로 가기 : ");
			int choice = scanner.nextInt();
			if(choice == 1) { //1. 제품 등록
				registerProduct();
			}else if(choice == 2) { //2. 제품 상세 보기
				System.out.println("상세 보기 할 제픔 번호 : "); int index = scanner.nextInt();
				viewProduct(index);
			}else if(choice ==3) {//3. 뒤로 가기 :
				return; //index쪽으로 돌아감.
			}
		}
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
	
	/*제품 상세 보기*/
	public void viewProduct(int index) {
		System.out.println("--------------------------제품 상세 페이지-----------------------");
		/*코드가 길어져서, 해당 인덱스의 객체를 변수에 저장*/
		Product pd = ProdContoller.getInstance().getList().get(index);
		System.out.println("제품 이름 : " + pd.getProdName());
		System.out.println("제품 내용 : " + pd.getProdContent());
		System.out.println("제품 가격 : " + pd.getProdPrice() + "원\t 제품 상태 : " + (pd.getProdState() ? "판매중" : "판매완료"));
		System.out.println("-----------------------------------------------------------");
		
		/*멤버의 로그인된 객체의 Mno[회원번호]와 해당 인덱스의 제품을 등록한 mno이 같다면*/
		if(MembController.getInstance().getLogSeasion().getMno() == pd.getMno()) {
			/*누군지에 따라 화면을 다르게 보여주기 위함*/
			System.out.print("1. 제픔 삭제 2. 제픔 수정 3. 뒤로가기");
			int choice = scanner.nextInt();
			if(choice == 1) { //1. 제픔 삭제
				deleteProduct(index);
			}else if(choice == 2) { //2. 제픔 수정
				
			}else if(choice == 3) { // 3. 뒤로가기
				return; //printProduct()로 돌아감
			}
		}else {
			System.out.print("1. 쪽지보내기 2. 뒤로가기");
			int choice = scanner.nextInt();
			
			if(choice == 1) {
				
			}else if(choice == 2) { // 2. 뒤로가기
				return; //printProduct()로 돌아감
			}
		}
	}
	
	/*제품 삭제*/
	public void deleteProduct(int index) {
		boolean result = ProdContoller.getInstance().deleteProduct(index);
		
		if(result) {
			System.out.println("[안내] 해당 제품이 삭제완료되었습니다.");
		}else {
			System.err.println("[안내] 해당 제품 삭제 실패하였습니다.");
		}
	}
	
	/*제품 수정*/
	
	/*족지 보내기*/
	
}
