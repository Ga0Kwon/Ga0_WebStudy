/*alert('view js 실행')*/

getBoard()

function getBoard(){
	//bno가져오기
	let bno = document.querySelector('.bno').innerHTML;
	
	$.ajax({
		url : "/jspWeb/board/info",
		method : "get",
		data : {"type" : 2, "bno" : bno}, //1. 전체 출력 2. 개별 출력
		success : (r) => {
			if(r != null){
				document.querySelector('.infoBox').innerHTML = `
				${r.bwritedate} | ${r.bview} | <button onClick = "bIncrease(2)"type = "button">${r.blike}</button> | <button onClick = "bIncrease(3)" type = "button">${r.bhate}</button>`;
				
				document.querySelector('.btitle').innerHTML = `${r.btitle}`;
				document.querySelector('.pimgBox').innerHTML = `<img onClick = "friendInfo(${r.mno})" style="width: 20%;" src = "/jspWeb/member/pimg/${r.mimg == null ? 'basic.jpg' : r.mimg }" </img>`;
				document.querySelector('.bcontent').innerHTML = `${r.bcontent}`;
			
				if(r.bfile == null){ //첨부파일 없으면
					document.querySelector('.bfile').innerHTML = '첨부파일 없음';
				}else{//첨부파일 있을 때
					html = `${r.bfile} <button onClick = "bfileDownload('${r.bfile}')" type = "button">다운로드</button>`
					document.querySelector('.bfile').innerHTML = html;
				}
				
			}else{
				alert('정보를 조회할 수 없습니다.')
			}
			
			//로그인된 회원과 작성자가 일치하면 삭제함
			if(memberInfo.mid == r.mid){
				let html = `<button onClick ="bDelete(${r.bno}, ${r.cno})" type = "button">삭제</button>
							<button onClick ="bUpdate(${r.bno})"  type = "button">수정</button>`;
				document.querySelector('.btnBox').innerHTML = html;
			}
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
	let bno = document.querySelector('.bno').innerHTML;
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

