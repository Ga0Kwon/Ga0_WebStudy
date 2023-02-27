package Day19.Ex4;

public class User2Thread extends Thread{
	private 계산기 calculator;
	
	public User2Thread() {
		setName("User2Thread");//스레드 이름 변경
	}

	public 계산기 getCalculator() {
		return calculator;
	}

	public void setCalculator(계산기 calculator) {
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		calculator.setMemory(50);
	}
	
}
