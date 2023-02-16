package 과제.자율미니프로젝트.controller;

import java.util.ArrayList;

import 과제.자율미니프로젝트.model.Subject;

public class SubController {
	private ArrayList<Subject>subjectDB = new ArrayList<>();
	
	//* 싱글톤
	private static SubController sc = new SubController();
	private SubController() {}
	
	public static SubController getInstance() {
		return sc;
	}
	
	/*글 출력을 위해 */
	public ArrayList<Subject> getList(){
		return subjectDB;
	}
	
	/*수강 신청 처리*/
	public void enrollSubject(int suno, String subject, int mno) {
		Subject enrollTarget = new Subject(suno, subject, mno);
		
		SubController.getInstance().getList().add(enrollTarget);
		
		for(int i = 0; i < StuController.getInstance().getList().size(); i++) {
			if(mno == StuController.getInstance().getList().get(i).mno) {
				 StuController.getInstance().getList().get(i).enrollSubjectList.add(enrollTarget);
			}
		}
		
	}
	
	/*점수 확인*/
	public int checkScore(String checkSN, int mno) {
		
		for(int i = 0; i < StuController.getInstance().getList().size(); i++) {
			if(StuController.getInstance().getList().get(i).mno == mno) {
				for(int j = 0; j < SubController.getInstance().getList().size(); j++) {
					if(SubController.getInstance().getList().get(j).subject.equals(checkSN)) {
						return returnScore(SubController.getInstance().getList().get(j).mno, SubController.getInstance().getList().get(j).suno);
					}
				}
			}
		}
		return -1; //찾지 못했을 경우
	}
	
	/*점수 반환 메소드*/
	public int returnScore(int mno, int suno) {
		for(int i =0; i < ScoreController.getInstance().getList().size(); i++) {
			if(ScoreController.getInstance().getList().get(i).mno == mno && ScoreController.getInstance().getList().get(i).suno == suno) {
				return ScoreController.getInstance().getList().get(i).score;
			}
		}
		return -1; //점수를 찾지 못했을 경우
	}
	
	
}
