package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.MemberDao;


@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Find() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 입력받은 타입 요청
		String type = request.getParameter("type");
		
		/*같이 쓰려고 보낼 결과를 따로 뺀다.*/
		String result = null; //* 보낼 결과
		
		if(type.equals("1")) {//아이디 찾기
			//1. 
			String memail = request.getParameter("memail");
			//2. 
			result = MemberDao.getInstance().findId(memail);
			
		}else if(type.equals("2")) { //비밀번호 찾기
			//1.
			String mid = request.getParameter("mid");
			String memail = request.getParameter("memail");
			
			//난수 목록[표현할 난수 문자 목록]
			String ranStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^";
			//임시 비밀번호 만들기
			String updatePwd = "";
				//1. 12자리수
			for(int i = 0; i < 12; i++) { //12 자리수
				Random random = new Random();
				//ranStr 문자열에서 0인덱스 ~ 마지막 인덱스의 난수 인덱스 만들기 
				int index = random.nextInt(ranStr.length()); //0번 인덱스부터 마지막 인덱스[인덱스를 난수로 가져옴]
				updatePwd += ranStr.charAt(index);
			}
			
			//2.
			result = MemberDao.getInstance().findPwd(mid, memail, updatePwd);
			
			if(result.equals("true")) {
				result = updatePwd;
			}
		}
		
		response.getWriter().print(result);
	}

	//비밀번호 변경
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
