package controller.board;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Sockaddr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.dao.BoardDao;
import model.dao.MemberDao;
import model.dto.BoardDto;
import model.dto.PageDto;


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
			// 카테고리 매개변수 요청 [cno]
			int cno = Integer.parseInt(request.getParameter("cno"));
			// ----------------- 검색 처리 ----------------
			// 1. 검색한 필요한 매개변수 요청 [key, keyword] 
			// gettotalSize와 getBoardList한테 조건 전달
			String key = request.getParameter("key");
			String keyword = request.getParameter("keyword");
			
			//------------------ page 처리 ---------------
			//1.현재 페이지[요청] , 2.페이지당 표시할 게시물 수  3.현재 페이지[게시물시작, 게시물 끝]
			int page = Integer.parseInt(request.getParameter("page"));
			int listSize = Integer.parseInt(request.getParameter("listSize"));
			int startRow  = (page-1)*listSize;//해당페이지에서의 게시물 시작 번호
			//------------------- page 버튼 만들기 -------------------
			//1. 전체페이지수 [총 게시물레코드수/페이지당표시되는수] 2. 페이지 표시할 최대버튼수 3. 시작버튼 번호
				//총레코드수/페이지당표시게시물수
					//1) 나머지가 없으면 => 몫 9/3 => 3페이지
					//2) 나머지가 있으면 => 몫+1 10/3 => 4페이지
			
			int totalSize = BoardDao.getInstance().getTotalSize(key, keyword, cno);
			//검색 없을 때
//			int totalSize = BoardDao.getInstance().getTotalSize();//마지막 페이지 수
			
			int totalpage = (totalSize%listSize == 0)? (totalSize/listSize) : (totalSize/listSize +1);
			/*
			   [예시]
			  	총 게시물 수 = 10 , 페이지당 표시할 게시물수 3
			  	1. 총 페이지 수 = 4 [123, 456, 789, 10]
			  		=> DB상 레코드 수로 따지면
			  		[012, 345, 678, 9]이다. (0부터시작)
			  	 => 나머지가 있으면 +1, 없으면 거기까지 [10/3]
			  	2. 페이지별 게시물시작 PK 번호 찾기
			  		1) 페이지 요청 (현재페이지-1)*페이지당표시할게시물수
			 	
			 	3. 시작버튼, 마지막버튼수
			 		startBtn 1 6 11 16...
			 		endBtn 5 10 15 
			 		7페이지
			 		1페이지 -> 12345
			 		2페이지 -> 12345
			 		3페이지 -> 12345
			 		4페이지 -> 12345
			 		5페이지 -> 12345
			 		6페이지 -> 67
			 		7페이지 -> 67
			 */
			
			int btnSize = 5; //최대 페이징 버튼 출력수
			int startBtn = ((page-1) / btnSize )*btnSize+1; 
			int endBtn = startBtn + (btnSize-1);

			//단 마지막버튼수가 총페이지수보다 커지면 막아야한다. [이 경우 마지막 버튼 수를 총 페이지수로]
			if(endBtn > totalpage) {
				endBtn = totalpage;
			}
			//검색이 있을 때 
			ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList(startRow, listSize, key, keyword, cno);
			
			//검색이 없을 때
			/*ArrayList<BoardDto> result = BoardDao.getInstance().getBoardList(startRow, listSize);*/
			
			PageDto pagedto = new PageDto(page, listSize, startRow, totalSize, totalpage, btnSize, startBtn, endBtn, result);

			String jsonArray =  mapper.writeValueAsString(pagedto);
			
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
//		//2. 경로 찾기
//		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
//		/* System.out.println("path : " + path); */
//		
//		//3. 파일 복사 [입력받은(file) 대용량 바이트 복사하기]
//		MultipartRequest multi = new MultipartRequest(
//				request, 						//1. 요청 방식
//				path, 							//2. 첨부파일 가져와서 저장할 서버내 폴더
//				1024*1024*10,					//3. 10MB; 첨부파일 허용 범위 용량 [바이트 단위]
//				"UTF-8", 						//4. 첨부파일 한글 인코딩
//				new DefaultFileRenamePolicy()   //5. 동일한 첨부파일명이 있으면 식별깨짐 -> 뒤에 숫자를 붙여줌
//		);
		
		MultipartRequest multi = upload(request);
		
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
	
	//업로드 함수화 처리
	protected MultipartRequest upload(HttpServletRequest request) throws IOException {
		String path = request.getSession().getServletContext().getRealPath("/board/bfile");
		
		//업로드만 담당
		MultipartRequest multi = new MultipartRequest(
				request, 
				path,
				1024*1024*10,
				"UTF-8",
				new DefaultFileRenamePolicy());
		
		return multi;
	}
	
	//수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		MultipartRequest multi = upload(request);
		
		int bno = Integer.parseInt( multi.getParameter("bno"));
		int cno = Integer.parseInt(multi.getParameter("cno"));
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		String bfile = multi.getFilesystemName("bfile");
		
		// 첨부파일 수정 경우의 수 
			//1. 기존에 첨부파일이 없었다. -> 새로운 첨부파일이 있다. [X]
			//					  -> 새로운 첨부파일이 있다. [업로드]
		    //2. 기존에 첨부파일이 있었다. -> 새로운 첨부파일이 없다. [기존파일로 업데이트처리]
			//					  -> 새로운 첨부파일이 있다. [업로드, 기존파일 삭제]
		
		if(bfile == null) {//새로운 첨부파일 없다.
			//기존 파일에 원래 있던 첨부파일 그대로
			bfile = BoardDao.getInstance().getBoard(bno).getBfile();
		
		}else { //새로운 첨부파일 있다.
			//수정전에 첨부파일 삭제
			//삭제 전 첨부파일명 구하기
			String oldfile = BoardDao.getInstance().getBoard(bno).getBfile();
			
			fileDelete(request, bno, oldfile);
		}
		
		BoardDto dto = new BoardDto(bno, btitle, bcontent, bfile, cno);
		
		boolean result = BoardDao.getInstance().bUpdate(dto);
		
		response.getWriter().print(result);
	}
	
	//첨부파일 삭제 메서드
	protected void fileDelete(HttpServletRequest request, int bno, String oldfile) {
		//삭제 or 수정 : 첨부파일 있을시 같이 삭제해야한다.
			//1. 경로를 찾아서
			//2. 파일 객체화 [?? 다양한 파일 관련 메소드 제공 .length(), delete()]
		String path = request.getSession().getServletContext().getRealPath("/board/bfile/" +oldfile);
		File file = new File(path); //객체화
		
		if(file.exists()) { //만약에 파일이 존재하면
			
			file.delete(); //삭제
			
		}
		
	}

	//삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		int type = Integer.parseInt(request.getParameter("type"));
		
		//삭제 전 첨부파일명 구하기
		String oldfile = BoardDao.getInstance().getBoard(bno).getBfile();
		boolean result = true;
		
		if(type == 1) { //DB+파일 삭제
				result = BoardDao.getInstance().bDelete(bno);
		
			
			if(result == true) {
				fileDelete(request, bno, oldfile);
			}
			
			response.getWriter().print(result);
			
		}else if(type == 2) { //파일 삭제
			result = BoardDao.getInstance().bfileDelte(bno);
			fileDelete(request, bno, oldfile);
		}
		
	
		
	}

}
