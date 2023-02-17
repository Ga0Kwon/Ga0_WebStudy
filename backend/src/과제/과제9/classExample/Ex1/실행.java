package 과제.과제9.classExample.Ex1;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		
		//1. 사자 객체 생성
		사자 사자 = new 사자();
		사자.name = "사자";
		사자.habitat = "야생";
		사자.kind = "고양이과";
		사자.leg = 4;

		사자.printInfo();
		사자.move();
		
		
		//2. 여우 객체1 생성
		여우 여우1 = new 여우();
		여우1.name = "여우1";
		여우1.habitat = "산지";
		여우1.kind = "개과";
		여우1.leg = 4;
		
		여우1.printInfo();
		여우1.sleep();
		
		
		//3. 여우 객체2 생성
		여우 여우2 = new 여우();
		여우2.name = "여우2";
		여우2.habitat = "초원";
		여우2.kind = "개과";
		여우2.leg = 4;
	
		여우2.printInfo();
		여우2.run();
		
		사자.hunt();
		
		//4. 해달 객체 생성
		해달 해달 = new 해달();
		해달.name = "해달";
		해달.habitat = "해안부근 암초대";
		해달.kind = "좃제빗과";
		해달.leg = 4;
		해달.printInfo();
		해달.eat();
		해달.swim();
		
	}//main e
}//class e
