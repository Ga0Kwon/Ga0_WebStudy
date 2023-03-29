
/*
$.ajax({
	url : "/jspweb/product/info",
	method : "get" ,
	success : (r)=>{
		console.log(r)
	}
})
// 		VS
$.get( 
	"/jspweb/product/info"  ,
	 (r)=>{ console.log(r) } );
*/

/*
	1. productlistprint() : 모든 제품 목록 html 출력 함수
	2. productprint() : productlist내 i번째 제품 1개 상세 html 출력	
	3. chatPrint() : 채팅창  html 출력 함수
	4. sendChat() : 채팅 보내기[DB처리]
	5. getproductlist() : 기준 [동서남북, 검색]에 따른 제품 목록 요청해서 결과를 받는 함수/마커 생성
	6. get동서남북() : 현재 보고 있는 지도의 좌표 구하기
	7. setplike() : 찜하기 등록
	8. getplike() : 찜하기 상태등록
*/
let productList = null; //getproductList()의 ajax로부터 요청된 결과를 담는 곳
//*
let index = 0; //현재 보고 있는 제품의 제품인덱스
let chatmno = 0; //현재 채팅하고 있는 상대방의 mno

/* 제품 목록 출력 html 출력 함수*/
function produclistprint(  ){
   let html = `<p style="font-size:12px; text-align:right" > 제품목록수 : ${ productList.length } 개 </h6>`;
    productList.forEach( (p, i) => {
		html += `<div onClick = "productprint(${i})" class = "productbox">
						<div class = "pimgbox">
							<img alt="" src="/jspWeb/product/pimg/${p.pimglist[0]}">
						</div>
						<div class = "pcontentbox">
							<div class = "pdate">${p.pdate}</div>
							<div class ="pname" >${p.pname}</div>
							<div class = "pprice">${p.pprice.toLocaleString()}원</div>
							<div class = "petc">
								<i class="far fa-eye"></i>${p.pview}
								<i class="far fa-thumbs-up"></i>5
								<i class="far fa-comment-dots"></i>3
							</div>
						</div>
					</div>`
	});
	document.querySelector('.produclistbox').innerHTML = html;
}

var map = new kakao.maps.Map(document.getElementById('map'), { // 지도를 표시할 div
    center : new kakao.maps.LatLng(37.3218778,126.8308848), // 지도의 중심좌표 
    level : 6 // 지도의 확대 레벨 
});
    
// 마커 클러스터러를 생성합니다 
var clusterer = new kakao.maps.MarkerClusterer({
    map: map, // 마커들을 클러스터로 관리하고 표시할 지도 객체 
    averageCenter: true, // 클러스터에 포함된 마커들의 평균 위치를 클러스터 마커 위치로 설정 
    minLevel: 7 // 클러스터 할 최소 지도 레벨 
});
// $.ajax( { url:"/jspweb/product/info" , success : (r) => { } );

/* ----------------------- 마커 디자인 변경 -----------------------*/

var imageSrc = '/jspWeb/img/pin.png', // 마커이미지의 주소입니다    
    imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      
// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption)
    
    
// 1. 제품목록 호출 [ 1. 현재 보이는 지도좌표내 포함된 제품만 2. ]
function getproductlist( 동 , 서  , 남 , 북 ){
	
	clusterer.clear() // 클러스터 비우기 [ 기존 마커들 제거 ]
	
	$.ajax({
		url : "/jspWeb/product/info" ,
		method : "get",
		async : false ,
		data : { "동" : 동 , "서" : 서 ,"남" : 남 , "북":북 },
		success : (r)=>{
			console.log(r);
		    // ------------ 사이드바 제품목록 --------------------------------
		    productList = r;	// 제품목록 결과를 전역변수 담아주기 
			produclistprint(  );
		   //------------ 마커 작업 ----------------------
		    var markers = r.map( ( p, i ) => {		console.log( p )
				// 마커에 추가코드 작성하기 위해 변수화
		        let marker = new kakao.maps.Marker({	
		            position : new kakao.maps.LatLng( p.plat, p.plng),
		            image : markerImage
		        });
		        // 마커에 클릭이벤트를 등록합니다
				kakao.maps.event.addListener(marker, 'click', function() {
				     productprint(i);
				}); // 클릭이벤트 end 
			
		        return marker;
		    }); // map end 
		    clusterer.addMarkers(markers);   // 클러스터러에 마커들을 추가합니다
		    //-------------------------------------------------
		} // success end 
	}); // ajax end  
} // getproductlist end 

