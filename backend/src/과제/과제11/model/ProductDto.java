package 과제.과제11.model;

public class ProductDto {
	//1. 필드
	private int pNo; //제품 번호
	private String pName; // 제품 이름
	private int pPrice; //제품 가격
	private int pStock; //제품 재고
	
	//2. 생성자
	public ProductDto(int pNo, String pName, int pPrice, int pStock) {
		this.pNo = pNo;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pStock = pStock;
	}
	
	

	public ProductDto(String pName, int pPrice, int pStock) {
		this.pName = pName;
		this.pPrice = pPrice;
		this.pStock = pStock;
	}

	/*cart에 넣기 위한 생성자*/
	

	public ProductDto() {}

	public ProductDto(int pNo, int pStock) {
		this.pNo = pNo;
		this.pStock = pStock;
	}



	//3. 메소드
	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}

	@Override
	public String toString() {
		return "ProductDto [pNo=" + pNo + ", pName=" + pName + ", pPrice=" + pPrice + ", pStock=" + pStock + "]";
	}
	
	
}
