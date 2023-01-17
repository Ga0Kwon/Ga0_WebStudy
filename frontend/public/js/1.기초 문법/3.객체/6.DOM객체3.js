
//1. keyup 이벤트 : 키보드 누르고 떼었을 때 
	//1) <textarea> 마크업 객체화
const textarea = document.querySelector('textarea');
const h3 = document.querySelector('h3')
	//2) 해당 마크업의 이벤트 등록 [객체명.addEventListener]
textarea.addEventListener('keyup', (이벤트상태)=>{
	console.log('타자 치는 중')
	//3) 해당 마크업 사이에 html 대입 [객체명.innerHTML = html형식의 문자]
	h3.innerHTML = `글자 수 : ${textarea.value.length}`
	//4) 키 상태 확인
	console.log(이벤트상태)
	console.log('altKey : '+ 이벤트상태.altKey) //다른 키와 같이 누를 경우 altKey
	console.log('ctrlKey : '+ 이벤트상태.ctrlKey)//다른 키와 같이 누를 경우 ctrlKey
	console.log('shiftKey : '+ 이벤트상태.shiftKey)//다른 키와 같이 누를 경우 shiftKey
	console.log('code 키 : '+ 이벤트상태.code)
	console.log('name 키 : '+ 이벤트상태.key)
	
})

textarea.style.position = 'absolute' //css 조작 -> static[작성배치] 기본값 위치 불가능
let x = 0 
let y = 0 //상위 마크업 시작점 기준
let block = 10; //이동 단위

print(); //위치 배치 1번 실행
function print(){  //위치 배치 함수
	textarea.style.left = `${x*block}px` //이동단위 : 10px씩 (x*이동단위)
	textarea.style.top = `${y*block}px`  //이동단위 : 10px씩 (y*이동단위)
}

print();
//2. keydown 이벤트 : 키보드가 키를 입력했을 때
document.body.addEventListener('keydown', (e) =>{
	if(control){
/*		console.log(e.keyCode);*/
		let kc = e.keyCode;
		if(kc == 37){ //왼쪽키 left--
			x--;
		}else if(kc == 38){ //위쪽 키 top-- 
			y--;
		}else if(kc == 39){ //오른쪽 키 left++
			x++;
		}else if(kc == 40){ //아래 키 top++
			y++;
		}
		print();
	}
})

// * 이벤트 제어 변수
let control = true;

//3. 
document.querySelector('.moving').addEventListener('click', () =>{
	//스위치 on/off 변경
	control ? control = false : control = true;
	/*control = !control*/
})
