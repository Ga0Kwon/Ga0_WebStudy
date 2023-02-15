package 과제.과제5.controller;

import java.util.ArrayList;
import 과제.과제5.model.Product;

public class ProdContoller {
	//공유메모리
	private ArrayList<Product> productDB = new ArrayList<>();
	
	private static int pno = 0; /*pno 초기값*/
	
	//*싱글톤
	private static ProdContoller pc = new ProdContoller();
	private ProdContoller() {}
	public static ProdContoller getInstance() {
		return pc;
	}
	
	//2. 출력할 때 사용할 예정
	public ArrayList<Product> getList(){
		return productDB;
	}
//	
//	/*mno 찾기 함수*/
//	public int findMno() {
//		/*현재 로그인한 회원의 mno의 값을 알아야한다.
//		  -> 그렇다면 memberDB 사이즈만큼 반복문을 돌면서 아이디가 같은 객체를 찾고,
//		  찾았다면, 해당 인덱스의 객체의 mno값을 반환해야한다. [아이디가 절대 같지 않다는 가정하에]
//		  회원가입에 아이디 중복 유효성 검사한다면 문제될 것이 없음!*/
//		for(int i = 0; i < MembController.getInstance().memberDB.size(); i++) {
//			if(MembController.getInstance().getLogSeasion().equals(MembController.getInstance().getList().get(i).getId())) {
//				return MembController.getInstance().memberDB.get(i).getMno();
//			}
//		}
//		return -1; //찾지 못했을 경우
//	}
	
	/*제품 등록*/
	public int registerProduct(String prodName, int prodPrice, String prodContent) {
		
		int mno = MembController.getInstance().getLogSeasion().getMno();
		System.out.println(mno);
		
		if(mno >= 0) {
			Product product = new Product(mno, pno, prodName, prodPrice, prodContent, true);
			productDB.add(product);
			/*제품 등록을 삭제할 경우 productDB의 길이도 줄어든다. 즉, 고유값에 대한 문제가 생길 수 있다. 따라서 전역필드로 pno를 등록할때마다 증가시켜 고유값으로 만들어줌*/
			pno++; 
			return product.getPno(); //제품 등록 성공시
		}
		
		return -1; //해당 멤버 pk를 찾지 못했을 경우
	}
	/*제품 삭제*/
	public boolean deleteProduct(int index) {
		/*따로 유효성 검사가 필요없는 이유 : 해당 제품을 등록한 사람이랑 현재 로그인한 사람의 mno가 같을 경우만 보여지는 화면에서왔기 때문*/
		int prev = getList().size(); //삭제전 prodDB 사이즈
		
		getList().remove(index);
		
		if(!(prev > getList().size())) { //삭제전 사이즈보다 현재 사이즈가 작지 않으면 삭제가 되지 않은 것
			return false;
		}
		
		return true; //if문을 빠져나왔다면 삭제가 성공적으로 된 것임으로 true
		
	}
	
}
