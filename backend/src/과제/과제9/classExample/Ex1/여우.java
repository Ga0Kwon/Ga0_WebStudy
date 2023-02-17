package 과제.과제9.classExample.Ex1;

public class 여우 extends 포유류{
	
	@Override
	public void eat() {
		
		System.out.println("여우가 밥을 먹습니다.");
	}
	
	@Override
	public void move() {
		System.out.println("여우가 움직입니다.");
	}
	
	@Override
	public void sleep() {
		System.out.println("여우가 잠을 잡니다.");
	}
	
	public void run() {
		System.out.println("사자로부터 도망칩니다.");
	}
	
}
