package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Member;

/*member 컨트롤*/
public class MController {
	ArrayList<Member> memberDB = new ArrayList<>();
	
	//* 싱글톤
	private static MController mc = new MController();
	private MController() {}
	
	public static MController getInstance() {
		return mc;
	}
	
	/*Member arrayList를 반환하는 함수*/
	public ArrayList<Member> getList(){
		return memberDB;
	}
	
	/*로그인한 객체 저장*/
	private Member logSeasion = null;
	
	public Member getLogSeasion() {
		return logSeasion;
	}
	
	/*로그인 처리*/
	public int logIn(String id, String pw) {
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).id.equals(id)) { //아이디가 존재하고
				if(memberDB.get(i).pw.equals(pw)) { //패스워드가 같다면
					logSeasion = memberDB.get(i); //해당 멤버 객체를 logSeasion에 대입
					return i;
				}
				return -1; //비밀번호가 틀릴 경우
			}
		}
		return -2; //해당 아이디가 없을 경우
	}
	
	/*아이디 찾기 처리*/
	public String findId(String name, String phone) {
		for(Member member : memberDB) {
			if(member.name.equals(name) && member.phone.equals(phone)) {
				return member.id; //해당 이름과 전화번호가 일치하는 계정을 찾으면 id반환
			}
		}
		return null; //못찾으면 nulls
	}
	
	/*비밀번호 찾기 처리*/
	public String findPw(String id, String phone) {
		for(Member member : memberDB) {
			if(member.id.equals(id) && member.phone.equals(phone)) {
				return member.pw;
			}
		}
		return null;
	}
	
	/*로그아웃*/
	public boolean logOut() {
		logSeasion = null; //필드에 저장된 로그인 성공한 회원 객체 지우기 [null 대입하면 GC가 메모리 자동 제거]
		return true;
	}
}
