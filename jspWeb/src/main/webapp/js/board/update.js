let bno = document.querySelector('.bno').value;
console.log(bno)
getviewInfo();

//해당 정보 bno의 정보 가져오기
function getviewInfo(){
	
	$.ajax({
		url : "/jspWeb/board/info",
		data : {"type" : 2, "bno" : bno},
		method : "get",
		success : (r) => {
			if(r != null){
				console.log(r)
				document.querySelector('.btitle').value = r.btitle;
				document.querySelector('.bcontent').value = r.bcontent;
				
				//1. 기존 select option 가져와서 selected
				let cnoSelect = document.querySelector('.cno');
				// i는 0부터 옵션<option> 태그 개수만큼 반복
				for(let i = 0; i < cnoSelect.options.length; i++){
					// i번째 옵션<option>태그 값과 현재 가져온 r.cno값과 같으면
					if(cnoSelect.options[i].value == r.cno){
						cnoSelect.options[i].selected = true;
					}
				}
				let html = ``;
				if(r.bfile == null){ //없을 때
					html += '첨부파일 없음'
				}else{
					html += `기존 첨부파일 : <span class = "oldbfile">${r.bfile}</span>
							<button onclick = "bfileDelete()" type = "button">삭제</button>`
				}
				html += `새 첨부파일 :
						<input name = "bfile" class = "bfile" type = "file">`
				
				document.querySelector('.bfileBox').innerHTML = html;
			}else{
				alert("글 수정을 조회할 수 없네요. 관리자에게 문의해주세요.")
			}
			
		}
	})
}

function bUpdate(){
	
	let updateForm = document.querySelectorAll('.updateForm')[0]; 
	//1. form 안에 있는 데이터를 객체화 했다.
	let updateFormData = new FormData(updateForm);
	
	//2.form 밖에 있거나 js에 있는 추가 데이터는 form 데이터에 추가할 수 있다.
	/*	updateFormData.set('변수명', 데이터)*/
	// 방법 2
	updateFormData.set('bno', bno);
	
	$.ajax({
		url : "/jspWeb/board/info",
		method : "put",
		data : updateFormData, 
		contentType : false, 
		processData : false,
		success : (r) => {
			if(r == 'true'){
				alert('글 수정 성공!')
				location.href = `/jspWeb/board/view.jsp?bno=${bno}`;
			}else{
				alert('글 수정 실패.')
			}
		}
	})
}

function bfileDelete(){
	document.querySelector('.oldbfile').innerHTML = '';
	
	$.ajax({
		url : '/jspWeb/board/info',
		method : "delete",
		data : {"bno" : bno, "type" : 2}, //첨부파일만 삭제
		success : (r) => {
			if(r = 'true'){
				//특정 div만 relaod[랜더링] 방법!
					// 주의점!! : location.href+' 띄어쓰기한번[.클래스명]'
					//load() : jquery 제공하는 랜더링[새로고침] 함수
				$('.bfileBox').load(location.href+' .bfileBox');
				//$('.bfileBox').value = 데이터 => 이런식으로 써도 된다.
				// jquery : $('.클래스명') : 해당 클래스명을 가진 태그 객체화
				//vs.
				//js  : document.querySelector('.클래스명')
/*				document.querySelector('.bfileBox').load(location.href+' .bfileBox');*/
			}else{
				
			}
		}
	})
}