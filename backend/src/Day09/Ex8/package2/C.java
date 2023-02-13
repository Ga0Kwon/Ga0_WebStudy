package Day09.Ex8.package2;

import Day09.Ex8.package1.B; 
//import Day09.Ex8.package1.A; 

public class C {
	//B 클래스가 public일 때
	B b; //불가능 -> 가능 : 같은 패키지 아니지만 import 해서 가능하게 됨
	//하지만 class B가 public이 아니면 불가능해짐.
	
	//A 클래스가 public이 아닐때
		//불가능 : default은 같은 패키지만 가능
//	A a;
	
	B b1 = new B(true); // public 가능
//	B b2 = new B(1); // default 같은 패키지까지 가능 => 다른 패키지 불가능
//	B b3 = new B("문자열"); // private 무조건 내부에서만 사용
	
}

