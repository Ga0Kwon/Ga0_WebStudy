package 과제.과제9.interfaceExample.Ex3;

public class 인스타그램 implements 앱{
	
	public void like(String id) {
		System.out.println(id + "의 게시물을 좋아요를 눌렀습니다.");
	}
	
	@Override
	public void turnOnApp() {
		System.out.println("인스타그램을 켭니다.");
		
	}@Override
	public void turnOffApp() {
		System.out.println("인스타그램을 끕니다.");
		
	}
}
