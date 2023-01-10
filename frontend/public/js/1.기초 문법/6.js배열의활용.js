/*
	1. 추가 버튼을 눌렀을 때 클릭 이벤트

*/

alert("JS 실행합니다.") // 1번밖에 실행 안됨.

//함수 밖에 만든 이유 : 함수가 실행될 때마다 선언하면 기존데이터가 삭제가 됨.
let studentList = []; //배열 선언, 초기 요소 없음[깡통]
let name ;

function onAdd(){ 
	//1) function : 함수 정의 키워드
	//2) onAdd() : 함수명 [아무거나 해도 되고, 중복 X]
	//3) () : 인수 [함수 실행시 함수 안으로 전달받는 데이터]
	//4) { } : 함수가 실행되는 구역
	alert("클릭했습니다."); // 여러번 실행 됨.
	
	/* 2. 입력받은 input value[값]을 가져오기 */
	//1> HTML 마크업을 변수화 하기 = DOM [document = HTML]
	
	// 1. class 명으로 해당 마크업을 JS변수로 가져올 때  
	 	//let HTML변수명 = document.querySelector('.클래스');
		
	// 2. id명으로 해당 마크업을 JS변수로 가져올 때  
		//let HTML변수명 = document.querySelector('#아이디');
		//마크업의 속성호출
	//2> 1.HTML ----> JS => document.querySelector();
	//   2. HTML <---- JS => document.write();
		
	// HTML -> JS (서로 다른 언어들 간에 데이터를 주고 받을 수 있다.)
	let studentName = document.querySelector('.studentName'); 
		//sName 변수에 input 마크업 저장
	/* 3. 마크업에서 값 가져오기 */
	/*alert(sName.value);*/
	
	// 4.마크업에 출력
	studentList.push(studentName.value);
	//console.log(학생리스트)
		//1. 출력할 위치에 <ul> 마크업 가져온다.
	let sList = document.querySelector('#studentList');
	sList.innerHTML = '<li>' + studentList + '</li>'
	
} //1. 함수 끝 

/* 클릭시 배열 내 요소를 삭제하는 리스트  */
function onDelete(){
	//[입력부]
	
	//1. 입력받은 데이터를 가져온다. <input> 가져와서 변수에 저장 [DOM 객체]
	let studentName = document.querySelector('.studentName');
	//2. <input>에 입력된 value[값] 가져오기
	let deleteName = studentName.value
	//3. 배열 내에서 값에 해당하는 요소 인덱스 찾기
	let deleteIndex = studentList.indexOf(deleteName); //입력받은 이름의 인덱스를 찾아 변수에 저장
	//4. 배열 해당 인덱스의 요소 제거
	studentList.splice(deleteIndex, 1);
	
	//[출력부]
	// 1. <ul> 가쟈와서 변수에 저장 [DOM 객체]
	let sList = document.querySelector('#studentList');
	// 2. <ul> innerHTML 이용한 <ul> {여기에 데이터 넣기 } </ul>
	sList.innerHTML = '<li>'+ studentList+'</li>'
	
	
	
}