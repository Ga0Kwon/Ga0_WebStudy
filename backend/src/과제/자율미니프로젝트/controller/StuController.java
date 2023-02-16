package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Student;

public class StuController {
	ArrayList<Student> studentDB = new ArrayList<>();
	
	//* 싱글톤
	private static StuController stuc = new StuController();
	private StuController() {}
	
	public static StuController getInstance() {
		return stuc;
	}
	
	/*Student arrayList를 반환하는 함수*/
	public ArrayList<Student> getList() {
		return studentDB;
	}
	
	
}
