/*alert('header.js 열림')*/

let memberInfo = null; //JS끼리 통신하기 위해서
//로그인한 회원 정보 호출
getLogin();

function getLogin(){
	$.ajax({
		url : "/jspWeb/login",
		method : "get",
/*		data : "",*/
		/*만약 동기를 안쓰면 info.js에서 해당 1명의 회원의 정보[memberInfo]를 가져올때,
		ajax가 아직 처리를 안해서 null값을 가져가게 된다. 하지만 동기식으로 한다면,
		ajax가 통신할 때까지 기다리기 때문에 정보를 받을 수 있다. -> JS끼리 통신 가능!*/
		async : false, // 동기화
		success : (r) => {
			/* r -> dto{mno, mid, mpwd, mimg, memail} 
				MemberDto 1개 회원 --> r 객체 1개 */
			memberInfo = r; // 응답 결과를 전역변수로 옮기기 [왜? 다른 함수/JS에서 쓰려고]
			//1. html 구성
			let html = ``;
			//r.mno == 0 or r.mid = null 
			// mno는 1부터 시작하기 때문에 0이 나오는 건 없다는 뜻이고, 
			// mid가 null일 수도 없기 때문에 조회 결과가 없다는 것
			if(r.mid == null){ //로그인 안했으면
				html += `<a href = "/jspWeb/member/signup.jsp">회원가입</a> `;
				html += `<a href = "/jspWeb/member/login.jsp">로그인</a> `;
			}else{
				html += `<div class="dropdown">
							  <button class = "pimgBtn" type="button" data-bs-toggle="dropdown">
							   	<img class = "hpimg" src ="/jspWeb/member/pimg/${r.mimg == null ? 'basic.jpg' : r.mimg }">
							  </button>
							  <ul class="dropdown-menu"> <!-- 드롭다운시 표시되는 구역 -->
							    <li><a class="dropdown-item" href="/jspWeb/member/info.jsp"> 내 프로필 </a></li>
							    <li><a class="dropdown-item" href="#"> 친구 목록 </a></li>
							    <li><a class="dropdown-item" href="/jspWeb/member/logout.jsp"> 로그아웃 </a></li>
							  </ul>
							</div> <!-- 드롭다운 end -->
							<span>${r.mid}님</span>
							<a href = "#">쪽지함</a>
							<a href = "/jspWeb/member/point.jsp">${r.mpoint} 포인트</a>`;
				
				if(r.mid == 'admin'){ //관리자이면
					html += `<a href = "/jspWeb/admin/info.jsp">관리자페이지</a> `;
				}
			}
			
			document.querySelector('.submenu').innerHTML = html;
		}
	})
}


// 알림용 소켓
let noticeSocket = null;

if(memberInfo.mid == null){
	
}else{
	//JS 실행주체 = 클라이언트 // JAVA = 서버
	//1) JS : [클라이언트 소켓 생성]
	noticeSocket = new WebSocket('ws://localhost:8080/jspWeb/alarm/'+memberInfo.mid);
	//2) 클라이언트 소켓 이벤트 메서드 정의
	noticeSocket.onopen = (e) => {console.log('알림용 서버 소켓에 들어옴'); }
	noticeSocket.onclose = (e) => {console.log('알림용 서버 소켓에 나감')}
	noticeSocket.onerror = (e) => {console.log('알림용 서버 소켓 오류')}
	noticeSocket.onmessage = (e) => {onalarm(e);}
}


// 
function onalarm(e){
	let msgbox =document.querySelector('.msgbox');
	
	msgbox.style.bottom = "50px";
	
	// * 4초 후에 자동 내려가기
	// n밀리초(1/1000) 후에 이벤트 실행 setTimeout
	// n밀리초 마다 이벤트 실행 setInterval
	setTimeout(() => {msgbox.style.bottom = "-100px";}, 4000);
	//Dao 메소드에 synchronized 키워드 사용
	//스레드1 해당 메서드를 사용하고 있을 때 [return 전] 다른 스레드2 해당 메서드에 대기상태
	//멀티 스레드
	getcontent(); //헤더는 index에서 쓰고 있기 때문에 메서드됨. 
   
}