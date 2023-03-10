package model.dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MemberDto {
	private int mno;
	private String mid;
	private String mpwd;
	private String mimg;
	private String memail;
	
	//1. 이메일 전송 메소드 [받는 사람 이메일, 받는 내용 HTML]
	public boolean sendEmail(String toEmail, String contentHTML) {
		//메일 인증 API
		
		//1) 보내는 사람의 정보
		String fromEmail = " 계정 아이디@호스트주소.com";
		String EmailPwd = " 계정 비밀번호";

		
		//2. 호스팅 설정[네이버 기준]
		Properties properties = new Properties();
		//계정에 2차 비밀번호 있는 경우 불가능!
//		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.host", "smtp.naver.com");
		properties.put("mail.smtp.port", 587); //동일
		properties.put("mail.smtp.auth", true); //동일
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); //동일
		
		
		//3. 인증 처리 [Session : java.mail]
		//Session.getDefaultInstance('properties', 인증 객체)
		//Authenticator [java.mail]
		Session session = Session.getDefaultInstance(
				properties,
				new Authenticator() {
					//패스워드 인증 함수를 오버라이딩
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(fromEmail, EmailPwd);
					};
				}
		);
		
		//4. 메일 보내기
		try {
			//Mime 프로토콜 : smtp가 보낼 수 있는 펴즌 형식[포맷]
			MimeMessage message = new MimeMessage(session); //인증된 세션을 대입해서 포맷
			message.setFrom(new InternetAddress(fromEmail)); //보내는 사람
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			
			//내용 구성
			message.setSubject("KGY Comunity 회원가입 메일 인증코드"); //메일 제목
			message.setText(contentHTML); //메일 내용
			
			//전송
			Transport.send(message);
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public MemberDto() {
		super();
	}

	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mimg=" + mimg + ", memail=" + memail
				+ "]";
	}
	
	
}
