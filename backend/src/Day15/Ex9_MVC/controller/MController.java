package Day15.Ex9_MVC.controller;

import java.util.ArrayList;

import Day15.Ex9_MVC.model.MemberDao;
import Day15.Ex9_MVC.model.MemberDto;

public class MController {
	//* 싱글톤
	private static MController bc = new MController();
	private MController() {};
	public static MController getInstance() {
		return bc;
	}
	private ArrayList<MemberDto> memberDB = new ArrayList<>();
	//회원가입
	public boolean signup(String id, String pw) {
		//객체화
		MemberDto dto = new MemberDto(id, pw);
		
		//해당 객체를 DB에 저장 [DAO 호출] 하고 실행 결과 저장 
		boolean result = MemberDao.getInstance().signup(dto);
		
		//실행 결과 반환
		return result;
		
	}
	//출력
	public ArrayList<MemberDto> list(){
		//모든 회원을 호출하는 DAO메소드 호출해서 결과 얻기
		return MemberDao.getInstance().list();
	}
	
	//비밀번호 변경
	public boolean changePw(int mno, String mpw) {
		boolean result = MemberDao.getInstance().changePw(mno, mpw);
		return result;
	}
	
	//회원 삭제
	public boolean delete(int mno) {
		boolean result = MemberDao.getInstance().delete(mno);
		return result;
	}
	
	//로그인
	public int logIn(String id, String pw) {
		//객체화
		MemberDto dto = new MemberDto(id, pw);
		
		int result = MemberDao.getInstance().login(dto);;
		
		return result;
	}
	
}
