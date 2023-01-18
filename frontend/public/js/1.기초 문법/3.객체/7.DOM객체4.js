/*
	
*/

//1. select 변경 이벤트
let selectBox = document.querySelector('.selectBox');
selectBox.addEventListener('change', (e) =>{
	console.log(e); //e : 이벤트 결과 정보
	
	//1. 선택된 option
	e.currentTarget // 이벤트를 실행한 마크업[타겟] => selectBox
	console.log(e.currentTarget);
	
	let options = e.currentTarget.options //select의 모든 옵션들을 배열로 가져오기
	console.log(e.currentTarget.options)
	
	let index = e.currentTarget.options.selectedIndex //select에서 선택한 인덱스 가져오기
	console.log(e.currentTarget.options.selectedIndex) 
	
	console.log(options[index].textContent);
	console.log(options[index].value);
	
	/*document.write(options[index].value);*/
	document.querySelector('h3').innerHTML = `선택한 옵션 :  ${options[index].value}`
})

//2. checkbox 변경 이벤트
let checkbox = document.querySelector('.checkBox')
checkbox.addEventListener('change', (e) => {
	console.log(e);
	//1. 체크 여부 확인
	e.currentTarget
	console.log(e.currentTarget)
	
	e.currentTarget.checked
	console.log(e.currentTarget.checked)
})

//3. 타이머 예제
let timer = 0; //타이머 시간(초)를 저장하는 변수
let timerId = 0; //전역 변수

/*function 함수명() {timer++; timerspan.innerHTML = timer + "초";}*/

let timerbox = document.querySelector('.timerBox')
let timerspan  = document.querySelector('.timerSpan')
timerbox.addEventListener('change', (e) =>{
	if(e.currentTarget.checked){
		/*	timer = 0;*/ //초기화
		//만약 체크박스에 체크가 되어 있으면
		
		// setInterval : 특정 시간마다 함수를 실행
		/*	setInterval(함수명,  시간(밀리초 = 1000/1초))*/
		/*setInterval(() => { 실행문 }, 1000)*/ //1초마다 화살표 함수 실행
		/*clearInterval() : Interval 초기화*/
		//let 변수명 = setInterval(() => { 실행문 }, 1000)
/*		timerId = setInterval(함수명, 1000);*/
		
		timerId = setInterval(() => {
			timer++
			timerspan.innerHTML = timer + "초";
		}, 1000)
	}else{
		clearInterval(timerId);
	}
})