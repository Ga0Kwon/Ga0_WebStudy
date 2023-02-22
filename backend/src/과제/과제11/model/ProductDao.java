package 과제.과제11.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDao {
	private static ProductDao dao = new ProductDao();
	
	
	public static ProductDao getInstance() {
		return dao;
	}
	
	private static Connection conn;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	//생성자
	private ProductDao() {
		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/과제11", "root", "1234");
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//1. 제품 등록
	public boolean enrollProduct(ProductDto dto) {
		String sql = "" + "INSERT INTO product (pName, pPrice, pStock) VALUES (?, ? , ?)";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getpName());
			pstmt.setInt(2, dto.getpPrice());
			pstmt.setInt(3, dto.getpStock());
			
			pstmt.executeUpdate();
			
			return true;
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//2. 모든 제품 출력
	public ArrayList<ProductDto> printProduct() {
		ArrayList<ProductDto> productList = new ArrayList<>();
		
		String sql = "select * from product";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDto dto = new ProductDto(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				productList.add(dto);
			}
			return productList;
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	// [번외] 있는 제품 번호인지 확인
	public boolean checkPNo(int pno) {
		String sql = "select * from product where pNo = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pno);
			
			rs = pstmt.executeQuery();
			
			if(!rs.next()) { //읽어드릴 레코드가 없다는 것은 없는 번호
				return false;
			}else {
				return true;
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	//3. 제품 이름, 가격 변경
	public int updateProductInfo(int pno, String name, int price) {
		if(checkPNo(pno)) { // 있는 제품 번호이다.
			String sql = "update product set pName = ?, pPrice = ? where pNo = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, name);
				pstmt.setInt(2, price);
				pstmt.setInt(3, pno);
				
				pstmt.executeUpdate();
				
				return 0;
				
			}catch (SQLException e) { //DB에서 에러가 발생한 경우
				System.out.println(e.getMessage());
				return -2;
			}
			
		}else { // 없는 번호일 경우
			return -1;
		}
	}
	
	//4. 제품 재고 변경
	public int updateProductStock(int pno, int stock) {
		if(checkPNo(pno)) {
			try {
				String sql = "update product set pStock = ? where pNo = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, stock);
				pstmt.setInt(2, pno);
				
				pstmt.executeUpdate();
				return 0;
			}catch(SQLException e) {
				System.err.println(e.getMessage());
				return -2;
			}
		}else {// 없는 번호일 경우
			return -1;
		}
	}
	
	//5. 제품 삭제
	public int deleteProduct(int pno) {
		if(checkPNo(pno)) {
			try {
				String sql = "delete from product where pNo = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pno);
				
				pstmt.executeUpdate();
				
				return 0;
				
			}catch(SQLException e) {
				System.err.println(e.getMessage());
				return -2;
			}
		}else {//없는 제품 번호일경우
			return -1;
		}
	}
}
