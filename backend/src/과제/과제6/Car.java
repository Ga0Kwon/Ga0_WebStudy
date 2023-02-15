package 과제.과제6;

/*클래스 Car*/
public class Car { 
	// 1. 필드 [ 변수 , 객체 , 상수 , 배열, 리스트 등 = 메모리 ]
	/*왼쪽에 있는 매개변수 값 : maxRotation /오른쪽에 있는 매개변수 값 : location
	  필*/
	Tire frontLeftTire = new Tire( 6 , "앞왼쪽"); //Tire 객체를 생성하여 Tire 타입인 frontLeftTire을 생성한다. 매개변수값으로 6과 "앞왼쪽"이 들어감.
	Tire frontRightTire = new Tire(2 , "앞오른쪽"); //Tire 객체를 생성하여 Tire 타입인 frontRightTire을 생성한다. 매개변수값으로 2과 "앞오른쪽"이 들어감.
	Tire backLeftTire =  new Tire(3 , "뒤왼쪽");  //Tire 객체를 생성하여 Tire 타입인 backLeftTire을 생성한다. 매개변수값으로 3과 "뒤왼쪽"이 들어감.
	Tire backRightTire =  new Tire(4 , "뒤오른쪽"); //Tire 객체를 생성하여 Tire 타입인 backRightTire을 생성한다. 매개변수값으로 4과 "뒤오른쪽"이 들어감.
	
	// 3. 메소드 
	int run() { //int형을 반환하는 defalut 메소드 run()
		System.out.println("[자동차가 달립니다.]"); // 괄호안의 내용을 출력하고 줄바꿈
		
		/*tire객체.roll() 반환값이 false인 경우는 펑크가 난 경우이다.*/
		
		if( frontLeftTire.roll() == false ) { //maxRotaion[최대회전수]가 6을 가진 앞왼쪽 타이어가 펑크가 나면
			stop(); //run()메소드 밑에 있는 stop()메소드를 호출 [자동차가 멈춥니다.]
			return 1; //1을 반환
		} 
		if( frontRightTire.roll() == false ){ //maxRotaion[최대회전수]가 2을 가진 앞오른쪽 타이어가 펑크가 나면
			stop();//run()메소드 밑에 있는 stop()메소드를 호출 [자동차가 멈춥니다.] 	
			return 2; //2를 반환
		}
		if( backLeftTire.roll() == false ) 	{ //maxRotaion[최대회전수]가 3을 가진 뒤왼쪽 타이어가 펑크가 나면
			stop();//run()메소드 밑에 있는 stop()메소드를 호출 [자동차가 멈춥니다.] 	
			return 3;//3을 반환
		}
		if( backRightTire.roll() == false ) { //maxRotaion[최대회전수]가 4을 가진 뒤오른쪽 타이어가 펑크가 나면
			stop();//run()메소드 밑에 있는 stop()메소드를 호출 [자동차가 멈춥니다.] 	
			return 4; //4를 반환
		}
		
		return 0; //0을 반환 [0이 반환되었다면 아직 펑크난 타이어가 없다는 것.]
	}
	void stop() {System.out.println("[자동차가 멈춥니다.]");} //반환값이 없는 defalut 메소드 stop()
}
