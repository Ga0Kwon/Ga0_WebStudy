package controller.member;

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

import model.dao.MemberDao;
import model.dto.MemberDto;


@WebServlet("/member")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Info() {
        super();

    }

    //2. 회원 정보 호출 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//1. Dao에게 모든 회원 정보 요청 
		ArrayList<MemberDto> memberList = MemberDao.getInstance().getMemberList();
		
		//String은 JS에서도 문자열이니까 형변환할 필요가 없다 [문자로 전달하니까] 하지만 객체는 다름!
		
		//2. JAVA 객체 --> JS 객체 형변환 [ 서로 다른 언어 사용하니까 ]
		ObjectMapper objectmapper = new ObjectMapper();
		String jsonArray = objectmapper.writeValueAsString(memberList);
		
		//3. 응답
		response.setCharacterEncoding("UTF-8"); //응답 데이터 한글 인코딩
		response.setContentType("application/json"); //응답(전송할) 데이터 타입
		response.getWriter().print(jsonArray); //응답 데이터 보내기
	}

	//1. 회원 가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//------------------첨부파일 있을 때 ------------------
		/*
		  request는 첨부파일[대용량] 에 대한 요청이 불가능 --> 외부 라이브러리 [cos.jar]
		  1. 프로젝트 build path 추가
		  2. 프로제트 WEB-INF -> lib -> cos.jar 추가
		  -------
		  => MultipartRequest 클래스 제공
		  	1. 요청 방식 : HTTP request
		  	2. 저장 폴더 : 1.프로젝트[git에 올라감] 2. 서버[git에 안올라감, workspace]
		  		서버폴더 찾기 : request.getSession().getServletContext().getRealPath("(webapps생략)폴더명");
		  	3. 첨부파일 허용 범위 용량 [바이트단우;]
		  	4. 첨부파일 요청 ㅎ나글 인코딩
		  	5. 첨부파일 파일명 중복일 경우 뒤에 자동 숫자 붙임 
		  	
		  	1bit : 0, 1
		  	1byte : 01010101 = 8bit
		  	1kbyte : 1024byte = 1KB
		  	1MByte : 1024kbyte = 1MB
		  	1GByte : 1024MByte  = 1GB
		  	
		*/
		// * 현재 작업 중인 프로젝트내 경로 찾기[Git에 올라감]
//		String path = "C:\\Users\\504\\git\\Ga0_WebStudy\\jspWeb\\src\\main\\webapp\\member\\pimg";
		
		request.setCharacterEncoding("UTF-8");
		
		// * 현재 서버의 배포된 프로젝트내 폴더 경로 찾기
		String uploadpath = request.getSession().getServletContext().getRealPath("/member/pimg");
//		System.out.println(uploadpath);
		
		//* 진짜 업로드 [파일만 업로드]
		//JSP에서 첨부파일 쓰는 법!
		MultipartRequest multi = new MultipartRequest(
				request, 						//1. 요청 방식
				uploadpath, 							//2. 첨부파일 가져와서 저장할 서버내 폴더
				1024*1024*10,					//3. 10MB; 첨부파일 허용 범위 용량 [바이트 단위]
				"UTF-8", 						//4. 첨부파일 한글 인코딩
				new DefaultFileRenamePolicy()   //5. 동일한 첨부파일명이 있으면 식별깨짐 -> 뒤에 숫자를 붙여줌
				);
		
		// 그외 매개변수 요청 [request --> multi / form 하위 태그 name 식별자]
		String mid = multi.getParameter("mid");  //호출할 input의 name
		String mpwd = multi.getParameter("mpwd"); //호출할 input의 name
		String memail = multi.getParameter("memail"); //호출할 input의 name
		/* 첨부파일만, 첨부파일된 파일명 호출 []  */
		String mimg = multi.getFilesystemName("mimg"); //호출할 input의 name
		
		MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		
		boolean result = MemberDao.getInstance().signup(dto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
		
		//------------------첨부파일 없을 때 ------------------
		//1. ajax에게 데이터 요청
		/*
		 * request.setCharacterEncoding("UTF-8"); String mid =
		 * request.getParameter("mid"); String mpwd = request.getParameter("mpwd");
		 * String memail = request.getParameter("memail"); String mimg =
		 * request.getParameter("mimg");
		 * 
		 * //2. DTO 만들기 MemberDto dto = new MemberDto(0, mid, mpwd, mimg, memail);
		 * System.out.println("dto : " + dto);
		 * 
		 * //3. Dao호출하고 결과 받기 [MemberDao] boolean result =
		 * MemberDao.getInstance().signup(dto);
		 * 
		 * //4. 결과 응답하기 response.setCharacterEncoding("UTF-8");
		 * response.getWriter().print(result);
		 */
		
	}

	//3. 회원 정보 수정
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	//4. 회원 탈퇴
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
