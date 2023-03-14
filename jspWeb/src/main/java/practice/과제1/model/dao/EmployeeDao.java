package practice.과제1.model.dao;

import java.util.ArrayList;

import practice.과제1.model.dto.DepartmentDto;
import practice.과제1.model.dto.EmployeeDto;

public class EmployeeDao extends Dao{
	//싱글톤
	private static EmployeeDao dao = new EmployeeDao();
	private EmployeeDao() { }
	public static EmployeeDao getInstance() {return dao;}
	
	// 입력받은 부서 -> 객체반환 
	   public DepartmentDto departmentDto(String departName) {
	         String sql = "select * from department  where departname = ?";
	         
	         try {
	            ps = con.prepareStatement(sql);
	            ps.setString(1, departName);
	            
	            rs = ps.executeQuery();
	            
	            if(rs.next()) {
	               DepartmentDto dto = new DepartmentDto(
	                     rs.getInt(1), 
	                     rs.getString(2), 
	                     rs.getString(3));
	               
	               return dto;
	            }
	            
	         }catch(Exception e) {
	            System.out.println(e.getMessage());
	         }
	         return null;
	      }
	   
	   // 사원등록
	   public boolean signup( EmployeeDto dto ) {
	      String sql = "insert into employee ( emimg , emname , emrank , emtype , emdepartno , emindate , emoutdate , emoutreason) values( ? , ? , ? , ? ,? , ? , ? , ? )";
	      try {
	         ps = con.prepareStatement(sql);
	         
	         ps.setString(1, dto.getEmimg() );
	         ps.setString(2, dto.getEmname() );
	         ps.setString(3, dto.getEmrank() );
	         ps.setString(4, dto.getEmtype() );
	         ps.setInt(5, dto.getEmdepartno() );
	         ps.setString(6, dto.getEmindate() );
	         ps.setString(7, dto.getEmoutdate() );
	         ps.setString(8, dto.getEmoutreason() );
	         
	         ps.executeUpdate();
	         return true;
	      }catch (Exception e) { System.out.println(e); }
	      return false;
	   }
	      
	   // 사원 출력
	   public ArrayList<EmployeeDto> emlist(){
	      ArrayList<EmployeeDto> list = new ArrayList<>();
	      String sql = "select * from employee";
	      try {
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         
	         while( rs.next() ) {
	            EmployeeDto dto = new EmployeeDto( 
	                  rs.getInt(1), 
	                  rs.getString(2), 
	                  rs.getString(3), 
	                  rs.getString(4), 
	                  rs.getInt(5),
	                  rs.getString(6), 
	                  rs.getString(7), 
	                  rs.getString(8), 
	                  rs.getString(9));
	            
	            list.add(dto);
	         }
	      }catch (Exception e) { System.out.println(e); }
	      return list;
	   }
	
	
	//퇴사 처리
	public boolean deleteEmployee(int employeeNo) {
		String sql = "delete from employee where emno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, employeeNo);
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}
	
	//사원 정보 수정
	public boolean updateEmployee(EmployeeDto dto) {
		
		String sql = "update employee set emname = ?, emtype = ?, emindate =?, emrank = ?, emoutdate =?, emoutreason = ?, emdepartno = ? where emno = ?";
		
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getEmname());
			ps.setString(2, dto.getEmtype());
			ps.setString(3, dto.getEmindate());
			ps.setString(4, dto.getEmrank());
			ps.setString(5, dto.getEmoutdate());
			ps.setString(6, dto.getEmoutreason());
			ps.setInt(7, dto.getEmdepartno());
			ps.setInt(8, dto.getEmno());
			
			int count = ps.executeUpdate();
			
			if(count == 1) {
				return true;
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	//부서번호로 부서명 받아오는 메소드
	public DepartmentDto returnDepartmentDto(String departName) {
		String sql = "select * from department where departname = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, departName);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				DepartmentDto dto = new DepartmentDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3));
				return dto;
			}
		
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	//직원 번호로 직원 정보 받아오는 메소드
	public EmployeeDto returnEmployee(int emno) {
		String sql = "select * from employee where emno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, emno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				EmployeeDto dto =  new EmployeeDto(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getInt(5),
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9)
				);
				return dto;
			}
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
}
