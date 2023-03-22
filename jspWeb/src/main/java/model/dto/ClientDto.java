package model.dto;

import javax.websocket.Session;

public class ClientDto {
	//세션과 String을 저장하는 ClientDto
	private Session session;
	private String mid;
	
	//채팅방까지 만들려면 채팅방 필드도 만들어야함
	
	public ClientDto() {
		super();
	}
	
	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", mid=" + mid + "]";
	}
	
	
}
