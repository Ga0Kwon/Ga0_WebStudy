/*공통 */
let categoryList = ['프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거'];

let burgerList = [{img : '기네스와퍼.png', name : '기네스와퍼', price : 9500, category : '프리미엄', productNo : '1674104004537-334'},
				  {img : '기네스콰트로치즈와퍼.png', name : '기네스콰트로치즈와퍼', price : 10000, category : '프리미엄', productNo : '1674104004537-335'},
				  {img : '몬스터X.png', name : '몬스터X', price : 8800, category : '프리미엄', productNo : '1674104004537-336'},
				  {img : '몬스터와퍼.png', name : '몬스터와퍼', price : 8500, category : '프리미엄', productNo : '1674104004537-337'},
				  {img : '콰트로치즈X.png', name : '콰트로치즈X', price : 7800, category : '프리미엄', productNo : '1674104004537-338'},
				  {img : '콰트로치즈와퍼.png', name : '콰트로치즈와퍼', price : 9000, category : '프리미엄', productNo : '1674104004537-339'},
				  {img : '통새우와퍼.png', name : '통새우와퍼', price : 6500, category : '프리미엄', productNo : '1674104004537-340'},
				  {img : 'BLT오믈렛킹모닝.png', name : 'BLT오믈렛킹모닝', price : 8800, category : '올데이킹', productNo : '1674104004537-341'},
				  {img : '오믈렛킹모닝.png', name : '오믈렛킹모닝', price : 6500, category : '올데이킹', productNo : '1674104004537-342'},
				  {img : '불고기몬스터세트.png', name : '불고기몬스터세트', price : 9500, category : '올데이킹', productNo : '1674104004537-343'},
				  {img : '타바스코몬스터.png', name : '타바스코몬스터', price : 10500, category : '올데이킹', productNo : '1674104004537-344'},
				  {img : '더블오리지널치즈버거세트.png', name : '더블오리지널치즈버거세트', price : 10000, category : '올데이킹', productNo : '1674104004537-345'},
				  {img : '타바스코더블비프.png', name : '타바스코더블비프', price : 7900, category : '올데이킹', productNo : '1674104004537-346'},
				  {img : '통새우와퍼주니어세트.png', name : '통새우와퍼주니어세트', price : 9900, category : '올데이킹', productNo : '1674104004537-347'},
			  	  {img : '치즈버거.png', name : '치즈버거', price : 4500, category : '올데이킹', productNo : '1674104004537-348'},
	  	  		  {img : '치킨킹팩1.png', name : '치킨킹팩1', price : 11000, category : '스페셜', productNo : '1674104004537-349'},
				  {img : '치킨킹팩2.png', name : '치킨킹팩2', price : 11500, category : '스페셜', productNo : '1674104004537-350'},
				  {img : '치킨킹팩3.png', name : '치킨킹팩3', price : 12000, category : '스페셜', productNo : '1674104004537-351'},
				  {img : '블랙어니언팩1.png', name : '블랙어니언팩1', price : 12000, category : '스페셜', productNo : '1674104004537-352'},
				  {img : '블랙어니언팩2.png', name : '블랙어니언팩2', price : 13000, category : '스페셜',productNo : '1674104004537-353'},
				  {img : '블랙어니언팩3.png', name : '블랙어니언팩3', price : 13000, category : '스페셜', productNo : '1674104004537-354'},
				  {img : '스태커2와퍼.png', name : '스태커2와퍼', price : 9800, category : '와퍼', productNo : '1674104004537-355'},
				  {img : '스태커3와퍼.png', name : '스태커3와퍼', price : 10800, category : '와퍼', productNo : '1674104004537-356'},
				  {img : '갈릭불고기와퍼.png', name : '갈릭불고기와퍼', price : 7900, category : '와퍼', productNo : '1674104004537-357'},
				  {img : '베이컨치즈와퍼.png', name : '베이컨치즈와퍼', price : 6900, category : '와퍼', productNo : '1674104004537-358'},
				  {img : '할라피뇨와퍼.png', name : '할라피뇨와퍼', price : 7600, category : '와퍼', productNo : '1674104004537-359'},
				  {img : '치즈와퍼.png', name : '치즈와퍼', price : 4500, category : '와퍼', productNo : '1674104004537-360'},
				  {img : '와퍼.png', name : '와퍼', price : 3900, category : '와퍼',productNo : '1674104004537-361'},
				  {img : '불고기와퍼.png', name : '불고기와퍼', price : 4900, category : '와퍼', productNo : '1674104004537-362'},
				  {img : '와퍼주니어.png', name : '와퍼주니어', price : 3900, category : '와퍼',productNo : '1674104004537-363'},
				  {img : '불고기와퍼주니어.png', name : '불고기와퍼주니어', price : 4200, category : '와퍼', productNo : '1674104004537-364'},
				  {img : '비프&슈림프버거.png', name : '비프&슈림프버거', price : 8900, category : '치킨버거', productNo : '1674104004537-365'},
				  {img : '통새우슈림프버거.png', name : '통새우슈림프버거', price : 8200, category : '치킨버거', productNo : '1674104004537-366'},
				  {img : '잔망루피슈림프버거.png', name : '잔망루피슈림프버거', price : 4000, category : '치킨버거', productNo : '1674104004537-367'},
				  {img : '롱치킨버거.png', name : '롱치킨버거', price : 4600, category : '치킨버거',productNo : '1674104004537-368'},
				  {img : '바비큐킹치킨버거.png', name : '바비큐킹치킨버거', price : 4800, category : '치킨버거', productNo : '1674104004537-369'},
				  {img : '킹치킨버거.png', name : '킹치킨버거', price : 4700, category : '치킨버거', productNo : '1674104004537-370'},
];

