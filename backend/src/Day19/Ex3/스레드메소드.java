package Day19.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class 스레드메소드 {
	public static void main(String[] args) {
		
		//1. sleep()
//		Toolkit toolkit = Toolkit.getDefaultToolkit();
//		
//		for(int i =0; i < 10; i++) {
//			toolkit.beep(); //비프음 내기
//			
//			try {
//				Thread.sleep(3000); // 3초간 해당 스레드를 일시정지 [ 3초간 CPU(명령어처리) 점유불가]
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			} 
//		}
		
		//2. 콘솔에 시계 만들기
//		while(true) {
//			Date date = new Date(); //날짜/시간 클래스
//			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); //날짜/시간 꾸미기[형식] 클래스
//			System.out.println(sdf.format(date));
//			try{
//				Thread.sleep(1000); //1초간 일시정지
//			}catch(InterruptedException e) {}
//			
//			//콘솔을 지워보이게 하는 코드 (공백 100줄) => 콘솔 초기화하는 것은 없음.
//			for(int i = 0; i < 100; i++) {
//				System.out.println();
//			}
//		}
		
		//3. join()
//		SumThread sumThread = new SumThread();
//		sumThread.start();
//		//이 아래 코드는 메인스레드가 걸었음 => 결과값 0
		//아직 계산 안끝났기 때문...
//		System.out.println(sumThread.getSum());
		
		
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join(); // -현스레드(main)와 조인[합치기]ㄴ
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		System.out.println(sumThread.getSum());
	}
}
