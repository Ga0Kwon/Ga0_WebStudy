/*공통 */
let categoryList = ['프리미엄', '스페셜', '와퍼', '올데이킹', '치킨버거'];

let burgerList = [{img : '기네스와퍼.png', name : '기네스와퍼', price : 9500, category : '프리미엄'},
				  {img : '기네스콰트로치즈와퍼.png', name : '기네스콰트로치즈와퍼', price : 10000, category : '프리미엄'},
				  {img : '몬스터X.png', name : '몬스터X', price : 8800, category : '프리미엄'},
				  {img : '몬스터와퍼.png', name : '몬스터와퍼', price : 8500, category : '프리미엄'},
				  {img : '콰트로치즈X.png', name : '콰트로치즈X', price : 7800, category : '프리미엄'},
				  {img : '콰트로치즈와퍼.png', name : '콰트로치즈와퍼', price : 9000, category : '프리미엄'},
				  {img : '통새우와퍼.png', name : '통새우와퍼', price : 6500, category : '프리미엄'},
				  {img : 'BLT오믈렛킹모닝.png', name : 'BLT오믈렛킹모닝', price : 8800, category : '올데이킹'},
				  {img : '오믈렛킹모닝.png', name : '오믈렛킹모닝', price : 6500, category : '올데이킹'},
				  {img : '불고기몬스터세트.png', name : '불고기몬스터세트', price : 9500, category : '올데이킹'},
				  {img : '타바스코몬스터.png', name : '타바스코몬스터', price : 10500, category : '올데이킹'},
				  {img : '더블오리지널치즈버거세트.png', name : '더블오리지널치즈버거세트', price : 10000, category : '올데이킹'},
				  {img : '타바스코더블비프.png', name : '타바스코더블비프', price : 7900, category : '올데이킹'},
				  {img : '통새우와퍼주니어세트.png', name : '통새우와퍼주니어세트', price : 9900, category : '올데이킹'},
			  	  {img : '치즈버거.png', name : '치즈버거', price : 4500, category : '올데이킹'},
	  	  		  {img : '치킨킹팩1.png', name : '치킨킹팩1', price : 11000, category : '스페셜'},
				  {img : '치킨킹팩2.png', name : '치킨킹팩2', price : 11500, category : '스페셜'},
				  {img : '치킨킹팩3.png', name : '치킨킹팩3', price : 12000, category : '스페셜'},
				  {img : '블랙어니언팩1.png', name : '블랙어니언팩1', price : 12000, category : '스페셜'},
				  {img : '블랙어니언팩2.png', name : '블랙어니언팩2', price : 13000, category : '스페셜'},
				  {img : '블랙어니언팩3.png', name : '블랙어니언팩3', price : 13000, category : '스페셜'},
				  {img : '스태커2와퍼.png', name : '스태커2와퍼', price : 9800, category : '와퍼'},
				  {img : '스태커3와퍼.png', name : '스태커3와퍼', price : 10800, category : '와퍼'},
				  {img : '갈릭불고기와퍼.png', name : '갈릭불고기와퍼', price : 7900, category : '와퍼'},
				  {img : '베이컨치즈와퍼.png', name : '베이컨치즈와퍼', price : 6900, category : '와퍼'},
				  {img : '할라피뇨와퍼.png', name : '할라피뇨와퍼', price : 7600, category : '와퍼'},
				  {img : '치즈와퍼.png', name : '치즈와퍼', price : 4500, category : '와퍼'},
				  {img : '와퍼.png', name : '와퍼', price : 3900, category : '와퍼'},
				  {img : '불고기와퍼.png', name : '불고기와퍼', price : 4900, category : '와퍼'},
				  {img : '와퍼주니어.png', name : '와퍼주니어', price : 3900, category : '와퍼'},
				  {img : '불고기와퍼주니어.png', name : '불고기와퍼주니어', price : 4200, category : '와퍼'},
				  {img : '비프&슈림프버거.png', name : '비프&슈림프버거', price : 8900, category : '치킨버거'},
				  {img : '통새우슈림프버거.png', name : '통새우슈림프버거', price : 8200, category : '치킨버거'},
				  {img : '잔망루피슈림프버거.png', name : '잔망루피슈림프버거', price : 4000, category : '치킨버거'},
				  {img : '롱치킨버거.png', name : '롱치킨버거', price : 4600, category : '치킨버거'},
				  {img : '바비큐킹치킨버거.png', name : '바비큐킹치킨버거', price : 4800, category : '치킨버거'},
				  {img : '킹치킨버거.png', name : '킹치킨버거', price : 4700, category : '치킨버거'},
];

let cartList = []; //카트 목록

let orderList = []; //주문 목록

printCategory();
categorySelect(0); //처음 클릭되어 있는[기본값] : 프리미엄
printProduct(0); //0 : 프리미엄

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

/*주문 취소 */
function onCancel(){
	if(confirm('카트를 비우겠습니까?')){
		cartList.splice(0);
		printCart()
	}else{
		return;
	}
	
}



/*주문 */
function onOrder(){
	let number = 0;
	//1. 주문 번호 만들기 
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
			number : number, 
			items : mapCartLsit, //새로운 객체를 만듦가 동시에 cartList의 객체정보를 가져옴.
			time : new Date(), //new Date() : 현재 날짜와 시간을 알려줌
			state : true, //true : 일단 주문 -> false : 주문 완료
			complete : 0, //아직 주문 완료 되기 전이기 때문에 0
			price : totalPrice  
		}
		//2) order 객체 배열에 저장
		orderList.push(order)
		console.log(orderList)
		cartList.splice(0);
	}else{
		return;
	}
}
	