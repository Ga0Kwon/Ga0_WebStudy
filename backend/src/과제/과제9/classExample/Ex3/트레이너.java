package 과제.과제9.classExample.Ex3;

public class 트레이너 extends 헬스장{

	
	public void teach(헬스회원 회원) {
		System.out.println(회원.name + "을 가르치고 있습니다.");
	}
	
	public void checkTime() {
		System.out.println("회원 시간을 체크중입니다.");
	}
	
	@Override
	public void entrance() {
		System.out.println(" 출근 도장을 찍습니다.");
	}
	
	
}
