package 과제.과제5.model;

public class Memo {
	//1. 필드
	private String frommno; //쪽지를 보낸 회원 번호
	
	private String pno; //제품 번호
	
	private int meno;  //쪽지 번호
	private String memoContent; //쪽지 내용
	
	//2. 생성자
	public Memo() {}
	
	public Memo(String frommno, String pno, int meno, String memoContent) {
		super();
		this.frommno = frommno;
		this.pno = pno;
		this.meno = meno;
		this.memoContent = memoContent;
	}

	//3. 메소드
	public String getFrommno() {
		return frommno;
	}
	public void setFrommno(String frommno) {
		this.frommno = frommno;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	public int getMeno() {
		return meno;
	}
	public void setMeno(int meno) {
		this.meno = meno;
	}
	public String getMemoContent() {
		return memoContent;
	}
	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}
	
	
}
