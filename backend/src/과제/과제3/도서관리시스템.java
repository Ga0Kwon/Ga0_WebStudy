package 과제.과제3;

import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.Scanner;

public class 도서관리시스템 {// class s
	public static void main(String[] args) {// main s
		Scanner scanner = new Scanner(System.in); // 입력객체

		ArrayList<Book> bookList = new ArrayList<>(); // 리스트 선언에 사용되는 클래스[책]

		ArrayList<Member> memberList = new ArrayList<>();// 리스트 선언에 사용되는 클래스[회원]

		/*
		 * 관리자 계정은 미리 추가하기 위해 memberList.get(0).id = "admin"; //관리자 아이디 admin
		 * memberList.get(0).name = "관리자"; //관리자 이름 관리자 memberList.get(0).password =
		 * "1"; //관리자 비밀번호 1 memberList.get(0).phonenumber = "010-1234-1234"; // 관리자
		 * 전화번호 memberList.get(0).rentalBooks = null; //대여는 어찌되든 상관없으므로 null
		 */
		while (true) { //로그인 화면 무한반복 루프
			/*--------------------------추가 요구 사항 로그인 회원가입 란----------------------*/
			System.out.println("--------------- 이젠 도서관 ---------------");
			System.out.print("메뉴 > 1. 로그인 2. 회원 가입 : ");
			int memberChoice = scanner.nextInt(); // 1. 로그인 2. 회원 가입 중 선택 받기
			if (memberChoice == 1) { // 1. 로그인을 선택했을 경우
				if(memberList.size() == 0) {
					System.err.println("아직 회원이 없습니다.");
					continue;
				}
				boolean loginOk = false; // 로그인 여부를 저장하는 변수

				System.out.print("아이디 : ");
				
				String userId = scanner.next();
				System.out.print("비밀번호 : ");
				String userPassword = scanner.next();
				
				for (int i = 0; i < memberList.size(); i++) {
					if (memberList.get(i).id.equals(userId)) { // 아이디가 올바르고
						if (memberList.get(i).password.equals(userPassword)) { // 해당 인덱스의 비밀번호도 올바르다면,
							loginOk = true; // 로그인이 완료된것을 바깥에서 확인해야하기 때문에 변수에 저장
							System.out.println("로그인이 완료되었습니다. ");
						} else {
							System.err.println("[안내] 비밀번호가 올바르지 않습니다.");
						}
					} 
				}

				if (loginOk == true) { // login == true의 if s
					System.out.println("이젠 도서관에 오신 것을 환영합니다.");
					bookSystem : while(true) { //도서시스템 무한루프
						System.out.println("---------------------- 이젠 도서관 ---------------------");
						System.out.println("번호\t대여여부\t\t도서장르\t\t도서명\t\t대여한아이디");
						for (int i = 0; i < bookList.size(); i++) { // 번호, 대여여부, 도서 장르, 도서명 순으로 출력

							String rentalOX = ""; // 렌탈 여부를 문자열로 바꾸기 위한 변수
							String customerId = "";
							if (bookList.get(i).rentalOX == true) {// bookList.get(i).rentalOX이 true이면 대여 가능
								rentalOX = "대여가능";
								customerId = "-";
							} else {
								rentalOX = "대여중";
								customerId = bookList.get(i).customerId;
							}
							
							System.out.printf("%d \t %5s  %10s \t %10s \t %5s\n", i, rentalOX, bookList.get(i).bookCategory,
									bookList.get(i).bookname, customerId);
						}
						System.out.print("메뉴 > 1. 도서 대여 2. 도서 반납 3. 도서등록[관리자] : 4. 로그인화면");
						int bookChoice = scanner.nextInt();

						if (bookChoice == 1) { // 1. 도서 대여를 선택했을 경우
							System.out.print("대여할 도서 번호 선택 : ");
							int bookNo = scanner.nextInt();

							if (bookList.get(bookNo).rentalOX != false) { // 만약 해당 번호의 도서가 대여중이지 않을 경우
								bookList.get(bookNo).rentalOX = false; // 대여중으로 바꿔준다.
								bookList.get(bookNo).customerId = userId;
								/*
								 * 해당 사용지의 member 객체 rentalBooks 목록에 해당 책이름을 저장해줘야함 현재 가지고 있는 정보가 userId와
								 * userPassword뿐 -> 하지만 userId는 중복값을 가지지 못하도록 유효성검사를 했기 때문에 식별이 가능하다.
								 */
								for (int i = 0; i < memberList.size(); i++) {
									if (memberList.get(i).id == userId) { // 사용자 userId 로 해당 사용자 정보 찾기
										for (int j = 0; j < memberList.get(i).rentalBooks.length; j++) {
											if (memberList.get(i).rentalBooks[j] == null) { // member객체의 retalbook배열의 요소 값을
																							// 추가해주는 거니까
												memberList.get(i).rentalBooks[j] = bookList.get(bookNo).bookname; 
												// 해당 책이름을 해당 사용자 대여책 여부 목록에 넣어준다.
											}
										}
									}
								}
								System.out.println(bookList.get(bookNo).bookname + "이 대여 완료되었습니다.");
							} else {
								System.err.println(bookList.get(bookNo).bookname + "은 현재 대여중인 책입니다.");
							}

						} else if (bookChoice == 2) { // 2. 도서 반납을 선택했을 경우
							System.out.print("반납할 도서 번호 선택 : ");
							int bookNo = scanner.nextInt();
							/*반납은 책을 빌린사람만 반납할 수 있다.*/
							
							if (bookList.get(bookNo).rentalOX == false) { // 만약 해당 번호의 도서가 대여중일 경우

								/* 대여와 반납은 동일 하다 위와 같은 맥락으로 해주면 됨 -> 대신 null하고 앞으로 당겨줘야함. */
								for (int i = 0; i < memberList.size(); i++) {
									if (memberList.get(i).id == userId) { // 사용자 userId 로 해당 사용자 정보 찾기
										for (int j = 0; j < memberList.get(i).rentalBooks.length; j++) {
											/* member 객체에 있는 rentalBooks목록에서 입력받은 번호의 책이름과 같다면 */
											if (memberList.get(i).rentalBooks[j] == bookList.get(bookNo).bookname) {
												memberList.get(i).rentalBooks[j] = null; // 해당 인덱스의 값을 null로 바꿔주면 된다.
												bookList.get(bookNo).rentalOX = true; // 대여가능으로 바꿔준다.
											}
										}
										/* 삭제를 했다면 빈 값이 놓이게 되는데 그럴 경우 당겨줘야한다. */
										for (int j = 0; j < memberList.get(i).rentalBooks.length; j++) {
											if (j + 1 == memberList.get(i).rentalBooks.length) {// i+1값이 끝을 넘어선다면
												// 삭제하면 어차피 끝에 한개가 비어져야한다. 즉 마지막에 도달하면 null
												memberList.get(i).rentalBooks[j] = null;
												break;
											}

											if (memberList.get(i).rentalBooks[j] == null) {// 해당 인덱스의 rentalBoolks 값이 null이면
																							// [즉, 삭제 or 객체의 끝까지 갔다는 뜻!]
												memberList.get(i).rentalBooks[j] = memberList.get(i).rentalBooks[j + 1]; // 뒤의
																															// 값을
																															// 앞에
																															// 값에
																															// 넣어줌.
											}

											if (memberList.get(i).rentalBooks[j + 1] == null) {// 다음 인덱스가 null이라는 것은 더이상 당길
																								// 데이터가 없다는 뜻
												break;
											}
											
										}
										
										System.out.println(bookList.get(bookNo).bookname + "이 반납 완료되었습니다.");
										
									}else { //해당 userId가 아닌 경우
										System.err.println(userId + "사용자님께서 대여한 책이 아닙니다. ");
										break;
									}
								}
							} else {
								System.err.println(bookList.get(bookNo).bookname + "은 이미 대여 가능한 책입니다.");
							}
						} else if (bookChoice == 3) { // 3. 도서 등록[관리자]를 선택했을 경우
							if (userId.equals("admin")) { // 관리자일 경우
								scanner.nextLine();
								System.out.print("도서명 : ");
								String bookTitle = scanner.nextLine();
								System.out.print("카테고리 : ");
								String bookCategory = scanner.next();

								Book book = new Book(); // Book 객체 생성
								book.bookname = bookTitle;
								book.bookCategory = bookCategory; // 입력받은 책 이름과 책 카테고리를 저장하고
								book.rentalOX = true; // 등록 중일때는 대여 불가능 -> 즉, 기본 값이 true(대여가능)

								bookList.add(book); // 객체를 넣어준다.
								System.out.println(book.bookname + "해당 도서가 등록 완료 되었습니다.");
							} else {
								System.err.println("[안내] 해당 권한을 가지고 있지 않습니다. 관리자에게 문의하세요.");
							}

						} else if(bookChoice == 4){ //4. 로그인 화면 선택했을시
							System.out.println("로그인화면으로 돌아갑니다.");
							break bookSystem;
						}else {
							System.err.println("[안내] 1~3번중에 선택해주세요.");
						}
					}
					
				} // 로그인 여부가 true일 경우의 if e
			} else if (memberChoice == 2) { // 2. 회원 가입을 선택했을 경우
				int check = 0; // 유효성 검사를 위한 변수 check
				scanner.nextLine();
				System.out.print("아이디 : ");
				String userId = scanner.nextLine(); // 아이디
				System.out.print("비밀번호 : ");
				String userPassword = scanner.next(); // 비밀번호
				System.out.print("이름 : ");
				String userName = scanner.next(); // 이름
				System.out.print("전화번호 : ");
				String userPhoneNumber = scanner.next(); // 전화번호

				for (int i = 0; i < memberList.size(); i++) { // memberList 사이즈만큼 반복문
					if (memberList.get(i).id == userId) { // 이미 존재하는 아이디이면
						check++;
						System.err.println("[안내]이미 등록된 아이디입니다.");
					}
				}

				if (check == 0) { // 유효성 검사를 통과했을 경우
					Member member = new Member();
					member.id = userId;
					member.password = userPassword;
					member.name = userName;
					member.phonenumber = userPhoneNumber;
					member.rentalBooks = null; // 회원 가입이기 때문에 현재 대여한 책이 없으므로 null

					memberList.add(member);
					System.out.println("회원가입이 완료되었습니다.");
				} // if check == 0 e

			} else {
				System.err.println("[안내] 1~2번중에 선택해주세요.");
			}

		}

	}// main e
}// class e
