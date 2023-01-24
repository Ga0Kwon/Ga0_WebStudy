/*-----------------------------필요한 배열 선언 start------------------------ */
/* 키오스크 카테고리 배열 */
let categoryList = ['프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거'];

/*제품번호를 추가한 burgerList => 제품 목록 정보 */
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

let adminCategory = ['등록된버거현항', '주문된주문목록현황', '매출현황'] /*포스기 카데고리 */

let salseInfo = burgerList; //매출현황에서 사용할 배열 (burgerList를 담고 있는)

/*-----------------------------필요한 배열 선언 end------------------------ */

/*---------------------------js가 열렸을 때 실행되어야하는 함수------------------- */
printCategory(); //카테고리를 출력
categoryKioskSelect(0); //초기값은 프리미엄
/*-------------------------------------------------------------------- */

/*카테고리를 출력하는 함수(포스기/키오스크) [js가 열렸을 때] */
function printCategory(){
	// html 구성
	let html1 = `<ul>`
	let html2 = `<ul>`
	
	for(let i = 0; i < categoryList.length; i++){
		html1 += `<li class = "categoryKioskListItem" onClick = "categoryKioskSelect(${i})">${categoryList[i]}</li>`
	}
	for(let i = 0; i < adminCategory.length; i++){
		html2 += `<li class = "categoryPosListItem" onClick = "categoryPosSelect(${i})">${adminCategory[i]}</li>`
	}
	html1 += `</ul>`
	html2 += `</ul>`
	
	document.querySelector('.categoryBox').innerHTML = html1
	document.querySelector('.adminCategory').innerHTML = html2
	
}
/*----------------------------카테고리 선택시 해당 인덱스에 식별자 추가하는 부분 start-------------------------------- */
/*키오스크 부분 카테고리 선택 함수 */
function categoryKioskSelect(i){
	let kioskCategorys = document.querySelectorAll('.categoryKioskListItem');
	
	for(let j = 0; j < kioskCategorys.length; j++){ 
		if(j == i){ //인수로 받은 i(인덱스)와 li배열에서 내가 선택된 li의 인덱스가 같으면
			kioskCategorys[j].classList.add('categorySelectItem'); //해당 마크업의 class 식별자 추가
		}else{
			kioskCategorys[j].classList.remove('categorySelectItem'); //해당 마크업의 class 식별자 제거
		}
	}
	printProduct(i);
}

/*포스기 부분 카테고리 선택 함수 */
function categoryPosSelect(i){
	let posCategory = document.querySelectorAll('.categoryPosListItem');
	
	for(let j = 0; j < posCategory.length; j++){ 
		if(j == i){ //인수로 받은 i(인덱스)와 li배열에서 내가 선택된 li의 인덱스가 같으면
			posCategory[j].classList.add('categorySelectItem'); //해당 마크업의 class 식별자 추가
		}else{
			posCategory[j].classList.remove('categorySelectItem'); //해당 마크업의 class 식별자 제거
		}
	}
	printCurrentStatus(i)
}
/*----------------------------카테고리 선택시 해당 인덱스에 식별자 추가하는 부분 end--------------------------------- */

