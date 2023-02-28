package Day20.gallery.model.dao;

import java.util.ArrayList;

import Day20.gallery.model.dto.BoardDto;
import Day20.gallery.model.dto.CateogryDto;

public class BoardDao extends Dao{
	//1. 싱글톤 [내부에 본인객체 만든다.]
	private static BoardDao dao = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return dao;
	}
	
	//카테고리 추가 메소드
	public boolean addCategory(String cateogoryName) {
		String sql = "insert into Category (cateogry_name) value (?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, cateogoryName);
			
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	//모든 카테고리 목록 반환하는 메소드
	public ArrayList<CateogryDto> printCategory(){
		String sql = "select * from Category";
		ArrayList<CateogryDto> categoryList = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CateogryDto dto = new CateogryDto(rs.getInt(1), rs.getString(2));
				categoryList.add(dto);
			}
			
			return categoryList;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	
	
	//memberNo값으로 작성자 id를 가져오는 메소드
	public String findMemberId(int memberNo) {
		String sql = "select * from member where member_no = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, memberNo);
			
			rs = ps.executeQuery();
			
			String returnValue = null;
			
			if(rs.next()) {
				returnValue = rs.getString(2);
				
			}
			System.out.println(returnValue); 
			return returnValue;
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//categoryNo로 categoryName찾는 메소드
	public String findCategoryName(int categoryNo) {
		String sql = "select * from Category where category_no = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, categoryNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString(2));
				return rs.getString(2);
			}else {
				return null;
			}
			
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	// 게시판 목록 3개만 반환하는 메소드
	public ArrayList<BoardDto> printLimitBoard(){
		String sql = "select b.board_no , b.board_title , b.board_content , b.board_date , b.board_view , m.member_id , c.cateogry_name"
				+ "			from board b , member m , category c "
				+ "			where b.member_no = m.member_no and b.category_no = c.category_no"
				+ "			order by b.board_date desc limit 3;";
		ArrayList<BoardDto> boardDB = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6),  
						rs.getString(7)
				);
				
				boardDB.add(dto);
			}
			
			return boardDB;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	//전체 게시판 반환하는 메소드 [받은 카테고리에 대한]
	public ArrayList<BoardDto> printWholeBoard(int categoryNo){
		String sql = "select b.board_no , b.board_title , b.board_content , b.board_date , b.board_view , m.member_id , c.cateogry_name "
				+ "			from board b , member m , category c "
				+ "			where b.member_no = m.member_no and b.category_no = c.category_no and b.category_no = ? "
				+ "			order by b.board_date desc limit 3;";
		ArrayList<BoardDto> boardDB = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, categoryNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDto dto = new BoardDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5), 
						rs.getString(6),  
						rs.getString(7));
				boardDB.add(dto);
			}
			return boardDB;
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	//게시물 등록 
	public boolean writeBoard(String boardTitle ,String boardContent, int memberNo, int categoryNo) {
		String sql = "insert into board(board_title, board_content, member_no, category_no)"
				+ "values (?, ?, ?, ?)";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, boardTitle);
			ps.setString(2, boardContent);
			ps.setInt(3, memberNo);
			ps.setInt(4, categoryNo);
			
			ps.executeUpdate();
			
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}	
