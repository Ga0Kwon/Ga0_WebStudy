package model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.Chatting;
import model.dao.MemberDao;

public class MessageDto {
	//session은 json형식을 지원하지 않기 때문에 만들 수 없음
	//private Session fromSession;
	private String fromMid;
	private String frompimg;
	private String msg;
	private String time;
	/* private String roompk; */
	
	
	public MessageDto() {
		super();
	}

	//클라이언트에게 메세지를 보낼때 사용하는 생성자
	public MessageDto(Session fromSession, String msg) {
		super();
		//this.fromSession = fromSession;
		//메시지를 보낸 클라이언트 세션을 통해 회원 아이디 얻기
		for(ClientDto dto : Chatting.clientList) {
			if(dto.getSession() == fromSession) {
				this.fromMid = dto.getMid();
			}
		}
		
		//보낸 사람의 프로필 얻기
		this.frompimg = MemberDao.getInstance().getMember(this.fromMid).getMimg();
		this.msg = msg;
		//메시지가 생성된 날짜 a하나 넣으면 영문으로 나오고 a 두개 넣을 시 한글
		this.time = new SimpleDateFormat("aa hh:mm").format(new Date());
	}


	/*
	 * public Session getFromSession() { return fromSession; }
	 * 
	 * 
	 * public void setFromSession(Session fromSession) { this.fromSession =
	 * fromSession; }
	 */


	public String getFromMid() {
		return fromMid;
	}


	public void setFromMid(String fromMid) {
		this.fromMid = fromMid;
	}


	public String getFrompimg() {
		return frompimg;
	}


	public void setFrompimg(String frompimg) {
		this.frompimg = frompimg;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "MessageDto [fromMid=" + fromMid + ", frompimg=" + frompimg + ", msg="
				+ msg + ", time=" + time + "]";
	}
	
	
	
}
