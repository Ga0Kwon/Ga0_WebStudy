package Day14.Ex1;

public class Ex1_예외처리 {
	//[1]
		//2. 함수 선언
		//접근제한자 키워드 반환타입 함수명(타입 매개변수1, 타입 매개변수2 ...){return 데이터;}
			//접근제한자 : public private, default[생략], protected
			//키워드[생략] : static[정적], final[최종, 오버라이딩 안됨 => 수정/리모델링/재정의 안됨]
			//반환 타입 : return할 데이터의 타입
			//함수명 : 카멜표기법
			//매개변수 : 타입에 맞춰서 선언
	public static final void printLength(String data) {
		
		try { //*예외가 발생할 것 같은 코드를 try{}안에 넣기
			
			//static 쓴 것은 main 함수가 static이기 때문에 main에서 쓰려면 static을 써야한다.
			int result = data.length(); // 문자열 길이 : 문자열.length();
			System.out.println("문자 수 : " +result);
			
		}catch(NullPointerException e) {
			
			//* 만약에 try{}안에서 예외가 발생했을 때 실행되는 catch{}코드
				//- 만일 try{} 안에서 예외가 발생하지 않으면 catch{}실행 안됨.
				// e : 예외 객체명 [아무거나] 예외정보가 담겨져 있는 객체 [e 이름 자체는 아무거나 해도 됨]
			System.out.println(e.getMessage());
			
		}finally { //* 예외가 있던 말던 실행되는 코드
			
			System.out.println("마무리 실행");
			
		}
	}
		//1. main 함수 선언 : main스레드가 포함된 함수 -> 스레드 : 코드를 읽어주는 흐름 단위[단일 스레드]
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		printLength("This is JAVA");
		printLength(null); //실행 예외가 발생할 것 같은 코드 -> NullPointerException : 데이터가 null이라서 length()사용이 안됨
		System.out.println("프로그램 종료");
		
	}
}

/*
   에러 : 컴퓨터하드웨어의 고장으로 인해 응용프로그램 실행 오류 발생 
   예외 : 에러 이외 예외라는 오류
   		* 잘못된 사용[사용자] 또는 코딩[개발자]으로 인해 발생
   		* 잘못된 사용 : 사용자가 비정상적인 행동을 했을 때 -> 다 파악 못함 => 경험바탕으로 할 수밖에 없음
   			1. 일반 예외 : 컴파일(실행) 전에 발생할 수 있는 예외 검사 [* 자바 외부 통신(스트림) => 자바 외부와 통신할 때 스트림을 사용함. ]
   			2. 실행 예외 : 컴파일(실행) 후에 발생하는 예외 -> 경험
   예외클래스
   		Exception 클래스 : 모든 예외를 받을 수 있는 예외 중에 최상위 클래스
   		
   문법
   		try{
   		
   			1. 예외가 발생할 것 같은 코드 [경험]
   			=> 입출력에 관련된 것은 다 예외처리하는 것이 좋음!
   			
   		}catch(예외클래스 e){
   			2. try{}에서 예외가 발생했을 때 실행되는 코드 [만일 예외발생했을 때 이후 실행 코드]
   		}
   		finally{
   			3. 예외가 있던 말던 실행되는 코드 [*생략가능]
   		}
  
 */
 