package 과제.과제4_싱글톤.contoller;

import java.util.ArrayList;

import 과제.과제4_싱글톤.model.Board;

public class BController {
	private ArrayList<Board> boardList = new ArrayList<>();
	
	//* 싱글톤
	private static BController bc = new BController();
	private BController() {};
	public static BController getInstance() {
		return bc;
	}
	
	//1. 글쓰기
	public boolean write(String title, String content) {
		//1. 유효성 검사 [로그인 안되어있으면 나가기]
		if(MController.getInstance().getLogSeasion() == null){
			return false;
		}
		
		//2. DB 저장 [ 로그인이 되어있으면 ] => board가 member을 알고, member가 board를 안다. => 양방향
		// * 이런 식으로 하면 반복문이 필요없음! => 즉, 빠르다!!!
			//1) 객체화 [글작성 : 입력받은 데이터 2개, 초기값 0, 로그인한 회원 객체 = 글쓴이]
		Board board = new Board(title, content, 0, MController.getInstance().getLogSeasion());
			//2) boardList[DB]에 저장
		boardList.add(board);
			//3) 멤버 객체에 내가 쓴 글 등록
		MController.getInstance().getLogSeasion().getBoardlist().add(board);
		return true;
	}
	
	//2. 글출력
	public ArrayList<Board> getList(){
		//추후 검색처리. 페이징처리 등록 로직이 들어갈 예정
		return boardList;
	}
	
	//3. 글 상세
	public Board getBoard(int bno) {
		boardList.get(bno).setView(boardList.get(bno).getView()+1); //조회수 증가
		
		return boardList.get(bno); //인수로 전달받은 인덱스[게시물 번호]의 게시물을 반환
	}
	
	//4. 글 삭제
	public boolean delete(int bno) {
		boardList.remove(bno); //인수로 전달받은 인덱스[게시물 번호]의 게시물 삭제
		return true;
	}
	
	//5. 글 수정
	public boolean update(int bno, String title, String content) {
		boardList.get(bno).setTitle(title); //인수로 전달받은 인덱스[게시물번호]의 게시물 제목 수정
		boardList.get(bno).setContent(content); //인수로 전달받은 인덱스[게시물 번호]의 게시물 내용 수정
		return true;
	}
}

/*

	5. 글쓰기 처리 
	인수 : title , content			반환 : true성공 , false실패 
	
	6. 글출력 데이터 반환
	인수 : x [ 페이징처리 , 검색처리 ]		반환 : 모든글이 담긴 arraylist<board>
	
	7. 글상세 데이터 반환  
	인수 : 글번호			반환 : 글 하나 board 
	*조회수 증가 
	
	8. 글삭제 처리 
	인수 : 글번호			반환 : true 성공 , false 실패
	
	9. 글수정 처리
	인수 : 글번호 , 새로운제목 , 새로운내용	반환 : true 성공 , false 실패 
	
	10.로그아웃 처리 
	인수 : x				반환 : true 성공 , false 실패 
*/