let cartList = []; //카트 목록

let orderList = []; //주문 목록

/*매출현황 정보를 가지고 있는 객체를 담는 배열 생성 */
let salseInfo = [];
/*
let adminCategory = ['등록된버거현항', '주문된주문목록현황', '매출현황']*/

function createSalesObject(){
	let salesBurgerTable = { }
	for(let i = 0; i < burgerList.length; i++){
/*		console.log(i)*/
		salesBurgerTable = {
			productNo : burgerList[i].productNo,
			productNm : burgerList[i].name,
			productSalse : 0,
			productSalsePrice : 0,
			productRank : 1,
		}
		salseInfo.push(salesBurgerTable)
	}
}

setting();

/*삭제될때도 수정될때도 하나하나 다시 새로고침해야하기 때문에 새로고침해야하는 것들을 모아 함수로 만들었습니다. */
function setting(){
	printCategory();
	categorySelect(0); //처음 클릭되어 있는[기본값] : 프리미엄
	printProduct(0); //0 : 프리미엄
	printInsertCurrentable();
	createSalesObject(0)
}


//1. 카테고리 출력하는 함수 [1. js 열렸을 때]
function printCategory(){
	// 1) 기본 HTML 구성
	let html = `<ul>`
	for(let i  = 0; i < categoryList.length; i++){
		html += `<li class = "categoryListItem" onClick = "categorySelect(${i})">${categoryList[i]}</li>`
	}
	html += `</ul>`
	
	// 2) 해당 마크업에 HTML 출력
	document.querySelector('.categoryBox').innerHTML = html
	
}

//2. 카테고리 선택 함수
function categorySelect(i){ //i : 선택된 li의 인덱스
	//1. 모든 li 가져와서 배열 저장
	let categoryArrays = document.querySelectorAll('.categoryListItem');
	// 2. .모든 li 배열 반복문
	for(let j = 0; j < categoryArrays.length; j++){ //만약에 li배열에서 내가 선택된 li의 인덱스와 같으면
		if(j == i){ //선택된 li
			categoryArrays[j].classList.add('categorySelectItem'); //해당 마크업의 class 식벽자 추가
		}else{
			categoryArrays[j].classList.remove('categorySelectItem'); //해당 마크업의 class 식별자 제거
		}
	}
	printProduct(i);
}

				
//3. 제품 출력 함수 // [1. js열렸을 때 2.카테고리 바뀌었을 때]
function printProduct(index){
	//1) html 구성
	let html = ``
	// i는 0번째 인덱스부터 마지막 인덱스까지 버거 객체를 가져온다.
	for(let i = 0; i < burgerList.length; i++){
		
		if(burgerList[i].category == categoryList[index]){
			// i번째 버거 객체의 카테고리와 선택된 카테고리와 같으면 
			html += `<div onClick = "addCart(${i})" class = "hamburger">
						<img src = "img/burger/${burgerList[i].img}" width = "100%"/>
						<div class = "hamburgerInfo">
							<div class ="hamburgerTitle">
								${burgerList[i].name}
							</div>
							<div class ="hamburgerPrice">
								${(burgerList[i].price).toLocaleString()}원
							</div>
						</div>
					</div>`	
			//천단위로 쉼표 넣어줌 -> toLocaleString 대신 문자열로 바뀜
		}
	}
	
	//2) 구성된 html를 마크업 대입
	document.querySelector('.product').innerHTML = html
}

