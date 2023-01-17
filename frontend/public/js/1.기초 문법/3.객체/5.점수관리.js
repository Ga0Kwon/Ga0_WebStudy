/*
	[CRUD] : CREATE READ UPDATE DELETE => JAVA, JavaScript 등등에서 이건 기본.
	
	- 점수 관리
		1. 학생 점수 등록 페이지
		2. 학생 점수 출력 페이지
	- 학생 점수 현황
		1. 번호
		2. 이름
		3. 국어
		4. 영어
		5. 수학
		6. 총점
		7. 평균
		8. 순위[총점 기준]

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
	let check = true; //유효성 검사 상태 저장하는 변수 [아래 유효성검사 조건이 하나라도 걸리면 저장 실패]
	
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
			check = false;
			return;
		} //if end
	} //for end
	
		//2. 타입 확인
		//2. 정수 0~100사이만 입력
	if(info.kor < 0 || info.kor > 100 || 
		info.eng < 0 || info.eng > 100 || 
		info.mat < 0 || info.mat > 100 ){
		alert('입력할 수 없는 점수 범위입니다. [0~100]사이만 입력가능');
		check = false;
		return;
	}
	
	//3. 이름 글자 3~5글자 사이
	if(info.name.length > 5 || info.name.length < 3){
		alert('이름은 3~5글자로 입력할 수 있습니다. ');
		check = false;
		return;
	}
	
	//4.점수가 숫자가 아닐 경우
	/*if(typeof(info.kor) != Number || 
		typeof(info.eng) != Number || 
		typeof(info.mat) != Number ){
		alert('점수는 숫자로 입력해주세요.' );
		return;
	}*/
	
	//4. 숫자 아닐 경우 [isNan() : 숫자 형식 체크 [true of false]]
	/*if(isNan(info.kor) || isNan(info.eng) || isNaN(info.mat)){
		alert('숫자 형식으로 입력해주세요.')
	}
	*/
	if(isNaN(info.kor)){
		alert('[국어점수] 숫자 형식으로 입력해주세요.');
		check = false;
		return;
	}else if(isNaN(info.eng)){
		alert('[영어점수] 숫자 형식으로 입력해주세요.');
		check = false;
		return;
	}else if(isNaN(info.mat)){
		alert('[수학점수] 숫자 형식으로 입력해주세요.');
		check = false;
		return;
	}
	
	//3. 저장 [위 유효성검사 하나라도 충족하지 않았을 때]
	if(check){
		studentArray.push(info);
		printScoreTable();
	}
	console.log(studentArray);
	
	/*console.log(typeof(info.name));
	console.log(typeof(info.kor));
	console.log(typeof(info.eng));
	console.log(typeof(info.mat));*/
/*	
	console.log(parseInt(typeOf(info.kor))); //숫자로 형변환
	console.log(parseInt(typeOf(info.eng))); //숫자로 형변환
	console.log(parseInt(typeOf(info.mat))); //숫자로 형변환*/
	 
})
//처음 실행
printScoreTable();
//2. 배열 내 객체 정보를 테이블에 출력하는 함수 [1. JS 열렸을 때 2. 등록할때마다/업데이트 3. 삭제 4. 수정]
function printScoreTable(){
	
	let html = `<tr>	
						<th>번호</th>
						<th>이름</th>
						<th>국어</th>
						<th>영어</th>
						<th>수학</th>
						<th>총점</th>
						<th>평균</th>
						<th>순위</th>
						<th>비고</th>
				</tr>`
				
	for(let i = 0; i < studentArray.length; i++){
		let total = (studentArray[i].kor + studentArray[i].eng + studentArray[i].mat)
		let avg = (total/3).toFixed(2);
		
		/* 2. 순위 구하기 [총점 구하기]*/
		let rank = 1;

		studentArray.forEach((o2) => {
			let total2 = o2.kor + o2.eng + o2.mat;
			if(total < total2){
				rank++
			}
		})
		console.log(rank);
		html +=  `<tr>	
						<td>${i+1}</td>
						<td>${studentArray[i].name}</td>
						<td>${studentArray[i].kor}</td>
						<td>${studentArray[i].eng}</td>
						<td>${studentArray[i].mat}</td>
						<td>${total}</td>
						<td>${avg}</td>
						<td>${rank}</td>
						<td><button onclick = "deleteClick(${i})" class = "deleteBtn">삭제</button> 
								<button onclick = "changeClick(${i})" class = "changeBtn">수정</button></td>
				</tr>`
	}
	document.querySelector('.listTable').innerHTML = html
}

/*삭제 기능 */
function deleteClick(i){
	let inputInfo = confirm(studentArray[i].name + "의 정보를 삭제하시겠습니까?");
	
	if(inputInfo == true){
		studentArray.splice(i, 1);
		printScoreTable();
	}
}

//수정할 인덱스 => 여럿 {}에서 동일한 변수 사용하려고
let upIndex = -1; //index는 -1이 절대 생길 수 없기 때문에 안전하게 -1을 넣음
/*수정버튼 클릭시 수정할 인덱스 [i]*/
function changeClick(i){
	upIndex = i
	// 1. 수정 페이지 보여주기
	document.querySelector('.updateBox').style.display = 'block'; 
	
	document.querySelector('.updatename').value = studentArray[i].name;
	document.querySelector('.updatekor').value = studentArray[i].kor;
	document.querySelector('.updateeng').value = studentArray[i].eng;
	document.querySelector('.updatemat').value = studentArray[i].mat;
	
}

/*점수 수정 버튼을 클릭했을 때 */
let updateBtn = document.querySelector('.updateBtn');
updateBtn.addEventListener('click', ()=>{
	document.querySelector('.updateBox').style.display = 'none'; 
	
	if(confirm(studentArray[upIndex].name + "의 정보를 수정하시겠습니까?")){
		studentArray[upIndex].kor = parseInt(document.querySelector('.updatekor').value);
		studentArray[upIndex].eng = parseInt(document.querySelector('.updateeng').value);
		studentArray[upIndex].mat = parseInt(document.querySelector('.updatemat').value);
	}
	printScoreTable();
})
