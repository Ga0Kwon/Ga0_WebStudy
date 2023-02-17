package 과제.과제9.classExample.Ex2;

public class RVIP회원 extends 영화관회원{
	@Override
	public void addPoint(int point) {
		// TODO Auto-generated method stub
		super.addPoint(6);
	}
	
	public RVIP회원() {
		super("VIP 승급 후 1년 이내 24000", "영화무료쿠폰 9매 지급");
	}
}
