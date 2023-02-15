package Day11.Ex7_타입변환;

import java.util.ArrayList;

import Day11.Ex6.HankookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {//class s
	public static void main(String[] args) {//main s
		
		//*
		Tire tire = new Tire();
		KumhoTire kumhoTire = new KumhoTire();
		HankookTire hankookTire = new HankookTire();
		
		//1. 참조타입의 자동타입 변환
		Tire temp1 = tire;
		Tire temp2 = kumhoTire;
		Tire temp3 = hankookTire;
		Object temp4 = temp3; //올라가고 올라가고 올라가다보면 맨 상위층애 Object
		
		//2. 강제타입 변환
		KumhoTire kumhoTire2 = (KumhoTire)tire;
		HankookTire hankookTire2 = (HankookTire)tire;
		Tire tire2 = (Tire)temp4;
		
		//3. 매개변수, 리턴타입
		함수2(hankookTire2); //자식은 부모가 될 수 있음.
		
		Tire result = 함수1(kumhoTire2);
		
		KumhoTire result2 = (KumhoTire)((KumhoTire)temp2);
		
		//4. 배열, ArrayList
		ArrayList<KumhoTire>kumhoList = new ArrayList<>();
		kumhoList.add(kumhoTire);
//		kumhoList.add(hankookTire); //x
//		kumhoList.add(tire); //x
		
		//---------------------------------------------->
		ArrayList<Tire> tireList = new ArrayList<>();
		tireList.add(kumhoTire2);
		tireList.add(hankookTire2);
		tireList.add(tire);
		
		
	}//main e
	
	public static HankookTire 함수2(Tire tire) {
		return new HankookTire();
	}
	
	public static KumhoTire 함수1(Tire tire) {
		return new KumhoTire();
	}
	
	public static Tire 함수3(KumhoTire kumhoTire) {
		return new Tire();
	}
}//class e
