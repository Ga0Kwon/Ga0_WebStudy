package Day09.Ex7;

/*
 	final 필드 : 최종적 뜻
 		- 수정 불가 만들기
 		- 무조건 초기화가 있어야 한다.
 		- 필드에 직접 초기화, 생성자 이용한 초기화
 		
	js => const : 상수
	
	java => static final 필드 : 상수
	 - 수정 불가능, 어디든 공유 메모리
	 - 상수 이름 : 관례적으로 대문자 사용
  
 */

public class Korean {//class s
	//1. final [ 수정 불가, 공유메모리X]
	final String nation = "대한민국";
	final String ssn; //final 무조건 초기값이 존쟈햐여야함
	
	String name;
	public Korean(String ssn, String name) {
		this.name = name;
		this.ssn = ssn; //생성자 이용한 초기화
	}
	
	//2. static final : 수정 불가. 공유메모리O
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	static {
		EARTH_SURFACE_AREA = EARTH_RADIUS * EARTH_RADIUS  * Math.PI * 4;
	}
	
}//class e
