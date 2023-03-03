package practice.Day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		
		//1. 
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
}
