/*1. JS 열렸을 때 */
alert("day02-index.js 열림");

/*특정 행동[이벤트] 있을 때 코드집합소[함수] 실행 */
function ex1(){
	/*변수 10개를 객체 1개로 바꾸기! */
	let info = {
		
	//DATA1[문자열]
	 data1 : document.querySelector('.data1').value,
	
	//DATA2[패스워드]
	 data2 : document.querySelector('.data2').value,
	
	//DATA3[실수]
	 data3 : document.querySelector('.data3').value,
	
	//DATA4[정수]
	 data4 : document.querySelector('.data4').value,
	
	//DATA5[날짜]
	 data5 : document.querySelector('.data5').value,
	
	//DATA6[날짜/시간]
	 data6 : document.querySelector('.data6').value,
	
	//DATA7[선택 상자] -> //라디오에서 선택된 버튼의 value
	 data7 : document.querySelector('input[name="data7"]:checked').value, 
	
	//DATA8[체크 상자] -> // 체크여부를 가져오는 [true/false]
	 data8 : document.querySelector('.data8').checked, 
	
	//DATA9[목록 상자]
	 data9 : document.querySelector('.data9').value,
	
	//DATA10[긴글 상자]
	 data10 : document.querySelector('.data10').value
		
	}
	console.log(info); //data7 제외 모두 문자열 
	
	
	$.ajax({ //* JQuery 라이브러리 필수!
		url :"/jspWeb/Ex2", //1. 서블릿 주소 [/프로젝트명/서블릿주소]
		method : "post", //2. 메소드 방식 [doGet vs doPost]
		data : info, //3. 보낼 데이터[객체 vs {}]
		success : function(result){
			if(result == 'true'){ //ajax는 문자만 전달가능하고 받을 수 있다.
				console.log("[전달 완료]")
				getInfo();
			}else{
				console.log("[전달 실패]")
			}
		}
	})
}

getInfo(); // JS 실행시 DB 정보 띄우기 

function getInfo(){
	$.ajax({
		url : "/jspWeb/Ex2",
		method : "get",
		//data : -> 주는 데이터 없음
		success : function(result){
			//console.log(result);
			//DTO 없는 버전 
			//document.querySelector('.ex2Box').innerHTML = result;
			let html = `<table border = "1">
							<tr>
								<th> data1 </th><th> data2 </th><th> data3 </th><th> data4 </th>
								<th> data5 </th><th> data6 </th><th> data7 </th><th> data8 </th>
								<th> data9 </th><th> data10 </th>
							<tr>`
			result.forEach((o, i)=>{ //객체명.forEach((반복변수, 반복인덱스) => {실행문})
				html += `
							<tr>
								<td> ${o.data1} </td><td> ${o.data2} </td><td> ${o.data3} </td><td> ${o.data4} </td>
								<td> ${o.data5} </td><td> ${o.data6} </td><td> ${o.data7} </td><td> ${o.data8} </td>
								<td> ${o.data9} </td><td> ${o.data10} </td>
							<tr>`
			})
			
			html += `</table>`
			document.querySelector('.ex2_1Box').innerHTML = html;
		}
	})
}

//등록 버튼 클릭시
function signup(){
	let signInfo = {
		
	 name : document.querySelector('.name').value,
	
	 phoneNumber : document.querySelector('.phoneNumber').value,
	
	 height : document.querySelector('.height').value,
	
	 age : document.querySelector('.age').value,
	
	 signDate : document.querySelector('.signDate').value,
	
	 sex : document.querySelector('input[name="sex"]:checked').value, 
	
	
	 agree : document.querySelector('.agree').checked, 
	
	
	 location : document.querySelector('.location').value,
	

	 introduce : document.querySelector('.introduce').value
	}
	
	$.ajax({
		url : "/jspWeb/Q2",
		method : "post",
		data : signInfo,
		success : function(result){
			if(result == 'true'){
				console.log('[등록 성공]');
				getStudentInfo();
			}else{
				console.log('[등록 실패]');
			}
		}
		
	})
}

getStudentInfo();

function getStudentInfo(){
	$.ajax({
		url : "/jspWeb/Q2",
		method : "get",
		success : function(studentInfo){
			let html = `<table border = "1">
							<tr> 
								<th> 번호 </th> <th> 이름 </th><th> 전화번호 </th><th> 키 </th><th> 나이 </th>
								<th> 등록일 </th><th> 성별 </th><th> 동의 </th><th> 지역 </th>
								<th> 소개 </th>
							<tr>`
							
			studentInfo.forEach((o, i) => {
				html += `
						<tr>
							<td> ${i} </td> <td> ${o.name} </td><td> ${o.phoneNumber} </td><td> ${o.height} </td><td> ${o.age} </td>
							<td> ${o.signDate} </td><td> ${o.sex} </td><td> ${o.agree} </td><td> ${o.location} </td>
							<td> ${o.introduce} </td>
						<tr>`
			})
			html += `</table>`
			document.querySelector('.studentInfo').innerHTML = html;
		}
	})
}