package Day09.Ex8.package1;

public class B {
	A a; // 가능 : 같은 패키지니까
	
	B b1 = new B(true);
	B b2 = new B(1);
	B b3 = new B("문자열");
	
	
	//1. public 생성자
	public B(boolean b) {
		
	}
	
	//2. defalut 생성자
	B(int b){}
	
	//3. private 생성자
	private B(String s) {}
	
	//1. public 필드
	public int field1;
	
	//2. defalut 필드
	int field2; //defalut는 생략 가능
	
	//3. private 필드
	private int field3;
	
}
