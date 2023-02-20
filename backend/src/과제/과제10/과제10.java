package 과제.과제10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class 과제10 {
	/*create database DB과제1; 후*/
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		while(true) {
			try{
				System.out.print("1. DB연결 2.SQL구문 작성 3.매개변수 입력 : ");
				int choice = scanner.nextInt();
				if(choice == 1) { //1. DB연결
					
					System.out.print("연결할 DB명 : ");
					String DBName = scanner.next();
					
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DBName, "root", "1234");
					
					System.out.println("[DB 연결 성공!]");
				}else if(choice == 2) { //2.SQL구문 작성
					if(!conn.equals(null)) {
						System.out.print("SQL 구문 입력 : ");
						scanner.nextLine();
						String sql = scanner.nextLine();
						
						pstmt = conn.prepareStatement(sql);
						
						pstmt.execute(); //실행
						
						System.out.println("SQL 구문 실행이 완료되었습니다.");
					}
					
				}else if(choice == 3) { //3.매개변수 입력
					if(!conn.equals(null)) {
						System.out.print("제품번호 : ");
						int productNo = scanner.nextInt();
						
						System.out.print("제품명 : ");
						String productName = scanner.next();
						
						System.out.print("제품설명 : ");
						scanner.nextLine();
						String productContent = scanner.nextLine();
						
						System.out.print("제품가격 : ");
						int productPrice = scanner.nextInt();
						
						String sql = "INSERT INTO PRODUCT VALUES (?, ?, ?, ?);";
						
						pstmt = conn.prepareStatement(sql);
						
						pstmt.setInt(1, productNo); //제품 번호
						pstmt.setString(2, productName); //제품 이름
						pstmt.setString(3, productContent); //제품 설명
						pstmt.setInt(4, productPrice);//제품 가격
						
						pstmt.executeUpdate(); //실행
						System.out.println("테이블에 데이터가 등록되었습니다.");
					}
				}
			}catch(InputMismatchException e) {
				
				System.err.println("알 수 없는 입력입니다. " + e);
				scanner = new Scanner(System.in);
			}catch(SQLException e) {
				
				System.err.println("SQL 오류 : " + e);
			}catch(Exception e) {
				System.err.println("DB 연결 후 다시 실행해주세요.");
			}
		}
	}
}
