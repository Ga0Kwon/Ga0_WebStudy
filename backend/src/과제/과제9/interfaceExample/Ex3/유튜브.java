package 과제.과제9.interfaceExample.Ex3;

public class 유튜브 implements 앱{
	
	public void video(String title) {
		System.out.println(title + "영상 시청합니다.");
		System.out.println("영상 시청중...");
	}
	
	@Override
	public void turnOnApp() {
		System.out.println("유튜브를 켭니다.");
		
	}@Override
	public void turnOffApp() {
		System.out.println("유튜브를 끕니다.");
		
	}
}
