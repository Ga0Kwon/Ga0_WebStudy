package Day06;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex3_문자열2 {//class s //  throws Exception : 예외가 생기면 무시
	public static void main(String[] args) throws Exception {//main s
		// Scanner scanner : 스택영역
		// new Scanner(System.in); : 힙 영역
		
		//1. 문자열 입력받기
		Scanner scanner = new Scanner(System.in); //입력객체
		while(true) {
			System.out.print("문자열을 입력해주세요 : "); 
			String input = scanner.nextLine() + "\n"; //입력객체가 제공하는 메소드 => 입력받은 문자열을 변수에 저장
			System.out.println(input);
			
			//2. 문자열 파일에 저장 => stream은 바이트 전달밖에 안됨 [ 자바의 키보드/피일/네트워크 등등 통신할때 무조건 바이트 단위)
				//out : 나간다는의미. console 도 java에서 나간다는 것, file도 나가서 file을 생성해 넣는거니까 out
				//FileOutputStream("파일경로", 이어쓰기 여부) : 파일 쓰기 클래스 => 파일처리하는 이유는 영구저장
					//.write(바이트 배열) 
				//문자열.getBytes() : 바이트로 바꾸고 배열로 저장한다. => 해당 문자열을 바이트배열로 반환
			/* FileOutputStream fout = new FileOutputStream("C:\\java\\test.txt"); */ // => 해당 경로에 txt 파일이 생김 [새로 쓰기O / 이어쓰기X]
			 FileOutputStream fout = new FileOutputStream("C:\\java\\test.txt", true); //뒤에 true를 넣으면 이어서 쓰기가 가능함.
			fout.write(input.getBytes());
		}
	}
}//class e
