alert("js 실행 -- 버튼 눌림");

//JS 함수
//function 함수명 (매개 변수) 

function 예제(){
	// document : 미리 만들어진 DOM 객체
		// querySelector(식별자)
			//1. .클래스
			//2. #아이디
		//querySelectorAll(식별자) => tag 여러개 => 배열/리스트에 저장
		
		//querySelector().속성명
			//1. querySelector().value : input, select, textarea [div x, table x]
			//2. querySelector().innerHtml : div, span, td 등등
			
	let data = document.querySelector('.inputData').value;
	console.log(data);
}