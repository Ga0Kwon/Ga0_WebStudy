package practice.Day03;

public class BoardDto {
	private int bno;
	private String bcontent;
	private String bdate;
	private String bwriter;
	
	
	public BoardDto() {
		super();
	}



	public BoardDto(int bno, String bcontent, String bdate, String bwriter) {
		super();
		this.bno = bno;
		this.bcontent = bcontent;
		this.bdate = bdate;
		this.bwriter = bwriter;
	}



	public int getBno() {
		return bno;
	}


	public void setBno(int bno) {
		this.bno = bno;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}



	public String getBwriter() {
		return bwriter;
	}



	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

}
