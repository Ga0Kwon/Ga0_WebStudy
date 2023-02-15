package 과제.과제7;

public class 은행 {
	
	public String account; //계좌번호
	public String pw; //비밀번호
	public String name; //계좌주
	public int amount; //금액
	
	
	public 은행() {}

	public 은행(String account, String pw, String name, int amount) {
		this.account = account;
		this.pw = pw;
		this.name = name;
		this.amount = amount;
	}
	
	public void 계좌생성(String account, String pw, String name, int amount) {
		this.account = account;
		this.pw = pw;
		this.name = name;
		this.amount = amount;
	}

	public void 계좌생성(String account2, String pw2, String name2, int amount2) {
		
	}
	
}