function addCart(index){
	cartList.push(burgerList[index]);
	printCart()
}

function printCart(){
	let totalPrice = 0;
	
	for(let i = 0; i < cartList.length; i++){
		totalPrice += cartList[i].price;
	}
	
	document.querySelector('.cartCount').innerHTML = cartList.length;

	document.querySelector('.pTotal').innerHTML = totalPrice.toLocaleString();
	
	let html = ``;
	for(let i = 0; i < cartList.length; i++){
		html += `<div class = "item"> 
						<div class = "hamburgerTitle">${cartList[i].name}</div>
						<div class = "hamburgerPrice">${cartList[i].price}원</div>
					</div>`
				
	}
	document.querySelector('.cartBottom').innerHTML = html;
}

/*주문 취소  -> 모든 취소이므로 인덱스를 인수로 안받아도된다.*/
function onCancel(){
	if(confirm('카트를 비우겠습니까?')){
		cartList.splice(0);
		printCart()
	}else{
		return;
	}
	
}

/*전역변수는 선언이 한번되는 변수. -> 그래서 초기화하면 참조할 수 없게된다.  */

/*주문 */
function onOrder(){
	let number = 0;
	let orderDate = new Date().toLocaleString();
	//마지막 인덱스 : 배열명.length - 1
	if(orderList.length == 0){
		/*주문이 한개도 없으면 주문번호 1 */
		number = 1
	}else{
		/*아니면 마지막 인덱스 주문객체의 주문 번호 + 1 다음 주문번호 사용 */
		number = orderList[orderList.length-1].number+1
	} 
	//주문이 삭제되어도 number은 줄어들지 않는다.
	
	//3. 
/*	cartList.forEach((o) => {console.log(o)})
	cartList.map((o) => {console.log(o)})
	*/
	//카트배열 -> 새로운 배열 [주문 객체에 카트 배열 대입시 카트배열 초기화시 주문객체나 카트배열도 초기화 = 메모리 동일하기 때문]
	let mapCartLsit = cartList.map((o) =>{ return o;})
	//2. 총 가격 만들기 
	let totalPrice = 0;
	for(let i = 0; i < mapCartLsit.length; i++){
		totalPrice += mapCartLsit[i].price;
	}
/*	console.log(totalPrice)*/
	if(confirm('주문하시겠습니까?')){
		/*카트 리스트 ~~~~~~~~~~~~~~~> 주문 페이지로 */
		//1. 주문
		//1) order 객체 만들기
		//cartList만 쓰면 참조형식으로 가져오는데 메모리를 지우게 되면 없어짐...
		/*map() : 반복문 함수이다. */
		let order = {
			number : number, //고유한 주문번호를 만들어야함.
			items : mapCartLsit, //새로운 객체를 만듦가 동시에 cartList의 객체정보를 가져옴.
			time : orderDate, //new Date() : 현재 날짜와 시간을 알려줌
			state : true, //true : 일단 주문 -> false : 주문 완료
			complete : 0, //아직 주문 완료 되기 전이기 때문에 0
			price : totalPrice  
		}
		//2) order 객체 배열에 저장
		orderList.push(order)
		printOrderTable(orderList)
		console.log(orderList)
		/*console.log(order)*/
		cartList.splice(0); //cartList를 다른 곳에서 써야한다면 -> cartList.splice(0)하기전에 옮겨야함.
	}else{
		return;
	}
}

