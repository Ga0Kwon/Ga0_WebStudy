package 과제.과제9.interfaceExample.Ex3;

public class 카카오톡 implements 앱{	
	
	public void chat(String name) {
		System.out.println(name + "채팅창에 들어왓씁니다.");
		System.out.println("타이핑치는 중...");
	}
	
	
	@Override
	public void turnOnApp() {
		System.out.println("카카오톡을 켭니다.");
		
	}@Override
	public void turnOffApp() {
		System.out.println("카카오톡을 끕니다.");
		
	}
}
