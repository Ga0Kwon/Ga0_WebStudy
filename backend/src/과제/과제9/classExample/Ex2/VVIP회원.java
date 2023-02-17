package 과제.과제9.classExample.Ex2;

public class VVIP회원 extends 영화관회원{
	@Override
	public void addPoint(int point) {
		// TODO Auto-generated method stub
		super.addPoint(9);
	}
	
	public VVIP회원() {
		super("3년 연속 RVIP 유지 and 12000포인트","영화무료쿠폰 12매 지급");
	}
}
