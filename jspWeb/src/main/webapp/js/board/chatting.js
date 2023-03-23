/*
	코드 작성 = 요리사    JS = 개발자
	코드 실행 = 먹는 사람  JS = 사용자
	
	    클라이언트                           		서버
	ex) 카카오톡 User                       		카카오톡 본사
		new WebSocket('ws://서버소켓URL') -보내기->   @ServerEndpoint("/chatting")
	 		1. clientSocket.Open       	  		@OnOpen
	 		2. clientSocket.send()       		@OnMessage
	 		3. 							 		세션명.getBasicRemote().sendText()
	 		4. 						 [연결끊김]		접속한클라이언트명단.remove(session); //	
	 		
		유재석      안녕 --------------->
		(소켓)	 <--------------- 안녕 
										(서버 소켓)채팅방(유재석, 강호동, 신동엽)
		강호동       <--------------- 안녕   
		(소켓)		  
				  
		신동엽		   <--------------- 안녕
		(소켓)		  
	
	- 클라이언트의 종착점과 서버의 종착점이 존재해야함
	
	
	네트워크 소켓 : 컴퓨터 네트워크를 경유하는 프로세스간 통신의 종착점[=엔드 포인트]
		- 두 프로그램간의 양방향 통신 종착점[도착지]
		
	서버 소켓 :	서버가 가지고 있는 소켓 [JAVA]
	
	클라이언트 소켓 : 각 클라이언트마다 가지고 있는 소켓[JS]
	
	JS WebSocket -> HTTP와는 프로토콜이 다르다
		1. JS에서 제공하는 클래스 WebSocket(webSocket의 경로[=ws://URL]);
		2. 소켓 객체 만들기
			let clientSocket = new WebSocket();
		  - 소켓과 다른 소켓(종착점)을 넣어줘야함
			let clientSocket = new WebSocket('ws://서버소켓URL');
		3. 소켓이 서버소켓과 연동
			1) WebSocket 생성자에서 해당 서버소켓의 경로 확인 통신
			
	JAVA ServerSocket
		1. 임의의 클래스 생성
		2. 서버소켓 만들기
			클래스위에 @ServerEndpoint
			- @ServerEndpoint : 서버소켓의 URL 만들기
			- @WebServlet : HTTP 서블릿 URL 만들기 
		3. @OnOpen 
			- 클라이언트소켓이 서버소켓[엔드포인트]로 접속했을 때 매핑[연결]
		
*/

let contentbox =  document.querySelector('.contentbox');
// 1. 클라이언트 소켓 생성 과 서버 소켓 연결
let clientSocket ;

/*회원제*/
if(memberInfo.mid == null){ //헤더 memberInfo에 있음
	alert('로그인 후 입장 가능합니다.')
	location.href = "/jspWeb/member/login.jsp"
}else{
	/*로그인 했으면 클라이언트 소켓 생성 */
	// 누가 보내는지 mid를 url에 같이 보낸다. [?는 request로 빼올 수 있는건데 request를 사용할 수 없음]
	
	/*clientSocket = new WebSocket('ws:///localhost:8080/jspWeb/chatting/{아이디}/{채팅방}');  */
	//-> 이런식으로 매개변수 여러개 받아올 수 있음
	clientSocket = new WebSocket('ws:///localhost:8080/jspWeb/chatting/'+memberInfo.mid); //종착점 
	// 클라이언트 소켓 객체에 정의한 함수 대입
	clientSocket.onopen = function(e){//생성과 동시에 오픈
		onopen(e); // java의 @OnOpen
	}
	//메세지 보내기 
	clientSocket.onmessage = (e) => {
		msgReceive(e); // java의 @OnMessage
	}
	//5. 서버와 연결이 끊겼을 때 [클라이언트소켓 객체가 초기화될때 -> F5, 페이지 전환할때 등등]
	clientSocket.onclose = (e) => {
		conectClose(e)
	}
	clientSocket.onerror = (e) => {
		alert('에러 발생: 관리자에게 문의> ' + e)
	}
}


console.log(clientSocket);



//2. 클라이언트소켓이 접속했을 때 이벤트/함수 정의
function onopen(e){ // 접속했을 때 하고 싶은 함수 정의
	etcsend(memberInfo.mid + "님이  입장하였습니다.", "alerm")
}


//3. 클라이언트 소켓이 서버에게 메시지 보내기 [@OnMessage] (1. 보내기 버튼 눌렀을 때 2. 입력창에서 엔터했을때 ) type = msg
function msgSend(){
	
	let msgbox = document.querySelector('.msgbox').value;

	/* 메시지 전송하기 */
		//JSON 형식의 문자열 타입 만들어서 문자열로 타입 전송
		//JSON.parse(JSON형식의 문지열 타입) : 문자열 타입 --> JSON 타입으로 변환
		//JSON.stringfy(JSON객체) : JSON타입 --> JSON형식[모양]의 String 타입으로 변환
	let info = {
		type : 'msg',
		msgbox : msgbox
	}
	
	clientSocket.send(JSON.stringify(info)); //-> @
	
	// 전송 성공시 채팅 입력창 초기화
	document.querySelector('.msgbox').value = ""; 
}

