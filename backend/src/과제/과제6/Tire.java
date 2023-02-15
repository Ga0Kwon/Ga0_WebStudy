package 과제.과제6;
public class Tire { //Tire 클래스
	// 1. 필드
	public int maxRotation;   //접근제한자가 public(어디든 사용가능)인 정수형(int)필드 maxRotation
	public int accumulatedRotation; //접근제한자가 public(어디든 사용가능)인 정수형(int)필드 accumulatedRotation
	public String location; //접근제한자가 public(어디든 사용가능)인 문자열형(String)필드 location
	
	//2. 생성자
	public Tire(int maxRotation, String location) { //매개변수를 2개(maxRotation와 location)받는 생성자 Tire
		this.maxRotation = maxRotation;  //현재 Tire 클래스의 필드인 maxRotation에 인자(매개변수)로 받은 maxRotation을 대입
		this.location = location; //현재 Tire 클래스의 필드인 location에 인자(매개변수)로 받은 location을 대입
	}
	//3. 메소드
	//함수 선언
	public boolean roll() { //접근제한자가 public(어느곳이든 가능)인 boolean(true or false)형을 반환하는 메소드 roll() 
		++accumulatedRotation; //전위증감식으로 현재 클래스의 필드에 있는 accumulatedRotation을 1증가시킨다.
		
		if( accumulatedRotation < maxRotation ) { //만약 증가시킨 accumulatedRotation이 maxRotation보다 작다면
			System.out.println( location + " Tire 수명 : "  //현재 클래스의 location과 Tire의 수명(maxRotation에서 accumulatedRotation을 뺀값)을 출력한다.
				+ (maxRotation-accumulatedRotation) + "회");
			return true; //그리고 true를 반환
		}else {//만약 증가시킨 accumulatedRotation이 maxRotation보다 크거나 같다면
			System.out.println("*** " + location +" Tire 펑크 ***"); //현재 클래스의 location과 타이어펑크 문구를 출력하고 
			return false; //false를 반환한다.
		}
	}
}
