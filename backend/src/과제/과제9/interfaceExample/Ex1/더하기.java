package 과제.과제9.interfaceExample.Ex1;

public class 더하기 implements 계산기{
	@Override
	public void calculation(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a+b));
		
	}

}
