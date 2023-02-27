package Day19.Ex1;

import java.awt.Toolkit;

//규모가 크면 interface가 나음.
public class Sound2 implements Runnable {
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		for(int i =0; i< 5; i++) {
			toolkit.beep();
			
			try {
				Thread.sleep(500);
				
			}catch (Exception e) {}
		}// for ends
		 
	} // run() end
}
