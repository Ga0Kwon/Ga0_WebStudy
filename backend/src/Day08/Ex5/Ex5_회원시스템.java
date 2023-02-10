package Day08.Ex5;

public class Ex5_회원시스템 {//class s
	
	/*main 함수는 무조건 static => 메인 쓰레드(코드 흐름을 읽어줌)를 가지고 있는 함수!
	  static => 가장 먼저 실행되기 때문에 밑의 함수[static없는]의 존재를 모르게 된다.
	  즉, 밑의 함수를 쓰려면 함수에 static을 넣어줘야한다.
	  method area에 있는 것은 메모리 공간에 올릴때 초기화되는 대상 => static이면 Method area
	  전역변수 만들때 메소드영역에 저장한다. -> JVM이 시작할때 생성된다[Method Area] 
	  => JVM이 끝날때 꺼진다. => 메모리 효율이 낮다. => 둥둥떠다니게 됨.*/
	
	/*기능 별로 함수를 나눠야함!*/
	public static void main(String[] args) {//main s
		
		/* menu(); */
		
		// 1. 객체 생성
		//[다른 클래스의 메소드 호출방법1] 객체 이름
		Front front  = new Front(); //1) 빈 객체 생성
		
		front.index(); //2) 객체를 통한 함수 호출
			
		
		
	}//main e
	
	//1. 함수 선언 [인수x, 반환x] 
	//static void menu() { }

	
}//class e