//개별 제품 출력
function productprint(i){
	let p = productList[i];
	
	//이미지 스라이드에 대입할 html 구성
	let imghtml = ``;
	
	p.pimglist.forEach((img, i) => {
		//bs class : active 현재 보여지는 이미지
		// 첫번째만 active 해놓는다.
		if(i == 0){
			imghtml += `<div class="carousel-item active">
						 <img src="/jspWeb/product/pimg/${img}" class="d-block w-100" alt="...">
					</div>`
		}else{
			
			imghtml += `<div class="carousel-item">
						 <img src="/jspWeb/product/pimg/${img}" class="d-block w-100" alt="...">
					</div>`
		}
		
		
	})
	
	  let html = `<h3 class = "productTitle">제품상세페이지</h3>`;
      html += `<div class = "pviewbox">
					<div class ="pviewinfo">
						<div class = "mimgbox">
							<img class = "mimg hpimg" src="/jspWeb/member/pimg/${p.mimg}">
							<span class = "mid">${p.mid}</span>
						</div>
					
						<div class = "">
							<button onClick = "produclistprint()" class = "pbadge" type = "button">목록보기</button>
						</div>
					</div>
			
				<div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
					  <div class="carousel-inner">
						   ${imghtml}
					  </div>
					  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
					    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Previous</span>
					  </button>
					  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
					    <span class="carousel-control-next-icon" aria-hidden="true"></span>
					    <span class="visually-hidden">Next</span>
					  </button>
				</div>
				
				<!-- 제품 상세 내용물 -->
				<div class = "pdate">${p.pdate}</div>
				<div class = "pname">${p.pname}</div>
				<div class = "pcomment">${p.pcomment}</div>
				<div class = "pstate"><span class = "pbadge">${p.pstate == 1 ? '판매중' : (p.pstate == 2) ? '거래중':'판매완료'}</span></div>
				<div class = "pprice">${p.pprice}원</div>
				<div class = "petc">
					<span><i class="far fa-eye"></i><span class = "bview">${p.pview}</span></span>
					<span><i class="far fa-thumbs-up"></i><span class = "blike">5</span></span>
					<span><i class="far fa-comment-dots"></i><span class = "rcount">3</span></span>
				</div>
				<div class = "pviewbtnbox">
					<button class = " plikebtn" onClick = "setplike(${p.pno})" type = "button"><i class="far fa-heart"></i></button>
					<button onClick = "chatprint(${i})" type = "button">채팅</button>
				</div>
			</div>	`	
		
	document.querySelector('.produclistbox').innerHTML = html;
	getplike(p.pno);
	
}


// ------------  지도 중심좌표 이동 이벤트 //
// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener( map, 'dragend', function() {
    var bounds = map.getBounds();  // 지도의 현재 영역을 얻어옵니다 
    var swLatLng = bounds.getSouthWest();   // 영역의 남서쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast();   // 영역의 북동쪽 좌표를 얻어옵니다 
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();
    getproductlist( 동 , 서  , 남 , 북 );
});
	 
	 
        // $(r).map( (인덱스,반복객체명) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // r.map( (반복객체명,인덱스) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // vs 
        // .forEach( (반복객체명,인덱스) => { } ) 	실행문에서 return X
	 
// 2. 현재 지도의 좌표얻기
get동서남북();

