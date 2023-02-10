package 과제.과제4.model;

public class Board {
	public int no;
	public int view;
	public String writer;
	public String title;
	public String content;
	
	
	public Board() {}


	public Board(String writer, int view, String title, String content) {
		this.writer = writer;
		this.view = view;
		this.title = title;
		this.content = content;
	}


	public Board(int no, int view) {
		this.no = no;
		this.view = view;
	}
	
	
	
}
