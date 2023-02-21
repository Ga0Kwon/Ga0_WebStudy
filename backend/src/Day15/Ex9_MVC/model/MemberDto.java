package Day15.Ex9_MVC.model;

public class MemberDto {
	//1. 필드 [DB 테이블의 필드와 일치화] => 필드는 무조건 private
	private int mno; //회원번호
	private String mid; //회원 아이디
	private String mpw; //회원 비밀번호
	
	//2. 생성자 [1. 깡통, 2. 풀생성자]
	public MemberDto(int mno, String mid, String mpw) {
		this.mno = mno;
		this.mid = mid;
		this.mpw = mpw;
	}
	
	
	public MemberDto(String mid, String mpw) {
		this.mid = mid;
		this.mpw = mpw;
	}



	public MemberDto() {}

	
	//3. 메소드 [1. get/set 2. toString]
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	@Override
	public String toString() {
		return "BoardDto [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + "]";
	}
	
	
}
