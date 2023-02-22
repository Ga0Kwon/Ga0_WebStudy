package 과제.과제11.controller;

import java.util.ArrayList;

import 과제.과제11.model.ProductDao;
import 과제.과제11.model.ProductDto;

public class PController {
	private static PController pc = new PController();
	
	private PController() {}
	
	public static PController getInstance() {
		return pc;
	}
	
	private static ArrayList<ProductDto> cartList = new ArrayList<>();
	public static ArrayList<ProductDto> getCartInstance(){
		return cartList;
	}
	/*------------------------------사용자 페이지s------------------------*/
	//-1. 장바구니 목록 
	public ArrayList<ProductDto> printCart(){
		return ProductDao.getInstance().printCart(cartList);
	}
	
	//0. 결제
	public boolean purchase() {
		boolean result = ProductDao.getInstance().purchase(cartList);
		
		if(result) { //구매했으면 장바구니 비우기
			cartList = new ArrayList<>();
		}
		
		return result;
		
	}
	
	//1. 장바구니 담기
	public int cart(int no, int inCount) {
		if(inCount > 0) { //사려는 개수가 0보다는 커야 장바구니에 넣을 수 있음
			int result = ProductDao.getInstance().cart(no, inCount);
			
			if(result == -3) {
				ProductDto dto = new ProductDto(no, inCount);
				cartList.add(dto);
				return result;
			}else { // -2 : DB 에러 / -1 : 해당 제품이 없는 경우 / -3, -1, -2가 아닌 다른 경우 : 사려는 금액보다 재고부족
				return result;
			}
		}else {
			return -4; // 0보다 작은 것을 넣음
		}
	}
	
	/*------------------------------사용자 페이지e------------------------*/
	
	/*------------------------------관리자 페이지s------------------------*/
	//1. 제품 등록
	public boolean enrollProduct(String name, int price, int stock) {
		ProductDto dto = new ProductDto(name, price, stock);
		
		boolean result = ProductDao.getInstance().enrollProduct(dto);
		 
		return result;
	}
	
	//2. 모든 제품 출력
	public ArrayList<ProductDto> printProduct(){
		return ProductDao.getInstance().printProduct();
	}
	
	//3. 제품 이름, 가격 변경
	public int updateProductInfo(int pno, String name, int price) {
		int result = ProductDao.getInstance().updateProductInfo(pno, name, price);
		return result;
	}
	
	//4. 제품 재고 변경
	public int updateProductStock(int pno, int stock) {
		return ProductDao.getInstance().updateProductStock(pno, stock);
	}
	
	//5. 제품 삭제
	public int deleteProduct(int pno) {
		return ProductDao.getInstance().deleteProduct(pno);
	}
	/*------------------------------관리자 페이지e------------------------*/
}
