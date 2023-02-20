package Day14.Ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ex4_DB연동 {
	public static void main(String[] args) {
		try {
			//1. Connection : 연결 인터페이스
				//DriverManagerm : 싱글톤 객체	
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "1234"); 
			//java에서 DB생성 불가능때문에 DB생성하고 난 후 실행
			
			System.out.println("DB연동 성공");
			
			//2. table 생성하는 sql 구문을 문자열 변수에 저장
			String sql = "create table member(mno int, mid varchar(20), password varchar(20))";
			
			//3. DML DDL 조작 인터페이스에 연결된 DB연결구현객체에 sql대입 
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//4. execute() : SQL 실행
			pstmt.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("DB연동 실패 사유 : " + e);
			
		}
		
	}
}

/*
  	[JAVA에서 DB(database)는 생성 못함 -> 연결할때 DB 경로가 필요하기 때문]
  	JDBC : 자바와 DB 연결 드라이브
  		- 해당 DBMS마다 라이브러리 [.JAR] 파일 필요
  		- 보관장소 : C://mysql-connector-j-8.0.XX 이어야 다른 사람과 할때 편하다
  		
	- 라이브러리
		1. 프로젝트 오른쪽 클릭 -> bulid path -> configure build
		2. Libaries 탭에서 javaSE 버전 변경
			[javaSE-1.8일 경우 생략]
				1) javaSE - 17
				2) 더블클릭 -> JAVASE -1.8 변경 -> apply
			1. add External jars
			2. mysql-connector-j-8.0.XX -> .jar 파일 찾아서 추가
			
	- 
		Connection : DB 연결 인터페이스로 다양한 객체를 제공
		DriverManager : DB 연결 클래스 구현객체 제공
			1) DriverManager.getConnection(db주소, 계정 ,비밀번호);
				- 일반예외 발생 -> 예오;처리 필수
				- MySQL server 주소 : jdbc:mysql://ip주소:포트번호/db명
 
*/