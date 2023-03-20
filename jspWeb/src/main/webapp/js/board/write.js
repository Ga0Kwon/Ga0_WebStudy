/*alert('write JS');*/

// 방법3 [로그인 여부 확인]
//헤더에 있는 memberInfo [헤더 목록은 jsp(<%@ %>)로 넣어서 공통으로 사용할 수 있음.] 
/*if(memberInfo.mid == null){
	alert('회원제 기능입니다. 로그인 후 작성해주세요.');
	location.href = "/jspWeb/member/login.jsp";
}*/

function bWrite(){
	//type = "file" 에 직접적인 조작이 불가능
	//querySelector을 쓰면 form자체를 가져온다[문자]
	//폼을 가져올때 querySelectorAll을 쓰는 이유, form 객체를 가져옴
	
	//1. 폼 가져오기
	/*let writeForm = document.querySelector('.writeForm');*/
	
	//2. 폼 가져오기 [어처피 1개여서 인덱스가 0밖에 없지만, 예상치 못한 문제를 미리 방지하기 위해]
	// 2-1.
	let writeForm = document.querySelectorAll('.writeForm')[0]; 
	// 2-2.
	/*let writeForm = document.querySelectorAll('.writeForm'); */
	
	//3. 폼 객체 ----> new FormData 클래스 
	//3-1.
	let writeFormData = new FormData(writeForm);
	//3-2.
/*	let writeFormData = new FormData(writeForm[0]);*/

	//4.
	$.ajax({
		url : "/jspWeb/board/info",
		method : "post",
		data : writeFormData, 
		//첨부파일 multipart/form-data 명시 [contentType/processData]
		contentType : false, 
		processData : false,
		success : (r) => {
			if(r == 'true'){
				alert('글쓰기 성공!')
				location.href = "/jspWeb/board/list.jsp?cno="+document.querySelector('.cno').value;
			}else{
				alert('글쓰기 실패.')
			}
		}
	})
}

$(document).ready(function() {
  $('#summernote').summernote(
	  {height : 300}
  );
});