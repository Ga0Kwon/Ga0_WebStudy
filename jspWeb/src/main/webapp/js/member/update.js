
if(memberInfo.mid == null){
	alert('로그인하고 오세요.')
	location.href = "/jspWeb/member/login.jsp";
}

document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.newmemail').value = memberInfo.memail;
document.querySelector('.mimg').src = `/jspWeb/member/pimg/${memberInfo.mimg == null ? 'basic.jpg' : memberInfo.mimg}`;

/*회원 정보 수정 [유효성 검사 패스]*/
function setUpdate(){
	/*1. 첨부파일 없을 때  */
/*	let info = {
		mpwd : document.querySelector('.mpwd').value,
		newmpwd : document.querySelector('.newmpwd').value,
		newmemail : document.querySelector('.newmemail').value
	} */
	
	/*2. 첨부파일 있을 때 */
	let updateForm = document.querySelectorAll('.updateForm')[0];
	let updateFormData = new FormData(updateForm);
	
	//3. form에 데이터 추가
		//1) 체크박스 체크여부 확인
	updateFormData.set("defaultimg", document.querySelector('.defaultimg').checked);
	
	$.ajax({
		url : "/jspWeb/member",
		method : "put",
/*		data : info, 첨부파일 없을 때*/
		data : updateFormData,
		/* contentTyle, processData 둘다 false로 설정해야 multi 사용 가능
			-> 즉, 첨부파일 전송 가능*/
		contentType : false,
		processData : false,
		success : (r) =>{
			if(r == 'true'){
				alert('회원 정보가 수정되었습니다.')
				location.href = "/jspWeb/member/update.jsp"
			}else{
				alert('[수정 실패]비밀번호가 틀렸습니다.')
			}
		}
	})
}

/*사진 바꾸면 미리 보기*/
function premimg(object){
	let file = new FileReader();
	
	file.readAsDataURL(object.files[0]);
	
	file.onload = (e) => {
		document.querySelector('.mimg').src = e.target.result;
	}
}

/*체크박스 클릭시 파일 선택 못하도록 바꾸기*/
function onChecked(){
	let checked = document.querySelector('.defaultimg').checked;
	
	if(checked){
		document.querySelector('.mimg').src = "/jspWeb/member/pimg/basic.jpg";
		document.querySelector('.newmimg').disabled = true;
	}else{
		document.querySelector('.newmimg').disabled = false;
	}
}
