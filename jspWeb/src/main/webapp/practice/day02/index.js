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
			console.log(result);
			document.querySelector('.ex2_1Box').innerHTML = result;
		}
	})
}