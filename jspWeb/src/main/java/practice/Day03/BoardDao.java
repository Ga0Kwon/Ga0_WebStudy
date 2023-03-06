package practice.Day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import practice.Day02.Dao;

public class BoardDao {
	//[싱글톤]
	//1. 내부객체
	private static BoardDao bdao = new BoardDao();
	
	public static BoardDao getInStance() {
		return bdao;
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//생성자
	private BoardDao() {
		try {
			// * [웹 서버] 해당 MYSQL 드라이버[라이브러리] 찾기 => 안넣으면 실행이 X
			Class.forName("com.mysql.cj.jdbc.Driver"); //console 프로젝트 필요X
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspWeb",
					"root", 
					"1234");
			
			System.out.println("연동 성공");
		}catch (Exception e) {
			System.err.println("연동 실패 : " + e.getMessage());
		}
	}
	
	//1. post [등록 ; C]
	public boolean onWrite(BoardDto dto) {
		String sql = "insert into ex3 (bcontent, bwriter) values (?, ?)" ;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getBcontent());
			ps.setString(2, dto.getBwriter());
			
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//2. 출력
	public ArrayList<BoardDto> printBoard(){
		ArrayList<BoardDto> boardDB = new ArrayList<>();
		String sql = "select * from ex3";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(4),
						rs.getString(3));
				
				boardDB.add(dto);
			}
			return boardDB;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//3. 수정
	public boolean onUpdate(int bno, String updateContent) {
		String sql = "update ex3 set bcontent = ? where bno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, updateContent);
			ps.setInt(2, bno);
			
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//4. 삭제
	public boolean onDelete(int bno) {
		String sql = "delete from ex3 where bno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
