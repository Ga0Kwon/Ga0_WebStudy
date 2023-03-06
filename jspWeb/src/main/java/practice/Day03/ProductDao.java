package practice.Day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductDao {
	//[싱글톤]
	//1. 내부객체
	private static ProductDao pdao = new ProductDao();
	
	public static ProductDao getInStance() {
		return pdao;
	}
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	//생성자
	private ProductDao() {
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
	
	//1) 제품 등록
	public boolean insertProduct(productDto dto) {
		String sql = "insert into product (prod_name, prod_price)values ( ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getProductName());
			ps.setInt(2, dto.getProductPrice());
			
			ps.executeUpdate();
			return true;
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//2) 제품 출력
	public ArrayList<productDto> printProduct(){
		ArrayList<productDto> productList = new ArrayList<>();
		
		String sql = "select * from product";
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				productDto dto = new productDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getInt(3));
				
				productList.add(dto);
			}
			return productList;
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//3) 제품 수정
	public boolean updateProduct(productDto dto) {
		String sql = "update product set prod_name = ?, prod_price = ? where pno = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getProductName());
			ps.setInt(2, dto.getProductPrice());
			ps.setInt(3, dto.getPno());
			
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	//4) 제품 삭제
	public boolean deleteProduct(int pno) {
		String sql = "delete from product where pno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pno);
			
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
}
