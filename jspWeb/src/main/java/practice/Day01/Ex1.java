package practice.Day01;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class indexTest
 */
@WebServlet("/Ex1")
public class Ex1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. HTTP 객체 [ request : JS에게 요청, response : js에게 응답 ]
			//0) 한글 인코딩
				// 요청 인코딩 변경 : request.setCharacterEncoding("UTF-8");
				// 응답 인코딩 변경 : response.setCharacterEncoding("UTF-8");
			//1) request.getParameter("매개변수명");
			//2) response.getWriter().print(데이터);
		
		response.setCharacterEncoding("UTF-8");
		
		//1. DAO() 실행해서 데이터 호출
		ArrayList<String> result = Dao.getInStance().getData();
		
		System.out.println("확인 : " +result);
		//3. 응답
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. HTTP 객체 [ request :A JS에게 요청, response : js에게 응답 ]
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String data = request.getParameter("data"); //ajax (data : {"매개변수" : 데이터})
		
		//1. DB연동후 요청된 데이터를 DAO에게 전달 후 결과를 result에 저장 
		boolean result = Dao.getInStance().setData(data);
		
		
		System.out.println("JS에게 Post 방식으로 받은 데이터 : " + result);
		
		response.getWriter().print("POST : 잘받았습니다."); //http로 내보냄 -> js
	}

}
