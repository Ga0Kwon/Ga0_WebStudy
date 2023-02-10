package Day08.Ex2;

public class Korean {//class s
	//1. 필드
	String nation = "대한민국";
	String name;
	String ssn;
	
	//2. 생성자
	public Korean(){}
		
	public Korean(String name, String ssn) {
		/*this는 현재내부를 의미*/
		this.name = name;
		this.ssn = ssn;
		
	}

	@Override
	public String toString() {
		return "Korean [nation=" + nation + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
}//class e
