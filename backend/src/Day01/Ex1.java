/* 주석 */
	//한줄 주석
 	/*여러줄 주석*/
		/*
		 * 범위 지정후 ctrl + /  => 한줄 주석
		 *  범위 지정후 ctrl + shift + / => 여러줄 주석
		 */

package Day01;
/*
 * package : 패키지 이름이 표시되는 키워드
 * package Day01; : 현재 소스파일이 위치한 패키지
 * 
 */

/*int 변수 = 10; => 클래스 밖에서 코드를 치면 에러!!*/

// 1. 자바는 클래스  { }안에서만 코드를 작성해야한다.
public class Ex1 { //class s
	/* int 변수 = 10; */ // class 안에서 코드 작성 가능
	
	//2. 실행되는 코드는 main함수(){ }안에서만 코드 작성한다!
		// m 입력후 ctrl + space
	
	/* System.out.println(); */ //자동 완성이 안됨.
	public static void main(String[] args) { 
		//main 함수 : 메인 스레드를 가지고 있는 함수.
			//스레드 : 코드를 읽어들이는 흐름 단위
		//3. 출력 : syso입력후 ctrl+스페이스바 -> 엔터
		System.out.println("안녕 자바"); //js : console.log와 같음 println() 괄호 안에 큰따옴표!
	}
	
	
} //class e

/*
 * public : 사용 범위뜻 [프로젝트 내 모든 곳에서 사용]
 * class : 클래스 선언할때 사용되는 키워드
 * Ex1 : 클래스명[아무거나] => 영문/첫글자 영대문자
 * { code가 들어감 } : 클래스의 시작s 끝e
 */

/*
 실제 존재하는 모든 것 ------> 코드
 	공기, 돈, 사람 등         객체[*식별가능한]지향 언어
 	[성질, 행동]            
 	
 		예) 붕어빵 틀[클래스]			  [객체]
 			반죽[성질, 속성]    --->  붕어빵1[밀가루, 팥]
 			굽기[행동]				   붕어빵2[밀가루, 팥]
 			 					   붕어빵3[밀가루, 크림]
 			 					   -> 붕어빵은 서로 다르다.
 			 					   
	    예) SM7 자동차 틀[클래스]		   [객체]
	    	속도[성질, 속성]		SM7 자동차1[60, 주행증]
	    	주행[행동]				SM7 자동차2[0, 주행중X]
 
 		예) 객체지향 프로그래밍
 			
 			타이어 틀 : 금호타이어 회사
 				공기압		---> 타이어1 객체 / 타이어2 객체
 				구르기 
 				
 			자동차 틀 [클래스] : 현대 회사
 				타이어[금호타이어 객체]  ---> 현대자동차
 			
 			
  자바 100% 객체지향언어
 	객체 : 클래스 기반으로 만들어진 식별가능한 형태/메모리
 	클래스 : 객체지향 생성하기 위한 미리 정의된 틀/설계도
 	객체지향[OOP] : 객체들을 모아서 만든 프로그램 [레고같은 느낌]
 	
 	코드 ---> 프로세스 ---> 프로그램
 
 */