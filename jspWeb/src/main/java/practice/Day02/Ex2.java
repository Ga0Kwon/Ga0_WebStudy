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
		//1. Dao에게 모든 데이터 요청
//		ArrayList<Object> infoList = Dao.getInStance().getData();
		ArrayList<Dto> dtoList = Dao.getInStance().getDtoData();
		
			//* JAVA객체와 JS객체는 체계/형태가 다르다 [호환 불가]
			// 해결 : JAVA객체를 JS객체로 바꾸자 [Object -> json]
				//1) 라이브러리 3개 [Jackson-databind-x, Jackson-core-x, Jackson-annotations-x]
				//2) ObjectMapper 객체 생성 [jackson 라이브러리에서 제공]
		
		ObjectMapper objectMapper = new ObjectMapper();
				//3) ObjectMapper.writeValueAsString(자바객체) ---> 자바 객체를 JSON 형식의 문자열로 반환
		String jsonArray = objectMapper.writeValueAsString(dtoList);
		
		//2. 요청으로 받은 결과를 JS에게 전달 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); //전달[전송]타입 json 방식
//		response.getWriter().print(infoList);
		//response.getWriter().print(dtoList);
		response.getWriter().print(jsonArray); //변환된 json 형식의 문자열 전달 
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
		
		//3. DAO 메소드에 인수 10개 전달 [Dto X]
//		boolean result = Dao.getInStance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		
		//Dto 버전 
		Dto dto = new Dto(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		boolean resultDto = Dao.getInStance().setDtoData(dto);
		
		// * response [응답] : JS에게 응답을 보냄
		//4. 응답시 데이터 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		//5. DAO를 부터 결과를 JS에게 전달하기 
		response.getWriter().print(resultDto);
	}

}
