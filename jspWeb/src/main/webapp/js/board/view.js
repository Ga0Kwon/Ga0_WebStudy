/*alert('view js 실행')*/

//bno가져오기
let bno = document.querySelector('.bno').value;

/*로그인 안했다면 댓글 달기 X */
if(memberInfo.mid == null){
	document.querySelector('.rcontent').disabled = true;
	document.querySelector('.replyBtn').disabled = true;
	document.querySelector('.rcontent').innerHTML = '로그인 후에 댓글 작성 가능합니다.'
}

getBoard()

//해당 게시물 호출
function getBoard(){
	$.ajax({
		url : "/jspWeb/board/info",
		method : "get",
		data : {"type" : 2, "bno" : bno}, //1. 전체 출력 2. 개별 출력
		success : (r) => {
			
			if(r.mid != null){
				
				document.querySelector('.mimg').src = `/jspWeb/member/pimg/${r.mimg == null ? 'basic.jsp' : r.mimg}`
				document.querySelector('.mid').innerHTML = r.mid;
				document.querySelector('.bwritedate').innerHTML = r.bwritedate;
				document.querySelector('.bview').innerHTML = r.bview;
				document.querySelector('.blike').innerHTML = r.blike;
				document.querySelector('.bhate').innerHTML = r.bhate;
				
				document.querySelector('.btitle').innerHTML = r.btitle;
				document.querySelector('.bcontent').innerHTML = r.bcontent;
			
				
				document.querySelector('.replycount').innerHTML = r.rcount+"개의 댓글";
				
				if(r.bfile == null){ //첨부파일 없으면
					document.querySelector('.bfile').innerHTML = '첨부파일 없음';
				}else{//첨부파일 있을 때
					html = `<button class ="bfilebtn" onClick = "bfileDownload('${r.bfile}')" type = "button"><i class="fas fa-download"></i> ${r.bfile}</button>`
					document.querySelector('.bfile').innerHTML = html;
				}
				
			}else{
				alert('정보를 조회할 수 없습니다.')
			}
			
			//로그인된 회원과 작성자가 일치하면 삭제함
			if(memberInfo.mid == r.mid){
				let html = `<button class = "bbtn bupdatebtn" onClick ="bDelete(${r.bno}, ${r.cno})" type = "button">삭제</button>
							<button class = "bbtn bdeletebtn" onClick ="bUpdate(${r.bno})"  type = "button">수정</button>`;
				document.querySelector('.btnBox').innerHTML = html;
			}
			getReplayList(); //다 출력하면 댓글 출력
		}
	})
}
/*
	1. onClick = JS 코드 작성 구역
	
		<button onClick = "bfileDownload(${r.bfile})"
			짱구4.jpg [문자처리를 안하면 .연산자가 실행되가지고, 에러가 난다.]
		<button onClick = "bfileDownload('${r.bfile}')"
		 '짱구4.jpg' -> 작은따옴표나 통해 문자열로 처리해준다. [큰따옴표를 이미 쓰고 있으므로.. 작은따옴표]

	2. 전송 방법
		HTML : 1. <form> 2. <a href = "">
		JS : 1. location.href = ""
		JQUERY : 1.$.ajax({})
		servlet : 1. response.getWriter.print(문자데이터);
				  2. response.sendRedirect('경로');
				  
*/

//첨부파일 다운로드
function bfileDownload(bfile){
	
	/*$.ajax({
		url : "/jspWeb/filedownload",
		method : "get",
		data : {"bfile" : bfile},
		success : (r) =>{
			console.log(r);
			
		}
	})*/
	
	location.href = "/jspWeb/filedownload?bfile=" + bfile;
	
}

 bIncrease( 1 ); //해당 스크립트가 열리는 순간 조회수는 증가 
// 3. 조회수 좋아요수 싫어요수
function bIncrease( type ){

	let kind = '';
	//type 구분
	if(type == 2){
		kind = '좋아요';
	}else if(type == 3){
		kind = '싫어요';
	}
	//1. 현재 게시물의 번호 [증가할 대상]
	let bno = document.querySelector('.bno').value;
	//2. 
	
	$.ajax({
		url : "/jspWeb/board/view",
		method : "get",
		data : {"type" : type, "bno" : bno},
		success : (r) => {
			getBoard();
			if(r == 'true'){
			}else if(r == '-1'){
				if(type != 1){
					alert(kind + '는 이미 처리하였습니다. [24시간후에 다시 처리해주세요.]')	
				}
			}
		}
	})
}

