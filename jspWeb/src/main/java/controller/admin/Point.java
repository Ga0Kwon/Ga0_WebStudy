package controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.MemberDao;
import model.dao.ProductDao;


@WebServlet("/point")
public class Point extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Point() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		HashMap<String, Integer> pointlist = ProductDao.getInstance().getSum();
		
		System.out.println(pointlist);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonArray = mapper.writeValueAsString(pointlist);
		System.out.println(jsonArray);
		
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mpcomment = request.getParameter("mpcomment");

		int mpamount = Integer.parseInt(request.getParameter("mpamount"));
		
		int mno = Integer.parseInt(request.getParameter("mno"));
	
		boolean reseult = MemberDao.getInstance().setPoint(mpcomment, mpamount, mno);
		
		response.getWriter().print(reseult);
	}

}
