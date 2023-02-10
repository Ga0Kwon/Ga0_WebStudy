package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Board;

public class BContoller {
	ArrayList<Board> boardList = new ArrayList<>();
	
	/*해당 게시물 목록을 전달하는 함순*/
	public ArrayList<Board> nextBoard() {
		// TODO Auto-generated method stub
		return boardList;
	}
	
	public int writeBoard(String title, String content, String writer) {
		int prev = boardList.size(); //등록하기전의 사이즈
		
		Board board = new Board(writer, 0, title, content);
		
		boardList.add(board);
		
		if(prev < boardList.size()) { //등록이 잘되었으면
			return 0;
		}else {//사이즈가 같거나 작으면 입력이 안된거니까
			return 1;
		}
	}
	
	/*글 상세 조회 -> 조회수 하나올려주고 해당 객체를 반환한다.*/
	public Board viewBoard(int index) {
		
		boardList.get(index).view += 1; //증가한 값
		
		Board board = new Board(index, boardList.get(index).view);//객체에도 저장
		
		return boardList.get(index);
	}
	
	/*글 삭제 기능*/
	public int deleteBoard(String userId, int index) {

		return 0;
	}

}
