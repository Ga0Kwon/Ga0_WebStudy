package Day09.Ex2;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 붕어빵 객체 = 지역 변수 만들기
		
		//스택 영역 = 힙영역 주소
		
		//1)
		붕어빵틀 붕어빵1 = new 붕어빵틀();
		System.out.println("붕어빵1 : "+붕어빵1);
		붕어빵1.굽기();
		
		//2)
		붕어빵틀 붕어빵2 = new 붕어빵틀("반죽");
		System.out.println("붕어빵2 : "+ 붕어빵2);
		붕어빵2.변경("반죽", "슈크림");
		System.out.println("붕어빵2 : "+ 붕어빵2);
		
		//3)
		붕어빵틀 붕어빵3 = new 붕어빵틀("반죽", "팥");
		System.out.println("붕어빵3 : "+붕어빵3);
		System.out.println("붕어빵3 판매가 : " + 붕어빵3.판매가() + "원");
		
		//4) 
		System.out.println("붕어빵4 : " + 붕어빵3.판매());
		
		//5)
		붕어빵3.확인(붕어빵3);
		
		//6)
		System.out.println(붕어빵3.여러개판매(5));
	}//main e
}//class e
