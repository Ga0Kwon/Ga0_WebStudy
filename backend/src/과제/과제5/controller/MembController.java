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
	
	//로그인한 Member 객체를 담기 위해
	private Member logSeasion = null;

	public Member getLogSeasion() {
		return logSeasion;
	}
	
	//1. 회원 가입 처리
	public boolean signUp(String id, String pw, String confirmPw, String phone) {
		if(!pw.equals(confirmPw)) { //비밀번호가 같지않으면
			return false;
		}
		/*회원 삭제 기능은 없기 때문에, memberDB사이즈를 이용해서 식별한다.*/
		Member member = new Member(memberDB.size(), id, pw, phone);
		
		memberDB.add(member); //리스트에 해당 member객체 추가
		return true; 
	}
	
	//2. 로그인 처리
	public int logIn(String id, String pw) {
		for(int i = 0; i < memberDB.size(); i++) {
			if(memberDB.get(i).getId().equals(id)) { //아이디가 존재하고
				if(memberDB.get(i).getPw().equals(pw)) { //해당 아이디의 비밀번호와 맞다면
					logSeasion = memberDB.get(i); //필드 logSeasion에 해당 객체를 저장
				}else { //비밀번호가 틀렸을 경우
					return -1; //인덱스는 0부터 시작하기 때문에 나올 수 없는 숫자는 0이하부터
				}
			}
		}
		return -2; //여기까지 왔다느 넋은 없는 아이디라는 뜻
	}
	
	
	
}
