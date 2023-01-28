//1. userBox, logBox, monBox Dom객체를 가져오기
let userBox = document.querySelector('.userBox');
let monBox =document.querySelector('.monsterBox');

//로그를 출력하는 user, monster span 가져오기.
let userLog =document.querySelector('.user_log');
let monsterLog =document.querySelector('.monster_log');

// 게임 전체화면 가져오기.
let wrap = document.querySelector('.wrap');

//*캐릭터 객체 [=user]
let character = {
	img : 'img/user/user.png', //처음 캐릭터 이미지
	left : 10 , //가로 위치
	level : 1, //레벨
	top : 450, //세로 위치.
	exp: 0,  //경험치 
	power : 20, //캐릭터 힘
	hp : 200 //캐릭터 hp
}

//*몬스터 배열
let monsterArrays = [
	{name : 'monster1', m_img :'img/monster1/monster1.png', hp : 100, left : 910, top : 415, exp : 50},
	{name : 'monster2', m_img :'img/monster2/monster2.png', hp : 150, left : 910, top : 415, exp : 100},
	{name : 'monster3', m_img :'img/monster3/monster3.png', hp : 200, left : 900, top : 415, exp : 150}
]

/*사용자와 몬스터의 left값을 저장하는 변수 */
let u_left = character.left;
let m_left = monsterArrays[0].left;

/*몬스터와 사용자의 HP칸 width값 */
let monsterMaxHp = 350;
let userMaxHP = 350;

/*게임화면에서 사용자가 키보드를 눌렀을 경우 발생하는 이벤트 */
document.addEventListener('keydown', (e) =>{
	/*	console.log('키입력')*/
	/*	console.log(e)*/
	console.log(e.keyCode);
	
	let key = e.keyCode; //누른 키의 값을 변수 key에 저장
	
	if(key == 37){ //왼쪽 키
		u_left -= 10;
		u_left = u_left < 0 ? 0 : u_left; //게임 화면 밖으로 나가지 못하게.
		userBox.style.backgroundImage = `url(img/user/user_left.png)`
	}else if(key == 39){//오른쪽 키
		u_left += 10;
		u_left = u_left > 910 ? 910 : u_left; 
		userBox.style.backgroundImage = `url(img/user/user_right.png)`
	}else if(key == 65){ //a키 -> 공격
		damage(key); //a키를 누를때만 함수를 호출하면 됨.
		userBox.style.backgroundImage = `url(img/user/user_attack.png)`
		
	}else if(key == 32){ //space키 -> 점프
		userBox.style.backgroundImage = `url(img/user/user_jump.png)`
		character.top = 400;
		userBox.style.top = `${character.top}px`
	}else if(key == 40){ //아래키 -> 납작하게
		userBox.style.backgroundImage = `url(img/user/user_down.png)`
	}else if(key == 83){ //s키 -> 실드
		userBox.style.backgroundImage = `url(img/user/user_shield.png)`
	}
	
	character.left = u_left
	
	//화면으로 움직인 만큼 보여주기
	userBox.style.left = `${character.left}px`
	
	//*현재 좌표 로그 출력
	userLog.innerHTML = `사용자 좌표 : ${u_left}`
})

//2. 문서 안에서 키를 떼었을 때 이벤트
document.addEventListener('keyup', (e) => {
	userBox.style.backgroundImage = `url(img/user/user.png)`
	userBox.style.backgroundSize =`100%`;
	
	/*console.log(e.keyCode)*/
	
	if(e.keyCode == 32){ /*점프를 누르고 놓았을 때 제자리로 내려와야한다. */
		character.top = 450; //원래 위치 top = 450px
	}
	
	//화면으로 점프 보여주기
	userBox.style.top = `${character.top}px`
})

//3. 몬스터 이동 난수 [랜덤 -> 1초]
//특정시간마다 함수 실행해주는 함수 setInterval(() => {}, 밀리초(1000/1))
//몬스터가 움직였을 때 사용자와 닿으면 사용자는 데미지를 받는다. [단, 사용자가 공격할때, 사용자가 방어를 할때 제외]]
setInterval(mon_moving, 1000)

function mon_moving(){
	
	//1. 난수 +- 20
	let randDistance = parseInt(Math.random()*50+1); //1~50사이의 랜덤한 정수 //이동 거리
	let randDirection = parseInt(Math.random()*2); // 0 또는 1 //이동 방향
	
	if(randDirection  == 1){m_left += randDistance;} //randDirection이 1이 나오면 오른쪽 이동
	else {m_left -= randDistance; }  //randDirection이 0이 나오면 왼쪽 이등
	
	//2.게임화면 고정 -> 게임 화면 밖으로 나갈 수 없게
	if(m_left < 0) m_left = 0;
	if(m_left > 910) m_left = 910;
	
	//3.화면으로 움직인 만큼 보여주기
	monBox.style.left = `${m_left}px`
	
	//*현재 좌표 로그 출력
	monsterLog.innerHTML = `몬스터 좌표 : ${m_left}`
	
	damage("몬스터"); //움직일때마다 닿았는지 확인 해줘야함 [데미지를 주기 위해]
}

//사용자나 몬스터가 데미지를 받는 함수
function damage(key){
	if(m_left > u_left){ //몬스터가 더 오른쪽에 가있는 경우
		/*닿는 기준은 오른쪽에 있는 캐릭터와 왼쪽에 있는 
		  캐릭터의 left값을 뺐을 때 0보다 작거나 같으면 닿은 경우다.*/
		if(m_left-u_left <= 0){ 
			if(key == "몬스터"){ //인수로 받은 값이 "몬스터일 경우" => 
				
			}else{
				
			}
		}
	}else if(m_left < u_left){ //사용자가 더 오른쪽에 가있는 경우
		if(u_left-m_left <= 0){
			if(key == "몬스터"){
				
			}else{
				
			}
		}
	}
}