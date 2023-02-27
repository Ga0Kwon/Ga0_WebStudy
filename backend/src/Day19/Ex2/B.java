package Day19.Ex2;

public class B implements Runnable{
	@Override
	public void run() {
		while(true) {
			//Thread.currentThread() : 현 스레드 이름
			System.out.println("---B 인터페이스 스레드 : " + Thread.currentThread());
			
			try {
				Thread.sleep(1000); //현 스레드 1초간 일시정지
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
