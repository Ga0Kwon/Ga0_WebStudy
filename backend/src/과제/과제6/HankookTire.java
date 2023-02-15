package 과제.과제6;

public class HankookTire extends Tire { //Tire객체를 상속받는 HankookTire
	/*필드가 없는 것을 보아하니, 필드는 Tire에 있는 필드만을 사용한다.*/
	
	/*생성자*/
	public HankookTire(int maxRotation, String location) { //인수(매개변수) 2개(maxRotation, location)를 받는 HankookTire 생성자
		super(maxRotation, location); //상속받은 Tire의 매개변수 2개 받는 생성자를 호출한다.
		/*
		  	[Tire.java] 중
			  	public Tire(int maxRotation, String location) { 
					this.maxRotation = maxRotation; 
					this.location = location;
				}
			이 코드가 실행될 것.
		 */
	}
	/*오버라이딩 => 상속받은 Tire객체에 있는 메소드 roll()을 리모델링한다.*/
	
	@Override
	public boolean roll() { //boolean형을 반환하는 roll()함수
		++accumulatedRotation;	//전위증감식으로 현재 클래스의 필드[Tire => 상속받았으니 보이진 않지만 HankookTire에도 존재]에 있는 accumulatedRotation을 1증가시킨다.
		if( accumulatedRotation < maxRotation ) {//만약 증가시킨 accumulatedRotation이 maxRotation보다 작다면
			System.out.println( location + " HankookTire 수명 : " 
				+ (maxRotation-accumulatedRotation) + "회"); //현재 클래스의 location과 HankookTire의 수명(maxRotation에서 accumulatedRotation을 뺀값)을 출력한다.
			return true; //그리고 true를 반환
		}else {//만약 증가시킨 accumulatedRotation이 maxRotation보다 크거나 같다면
			System.out.println("*** " + location +" HankookTire 펑크 ***"); //현재 클래스의 location과 HankookTire 펑크 문구를 출력하고 
			return false;  //false를 반환한다.
		}
	}
	
	
}
