package Day09.Ex10_게시판.view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.contoller.Bcontroller;
import Day09.Ex10_게시판.model.Board;

public class Front {
	//1. 싱글톤 객체 [ 1. 프로그램내 하나의 객체 = 공유 메모리]
	private static Front front = new Front();
	
	private Front() {}
	
	public static Front getInstance() {
		return front;
	}
	
	// 필드 : 입력 객체 [인스턴스 멤버]
	private Scanner scanner = new Scanner(System.in);
	//2. index 함수
	public void index() {
		while(true) {
			System.out.print("1.쓰기 2. 보기 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 쓰기 선택
				write_page();
			}else if(choice == 2) { //2. 보기 선택
				view_page();
			}
		}
	}
	//날짜 포맷 값
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		
	//3. 쓰기 페이지 함수
	private void write_page() {
		System.out.println("-------------------글쓰기 페이지-------------------");
		scanner.nextLine();
		System.out.print("제목 : "); String title = scanner.nextLine();
		System.out.print("내용 : "); String content = scanner.nextLine();
		System.out.print("비밀번호 : "); String password = scanner.next();
		System.out.print("작성자 : "); String writer = scanner.next();
		
		Date date = new Date();
		String format_date = formatter.format(date);
		
		int view = 0;
		
		boolean checkWrite = Bcontroller.getInstance().write_board(title, content, password, writer, format_date, view);
		
		if(checkWrite == true) {
			System.out.println("게시글이 등록되었습니다.");
			print_page();
		}else {
			System.err.println("게시글을 등록하지 못하였습니다.");
		}
	}
	
	//4. 출력 페이지
	private void print_page() {
		System.out.println("-------------------글보기 페이지-------------------");
		System.out.println("번호 \t 제목 \t 작성자 \t 조회수 \t 작성일");
		for(int i = 0; i < Bcontroller.getInstance().print().size(); i++) {
			System.out.printf("%d \t %s\t %s \t %d \t %s\n",
					i,
					Bcontroller.getInstance().print().get(i).getTitle(),
					Bcontroller.getInstance().print().get(i).getWirter(),
					Bcontroller.getInstance().print().get(i).getView(),
					Bcontroller.getInstance().print().get(i).getDate());
		}
		System.out.println("-----------------------------------------------");
	}
	//5. 글 상세 출력 페이지 함수
	private void view_page() {
		System.out.println("-------------------글상세 페이지-------------------");
		System.out.print("보고싶은 번호/인덱스 : "); int index = scanner.nextInt();
		
		Board board = Bcontroller.getInstance().look_board(index);
		
		System.out.printf("-------------------%d번째 글----------------------\n", index);
		System.out.printf("제목 : %s \t\t\t 조회수 : %d\n", board.getTitle(), board.getView());
		System.out.println("내용 : " + board.getContent());
		System.out.println("작성자 : " + board.getWirter());
		System.out.println("작성일 : " + board.getDate());
		System.out.println("-----------------------------------------------");
		System.out.print(">> 1. 뒤로가기 2. 삭제 3. 수정 : "); 
		int choice = scanner.nextInt();
		
		if(choice == 1) { //1. 뒤로가기 
			
		}else if(choice == 2) {//2. 삭제
			
		}else if(choice == 3) {//3. 수정
			
		}
	}
}
