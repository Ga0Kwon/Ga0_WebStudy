package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Score;

public class ScoreController {
	ArrayList<Score>scoreDB = new ArrayList<>();
	
	//* 싱글톤
	private static ScoreController score = new ScoreController();
	private ScoreController() {}
	
	public static ScoreController getInstance() {
		return score;
	}
	
	/*Score arrayList를 반환하는 함수*/
	public ArrayList<Score> getList() {
		return scoreDB;
	}
	
}
