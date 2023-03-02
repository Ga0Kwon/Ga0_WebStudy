package jspweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	//[싱글톤]
	//1. 내부객체
	private static Dao dao = new Dao();
	
	public static Dao getInStance() {
		return dao;
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//생성자
	private Dao() {
		try {
			// * [웹 서버] 해당 MYSQL 드라이버[라이브러리] 찾기
			Class.forName("com.mysql.cj.jdbc.Driver"); //console 프로젝트 필요X
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspWeb",
					"root", 
					"1234");
			
			System.out.println("연동 성공");
		}catch (Exception e) {
			System.err.println("연동 실패 : " + e.getMessage());
		}
	}
	
	//2. SQL 메소드
	//데이터 저장
	public boolean setData(String data) {
		//1) SQL 작성
		String sql ="insert into ex1 values(?)";
		
		//2)SQL 대입
		try {
			ps = con.prepareStatement(sql); //2)연결된 JDBC에 SQL 대입
			ps.setString(1, data); //3) SQL 조작
			ps.executeUpdate(); // 4) SQL 실행 --> 5. SQL 결과[rs]
			return true; 
		}catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	
	//데이터들 호출 [1개 String / 여러개 ArrayList<String>]
	public ArrayList<String> getData(){
		String sql = "select * from ex1";
		
		ArrayList<String> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
			return list;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//--------------------과제-----------------------
	//데이터 저장
	public boolean qSetData(String data) {
		//1) SQL 작성
		String sql ="insert into q1 values(?)";
		
		//2)SQL 대입
		try {
			ps = con.prepareStatement(sql); 
			ps.setString(1, data); 
			ps.executeUpdate(); 
			return true; 
		}catch(Exception e) {
			System.err.println(e);
			return false;
		}
	}
	public ArrayList<String> qGetData(){
		String sql = "select * from q1";
		ArrayList<String> list = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			
			return list;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
}
