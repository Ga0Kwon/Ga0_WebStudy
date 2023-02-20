package Day14.Ex3;

public class Ex3_예외떠넘기기 {//class s
	//1.
	public static void findClass() throws Exception{ // throws Exception : 예외 던지기
		Class.forName("java.lang.String2"); //일반 예외
	}

	public static void main(String[] args) /* throws Exception */ {//main s
		//main이 throws Exception를 하면 자바가 받아서 예외처리를 해줌.
		try {
			
			findClass();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		System.out.println("확인");
	}//main e
}//class e

/*
  예외 떠넘기기
  		- 메소드 내부에서 예외발생했을 때 메소드 호출했던 곳으로 예외를 넘기기
  		- throws
  		- 메소드 마다 예외처리를 하면 코드가 지저분해짐 -> 이동 후 한곳에서 처리
  
 */
