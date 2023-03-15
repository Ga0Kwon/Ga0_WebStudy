package model.dao;

import model.dto.BoardDto;

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
}
