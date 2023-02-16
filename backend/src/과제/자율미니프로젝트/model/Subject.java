package 과제.자율미니프로젝트.model;

public class Subject {
	public int suno;
	public String subject;
	
	public int mno;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(int suno, String subject, int mno) {
		super();
		this.suno = suno;
		this.subject = subject;
		this.mno = mno;
	}

	@Override
	public String toString() {
		return "Subject [suno=" + suno + ", subject=" + subject + ", mno=" + mno + "]";
	}
	
}
