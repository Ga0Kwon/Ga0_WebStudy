package practice.과제1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import practice.과제1.model.dao.EmployeeDao;
import practice.과제1.model.dto.EmployeeDto;

@WebServlet("/employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Employee() {}

    // 모든 게시물 조회
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
       response.setCharacterEncoding("UTF-8");
       ArrayList<EmployeeDto> list = EmployeeDao.getInstance().emlist();
       ObjectMapper mapper = new ObjectMapper();
       String jsonArray = mapper.writeValueAsString(list);
       
       response.setContentType("application/json");
       response.getWriter().print(jsonArray);
       
       
    }

    // 사원등록
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 업로드 코드 구현
       String path = request.getSession().getServletContext().getRealPath("/member/pimg");
       System.out.println(path);
       MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "UTF-8" , new DefaultFileRenamePolicy());
       // 
       String emimg = multi.getFilesystemName("changeemimg");
       String emname = multi.getParameter("emname");
       String emrank = multi.getParameter("emrank");
       String emtype = multi.getParameter("emtype");
       String emdepartno = multi.getParameter("emdepartno");
       String emindate = multi.getParameter("emindate");
       String emoutdate = multi.getParameter("emoutdate");
       String emoutreason = multi.getParameter("emoutreason");
       
       
        int Departno = EmployeeDao.getInstance().returnDepartmentDto(emdepartno).getDepartno();
        
       
        if( emoutdate.equals("") ) { emoutdate = null; }
        if( emoutreason.equals("") ) { emoutreason = null; }
        System.out.println(emimg);
        EmployeeDto dto = new EmployeeDto(
    		   0, 
    		   emimg, 
    		   emname, 
    		   emrank, 
    		   Departno,  
    		   emtype, 
    		   emindate, 
    		   emoutdate, 
    		   emoutreason);
       
       boolean result = EmployeeDao.getInstance().signup(dto);
       response.getWriter().print(result);
       
    }


	//인사 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getSession().getServletContext().getRealPath("/member/pimg");
		
		MultipartRequest multi = new MultipartRequest(
				request,
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		int emno = Integer.parseInt(multi.getParameter("emno"));
		
		String newmimg = multi.getFilesystemName("newmimg"); 
		
		String emname = multi.getParameter("emname");
		String emtype = multi.getParameter("emtype");
		
		String emrank = multi.getParameter("emrank");
		
		String emdepartname = multi.getParameter("emdepartname");
		
		int emdepartno = EmployeeDao.getInstance().returnDepartmentDto(emdepartname).getDepartno();
		String emoutreason = multi.getParameter("emoutreason");
		
		String emindate = multi.getParameter("emindate"); 
		
		String emoutdate = multi.getParameter("emoutdate");
		
		if( emoutdate.equals("") ) { emoutdate = null; }
	        
		EmployeeDto dto = new EmployeeDto(
				emno, 
				newmimg, 
				emname, 
				emrank, 
				emdepartno,
				emtype, 
				emindate, 
				emoutdate, 
				emoutreason);
		
		boolean result = EmployeeDao.getInstance().updateEmployee(dto);
		
		response.getWriter().print(result);
		
	}

	//인사 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int emno = Integer.parseInt(request.getParameter("emno"));
		
		boolean result = EmployeeDao.getInstance().deleteEmployee(emno);
		
		response.getWriter().print(result);
	}

}
