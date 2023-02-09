package Day07.Ex5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class 실행 {
	public static void main(String[] args) {
		// * 객체 3개 만들기
		Member member1 = new Member();
		member1.id = "qwe";
		member1.password = "qwe";
		
		Member member2 = new Member();
		member2.id = "asd";
		member2.password = "asd";
		
		Member member3 = new Member();
		member3.id = "zxc";
		member3.password = "zxc";
		
		//1. 배열 [프로그래밍 언어 문법 : C, java, js, python] => 고정길이
		Member[] memberList1 = new Member[3];
		memberList1[0] = member1;
		memberList1[1] = member2;
		memberList1[2] = member3;
		
		System.out.println(Arrays.toString(memberList1));
		
		memberList1[1] = null; //=>  '1' 인덱스 삭제, 고정
		System.out.println(Arrays.toString(memberList1)); // 3개 => 3개인데 해당 값에 null
		
		//2. 컬렉션[수집] 프레임워크 [미리 만들어진 클래스]
		//< > : 제네릭 => 가변 길이
		ArrayList<Member> memberList2 = new ArrayList<>();
		/*자바스크립트의 push처럼 사용하는 add*/
		memberList2.add(member1);
		memberList2.add(member2);
		memberList2.add(member3);
		
		System.out.println(memberList2);
		
		memberList2.remove(1); // '1' 인덱스 삭제, 가변
		System.out.println(memberList2); // => 3개 => 2개로
		
		for(int i = 0; i < memberList1.length; i++) {
			if(memberList1[i] != null) {
				System.out.println(memberList1[i].id);
			}
		}
		
		for(int i = 0; i < memberList2.size(); i++) {
			System.out.println(memberList2.get(i));
		}
		
		
	}
}

/*
  라이브러리 : 도구
  프레임워크 : 뼈대 [ 프로그램 ]
  
  
 */