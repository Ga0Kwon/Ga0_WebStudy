/*alert('문의 사항 write.js 실행')*/

let 문의사항임시저장소 = [];

function qboardWrite(){
	let qboard = {
		title : document.querySelector('.qtitle').value,
		password : parseInt(document.querySelector('.qpassword').value),
		writer :  document.querySelector('.qwriter').value,
		content : document.querySelector('.qcontent').value,
	}
	console.log(qboard)
	
	let writeForm = document.querySelector('.write_form');
	let formData = new FormData(writeForm);
	
	console.log(writeForm)
	console.log(formData)
	
	if(checkObject(qboard) == 0){
		문의사항임시저장소.push(qboard); console.log(문의사항임시저장소);
		alert('글쓰기 성공!')
		location.href = 'list.html'
	}else{
		alert('글쓰기 실패')
	}
	
}
/*유효성 검사 */
function checkObject(info){
	let check = 0;
	
	if(info.title.length <= 0){
		alert('제목을 입력해주세요')
		check++;
	}
	
	if(isNaN(info.password)){
		alert('비밀번호는 숫자로입력해주세요.')
		check++;
	}
	
	if(info.writer.length <= 0){
		alert('작성자를 입력해주세요.')
		check++;
	}
	
	if(info.content.length <= 0){
		alert('내용을 입력해주세요.')
		check++;
	}
	
	return check;
	
}

//취소 버튼
function reset(){
	document.querySelector('.qtitle').value = "";
	document.querySelector('.qpassword').value = ""
	document.querySelector('.qwriter').value = ""
	document.querySelector('.qcontent').value = ""
}
