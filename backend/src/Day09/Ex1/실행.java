package Day09.Ex1;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 객체 만들기
		Member member = new Member();
		
		//2. 멤버인 필드 호출 가능
		System.out.println(member.name);
		
		//3. 멤버안에 있는 변수 호출 불가능
//		System.out.println(member.inputName);

	}//main e
}//class e
