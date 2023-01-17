/*
	[CRUD] : CREATE READ UPDATE DELETE => JAVA, JavaScript 등등에서 이건 기본.
	
	- 점수 관리
		1. 학생 점수 등록 페이지
		2. 학생 점수 출력 페이지

*/

//학생들의 점수 객체를 여러개 저장하는 배열
let studentArray = [];

//1. Js 열렸을 때 <button> 객체 가져오기
let addbtn = document.querySelector('.addBtn');

//2. 해당 버튼에 클릭 이벤트 
addbtn.addEventListener('click', () =>{ //html 코드에 onClick넣는거랑 같음.

	//1. 입력받은 데이터를 가져오기
	/*let inputArray =  document.querySelectorAll('input');
	console.log(inputArray);*/
	
	//1.입력받은 데이터를 하나씩 가져와서 객체화
	//* input 숫자를 입력해도 value는 무조건 문자열 가져온다. 형변환 필요!
	let info = {
		name : document.querySelector('.name').value,
		kor : parseInt(document.querySelector('.kor').value),
		eng : parseInt(document.querySelector('.eng').value),
		mat : parseInt(document.querySelector('.mat').value)
	}
	
	console.log(info);
	
	//2. 유효성검사 [데이터 체크]
		//1. 이름 중복체크
	/*studentArray.forEach((obj) => {
			if(obj.name ==info.name){ //if start
				alert('현재 등록된 학생명입니다.');
				return;
			} //if end
		})*/
	
	for(let i = 0; i < studentArray.length; i++){ //for start
		if(studentArray[i].name == info.name){ //if start
			alert('현재 등록된 학생명입니다.');
			return;
		} //if end
	} //for end
	
		//2. 타입 확인
		//2. 정수 0~100사이만 입력
	if(info.kor > 0 || info.kor > 100 || 
		info.eng > 0 || info.eng > 100 || 
		info.mat > 0 || info.mat > 100 ){
		alert('입력할 수 없는 점수 범위입니다. [0~100]사이만 입력가능');
		return;
	}
	/*console.log(typeof(info.name));
	console.log(typeof(info.kor));
	console.log(typeof(info.eng));
	console.log(typeof(info.mat));*/
/*	
	console.log(parseInt(typeOf(info.kor))); //숫자로 형변환
	console.log(parseInt(typeOf(info.eng))); //숫자로 형변환
	console.log(parseInt(typeOf(info.mat))); //숫자로 형변환*/
	 
})