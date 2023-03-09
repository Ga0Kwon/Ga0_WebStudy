package model.dao;

import java.util.ArrayList;

import model.dto.MemberDto;

public class MemberDao extends Dao {
	
	//싱글톤
	private static MemberDao dao = new MemberDao();
	private MemberDao() { }
	public static MemberDao getInstance() {return dao;}
	
	//1. 회원 가입
	public boolean signup(MemberDto dto) {
		String sql = "insert into member(mid, mpwd, memail, mimg) values (?, ?, ?, ?)";
			try {
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, dto.getMid());
				ps.setString(2, dto.getMpwd());
				ps.setString(3, dto.getMemail());
				ps.setString(4, dto.getMimg());
				
				ps.executeUpdate();
				
				return true; //회원 가입 성공!
			}catch (Exception e) {
				System.err.println(e.getMessage());
				return false; //DB에러
			}
		}
	
	//2. 모든 회원 호출 [ 관리자 기준 인수 : X / 반환 : 모든 회원들의 dto]
	public ArrayList<MemberDto> getMemberList(){
		ArrayList<MemberDto> memberDB = new ArrayList<>(); //모든 회원들의 리스트 선언
		
		String sql = "select * from member"; //1. SQL명령어 작성
		
		try {
			ps = con.prepareStatement(sql); //2. 연결된 con에 SQL 대입해서 ps
			rs = ps.executeQuery(); //3. SQL 실행 후 결과 RS 담고
			
			while(rs.next()) { //4. rs.next() : 다음 레코드[t/f]
				//5-2/ rs.get타입(필드 순서 번호)
				MemberDto dto = new MemberDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				memberDB.add(dto); //6. dto ---> 리스트 담기 
			}
			return memberDB; //7. 리스트 반환
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//3. 아이디 중복 체크
	public boolean idCheck(String mid) {
		String sql = "select * from member where mid = '" +mid+"'";
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) { //중복 아이디가 있을 경우
				return true;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		return false; // 중복 아이디가 없을 경우 
	}
	
	//4. 로그인
	public boolean login(String mid, String mpwd) {
		String sql = "select * from member where mid = ? and mpwd = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mpwd);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false; //DB 오류이거나 로그인 정보 조회 결과가 없을 경우
	}
	
	//5. 로그인한 멤버의 정보 호출 [ 비밀번호 빼고 ]
	public MemberDto getMember(String mid) {
		String sql = "select * from member where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				MemberDto dto = new MemberDto(
					rs.getInt(1),
					rs.getString(2),
					null, //비밀번호 빼고
					rs.getString(4),
					rs.getString(5));
				return dto;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; //DB에러 or 조회 결과가 없는
	}
}
