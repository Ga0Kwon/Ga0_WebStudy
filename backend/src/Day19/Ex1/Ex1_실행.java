package Day19.Ex1;

import java.awt.Toolkit;

public class Ex1_실행 {
	//main()메소드 : 메인 thread 싱글스레드
	public static void main(String[] args) {
		//------------------1. 싱글스레드---------------------
		System.out.println("단일 스레드");
		// * 소리코드가 실행되고 출력 코드가 실행
		//1.소리 코드
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i = 0; i < 5; i++) {
			// 5번인데 비프음 한번만 소리남
			toolkit.beep(); //띠링 : 비프음 소리내기
			
			//비프음을 소리내기전에 반복문이 끝나서 한번만 들린거.
			
			//Thread는 무조건 예외처리를 해야한다.
			try{ //다섯번 소리가 남
				// 여기서 Thread는 현재 스레드로 여기선 main Thread이다.
				Thread.sleep(500); //스레드 0.5초 대기 상탠
			}catch (Exception e) {
				
			}
		}
		
		//2. 출력코드
		//소리가 나고 출력됨 => 싱글스레드는 위에서 아래로.[단일작업]
		for(int i =0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		//--------------------------------------------
		
		//------------------2. 멀티스레드---------------------
//		Thread thread = new Thread(구현 인터페이스);
//		Thread thread = new Thread() => 자동완성하면 밑에와 같이 됨
		
		/*
		 Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		 }); 
		 */
		System.out.println("Runnable()을 이용한 멀티 스레드");
		// 익명[이름이 없는] 구현 객체
		//1) 스레드 객체 생성
		Thread thread = new Thread(new Runnable() {
			
			//2) run()메소드 구현
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				
				for(int i =0; i< 5; i++) {
					toolkit.beep();
					
					try {
						Thread.sleep(500);
						
					}catch (Exception e) {}
				}// for ends
				 
			} // run() end
		}); // 생성자 end
		
		thread.start(); //2) run()메소드 실행
		
		//2. 출력 코드
		for(int i =0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			}
		}
		
		//------------------3. 멀티스레드2---------------------
		System.out.println("Thread를 상속받은 클래스를 생성한 멀티 스레드");
		//1. 소리 출력
		Thread thread2 = new Sound();
		thread2.start(); 
		
		//2. 출력 코드
		for(int i =0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			}
		}
		
		//------------------4. 멀티스레드3---------------------
		System.out.println("Runnable 인터페이스를 이용한 멀티 스레드");
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread(runnable);
		thread3.start();
		
		//2. 출력 코드
		for(int i =0; i < 5; i++) {
			System.out.println("띵");
			try {
				Thread.sleep(500);
			}catch (Exception e) {
			}
		}
		
		
		
	}//main end
}//class end
