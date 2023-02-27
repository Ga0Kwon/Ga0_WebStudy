package Day19.Ex5;

public class Movie extends Thread{
	
	public boolean play = false;
	@Override
	public void run() {

		while(play) {
			System.out.println("영화 재생중");
			
			try {
				Thread.sleep(1000);
				
			}catch (Exception e) {
				
			}
		}
	}
}
