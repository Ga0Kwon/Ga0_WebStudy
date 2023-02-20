package 과제.자율미니프로젝트.view;

import java.util.Scanner;

import 과제.자율미니프로젝트.controller.MController;
import 과제.자율미니프로젝트.controller.StuController;
import 과제.자율미니프로젝트.controller.SubController;
import 과제.자율미니프로젝트.model.Student;
import 과제.자율미니프로젝트.model.Subject;

public class Front {
	private Scanner scanner = new Scanner(System.in);
	
	//*싱글톤
	private static Front front = new Front();
	private Front() {};
	public static Front getInstance() {
		return front;
	}
	
	/*첫 페이지*/
	public void index() {
		while(true) {
			System.out.println("-----------------학사관리시스템-----------------");
			System.out.print("1. 로그인 2. 아이디 찾기 3. 비밀번호 찾기");
			int choice = scanner.nextInt();
			if(choice == 1) {//1. 로그인
				login_page();
			}else if(choice == 2) {//2. 아이디 찾기
				findId_page();
			}else if(choice == 3) { //3. 비밀번호 찾기
				findPw_page();
			}
		}
	}
	
	/*로그인*/
	public void login_page() {
		//1. 입력
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.println("비밀번호 : "); String pw = scanner.next();
		
		int result = MController.getInstance().logIn(id, pw);
		
		if(result == -1) { //비밀번호가 틀릴 경우
			System.err.println("[안내] 비밀번호가 올바르지 않습니다.");
		}else if(result == -2) {//해당 아이디가 없을 경운
			System.err.println("[안내] 해당 아이디를 찾을 수 없습니다.");
		}else { //그외
			System.out.println("[안내] 로그인 성공! 안녕하세요.");
			if(MController.getInstance().getLogSeasion().job == "학생") { //로그인한 사람이 학생일 경운
				printSubject(); //로그인 성공시
			}else if(MController.getInstance().getLogSeasion().job == "교수") {//로그인한 사람이 교수일 경운
				
			}else if(MController.getInstance().getLogSeasion().job == "관리자") {//로그인한 사람이 관리자일 경우
				
			}
		}
	}
	
	/*아이디 찾기*/
	public void findId_page() {
		//1. 입력
		System.out.print("이름 : "); String name = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		String result = MController.getInstance().findId(name, phone);
		
		if(result == null) {//해당 정보로 아이디를 못찾았을 경우
			System.out.println("[안내] 없는 회원입니다.");
		}else {
			System.out.println("[안내] 회원님의 아이디는 " + result + " 입니다.");
		}
	}
	
	
	/*비밀번호 찾기*/
	public void findPw_page() {
		//1. 입력
		System.out.print("아이디 : "); String id = scanner.next();
		System.out.println("전화번호 : "); String phone = scanner.next();
		
		String result = MController.getInstance().findPw(id, phone);
		
		if(result == null) {//해당 정보로 아이디를 못찾았을 경우
			System.out.println("[안내] 없는 회원입니다.");
		}else {
			System.out.println("[안내] 회원님의 비밀번호는 " + result + " 입니다.");
		}
	}
	
	/*----------------------------------학생------------------------------*/
	/*과목 리스트 출력*/
	public void printSubject() {
		while(true) {
			System.out.println("--------------------강의 목록-------------------");
			System.out.println("번호\t\t 과목 \t\t\t 교수명");
			for(int i = 0; i <SubController.getInstance().getList().size(); i++) {
				Subject subject = SubController.getInstance().getList().get(i);
				
				System.out.printf("%d\t\t%s\t\t\t%s\n",
						i, 
						subject.subject,
						findName(subject.mno));
			}
			System.out.println("----------------------------------------------");
			System.out.print("1. 수강 신청 2. 수강 리스트 3. 로그아웃 : ");
			int choice = scanner.nextInt();
			
			if(choice == 1) { //1. 수강 신청
				System.out.println("수강신청 과목 번호 : ");
				int index = scanner.nextInt();
				enrollSubject(SubController.getInstance().getList().get(index));
			}else if(choice == 2) {//2. 수강 리스트
				
			}else if(choice == 3) {//3. 로그아웃
				return;
			}
		}
	}
	
	/*수강 신청 */
	public void enrollSubject(Subject subject) {
		
		SubController.getInstance().enrollSubject(subject.suno, subject.subject, MController.getInstance().getLogSeasion().mno);
		
	}
	
	/*학생이 수강신청한 목록을 보여주는 메소드*/
	public void printEnrollSubject() {
		System.out.println("-------------------수강 신청 목록-------------------");
		System.out.println("번호 \t\t 과목명 \t\t 교수명 ");
		for(int i = 0; i < StuController.getInstance().getList().size(); i++) {
			Student student = StuController.getInstance().getList().get(i);
			if(student.mno == MController.getInstance().getLogSeasion().mno) {
				for(int j = 0; j < student.enrollSubjectList.size(); j++) {
					System.out.printf("%d \t\t %s \t\t\t %s",
							j,
							student.enrollSubjectList.get(i).subject,
							findName(student.enrollSubjectList.get(i).mno));
				}
			}
		}
		System.out.println("--------------------------------------------------");
		System.out.print("점수 확인 할 과목명 : ");
		String checkSN = scanner.next();
		int result = SubController.getInstance().checkScore(checkSN, MController.getInstance().getLogSeasion().mno);
		
		if(result == -1) {//점수 찾지 못했을 경우
			System.err.println("[안내] 점수를 찾지 못했습니다.");
		}else {
			System.out.println(checkSN + "의 점수는 " + result + "입니다.");
		}
	}
	
	
	/*회원 번호로 이름 찾는 메소드*/
	public String findName(int mno) {
		for(int i = 0; i < MController.getInstance().getList().size(); i++) {
			if(MController.getInstance().getList().get(i).mno == mno) {
				return MController.getInstance().getList().get(i).name;
			}
		}
		return null; //해당 회원을 찾을 수 없을 경우
	}
	
	/*----------------------------------교수------------------------------*/
	/*---------------------------------관리자------------------------------*/
	
}
