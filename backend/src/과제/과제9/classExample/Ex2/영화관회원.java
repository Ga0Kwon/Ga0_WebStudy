package 과제.과제9.classExample.Ex2;

public class 영화관회원 {
	public int views;
	public int accumulatedPoint; //누적 포인트
	public String condition; //조건
	public String benefit;//혜택
	public int point; //한회당 포인트
	
	public 영화관회원() {}
	
	public 영화관회원(String condition, String benefit) {
		this.condition = condition;
		this.benefit = benefit;
	}
	
	public void viewMovies() {
		System.out.println("영화를 관람합니다.");
		addPoint(point);
	}
	
	public void addPoint(int point) {
		this.accumulatedPoint += point;
		if(point == 3) {
			printAccumulated();
		}else if(point == 6) {
			printAccumulated();
		}else if(point == 9) {
			printAccumulated();
		}
	}
	
	public void printInfo() {
		System.out.println("조건 : " + this.condition);
		System.out.println("혜택 : " + this.benefit);
	}
	
	public void printAccumulated() {
		System.out.println("포인트를 누적하였습니다.");
		System.out.println("누적포인트 : " + this.accumulatedPoint);
	}
	
}