function get동서남북(){
	var bounds = map.getBounds();  // 지도의 현재 영역을 얻어옵니다 
    var swLatLng = bounds.getSouthWest();   // 영역의 남서쪽 좌표를 얻어옵니다 
    var neLatLng = bounds.getNorthEast();   // 영역의 북동쪽 좌표를 얻어옵니다 
    let 남 = swLatLng.getLat();
    let 서 = swLatLng.getLng();
    let 북 = neLatLng.getLat();
    let 동 = neLatLng.getLng();
    getproductlist( 동 , 서  , 남 , 북 );
}
// ------------  지도 중심좌표 이동 이벤트 //
// 지도가 이동, 확대, 축소로 인해 중심좌표가 변경되면 마지막 파라미터로 넘어온 함수를 호출하도록 이벤트를 등록합니다
kakao.maps.event.addListener( map, 'dragend', ()=>{ get동서남북(); });


//3. 찜하기 버튼을 눌렀을 때 [첫 클릭시 찜하기 등록/다음 클릭시 찜하기 취소/다음 클릭시 찜하기 등록]
function setplike(pno){
	if(memberInfo.mid == null){
		alert('회원기능입니다. 로그인 후 사용해주세요.'); return;
	}

	//1. post 방식 전송
	$.ajax({
		url : "/jspWeb/product/like",
		method : "post",
		data : {"pno" : pno},
		success : (r) => {
			if(r == 'true'){
				alert('찜하기 등록')
				
				document.querySelector('.plikebtn').innerHTML =`<i class="fas fa-heart"></i>`;
			}else{
				alert('찜하기 취소');
				document.querySelector('.plikebtn').innerHTML = `<i class="far fa-heart"></i>`;
			}
		}
	})
	

//1. get 방식 전송
// vs
	// $.get( "/jspweb/product/like?pno="+pno , (r)=>{} )
	// $.ajax({ url : "/jspweb/product/like?pno="+pno , success : (r)=>{ console.log(r); } })
	
	// $.get( "/jspweb/product/like , { "data" : data } , (r)=>{} )
	// $.ajax({ url : "/jspweb/product/like" , data : { "data" : data } , success : (r)=>{ console.log(r); } })
	
	// $.post( "/jspweb/product/like , { "data" : data } , (r)=>{} )
	// $.ajax({ url : "/jspweb/product/like", method : "post" , data : { "data" : data } , success : (r)=>{ console.log(r); } })
}
//4. 현재 회원이 해당 제품의 찜하기 상태호출
function getplike(pno){
	
	if(memberInfo.mid == null){ //로그인안했을 시 
		document.querySelector('.plikebtn').innerHTML = "♡";
	}
	
	//1. get 방식 전송
	$.ajax({
		url : "/jspWeb/product/like",
		method : "get",
		async : false,
		data : {"pno" : pno},
		success : (r) => {
			if(r == 'true'){
				document.querySelector('.plikebtn').innerHTML = `<i class="fas fa-heart"></i>`;
			}else{
				document.querySelector('.plikebtn').innerHTML = `<i class="far fa-heart"></i>`;
			}
		}
	})
}

