package Day08.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

/*View 담당*/
//함수 만들때 기능 단위로 -> 함수마다 만든 사람 이름 날짜 적기!
public class Front {
	//1. 필드 [변수, 객체 , 배열]
	Scanner scanner = new Scanner(System.in); //입력객체
	
	ArrayList<Member> memberList = new ArrayList<>(); //리스트객체(Member객체를 여러개)
	
	//2. 생성자
	//3. 메소드
	
		//1) 메인 페이지 프론트 함수
	void index() {
		
		while(true) {
			print(); //회원 출력 함수.
			System.out.print("1. 회원등록 2. 회원 삭제 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) {//1. 회원등록을 선택했을시
				
				signup();
				
			}else if(choice == 2) {//2. 회원 삭제을 선택했을시 
				
				delete();
				
			}else {
				System.err.println("1번과 2번중에 선택해주세요.");
			}
		}
	}
	
		//2) 회원 등록 페이지 함수
	void signup() {
		System.out.print("회원명 : "); String name = scanner.next();
		System.out.print("전화번호 : "); String phone = scanner.next();
		
		// member 객체 생성 [생성자를 위한 객체 선언]
		Member member = new Member(name, phone);
		
		memberList.add(member);
		//* 배열 or 리스트에 객체 저장
	}
	
		//3) 회원 삭제 페이지 함수
	void delete() {
		System.out.print("삭제할 번호/인덱스 : "); int index = scanner.nextInt();
		
		memberList.remove(index);
	}
	
		//4) 회원 출력
	void print() {
		System.out.println("번호\t회원\t전화번호");
		for(int i = 0; i < memberList.size(); i ++) {
			System.out.printf("%d\t%s\t%s\n", i, memberList.get(i).name, memberList.get(i).phone);
		}
	}
}
