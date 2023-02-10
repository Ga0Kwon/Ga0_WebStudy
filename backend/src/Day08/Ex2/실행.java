package Day08.Ex2;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		/*접근연산자[.]은 주소를 가지고 있는 값만 사용 가능*/
		// => 따라서 변수에 [.]을 쓰지 못하는 이유가 된다.
		
		//1. 객체 생성 [빈생성자]
		Korean k1 = new Korean();
			//1) 객체 정보 [객체명.toString()] 출력
		System.out.println(k1.toString());
			//2) 객체 필드 호출[객체명.필드명]
		System.out.println(k1.nation);
		System.out.println(k1.name);
		System.out.println(k1.ssn);
		
		//2. 객체 생성
		Korean k2 = new Korean("박자바" , "011225-1234567");
		System.out.println(k2.toString());
		
		System.out.println(k2.nation);
		System.out.println(k2.name);
		System.out.println(k2.ssn);
		
	}//main e
}//class e

/*
  
  
  
 */