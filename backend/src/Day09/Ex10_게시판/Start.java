package Day09.Ex10_게시판;

import Day09.Ex10_게시판.view.Front;

/*
  Ex10_게시판 페이지
  	controller 패키지
  		Bcontoller.java
	model 패키지
		Board.java
	view 패키지
		Front.java
	Start.java
		- 1. Start[main함수] 클래스가 front 클래스 호출
		- 2. Front 클래스에서 사용자로부터 입*출력 받기
		- 3. Bcontoller 클래스에서 Front로 부터 전달받은 데이터를 처리/로직
		- 4. Board 클래스에서 게시물 모델링
  
 */

public class Start {//class s
	public static void main(String[] args) {//main s
//		Front front = new Front(); // 안됨
		Front.getInstance().index();
		
	}//main e
}//class e
