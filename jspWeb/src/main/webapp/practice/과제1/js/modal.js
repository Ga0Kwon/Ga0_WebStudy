
/*모달 열기*/
function openModal(what, emno){
	
	/*열기*/
	document.querySelector('.modal_wrap').style.display = 'flex';
	
	if(what == 1){
		$.ajax({
			url : "/jspWeb/searchEmployee",
			method : "get",
			data : {"emno" : emno},
			success : (r) =>{
				let departName = '';
				if(r.emdepartno == 1){departName = "영업팀"}
				else if(r.emdepartno == 2){departName = "인사팀"}
				else if(r.emdepartno == 3){departName = "개발팀"}
				
				document.querySelector('.modal_title').innerHTML = "[직원 번호 : " + emno + "] 정보 수정";
				document.querySelector('.modal_content').innerHTML = `
				<form class = "updateForm">
					<div>
						<img width = "20%" class= "newemimg" src="/jspWeb/member/pimg/${ r.emimg == null ? 'basic.jpg' : r.emimg }" width="30%">
						<br> 사원 사진 변경 <input onchange = "premimg(this)" type = "file" name = "newmimg" class = "newmimg">
					</div>
					<div class = "block">
						<div>사원명 수정</div>
						<input type = "text" class ="emname" name = "emname" value = ${r.emname}>
					</div>
					<div class = "block">
						<div>직급 수정 [현재 직급 : ${r.emrank}] </div>
						<select class = "emrank" name ="emrank">
							<option value = "부장">부장</option>
							<option value = "차장">차장</option>
							<option value = "과장">과장</option>
							<option value = "대리">대리</option>
							<option value = "사원">사원</option>
							<option value = "인턴">인턴</option>
						</select>
					</div>
					<div class = "block">
						<div>고용형태 수정 [현재 고용형태 : ${r.emtype}]</div>
						<select class = "emtype" name = "emtype" data-emtype = ${r.emtype}>
							<option value = "임원">임원</option>
							<option value = "정규직">정규직</option>
							<option value = "일용직">일용직</option>
						</select>
					</div>
					<div class = "block">
						<div>부서 이동 [현재 부서 : ${departName}] </div>
						<select class = "emdepartname" name = "emdepartname" data-emdepartname = ${r.emdepartno}>
							<option value = "인사팀">인사팀</option>
							<option value = "영업팀">영업팀</option>
							<option value = "개발팀" >개발팀</option>
						</select>
					</div>
					<div class = "block">
						<div>입사일</div>
						<input class = "emindate" type = "date" name = "emindate" value = ${r.emindate}>
					</div>
					<div class = "block">
						<div>퇴사일</div>
				   		<input class = "emoutdate" type = "date" name = "emoutdate" value = ${r.emoutdate}>
					</div>
					<div class = "block">
						<div>퇴사 사유 수정</div>
						<input type = "text" class ="emoutreason" name = "emoutreason" value = ${r.emoutreason}>
					</div>
			</form>`
			
			document.querySelector('.modal_btns').innerHTML = `
		   			<button onClick = "updateEmployee(${emno})" class = "modal_check" type = "button">확인</button>
					<button onClick = "closeModal()" class = "closeModal" type = "button">취소</button>`
				}
		})
		
				
	}else if(what == 2){
		document.querySelector('.modal_title').innerHTML = "[직원 번호 : " + emno + "] 퇴사 처리";
		document.querySelector('.modal_content').innerHTML =  emno + " 직원을 퇴사 처리 하시겠습니까?"
			+ `
			   	<form class = "updateForm">
				   	<div>
				   		<div>직원 번호</div>
				   		<input class = "emno" maxlength = "20" type = "text">
				   	</div>
			   	</form>`
			   	
	   	document.querySelector('.modal_btns').innerHTML = `
	   			<button onClick = "deleteEmployee(${emno})" class = "modal_check" type = "button">확인</button>
				<button onClick = "closeModal()" class = "closeModal" type = "button">취소</button>`
	
	}
}

/*모달 열기*/
function closeModal(){
	/*닫기*/
	document.querySelector('.modal_wrap').style.display = 'none';

}

/*사진 바꾸면 미리 보기*/
function premimg(object){
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0]);
	
	file.onload = (e) => {
		document.querySelector('.mimg').src = e.target.result;
	}
}

// 사원 퇴사
function deleteEmployee(emno){
	
	$.ajax({
		url : "/jspWeb/employee",
		method : "delete",
		data : {"emno" : emno},
		success : (r) =>{
			if(r == 'true'){
				alert('[퇴직 처리 완료]');
				location.href = "/jspWeb/practice/과제1/index.jsp"
			}else{
				alert('퇴사처리 실패, 직원 번호가 다릅니다.')
			}
		}
	})		
}

//사원정보 수정
function updateEmployee(emno){
	
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData(updateForm);
	
	updateFormData.set("emno", emno);
	
/*	updateForm.set("emrank", document.querySelector('.emrank').value);
	updateForm.set("emtype", document.querySelector('.emtype').value);
	updateForm.set("emdepartname", document.querySelector('.emdepartname').value);*/
	
	
	$.ajax({
		url : "/jspWeb/employee",
		method : "put",
		data : updateFormData,
		contentType : false,
		processData : false,
		success : (r) =>{
			if(r == 'true'){
				alert('직원 정보 수정 완료');
				location.href = "/jspWeb/practice/과제1/index.jsp"
			}else{
				alert('직원정보 수정 실패')
			}
		}
	})
}

/*사진 바꾸면 미리 보기*/
function premimg(object){
	alert('preming')
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0]);
	
	file.onload = (e) => {
		document.querySelector('.newemimg').src = e.target.result;
	}
}


