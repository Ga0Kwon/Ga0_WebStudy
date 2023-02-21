package Day15.Ex9_MVC.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	
	// *싱글톤 : Dao 싱글톤 사용하는 이유 : 프로그램내 DB연동 1번만 해서 하나의 연동 객체 사용
		//1. 내부에 객체 만들기
	public static MemberDao dao = new MemberDao();
		//2. 생성자는 private -> 외부에서 new 사용 금지
		//3. 외부에서 내부 객체를 사용할 수 있게 내부 객체 반환 메소드 [getInstance]
	public static MemberDao getInstance() {
		return dao;
	}
	
	//1. 필드
	private static Connection conn; //1) 연결된 구현객체를 가지고 있는 인터페이스


	private PreparedStatement pstmt; //2) 연결된 sql 조작 [+ 매개변수]
	private ResultSet rs; //3) 실행된 sql 결과
	
	//2. 생성자 [연동 코드 ->객체 생성시 바로 연동될 수 있게 하려고]
	
	public MemberDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/day15", "root", "1234");
//			System.out.println("DB연동 성공!");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
	}
	
	//3. SQL 처리 메소드
	//1. 회원 가입 메소드 [인수 : Dto[id, pw, 반환 : 성공[true] or 실패[false]] 
	public boolean signup(MemberDto dto) {
		//2. 객체화 [이유 : 여러개 변수가 이동하면 로직이 길어짐 -> 여러개 변수를 하나의 객체로]
		//1) sql 작성한다.
		String sql = "" + "INSERT INTO member (mid, mpw) VALUES (? , ?)";
		//2) 연동 DB에 sql 작성
		try {
			
			pstmt = conn.prepareStatement(sql);
			//3) pstmt는 매개변수에 대한 조작 가능
			//첫번째 ?에 대한 데이터 대입
			pstmt.setString(1, dto.getMid());
			//두번째 ?에 대한 데이터 대입
			pstmt.setString(2, dto.getMpw());
			
			//4) pstmt가 sql 실행 후 업데이트
			pstmt.executeUpdate();
			
			//5) 결과 반환
			return true; //여기 까지 문제없었으면 저장 성공
			
		} catch (SQLException e) {
			System.out.println("DB 오류 : " + e);
			return false;
		}
		
	}
	//2. 출력 메소드
	public ArrayList<MemberDto> list() {
		ArrayList<MemberDto> memberDB = new ArrayList<>();
		
		String sql = "" + "select * from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setMno(rs.getInt("mno"));
				dto.setMid(rs.getString("mid"));
				dto.setMpw(rs.getString("mpw"));
				memberDB.add(dto);
			}
			
			return memberDB;
			
		}catch(SQLException e) {
			return null;
		}
	}
	
	
	//로그인 메소드
	public int login(MemberDto dto) {
		String sql = "" + "select * from member where mid = ? and mpw = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//3) pstmt는 매개변수에 대한 조작 가능
			//첫번째 ?에 대한 데이터 대입
			pstmt.setString(1, dto.getMid());
			//두번째 ?에 대한 데이터 대입
			pstmt.setString(2, dto.getMpw());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {

				return rs.getRow();
			}else {
				return -1;
			}
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return -2;
		}
	}
	
	
	
}
