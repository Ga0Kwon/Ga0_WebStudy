
printBoard();
//게시글 출력하기
function printBoard(){
	$.ajax({
		url : "/jspWeb/board/info",
		method : "get",
		data : {"type" : 1}, //1. 전체 출력 2. 개별 출력
		success : (r) => {
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
			r.forEach((o) => {
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
		}
	})
}


/*
	1. 클릭한 pk[식별자] 이동하는 경우의 수
		1) HTTP 이용한 PK 이동 [HTTP get메소드 방식의 a태그 이용한 pk 이동 방식]
			<a href = "/jspWeb/board/view.jsp?bno=${o.bno}">
			<a href = "/jspWeb/board/view.jsp?변수명=데이터">
			<a href = "/jspWeb/board/view.jsp?변수명=데이터&변수명=데이터">
			http://localhost:8080/jspWeb/board/view.jsp?bno=1
 */
