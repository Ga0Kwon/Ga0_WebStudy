package Day13.Ex4;

public class InterfaceCImp1 implements InterfaceC {
	
	@Override
	public void methodA() {
		System.out.println("InterfaceCImp1-methodA 실행");
	}
	
	@Override
	public void methodB() {
		System.out.println("InterfaceCImp1-methodB 실행");
	}
	
	@Override
	public void methodC() {
		System.out.println("InterfaceCImp1-methodC 실행");
	}
}
