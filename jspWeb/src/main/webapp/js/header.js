/*alert('header.js 열림')*/

//로그인한 회원 정보 호출
getLogin();

function getLogin(){
	$.ajax({
		url : "/jspWeb/login",
		method : "get",
/*		data : "",*/
		success : (r) => {
			/* r -> dto{mno, mid, mpwd, mimg, memail} 
				MemberDto 1개 회원 --> r 객체 1개 */
			
			//1. html 구성
			let html = ``;
			
			if(r == null){
				html += `<a href = "/jspWeb/member/signup.jsp">회원가입</a> `;
				html += `<a href = "/jspWeb/member/login.jsp">로그인</a> `;
			}else{
				html += `<div class="dropdown">
							  <button class = "pimgBtn" type="button" data-bs-toggle="dropdown">
							   	<img class = "hpimg" src ="/jspWeb/member/pimg/${r.mimg == null ? 'basic.jpg' : r.mimg }">
							  </button>
							  <ul class="dropdown-menu"> <!-- 드롭다운시 표시되는 구역 -->
							    <li><a class="dropdown-item" href="#"> 내 프로필 </a></li>
							    <li><a class="dropdown-item" href="#"> 친구 목록 </a></li>
							    <li><a class="dropdown-item" href="/jspWeb/member/logout.jsp"> 로그아웃 </a></li>
							  </ul>
							</div> <!-- 드롭다운 end -->
							<span>${r.mid}님</span>
							<a href = "#">쪽지함</a>
							<a href = "#">포인트</a>`;
				
				if(r.mid == 'admin'){ //관리자이면
					html += `<a href = "/jspWeb/admin/info.jsp">관리자페이지</a> `;
				}
			}
			
			document.querySelector('.submenu').innerHTML = html;
		}
	})
}