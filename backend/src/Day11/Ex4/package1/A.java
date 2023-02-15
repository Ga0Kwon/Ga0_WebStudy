package Day11.Ex4.package1;
/*-------------------------패키지 1----------------------*/
public class A {
	/*같은 패키지만*/
//	String field;
//	A() {}
//	void method() {}
	
	/*다됨*/
//	public String field;
//	public A() {}
//	public void method() {}
	
	/*같은 패키지만 상속할때 super()사용 가능 -> new 는 사용 불가*/
	protected String field;
	protected A() {}
	protected void method() {}
	
	/*다 안됨*/
//	private String field;
//	private A() {}
//	private void method() {}
	
	
}
