package Day15.Ex5;

import java.util.Properties;

public class System클래스 {
	public static void main(String[] args) {
		
		//1.
		long time1 = System.nanoTime(); //나노초
		System.out.println(time1);
		int sum = 0;
		
		for(int i =0; i <= 10000000; i++) { //백만번 반복 [ * CPU마다 다름]
			sum += i;
		}
		
		long time2 = System.nanoTime();
		System.out.println("걸린 시간 : " + (time2 - time1));
		
		
		//2.
		System.out.println("--------------------------------------------------");
		System.out.println("Key    :               Value");
		Properties props = System.getProperties(); //모든 시스템 속성 호출
		for(Object obj : props.keySet()) { //시스템 속성들의 키를 반복문 돌리기
			System.out.println((String)obj + //해당 키를 문자열로 변환
					"                   "
					+ System.getProperty((String)obj)); //해당 키를 이용한 시스템 속성 반환
		}
		
		
	}
}

/*
  밀리초 -> 										1/1000 
  	마이크로초 -> 									1/1,000,000	
  		나노초 ->   								1/1,000,000,000,000
  			피코초 -> 							1/1,000,000,000,000,000
  				펨토초 -> 						1/1,000,000,000,000,000,000
  					아토초 -> 					1/1,000,000,000,000,000,000,000
  						젭토초 -> 				1/1,000,000,000,000,000,000,000,000
  							욕토초  ->			1/1,000,000,000,000,000,000,000,000,000
  
*/
