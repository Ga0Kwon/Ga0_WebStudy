package Day14.Ex4;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex5_DB연동2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection con = null; //여러 if()안에서 사용하기 위해 
		PreparedStatement pstmt = null;
		
		while(true) {
			//1. 예외 발생할 것 같은 코드 [예상 : nextInt() 인데 문자열 입력시 예외 발생]
			System.out.print("1. DB연결 2. SQL 구문 삽입 3. 매개변수 구문 삽입 : ");
			try {
				int choice = scanner.nextInt();
				if(choice == 1) {
					
					System.out.print("연결할 DB명 입력 : ");
					String dbName = scanner.next();
					System.out.println(dbName +" DB에 연결합니다.");
					
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName, "root", "1234");
					System.out.println("DB연결 성공!");

				}else if(choice == 2) {

					System.out.print("sql 구문 입력 : ");
					scanner.nextLine(); //* scanner.nextLine();앞에 다른 .next()있을 떄 오류 방지
					String sql = scanner.nextLine();
					
					//*연결된 DB객체에 SQL 대입
					pstmt = con.prepareStatement(sql);
					
					pstmt.execute();

					
				}else if(choice == 3) {
					System.out.print("번호 : "); int mno = scanner.nextInt();
					System.out.print("아이디 : "); String id = scanner.next();
					System.out.print("비밀번호 : "); String password = scanner.next();
				
					String sql = "insert into member values (?, ?, ?);";
					
					//*연결된 DB객체에 SQL 대입
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, mno); //1 : sql 구문에서 첫번째 ? 자리
					pstmt.setString(2, id); //2 : sql 구문에서 두번째 ? 자리
					pstmt.setString(3, password); //3 : sql 구문에서 세번째 ? 자리
						
					pstmt.executeUpdate();
				}
			}catch(InputMismatchException e) {
				System.out.println("알 수 없는 번호 입니다. " + e);
				// 알 수 없는 번호를 했을 때 scanner에 그 알수없는 값이 남아 있어서 에러가 계속 생김
				scanner = new Scanner(System.in); //기존에 입력된 데이터 제거
			}catch(SQLException e) {
				System.out.println("SQL 오류 : " + e);
			}
		}
	}
}
