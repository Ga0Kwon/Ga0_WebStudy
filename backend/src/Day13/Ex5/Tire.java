package Day13.Ex5;

//*인터페이스 : 객체의 사용방법 정의 타입
/*
  다형성 / 타입 변환
  	- 존재하지 않을 때 [타입 일치화] => 중복 증가, 유지보수 증가, 돈 증가, 효율 감소
  		ex) int타입
  		int 변수 = 3;
  		변수 = 3.3; [x]
  		
  		ex) class 타입
  		학생 학생1 = new 학생("유재석", 19);
  		- 19 ---> 20 되었기 때문에 성인으로 타입 변환
  		성인 성인1 = 학생1; [x]// 20살이 되어서 넣을려고 하면
  		
  	- 존재할 때
  		ex) int 타입
  		int 변수 = 3;
  		변수 = (int)3.3 [o]
  		
  		ex) class 타입
  		학생 학생1 = new 학생("유재석", 19);
  		- 19 ---> 20 되었기 때문에 성인으로 타입 변환
  		성인 성인1 = 학생1;[x]
  		
  		class 학생 extend 성인 가정하에 [ 상속 관계 했다는 가정]
  		성인 성인1 = 학생1;[o]
  		
  		
 */
public interface Tire {
	//추상 메소드
	void roll();
}