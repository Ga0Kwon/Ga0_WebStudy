package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.MemberDto;

@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Email() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*		request.setCharacterEncoding("UTf-8"); //한글 있을리가 없으므로[정규표현식] => 주석처리*/		
		//1. 받을 회원 이메일 요청
		String memail = request.getParameter("memail");
		System.out.println(memail);
		
		//2. 인증 코드 만들기
		String auth = "";
		
		for(int i = 0; i < 6; i++) { //6자리 난수 생성
			Random random = new Random();
			auth += random.nextInt(10); //0부터 9사이의 정수 생성
		}
		System.out.println(auth);
		
		//3. 인증 코드와 받는 사람의 이메일에게 보낸 후 결과 받아오기
		//static X => 인스턴스 멤버 => 즉, new연산자가 필요함
		boolean result = new MemberDto().sendEmail(memail, auth); //힙만들고 바로 사라짐[메소드영역에 남긴것이 없기 때문에 재사용X]
		
		//3-1 
//		MemberDto dto = new MemberDto();
//		dto.sendEmail(memail, auth);
		
		//3. 인증 코드를 받는 사람의 이메일에게 보내기
		if(result) { //인증 코드 보내기 [메일 전송 성공하면]
			//3. 인증 코드 보내기
			response.getWriter().print(auth);
		}else {// 메일 전송 실패시
			response.getWriter().print(result);
		}
		
		/*	
		    SMTP 서버는 SMTP 프로토콜을 사용해 이메일을 전송하고 수신할 수 있는 메일 서버이다.
			SMTP : 간이 우편 전송 프로토콜[Simple Mail Transfer Protocol]
			메일 서버(네이버, 구글, 카카오, 다음)에게 우편 전송
		*/
		
	}

}