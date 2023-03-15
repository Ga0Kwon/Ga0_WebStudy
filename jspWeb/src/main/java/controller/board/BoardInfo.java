package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;


@WebServlet("/board/info")
public class BoardInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardInfo() {
      
    }

	//게시글 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int type = Integer.parseInt( request.getParameter("type"));
		
		//Java형태를 script 형식으로 바꿔주는 것이 ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		
		//응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		
		if(type == 1) { //1. 전체 출력
			ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList();
			
			String jsonArray =  mapper.writeValueAsString(result);
			
			response.getWriter().print(jsonArray);
		}else if(type == 2) {
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardDto result = BoardDao.getInstance().getBoard(bno);

			String jsonArray =  mapper.writeValueAsString(result);
			
			response.getWriter().print(jsonArray);
		}

	}

	// 게시글 쓰기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//업로드
		request.setCharacterEncoding("UTF-8");
		//1. 업로드할 파일의 저장 위치 [경로]
			// 클라이언트[유저] ----x----> git[내프로젝트]
			//             ----o----> 서버[배포된프로젝트]
		//2. 경로 찾기
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		/* System.out.println("path : " + path); */
		
		//3. 파일 복사 [입력받은(file) 대용량 바이트 복사하기]
		MultipartRequest multi = new MultipartRequest(
				request, 						//1. 요청 방식
				path, 							//2. 첨부파일 가져와서 저장할 서버내 폴더
				1024*1024*10,					//3. 10MB; 첨부파일 허용 범위 용량 [바이트 단위]
				"UTF-8", 						//4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy()   //5. 동일한 첨부파일명이 있으면 식별깨짐 -> 뒤에 숫자를 붙여줌
		);
		/* System.out.println("multi : " + multi); */
		//----------------------확인----------------------
			//requeest.getParameter("객체면 필드명");
			//multi.getParameter("form 하위 태그의 name명");
		int cno = Integer.parseInt(multi.getParameter("cno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
//		System.out.println("cno : " + cno);
//		System.out.println("btitle : " + btitle);
//		System.out.println("bcontent : " + bcontent);
//		System.out.println("bfile : " + bfile);
		
		//1. 회원제 게시판 [ 로그인된 회원의 mno 필요!]
		String mid = (String)request.getSession().getAttribute("login");
		
		//2. mid ---> mno
		/* int mno = MemberDao.getInstance().getMember(mid).getMno(); */
		int mno = MemberDao.getInstance().getMno(mid);
		
		//3. 만약에 회원번호가 없으면 글쓰기 불가능 [로그인 안했으면]
		if(mno < 0) {
			/* response.sendRedirect("/jspWeb/member/login.jsp"); */
			response.getWriter().print("false");
		}
		
		//DTO
		BoardDto dto = new BoardDto(btitle, bcontent, bfile, mno, cno);
		
		//DAO
		boolean result = BoardDao.getInstance().bwrite(dto);
		
		//응답
		response.getWriter().print(result);
		
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
