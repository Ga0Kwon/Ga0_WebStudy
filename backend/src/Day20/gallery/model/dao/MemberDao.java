package Day20.gallery.model.dao;

import java.sql.SQLException;

import Day20.gallery.model.dto.MemberDto;

public class MemberDao extends Dao{
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return dao;
	}
	
	// 기능 메소드
	
	// 아이디 중복 체크
	public boolean checkId(String memberId) {
		String sql = "select * from member where member_id = ? ";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memberId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) { //해당 아이디가 있으면
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			System.err.println(e.getMessage());
			return true;
		}
	}
	
	// 회원 가입
	public boolean signUp(MemberDto dto) {
		String sql = "insert into member(member_id, member_pw, member_name, member_phone) values (?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getMemberId());
			ps.setString(2, dto.getMemberPw());
			ps.setString(3, dto.getMemberName());
			ps.setString(4, dto.getMemberPhone());
			
			ps.executeUpdate();
			return true;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//로그인 [ 반환 : 로그인 회원번호 반환]
		// - 로그인[로그인 되어 있는 동안 저장되는] 세션 : 1. 회원 번호 2. loginDto[회원 번호, 포인트, 등급]
	public int logIn(String memberId, String memberPw) {
		String sql = "select * from member where member_id = ? and member_pw = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memberId);
			ps.setString(2, memberPw);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}else {
				return -1;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return -2;
		}
	}
	
	//회원 번호로 해당 회원의 이름 받아오기
	public String findMemberName(int memberNo) {
		String sql = "select * from member where member_no = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, memberNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(4);
			}else {
				return null;
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return "ERROR";
		}
	}
}
