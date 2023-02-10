package 과제.과제4.model;

/*데이터 모델링*/
public class Member {
	//필드
	public String id; 
	public String password;
	public String name;
	public String phone;
	
	// 기본 생성자
	public Member() {};
	
	//인수를 가지고 있는 생성자
	public Member(String id, String password, String name, String phone) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	
}	
