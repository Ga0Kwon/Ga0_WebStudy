
function join(){
	console.log('join')
	
	//유효성 검사
	if(document.joinform.custno.value == ""){
		alert('회원번호를 입력해주세요.')
		document.joinform.custno.focus(); //커서 이동
		return false;
	}
	
	if(document.joinform.custname.value == ""){
		alert('회원성명을 입력해주세요.')
		document.joinform.custname.focus(); //커서 이동
		return false;
	}
	
	if(document.joinform.phone.value == ""){
		alert('전화번호를 입력해주세요.')
		document.joinform.phone.focus(); //커서 이동
		return false;
	}
	
	if(document.joinform.address.value == ""){
		alert('회원주수롤 입력해주세요.')
		document.joinform.address.focus(); //커서 이동
		return false;
	}
	
	if(document.joinform.joindate.value == ""){
		alert('가입일자를 입력해주세요.')
		document.joinform.joindate.focus(); //커서 이동
		return false;
	}
	
	if(document.joinform.grade.value == ""){
		alert('고객등급 입력해주세요.')
		document.joinform.grade.focus(); //커서 이동
		return false;
	}
	if(document.joinform.city.value == ""){
		alert('도시코드 입력해주세요.')
		document.joinform.city.focus(); //커서 이동
		return false;
	}
	
	document.joinform.submit(); //폼 전송
	
	alert('회원등록이 완료되었습니다.')
	
	
}