package practice.Day02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// * request : JS 요청 객체
		
		//1. 요청시 데이터 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		
		//2. request.getParameter("매개변수명") 
			// 데이터를 가져올때 무조건 String 타입으로 가져오기 때문에 [필요에 따라 형변환해야함!] -> AJAX는 문자열로 받아옴,,
		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		double data3 = Double.parseDouble(request.getParameter("data3"));
		int data4 = Integer.parseInt(request.getParameter("data4"));
		//DB를 위해 String [DateTime이나 Date는 DB에게 줄때 문자열로 줘야함]
		String data5 = request.getParameter("data5");
		String data6 = request.getParameter("data6");
		//DB에겐 char이 없기에 String
		String data7 = request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean( request.getParameter("data8"));
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		
		//3. DAO 메소드에 인수 10개 전달 
		boolean result = Dao.getInStance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		// * response [응답] : JS에게 응답을 보냄
		//4. 응답시 데이터 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		//5. DAO를 부터 결과를 JS에게 전달하기 
		response.getWriter().print(result);
	}

}
