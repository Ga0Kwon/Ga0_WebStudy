package model.dao;

import java.util.ArrayList;

import model.dto.BoardDto;
import model.dto.MemberDto;

public class BoardDao extends Dao{
	//싱글톤
	private static BoardDao boardDao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {return boardDao;}
	
	//1. 글쓰기
	public boolean bwrite(BoardDto dto) {
		String sql = "insert into board (btitle, bcontent, bfile, mno, cno)"
				+ "	values (?, ?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getMno());
			ps.setInt(5, dto.getCno());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	//2-2. 게시물 수 구하기
	public int getTotalSize(String key, String keyword, int cno) {
		String sql;
		
		if(key.equals("") && keyword.equals("")) {
			 sql = "select count(*) from member m natural join board b where b.cno = " +cno;
		}else {
			 sql = "select count(*) from member m natural join board b where "+key+" like " + "\"%"+ keyword + "%\" and b.cno = " +cno;
		}
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return rs.getInt(1);
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return 0;
	}
	
	//2-1. 모든 글 출력
	public ArrayList<BoardDto> getBoardList(int startRow,int listSize, String key, String keyword, int cno){
		String sql;
		ArrayList<BoardDto> boardList = new ArrayList<>();
		
		if(key.equals("") && keyword.equals("")) {
			 sql = "select b.*, m.mid from member m natural join board b where b.cno = " +cno
					 	+" order by bwritedate desc limit ?,?";
		}else {
			 sql = "select b.*, m.mid from member m natural join board b where "+key+" like \"%"+keyword+"%\" and b.cno = "+ cno 
					 	+" order by bwritedate desc limit ?,?";
		}
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, startRow);
			ps.setInt(2, listSize);
			
			rs =ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getInt(6), 
						rs.getInt(7),
						rs.getInt(8), 
						rs.getInt(9),
						rs.getInt(10),
						rs.getString(11));
				
				boardList.add(dto);
			}
			
			return boardList;
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//개별 출력
	public BoardDto getBoard(int bno) {
		String sql = "select board.*, member.mid, member.mimg from member natural join board where board.bno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardDto dto =  new BoardDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getInt(6), 
						rs.getInt(7), 
						rs.getInt(8), 
						rs.getInt(9), 
						rs.getInt(10), 
						rs.getString(11), 
						rs.getString(11));
				return dto;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	//조회수, 좋아요, 싫어요 중 증가
	public boolean bIncrease(int type, int bno) {
		
		String sql = "";
		
		if(type == 1) {
			sql = "update board set bview = bview +1 where bno = ?";
		}else if(type == 2) {
			sql = "update board set blike = blike +1 where bno = ?";
		}else if(type == 3) {
			sql = "update board set bhate = bhate +1 where bno = ?";
		}
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, bno);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	//게시물 삭제
	public boolean bDelete(int bno) {
		String sql = "delete from board where bno = " +bno;
		
		try {
			ps =con.prepareStatement(sql);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	//게시물 수정 
	public boolean bUpdate(BoardDto dto) {
		String sql = "update board set btitle = ?, bcontent = ?, bfile = ?, cno = ? where bno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getBtitle());
			ps.setString(2, dto.getBcontent());
			ps.setString(3, dto.getBfile());
			ps.setInt(4, dto.getCno());
			ps.setInt(5, dto.getBno());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	//파일만 삭제
	public boolean bfileDelte(int bno) {
		String sql = "update board set bfile = null where bno = " + bno;
		
		try {
			ps =con.prepareStatement(sql);
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
}
