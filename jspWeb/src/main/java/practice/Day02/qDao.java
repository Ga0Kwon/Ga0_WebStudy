package practice.Day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class qDao {
	//[싱글톤]
	//1. 내부객체
	private static qDao qdao = new qDao();
	
	public static qDao getInStance() {
		return qdao;
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//생성자
	private qDao() {
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
	
	public boolean setqData(qDto qdto) {
		String sql = "insert into q2 values (?,?,?,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, qdto.getName());
			ps.setString(2, qdto.getPhoneNumber());
			ps.setDouble(3, qdto.getHeight());
			ps.setInt(4, qdto.getAge());
			ps.setString(5, qdto.getSignDate());
			ps.setString(6, qdto.getSex());
			ps.setBoolean(7, qdto.isAgree());
			ps.setString(8, qdto.getLocation());
			ps.setString(9, qdto.getIntroduce());
			
			ps.executeUpdate();
			
			return true;
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public ArrayList<qDto> getqData(){
		ArrayList<qDto> dtoList = new ArrayList<>();
		
		String sql = "select * from q2";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				qDto qdto = new qDto(
						rs.getString(1), 
						rs.getString(2), 
						rs.getDouble(3), 
						rs.getInt(4), 
						rs.getString(5),
						rs.getString(6), 
						rs.getBoolean(7), 
						rs.getString(8), 
						rs.getString(9));
				
				dtoList.add(qdto);		
			}
			return dtoList;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
