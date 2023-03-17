package model.dto;

public class BoardDto {
	private int bno; //게시물 번호
    private String btitle; // 게시물 제목
    private String bcontent; //게시물 내용
    private String bfile; //게시물 첨부파일
    private String bwritedate; //게시물 작성 날짜/시간
    private int bview; //게시물 조회수
    private int blike;// 게시물 좋아요
    private int bhate; //게시물 싫어요
    private int mno; //작성자 번호
    private int cno; //카테고리 번호
    
    // 추가 필드 --> 작성자 id
    private String mid; //출력용
    //추가 필드 --> 작성자 프로필 사진
    private String mimg;
    
    //1. 생성자 [빈생성자] : 사용할 용도가 적음
	public BoardDto() {
		super();
	}
    //2. 생성자 [풀생성자] : 객체 만들때 [DAO]
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bwritedate, int bview, int blike,
			int bhate, int mno, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bwritedate = bwritedate;
		this.bview = bview;
		this.blike = blike;
		this.bhate = bhate;
		this.mno = mno;
		this.cno = cno;
	}
	
	//3. 게시물 등록용 생성자[들어가는 정보만]
	public BoardDto(String btitle, String bcontent, String bfile, int mno, int cno) {
		super();
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.mno = mno;
		this.cno = cno;
	}
	
	//4. 게시물 출력용 생성자[들어가는 정보만]
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bwritedate, int bview, int blike,
			int bhate, int mno, int cno, String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bwritedate = bwritedate;
		this.bview = bview;
		this.blike = blike;
		this.bhate = bhate;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
	}
	
	//5. 개별 게시물 출력
	public BoardDto(int bno, String btitle, String bcontent, String bfile, String bwritedate, int bview, int blike,
			int bhate, int mno, int cno, String mid, String mimg) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bwritedate = bwritedate;
		this.bview = bview;
		this.blike = blike;
		this.bhate = bhate;
		this.mno = mno;
		this.cno = cno;
		this.mid = mid;
		this.mimg = mimg;
	}
	
	//6. 업데이트용 생성자
	public BoardDto(int bno, String btitle, String bcontent, String bfile, int cno) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.cno = cno;
	}
	
	//메소드
	public int getBno() {
		return bno;
	}
	
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public String getBfile() {
		return bfile;
	}
	public void setBfile(String bfile) {
		this.bfile = bfile;
	}
	public String getBwritedate() {
		return bwritedate;
	}
	public void setBwritedate(String bwritedate) {
		this.bwritedate = bwritedate;
	}
	public int getBview() {
		return bview;
	}
	public void setBview(int bview) {
		this.bview = bview;
	}
	public int getBlike() {
		return blike;
	}
	public void setBlike(int blike) {
		this.blike = blike;
	}
	public int getBhate() {
		return bhate;
	}
	public void setBhate(int bhate) {
		this.bhate = bhate;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	@Override
	public String toString() {
		return "BoardDto [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile
				+ ", bwritedate=" + bwritedate + ", bview=" + bview + ", blike=" + blike + ", bhate=" + bhate + ", mno="
				+ mno + ", cno=" + cno + ", mid=" + mid + "]";
	}
}
