package 과제.과제9.classExample.Ex3;

public class 헬스방문객 extends 헬스장 {
	@Override
	public void entrance() {
		System.out.println("헬스장을 처음 방문했습니다.");
	}
	
	public void consults() {
		System.out.println("상담을 받습니다.");
	}
	
	public void payment(int usufruct) {
		System.out.println(usufruct + "개월 이용권을 결제합니다.");
	}
}
