 function update(){
	 console.log('update')
	 
	 //유효성 검사
	if(document.updateform.custno.value == ""){
		alert('회원번호를 입력해주세요.')
		document.updateform.custno.focus(); //커서 이동
		return false;
	}
	
	if(document.updateform.custname.value == ""){
		alert('회원성명을 입력해주세요.')
		document.updateform.custname.focus(); //커서 이동
		return false;
	}
	
	if(document.updateform.phone.value == ""){
		alert('전화번호를 입력해주세요.')
		document.updateform.phone.focus(); //커서 이동
		return false;
	}
	
	if(document.updateform.address.value == ""){
		alert('회원주수롤 입력해주세요.')
		document.updateform.address.focus(); //커서 이동
		return false;
	}
	
	if(document.updateform.joindate.value == ""){
		alert('가입일자를 입력해주세요.')
		document.updateform.joindate.focus(); //커서 이동
		return false;
	}
	
	if(document.updateform.grade.value == ""){
		alert('고객등급 입력해주세요.')
		document.updateform.grade.focus(); //커서 이동
		return false;
	}
	if(document.updateform.city.value == ""){
		alert('도시코드 입력해주세요.')
		document.updateform.city.focus(); //커서 이동
		return false;
	}
	
	document.updateform.submit(); //폼 전송
	
	alert('회원수정이 완료되었습니다.')
 }