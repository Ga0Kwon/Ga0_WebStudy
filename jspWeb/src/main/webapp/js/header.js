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
				html += `<img class = "hpimg" src ="/jspWeb/member/pimg/${r.mimg == null ? 'basic.jpg' : r.mimg }"><br/>`
				html += `${r.mid}님 안녕하세요.<br/>`
				html += `<a href = "/jspWeb/member/logout.jsp">로그아웃</a> `;
				
				if(r.mid == 'admin'){
					html += `<a href = "/jspWeb/admin/info.jsp">관리자페이지</a> `;
				}
			}
			html += `<a href = "/jspWeb/index.jsp">메인페이지</a> `
			
			document.querySelector('.header').innerHTML = html;
		}
	})
}