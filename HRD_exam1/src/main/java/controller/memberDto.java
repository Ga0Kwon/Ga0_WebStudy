package controller;

public class memberDto {
	private int custno;
    private String custname;
    private String phone;
    private String address;
    private String joindate;
    private String grade;
    private int city;
    
    
    //추가 필드
    private int sum;
    
    
    
	public memberDto() {
		super();
	}
	
	
	public memberDto(int custno, String custname, String phone, String address, String joindate, String grade,
			int city) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}




	public memberDto(String custname, String phone, String address, String joindate, String grade, int city) {
		super();
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.joindate = joindate;
		this.grade = grade;
		this.city = city;
	}
	
	//매출 통계 생성자
	public memberDto(int custno, String custname, String grade, int sum) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.sum = sum;
	}

	//수정용
	
	public memberDto(String custname, String phone, String address, String grade, int city) {
		super();
		this.custname = custname;
		this.phone = phone;
		this.address = address;
		this.grade = grade;
		this.city = city;
	}
	
	public int getCustno() {
		return custno;
	}




	public void setCustno(int custno) {
		this.custno = custno;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getJoindate() {
		return joindate;
	}
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}


	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "memberDto [custno=" + custno + ", custname=" + custname + ", phone=" + phone + ", address=" + address
				+ ", joindate=" + joindate + ", grade=" + grade + ", city=" + city + "]";
	}
    
    
    
}
