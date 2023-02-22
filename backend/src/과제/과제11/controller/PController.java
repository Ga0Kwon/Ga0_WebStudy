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
}
