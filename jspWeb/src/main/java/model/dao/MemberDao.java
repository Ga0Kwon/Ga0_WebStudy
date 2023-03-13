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
	
	//5. 로그인한 멤버의 정보 + 보유 포인트 호출 [ 비밀번호 빼고 ]
	public MemberDto getMember(String mid) {
		String sql = "select m.mno, m.mid, m.mimg, m.memail, sum(p.mpamount) as mpoint"
				+ "		from member m, mpoint p"
				+ "    	where m.mno = p.mno and m.mid = ?;";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			
			rs = ps.executeQuery();
		
			/*정상이든 아니든 값이 없을 경우 null이 포함된 객체를 가져오기 때문에 로그인이 js에서 null님이 뜨게 됨.
			 * 	-> join을 했을 때 null이 포함된 객체를 가져온다. [next가 한번 무조건 돌게 된다.]*/
			if(rs.next()) {
				//결과 레코드 : mno, mid, mimg, memal, mpoint
				MemberDto dto = new MemberDto(
					rs.getInt(1),
					rs.getString(2),
					null, //비밀번호 빼고
					rs.getString(3),
					rs.getString(4));
				
				dto.setMpoint(rs.getInt(5)); //포인트
				return dto;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null; //DB에러 or 조회 결과가 없는
	}
	
	//6. 아이디 찾기 
	public String findId(String memail) {
		String sql = "select mid from member where memail = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memail);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getString(1); //찾은 아이디 반환
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return "false";
	}
	
//	//7. 비밀번호 찾기
//	public String findPwd(String mid, String memail) {
//		String sql = "select mpwd from member where memail = ? and mid = ?";
//		
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setString(1, memail);
//			ps.setString(2, mid);
//			
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				return rs.getString(1);
//			}
//			
//		}catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//		return "false";
//	}
	
	//7. 비밀번호 찾은 후 임시 비밀번호
	public String findPwd(String mid, String memail, String updatePwd) {
		String sql = "select mno from member where memail = ? and mid = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, memail);
			ps.setString(2, mid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) { //동일한 아이디와 이메일 일치한 레코드가 있으면 [찾았으면]
				
				sql = "update member set mpwd = ? where mno = ?";
				
				ps = con.prepareStatement(sql);
				ps.setString(1, updatePwd);
				ps.setInt(2, rs.getInt(1));
				
				int result = ps.executeUpdate(); //업데이트한 레코드 개수 반환
				System.out.println(result);
				if(result == 1) {
					//이메일 테스트 되는 경우
					/* new MemberDto().sendEmail(memail, updatePwd); */
					//이메일 전송 테스트 안되는 경우
					return "true";
				}
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return "false";
	}
	
}