/* 제품번호 만드는 함수 */
function makeProductNo(){
	//현재 시간을 밀리초단위로 받고 버거리스트의 길이 + 1넣어주면 고유값이 나올 수밖에 없다.
	let productNo = Date.now() + "-" + (burgerList.length)+1;
	return productNo;
} 

/*버거 신규 등록해서 키오스크에 띄우는 함수 */
function insertBurger(){
	let check = 0;
	
	let newBurgerInfo = {
		img : 'insert_' + document.querySelector('.inputImgName').value,
		name : document.querySelector('.inputBurgerName').value,
		price : parseInt(document.querySelector('.inputPrice').value),
		category : document.querySelector('.inputCategory').value,
		productNo : makeProductNo()
		
	}
	/*가격에 문자가 들어갔을 경우 */
	if(isNaN(newBurgerInfo.price)){
		alert('숫자로만 입력해주세요.')
		document.querySelector('.inputPrice').value = "";
		check++;
	}
	
	
	/*있는 버거를 신규등록할 경우 -> 중복 */
	for(let i = 0; i < burgerList.length; i++){
		if(burgerList[i].name == newBurgerInfo.name){
			alert('이미 등록된 버거입니다.')
			check++;
		}
	}
	
	/*유효성 검사를 통과했을 경우 */
	if(check == 0){
		let categoryIndex = categoryList.indexOf(newBurgerInfo.category);
		burgerList.push(newBurgerInfo);
		categorySelect(categoryIndex);
		printProduct(categoryIndex)
		printInsertCurrentable();
		
		alert("새로운 버거가 등록되었습니다.")
		
		/*등록했다면 input의 값을 초기화 해준다. [지워줌] */
		document.querySelector('.inputPrice').value = "";
		document.querySelector('.inputBurgerName').value ="";
		document.querySelector('.inputImgName').value = "";
		document.querySelector('.inputCategory').value = ""
	}

}

/*버거 등록해서 등록된 버거 현황 테이블에 띄우는 함수 */
function printInsertCurrentable(){
	let html = `<tr>
					<th class = "productNo">제품번호</th>
					<th class = "burgerImg">버거이미지</th>
					<th class = "burgerName">버거이름</th>
					<th class = "burgerCategory">카테고리</th>
					<th class = "burgerPrice">가격</th>
					<th class = "insertRemark">비고</th>
				</tr>`
	/* 신규가 아니더라도 기존에 있는 버거도 등록된 버거이므로 테이블 전체에 모든 등록된 버거를 띄운다. */
	for(let i = 0; i < burgerList.length; i++){
		html += `<tr>
					<td class = "productNo">${burgerList[i].productNo}</td>
					<td class = "burgerImg"><img src = "img/burger/${burgerList[i].img}" width = "100%"/></td>
					<td class = "burgerName">${burgerList[i].name}</td>
					<td class = "burgerCategory">${burgerList[i].category}</td>
					<td class = "burgerPrice">${(burgerList[i].price).toLocaleString()}원</td>
					<td class = "insertRemark">
						<div>
							<button class = "deleteBurgerBtn" onClick = "deleteBurger(${i})">삭제</button>
							<button class = "changePriceBtn" onClick = "changePrice(${i})">가격수정</button>
						</div>
					</td>
				</tr>`
	}
	document.querySelector('.insertCurrentTable').innerHTML = html
}

/*버거 목록에서 버거 삭제하는 함수 => 삭제버튼*/
function deleteBurger(i){
	if(confirm(burgerList[i].name+ "을 버거 목록에서 삭제하시겠습니까?")){
		let deleteBurgerName = burgerList[i].name 
		burgerList.splice(i, 1);
		alert(deleteBurgerName + '가 버거 목록에서 삭제되었습니다.')
		setting();
		
	}else{
		return;
	}
}

/*버거 가격을 수정하는 함수 -> 수정 버튼 */
function changePrice(i){
	let changeBurgerPrice = parseInt(prompt(burgerList[i].name+ '의 수정하실 가격을 입력해주세요.'))

	burgerList[i].price = parseInt(changeBurgerPrice);
	alert(burgerList[i].name + '의 가격이 수정되었습니다.')
	setting();
}

