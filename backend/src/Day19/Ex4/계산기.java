package Day19.Ex4;

import javax.net.ssl.SNIHostName;

public class 계산기 {
	private int memory; //필드
	
	public int getMemory(){
		return memory; //getter
	}
	
	public synchronized void setMemory(int memory) {//setter
		
		try {
			Thread.sleep(2000); //해당 메소 작업 시간 추가 
		}catch (Exception e) {}
		
		this.memory = memory;
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);
	}
	
	
	
}
