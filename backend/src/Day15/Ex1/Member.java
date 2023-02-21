package Day15.Ex1;

public class Member {
	//1. 필드
	public String id;
	
	//2. 생성자
	public Member(String id) {
		this.id = id;
	}
	
	//3. 메소드
	//주소번지 비교가 아닌 내부 값 비교로 재정의[오버라이딩]
	
	@Override
	public boolean equals(Object obj) {
		//1.
		
//		if(obj instanceof Member target) { //멤버의 타입인지 확인
//			//부모객체 instanceof 자식클래스 변환객체명
//			// obj -> target
//			// Member target = (Member)obj;
//			if(id.equals(target.id)) {
//				return true;
//			}
//		}
		
		//2.
		if(obj instanceof Member) {
			Member target = (Member)obj;
			if(this.id.equals(target.id)) {
				return true;
			}
		}
		return false;
	}
}
