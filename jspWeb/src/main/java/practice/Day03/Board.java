package practice.Day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Ex3/Board")
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Board() {
        super();
        
    }
    
    //2. 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<BoardDto> boardList = BoardDao.getInStance().printBoard();
		
		ObjectMapper objectmapper = new ObjectMapper();
		String jsonArray = objectmapper.writeValueAsString(boardList);
		
		response.setContentType("application/json"); //전달[전송]타입 json 방식
		
		response.getWriter().print(jsonArray);
		
		
	}

	//1. 등록 [인수 : 입력한 값 / 반환 : 성공 여부]
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청시 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		//2. 매개변수 요청 [AJAX data 속성에서 보내준 매개변수 이름]
		String content = request.getParameter("content"); 
		String writer = request.getParameter("writer");
//		System.out.println("내용 : " + content + "  작성자 : " + writer);
		
		//3. Dto 객체 [기본 값 : int 필드의 0 / 객체 필드의 null]
		BoardDto boarddto = new BoardDto(0, content, null, writer);
		
		//4. Dao 호출
		boolean result = BoardDao.getInStance().onWrite(boarddto);
		
		//5. Dao 결과인 true, false 데이터를 response 객체 이용한 응답
			// 'true' vs '{true}'
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
	
	//3.수정/업데이트
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//1. 수정할 게시물 번호 요청
		int bno = Integer.parseInt(request.getParameter("bno"));
		//2. 수정할 게시물 내용 요청
		String newcontent = request.getParameter("newcontent");
		//3. Dao 호출해서 결과 얻기
		boolean result = BoardDao.getInStance().onUpdate(bno, newcontent);
		//4. 결과 응답하기
		response.getWriter().print(result);		
	}
	
	//4. 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//1. 삭제할 게시물 번호 요청 [ ???? 매개변수 못들어옴 => null]
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		//2. Dao 호출해서 결과 얻기
		boolean result = BoardDao.getInStance().onDelete(bno);
		//3. 결과를 응답
		response.getWriter().print(result);
	}

}
