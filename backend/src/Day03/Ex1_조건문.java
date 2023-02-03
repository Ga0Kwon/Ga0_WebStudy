package Day03;

import java.util.Random;

public class Ex1_조건문 {
	public static void main(String[] args) {
		
		//IF 형태
			// 1. IF(조건식) 실행문;
			// 2. IF(조건식) {실행문; 실행문;}
			/* 3.
			     if(조건식){
			     	true 실행문;
			     }else{
			     	false 실행문;
			     }
			 */
			/* 4.
			     if(조건식1){
			     	true1 실행문;
			     }else if(조건식2){
			     	true2 실행문;
			     }else if(조건식3){
			     	true3 실행문;
			     }else{
			     	false 실행문;
			     }
			 */
			/* 5. if 중첩
		     if(조건식1){
		     	 if(조건식){
			     	true 실행문;
			     }else{
			     	false 실행문;
			     }
		     }else{
		     	 if(조건식){
			     	true 실행문;
			     }else{
			     	false 실행문;
			     }
		     }
		 */
		//1.
		int score1 =93; //1. 변수 선언
			
		if(score1 >= 90) { //제어문
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다");
		}
		
		if(score1 < 90) 
			System.out.println("점수가 90점보다 작습니다.");
			System.out.println("등급은 B입니다"); //중괄호를 안해서 이라인의 실행문도 출력된다.
		
		//2.
		int score2 = 85;
		
		if(score2 >= 90) {
			System.out.println("점수가 90점 이상입니다.");
			System.out.println("등급은 A입니다");
		}else {
			System.out.println("점수가 90점보다 작습니다.");
			System.out.println("등급은 B입니다");
		}
		
		//3.
		int score3 = 75;
		
		if(score3 >= 90) {
			System.out.println("점수가 100~90점입니다.");
			System.out.println("등급은 A입니다");
		}else if(score3 >= 80){
			System.out.println("점수가 80~89점입니다.");
			System.out.println("등급은 B입니다");
		}else if(score3 >= 70){
			System.out.println("점수가 70~79점입니다.");
			System.out.println("등급은 C입니다");
		}else {
			System.out.println("점수가 70점 미만입니다.");
			System.out.println("등급은 D입니다");
		}
		/*
		  Math : 수학 관련 메소드를 제공하는 클래스
		  	Math.random()
		  Random : 난수 관련 메소드를 제공하는 클래스
		  
		 */
		
		Random random = new Random();
		System.out.println(random.nextInt()); //int가 표현할 수 있는 범위 내의 난수 생성 +-21억
		System.out.println(random.nextInt(3)); // 0 ~ 2 숫자가 나옴
		System.out.println(random.nextInt(5)); // 0 ~ 5 숫자가 나옴
		System.out.println(random.nextInt(5)+1); // 1 ~ 6 숫자가 나옴
		System.out.println(random.nextInt(26)+97); //아스키코드 문자가 97부터 시작함 97~122까지의 숫자를 얻게 됨. 
		char c1 = (char)(random.nextInt(26)+97); // -> 형변환하면 문자(소문자해당)로 나오게 됨.
		System.out.println(c1);
		
		/*java 난수 생성하는 방법
		 
		 	(int)(Math.random()*개수)+시작번호
		 	random.nextInt(개수)+시작번호
		 	
		  	예) 1~6
		  		1) (int)(Math.random()*6+1);
		  		2) Random random = new Random();
		  		   random.nextInt(6)+1
		  	예 a~z
		  		1) (char)(Math.random)*26+97;		*26+65
		  		2)  Random random = new Random();	 26+65
		  			(char)(random.nextInt(26)*97
  		   
		 */
		//4. 난수 생성 제어문
		int num = (int)(Math.random()*6 +1); //주사위 1 < num < 7 즉, 1,2,3,4,5,6중에 나옴. (실수가 나오는데 (int) 자동 타입변환으로 소수점을 버림
		
		if(num == 1) {
			System.out.println("1번이 나왔습니다.");
		}else if(num == 2) {
			System.out.println("2번이 나왔습니다.");
		}else if(num == 3) {
			System.out.println("3번이 나왔습니다.");
		}else if(num == 4) {
			System.out.println("4번이 나왔습니다.");
		}else if(num == 5) {
			System.out.println("5번이 나왔습니다.");
		}else { //1,2,3,4,5가 아닐 때 6밖에 없음.
			System.out.println("6번이 나왔습니다.");
		}
		
		//5. 중첨 if문
		int score5 =(int)(Math.random()*20)+81; // 81 <= score5 <= 100
		
		if(score5 >= 90) {
			if(score5 >= 95) {
				System.out.println("A+");
			}else {
				System.out.println("A");
			}
		}else {
			if(score5 >= 85) {
				System.out.println("B+");
			}else {
				System.out.println("B");
			}
		}
		
	}

}
