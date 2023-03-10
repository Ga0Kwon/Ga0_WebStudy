/*
	주제 : 입력된 값으로 구구단 출력
		1. 단[input]과 곱[input] 입력받아 
		2. 확인 button 클릭하면 
		3. 테이블에 출력
*/

/*let tableRow += '<tr>'+'<td style="padding : 10px 20px;">'+ danValue+'</td>'
		+'<td style="padding : 10px 20px;">'+ 'X'+'</td>'
		+'<td style="padding : 10px 20px;">'+ i+'</td>'
		+'<td style="padding : 10px 20px;">'+ danValue*i+'</td>'+'</tr>';
}*/

function onCheck(){
	//input으로 입력받은 단을 가져옴.
	let gugudan_dan = document.querySelector('.gugudan_dan');
	//입력받은 단의 값을 변수 danValue에 저장
	let danValue = gugudan_dan.value;
	
	let h_dan = document.querySelector('.gugudanTitle');
	h_dan.innerHTML = '<h3 style = "color : green">' + danValue + '단' + '</h3>'

	//input으로 입력받은 곱을 가져옴.
	let gugudan_gop = document.querySelector('.gugudan_gop');
	//입력받은 곱의 값을 변수 gopValue에 저장
	let gopValue = Number(gugudan_gop.value);
	
	//헤더 부분을 초기값으로 두고 
	let tableRow = '<tr>'+'<th style="padding : 10px 20px;">'+ "단"+'</th>'
		+'<th style="padding : 10px 20px;">'+ 'X'+'</th>'
		+'<th style="padding : 10px 20px;">'+ "곱"+'</th>'
		+'<th style="padding : 10px 20px;">'+ "결과" +'</th>'+'</tr>';
	
	//3. <table> 행 <tr>만들기 
	for(let i = 1; i <= gopValue; i++){
		//헤더 부분 초기값을 가지고 있는 tableRow에 곱만큼 반복문을 돌려 구구단을 출력한다.
		//이 아래의 값이 함수 밖에 들어가게 되면 누적되어 밑에 차곡차곡 쌓인다.
		tableRow += '<tr>'+'<td style="padding : 10px 20px;">'+ danValue+'</td>'
		+'<td style="padding : 10px 20px;">'+ 'X'+'</td>'
		+'<td style="padding : 10px 20px;">'+ i+'</td>'
		+'<td style="padding : 10px 20px;">'+ danValue*i+'</td>'+'</tr>';
	}
	let content = document.querySelector('.gugudan_Table');
	content.innerHTML = tableRow
	
	//구구단을 전부 출력했다면, input안에 text를 지운다.[초기화]
	document.getElementById("dan").value ='';
	document.getElementById("gop").value ='';
}
