package Day20.gallery.controller;

import Day20.gallery.model.dao.MemberDao;
import Day20.gallery.model.dto.MemberDto;

public class MemberController {
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static MemberController mc = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() {
		return mc;
	}
	
	//로그인 세션
	private int LogSeasion = -1;
	
	public int getLogInMemberNo() {
		return LogSeasion;
	}
	
	public void setLogInMemberNo(int logInSeaction) {
		this.LogSeasion = logInSeaction;
	}
	
	//회원가입 처리 [아이디 중복 체크 유효성 추가]
	public int signUp(String memberId, String memberPw, String memberName, String memberPhone) {
		//1) 유효성 검사 [글자수, 중복체크 등등]
			//1> 아이디 중복체크
		
		if(MemberDao.getInstance().checkId(memberId)) {
			return 2;
		}else {
			//2) 객체화
			MemberDto dto = new MemberDto(0 ,memberId, memberPw, memberName, memberPhone);
			//3) 회원가입 DB 처리
			boolean result = MemberDao.getInstance().signUp(dto);
			
			if(result) {
				return 1;
			}else {
				return 3;
			}
		}
	}
	
	//로그인 처리
	public String login(String memberId, String memberPw) {
		int loginResult =  MemberDao.getInstance().logIn(memberId, memberPw);
		
		if(loginResult == -1) {
			return null;
		}else if(loginResult == -2) {
			return "ERROR";
		}else {
			LogSeasion = loginResult;
			return MemberDao.getInstance().findMemberName(loginResult);
		}
	}
}
