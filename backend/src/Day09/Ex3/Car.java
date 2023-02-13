package Day09.Ex3;

/*
  return : 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아감
  
  
 */
public class Car {//class s
	//1. 필드
	int gas;
	
	//2. 생성자
	Car(){}
	
	Car(int gas){this.gas = gas;}
	
	//3. 메소드
		//1) 리턴가입x 인수o (int형 매개변수)
	void setGas(int gas) {
		this.gas = gas;
	}
	
		//2) 리턴타입O(boolean) 인수X
	boolean isLetfGas() {
		if(gas == 0) {
			System.out.println("Gas가 없습니다.");
			return false;
		}
		System.out.println("Gas가 있습니다.");
		return true;
	
	}
	
		//3) 리턴타입X 인수 x
	void run() { //자동차 달리는[gas 0일 때까지] 함수
		while(true) { //무한루프 [종료 조건 : gas 0이면 return]
			if(gas > 0) {
				System.out.println("달립니다. (Gas 잔량 : " + gas + " )");
				gas--;
			}else {
				System.out.println("멈춥니다. (Gas 잔량 : " + gas + " )");
				return; //함수 종료 [while 종료]
			}
		}
	}
}//class e
