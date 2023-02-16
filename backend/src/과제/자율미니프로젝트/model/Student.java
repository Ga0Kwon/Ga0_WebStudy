package 과제.자율미니프로젝트.model;

import java.util.ArrayList;

public class Student extends Member {
	//* 필드
	public String job;
	
	public ArrayList<Subject> enrollSubjectList; //수강신청한 목록 리스트
	
	public Student(){};
	
	public Student(int mno, String id, String pw, String name, String phone) {
		super(mno, id, pw, name, phone, "학생");
	}
}
