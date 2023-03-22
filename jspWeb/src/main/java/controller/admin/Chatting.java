package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.dto.ClientDto;
import model.dto.MessageDto;

//해당 클래스를 서버소켓[종착점] 으로 만들기
@ServerEndpoint("/chatting/{mid}") //아이디 받기
//URL 매개변수 받을때 : /경로/{매개변수1}/{매개변수2} --> @PathRaram("경로상의 매개변수명") 타입 변수명 [인수로]
	//ex) /jspWeb/chatting/qweqwe
	//ex) /jspWeb/chatting/{mid}
	//ex) @PathRaram("mid") => qweqwe
	//ex) 매개변수 = qweqwe
//URL 매개변수 받을때 : /경로?매개변수명1 = 데이터1&매개변수명2 = 데이터2 --> request.getParameter("매개변수명")[함수안에]
public class Chatting {
	//클라이언트 소켓이 접속했을때의 실행되는 메소드/함수
	
	//*-* 접속한 클라이언트 명단[목록] (클라이언트 소켓 여러개 저장)
	public static ArrayList<ClientDto> clientList = new ArrayList<>();
	
	@OnOpen //어노테이션을 해놔야 인식을 하고 실행된다.
	//session [접속한 클라이언트 소켓 객체]
	public void OnOpen(Session session,  @PathParam("mid") String mid) {
		// 접속한 클라이언트 소켓들을 보관
		clientList.add(new ClientDto(session, mid)); 	
	}
	// 서버 엔드 포인트에 URL 매개변수 가져오기 
	@OnClose //클라이언트 소켓이 접속이 나갔을때 @PathParam => 경로상의 변수 String mid를 문자형 mid로 받는다
	public void OnClose(Session session) {
		//접속이 끊긴 세션의 DTO를 찾아서 제외를 시켜야한다.
		for (ClientDto dto : clientList) {
			if(dto.getSession() == session) {
				/*찾은 dto를 삭제*/
				clientList.remove(dto); //나가면 접속명단에서 제외
			}
		}
	}
	
	//클라이언트 소켓이 메시지를 보냈을 때 [서버가 메시지 받기]
	@OnMessage
	//session : 누가 msg : 어떤 메세지
	public void OnMessage(Session session, String msg) throws IOException {
		//메세지 형식 구성
		MessageDto messageDto = new MessageDto(session, msg);
		//메시지 받는 프로그램 [JS] : JSON -> *Session은 json으로 형변환을 할 수 없다.
		ObjectMapper mapper = new ObjectMapper();
		String jsonMessage = mapper.writeValueAsString(messageDto);
		//JSON으로 형변환할 때 Session을 형변환할 수가 없다.
		
		/*서버가 클라이언트 소켓에게 메시지 보내기*/
		//현재 서버소켓과 연결된 클라이언트 소켓 모두에게 서버가 받은 내용을 전달
		  for(ClientDto dto : clientList) { 
			  //문자열로 전달
			  //servlet이 지원하던 setContentType("application/json");을 쓰지 X
			  // -> 즉, ObjectMapper을 통해 json형식[모양]이긴 하나 타입은 문자열로 보낸다.
			  //보낸 사람 아이디 + 프로필, 시간까지 전부 보냄
			  dto.getSession().getBasicRemote().sendText(jsonMessage); //->클라이언트
			  
		  }
		 
	}
}
