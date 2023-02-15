package 과제.과제6;

public class 실행 { //실행 클래스
	
	public static void main(String[] args) { //쓰레드를 가진 main() => 즉, 실질적인 실행 부분!
		
		Car car = new Car();  //Car 객체를 생성한다.
		
		for( int i = 1 ; i<=10 ;i++ ) { //반복을 1~10까지 총 10번 돈다.[run()메소드를 10번 출력]
			//Car 객체에 있는 멤버 run()메소드를 호출하여 반환값을 받아온다.
			int result =  car.run(); 
			
			/* 여기서 중요한 것은 자동 타입 변환! 캐스팅이 따로 필요없다!
			  => 부모[상위]였던 클래스 Tire이 기본으로 자동차에 설치되어있던 타이어고, 만약 타이어가 펑크나면 교체해주어야한다.
			 여기서 교체하려고 하는 것이 앞쪽엔 HankookTire 뒤쪽엔 KumhoTire인데,
			 이 두 클래스[객체]는 [HankookTire 와 KumhoTire]이고, 이들은 Tire에게 상속받는 자식[하위] 클래스이므로,
			 	"자식은 부모를 선택할 수 있지만[될 수 있지만], 부모는 자식이 될 수 없다."라는 규칙(?)으로 별도의 캐스팅 없이
			 car의 생성한 객체를 넣은 Tire 타입 필드에 하위 클래스[객체] 타입을 대입할 수 있다.
			*/
			
			
			/*------------앞왼쪽과 앞 오른족의 타이어는 HankookTire의 객체로 교체한다.---------------*/
			
			// result가 1인 경우 앞왼쪽 타이어가 펑크난 경우, [기본으로 장착되어있던 상위 클래스였던 Tire이 펑크나면]
			// HankookTire로 교체해준다. [car의 앞왼쪽 타이어를 최대회전수가 15인 한국타이어로 교체[객체 생성 후 대입]]
			if( result == 1 ) car.frontLeftTire = new HankookTire( 15 , "앞왼쪽" );
			
			// result가 2인 경우 앞오른쪽 타이어가 펑크난 경우, [기본으로 장착되어있던 상위 클래스였던 Tire이 펑크나면]
			// HankookTire로 교체해준다. [car의 앞오른쪽 타이어를 최대회전수가 13인 한국타이어로 교체[객체 생성 후 대입]]
			if( result == 2 ) car.frontRightTire = new HankookTire( 13 , "앞오른쪽" );
			
			/*-----------뒤 왼쪽과 뒤 오른쪽의 타이어는 KumhoTire의 객체로 교체한다-----------------*/
			
			// result가 3인 경우 뒤왼쪽 타이어가 펑크난 경우, [기본으로 장착되어있던 상위 클래스였던 Tire이 펑크나면]
			// KumhoTire로 교체해준다. [car의 뒤왼쪽 타이어를 최대회전수가 14인 금호타이어로 교체[객체 생성 후 대입]]
			if( result == 3 ) car.backLeftTire = new KumhoTire( 14 , "뒤왼쪽" );
			
			// result가 4인 경우 뒤오른쪽 타이어가 펑크난 경우, [기본으로 장착되어있던 상위 클래스였던 Tire이 펑크나면]
			// KumhoTire로 교체해준다. [car의 뒤오른쪽 타이어를 최대회전수가 17인 금호타이어로 교체[객체 생성 후 대입]]
			if( result == 4 ) car.backRightTire = new KumhoTire( 17 , "뒤오른쪽" );
			
		} // for 
		
	}
}
