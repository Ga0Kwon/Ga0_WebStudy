package Day15.Ex1;

public class 실행 {
	public static void main(String[] args) {
		
		Member obj1 = new Member("Blue");
			System.out.println(obj1);
			
		Member obj2 = new Member("Blue");
			System.out.println(obj2);
		
		Member obj3 = new Member("Red");
			System.out.println(obj3);
		
		// new 연산자를 쓸때마다 주소 값이 새로 할당
		
		System.out.println(obj1.equals(obj2));
		
		System.out.println(obj1.equals(obj3));
	}
}
