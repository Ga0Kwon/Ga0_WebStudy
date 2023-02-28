package Day20.gallery.model.dto;

public class CateogryDto {
	private int categoryNo;
	private String categoryName;
	

	public CateogryDto() {
		super();
	}

	public CateogryDto(int categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CateogryDto [categoryNo=" + categoryNo + ", categoryName=" + categoryName + "]";
	}
	
}
