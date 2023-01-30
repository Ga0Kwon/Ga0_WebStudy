let boardlist = [
   { no : 5 , title : '안녕하세요A' , writer : '유재석' , date : '2023-01-30' , view:325 , up : 9 , down : 1  } , 
   { no : 4 , title : '안녕하세요B' , writer : '강호동', date : '2023-01-27' , view:123 , up : 2 , down : 0  } , 
   { no : 3 , title : '안녕하세요C' , writer : '신동엽' , date : '2023-01-25' , view:753 , up : 3 , down : 0  } , 
   { no : 2 , title : '안녕하세요D' , writer : '서장훈' , date : '2023-01-24' , view:521 , up : 10 , down : 3  } , 
   { no : 1 , title : '안녕하세요E' , writer : '김희철' , date : '2023-01-23' , view:951 , up : 21 , down : 4 } 
]

printTable();

/*커뮤니티 테이블을 출력하는 함수 */
function printTable(){
	let html = ``;
	
	for(let i = 0; i < boardlist.length; i++){
		html +=  `<tr>
						<td>${boardlist[i].no}</td>
						<td>${boardlist[i].title}</td>
						<td>${boardlist[i].writer}</td>
						<td>${boardlist[i].date}</td>
						<td>${boardlist[i].view}</td>
						<td>${boardlist[i].up}</td>
						<td>${boardlist[i].down}</td>
				  </tr>`
	}
	
	document.querySelector('tbody').innerHTML = html;
}