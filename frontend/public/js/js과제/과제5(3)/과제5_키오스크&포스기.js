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

let salseInfo = []; //매출현황 정보를 가지고 있는 객체를 담는 배열 생성 

/*-----------------------------필요한 배열 선언 end------------------------ */

/*---------------------------js가 열렸을 때 실행되어야하는 함수------------------- */
printCategory(); //카테고리를 출력
/*-------------------------------------------------------------------- */

/*카테고리를 출력하는 함수 [js가 열렸을 때] */
function printCategory(){
	let html = `<ul>`
}