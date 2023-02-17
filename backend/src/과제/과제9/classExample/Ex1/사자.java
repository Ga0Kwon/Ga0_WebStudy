package 과제.과제9.classExample.Ex1;

public class 사자 extends 포유류{
	@Override
	public void eat() {
		System.out.println("사자가 밥을 먹습니다.");
	}
	
	@Override
	public void move() {
		System.out.println("사자가 움직입니다.");
	}
	
	@Override
	public void sleep() {
		System.out.println("사자가 잠을 잡니다.");
	}
	
	public void hunt() {
		System.out.println("사자가 사냥하고 있습니다.");
	}
}
