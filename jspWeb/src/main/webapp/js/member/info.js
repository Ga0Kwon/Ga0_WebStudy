/*alert('INFO-JS 열림');*/
/*info.jsp[HTML/JSP]은 JSP의 include으로 연결했기 때문에
	=> 그리고 header은 모든 페이지의 공통분모이기 때문에 */
/*console.log(memberInfo);*/

// * 회원 정보.js : 만약에 로그인이 안되어있으면 불가능
if(memberInfo.mid == null){
	alert('로그인한 사용자만 보실 수 있습니다.');
	location.href = "/jspWeb/member/login.jsp";
}

// header.js에서 ajax 동기식으로 회원정보를 가져온 상태 [memberInfo]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.mimg').src = `/jspWeb/member/pimg/${memberInfo.mimg == null ? 'basic.jpg' : memberInfo.mimg}`;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;


//1. 회원 탈퇴
// function delete(){} [JS 이미 사용중인 키워드]
function setDelete(){
	if(memberInfo.mid == 'admin'){
		alert('관리자는 회원 탈퇴하실 수 없습니다.')
	}else{
		$.ajax({
			url : "/jspWeb/member",
			method : "delete",
			data : {"mpwd" : document.querySelector('.mpwd').value},
			success : (r) =>{
				if(r == 'true'){
					alert('회원탈퇴 성공');
					location.href = "/jspWeb/member/logout.jsp"
				}else{
					alert('회원탈퇴 실패, 비밀번호가 다릅니다.')
				}
			}
		})		
	}
}


//2. 회원 수정
// function update(){} [JS 이미 사용중인 키워드]
function setUpdate(){
	if(memberInfo.mid == 'admin'){
		alert('관리자는 회원 수정하실 수 없습니다.')
	}else{
		$.ajax({
			url : "/jspWeb/member",
			method : "put",
			success : (r) =>{
				if(r == 'true'){
					alert('회원정보 수정 성공');
					location.href = "/jspWeb/member/info.jsp"
				}else{
					alert('회원정보 수정 실패, 관리자에게 문의해주세요.')
				}
			}
		})
	}
}