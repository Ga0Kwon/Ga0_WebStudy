package Day09.Ex9;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		//1. 생성자가 private 이라서 객체생성 불가능
//		Member member = new Member();
		
		//2. 객체 없이 메소드를 호출하려면 static
		Member.getInstance();
		
		Member m1 = Member.getInstance();
		Member m2 = Member.getInstance();
		
		/*하나의 객체를 가지기 때문에 주소값이 같음*/
		System.out.println(m1);
		System.out.println(m2);
	}//main e
}//class e
