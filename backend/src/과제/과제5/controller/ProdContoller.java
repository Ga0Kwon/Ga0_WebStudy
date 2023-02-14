package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Product;

public class ProdContoller {
	//공유메모리
	private ArrayList<Product> productDB = new ArrayList<>();
	private static int pno = 0;
	
	//*싱글톤
	private static ProdContoller pc = new ProdContoller();
	private ProdContoller() {}
	public static ProdContoller getInstance() {
		return pc;
	}
	/*mno 찾기 함수*/
	@SuppressWarnings("unlikely-arg-type")
	public int findMno() {
		/*현재 로그인한 회원의 mno의 값을 알아야한다.
		  -> 그렇다면 memberDB 사이즈만큼 반복문을 돌면서 아이디가 같은 객체를 찾고,
		  찾았다면, 해당 인덱스의 객체의 mno값을 반환해야한다. [아이디가 절대 같지 않다는 가정하에]
		  회원가입에 아이디 중복 유효성 검사한다면 문제될 것이 없음!*/
		for(int i = 0; i < MembController.getInstance().memberDB.size(); i++) {
			if(MembController.getInstance().getLogSeasion().equals(MembController.getInstance().memberDB.get(i).getId())) {
				return MembController.getInstance().memberDB.get(i).getMno();
			}
		}
		return -1; //찾지 못했을 경우
	}
	
	/*제품 등록*/
	public int registerProduct(String prodName, int prodPrice, String prodContent) {
		
		
		if(MembController.getInstance().getLogSeasion() == null) {
			return -1; //로그인이 안된 상태
		}
		
		int mno = findMno();
		
		if(mno >= 0) {
			Product product = new Product(findMno(), pno, prodName, prodPrice, prodContent, false);
			productDB.add(product);
			/*제품 등록을 삭제할 경우 productDB의 길이도 줄어든다. 즉, 고유값에 대한 문제가 생길 수 있다. 따라서 전역필드로 pno를 등록할때마다 증가시켜 고유값으로 만들어줌*/
			pno++; 
			return product.getPno(); //제품 등록 성공시
		}
		
		return -2; //해당 멤버 pk를 찾지 못했을 경우
	}
	
	
}
