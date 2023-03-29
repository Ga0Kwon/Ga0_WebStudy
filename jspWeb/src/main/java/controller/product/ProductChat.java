package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import controller.admin.Alarm;
import model.dao.MemberDao;
import model.dao.ProductDao;
import model.dto.ChatDto;


@WebServlet("/product/chat")
public class ProductChat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductChat() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		int chatmno = Integer.parseInt(request.getParameter("chatmno"));
		
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		
		ArrayList<ChatDto> chatList = ProductDao.getInstance().getChatList(pno, mno, chatmno);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonArray = mapper.writeValueAsString(chatList);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
		
		
	}
	
	// chat 보내기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String ncontent = request.getParameter("ncontent");
		
		int pno = Integer.parseInt(request.getParameter("pno"));
		
		int frommno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));

		int tomno = Integer.parseInt(request.getParameter("tomno"));
	
		ChatDto dto = new ChatDto(0, ncontent, null, pno, frommno, tomno);
		
		boolean result = ProductDao.getInstance().setChat(dto);
		
		// 만약에 채팅 등록 성공했으면 tomno에게 소켓 알림 메시지 보내기
		if(result) {
			//서버 소켓에게 채팅을 받은 유저의 번호와 내용을 전달
			try {
				Alarm.messageServer(null, tomno+","+ncontent );
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		response.getWriter().print(result);
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
