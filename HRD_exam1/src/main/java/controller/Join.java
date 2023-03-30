package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/join")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Join() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int custno = Integer.parseInt(request.getParameter("custno"));
		
		String custname = request.getParameter("custname");

		String phone = request.getParameter("phone");

		String address = request.getParameter("address");

		
		String joindate = request.getParameter("joindate");

		String grade = request.getParameter("grade");
		int city = Integer.parseInt(request.getParameter("city"));
		
		memberDto dto = new memberDto(custno, custname, phone, address, joindate, grade, city);
		
		
		Dao dao = new Dao();
		
		boolean result = dao.setMember(dto);
		
		if(result) {
			response.setCharacterEncoding("UTF-8");
			response.sendRedirect("/HRD_exam1/view.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String custname = request.getParameter("custname");

		String phone = request.getParameter("phone");

		String address = request.getParameter("address");

		
		String joindate = request.getParameter("joindate");

		String grade = request.getParameter("grade");

		
		int city = Integer.parseInt(request.getParameter("city"));
		
		memberDto dto = new memberDto(custname, phone, address, joindate, grade, city);

		
		Dao dao = new Dao();
		boolean result = dao.join(dto);
		
		if(result) {
			response.setCharacterEncoding("UTF-8");
			response.sendRedirect("/HRD_exam1/join.jsp");
		}
	}


}
