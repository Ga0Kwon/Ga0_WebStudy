package practice.Day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import practice.Day02.Dao;

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
		
		//1. Dto X
		public boolean setData(String data1, String data2, double data3,
				int data4, String data5, String data6, String data7,
				boolean data8, String data9, String data10) {
			
			String sql = "insert into ex2 values (?,?,?,?,?,?,?,?,?,?)";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, data1);
				ps.setString(2, data2);
				ps.setDouble(3, data3);
				ps.setInt(4, data4);
				ps.setString(5, data5);
				ps.setString(6, data6);
				ps.setString(7, data7);
				ps.setBoolean(8, data8);
				ps.setString(9, data9);
				ps.setString(10, data10);
				
				ps.executeUpdate();
				
				return true;
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
		
		//2. Dto O
		public boolean setDtoData(Dto dto) {
			String sql = "insert into ex2 values (?,?,?,?,?,?,?,?,?,?)";
			
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getData1());
				ps.setString(2, dto.getData2());
				ps.setDouble(3, dto.getData3());
				ps.setInt(4, dto.getData4());
				ps.setString(5, dto.getData5());
				ps.setString(6, dto.getData6());
				ps.setString(7, dto.getData7());
				ps.setBoolean(8, dto.isData8()); //boolean은 getData가 아닌 isData이다.
				ps.setString(9, dto.getData9());
				ps.setString(10, dto.getData10());
				
				ps.executeUpdate();
				
				return true;
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return false;
			}
		}
		
		//2. DTO X version
		public ArrayList<Object> getData() {
			//Dto가 필요한 이유! Object를 쓰면 구분을 못한다,,, 
			ArrayList<Object> infoDB = new ArrayList<>();
			
			String sql = "select * from ex2";
			/*여러개 자료형 ---> 하나의 자료형 [클래스]
			  동일한 자료형 ---> 하나의 자료형 [리스트 혹은 배열]
			*/
			
			try {
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					infoDB.add(rs.getString(1));
					infoDB.add(rs.getString(2));
					infoDB.add(rs.getDouble(3));
					infoDB.add(rs.getInt(4));
					infoDB.add(rs.getString(5));
					infoDB.add(rs.getString(6));
					infoDB.add(rs.getString(7));
					infoDB.add(rs.getBoolean(8));
					infoDB.add(rs.getString(9));
					infoDB.add(rs.getString(10));
				}
				return infoDB;
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		}
		
		//DTO O version
		public ArrayList<Dto> getDtoData(){
			ArrayList<Dto> dtoDB = new ArrayList<>();
			String sql = "select * from ex2";

			try {
				ps = con.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Dto dto = new Dto( // 레코드 1개 --> Dto 1개 --> 리스트 담기[Dto 여러개] 
							rs.getString(1), 
							rs.getString(2), 
							rs.getDouble(3), 
							rs.getInt(4), 
							rs.getString(5), 
							rs.getString(6), 
							rs.getString(7), 
							rs.getBoolean(8), 
							rs.getString(9), 
							rs.getString(10));
					
					dtoDB.add(dto);
				}
				return dtoDB;
			}catch(Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
			
		}
}
