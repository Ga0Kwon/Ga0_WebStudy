package Day06;

public class Ex4_배열 {//class s
	public static void main(String[] args) {//main s
		
		/*-----------------------------1.-----------------------------------*/
		//1. 선언
		String[] season = {"Spring", "Summer", "Fall", "Winter"};
		
		//2. 호출
		System.out.println("season[0] : " + season[0]);
		System.out.println("season[1] : " + season[1]);
		System.out.println("season[2] : " + season[2]);
		System.out.println("season[3] : " + season[3]);

		/* System.out.println("season[4] : " + season[4]); */ //오류발생 : 인덱스 없음
		
		//3. 인덱스 내 데이터 변경
		season[1] = "여름";
		System.out.println("season[1] : " + season[1]);
		
		int[] score = {83, 90, 87};
		int sum = 0;
		
		//4. 반복과 배열 관계
		for(int i = 0; i < 3; i++) {
			sum += score[i];
		}
		
		System.out.println("총합 : " + sum);
		double avg = (double) sum/score.length;
		System.out.printf("평균 : %.2f ", avg);
		

		/*-----------------------------2.-----------------------------------*/
		int[] arr1 = new int[3]; //1. int형 변수 3개를 저장할 수 있는 배열 선언 [배열 선언시 길이가 고정]
		
		for(int i = 0; i < arr1.length; i++) {// 0 0 0  [초기값]
			System.out.println(arr1[i]); //2. 확인
		}
		arr1[0] = 10; arr1[1] = 20; arr1[2] = 30; 
		
		for(int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]); //2. 확인
		}
		
		double[] arr2 = new double[3];
		
		for(double v : arr2) { // 0.0 0.0 0.0  [초기값]
			System.out.println(v);
		}
		
		arr2[0] = 0.1; arr2[1] = 0.2; arr2[2] = 0.3;
		
		for(double v : arr2) { 
			System.out.println(v);
		}
		
		String[] arr3 = new String[3];
		for(String v : arr3) {System.out.println(v);} //null null null [초기값]
		
		arr3[0] ="1월"; arr3[1] ="2월"; arr3[2] ="3월";
		for(String v : arr3) {System.out.println(v);} 
		
		
	}//main e
}//class e

/*
  - 
  	변수 : 데이터 1개  		스택 영역
  	배열 : 데이터 여러개		힙 영역
  	
  - 
  	JS			vs			JAVA
  	다른 타입					같은 타입
  	가변 길이					고정 길이
  	
  -
  	JS							JAVA
  	let 배열명 = []				int[]배열명 = {}
  	
  - 배열과 반복문 활용
  	---------JS---------
  	for(let 변수 in 배열명){ }
  	for(let 변수 of 배열명){ }
  	배열명.forEach((v) -> { })
  	배열명.map((v) -> { return 반환값;})
  	
  	--------JAVA--------
  	for(자료형 변수 : 배열명){}
  
  	1. 선언
  		1) 자료형타입[]배열명 = {허용범위내데이터1, 허용범위내데이터2}
  		2) 자료형타입[]배열명 = new 자료형타입[길이];
  		
  			- 초기값
  				int[]scores = new int[3];
  				자료형 : int int int
  				데이터 :  0   0   0
  				인덱스 :  0   1   2
  				-String[] names = new String[3];
  				자료형 : String String String
  				데이터 :  null   null   null
  				인덱스 :    0      1      2
  				
  		
	2. 호출 , 인덱스
		1) 배열명 : 첫번째 값의 주소값
		2) 배열명[인덱스] : 해당 인덱스의 위치한 데이터
		
	3. 데이터 변경
		1) 배열명[인덱스] = 새로운 데이터;
		
	4. 배열의 길이
		배열.length : 요소 개수만큼 
		인덱스 : 0 ~
  	
  
 
 */
 