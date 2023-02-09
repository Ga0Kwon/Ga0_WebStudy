package Day07.Ex3;

import java.util.Scanner;

public class 실행 {//class s
	public static void main(String[] args) {//main s
		Scanner scanner = new Scanner(System.in); //입력객체
		
		String[] 배열 = new String[3]; //String 객체 3개를 저장할 수 있는 배열
									  //String 문자열 1개 저장하는 클래스/객체
		
		Member[] 배열2 = new Member[3]; //Member 객체 3개를 저장할 수 있는 배열
									   //Member 문자열 2개[id, password] 저장하는 객체배열
		// *객체 활용 OX
		//1.
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.print("비밀번호 : "); String password = scanner.next();
		배열[0] = id + "," + password; //아이디와 비밀번호 ','로 구분해서 하나의 문자열 합치기
		
		System.out.println(배열[0].split(",")[0]);
		
		//2. 회원클래스 만들어서 회원객체를 만들자
		Member member = new Member();
		member.id = id; //입력받은 아이디를 객체내 필드인 id에 대입
		member.password = password; //입력받은 패스워드를 객체내필드인 password에 대입
		
		배열2[0] = member; //배열2에 m1 객체 대입.
		System.out.println(배열2[0].id);
		
	}//main e
}//class e
