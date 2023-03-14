package practice.과제1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import practice.과제1.model.dao.EmployeeDao;
import practice.과제1.model.dto.EmployeeDto;


@WebServlet("/searchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

    //1. 사원번호로 정보 받아오기
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		EmployeeDto dto = EmployeeDao.getInstance().returnEmployee(Integer.parseInt(request.getParameter("emno")));
		
		ObjectMapper mapper = new ObjectMapper();
	    String jsonArray = mapper.writeValueAsString(dto);
	    
	    response.setContentType("application/json");
	    response.getWriter().print(jsonArray);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
