package Day07.Ex6;

import java.util.ArrayList;
import java.util.Scanner;

import Day07.Ex4.Member;

public class Ex6_회원시스템_컬렉션프레임워크 {//class s
	public static void main(String[] args) {//main s
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Member>memberList = new ArrayList<>();
		//ArrayList : 리스트 선언 사용되는 클래스
		//<클래스명> : 리스트 안에 들어갈 항목의 클래스[자료형/타입]
		
		while(true) {
			//컬렉션 프레임워크에서 foreach를 제공 // => : 자바스크립트  vs -> : 자바
			/*
			 * memberList.forEach((o) -> { System.out.println(o); });
			 */ 
			/*배열명.length : 배열내 길이 [고정 길이]
			  리스트명.size() : 리스트 내 요소들의 개수 [가변길이]*/
			for(int i = 0; i < memberList.size(); i++) { //length대신 size()를 써야함.
				System.out.println(i + "\t" + memberList.get(i).name + "\t" + memberList.get(i).phone);
			}
			System.out.print("1. 회원 등록  2. 회원 삭제 : ");
			int choice= scanner.nextInt();
			
			if(choice == 1) {
				System.out.print("회원명 : "); String inputname = scanner.next();
				System.out.print("전화번호 : ");String inputphone = scanner.next();
				
				Member member = new Member();
				member.name = inputname; 
				member.phone = inputphone;
				
				/*add() => js의 push()*/
				memberList.add(member);
				
			}else if(choice == 2) {
				System.out.print("삭제할 번호/인덱스 : ");
				int no = scanner.nextInt();
				memberList.remove(no);
				
			}else {
				
			}
		}
	}//main e
}//class e
