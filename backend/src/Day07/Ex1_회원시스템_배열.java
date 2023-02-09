package Day07;

import java.util.Scanner;

public class Ex1_회원시스템_배열 {//class s
	public static void main(String[] args) {//main s
		
		Scanner scanner = new Scanner(System.in); //입력객체
		
		/* 문자열 [String] 3개를 저장할 수 있는 배열 선언 */
		/*{null, null, null} -> String은 클래스니까 빈 값에 자동으로 null이 들어감*/
		String[] memberList = new String[3];
		
		while(true) {//무한루프 [종료조건 : 없음]
			//2. 배열 내 데이터 출력
			System.out.println("번호 \t 회원명 \t 전화번호");
			for(int i = 0; i < memberList.length; i++) {
				if(memberList[i] != null) {
					String[] memberInfo = memberList[i].split(",");
					System.out.printf("%d \t %s \t %s \n", i, memberInfo[0], memberInfo[1]);
				}
			}
			
			System.out.print("1. 회원 등록  2. 회원 취소 >");
			int ch = scanner.nextInt(); //입력받은 값 저장 변수
			if(ch == 1) { //1. 회원 등록을 선택했을 때
				
				int check = 0;
				
				for(int i = 0; i < memberList.length; i++) {
					if(memberList[i] != null) {
						check++;
					}
				}
				if(check >= memberList.length) {
					System.err.println("[안내]회원이 꽉찼습니다.");
					continue;
				}
				
				// 출력 -> 입력 -> 저장
				System.out.print("회원명 : "); String name = scanner.next();
				System.out.print("전화번호 : "); String phone = scanner.next();
				
				//1. push 기능 만들기 [배열 내 빈공간[null] 찾기]
				for(int i = 0; i < memberList.length; i++) {
					if(memberList[i] == null) { //만약에 i번째 인덱스가 null 이면
						memberList[i] = name + "," + phone; //이름과 전화번호를 1개의 문자열로 합치기
						System.out.println(i + "번째 회원이 등록 되었습니다." + memberList[i]);
						break; // 3번 저장하지 않도록, 한번 저장했으면 break로 나가준다.
					}
				}
				
			}else if(ch == 2) { //2. 회원 취소를 선택했을 때
				System.out.print("삭제할 번호[인덱스] : "); int number = scanner.nextInt();
				//3. 배열 내 데이터 삭제/ splice 기능 [배열내 null로 만들기]
				memberList[number] = null;
				
				/*삭제후 빈자리 채우기 [삭제된 인덱스 뒤로 한칸씩 당기기]*/
				for(int i = number; i < memberList.length; i++) {
					
					/*마지막 인덱스이면 마지막 인덱스에 null 넣기*/
					if(i+1 == memberList.length) {//마지막 인덱스를 넘어서면 for문을 나와야한다.
						memberList[i] = null; //앞으로 다 당겼으니 마지막 인덱스는 마지막-1 인덱스와 겹칠 것! -> 삭제해주면 됨~
						break;
					}
					
					if(memberList[i] == null) {
						memberList[i] = memberList[i+1];
					}
					
					if(memberList[i+1] == null) {break;} //다음 인덱스가 null이면 종료
				}
			}else {// 그외.
				
			}
			
		}//while e
		
	}//main e
}//class e
