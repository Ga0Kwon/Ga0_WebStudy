package 과제.과제4.controller;

import java.util.ArrayList;

import 과제.과제4.model.Member;

// * 처리 제어담당
public class MController {
	ArrayList<Member>memberList = new ArrayList<>();
	
	//1. 회원가입 로직
	public int signup(String id, String password, String cofirmPassword, String name, String phone) {
		int check = 0;
		
		for(int i = 0; i < memberList.size(); i++) {
			System.out.println();
			if(memberList.get(i).id.equals(id)) { //중복된 아이디 유효성 검사
				check++;
			}
		}
		
		if(check == 0) {
			if(password.equals(cofirmPassword)) {
				Member member = new Member(id, password, name, phone); // 객체 생성
				
				memberList.add(member);
				return 0;
				
			}else { //비밀번호가 다르다는 뜻
				return 1; // 실패 [ 회원 가입]
			}
		}else { //아이디가 중복되었을 경우
			return 2;
		}
		
		
	}
	
	//2. 로그인 로직
	public int login(String id, String password) {
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).id.equals(id)) {
				if(memberList.get(i).password.equals(password)) {
					return i; //로그인 성공시 [회원 인덱스]
				}else { //패스워드가 다를 경우
					return -1;
				}
			}else { //아이디가 다를 경우
				return 2;
			}
		}
		return 3; 
	}
	
	//3. 아이디 찾기 로직
	public String findId(String name, String phone) {
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).name.equals(name)) {// 이름이 존재하면
				if(memberList.get(i).phone.equals(phone)) { //이름과 해당 전화번호가 맞다면
					return memberList.get(i).id;
				}
			}
		}
		return "0"; //알 수 없는 오류 => 왜냐 반복문 자체를 안돌았다는 말이니까
	}
	
	//4. 비밀번호 찾기 로직
	public String findPassword(String id, String phone) {
		for(int i = 0; i < memberList.size(); i++) {
			if(memberList.get(i).id.equals(id)) {//아이디가 존재하고
				if(memberList.get(i).phone.equals(phone)) {// 아이디와 전화번호가 매치된다면.
					return memberList.get(i).password;
				}
			}
		}
		return "0"; // 알수 없는 오류
	}
	
}
