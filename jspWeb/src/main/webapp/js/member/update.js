
if(memberInfo.mid == null){
	alert('로그인하고 오세요.')
	location.href = "/jspWeb/member/login.jsp";
}

document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.newmemail').value = memberInfo.memail;
document.querySelector('.mimg').src = `/jspWeb/member/pimg/${memberInfo.mimg == null ? 'basic.jpg' : memberInfo.mimg}`;

/*회원 정보 수정 [유효성 검사 패스]*/
function setUpdate(){
	let count = 0;
	for(let i = 0; i < checkconfirm.length; i++){
		if(checkconfirm[i].innerHTML == 'O'){count++}
	}
	if(count != 2){alert('정상적으로 입력되지 않은 데이터가 있습니다.'); return;}
	
	/*1. 첨부파일 없을 때  */
	/*let info = {
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

let checkconfirm = document.querySelectorAll('.checkconfirm');

//비밀번호 유효성 검사
function pwdCheck(){

	let newmpwd =document.querySelector('.newmpwd').value;
	
	let mpwdj = /^(?=.*[A-Za-z])(?=.*[0-9])[A-Za-z0-9]{5,20}$/ 
	
	if(mpwdj.test(newmpwd)){
		pwdconfirmCheck();
	}else{
		checkconfirm[0].innerHTML = '영대소문자+숫자 조합 5~20글자로 입력해주세요.'
	}
}

//4. 비밀번호 확인 유효성 검사
function pwdconfirmCheck(){

	let mpwdconfirm =document.querySelector('.newmpwdconfirm').value;

	let mpwd =document.querySelector('.newmpwd').value;
	
	let mpwdj = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{5,20}$/ //정규표현식
	//3. 제어
	if(mpwdj.test(mpwdconfirm)){
		//두 비밀번호간의 동일성 체크
		if(mpwdconfirm == mpwd){ //두 비밀번호가 같으면 
			checkconfirm[0].innerHTML = 'O';
		}else{ //두 비밀번호가 같지 않으면
			checkconfirm[0].innerHTML = '두 비밀번호가 일치하지 않습니다.';
		}
	}else{
		checkconfirm[0].innerHTML = '영대소문자+숫자 조합 5~20글자로 입력해주세요.'
	}
}


//이메일 유효성 검사 [이메일 형식 유효성 검사]
function emailCheck(){
	let memail = document.querySelector('.newmemail').value;
	
	let memailj = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9]+$/;
	
	if(memailj.test(memail)){
		checkconfirm[1].innerHTML ='O'
		document.querySelector('.authBtn').disabled = false;
	}else{
		checkconfirm[1].innerHTML ='이메일 형식으로 입력해주세요.'
		document.querySelector('.authBtn').disabled = true;
	}
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
		document.querySelector('.mimg').src = "/jspWeb/member/pimg/" + memberInfo.mimg;
		document.querySelector('.newmimg').disabled = false;
	}
}
