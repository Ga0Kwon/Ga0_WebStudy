alert("day03_js열림");

function doPost(){
	alert("http POST 메소드 실행");
	$.ajax({
		url :"/jspWeb/Ex3",
		method :"post",
		success : (result) => {}	
	})
}

function doGet(){
	alert("http Get 메소드 실행");
	$.ajax({
		url :"/jspWeb/Ex3",
		method :"get",
		success : (result) => {}	
	})
}

function doPut(){
	alert("http PUT 메소드 실행");
	$.ajax({
		url :"/jspWeb/Ex3",
		method :"put",
		success : (result) => {}	
	})
}

function doDelete(){
	alert("http DELETE 메소드 실행");
	$.ajax({
		url :"/jspWeb/Ex3",
		method :"delete",
		success : (result) => {}	
	})
}

/*-----------------예제2-----------------*/
//1. 등록
function onWrite(){
	console.log('onWrite()메소드 실행');
	
	let info = {
		content : document.querySelector('.content').value,
		writer : document.querySelector('.writer').value
	}
	
	console.log(info);
	
	
	$.ajax({
		url : "/jspWeb/Ex3/Board",
		method : "post",
		data : info,
		success : (r) => {
			if(r == 'true'){
				alert('등록 성공');
				document.querySelector('.content').value = '';
				document.querySelector('.writer').value = '';
				printBoard();
			}else{
				alert('등록 실패')
			}
		}
	})
}

printBoard();

//2. 출력
function printBoard(){
	$.ajax({
		url : "/jspWeb/Ex3/Board",
		method : "get",
		success : function(result){
			let html = `<table border = "1">
							<tr>
								<th>번호</th>
								<th>내용</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>비고</th>
							</tr>`
						
						
			result.forEach((o) => {
				html += `<tr>
							<td>${o.bno}</td>
							<td>${o.bcontent}</td>
							<td>${o.bwriter}</td>
							<td>${o.bdate}</td>
							<td><button onClick = "onUpdate(${o.bno})" type = "button">수정</button> | <button onClick = "onDelete(${o.bno})" type = "button">삭제</button></td>
						</tr>`
			})
			
			html += `</table>`;
			
			document.querySelector('.boardList').innerHTML = html;
		}
	})
}
//3. 수정
function onUpdate(bno){
	
	let newcontent = prompt("수정할 내용 입력");
	
	console.log(bno, newcontent);
	
	$.ajax({
		url : "/jspWeb/Ex3/Board",
		method : "put",
		data : {"bno" : bno, "newcontent" : newcontent},
		success : (result) =>{
			if(result == 'true'){
				console.log("수정되었습니다.");
				printBoard();
			}else{
				console.log("수정 실패하였습니다.")
			}
		}
	})
}

//4. 삭제
function onDelete(bno){
	console.log(bno)
	$.ajax({
		url : "/jspWeb/Ex3/Board",
		method : "delete",
		data : {"bno" : bno},
		success : (result) =>{
			if(result == 'true'){
				console.log("삭제하였습니다.");
				printBoard();
			}else{
				console.log("삭제 실패하였습니다.")
			}
		}
	})
}

/*
	JSP 서블릿[JSP 서블릿만!!] 
	get, post는 안해도 되지만, 
	JSP 서블릿에서 HTTP 메소드 put, delete 사용시 필수 설정.
		* 기본값 : 매개변수 요청 차단
	1. Server 폴더 클릭
	2. Server.xml 더블 클릭
	3. 하단 Source 탭 클릭
	4. 대략 60번대 줄에서 
	<Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
	 을 찾고 뒤에다가 parseBodyMethods="POST,PUT,DELETE" URLEncoding="UTF-8" 추가 
	 즉, <Connector connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443" parseBodyMethods="POST,PUT,DELETE" URLEncoding="UTF-8"/>
	 
	
 */