package 과제.과제7;

public class 국민 extends 은행{
	
	public final String code = "04";
	
	@Override
	public void 계좌생성(String account, String pw, String name, int amount) {
		
		String account = code + "-" + createAccount() + "-" +createAccount();
		
		super.계좌생성(account, pw, name, amount);
	}

	
	public String createAccount() {
		int account = (int)Math.random()*99;
		String txtAccount = "";
		
		if(account < 10) {
			txtAccount = "0" + account;
		}
		
		return txtAccount;
	}
}
