package controller.admin;

import java.lang.reflect.Member;
import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.dao.MemberDao;
import model.dto.ClientDto;

@ServerEndpoint("/alarm/{mid}")
public class Alarm {
	
	private static ArrayList<ClientDto> noticelist = new ArrayList<>();
	
	@OnOpen //클라이언트 소켓이 들어왔을 때 매핑 [연결]
	public void enterSever(Session session, @PathParam("mid") String mid) throws Exception{
		noticelist.add(new ClientDto(session, mid));
	}
	
	@OnClose //클라이언트 소켓이 나갔을 때 매핑 [연결]
	public void outServer(Session session) throws Exception{
		System.out.println(session);
		for(ClientDto dto : noticelist) {
			if(dto.getSession() == session) {
				noticelist.remove(dto);
			}
		}
	}
	
	@OnError //클라이언트 소켓이 에러가 발생했을 때 매핑 [연결] => Throwable : 오류 메시지를 담는 매개변수[필수로 정의할 인수]
	public void errorServer(Session session, Throwable e) throws Exception {
		System.out.println(session);
		//Throwable 쓰는 이유
		/*
		  	OnError로 annotate된 클래스 [controller.admin.Alarm]의 메소드 [errorServer]에 Throwable 파라미터가 없습니다.
		 */
	}
	
	//static : 정적이라 어디서든 쓰는 거 가능 => 가장 먼저 실행 static있는 것부터 정의/실행
	@OnMessage //클라이언트 소켓이 메시지를 보냈을 때 매핑 [연결] => onMessage를 할때 매개변수 값![필수로 정의할 인수]
	public static void messageServer(Session session, String msg) throws Exception{
		
		// 서블릿에 Alarm.messageServer(null, tomno+","+ncontent );을 받기 때문
		int tomno = Integer.parseInt(msg.split(",")[0]);
		
		//메시지 내용
		String toncontent = msg.split(",")[1];
		
		for(ClientDto dto : noticelist) {
			int cmno = MemberDao.getInstance().getMember(dto.getMid()).getMno();
			if(cmno == tomno) { // 받는 회원 번호가 명단에 존재하면
				dto.getSession().getBasicRemote().sendText(toncontent);
			}
			
		}
		
	}
	
}

/*

   Session session : 요청한 클라이언트 소켓의 변수
   Throwable e  : 에러 발생시 에러이유가 저장된 변수
   String msg : 요청받은 메시지 내용
 
   서버소켓
   	1) @ServerEndpoint('서버소켓경로/{매개변수명1}/{매개변수명2}")
   	2) @OnOpen 필수 매개변수  : Session session
   	3) @OnClose 필수 매개변수 : Session session
   	4) @OnError 필수 매개변수 : Session session, Throwable e
   	5) @OnMessage 필수 매개변수 : Session session, String s
  	6) @@PathParam("경로상의/{매개변수명}") : 경로상의 변수 요펑
*/
