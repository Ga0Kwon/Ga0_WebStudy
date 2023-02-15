package 과제.과제7;

public class 은행 {
	/*필드*/
	public String account; //계좌번호
	public String code;
	public String pw; //비밀번호
	public String name; //계좌주
	public int amount; //금액
	
	/*생성자*/
	public 은행() {}
	
	public 은행(String code, String pw, String name, int amount) {
		String account = code + "-" + randomNm() + "-" + randomNm();
		
		this.account = account;
		this.code = code;
		this.pw = pw;
		this.name = name;
		this.amount = amount;
	}
	/*두자리 랜덤 숫자 반환하는 함수*/
	private String randomNm() {
		int account = (int)(Math.random()*100);
		String txtAccount = "";
		
		if(account < 10) {
			txtAccount = "0" + Integer.toString(account);
		}else {
			txtAccount = Integer.toString(account);
		}
		
		System.out.println(txtAccount);
		return txtAccount;
	}
	
}
