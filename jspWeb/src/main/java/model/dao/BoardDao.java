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
	
	//2. 모든 글 출력
	public ArrayList<BoardDto> getBoardList(){
		String sql = "select board.*, member.mid from member natural join board";
		ArrayList<BoardDto> boardList = new ArrayList<>();
		
		try {
			ps = con.prepareStatement(sql);
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
}
