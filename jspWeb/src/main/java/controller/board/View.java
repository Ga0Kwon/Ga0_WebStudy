package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;

@WebServlet("/board/view")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public View() {

    }

    //조회수, 좋아요, 싫어요 증가
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("type"));
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		/*
		  	특정 시간
		  	- 하루에 한번씩 조회수 또는 좋아요 수 또는 싫어요 수 증가 가능
		  	- 회원별 vs. PC마다
		  	- 세션 사용
		*/
		//1. PC 네트워크 식별자 [ ??? : ip ]
			//1) java에서 현재 요청한 클라이언트 ip확인
		String ip = request.getRemoteAddr();
		/*localhost 경우  ip : 0:0:0:0:0:0:0:1 라고 뜬다.*/
//		System.out.println(" ip : " + ip);
		//4. 만약에 기존 세션이 없으면 증가 없으면 증가 불가
		Object obj = request.getSession().getAttribute(ip+type+bno);
		
		if(obj == null) { //세션[ip+type+bno]이 생성된 적이 없다.
			//2) 세션 생성 [ip + type + bno]
			request.getSession().setAttribute(ip+type+bno, 1); // 임의로 1 : 이 사람이 클릭했다.
			// IP하나밖에 안들어가면 다른 게시물 못함, type마다 한 이유 좋아요, 싫어요, 조회수 다 한번씩 증가할 수 있도록,
			//bno는 게시물마다 1번씩 가능하게 하려고
				//3) 세션 생명주기 [생명주기 지나면 자동으로 메모리 삭제 / 초 단위]
				// - 세션 초기화 되는 기준
				// 1] 서버 끄기 2] 서버 다시켰을때 3] setMaxInactiveInterval 설정한 일정 시간 지났을 때 
			request.getSession().setMaxInactiveInterval(60*60*24); //초단위
			//하루가 지나면 다시 증가할 수 있도록 [게시물 각각 한번씩] 단위를 하루단위로 설정했다.
			boolean result = BoardDao.getInstance().bIncrease(type, bno);
			response.getWriter().print(result);
		}
		// 없으면 아무것도 안하면 됨
		response.getWriter().print(-1);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
