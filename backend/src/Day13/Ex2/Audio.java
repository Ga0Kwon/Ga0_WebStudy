package Day13.Ex2;

public class Audio implements RemoteControl{
	private int volumn;
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다.");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		 if(volume > RemoteControl.MAX_VOLUME) {//최대볼륨보다 큰 볼륨을 요청하면
			 
			 this.volumn = RemoteControl.MAX_VOLUME; //최대볼륨을 대입
			 System.out.println("최대 볼륨보다 커질 수 없습니다. 최대볼륨으로 설정");
		 }else if(volume < RemoteControl.MIN_VOLUME) {//최소볼륨보다 작은 볼륨을 요청하면
			 
			 this.volumn = RemoteControl.MIN_VOLUME; //최소볼륨을 대입
			 System.out.println("최소 볼륨보다 작아질 수 없습니다. 최소볼륨으로 설정");
		 
		 }else { //그외
			 System.out.println("Audio의 volume을 " +volume + "로 설정합니다.");
			 this.volumn = volume; //요구한 대로 볼륨 설정
			 
		 }
		 System.out.println("현재 Audio 볼륨 : " + this.volumn);
	}
	
	
}
