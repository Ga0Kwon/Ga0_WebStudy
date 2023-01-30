console.log('스크립트 실행')

$(document).ready(function() {
  $('#summernote').summernote({height : 300, lang : 'ko-KR'}); //객체 형태로 넣어주어야함.
});

/*
	썸머노트 기능 속성
	$(document).ready(function() {
 		 $('#summernote').summernote({속성 : 값, 속성 : 값}); 
 		 1. height : 높이
 		 2. lang : ko-KR : 한글 버전
	});


*/