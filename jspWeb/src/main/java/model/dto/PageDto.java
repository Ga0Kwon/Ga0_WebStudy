package model.dto;

import java.util.ArrayList;

//페이지 처리할때 한 곳에 넣어 보내기 위한
public class PageDto {
	private int page; //현재 페이지
	private int listSize; //페이지당 표시할 개수
	private int startRow; //현재 페이지에서 시작되는 게시물 번호
	private int totalsize; // 총 게시물수
	private int totalpage; //총 페이지수
	private int btnSize; //페이지별 최대 페이징버튼 수
	private int startBtn; //페이지별 시작 페이징버튼의 번호
	private int endBtn; //페이지별 끝 페이징버튼의 번호
	
	//!! : 실질적인 게시물 목록 
	ArrayList<BoardDto> boardList; //출력할 데이터[게시물] 리스트
	
	//!! : 관리자 페이지에 필요한!!
	ArrayList<MemberDto> memberList; //출력할 데이터[멤버정보들] 리스트
	public PageDto() {
		super();
	}
	
	
	//게시물용
	public PageDto(int page, int listSize, int startRow, int totalsize, int totalpage, int btnSize, int startBtn,
			int endBtn, ArrayList<BoardDto> boardList) {
		super();
		this.page = page;
		this.listSize = listSize;
		this.startRow = startRow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnSize = btnSize;
		this.startBtn = startBtn;
		this.endBtn = endBtn;
		this.boardList = boardList;
	}


	//관리자 페이지용
	public PageDto( ArrayList<MemberDto> memberList, int page, int listSize, int startRow, int totalsize, int totalpage, int btnSize, int startBtn,
			int endBtn) {
		super();
		this.page = page;
		this.listSize = listSize;
		this.startRow = startRow;
		this.totalsize = totalsize;
		this.totalpage = totalpage;
		this.btnSize = btnSize;
		this.startBtn = startBtn;
		this.endBtn = endBtn;
		this.memberList = memberList;
	}


	public ArrayList<MemberDto> getMemberList() {
		return memberList;
	}


	public void setMemberList(ArrayList<MemberDto> memberList) {
		this.memberList = memberList;
	}


	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getTotalsize() {
		return totalsize;
	}

	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getBtnSize() {
		return btnSize;
	}

	public void setBtnSize(int btnSize) {
		this.btnSize = btnSize;
	}

	public int getStartBtn() {
		return startBtn;
	}

	public void setStartBtn(int startBtn) {
		this.startBtn = startBtn;
	}

	public int getEndBtn() {
		return endBtn;
	}

	public void setEndBtn(int endBtn) {
		this.endBtn = endBtn;
	}

	public ArrayList<BoardDto> getBoardList() {
		return boardList;
	}

	public void setBoardList(ArrayList<BoardDto> boardList) {
		this.boardList = boardList;
	}


	@Override
	public String toString() {
		return "PageDto [page=" + page + ", listSize=" + listSize + ", startRow=" + startRow + ", totalsize="
				+ totalsize + ", totalpage=" + totalpage + ", btnSize=" + btnSize + ", startBtn=" + startBtn
				+ ", endBtn=" + endBtn + ", boardList=" + boardList + ", memberList=" + memberList + "]";
	}
	
	
}
