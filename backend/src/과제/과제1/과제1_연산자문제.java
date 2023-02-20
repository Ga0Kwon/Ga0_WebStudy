package 과제.과제1;

import java.util.Scanner;

public class 과제1_연산자문제 {//class s
	public static void main(String[] args) {//main s
		//문제 1
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");
        
        //문제2
          Scanner scanner = new Scanner(System.in);
        System.out.print("작성자 : ");
        String writer = scanner.nextLine();
        System.out.print("내용 : ");
        String content = scanner.nextLine();
        System.out.print("날짜 :");
        String date = scanner.nextLine();
        
        System.out.println("--------------방문록--------------------");
        System.out.printf("| %3s  | %6s | %15s | %6s |\n", "순번", "작성자", "내용", "날짜");
        System.out.printf("| %4d  | %6s | %15s | %6s |\n", 1, writer, content, date);
        System.out.println("----------------------------------------");
        
        //문제3
        System.out.print("기본금 : ");
        int 기본급 = scanner.nextInt();
        System.out.print("수당 : ");
        int 수당 = scanner.nextInt();
        int 수령액 = (int)(기본급 + 수당 - 기본급*0.1); 
        System.out.printf("실수령액 : %d", 수령액);
        System.out.println();
        
        //문제4
        System.out.print("금액 : ");
        int price = scanner.nextInt();
        int 십만원 = price/100000;
        int 만원 = (price%100000)/10000;
        int 천원 = ((price%10000)/1000);
        int 백원 = ((price%1000)/100);
        System.out.printf("십만원 : %d\n만원 : %d\n천원 : %d\n백원 : %d\n", 십만원, 만원, 천원, 백원);
        
        //문제5
        System.out.print("숫자 입력 : ");
        int number5 = scanner.nextInt();
        char result5 = number5 % 7 == 0 ? 'O' : 'X'; 
        System.out.println(number5+"는 7의 배수인가? "+result5);
        
        //문제6
        System.out.print("숫자 입력 : ");
        int number6 = scanner.nextInt();
        char result6 = number6 % 2 != 0 ? 'O' : 'X'; 
        System.out.println(number6+"는 홀수인가? "+result6);
        
        //문제7
        System.out.print("숫자 입력 : ");
        int number7 = scanner.nextInt();
        char result7 = (number7 % 7 == 0 && number7%2 == 0)? 'O' : 'X'; 
        System.out.println(number7+"는 7의 배수이면서 짝수인가? "+result7);
        
        //문제8
        System.out.print("숫자 입력 : ");
        int number8 = scanner.nextInt();
        char result8 = (number8 % 7 == 0 || number8%2 != 0)? 'O' : 'X'; 
        System.out.println(number8+"는 7의 배수이거나 홀수인가? "+result8);
        
        //문제9
        System.out.print("첫번째 숫자 입력 : ");
        int x = scanner.nextInt();
        System.out.print("두번째 숫자 입력 : ");
        int y = scanner.nextInt();
        int result9 = x >= y ? x : y;
        System.out.println("더 큰 수는 " + result9);
        
        //문제10
        System.out.print("반지름 입력 : ");
        double r = scanner.nextDouble();
        System.out.println("원의 넓이는 " + r*r*3.14);
    
        //문제11
        System.out.print("실수 숫자 입력1 : ");
        double 실수1 = scanner.nextDouble();
        System.out.print("실수 숫자 입력2 : ");
        double 실수2 = scanner.nextDouble();
        double result11 = (실수1/실수2)*100;
        System.out.println("앞의 실수는 뒤의 실수의 " +result11);
        
        //문제12
        System.out.print("사디리꼴 윗변 :");
        int upLength = scanner.nextInt();
        System.out.print("사디리꼴 아래변 :");
        int downLength = scanner.nextInt();
        System.out.print("사디리꼴 높이 :");
        int height = scanner.nextInt();
        double 사다리꼴넓이 = (upLength+downLength)*height/2;
        System.out.println("사디리꼴 넓이는 " + 사다리꼴넓이);
        
        //문제13
        System.out.print("키 :");
        double 키 = scanner.nextDouble();
        System.out.println(키+"의 표준 체중은 " + (키-100)*0.9);
        
        //문제14
        System.out.print("키 :");
        double 키1 = scanner.nextDouble();
        System.out.print("몸무게 :");
        double 몸무게 = scanner.nextDouble();
        System.out.println("BMI : "+ 몸무게/((키1/100)*(키1/100)));
        
        //문제15
        System.out.print("인치 :");
        int inch= scanner.nextInt();
        double cm = inch*2.54;
        System.out.println(inch+ "inch ->" + cm + "cm");
        
        //문제16
        System.out.print("중간고사 : ");
        int 중간고사 = scanner.nextInt();
        System.out.print("수행평가 : ");
        int 수행평가 = scanner.nextInt();
        System.out.print("기말고사 : ");
        int 기말고사 = scanner.nextInt();
        System.out.println("내신 점수 :" +  (중간고사*0.3 + 기말고사*0.3 +  수행평가*0.4));
        
        //문제17
        int x1 = 10;
    	int y1 = x1-- + 5 + --x1;
    	System.out.printf(" x의 값 : %d , y의값 :  %d ", x1, y1); //8 23
    	System.out.println();
    	
    	//문제18
        System.out.print("나이 : ");
    	int age = scanner.nextInt();
     	String 어느쪽 = (age >= 40 ?  "중년" : 
   										age >= 20 ? "성인" :
   															age>= 10 ? "학생" : "애기");
   	    System.out.println(age + " : " + 어느쪽 );
 	
    	//문제19
        System.out.print("국어점수 : ");
    	double k_score = scanner.nextDouble();
        System.out.print("영어점수 : ");
    	double e_score = scanner.nextDouble();
        System.out.print("수학점수 : ");
    	double m_score = scanner.nextDouble();
    	double total_score =  k_score + e_score + m_score;
   		double avg_score =  total_score/3;
   		System.out.printf("[국어, 영어, 수학] 총점 %.0f 평균 %.2f ", total_score, avg_score);
    	System.out.println();
    	 scanner.nextLine();
    	
    	//문제20
        System.out.print("아이디 : ");
    	String 아이디 = scanner.nextLine();
        System.out.print("비밀번호 : ");
    	String 비밀번호 = scanner.nextLine();
     	String 로그인결과 = 아이디.equals("admin") ? 
    										비밀번호.equals("1234") ? "로그인성공" : "로그인실패"
   																						: "로그인실패";
    	System.out.println("로그인 결과는 " +로그인결과);
    	
    	//문제21
        System.out.print("숫자 3개를 입력 : ");
    	int x21 = scanner.nextInt();
    	int y21 = scanner.nextInt();
    	int z21 = scanner.nextInt();
    	
    	int temp = x21;
    	temp = (x21 > y21) ?  x21 : y21;
    	temp = (temp > z21) ?  temp : z21;
    	System.out.println("가장 큰수는 " + temp);
    	
    	//문제22
        System.out.print("[player1]가위바위보 : ");
    	int player1 = scanner.nextInt();
    	System.out.print("[player2]가위바위보 : ");
    	int player2 = scanner.nextInt();
    	/*가위 0, 바위 1 , 보 2
    	 뺐을 때 1 차이면 큰쪽이 이기고, 2 차이면 작은 쪽이 이긴다. */
    	
    	String result22 = (player1 > player2) ? 
    						(player1 - player2 == 1) ? /*참*/
    							"player1이 승리" : (player1-player2 == 2) ? 
    									"player2가 승리" : "무승부"
    										: (player1 < player2) ? 
    												(player2-player1 == 1) ? "player2가 이김" : 
    													(player2-player1 == 2) ? 
    															"player1이 이김" :"무승부" 
    																				:"무승부";
    	
    	System.out.println("player1 : " + player1 + "\tplayer2 : " + player2+ " \n가위바위보 결과" + result22);
	}//main e
}//class e
