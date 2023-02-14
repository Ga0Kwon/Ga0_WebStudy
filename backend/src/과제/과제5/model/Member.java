package 과제.과제5.model;

public class Member {
	//1. 필드
	private int mno; //회원 번호 = 식별자 필드 PK
	
	private String id;
	private String pw;
	private String phone;
	
	//2. 생성자
	public Member() {}

	public Member(int mno, String id, String pw, String phone) {
		this.mno = mno;
		this.id = id;
		this.pw = pw;
		this.phone = phone;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
}
