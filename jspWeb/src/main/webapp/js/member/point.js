console.log('point js');


let pay = 0; //결제 금액

function setPay(payamount){
	pay = payamount;
	alert('결제 금액 선택');
}

var IMP = window.IMP; // 생략 가능
IMP.init("imp74683446"); // 예: imp00000000a
  
  function requestPay() {
	  if(pay == 0){
		  alert('충전할 금액을 선택해주세요.')
		  return;
	  }
    IMP.request_pay({
      pg: "kakaopay",
      pay_method: "card", //카드 결제
      merchant_uid: "ORD20180131-0000011",   // 주문번호
      name: "포인트 결제", //결제할 제품 이름
      amount: pay,                         // 숫자 타입
      buyer_email: "gildong@gmail.com", //관리자 정보
      buyer_name: "홍길동", //관리자 정보
      buyer_tel: "010-4242-4242", //관리자 정보
      buyer_addr: "서울특별시 강남구 신사동", //관리자 정보 
      buyer_postcode: "01181"
    }, function (rsp) { // callback
      if (rsp.success) {
        // 결제 성공 시 로직
        console.log(rsp)
      } else { 
		  console.log(rsp)
        // 결제 실패 시 로직
        
        
        //결제 성공 했다는 가정을 하고
        
        let info = {
			mpcomment : '포인트 충전',
			mpamount : pay,
			mno : memberInfo.mno
		}
		
		$.ajax({
			url : "/jspWeb/point",
			data : info,
			method : "post",
			success : (r) => {
				if(r == 'true'){
					alert('포인트 충전')
					location.hrf
				}
			}
		})
      }
    });
  }
  
  