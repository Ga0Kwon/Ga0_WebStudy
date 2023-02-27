package Day19.Ex2;

public class 실행 {
	//메인스레드는 싱글 스레드이다.
	public static void main(String[] args) {
		//1. Thread 자식 클래스로 멀티스레드 구현
		Thread aThread = new A();
		aThread.start();
		
		//2. Thread 자식 클래스의 익명 객체로 구현 => 익명은 스택이 없음 => 재사용 불가
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					//Thread.currentThread() : 현 스레드 이름
					System.out.println("--자식클래스 익명 스레드 : " + Thread.currentThread());
					
					try {
						Thread.sleep(1000); //현 스레드 1초간 일시정지
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};
		
		thread.start();
		
		//3. Runnable 인터페이스 구현 객체 구현
		Runnable runnable = new B();
		Thread bThread = new Thread(runnable);
		
		bThread.start();
		
		// ==
		
//		B b = new B();
//		Thread bThread2 = new Thread(b);
//		bThread2.start();
		
		//4. Runnable 인터페이스 익명 객체로 구현
		Thread thread4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					//Thread.currentThread() : 현 스레드 이름
					System.out.println("----인터페이스 익명 스레드 : " + Thread.currentThread());
					
					try {
						Thread.sleep(1000); //현 스레드 1초간 일시정지
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		thread4.start();
		
		
		//5. main 스레드
		while(true) {
			//Thread.currentThread() : 현 스레드 이름
			System.out.println("main 메소드 스레드 : " + Thread.currentThread());
			
			try {
				Thread.sleep(1000); //현 스레드 1초간 일시정지
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
