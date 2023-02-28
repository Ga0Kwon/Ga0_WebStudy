package Day20.gallery.model.dto;

public class BoardDto {
	private int BoardNo;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private int boardView;
	
	// 저장할땐 카테고리 번호와 회원 번호로 저장하지만
	// 출력하는 것은 memberId와 category를 출력
	private String memberId;
	private String categoryName;
	
	public BoardDto() {
		super();
	}

	public BoardDto(int boardNo, String boardTitle, String boardContent, String boardDate, int boardView,
			String memberId, String categoryName) {
		super();
		BoardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardView = boardView;
		this.memberId = memberId;
		this.categoryName = categoryName;
	}

	public int getBoardNo() {
		return BoardNo;
	}

	public void setBoardNo(int boardNo) {
		BoardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardView() {
		return boardView;
	}

	public void setBoardView(int boardView) {
		this.boardView = boardView;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "BoardDto [BoardNo=" + BoardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardDate=" + boardDate + ", boardView=" + boardView + ", memberId=" + memberId + ", categoryName="
				+ categoryName + "]";
	}
	
	
}
