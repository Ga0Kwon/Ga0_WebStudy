/*alert('관리자 JS 실행');*/
printMember();
function printMember(){
	$.ajax({
		url : "/jspWeb/member",
		method : "get",
		success : function(result){
			//1. 응답 데이터 처리
			//1) 테이블 헤더 구성
			let html = `<tr>
							<th width ="10%">회원번호</th>
							<th width ="10%">회원프로필</th>
							<th width ="10%">회원아이디</th>
							<th width ="10%">회원이메일</th>
							<th width ="10%">비고</th>
						</tr>`
						
			result.forEach((o) => {
				if(!(o.mid == 'admin')){ //관리자는 출력X
					//2) 테이블 내용물 추가 구성
					//만약에 회원의 mimg 프로필 이미지가 null이면 기본 프로필 사용 / 아니면 mimg 사용
					html += `<tr>
							<td>${o.mno}</td>
							<td><img src = "/jspWeb/member/pimg/${o.mimg == null ? 'basic.jpg' : o.mimg}" width = "50%"></td>
							<td>${o.mid}</td>
							<td>${o.memail}</td>
							<td></td>
						</tr>`	
				}
			})
				//3) 구성된 html를 table 대입
			document.querySelector('.memberTable').innerHTML = html;
		}
	})
}