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
	
	/*-------------------------사용자 페이지s------------------------*/
	//-1. 장바구니 목록 pNo로 정보 찾기
	public ArrayList<ProductDto> printCart(ArrayList<ProductDto> cartList){
		/*장바구니 목록에는 pNo와 구매할 개수만 담고 있기 때문에 출력할때 [번호  개수] 이렇게만 나오면 보기 안좋아서
		  개인적으로 추가한 내용.*/
		ArrayList<ProductDto> cartDto = new ArrayList<>();
		ArrayList<ProductDto> compareDto =  printProduct(); //compareDto는 전체 제품 목록을 담고 있는 리스트
		// 이건 관리자 페이지에서 모든 제품 출력했을 때 사용한 것. => 재사용.
		
		for(int i = 0; i < cartList.size(); i++) { //해당 인수로 받아온 [번호 개수] 리스트 사이즈만큼 반복문을 돌고
			for(ProductDto dto : compareDto) { // 모든 제품 목록의 사이즈만큼 반복문을 돌고
				if(cartList.get(i).getpNo() == dto.getpNo()) { //만약 현재 장바구니 리스트의 pNo와 반복문을 돈 compareDto의 pNo가 같으면
					ProductDto inputCartDto = new ProductDto( // 해당 정보를 받아오면 됨 [정보 : pNo, pName, pStock, pPrice] 전부 출력할 것이기 때문
							dto.getpNo(), 
							dto.getpName(), 
							dto.getpPrice(), 
							cartList.get(i).getpStock()); //여기서 이것만 cartList인 이유는 장바구니 리스트에서는 제품 재고가 아닌 구매할 개수를 띄울 것이기 때문
					cartDto.add(inputCartDto); //그렇게 객체에 정보를 다 받아왔으면 리스트에 추가 해당 객체를 계속 추가 [장바구니에 담겨있는 pNo개수 만큼]
					
				}
			}
		}
		return cartDto; // 다 넣었다면 반환해주면됨 장바구니에 담아져있는 객체
	}
	
	//0. 결제
	public boolean purchase(ArrayList<ProductDto> cartList) { // 결제 해당 장바구니에 담은 [번호 개수] 리스트 를 인수로 받음
		ArrayList<ProductDto> cartDto = printCart(cartList); // 이건 필 수 아님! 없어도 됨! 이줄은 없어도 돌아감!
		
		String sql = "update product set pStock = pStock - ? where pNo = ?"; //현재 pStock - [구매할 개수]를 빼주면 됨
		for(int i = 0; i < cartDto.size(); i++) {//cartDto 장바구니 리스트 사이즈 만큼 반복
			try {
				pstmt = conn.prepareStatement(sql); 
				
				pstmt.setInt(1, cartDto.get(i).getpStock()); // 해당 장바구니 리스트 정보의 구매할 개수를 넣어줌. 
				pstmt.setInt(2, cartDto.get(i).getpNo());
				
				pstmt.executeUpdate(); 
				
			}catch(SQLException e) {
				return false;
			}
		}
		return true; // 반복문이 돌고 있는데 return true를 해버리면 중간에 끝나버리니까, 다 끝나고 return!
		// 여기까지 왔다는 건 무사히 아무 에러 없이 잘 되었다는 것이므로!
	}
	
	//1. 장바구니 담기
	public int cart(int no, int inCount) {
		if(checkPNo(no)) { //이건 해당 제품 번호가 있는지 없는지 확인하는 메소드 추가한 것.  
//			String sql = "select pStock from product where pno = ?";
			String sql = "select * from product where pno = ?"; 
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, no);
				
				rs = pstmt.executeQuery();
	
				rs.next(); // 해당 열의 재고를 받아오려면 next필수!
				
				if(rs.getInt(4) < inCount) { // 사려는 개수가 재고보다 클 경우
					return rs.getInt(4); //해당 재고를 넣어준다.
				}else{ //재고가 0개일 수 있으니까 음수로 나눴음
					return -3; //장바구니에 넣을 수 있을 경우
				}
	
			}catch(SQLException e) { //DB에러
				System.err.println(e.getMessage());
				return -2;
			}
		}else { //해당 제품 번호가 없을 경우
			return -1; // 이부분은 checkPno() if문에 해당하는 부분
		}
	}
	/*-------------------------사용자 페이지e------------------------*/
	
	/*-------------------------관리자 페이지s------------------------*/
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
	/*-------------------------관리자 페이지e------------------------*/
}
