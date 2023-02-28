package Day20.gallery.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.gallery.controller.BoardController;
import Day20.gallery.controller.MemberController;
import Day20.gallery.model.dto.BoardDto;
import Day20.gallery.model.dto.CateogryDto;

public class BoardView {
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static BoardView bv = new BoardView();
	private BoardView() {}
	public static BoardView getInstance() {
		return bv;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	//1. 메인 페이지
	public void index() {
		while(true) {
			System.out.println("========================== 갤러리 ==========================");
			printCategory();
			System.out.println();
			
			System.out.print("-1 : 로그아웃 / 0 : 갤러리 추가 / 이동할 갤러리 번호 선택 : ");
			try {
				int choice = scanner.nextInt();
				if(choice == 0) { //1. 갤러리 추가  
					addCategory();
				}else if(choice == -1) { //-1. 로그아웃 
					MemberController.getInstance().setLogInMemberNo(-1);
					return;
				}else {
					printLimitBoard(choice);
				}
			}catch(Exception e) {
				System.err.println("잘못된 입력입니다.");
				scanner = new Scanner(System.in);
			}
		}
	}
	//카테고리 추가
	public void addCategory() {
		System.out.println("========================== 갤러리 추가 ==========================");
		System.out.print("추가할 갤러리 이름 : "); scanner.nextLine(); 
		String categoryName = scanner.nextLine();
		
		boolean result = BoardController.getInstance().addCategory(categoryName);
		
		if(result) {
			System.out.println("[성공] 갤러리 카테고리가 추가되었습니다.");
		}else {
			System.err.println("[실패] 관리자에게 문의해주세요.");
		}
	}
	
	//모든 카테고리 출력[ 갤러리 = dto 1개/ 갤러리 여러개 = dto 여러개 = 배열 혹은 리스트 ] 호출
	public void printCategory() {
		ArrayList<CateogryDto> categoryList = BoardController.getInstance().printCategory();
		
//		for(int i = 0; i < categoryList.size(); i++) {
//			System.out.println(categoryList.get(i).getCategoryNo()
//					+ "-" + categoryList.get(i).getCategoryName());
//		}
		
		int count = 0;
		for(CateogryDto dto : categoryList) {
			System.out.print(dto.getCategoryNo() + " - " + dto.getCategoryName()+ " \t ");
			count++;
			if(count != 0 && count % 4 == 0) {System.out.println();}
		}
	}
	
	//게시물 3개만 출력하기 [카테고리별]
	public void printLimitBoard(int CategoryNo) throws Exception{
		while(true) {
			ArrayList<BoardDto> boardDB = BoardController.getInstance().printLimitBoard(CategoryNo);
			System.out.println("========================== 갤러리 ==========================");
			System.out.println("번호 \t\t 제목 \t\t\t\t 작성일");
			System.out.println("----------------------------------------------------------");
			for(BoardDto dto : boardDB) {
				System.out.printf("%d \t %s \t %s \n", 
						dto.getBoardNo(),
						dto.getBoardTitle(),
						dto.getBoardDate());
			}
			System.out.print("1. 갤러리 모든 목록 보기  2. 갤러리 글 쓰기  3. 뒤로가기");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 상세 보기
				
			}else if(choice == 2) { //2. 갤러리 글쓰기
				writeBoard(CategoryNo);
			}else if(choice == 3) { //3. 뒤로 가기
				
			}
		}
	}
	
	public void printWholeBoard(int CategoryNo) {
		ArrayList<BoardDto> boardDB = BoardController.getInstance().printWholeBoard(CategoryNo);
		System.out.println("========================== 갤러리 ==========================");
		System.out.println("번호 \t\t 제목 \t\t\t\t 작성일");
		System.out.println("----------------------------------------------------------");
		for(BoardDto dto : boardDB) {
			System.out.printf("%d \t %s \t %s \n", 
					dto.getBoardNo(),
					dto.getBoardTitle(),
					dto.getBoardDate());
		}
		System.out.print("1. 상세 보기 2. 뒤로 가기");
		int choice = scanner.nextInt();
		
		if(choice == 1) {
			
		}else if(choice == 2) {
			return;
		}
	}
	
	public void writeBoard(int CategoryNo) {
		System.out.print("제목 : "); scanner.nextLine(); String boardTitle = scanner.nextLine();
		System.out.print("내용 : "); String boardContent = scanner.nextLine();
		
		boolean result = BoardController.getInstance().writeBoard(boardTitle, boardContent, CategoryNo);
		
		if(result) {
			System.out.println("[성공] 게시물 등록되었습니다.");
		}else {
			System.err.println("[실패] 게시물을 등록할 수 없습니다. 관리자에게 문의하세요.");
		}
	}
}
