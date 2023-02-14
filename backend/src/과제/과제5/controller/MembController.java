package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Member;

public class MembController {
	//*싱글톤 : 해당 객체 공유 메모리
	private static MembController mc = new MembController();
	
	private MembController() {}
	
	public static MembController getInstance() {
		return mc; //객체 반환
	}
	
	//DB대신 ArrayList
	ArrayList<Member>memberDB = new ArrayList<>();
	
	//1. 회원 가입 처리
	public int signUp(String id, String pw, String confirmPw, String phone) {
		if(!pw.equals(confirmPw)) {
			return 1;
		}
		
		Member m = new Member(memberDB.size(), id, pw, phone);
		
		memberDB.add(m); //리스트에 해당 member객체 추가
		return 0;
	}
	
	
}