/*-------------------------------카테고리 선택시 내용물 출력하는 부분 start------------------------------------ */
/*키오스크에서 제품(햄버거) 출력하는 함수 [1.js 열렸을 때, 2. 카테고리 바뀌었을 때] */
function printProduct(index){
	//1) html 구성
	let html =``
	// i는 0번째 인덱스부터 마지막 인덱스까지 버거 객체를 가져온다.
	for(let i = 0; i < burgerList.length; i++){
		if(burgerList[i].category == categoryList[index]){ //i번째 버거 객체의 카테고리와 선택된 카테고리가 같다면
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

/*현황 테이블을 카데고리에 따라 출력하는 함수 [1.js열렸을 때, 2. 카테고리 바뀌었을 때] */
function printCurrentStatus(index){
	if(index == 0){ //등록된 버거 현황
		document.querySelector('.insertCurrentBox').style.display = "block"
		document.querySelector('.orderBurgerBox').style.display = "none"
		document.querySelector('.salesBox').style.display = "none"
		printInsertCurrentTable()
	}
	else if(index == 1){ //주문 목록 현황
		document.querySelector('.insertCurrentBox').style.display = "none"
		document.querySelector('.orderBurgerBox').style.display = "block"
		document.querySelector('.salesBox').style.display = "none"
		printOrderTable();
	}
	else if(index == 2){ //매출 현황
		document.querySelector('.insertCurrentBox').style.display = "none"
		document.querySelector('.orderBurgerBox').style.display = "none"
		document.querySelector('.salesBox').style.display = "block"
		printSalesTable()
	}
}
/*-------------------------------카테고리 선택시 내용물 출력하는 부분 end------------------------------------ */

/*--------------------------------------카트 주문 부분 start---------------------------------------- */
/*카트에 해당 인덱스의 제품(햄버거)를 넣는 함수  */
function addCart(index){
	cartList.push(burgerList[index]);
	printCart();
}

/*카트 부분 요소들 출력하는 함수 */
function printCart(){
	let totalPrice = 0; //카트에 넣은 총 금액 변수 (처음은 아무것도 넣지 않았기 때문에 0)
	
	for(let i = 0; i < cartList.length; i++){ //cartList 배열의 크기만큼 반복
		totalPrice += cartList[i].price; //카트에 들어간 모든 제품(햄버거)의 가격을 다 더해줌.
	}
	
	document.querySelector('.cartCount').innerHTML = cartList.length; //카트에 들어간 햄버거의 개수는 배열에 들어간 객체의 개수만큼
	
	document.querySelector('.pTotal').innerHTML = totalPrice.toLocaleString(); //총 금액을 담은 변수 totalPrice
	
	let html = ``
	for(let i = 0; i < cartList.length; i++){
		html += `<div class = "item"> 
						<div class = "hamburgerTitle">${cartList[i].name}</div>
						<div class = "hamburgerPrice">${cartList[i].price}원</div>
				</div>`
	}
	//2) 구성된 html를 마크업 대입
	document.querySelector('.cartBottom').innerHTML = html
}

/*--------------------------------------카트 주문 부분 end---------------------------------------- */

/*-----------------------------------키오스크 버튼 부분 (주문취소/주문하기) 버튼 start------------------------ */
/*주문 취소 버튼  -> 모든 취소이므로 인덱스를 인수로 안받아도된다.*/
function onCancel(){
	if(confirm('카트를 비우겠습니까?')){
		cartList.splice(0); //cartlist 모두 삭제
		printCart()
	}else{
		return;
	}
}

/*주문하기 버튼 */
function onOrder(){
/*	alert('주문합니다.')*/
	
	let number = 0; //주문 번호
	let orderDate = new Date().toLocaleString(); //주문 시간
	
	if(orderList.length == 0){number = 1;} //길이가 0인 것은 주문이 하나도 없다는 것. 따라서 주문 번호는 1부터 시작하기 때문에 1
	else{
		number = orderList[orderList.length-1].number+1 //주문 객체의 마지막 인덱스의 number의 주문번호에 +1하면 다음 주문번호가 된다.
	}
	/*카트배열 -> 새로운 배열 [주문 객체에 카트 배열 대입시 카트 배열 초기화시 주문 객체나 카트배열도 초기화 => 매모리가 동일하기 때문] */
	//cartList만 쓰면 참조형식으로 가져오는데 메모리를 지우게 되면 없어짐...
	let mapCartList = cartList.map((o) => {return o;})
	//주문이 삭제되어도 number은 줄어들지 않는다.
	
	/*총가격 변수 */
	let totalPrice = 0;
	
	for(let i = 0; i < mapCartList.length; i++){totalPrice += mapCartList[i].price}
	if(confirm('주문하시겠습니까?')){
		//1. 주문시
		//1) 주문 객체 생성
		let order = {
			number : number, // 주문번호 [ 인덱스사용X ]
			items : mapCartList, //새로운 객체를 만듦가 동시에 cartList의 객체정보를 가져옴.
			time : orderDate, //주문 날짜 및 시간
			state : true, //true : 일단 주문 -> false : 주문 완료
			complete : 0, //아직 주문 완료 되기 전이기 때문에 0
			price : totalPrice //주문시 총 가격
		}
		//2)order 객체를 배열에 저장
		orderList.push(order);
		/*printOrderTable()*/
		/*console.log(orderList)*/
		/*console.log(order)*/
		cartList.splice(0); //카트에 있는 것을 주문 객체에 넣었으니 비어준다 (주문이 이미 들어갔기때문에 카트에선 더이상 보여주지 X)
	}else{
		return;
	}
	
}
/*-----------------------------------키오스크 버튼 부분 (주문취소/주문하기) 버튼 end-------------------------- */

/*제품 번호 만드는 함수 */
function makeProductNumber(){
	//현재 시간을 밀리초단위로 받고 버거리스트의 길이에 +1을 넣어주면 고유값이 나올 수밖에 없다.
	let productNumber = Date.now() + "-" + (burgerList.length+1);
	return productNumber;
}
/*----------------------------포스기 부분 버거 신규 등록해서 키오스크에 띄우는 함수 start ------------------------ */
/*버거 신규 등록해서 키오스크에 띄우는 함수 */
function insertBurger(){
	//유효성 검사 변수
	let check = 0;
	
	let newBurgerObject = {
		img : 'insert_' + document.querySelector('.inputImgName').value,
		name : document.querySelector('.inputBurgerName').value,
		price : parseInt(document.querySelector('.inputPrice').value),
		category : document.querySelector('.inputCategory').value,
		productNo : makeProductNumber()
	}
	
	/*console.log(newBurgerObject)*/
	
	/*가격에 문자가 들어갔을 경우 => 자료형 유효성*/
	if(isNaN(newBurgerObject.price)){
		alert('숫자로만 입력해주세요.')
		document.querySelector('.inputPrice').value = ""; //해당 가격 input의 내용을 비워준다.
		check++; //유효성 검사 변수를 증가시킴
	}
	
	/*있는 이름의 버거를 신규 등록할 경우 => 중복 유효성*/
	for(let i = 0; i < burgerList.length; i++){
		if(burgerList[i].name == newBurgerObject.name){
			alert(newBurgerObject.name+ '은 이미 등록된 버거입니다.')
			check++ //유효성 검사 변수를 증가시킴
		}
	}
	
	/*유효성 검사를 통과했을 경우 */
	if(check == 0){
		let categoryIndex = categoryList.indexOf(newBurgerObject.category); //해당 카테고리의 인덱스를 변수에 저장
		burgerList.push(newBurgerObject); //신규 버거객체를 burgerList에 넣어주고
		categoryKioskSelect(categoryIndex); //해당 신규 객체를 넣었다면 해당 카테고리에 들어갔는지 바로 확인 할 수 있게끔 함수를 호출
		printSalesTable(); //새로운 버거가 등록되면 매출현황 버거목록에 해당 버거가 추가되어야하기 때문에 호출
		printInsertCurrentTable(); //버거를 등록했다면 해당 버거 목록 테이블에도 추가되어야하기 때문에 호출
		alert("새로운 버거가 등록되었습니다.")
		
		/*등록했다면 input의 값을 초기화 해준다. [지워줌] */
		document.querySelector('.inputPrice').value = "";
		document.querySelector('.inputBurgerName').value ="";
		document.querySelector('.inputImgName').value = "";
		document.querySelector('.inputCategory').value = ""
	}
}
/*----------------------------포스기 부분 버거 신규 등록해서 키오스크에 띄우는 함수 end -------------------------- */

/*---------------------------------------- 버거 현황 테이블 start----------------------------------- */
/*버거 등록해서 등록된 버거 현황 테이블에 띄우는 함수 */
function printInsertCurrentTable(){
	//1) html 구성
	let html = `<tr>
					<th class = "productNo">제품번호</th>
					<th class = "burgerImg">버거이미지</th>
					<th class = "burgerName">버거이름</th>
					<th class = "burgerCategory">카테고리</th>
					<th class = "burgerPrice">가격</th>
					<th class = "insertRemark">비고</th>
				</tr>`
				
	/*신규가 아니더라도 기존에 있는 버거도 등록된 버거이므로 테이블 전체에 모든 등록된 버거를 출력 */
	for(let i = 0; i < burgerList.length; i++){
		html +=  `<tr>
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
	//2) 구성된 html를 마크업 대입
	document.querySelector('.insertCurrentTable').innerHTML = html
}

/*버거 목록에서 버거를 삭제하는 함수 => 삭제버튼 */
function deleteBurger(i){
	if(confirm(burgerList[i].name+ "을 버거 목록에서 삭제하시겠습니까?")){
		burgerList.splice(i, 1);
		printInsertCurrentTable(); //버거를 삭제했다면 해당 버거가 버거 목록 테이블에도 반영될 것을 바로 보여주어야하기때문에 호출
		alert('해당 버거가 목록에서 삭제되었습니다.')
	}else{
		return;
	}
}

/*버거 가격을 수정하는 함수 => 수정 버튼 */
function changePrice(i){
	let changeBurgerPrice = parseInt(prompt(burgerList[i].name+ '의 수정하실 가격을 입력해주세요.'))

	burgerList[i].price = parseInt(changeBurgerPrice);
	printInsertCurrentTable(); //가격을 수정했다면 버거 목록 테이블에도 반영된걸 바로 보여주어야하므로 호출.
	alert(burgerList[i].name + '의 가격이 수정되었습니다.')
}

/*------------------------------------------버거 현황 테이블 end-------------------------------------- */

/*-----------------------------------------주문 현황 테이블 start------------------------------------- */
/*주문된 주문 목록 현황 테이블 출력 */
function printOrderTable(){
	//1) html 구성
	let html = `<tr>
					<th class = "orderNo">주문번호</th>
					<th class = "orderburgerName">버거이름</th>
					<th class = "orderState">상태</th>
					<th class = "orderRemark">비고</th>
				</tr>`
				
	for(let i = 0; i < orderList.length; i++){
	
		/*console.log(useBurgerNameList)
		console.log(burgerNameList)*/
					
		for(let j = 0; j < orderList[i].items.length; j++){
			html += `<tr>
						<td class = "orderNo">${orderList[i].number}</td>
						<td class = "orderburgerName">${orderList[i].items[j].name}</td>
						<td class = "orderState">${orderList[i].state ? "주문요청" : 
							`<div class = "orderFinishText" >주문 완료</div>`}</td>
						<td class = "orderRemark">
							<div class = "showOrderBtn">
								${orderList[i].state ? 
							`<button class = "orderCompleteBtn" onClick = "onOrderComplete(${i})">주문완료</button>` 
							:`<div class = "orderFinishText">주문처리완료</div>`}
							</div>
						</td>
					</tr>`
			/*console.log(useBurgerNameList[j])*/
		}
	}
	//2) 구성된 html를 마크업 대입
	document.querySelector('.orderBurgerTable').innerHTML = html;		
}

/*주문완료 버튼 클릭 이벤트 함수 */
function onOrderComplete(i){
	orderList[i].state = false;

	printOrderTable(); //주문완료 버튼을 누르고 해당 주문 목록 현황 테이블을 새로고침해야 주문완료 버튼이 사라진것을 확인할 수 있다.
	printSalesTable(); //주문 완료를 누르면 버거 매출현황 또한 바뀌어야 한다. -> 따라서 해당 매출 현황 테이블도 다시 호출해준다.
	/*console.log(salseInfo)
	console.log(burgerList)*/
}

/*------------------------------------------주문 현황 테이블 end-------------------------------------- */

/*-----------------------------------------매출 현황 테이블 start------------------------------------- */
/*매출현황 테이블을 출력하는 함수 */
function printSalesTable(){
	//1) html 구성(1)
	let html = `<tr>
					<th class = "salesProductNo">제품번호</th>
					<th class = "salesBurgerName">버거이름</th>
					<th class = "salesCount">판매수량</th>
					<th class = "salesPrice">매출액</th>
					<th class = "salesBurgerRank">순위[매출액기준]</th>
				</tr>`
		

	let totalPrice = 0; //총 매출액을 저장하는 변수
	let salesCount = 0; //총 버거당 매출 개수를 저장하는 변수
	
	for(let i = 0; i < salseInfo.length; i++){
		let Rank = 1; //순위 변수 => 반복문 한번 돌때마다 1로 초기화. 버거들 마다 순위를 매기는 것이기 때문
		
		//있던 매출액, 매출개수, 순위는 초기화되면 안되기때문에 대입후 진행. [salseInfo[i]객체에 속성 3개 추가]
		salseInfo[i].salesTotalPrice = totalPrice 
		salseInfo[i].count = salesCount 
		salseInfo[i].salesRank = Rank 
		
		
		/*console.log(salseInfo);*/
		//1) html 구성(2)
		html += `<tr>
					<td class = "salesProductNo">${salseInfo[i].productNo}</td>
					<td class = "salesBurgerName">${salseInfo[i].name}</td>`
					
		for(let x = 0; x < orderList.length; x++){
			for(let y = 0; y < orderList[x].items.length; y++){
				if(salseInfo[i].name == orderList[x].items[y].name){ //이름이 같다면
					salseInfo[i].count++; //카운트 증가 [주문 목록에 해당 버거가 있다는 것이니까 해당 버거의 매출개수를 그만큼 +]
					salseInfo[i].salesTotalPrice = (salseInfo[i].count) * (salseInfo[i].price) //매출액
				}
			}
		}
		
		salseInfo.forEach((o) =>{ //순위 매기는 것. 반복함수 사용.
			let comparePrice = o.salesTotalPrice; //반복문을 돌면서 객체의 매출액을 계속 대입
			if(salseInfo[i].salesTotalPrice < comparePrice){ //매춝액이 비교 매출액보다 작으면 순위는 내려간다. -> 즉 순위 변수 숫자는 커진다.
				Rank++
			}
			salseInfo[i].salesRank  = Rank; //순위 대입
		})
		//1) html 구성(3)
		html +=		`<td class = "salesCount">${salseInfo[i].count}</td>
					<td class = "salesPrice">${salseInfo[i].salesTotalPrice}</td>
					<td class = "salesBurgerRank">${salseInfo[i].salesRank }</td>
				</tr>`
	}		
	//2) 구성된 html를 마크업 대입
	document.querySelector('.salesTable').innerHTML = html
	
}

/*------------------------------------------매출 현황 테이블 end-------------------------------------- */
