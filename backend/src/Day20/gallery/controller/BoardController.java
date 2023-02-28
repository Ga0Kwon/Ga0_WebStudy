package Day20.gallery.controller;

import java.util.ArrayList;

import Day20.gallery.model.dao.BoardDao;
import Day20.gallery.model.dto.BoardDto;
import Day20.gallery.model.dto.CateogryDto;

public class BoardController {
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static BoardController bc = new BoardController();
	private BoardController() {}
	public static BoardController getInstance() {
		return bc;
	}
	
	//카테고리 추가하기 
	public boolean addCategory(String categoryName) {
		return BoardDao.getInstance().addCategory(categoryName);
	}
	
	//모든 카테고리 출력
	public ArrayList<CateogryDto> printCategory(){
		return BoardDao.getInstance().printCategory();
	}
	
	//등록된 전체 게시판 출력하기 
	public ArrayList<BoardDto> printWholeBoard(int categoryNo){
		return BoardDao.getInstance().printWholeBoard(categoryNo);
	}
	
	//등록된 전체 게시판 출력하기 
	public ArrayList<BoardDto> printLimitBoard(){
		return BoardDao.getInstance().printLimitBoard();
	}
	
	public boolean writeBoard(String boardTitle ,String boardContent, int categoryNo) {
		return BoardDao.getInstance().writeBoard(boardTitle, boardContent, MemberController.getInstance().getLogInMemberNo(), categoryNo);
	}
}
