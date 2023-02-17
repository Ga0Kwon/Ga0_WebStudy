package 과제.과제9.classExample.Ex1;

public class 포유류 {
	public String name;
	public int leg;
	public String kind;
	public String habitat;
	
	public void move() {
		System.out.println("움직입니다.");
	}
	
	public void eat() {
		System.out.println("밥을 먹습니다.");
	}
	
	public void sleep() {
		System.out.println("잠을 잡니다.");
	}
	
	public void printInfo() {
		System.out.println("------------------------------");
		System.out.println( name + "의 정보");
		System.out.println("다리 : " + leg);
		System.out.println("과 : " + kind);
		System.out.println("서식지 : " + habitat);
		System.out.println("------------------------------");
	}
}
