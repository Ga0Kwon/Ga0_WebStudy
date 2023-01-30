//1.임의의 객체 배열
/*
	state = 0 이면 처리 안된 상태, state = 1이면 처리 완료
*/
let qboardList =[
	 { no : 5 , title : '문의드립니다E.' , writer : '유재석' , writeDate : '2023-01-28' , view:325 , state : 0 , completeDate :  '-'  } ,
	 { no : 4 , title : '문의드립니다D.' , writer : '강호동' , writeDate : '2023-01-27' , view:325 , state : 0 , completeDate : '-'   } ,
	 { no : 3 , title : '문의드립니다C.' , writer : '신동엽' , writeDate : '2023-01-26' , view:325 , state : 0 , completeDate : '-'  } ,
	 { no : 2 , title : '문의드립니다B.' , writer : '서장훈' , writeDate : '2023-01-25' , view:325 , state : 1 , completeDate :  '2023-01-27'   } ,
	 { no : 1 , title : '문의드립니다A.' , writer : '김희철' , writeDate : '2023-01-24' , view:325 , state : 1 , completeDate :  '2023-01-27'  } , 
]

printQBoardTable(null, null);

function printQBoardTable(keyword, inputData){
	let html = ``
	if(keyword == null && inputData == null){
		
		for(let i = 0; i < qboardList.length; i++){
			html +=  onSearchTable(i);
		}
	}else{
		if(keyword == "no"){
			for(let i = 0; i < qboardList.length; i++){
				if(inputData == qboardList[i].no){
					html += onSearchTable(i);
				}
			}
		}else if(keyword == "title"){
			for(let i = 0; i < qboardList.length; i++){
				if(inputData == qboardList[i].title){
					html += onSearchTable(i);
				}
			}
		}else if (keyword == "writer"){
			for(let i = 0; i < qboardList.length; i++){
				if(inputData == qboardList[i].writer){
					html += onSearchTable(i);
				}
			}
		}else{
			alert('키워드를 제대로 입력해주세요.')
		}
	}
	
	document.querySelector('tbody').innerHTML = html;
}

function onSearch(){
	let keyword = document.querySelector('.select_item').value;
	let searchData = document.querySelector('.input_txt').value;
	printQBoardTable(keyword, searchData)
}

function onSearchTable(i){
	let html = ``
	html = `<tr>
					<td>${qboardList[i].no}</td>
					<td><a href = "view.html">${qboardList[i].title}</a></td>
					<td>${qboardList[i].writer}</td>
					<td>${qboardList[i].writeDate}</td>
					<td>${qboardList[i].view}</td>
					<td>${qboardList[i].state == 0 ? '접수' : '처리완료' }</td>
					<td>${qboardList[i].completeDate}</td>
				 </tr>`
	return html;
}