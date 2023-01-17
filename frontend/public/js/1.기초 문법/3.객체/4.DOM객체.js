/*
	객체
		1. 미리 만들어진 객체
			1) console 객체
				console.log()
			2) Math 클래스
				Math.random()
			3) document객체 : DOM 객체
				document.querySelector()
			etc...
			
		2. 사용자 정의 객체

		함수
			1. 일반함수   : function 함수명(){ }
			2. 익명함수   : function(){ } 
				- 재호출 X (일회성) => 이름이 없으니까
			3. 화살표함수  : () => { } ; 람다식이라고도 함
				- 재호출 X (일회성) => 이름이 없으니까
			* 재호출 불가능하지만 변수나 객체[속성] 대입하면서 재호출을 할 수 있게 되었다.
			
		JAVA는 HTML를 직접적으로 조작 못함
		JS는 HTML를 직접적으로 조작 가능 [DOM 객체]
		window 객체
			1. window.onload = 함수 : HTML에서 모든 자료[CSS/HTML]를 불러왔을 때 실행 
			2. winodw.addEventListener('load' , 함수)
		
		DOM객체 : 문서 객체
			document.속성기능명
				1. document.body.innerHTML	  				: body 마크업에 html형식문자를 대입
				2. document.addEventListener('이벤트명', 함수)    : 문서에서 이벤트가 발생하면 함수 실행
					DOMContentLoaded : HTML이 열렸을 때 [다른 자료 상관X]
					document.addEventListener('DOMContentLoaded', () => { //HTML이 열렸을 때 실행})
					document.addEventListener('DOMContentLoaded', function(){ alert('html열림[익명함수]') })
				3. document.querySelector('식별자') : HTML 마크업 1개를 객체 반환
					- typeOf : 데이터/자료 형 확인 
					 1) style : -대신 카멜표기법을 사용
					 		.style.color = '색상';
							.style.backgroundColor = "배경색";
							.style.padding = '안쪽여백';
*/

//1. DOM 객체 : HTML를 객체화
let h1 = `<h1>${'안녕하세요'}</h1>`
document.body.innerHTML = h1

//2. DOM 객체의 이벤트

//1) 기존 함수 적용
function 함수1(){console.log('문서열림1')}

document.onload = 함수1; //실행 X
window.onload = 함수1; //실행 O

document.addEventListener('load' , 함수1) //실행 X
window.addEventListener('load' , 함수1) //실행 O

document.addEventListener('DOMContentLoaded' , 함수1);

//2) 익명 함수들 -> 이름이 없는 함수.
document.onload = function(){console.log('문서열림2')}
window.onload = function(){console.log('문서열림2')}

document.DOMContentLoaded = function(){console.log('문서열림2')}

document.addEventListener('load', function(){ console.log('문서열림3')})
window.addEventListener('load', function(){ console.log('문서열림3')})

document.addEventListener('DOMContentLoaded', function(){ console.log('문서열림3')})

//3) 화살표 함수 적용 [ ( 인수 ) => { 실행문 }] : 함수 적용
document.onload = () => {console.log('문서열림4')}
window.onload = () => {console.log('문서열림4')}

document.DOMContentLoaded = () => {console.log('문서열림4')}

document.addEventListener('load', () => {console.log('문서열림5')})
window.addEventListener('load', () => {console.log('문서열림5')})

document.addEventListener('DOMContentLoaded', () => {console.log('문서열림5')})

let 변수 = ( ) => { console.log('문서열림6')};
console.log(변수);

let 익명함수 =  function(){console.log('익명함수 실행')}
let 화살표함수 = () => {console.log('화살표함수 실행')}
let 객체 = {행동 : () => {console.log('화살표함수 실행 [객체]')}}