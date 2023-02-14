package 과제.과제5.model;

public class Product {
	//1. 필드
	private int mno; //작성한 사람
	
	private int pno; //제품 고유 번호
	
	private String prodName; //제품이름
	private String prodPrice; //제품 가격
	private String prodContent; //제품 내용
	private String prodState; //제품 상태
	
	public String getProdName() {
		return prodName;
	}
	
	//2. 생성자
	public Product() {}

	public Product(int mno, int pno, String prodName, String prodPrice, String prodContent, String prodState) {
		this.mno = mno;
		this.pno = pno;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodContent = prodContent;
		this.prodState = prodState;
	}
	
	//3. 메소드
	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdContent() {
		return prodContent;
	}

	public void setProdContent(String prodContent) {
		this.prodContent = prodContent;
	}

	public String getProdState() {
		return prodState;
	}

	public void setProdState(String prodState) {
		this.prodState = prodState;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	
	
		
	
}
