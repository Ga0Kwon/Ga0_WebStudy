package Day09.Ex10_게시판.model;

import java.util.ArrayList;
import java.util.Date;

/*
  	클래스 model 클래스 만들기
  		1. 필드 선정
  		2. 모든 필드는 private
  		3. 생성자  [1. 빈 , 2. 풀]
  		4. 메소드 [toStrint(), getter, setter]
  
 */
public class Board {//class s
	//1. 필드
	private String title;
	private String content;
	private String password;
	private String wirter;
	private Date date; //작성일
	private int view; //조회수
//	ArrayList<reply> list = new ArrayList<>(); // 댓글
	
	
	//2. 생성자
		//1) 빈생성자
	public Board() {}

		//2) 풀생성자
	public Board(String title, String content, String password, String wirter, Date date, int view) {
		this.title = title;
		this.content = content;
		this.password = password;
		this.wirter = wirter;
		this.date = date;
		this.view = view;
	}


	//3. 메소드
	
	@Override
	public String toString() {
		return "Board [title=" + title + ", content=" + content + ", password=" + password + ", wirter=" + wirter
				+ ", date=" + date + ", view=" + view + "]";
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWirter() {
		return wirter;
	}

	public void setWirter(String wirter) {
		this.wirter = wirter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}
		
}//class e
