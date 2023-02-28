package Day20.gallery.model.dto;

public class ReplyDto {
	private int replyNo;
	private String replyContent;
	private int replyIndex;
	private String replyDate;
	
	private String memberId;
	private int boardNo;

	public ReplyDto() {}



	public ReplyDto(int replyNo, String replyContent, int replyIndex, String replyDate, String memberId,
			int boardNo) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyIndex = replyIndex;
		this.replyDate = replyDate;
		this.memberId = memberId;
		this.boardNo = boardNo;
	}


	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getReplyIndex() {
		return replyIndex;
	}

	public void setReplyIndex(int replyIndex) {
		this.replyIndex = replyIndex;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	
	
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "ReplyDto [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyIndex=" + replyIndex
				+ ", replyDate=" + replyDate + ", memberId=" + memberId + ", boardNo=" + boardNo + "]";
	}

	
	
	
}