// 9. 제품별 채팅 목록 페이지 이동
function chatlistprint(i){
	
	let p = productList[i];
	
	let html = `<h3 class = "productTitle">채팅 목록</h3>`;
	
	$.ajax({
		url : "/jspWeb/product/chat",
		method : "get",
		data : {"pno" : p.pno, "chatmno" : 0}, //0보내면 목록
		async : false,
		success : (r) => {
			console.log(r)
			let printfromno = []; //출력된 mno
			
			r.forEach((o) => {
				// 구매자별 1개씩만 출력
				if(!printfromno.includes(o.frommno)){ //포함이 안되어있으면 Not연산자
					printfromno.push(o.frommno); //구매자 번호 저장후 -> 구매자별 1번씩만 출력
				
				
				html += `<div onclick = "chatinfoprint(${i}, ${o.frommno})" class = "chatlist">
							<div class = "frommimg">
								<img alt="" src="/jspWeb/member/pimg/${o.frommimg}" class ="hpimg">
							</div>
							<div class = "frominfo">
								<div class = "fromndate">${o.ndate}</div>
								<div class = "frommid">${o.frommid}</div>
								<div class = "fromncontent">${o.ncontent}</div>
							</div>
						</div> `
				}
			})
			//구매자 번호가 존재하지 않으면
			if(printfromno.length == 0) {html += '채팅 목록이 없습니다.'}
			
		}
		
	})
	document.querySelector('.produclistbox').innerHTML = html;
	
	
}
// 3. 채팅 페이지 이동
function chatprint(i){
	
	if(memberInfo.mid == null){
		alert('로그인하셔야 거래를 하실 수 있습니다.')
		return;
	}
	
	let html = `<h3 class = "productTitle">채팅방</h3>`
	
	let p = productList[i];
	
	if(p.mno == memberInfo.mno){ //만약에 등록한 회원이면 [판매자]
		alert('본인이 등록한 제품입니다.')
		chatlistprint(i)
		return;
	}
	
	//만약 등록한 회원이 아닌 경우 [구매자] : frommno 필요없다 . -> 판매자에게 메시지 보내기(p.mno == frommno)
	chatinfoprint(i, p.mno); //받는 사람 : 제품 등록자
}

//5.
function sendchat(pno){
	
	let ncontentinput = document.querySelector('.ncontentinput').value;
	
	$.ajax({
		url : "/jspWeb/product/chat",
		method : "post",
		data : {"pno" : pno, "ncontent" : ncontentinput, "tomno" : chatmno},
		success : (r) => {
			if(r == 'true'){
				document.querySelector('.ncontentinput').value = "";
				getcontent();
			}
		}
	});
}

//11. 판매자 기준 tomno / 구매자 기준 frommno
function chatinfoprint(i, tomno){

	index = i; //전역변수 index의 값을 바꿔준다.
	chatmno = tomno; //채팅 상대 (전역변수)
	
	let p = productList[index];
	
	let html = 
				`<div class = "chatbox">
						<div class ="pviewinfo">
							<div class = "mimgbox">
								<img class = "mimg hpimg" src="/jspWeb/product/pimg/${p.pimglist[0]}">
								<span class = "pname">${p.pname}</span>
							</div>
							<div>
								<button onClick = "produclistprint()" class = "pbadge" type = "button">목록보기</button>
							</div>
						</div>
						<div class = "chatcontent">
						</div>
						<div class = "chatbtn">
							<textarea class ="ncontentinput" rows="" cols=""></textarea>
							<button onClick = "sendchat(${p.pno}) " class = "bbtn" type = "button">전송</button>
						</div>
				 </div>`
			
	document.querySelector('.produclistbox').innerHTML =  html;
	
	getcontent();
}



//10. 채팅 내용을 가져오는 메서드 [채팅방 내용을 요청해서 해당 html 출력]
function getcontent(){
	
	let pno = productList[index].pno;
	
	$.ajax({
		url : "/jspWeb/product/chat",
		method : "get",
		data : {"pno" : pno, "chatmno" : chatmno},
		async : false, // 동기식
		success : (r) => {
			let html = ``;
			
			console.log(r);
			
			r.forEach((o) => {
				//내가 보낸 메시지일 경우
				if(o.frommno == memberInfo.mno){ //현재 로그인된 회원과 보낸 사람과 일치하면
					
					html += `<div class = "sendbox">${o.ncontent}</div>`
				
				//받은 메시지인 경우
				}/*else if(o.frommno == chatmno){ //메시지 보낸 사람과 채팅대상자와 일치하면 출력
				
					html +=  `<div class = "receviebox">${o.ncontent}</div>`
				
				}*/else{
					html +=  `<div class = "receviebox">${o.ncontent}</div>`
				}
			})	
			document.querySelector('.chatcontent').innerHTML = html;
		}
	})
}
    
// $(r).map( (인덱스,반복객체명) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // r.map( (반복객체명,인덱스) =>{ } ) 		실행문에서 return 값을 배열에 대입  
        // vs 
        // .forEach( (반복객체명,인덱스) => { } ) 	실행문에서 return X