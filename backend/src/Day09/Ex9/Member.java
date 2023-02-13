package Day09.Ex9;

/*
  싱글톤 : 프로그램내 하나의 객체를 가지는 패턴
  	- 1. 클래스 내부에 객체만들기
  	- 2. 생성자 private
  	- 3. 내부 객체 반횐해주는 함수 : getInstance();
  	- 4. *함수 호출시 객체가 필요한데, 외부에서 객체 생성 금지시켜놨기 때문에 -> static
  		=> 인스턴스 멤버는 객체가 필요하다.
  	- 5. 인스턴스 멤버를 정적멤버로 바꿔야함
  		=> 정적멤버는 인스턴스 멤버를 사용할 수 없다.
 */
public class Member {//class s
	
	//1. 자신의 클래스에서 자신의 타입으로 객체를 생성한다.
	//2. private 잠금 
	//6. 정적 멤버로 바꿔줌 [static]
	private static Member mem = new Member();
	
	//3. 생성자도 private으로 잠금
	private Member() {};
	
	//4. 
//	public Member getInstance() {
//		return mem;
//	}
	
	//5. static : 객체 없이 메소드를 호출하기 위해
	public static Member getInstance() {
		return mem; // static은 인스턴스 멤버 사용X
	}
	
	
	
}//class e
