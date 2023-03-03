package practice.Day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Q2
 */
@WebServlet("/Q2")
public class Q2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<qDto> qdtoDB = qDao.getInStance().getqData();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		String jsonArray = objectMapper.writeValueAsString(qdtoDB);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		response.getWriter().print(jsonArray);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phoneNumber");
		double height = Double.parseDouble(request.getParameter("height"));
		int age = Integer.parseInt(request.getParameter("age"));
		String signDate = request.getParameter("signDate");
		String sex = request.getParameter("sex");
		boolean agree = Boolean.parseBoolean(request.getParameter("agree"));
		String location = request.getParameter("location");
		String introduce = request.getParameter("introduce");
		
		qDto dto = new qDto(name, phoneNumber, height, age, signDate, sex, agree, location, introduce);
		
		boolean result = qDao.getInStance().setqData(dto);
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
