package Day06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex6_비회원게시판_변수ver {//class s
	public static void main(String[] args) throws Exception {//main s
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			
			System.out.println("-------------------------게시판------------------------");
			System.out.println("번호 \t\t 제목 \t\t 작성자 \t\t 조회수");
			
			// 파일에 있는 문자열을 가져오기
			/*파일 입력 클래스 생성 후 (파일 경로)*/
			FileInputStream fin = new FileInputStream("C:/java/board.txt");
			
			/*읽어온 바이트를 저장하기 위해 바이트배열 1000바이트 미리 생성*/
			byte[] inbytes = new byte[1000]; //영문은 한글자당 1바이트[아스키코드], 한글은 한글자당 3바이트[유니코드]
			
			/*read() 메소드를 이용한 파일 일기 [*읽은 바이트를 바이트 배열에 저장]*/
			// inbytes : 읽어온 바이트를 배열에 저장
			// bytecount : 읽어온 바이트의 개수
			int byteCount = fin.read(inbytes); // 읽어온 바이트를 바이트 배열엥 저장 스트림 : 바이트 단위
			
			if(byteCount > -1) {
				
				/*바이트 배열  ---- > 문자열*/
					//new String("유재석");
					//new String(바이트배열); new String(바이트배열, 시작인덱스, 마지막인덱스);
				String boardList = new String(inbytes, 0, byteCount); //바이트 배열 --> 문자열로 변환
				String []boards = boardList.split("\n"); //행기준으로 분리 [만약에 게시물 2개일 때는 3조각]
				
				
				//행마다 열 기준 자르기 [길이 -1, 마지막인덱스 제외]
				for(int i = 0; i < boards.length; i++) {
					//*게시물 마다 열 자르기
					String[] cols = boards[i].split(",");
					String title = cols[0];
					String content = cols[1];
					String writer = cols[2];
					String password = cols[3];
					
					System.out.printf("%2d\t %10s \t  %10s \t\t %3d", i , title, writer, 0);
					System.out.println();
			}
			}
			
			
			
			System.out.println("-----------------------<메뉴 입력>----------------------");
			System.out.print("메뉴 > -1 쓰기, -2 나가기 : ");
			
			int choice = scanner.nextInt();
			
			if(choice == -1) { //쓰기
				System.out.println("-----------------------게시물 작성----------------------");
				System.out.print("제목 : "); String title = scanner.next(); 
				System.out.print("내용 : "); String content = scanner.next(); 
				System.out.print("작성자 : "); String writer = scanner.next(); 
				System.out.print("비밀번호 : ");String password = scanner.next(); 
				
				//, : 열 구분선[데이터 구분] \n : 행 구분선[게시물 구분]
				String outStr = title+","+content+","+writer+","+password+"\n";
				
				//작성한 데이터를 파일 처리 [ 영구저장 ]
				//1) 파일처리[클래스] => 파일 객체 생성 ("파일경로", true[=이어쓰기여부]) => 처음부터 true넣을거면 파일 자체가 이미 존재해야함
				FileOutputStream fout = new FileOutputStream("C:/java/board.txt", true);
				fout.write(outStr.getBytes());
				
			}else if (choice == -2) { // 나가기
				break;
			}
		}
	}//main e
}//class e
