package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dto.ClientDto;

//해당 클래스를 서버소켓[종착점] 으로 만들기
@ServerEndpoint("/chatting/{mid}") //아이디 받기

public class Chatting {
	//클라이언트 소켓이 접속했을때의 실행되는 메소드/함수
	
	//*-* 접속한 클라이언트 명단[목록] (클라이언트 소켓 여러개 저장)
	public static ArrayList<ClientDto> clientList = new ArrayList<>();
	
	@OnOpen //어노테이션을 해놔야 인식을 하고 실행된다.
	//session [접속한 클라이언트 소켓 객체]
	public void OnOpen(Session session,  @PathParam("mid") String mid) {
		System.out.println("웹 소켓이 들어왔다");
		System.out.println(session);
		// 접속한 클라이언트 소켓들을 보관
		clientList.add(new ClientDto(session, mid)); 
		System.out.println(clientList.toString());
		
	}
	// 서버 엔드 포인트에 URL 매개변수 가져오기 
	@OnClose //클라이언트 소켓이 접속이 나갔을때 @PathParam => 경로상의 변수 String mid를 문자형 mid로 받는다
	public void OnClose(Session session) {
		clientList.remove(session); //나가면 접속명단에서 제외
		System.out.println(session + "웹 소켓이 나갔습니다."); //먼저 접속된 것이 나가고 다시 소켓 들어옴 [F5]클릭시
	}
	
	//클라이언트 소켓이 메시지를 보냈을 때 [서버가 메시지 받기]
	@OnMessage
	//session : 누가 msg : 어떤 메세지
	public void OnMessage(Session session, String msg) throws IOException {
		System.out.println("클라이언트 웹 소켓이 메시지를 보냈다 [서버가 메세지를 받았다.]");
		System.out.println(msg);
		
		/*서버가 클라이언트 소켓에게 메시지 보내기*/
		//현재 서버소켓과 연결된 클라이언트 소켓 모두에게 서버가 받은 내용을 전달
		/*
		 * for(Session s : clientList.get) { s.getBasicRemote().sendText(msg); //->클라이언트
		 * 소켓 .onMessage }
		 */
	}
}
