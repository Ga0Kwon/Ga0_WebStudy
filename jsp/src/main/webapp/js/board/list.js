//1. DB -> JAVA로 전달된 게시물리스트 데이터
let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
]

printTable(null, null); //1.js 열렸을 때 함수 실행

/*1. 게시물 출력 함수 
	[1. js 열렸을 때 2. 검색했을 때]
	1. 검색이 없을 때 null, null
	2. 검색이 있을 때 data, keyword
	3. 페이지전환되었을 때
*/


function printTable(keyword, data){
	//1. JAVA[백엔드]로 부터 데이터 요청
		let html = ``;

		// 1. 검색이 없는 경우
		if(keyword == null && data == null){
			//2. [요청된 결과] DB -> JAVA로 전달된 게시물리스트 데이터
			for(let i = 0; i < boardlist.length; i++){
				html +=  `<tr>
								<td>${boardlist[i].no}</td>
								<td><a href = "view.html">${boardlist[i].title}</a></td>
								<td>${boardlist[i].writer}</td>
								<td>${boardlist[i].date}</td>
								<td>${boardlist[i].view}</td>
								<td>${boardlist[i].up}</td>
								<td>${boardlist[i].down}</td>
						  </tr>`
			}
		}else{ /*검색이 있는 경우 */
			if(keyword == "no" && data.length >= 0){
				for(let i = 0; i < boardlist.length; i++){
					if(data == boardlist[i].no){
						html +=  `<tr>
									<td>${boardlist[i].no}</td>
									<td><a href = "view.html">${boardlist[i].title}</a></td>
									<td>${boardlist[i].writer}</td>
									<td>${boardlist[i].date}</td>
									<td>${boardlist[i].view}</td>
									<td>${boardlist[i].up}</td>
									<td>${boardlist[i].down}</td>
						 		 </tr>`
					}
				}
				
			}else if(keyword == "title" && data.length >= 0){
				for(let i = 0; i < boardlist.length; i++){
					if(data == boardlist[i].title){
						html +=  `<tr>
									<td>${boardlist[i].no}</td>
									<td><a href = "view.html">${boardlist[i].title}</a></td>
									<td>${boardlist[i].writer}</td>
									<td>${boardlist[i].date}</td>
									<td>${boardlist[i].view}</td>
									<td>${boardlist[i].up}</td>
									<td>${boardlist[i].down}</td>
						 		 </tr>`
					}
				}
			}else if(keyword == "writer" && data.length >= 0){
				for(let i = 0; i < boardlist.length; i++){
					if(data == boardlist[i].writer){
						html +=  `<tr>
									<td>${boardlist[i].no}</td>
									<td><a href = "view.html">${boardlist[i].title}</a></td>
									<td>${boardlist[i].writer}</td>
									<td>${boardlist[i].date}</td>
									<td>${boardlist[i].view}</td>
									<td>${boardlist[i].up}</td>
									<td>${boardlist[i].down}</td>
						 		 </tr>`
					}
				}
			}else if(keyword == "키워드"){
				alert('검색할 키워드를 선택해주세요.')
				printTable(null, null);
			}else if(data.length <= 0){
				alert('검색할 내용을 제대로 입력해주세요.')
			}
		}
	console.log(keyword, data)
	
	document.querySelector('tbody').innerHTML = html;
}

let searchBtn = document.querySelector('.search_btn');

/*검색버튼을 눌렀을 때 이벤트 */
searchBtn.addEventListener('click', (e) => {
	/*키워드를 가져온다. */
	let searchKeyword = document.querySelector('.form-select').value;
	/*검색어를 가져온다. */
	let searchData =  document.querySelector('.input_txt').value;
	
	console.log(searchKeyword);
	console.log(searchData);
	
	printTable(searchKeyword, searchData)
})

/*function viewPoint(index){
	let result = true; 
	console.log(index)
	if(result) { location.href = 'view.html'}
	else {}
}*/
/*
	배열 반복문
		1. for(let i = 0; i < 배열명.length; i++)
		2. 배열명.forEach(() => { })
*/