package 과제.과제9.classExample.Ex3;

public class 헬스회원 extends 헬스장{
	public String name;
	
	@Override
	public void entrance() {
		System.out.println("회원님께서 입장하였습니다.");
	}
	
	public void exercise(int index) {
		if(index == 1) {
			System.out.println("트레이너로 부터 운동배우기");
		}else if(index == 2) {
			System.out.println("혼자 운동하기");
		}
	}

}
