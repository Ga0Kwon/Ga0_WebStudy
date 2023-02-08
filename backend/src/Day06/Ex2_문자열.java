package Day06;

public class Ex2_문자열 {//class s
	public static void main(String[] args) {//main s
		
		//1. 자바 문자열을 사용하는 방법
		
			//1) 배열 [모든 언어가 사용할 수 있는 방법]
		char[] 문자열1 = new char[] {'안', '녕'};
		
			//2) 클래스[객체]
		String 문자열2 = new String("안녕");
		
			//3) 문자 리터럴 "" => new 안써도 힙에 생성이 됨.
		String 문자열 = "안녕";
		
		
		String strVar1 = "홍길동"; //ex. 10번지
		String strVar2 = "홍길동"; //ex. 10번지
		
		if(strVar1 == strVar2) { //만약에 두 변수가 가지고 있는 주소가 같으면
			System.out.println("strVar1과 strVar2는 참조[주소]가 같음.");
		}else {
			System.out.println("strVar1과 strVar2는 참조[주소]가 다름.");
		}
		
		//주소 안에 있는 데이터 비교
		if(strVar1.equals(strVar2)) {
			//만약에 두 변수가 가지고 있는 주소의 데이터가 같으면
			System.out.println("strVar1과 strVar2의 문자열[참조 내부]이/가 같음.");
		}
		
		
		String strVar3 = new String("홍길동"); //ex. 20번지
		String strVar4 = new String("홍길동"); //ex. 30번지
		
		if(strVar3 == strVar4) {
			System.out.println("strVar3과 strVar4는 참조[주소]가 같음.");
		}else {
			System.out.println("strVar3과 strVar4는 참조[주소]가 다름.");
		}
		
		if(strVar3.equals(strVar4)) {
			System.out.println("strVar3과 strVar4의 문자열[참조 내부]이/가 같음.");
		}
		
		String hobby = "";
		
		if(hobby.equals("")) {
			System.out.println("hobby 변수가 참조는 String 객체는 빈 문자열");
		}
		
		String hobby2 = null;
		/*
		 * if(hobby2.equals("")) { //가져오지도 못함 -> null 값이라 => 에러 발생
		 * System.out.println("hobby2 변수가 참조는 String 객체는 null"); }
		 */
	
		if(hobby2 == null){
			System.out.println("hobby2 변수가 참조는 String 객체는 null");
		}
		
		//문자열 api 함수
		//1. charAt(인덱스)
		String ssn = "9506241230123";
		char sex = ssn.charAt(6); System.out.println(sex);
		if(sex == '1' || sex == '2') {System.out.println("남자");}
		else {
			System.out.println("여자");
		}
		
		int length = ssn.length(); //길이 13 / 인덱스 0 ~12
		if(length == 13) {
			System.out.println("주민등록번호 자릿수 맞음");
		}else {
			System.out.println("주민등록번호 자릿수 다름");
		}
		
		String oldStr = "자바 문자열은 불변입니다. 자바 문자열은 String 입니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		
		System.out.println(oldStr);
		System.out.println(newStr);
		
		String ssn2 = "000606-1234567";
		String firstNum = ssn2.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn2.substring(7); //시작인덱스 7에서 끝까지
		System.out.println(secondNum);
		
		String subject = "자바프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		String subString= subject.substring(location);
		System.out.println(subString);
		
		location = subject.indexOf("자바");
		
		if(location != -1) {
			System.out.println("자바와 관련된 책이군요.");
		}else {
			System.out.println("자바와 관련 없는 책이군요.");
		}
		
		boolean result = subject.contains("자바");
		
		if(result) {
			System.out.println("자바와 관련된 책이군요.");
		}else {
			System.out.println("자바와 관련 없는 책이군요.");
		}
		
		String board = " 1, 자바 학습, 참조타입 String을 학습합니다., 홍길동.";
		
		String[]tokens = board.split(","); //, 기준으로 분리했을 때 4조각/인덱스 --> 배열 크기 4
		
		System.out.println("번호 : " + tokens[0]);
		System.out.println("제목 : " + tokens[1]);
		System.out.println("내용 : " + tokens[2]);
		System.out.println("성명 : " + tokens[3]);
		
		System.out.println("for 문 사용");
		
		for(int i = 0; i < tokens.length; i++) {
			System.out.println(tokens[i]);
		}
		
	}//main e
}//class e

/*
  자바 문자열을 사용하는 방법
  	1. 배열, 클래스, 문자리터럴
  	2. 문자리터럴
  		  - 문자리터럴이 동일한 경우 객체 공유 [주소 같다 ==] => 문자 리터럴사용했을 때 같다(==) 가능
  		  - ex.
  		  	String 문자열1 = "안녕";
  		  	String 문자열2 = "안녕";
  		  	
  		  	문자열1 == 문자열2 (true)
  		  	문자열1.eqauls(문자열2) (true)
 	3. 클래스
 		  - new 연산자 [객체 메모리 생성]
 		  - ex.
 		  String 문자열1 = new String("안녕");
 		  String 문자열2 = new String("안녕");
 		  
 		  문자열1 == 문자열2 (false)
 		  문자열1.eqauls(문자열2) (true)
  
  자바 문자열의 함수
  	.charAt(인덱스) : 인덱스 위치의 문자 1개 추출
  	.length() : 문자열 길이
  	.replace("기존문자", "새로운문자"); : 기존 문자를 새로운 문자로 치환/교체
  	.subString(인덱스); : 0 ~ 인덱스 자르기
  		.subString(시작인덱스, 마지막인덱스); : 시작인덱스 ~ 마지막 인덱스 자르기
	.indexOf('찾을 문자') : 찾을 문자의 찾은 인덱스 번호 반한
	.split("자를 기준"); : 기즌 믄자 기준으로 자르기
	.contains("찾을문자"); : 찾을 문자가 존재하면 true 아니면 false
	.getBytes() : 해당 문자를 바이트화 시킴
  
 */
