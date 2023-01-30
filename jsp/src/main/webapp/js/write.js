console.log('스크립트 실행')

let 게시물임시저장소 = []

function boardWrite(){
	//1. 입력받은 데이터 객체화한다.
	let board = { /*첨부파일이 없는 기준. */
		title : document.querySelector('.btitle').value,
		content : document.querySelector('.bcontent').value,
		writer : document.querySelector('.bwriter').value,
		password : document.querySelector('.bpassword').value
	}
	console.log(board)
	//[첨부파일이 있을 경우]
	//1. 입력 양식을 통째로 가져온다.
	let writeForm = document.querySelector('.write_form');
	let formData = new FormData(writeForm)
	console.log(writeForm)
	console.log(formData)
	
	//*유효성 검사 생략
	
	//2. java에게 데이터를 전송 후 전송된 결과를 받는다. [통신-AJAX]
	게시물임시저장소.push(board); console.log(게시물임시저장소);
	
	//3. 결과에 따른 이벤트
	let result = true; //java로 부터 전송 결과
	if(result) {alert('글쓰기 성공'); location.href = 'list.html'}
	else {alert('글쓰기 실패')}
}

/*썸머노트 api 실행 */
$(document).ready(function() {
  $('#summernote').summernote({
	  height : 300, lang : 'ko-KR'
	  
	  }); //객체 형태로 넣어주어야함.
});

/*
	썸머노트 기능 속성
	$(document).ready(function() {
 		 $('#summernote').summernote({속성 : 값, 속성 : 값}); 
 		 1. height : 높이
 		 2. lang : ko-KR : 한글 버전
	});


*/