package jspweb.index;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jspweb.model.Dao;

/**
 * Servlet implementation class Q1
 */
@WebServlet("/Q1")
public class Q1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Q1() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<String> result = Dao.getInStance().qGetData();
		
		System.out.println("JS에게 GET 방식으로 받은 데이터 : " + result);
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String data = request.getParameter("data2"); //ajax (data : {"매개변수" : 데이터})
		
		//1. DB연동후 요청된 데이터를 DAO에게 전달 후 결과를 result에 저장 
		boolean result = Dao.getInStance().qSetData(data);
		
		
		System.out.println("JS에게 Post 방식으로 받은 데이터 : " + result);
		
		response.getWriter().print("Post : 잘받았습니다." + result); //http로 내보냄 -> js
	}

}