//삭제
function bDelete(bno, cno){
	$.ajax({
		url : "/jspWeb/board/info",
		method : "delete",
		data : {"bno" : bno, "type" : 1}, //다 삭제
		success : (r) => {
			if(r == 'true'){
				alert('삭제 성공')
				location.href = `/jspWeb/board/list.jsp?cno=${cno}&bno=${bno}`;
			}else{
				alert('삭제할 수 없습니다. 관리자에게 문의해주세요.')
			}
		}
	})
}

//수정 [수정 페이지 이동]
function bUpdate(bno){
	location.href = `/jspWeb/board/update.jsp?bno=${bno}`;
}


//게시물 작성자의 정보를 확인하기[인수 mno]
function friendInfo(mno){
	
	$.ajax({
		url : "/jspWeb/member"
	})
	
}

//댓글 달기 [상위 댓글]
function rWrite(){
	let rcontent = document.querySelector('.rcontent').value;
	
	
	$.ajax({
		url : "/jspWeb/board/replay",
		method : "post",
		/*type = 1 상위 댓글 */
		data : {"type": 1, "bno" : bno, "rcontent" : rcontent},
		success : (r) => {
			console.log(r);
			if(r = 'true'){
				alert('댓글이 작성되었습니다.')
				/*부분적 렌더링*/
				$(".replayListBox").load(location.href+' .replayListBox');
				/*loaction.reload();*/ // 현재 페이지 새로 고침
			}else{	
				alert('댓글 작성에 실패 하였습니다. 관리자에게 문의해주세요.')
			}
		}
	})
}

//댓글 출력
function getReplayList(){
	
	$.ajax({
		url : "/jspWeb/board/replay",
		method : "get",
		data : {"type" : 1, "bno" : bno},
		success : (r) => {

			let html = ``;
			
			if(r != null){
				r.forEach((o) => {
					html += `
						<div>
							<span>${o.mimg}</span>
							<span>${o.mid}</span>
							<span>${o.rdate}</span>
							<span>${o.rcontent}</span>
							<button onClick = "rereplayview(${o.rno})"type = "button">대댓글보기</button>
							<div class = "rereplyBox${o.rno}"></div>
						</div>`
					
				})
			}
			
			document.querySelector('.replayListBox').innerHTML = html;
		}
	})
}

//대댓글 다는 창 출력하기
function rereplayview(rno){
	let html = ``;
	$.ajax({
		url : "/jspWeb/board/replay",
		method : "get",
		data : {"type" : 2, "rno" : rno, "bno" : bno},
		success : (r) =>{
			console.log(r)
			if(r != null){
				r.forEach((o) => {
					html += `<div>
								<span>대댓글 : ${o.mimg}</span>
								<span>${o.mid}</span>
								<span>${o.rdate}</span>
								<span>${o.rcontent}</span>
							</div>`	
							
			
				
				})	
			
			}
			
			html += `
					<textarea class = "rerecontent${rno}" rows="" cols=""></textarea>
					<button type = "button" onClick ="rrWrite(${rno})">대댓글 달기</button>
					`
			document.querySelector('.rereplyBox'+rno).innerHTML = html;
		}	
	})
}

//하위 댓글
function rrWrite(rno){
	let rerecontent = document.querySelector(`.rerecontent${rno}`).value;
	
	$.ajax({
		url : "/jspWeb/board/replay",
		method : "post",
		/* type = 2 대댓글 */
		data : {"type" : 2, "bno" : bno, "rindex" : rno, "rcontent" : rerecontent},
		success : (r) => {
			if(r == 'true'){
				alert('대댓글이 작성되었습니다.')
			}else{
				alert('대댓글 작성 실패하였습니다. 관리자에게 문의해주세요.')
			}
		}
	})
}
