package Day09.Ex10_게시판.contoller;

import java.util.ArrayList;
import java.util.Date;

import Day09.Ex10_게시판.model.Board;


public class Bcontroller {
	private ArrayList<Board> boardList = new ArrayList<>();
	
	//1. 싱글톤 객체
	private static Bcontroller bc = new Bcontroller();
	
	private Bcontroller() {}
	
	public static Bcontroller getInstance() {
		return bc;
	}
	
	/*글쓰기 함수*/
	public boolean write_board(String title, String content, String password, String writer, String date, int view) {
		
		int prev = boardList.size() ;
		
		Board board= new Board(title, content, password, writer, date, view);
		boardList.add(board);
		
		if(prev < boardList.size()) {
			return true;
		}
		
		return false;
	}
	/*전체 글 출력*/
	public ArrayList<Board> print() {
		return boardList;
	}
	
	/*글 보기 함수[상세]*/
	public Board look_board(int index) {
		
		boardList.get(index).setView(boardList.get(index).getView()+1); // 조회수 증가
		
		return boardList.get(index);
	}
	
}
