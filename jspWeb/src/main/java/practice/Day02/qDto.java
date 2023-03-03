package practice.Day02;

public class qDto {
	//필드
	private String name;
	private String phoneNumber;
	private double height;
	private int age;
	private String signDate;
	private String sex;
	private boolean agree;
	private String location;
	private String introduce;

	//생성자
	public qDto() {
		super();
	}

	public qDto(String name, String phoneNumber, double height, int age, String signDate, String sex, boolean agree,
			String location, String introduce) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.height = height;
		this.age = age;
		this.signDate = signDate;
		this.sex = sex;
		this.agree = agree;
		this.location = location;
		this.introduce = introduce;
	}
	
	//메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public boolean isAgree() {
		return agree;
	}

	public void setAgree(boolean agree) {
		this.agree = agree;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
}
