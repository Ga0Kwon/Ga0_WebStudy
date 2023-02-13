package Day09.Ex4;

/*
  오버라디이딩 : 이미 존재하는 메소드를 재정의[리모델링] 
 
 	vs.
 	
  오버로딩 : 이름은 같되 매개변수의 타입, 개수, 순서가 다르게 여러개 선언
  		생성자, 메소드 사용
  
 */
public class 계산기 {//class s
	
	//1. 정사각형 넓이 구하는 함수
	double areaRectangle(double width) {
		return width * width;
	}
	
	/*매개변수의 타입, 개수, 순서 중에 다르게 선언된 것이 없다면 에러가난다. 
	  -> 메소드 이름이 같기 때문에 구별이 불가능*/
	
	//2. 직사각형 넓이 구하는 함수
	double areaRectangle(double width1, double heigth) {
		return width1*heigth;
	}

}//class e