/*주문된 주문 목록 현황 테이블 띄우기 */
function printOrderTable(){
/*	console.log(orderList)*/
	let html = `<tr>
					<th class = "orderNo">주문번호</th>
					<th class = "orderburgerName">버거이름</th>
					<th class = "orderState">상태</th>
					<th class = "orderRemark">비고</th>
				</tr>`
	for(let i = 0; i < orderList.length; i++){
		let burgerNameList = orderList[i].items;
		let useBurgerNameList = []
		for(let j = 0; j < burgerNameList.length; j++){
			useBurgerNameList.push(burgerNameList[j].name)
		}
/*		console.log(useBurgerNameList)
		console.log(burgerNameList)*/
					
		for(let j = 0; j < useBurgerNameList.length; j++){
			html += `<tr>
					<td class = "orderNo">${orderList[i].number}</td>
					<td class = "orderburgerName">${burgerNameList[j].name}</td>
					<td class = "orderState">${orderList[i].state ? "주문요청" : 
					`<div class = "orderFinishText" >주문 완료</div>`}</td>
				<td class = "orderRemark">
					<div class = "showOrderBtn">
						${orderList[i].state ? 
						`<button class = "orderCompleteBtn" onClick = "onOrderComplete(${i})">주문완료</button>` 
						: `<div class = "orderFinishText">주문처리완료</div>`}
					</div>
				</td>
			</tr>`
/*			console.log(useBurgerNameList[j])*/
		}
		
	}
	document.querySelector('.orderBurgerTable').innerHTML = html;
	
}

/*주문완료를 눌렀을 경우  */
function onOrderComplete(i){
	orderList[i].state = false
	/*orderList 배열에서 버거 이름만 뽑아서 배열 만들기 */
	let burgerNameList = []
	for(let j = 0; j < orderList.length; j++){
		burgerNameList = orderList[j].items;
		console.log(burgerNameList)
	}
	/*	console.log(orderList)*/
	/*주문완료를 누르면 판매 수량 증가, 매출액 증가! */
	for(let x = 0; x < salseInfo.length; x++){
		/*매출 현황을 가지고 있는 배열의 이름과 현재 주문울 완료한 버거의 이름과 같을 경우
			매출액과 판매 수량을 그에 따라 증가시켜줘야하고, 그에따라 순위도 매겨야한다.*/
		for(let j = 0; j < burgerNameList.length; j++){
			if(salseInfo[x].productNm == burgerNameList[j].name){
				/*반복문을 돌면서 하나씩 체크하기 때문에 다른 연산 필요없이 반복문을 돌때마다 한개의 수령과 가격만큼 더해주면된다.
				같은 물품 2개여도 orderList에는 1개 1개 각각 따로 들어가기 때문*/
				salseInfo[x].productSalse += 1;
				salseInfo[x].productSalsePrice += burgerNameList[j].price;
			}
		}
		
	printOrderTable();
	printSalesTable();
	console.log(salseInfo)
	console.log(burgerList)
}

/*console.log(salseInfo)*/

/*printSalesTable()*/
/*매출현황 테이블을 출력하는 함수 */
function printSalesTable(){
	let html = `<tr>
					<th class = "salesProductNo">제품번호</th>
					<th class = "salesBurgerName">버거이름</th>
					<th class = "salesCount">판매수량</th>
					<th class = "salesPrice">매출액</th>
					<th class = "salesBurgerRank">순위[매출액기준]</th>
				</tr>`
			
	for(let i = 0; i < salseInfo.length; i++){
		let salesPrice = salseInfo[i].productSalsePrice
		let Rank = 1;
		
		salseInfo.forEach((o1) => {
			let comparePrice = o1.productSalsePrice;
			console.log(comparePrice)
			if(salesPrice < comparePrice){
				Rank++;
			}
		})
		
		
		html += `<tr>
					<td class = "salesProductNo">${salseInfo[i].productNo}</td>
					<td class = "salesBurgerName">${salseInfo[i].productNm}</td>
					<td class = "salesCount">${salseInfo[i].productSalse}</td>
					<td class = "salesPrice">${salseInfo[i].productSalsePrice}</td>
					<td class = "salesBurgerRank">${Rank}</td>
				</tr>`
	}
	document.querySelector('.salesTable').innerHTML = html
	}
}
