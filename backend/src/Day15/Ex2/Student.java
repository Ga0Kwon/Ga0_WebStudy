package Day15.Ex2;

public class Student {
	private int no;
	private String name;

	public Student(int no, String name) {
		this.no = no;
		this.name = name;
	}

	public int getNo() { return no; }
	public String getName() { return name; }
	
	@Override
	public int hashCode() {
		/*리터릴 값은 주소 [메모리]를 공유해서 문자열 데이터의 값이 같으면
		 * hashcode()이 같다는 것을 생각하면 가능*/
		int hashCode = no + name.hashCode();
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		//1.
		if(obj instanceof Student) {
			Student target = (Student) obj;
			if(no == target.getNo() && name.equals(target.getName())) {
				return true;
			}
		}
		
		//2.
//		if(obj instanceof Student target) {
//			if(no == target.getNo() && name.equals(target.getName())) {
//				return true;
//			}
//		}
		return false;
	}
}