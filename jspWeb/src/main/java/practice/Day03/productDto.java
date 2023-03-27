package practice.Day03;

public class productDto {
	//필드
	private int pno;
	private String productName;
	private int productPrice;
	
	//생성자
	public productDto(int pno, String productName, int productPrice) {
		super();
		this.pno = pno;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public productDto() {
		super();
	}

	//메소드
	public int getPno() {
		return pno;
	}


	public void setPno(int pno) {
		this.pno = pno;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}