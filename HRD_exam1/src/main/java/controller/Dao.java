package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class Dao {
	
	public Connection con;
	public PreparedStatement ps;
	public ResultSet rs;
	
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/xe",
				"root", 
				"1234");
		
		return con;
		
	}
	
	public Dao() {
		try {
			con = getConnection();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	//1. 마지막 회원번호+1 가져오기
	public int getcustno() {
		String sql = "select max(custno)+1 from member_tb1_02";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return -1; 
	}
	
	// 2. 회원등록
	public boolean join( memberDto dto ) {
		String sql ="insert into member_tb1_02"
				+ " (custname,phone,address,joindate,grade,city)"
				+ " values(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString( 1 , dto.getCustname()  );
			ps.setString( 2 , dto.getPhone()  );
			ps.setString( 3 , dto.getAddress()  );
			ps.setString( 4 , dto.getJoindate()  );
			ps.setString( 5 , dto.getGrade()  );
			ps.setInt( 6 , dto.getCity()  );
			System.out.println(dto);
			ps.executeUpdate(); return true;
		}catch (Exception e) {} return false;
	}
	
	//3. 모든 회원 목록 출력
	public ArrayList<memberDto> getmemberList(){
		ArrayList<memberDto> memberlist = new ArrayList<>();
		
		String sql = "select custno, custname, phone, address, joindate, IF(grade = 'A', 'VIP', IF(grade = 'B', '일반', '직원')) as g, city"
						+ "	from member_tb1_02;";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				memberDto dto = new memberDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7));
				
				memberlist.add(dto);
			}
			return memberlist;
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	//4. 특정 회원 출력
	public memberDto getMember(int custno) {
		String sql = "select * from member_tb1_02 where custno = " +custno;
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new memberDto(
						rs.getInt(1), 
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getInt(7));
				
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	//회원정보 수정
	public boolean setMember(memberDto dto) {
		String sql = "update member_tb1_02"
				+ " set custno = ?, custname = ?, phone = ?, address = ?, joindate = ?, grade = ?, city = ?"
				+ " where custno = " + dto.getCustno();

		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, dto.getCustno());
			ps.setString(2, dto.getCustname());
			ps.setString(3, dto.getPhone());
			ps.setString(4, dto.getAddress());
			ps.setString(5, dto.getJoindate());
			ps.setString(6, dto.getGrade());
			ps.setInt(7, dto.getCity());
			
			int count  = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	//매출 현황
	public ArrayList<memberDto> getSumlist(){
		ArrayList<memberDto> membersumlist = new ArrayList<>();
		
		String sql = "select mon.custno, mem.custname, IF(mem.grade = 'A', 'VIP', IF(mem.grade = 'B', '일반', '직원')) as g, sum(mon.price) as sum"
				+ "	from money_tbl_02 mon natural join member_tb1_02 mem group by mon.custno order by sum desc";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				membersumlist.add(new memberDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getInt(4)));
			}
			return membersumlist;
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