//4-2 타입에 따른 html 구별
function msgType(msg){
	let json = JSON.parse(msg);

	let html = ``;
	if(json.type == 'msg'){
		html += `<div class = "content">${json.msgbox}</div>`;
	}else if (json.type == 'emo'){
		html += `<div class = "content emocontent"><img src = "/jspWeb/img/imoji/emo${json.msgbox}.gif"></div>`;
	}
	return html;
}


//4. 서버로 부터 메시지가 왔을때 메시지 받기
function msgReceive(e){ // <-- e <--- getBasicRemote().sendText(msg);
	/*console.log(e);
	//e.data : 문자열 타입*/
	console.log(e.data)
	//JSON.parse(e.data) : 객체 json 형변환
	//Servlet에서 application/json을 안했다면 ajax success안에 JSON.parse만 넣어주면 된다.
	/*console.log(JSON.parse(e.data)); *///문자열 json -> 객체 json 형변환
	let data = JSON.parse(e.data);
	
	//접속명단[여러개 = list/Array] vs. 메시지 정보[1개 = dto/object]
		// Array 타입 확인 : Array.isArray(객체) : 해당 객체가 배열/리스트면 true
	if(Array.isArray(data)){
		let html = ``;
		data.forEach((o) => {
			html += `<div class = "connectbox"> <!-- 접속 명단 1명 -->
						<div>
							<img alt="" src="/jspWeb/member/pimg/${o.frompimg == null? 'basic.jpg' : o.frompimg}" class = "hpimg">
						</div>
						<div class = "name">
							${o.fromMid}
						</div>
					</div>`
		})
		
		document.querySelector('.connectlist').innerHTML = html;
		
	}else if(JSON.parse(data.msg).type == 'alerm'){
		contentbox.innerHTML += `<div class = "alerm">
									<div>${JSON.parse(data.msg).msgbox}</div>
								 </div>`
	}else{
		//보낸 사람과 현재 유저와 일치하면 [내가 보낸 메시지]
		if(data.fromMid == memberInfo.mid){
			contentbox.innerHTML += `<div class = "sendcontent">
										<div class = "date">${data.time}</div>
										${msgType(data.msg)}
									 </div>`
		}else{ //받은 경우
			contentbox.innerHTML += `<div class = "tocontent">
										<div><img class = "hpimg frompimg" src = "/jspWeb/member/pimg/${data.frompimg == null? 'basic.jpg' : data.frompimg}"></div>
										<div class = "rcontent">
											<div class = "name">${data.fromMid}</div>
											<div class = "contentdate">
												${msgType(data.msg)}
												<div class = "date">${data.time}</div>
											</div>
										</div>
									</div>`
		}
	
	}
	// ---------------- 스크롤 최 하단으로 내리기 ----------------
	/*let top = contentbox.scrollTop; //현재 스크롤의 상단 위치 좌표
	console.log(top);
	let height = contentbox.scrollHeight; //현재 스크롤의 높이 현재 스크롤의 전체 높이
	
	console.log(height) //초기값 : 679가 나옴*/
	//스크롤막대의 상단  위치를 스크롤 막대의 가장 아래의 위치로 대입
	contentbox.scrollTop = contentbox.scrollHeight;

}


function conectClose(e){
	etcsend(memberInfo.mid + "님이  퇴장하였습니다." + "alerm")
	
}

/*엔터 누르면 전송 되도록*/
function enterKey(){
	if(window.event.keyCode == 13){ //엔터키 코드 값 : 13
		msgSend(); //메시지 보내기 함수 실행
	}
}

/* 이모티콘 출력 */
function getEmo(){
	let html = ``;
	
	for(let i = 1; i <= 43; i++){
		html += `<img onClick = "etcsend(${i}, 'emo')" class ="emo" alt="" src="/jspWeb/img/imoji/emo${i}.gif" width = "50px">`
	}
	
	document.querySelector('.enolist').innerHTML = html;
}

//이모티콘 보내기
function etcsend(msgbox, type){
	let msg = {
		type : type,
		msgbox : msgbox
	}
	
	clientSocket.send(JSON.stringify(msg)); // ----> OnMessgae
}

/*
	[클라이언트 소켓이 이미 만들어져 있기 때문에 =(대입)]
	클라이언트 소켓 필드           서버소켓
		onopen = 
		onclose = 
		onMessage = 
		
		연결 해제 관련
		clientSocket.onclose = (e) = { console.log('연결해제'); }
		
			vs.
		clientSocket.onclose = function conectClose(e){ console.log('연결해제'); }
		
			vs. 
		function conectClose(e){
			console.log('연결 해제~');
		}
				+
		clientSocket.onclose = (e) => {
			conectClose(e)
		}	
		
	
	[AJAX는 아직 만들어지지 않았고, 정의를 내리면서 결과값을 받는 것이므로 :(콜론)을 써야함]
	AJAX 필드
		success : function(r){}
		success : (r)=>{}
*/


