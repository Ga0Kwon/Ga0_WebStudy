package Day11.Ex4.package2;
/*-------------------------패키지 2----------------------*/

import Day11.Ex4.package1.A;

public class D extends A{
	// 상속을 통해 가능하다.
	public D() { }
	
	/*----A의 필드와 메소드, 생성자가 default일때 안됨-----*/
	public void method() {
		this.field = "value";
		this.field = "value";
		
		this.method();
		super.method();
	}
	
	/*상속받을 시 super이 아닌 new를 써서 접근하려고 하면 안된다!
	 * super로만 가능*/
//	public void method2() {
//		A a = new A();
//		a.field = "value";
//		a.method();
//	}
}
