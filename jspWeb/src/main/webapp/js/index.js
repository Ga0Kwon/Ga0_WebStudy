alert("js 실행 -- 버튼 눌림");

//JS 함수
//function 함수명 (매개 변수){실행 코드}

function 예제(){
	// document : 미리 만들어진 DOM 객체
		// querySelector(식별자)
			//1. .클래스
			//2. #아이디
		//querySelectorAll(식별자) => tag 여러개 => 배열/리스트에 저장
		
		//querySelector().속성명
			//1. querySelector().value : input, select, textarea [div x, table x]
			//2. querySelector().innerHtml : div, span, td 등등
			
	let data = document.querySelector('.inputData').value;
	console.log(data);
	
	
	// js --> 서블릿 이동
	//0. $ : jquery 표현식
	//1. ajax 메소드 사용 $.ajax();
	//2. ajax 매개변수 [속성 : 객체 형태] : { } --> $.ajax({})
	//3. 속성
		//1. url : 통신할 경로 [서블릿(클래스) 주소 : /프로젝트명/클래스명]
		//2. method : http 메소드방식
			/*
				get
				post
			 */
		//3. data : 통신할때 보낼 데이터 
			/*
				js객체 형태 : {매개변수명1 : 데이터, 매개변수명2 : 데이터~~ㄴ}
			*/
		//4. success :통신후 응답
			/*
				1. success : function(매개변수){}
				2. success : (매개변수) => {} 
			*/
	/* 
	
		$.ajax({
			url : "",
			method : "",
			data : 매개변수명 : 값},
		 	success : function(result){
				 
			}
		);
	*/	
	
/*	$.ajax({
		url : "http://localhost:8080/jspWeb/Ex1", //통신할 서블릿 주소
		method : "get", //HTTP 메소드
		data : {"data" : data + " get"}, //데이터 보내기
		success : function(result){
			console.log(result);
		} //데이터 받기  		
	})
*/

		$.ajax({
		url : "/jspWeb/Ex1", //통신할 서블릿 주소
		method : "post", //HTTP 메소드
		data : {"data" : data + " post"}, //데이터 보내기
		success : function(result){
			console.log(result);
			Ex2();
		} //데이터 받기  		
	})
}
Ex2();

function Ex2(){
	$.ajax({
		url : "/jspWeb/Ex1",
		method : "get",
		//data : {}, => 생략
		success : function(result){
			console.log(result);
			document.querySelector('.ex2box').innerHTML = result;
		}
	})
}

function 과제post(){
	let data2 = document.querySelector('.inputData2').value;
	console.log(data2);
	
	$.ajax({
		url : "/jspWeb/Q1", //통신할 서블릿 주소
		method : "post", //HTTP 메소드
		data : {"data2" : data2}, //데이터 보내기
		success : function(result){
			console.log(result);
			과제get();
		} //데이터 받기  		
	})
}

과제get();

function 과제get(){
	$.ajax({
		url : "/jspWeb/Q1",
		method : "get",
		//data : {}, => 생략
		success : function(result){
			console.log(result);
			document.querySelector('.q1box').innerHTML = result;
		}
	})
}