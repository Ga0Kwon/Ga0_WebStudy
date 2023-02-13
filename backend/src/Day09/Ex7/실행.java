package Day09.Ex7;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 객체 생성
		Korean k1 = new Korean("123456-1234567", "김자바");
		
		//2. 객체 멤버 호출
		System.out.println(k1.name);
		System.out.println(k1.nation);
		System.out.println(k1.ssn);
		
		//3. 객체 멤버 변겅
		k1.name = "자바김"; // final이 아니기 때문에 변경 가능
		/*final은 같은 객체에서 딱 한번만 초기화*/
//		k1.nation = "미국"; => final 변경 불가
//		k1.ssn = "123456-7891011"; => final 변경 불가
		
		System.out.println(Korean.EARTH_RADIUS);
		System.out.println(Korean.EARTH_SURFACE_AREA);
	}//main e
}//class e
