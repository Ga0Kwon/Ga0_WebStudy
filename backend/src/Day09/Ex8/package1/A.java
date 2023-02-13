package Day09.Ex8.package1;
/*
  접근제한자 : 해당 클래스, 필드, 생성자, 메소드 접근을 제한하는
   		public                vs.                private
   		모든 패키지에서 사용                          현재 클래스에서만 사용
   		
   		default (생략)         vs.               protected
   		같은 패키지내에서                            같은 패키지내에서
   						                        + 다른 패키지일 경우 자식 클래스 가능
  
  
 */
class A {
	B b1 = new B(true); // public 가능
	B b2 = new B(1); // default 같은 패키지까지 가능
//	B b3 = new B("문자열"); // private 무조건 내부에서만 사용
	
	public static void main(String[] args) {
		B b4 = new B(true);
		b4.field1 = 10;
		b4.field2 = 20;
//		b4.field3 = 30; //같은 패키지여도 private이기 때문에 필드 사용X -> 사용 불가능
	}
}
