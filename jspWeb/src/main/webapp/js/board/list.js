
// * pageObject : 현재 페이지, 검색, 전송타입 보관된 객체
let pageObject = {
	page : 1, // page : 표시할 페이지 번호
	key : "",
	keyword : "",
	type : 1, //1. 전체 출력 2. 개별 출력
	cno : document.querySelector('.cno').value
}

// -- 카테고리 제목 넣어주기
let cnameHTML = '';

if(pageObject.cno == 1){
	cnameHTML = '공지사항';
}else if(pageObject.cno == 2){
	cnameHTML = '커뮤니티'
}else if(pageObject.cno == 3){
	cnameHTML = 'QnA'
}else if(pageObject.cno == 4){
	cnameHTML = '노하우'
}

document.querySelector('.cname').innerHTML = cnameHTML +" 목록";
console.log(pageObject)
printBoard(1); //처음 열릴때는 페이지 1 기본값
//게시글 출력하기
function printBoard(page){//해당함수로부터 페이징번호 받기

	pageObject.page = page; //받아온 페이지 바꿔준다.

	$.ajax({
		url : "/jspWeb/board/info",
		method : "get",
		data : pageObject,
		success : (r) => {
			//------------------------ 테이블 출력 ------------------------
			console.log(r)
			if(r != null){
				let html = `<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>작성자</th>
								<th>좋아요</th>
								<th>싫어요</th>
							</tr>`
			r.boardList.forEach((o) => {
				html += `<tr> 
							<td>${o.bno}</td>
							<td><a href = "/jspWeb/board/view.jsp?bno=${o.bno}">${o.btitle}</a></td>
							<td>${o.bwritedate}</td>
							<td>${o.bview}</td>
							<td>${o.mid}</td>
							<td>${o.blike}</td>
							<td>${o.bhate}</td>
						 </tr>`
			})	
			document.querySelector('.boardTable').innerHTML = html
				
			}else{
				alert('게시물을 조회할 수 없습니다.')
			}
			//----------------------- 페이징 버튼 출력 -----------------------
			html ='';//기존에 들어있는 내용 제거
			
			//맨앞
			html += `<button onClick = "printBoard(1)" type = "button">맨앞</button>`	;
			
			//이전버튼 [만약에 이전 페이지가 1 혹은 1 이하이면 더이상 이전페이지 없음]
			html += page <=1 ? 
				`<button onClick = "printBoard(${page})" type = "button">이전</button>`	
				:
				`<button onClick = "printBoard(${page-1})" type = "button">이전</button>`	;
			
			//페이징 버튼 번호들
			for(let i = r.startBtn; i <= r.endBtn; i++){ //시작 버튼 번호부터 마지막 버튼 번호까지 버튼 생성
				html += `
					<button onClick = "printBoard(${i})" type = "button">${i}</button>`	
			}
			
			//다음버튼 [만약에 다음 페이지가 totalpage 혹은 totalpage 이상이면 더이상 다음페이지 없음]
			html += page >= r.totalpage ?
			` <button onClick = "printBoard(${page})" type = "button">다음</button>`	
			:	
			` <button onClick = "printBoard(${page+1})" type = "button">다음</button>`	
			
			//맨뒤
			html += `<button onClick = "printBoard(${r.totalpage})" type = "button">맨뒤</button>`;
			
			document.querySelector('.pageBox').innerHTML = html;
			
		} //sucess 끝나는 구역
	})//ajax끝나는 구역
}

//2. 검색 조회
function getSearch(){
	//검색이랑 페이징이랑 같이 사용해야한다.
	// * 입력받은 데이터를 전역객체 필드에 대입
	pageObject.key = document.querySelector('.key').value;
	pageObject.keyword = document.querySelector('.keyword').value;
	
	// 게시물 호출
	printBoard(1); //검색 결과에 맞는 1페이지
}
/*
	1. 클릭한 pk[식별자] 이동하는 경우의 수
		1) HTTP 이용한 PK 이동 [HTTP get메소드 방식의 a태그 이용한 pk 이동 방식]
			<a href = "/jspWeb/board/view.jsp?bno=${o.bno}">
			<a href = "/jspWeb/board/view.jsp?변수명=데이터">
			<a href = "/jspWeb/board/view.jsp?변수명=데이터&변수명=데이터">
			http://localhost:8080/jspWeb/board/view.jsp?bno=1
 */
