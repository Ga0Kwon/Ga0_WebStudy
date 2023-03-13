package model.dao;

import java.sql.Statement;
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
				
				ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, dto.getMid());
				ps.setString(2, dto.getMpwd());
				ps.setString(3, dto.getMemail());
				ps.setString(4, dto.getMimg());
				
				ps.executeUpdate();
				
				//포인트 지급 [내용, 개수, 방금회원가입한 회원번호(PK)]
				/*
				 - insert 이후 자동으로 생성된 auto key 찾기
				 con.prepareStatement(sql);
				 아래로
				 con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
				 2. 생성된 PK 결과 담기
				 rs = ps.getGeneratedKeys();
				 3. 검색된 레코드 결과에서 pk 호출
				 rs.next() --> rs.getInt(1);
				  
				*/
				
				rs = ps.getGeneratedKeys(); //pk 값을 ps로 받기
				if(rs.next()) {
					int pk = rs.getInt(1);
					setPoint("회원가입축하", 100, pk);
				}
				
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
		
			/*[조건이 틀려도]정상이든 아니든 값이 없을 경우 null이 포함된 객체를 가져오기 때문에 로그인이 js에서 null님이 뜨게 됨.
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
				
				System.out.println(dto);
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
	
	//8. 포인트 함수 [1. 지급 내용 2. 지급 개수 3. 대상]
	public boolean setPoint(String content, int point, int mno) {
		String sql = "insert into mpoint(mpcomment, mpamount, mno) values (?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, content);
			ps.setInt(2, point);
			ps.setInt(3, mno);
			
			ps.executeUpdate();
			
			return true;
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return false;
	}
	
	//9. 회원 탈퇴 [인수 : mid 반환 : boolean]
	public boolean setDelete(String mid) {
		String sql = "delete from member where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			
			int count = ps.executeUpdate();
			
			/* 삭제된 레코드 수 반환 */
			if(count == 1) { //아이디가 달라도, 없어도 삭제가 된다. 즉 삭제한 개수가 있어야 확인 가능
				return true;
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	//10. 회원 수정 [인수 : mid, mpwd, memail 반환 : boolean]
	public boolean update(String mid, String mpwd, String memail) {
		String sql = "update member set mpwd = ? memail = ? where mid = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, mpwd);
			ps.setString(2, memail);
			ps.setString(3, mid);
			
			//수정한 필드[row]가 없어도 수정된다. 따라서 몇개 수정했는데 받아서 체크해야함.
			//executeUpdate() : 조작된 레코드 수가 반환됨
			int count = ps.executeUpdate(); //수정된 레코드 수 반환
			
			if(count == 1) { 
				return true; //레코두 수정 성공시 true
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
}
