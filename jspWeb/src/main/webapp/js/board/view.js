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
				${r.bwritedate} | ${r.bview} | ${r.blike} | ${r.bhate} `;
				
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

//게시물 작성자의 정보를 확인하기[인수 mno]
function friendInfo(mno){
	console.log(mno);
	
	$.ajax({
		url : "/jspWeb/member"
	})
	
}
