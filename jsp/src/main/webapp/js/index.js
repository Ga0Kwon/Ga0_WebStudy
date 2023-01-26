let productList = [
	{img : '두바이.jpg',  title: '[친구끼리 추천!] 두바이 / 아부다비 퍼펙트 일주', date : '6박 7일', price : 1399000, discount : 0.1, like :1000, review : 10939 },
	{img : '타이페이.jpg', title : '[모녀 여행 추천!] 타이페이/단수이/야류/지우펀/스펀 (4성호텔/단수이관광/천등날리기/특식3회)', date : '3박 4일', price : 629000, discount : 0.15, like :629, review : 5134 },
	{img : '방콕.jpg', title : '[나태주와 고모들도 갔다!] 방콕+파타야', date : '5박 6일', price : 499000, discount : 0.05, like :342, review : 4560 },
	{img : '캐나다.jpg', title : '캐나다 로키 일주 [시애틀/밴쿠버/캐네디언로키/밴프]', date : '7박 8일', price : 2199000, discount : 0.2, like :1389, review : 14092 },
	{img : '라오스.jpg', title : '[가족 여행 추천!] 라오스 비엔티엔/방비엥 전 일정 4성호텔', date : '3박 4일', price : 639000, discount : 0.08, like :349, review : 3278 },
	{img : '후쿠오카.jpg', title : '[후쿠오카 자유여행] 비즈니스호텔 세미더블/조식불포함', date : '3박 4일', price : 349000, discount : 0.02, like :795, review : 8392 },
]



printProduct();

function printProduct(){
	let html =``
	productList.forEach((o, i)=>{
		html += `<div class = "item"> <!-- 제품 1개 -->
					<img src = "img/${o.img}"> <!-- 제품 이미지 -->
					<div class = "item_info">
						<div class = "item_title">${o.title}</div> <!-- 제품 명 -->
						<div class = "item_day">${o.date}</div> <!-- 제품 몇박 며칠 -->
						<div class = "item_price">${o.price}원</div> <!-- 원가 -->
						<div>
							<span class = "item_sales">${o.price - parseInt(o.price*o.discount)}원</span> <!-- 판매가 -->
							<span class = "item_discount">${parseInt(o.discount*100)}%</span> <!-- 할인율 -->
						</div>
					</div>
					<div class = "item_bottom"> <!-- 제품정보 하단 구역 -->
						<div>
							<span class = "badge rounded-pill text-bg-danger">문의폭주</span> <!-- 배찌 -->
							<span class = "badge rounded-pill text-bg-warning">별점4개이상</span> <!-- 배찌 -->	
						</div>
						
						<div class = "item_review"> 찜 ${o.like} 리뷰수 ${o.review}</div>
					</div>
				</div>`	
	})
	document.querySelector('.itembox').innerHTML = html
}