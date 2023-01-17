/*

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
							
	배열과 반복문
		1. for(let i = 0; i < 배열명.length; i++){}
		2. for(let index in 배열명){}
		3. for(let object of 배열명){}
		4. foreach()
			1) 배열명.foreach((object) => { }) : obect는 필수이지만 나머지 인수는 필수가 아니다.
			2) 배열명.foreach((object, index) => { })
			3) 배열명.foreach((object, index, parentArray) => { })
			


*/

alert('script 열렸을 때') //script가 열렸을 때 실행

//1. 문서가 열렸을 때 DOM 객체 이벤트
//1) 재사용X => 화살표함수
document.addEventListener('DOMContentLoaded', () => { //HTML이 열렸을 때 실행
	/*실행문*/ 
	alert('html이 열림[화살표함수]')
	//객체 1개
	const h1 =document.querySelector('h1');
	console.log(h1);
	console.log(typeof(h1)); //typeof() : 데이터형 확인
	
	h1.innerHTML = '안녕'
	h1.style.color = 'red';
	h1.style.backgroundColor = "blue"; //카멜표기법 씀 -> CSS에서는 '-'을 쓰는 것을 
	h1.style.padding = '10px';
})

//2) 재사용X => 익명함수
document.addEventListener('DOMContentLoaded', function(){ alert('html열림[익명함수]')

	//객체 여러개
	const h1Array = document.querySelectorAll('h1')
	console.log(h1Array);
	console.log(typeof(h1Array)); //Object -> 배열도 객체
	
	
	/* 배열 내 데이터[요소]들을 하나씩 꺼내는 방법 */
	//1. 
	for(let i = 0; i<h1Array.length; i++){ //for start
		h1Array[i].innerHTML = '안녕' + i; //i라는 임시변수를 인덱스처럼 반복문에서 사용
	}//for end
	
	//2.
	for(let index in h1Array){ //배열내 요소 인덱스를 마지막까지 하나씩 반복변수에 대입
		h1Array[index].innerHTML = '안녕' + index;
	}
	
	//3.
	for(let object of h1Array){ //배열내 요소 모든 데이터를 마지막까지 하나씩 반복변수에 대입
		object.innerHTML = '안녕' 
	}
	
	//4.
	h1Array.forEach((object) => {object.innerHTML = "안녕~~~~~"})
		//배열명.forEach(화살표함수)
		//배열명.forEach(( 인수 ) => { 실행문; })
		//배열명.forEach((요소값) => { 실행문; })
	h1Array.forEach((object) => {console.log(object)}) //3번과 동일
		//배열명.forEach((요소값, 요소인덱스) => {실행문;})
	h1Array.forEach((object, index) => {console.log(object); console.log(index);}) //3번과 4번을 합친
	/*h1Array.forEach((값, 인덱스) => {console.log(값); console.log(인덱스);}) */
	h1Array.forEach((object, index, array) => { //배열도 들어갈 수 있음
		console.log(object); console.log(index); console.log(array)
	})

})