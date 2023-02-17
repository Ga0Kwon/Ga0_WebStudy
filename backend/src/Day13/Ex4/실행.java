package Day13.Ex4;

public class 실행 {
	public static void main(String[] args) {
		//1. 구현 객체 만들기
		InterfaceCImp1 imp1 = new InterfaceCImp1();
		
		//2. 인터페이스 변수에 구현 객체 대입
		//본인과 위는 호출가능하나.. 옆과 아래는 안됨.
		InterfaceA ia = imp1;
		ia.methodA(); //본인 추상 메소드 호출 가능
		//> InterfaceA 타입인데, InterfaceA에 methodB, methodC가 없다.
//		ia.methodB(); X -> 옆
//		ia.methodC(); X -> 아래

		InterfaceB ib = imp1;
		ib.methodB();
		
		InterfaceC ic = imp1;
		ic.methodA();
		ic.methodB();
		ic.methodC();
	}
}
