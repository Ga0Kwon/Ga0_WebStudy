alert('INFO-JS 열림');
/*info.jsp[HTML/JSP]은 JSP의 include으로 연결했기 때문에
	=> 그리고 header은 모든 페이지의 공통분모이기 때문에 */
console.log(memberInfo);

//1. header.js에서 ajax 동기식으로 회원정보를 가져온 상태 [memberInfo]
document.querySelector('.mid').innerHTML = memberInfo.mid;
document.querySelector('.mimg').src = "/jspWeb/member/pimg/"+ memberInfo.mimg;
document.querySelector('.memail').innerHTML = memberInfo.memail;
document.querySelector('.mpoint').innerHTML = memberInfo.mpoint;