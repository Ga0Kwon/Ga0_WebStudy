package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.ReplayDto;

@WebServlet("/board/replay")
public class Replay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Replay() {
      
    }

	//댓글 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		ArrayList<ReplayDto> result = BoardDao.getInstance().getReplayList(bno);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonArray = mapper.writeValueAsString(result);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	// 댓글 달기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //댓글은 한글이 있을 수 있기 때문
		int type = Integer.parseInt(request.getParameter("type"));
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		String rcontent = request.getParameter("rcontent");
		
		ReplayDto dto = new ReplayDto(rcontent, mno, bno);
		
		if(type == 1) { //상위 댓글 
			
		}else if(type == 2) { //하위 댓글
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			dto.setRindex(rindex); // 생성자 안만들고 넣는 방법 
		}
		
		boolean result = BoardDao.getInstance().rwrite(dto);
		response.getWriter().print(result);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
