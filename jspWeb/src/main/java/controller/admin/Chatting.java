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
	public void OnOpen(Session session,  @PathParam("mid") String mid) throws IOException {
		// 접속한 클라이언트 소켓들을 보관
		clientList.add(new ClientDto(session, mid)); 	
		
		//연결된 클라이언트 소켓을 모든 접속명단 목록 메시지 보내기
		OnMessage(session, "enter");
	}
	
	
	// 서버 엔드 포인트에 URL 매개변수 가져오기 
	@OnClose //클라이언트 소켓이 접속이 나갔을때 @PathParam => 경로상의 변수 String mid를 문자형 mid로 받는다
	public void OnClose(Session session) throws IOException {
		//접속이 끊긴 세션의 DTO를 찾아서 제외를 시켜야한다.
		for (ClientDto dto : clientList) {
			if(dto.getSession() == session) {
				/*찾은 dto를 삭제*/
				clientList.remove(dto); //나가면 접속명단에서 제외
				
				// 연결이 끊긴 클라이언트 소켓을 모든 접속명단에게 알림 메시지 보내기
				//1) 문자열 타입의 JSON형식 직접 작성하기 [VS ObjectMapper]
				// {"필드명1" : "데이터1", "필드명2" : "데이터2"}
				/* String msg = "{\"param1\":\"data1\",\"param2\":\"data\"}"; */
				
				String msg = "{\"type\":\"alerm\",\"msgbox\":\""+dto.getMid()+"님이 채팅방에 나갔습니다.\"}";
				OnMessage(session, msg);
				
				// 연결이 끊긴 클라이언트 소켓을 모든 접속명단 목록 알림 메시지 보내기
				OnMessage(session, "enter");
				break; //나간 사람 찾았으면 더이상 반복문 X
			}
		}
	}
	
	//클라이언트 소켓이 메시지를 보냈을 때 [서버가 메시지 받기]
	@OnMessage
	//session : 누가 msg : 어떤 메세지
	
	public void OnMessage(Session session, String msg) throws IOException {
		//두군데에서 사용해야하므로 위로 뺌
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		//2. 접속 명단 알림
		if(msg.equals("enter")) { //enter가 들어올 수는 절대 없음 [엔터를 누르면 메시지가 전송되는거지, 엔터키가 전송되지않기 때문]
			//회원 명단[이미지, 아이디] 포함된 회원리스트 생성
			ArrayList<MessageDto> list = new ArrayList<>();
			
			for(ClientDto dto : clientList) {
				list.add(new MessageDto(dto.getSession(), null)); //현재 접속된 회원정보 객체 생성
			}

			json = mapper.writeValueAsString(list); //접속자 명단 객체 여러개
			
		//1. 메시지 보내는 경우	
		}else {
			//메세지 형식 구성
			//메시지 받는 프로그램 [JS] : JSON -> *Session은 json으로 형변환을 할 수 없다.
			//JSON으로 형변환할 때 Session을 형변환할 수가 없다.
			MessageDto messgaeDto = new MessageDto(session, msg);
			json = mapper.writeValueAsString(messgaeDto); //메시지 보낸 정보 객체 1개 
		}
		
	
		
		/*서버가 클라이언트 소켓에게 메시지 보내기*/
		//현재 서버소켓과 연결된 클라이언트 소켓 모두에게 서버가 받은 내용을 전달
		  for(ClientDto dto : clientList) { 
			  //문자열로 전달
			  //servlet이 지원하던 setContentType("application/json");을 쓰지 X
			  // -> 즉, ObjectMapper을 통해 json형식[모양]이긴 하나 타입은 문자열로 보낸다.
			  //보낸 사람 아이디 + 프로필, 시간까지 전부 보냄
			  dto.getSession().getBasicRemote().sendText(json); //->클라이언트
			  
		  }
		 
	}
}
