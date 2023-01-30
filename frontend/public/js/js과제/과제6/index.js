//1. userBox, logBox, monBox Dom객체를 가져오기
let userBox = document.querySelector('.userBox');
let monBox =document.querySelector('.monBox');

//로그 출력하는 박스 가져오기.
let logBox =document.querySelector('.logBox');
let logBox2 = document.querySelector('.logBox2');

let wrap = document.querySelector('.wrap');

//*캐릭터 객체
let character = {
	img : 'img/user/user1.png',
	left : 10 ,
	level : 1,
	exp: 0, 
	power : 20,
	hp : 200
}

//*몬스터 배열
let monsterArrays = [
	{name : '마법사', m_img :'img/monster1/monster1.png', hp : 100, left : 910, exp : 50},
	{name : '빨간용', m_img :'img/monster2/monster2.png', hp : 150, left : 910, exp : 100},
	{name : '파란용', m_img :'img/monster3/monster3.png', hp : 200, left : 900, exp : 150}
]

// *userBox의 [기본/처음] 위치
let u_left = 10; //유저

// *monBox의 [기본/처음] 위치
let m_left = 910; //몬스터

/*몬스터와 사용자의 HP칸 */
let monsterMaxHp = 350;
let userMaxHP = 350;

/*몬스터와 사용자 받는 데미지 */
let monster_Damage = 0
let user_Damage = 0

/*어떤 몬스터가 나와야하는지 알려주는 변수 */
let whoMonster = 0;

//2. 문서 안에서 키 입력 이벤트 -> 문서 안에서 키를 입력하는 것이기 때문에 document
document.addEventListener('keydown', (e)=>{
/*	console.log('키입력')*/
/*	console.log(e)*/
	console.log(e.keyCode)
	
	let key = e.keyCode; //입력된 키 코드를 변수에 저장
	
	if(key == 37){ //왼쪽 키
		u_left -= 10;
		u_left = u_left < 0 ? 0 : u_left;
		userBox.style.backgroundImage = `url(img/user/user_left1.png)`
	}else if(key == 39){//오른쪽 키
		u_left += 10;
		u_left = u_left > 910 ? 910 : u_left;
		userBox.style.backgroundImage = `url(img/user/user_right1.png)`
	}else if(key == 65){ //a키 -> 공격
		Attack();
		mon_moving(key)
		userBox.style.backgroundImage = `url(img/user/user_akey.png)`
		
	}else if(key == 32){ //space키 -> 점프
		userBox.style.backgroundImage = `url(img/user/user_jump.png)`
		userBox.style.top = `450px`
	}else if(key == 40){ //아래키 -> 납작하게
		userBox.style.backgroundImage = `url(img/user/user_down.png)`
	}else if(key == 83){ //s키 -> 실드
		mon_moving(key)
		userBox.style.backgroundImage = `url(img/user/user_skey.png)`
	}
	
	userBox.style.left = `${u_left}px`
	
	//*현재 좌표 로그 출력
	logBox.innerHTML = `사용자 좌표 : ${u_left}`
})

//2. 문서 안에서 키를 떼었을 때 이벤트
document.addEventListener('keyup', (e) => {
	userBox.style.backgroundImage = `url(img/user/user1.png)`
	userBox.style.backgroundSize =`90%`;
	
	/*console.log(e.keyCode)*/
	
	if(e.keyCode == 32){ /*점프를 누르고 놓았을 때 제자리로 내려와야한다. */
		userBox.style.top = `510px`
	}
	
})

//3. 몬스터 이동 난수 [랜덤 -> 1초]
//특정시간마다 함수 실행해주는 함수 setInterval(() => {}, 밀리초(1000/1))
//몬스터가 움직였을 때 사용자와 닿으면 사용자는 데미지를 받는다. [단, 사용자가 공격할때, 사용자가 방어를 할때 제외]]
setInterval(mon_moving, 1000)

function mon_moving(key){
	
	nextMonster();
	
	//1. 난수 +- 20
	let rand = parseInt(Math.random()*35+1); //1~20사이의 랜덤한 정수 //이동 거리
	let rand2 = parseInt(Math.random()*2); // 0 또는 1 //이동 방향
	
	if(rand2  == 1){m_left += rand;}
	else {m_left -= rand; } 
	
	
	/*사용자 데미지 적용 코드 */
	if(whoMonster == 0){ //첫번째 몬스터일 경우
		if((m_left-u_left ) >= -10 && ( m_left-u_left ) <= 20 ){
			if(key == 65){ //사용자가 공격을 했을 경우
				
			}else if(key == 83){ //사용자가 실드를 했을 경우
				
			}else{ //몬스터의 공격으로 데미지를 받았을 경우
				monBox.style.backgroundImage = `url(img/monster1/monster1_attack.png)`
				user_Damage += 10*(whoMonster + 1); //난이도 조절
				character.hp -= user_Damage; //몬스터의 공격	
				document.querySelector('.userBlood').style.width = `${userMaxHP - user_Damage*20}px`
			}
		}else{
			if(whoMonster == 0){
				monBox.style.backgroundImage = `url(img/monster1/monster1.png)`
			}else if(whoMonster == 1){
				monBox.style.backgroundImage = `url(img/monster2/monster2.png)`
			}else if(whoMonster == 2){
				monBox.style.backgroundImage = `url(img/monster3/monster3.png)`
			}
		}
	}else if(whoMonster == 1){ //두번째 몬스터일 경우
		if((m_left-u_left ) >= -20 && ( m_left-u_left ) <= 30 ){
			if(key == 65){ //사용자가 공격을 했을 경우
		
			}else if(key == 83){ //사용자가 실드를 했을 경우
				
			}else{ //몬스터의 공격으로 데미지를 받았을 경우
				user_Damage += 10*(whoMonster + 1); //난이도 조절
				monBox.style.backgroundImage = `url(img/monster2/monster2_attack.png)`
				character.hp -= user_Damage; //몬스터의 공격	
				document.querySelector('.userBlood').style.width = `${userMaxHP - user_Damage*20}px`
			}
		}else{
			if(whoMonster == 0){
				monBox.style.backgroundImage = `url(img/monster1/monster1.png)`
			}else if(whoMonster == 1){
				monBox.style.backgroundImage = `url(img/monster2/monster2.png)`
			}else if(whoMonster == 2){
				monBox.style.backgroundImage = `url(img/monster3/monster3.png)`
			}
		}
	}else if(whoMonster == 2){ //세번째 몬스터일 경우
		if((m_left-u_left ) >= -30 && ( m_left-u_left ) <= 40 ){
			if(key == 65){ //사용자가 공격을 했을 경우
				
			}else if(key == 83){ //사용자가 실드를 했을 경우
				
			}else{ //몬스터의 공격으로 데미지를 받았을 경우
				monBox.style.backgroundImage = `url(img/monster3/monster3_attack.png)`
				user_Damage += 10*(whoMonster + 1); //난이도 조절
				character.hp -= user_Damage; //몬스터의 공격으로
				document.querySelector('.userBlood').style.width = `${userMaxHP - user_Damage*20}px`
			}
		}else{
			if(whoMonster == 0){
				monBox.style.backgroundImage = `url(img/monster1/monster1.png)`
			}else if(whoMonster == 1){
				monBox.style.backgroundImage = `url(img/monster2/monster2.png)`
			}else if(whoMonster == 2){
				monBox.style.backgroundImage = `url(img/monster3/monster3.png)`
			}
		}
		
	}


	//2.게임화면 고정
	if(m_left < 0) m_left = 0;
	if(m_left > 910) m_left = 910;
	
	//3.
	monBox.style.left = `${m_left}px`
	
	//*현재 좌표 로그 출력
	logBox2.innerHTML = `몬스터 좌표 : ${m_left}`
	if(character.hp >= 0 && monsterArrays[2].hp <= 0){
		monsterDie();
		monBox.style.backgroundImage =`none`
		clearInterval()
	}else if(character.hp < 0){
		characterDie();
	}
	
	console.log(user_Damage)
	console.log(monster_Damage)
	
}

//몬스터가 어떤 몬스터인지 판별하는 함수
function nextMonster(){
	whoMonster = 0;
	
	if(monsterArrays[whoMonster].hp <= 0){
		monBox.style.backgroundImage = `url(img/monster2/monster2.png)`
		document.querySelector('.dieMonster1').style.display = "inline"
		whoMonster++;
	}
	if(monsterArrays[whoMonster].hp <= 0){
		monBox.style.backgroundImage = `url(img/monster3/monster3.png)`
		document.querySelector('.dieMonster2').style.display = "inline"
		whoMonster++;
	}
	if(monsterArrays[whoMonster].hp <= 0){
		monsterDie();
		printTable();
		whoMonster++;
		return;
	}
	
}

/*사용자 공격 */
function Attack(){ //공격버튼을 눌렀을 때
	nextMonster();
	if(whoMonster <= 2){ //아직 이기지 못한 상대가 있을 경우
		if((m_left-u_left ) >= -50 && ( m_left-u_left ) <= 60){
			monster_Damage += 20*character.level;
			monsterArrays[whoMonster].hp -= monster_Damage;
		}
		
	}
	for(let i = 0; i < monsterArrays.length; i++){
		if(monsterArrays[i].hp <= 0){
			printTable()
		}
	}
	document.querySelector('.monBlood').style.width = `${monsterMaxHp - monsterArrays[whoMonster].hp*20}`
 }
 
 /*몬스터가 죽었을때 실행되는 코드*/
function monsterDie(){
	wrap.style.filter = `brightness(60%)`;
	wrap.style.textAlign = "center"
	wrap.style.margin = "0 auto"
	wrap.style.color = "white"
	wrap.style.fontSize = "50px"
	wrap.innerHTML = `<h1>Winner!</h1>`
	document.querySelector('.dieMonster3').style.display = "inline"
}

/*사용자 캐릭터가 죽었을때 실행되는 코드*/
function characterDie(){
	if(character.hp <= 0){ //캐릭터의 hp가 0보다 작거나 같으면
		wrap.style.filter = `brightness(60%)`;
		wrap.style.textAlign = "center"
		wrap.style.margin = "0 auto"
		wrap.style.color = "red"
		wrap.style.fontSize = "50px"
		wrap.innerHTML = `<h1>GAME OVER</h1>`
		
		document.querySelector('.dieCharacter').style.display = "inline"
		printTable();
	}
	return 0;
}

/*게임이 끝났을 때 경험치와 레벨 보여줌. [1.내가 졌을 경우/ 2. 모두 이겼을 경우] */
function printTable(){
	let characterExp = 0
	
	for(let i = 0; i < monsterArrays.length; i++){
		if(monsterArrays[i].hp <= 0){
			characterExp += monsterArrays[i].exp;
			character.exp = characterExp;
		}
	}
	if(character.exp >= 100){
		character.level = parseInt(characterExp/100) + 1;
	}
	
	let html = `<tr>
					<th>Monster</th>
					<th>Kill</th>
					<th>Exp</th>
					<th>Totalexp</th>
					<th>Level</th>
				</tr>`
	
	
	for(let i = 0; i < monsterArrays.length; i++){
		html += `<tr>
					<td>${monsterArrays[i].name}</td>
				 	<td>${monsterArrays[i].hp <= 0 ? "O" : "X" }</td>
				 	<td>${monsterArrays[i].exp}</td>
				 	<td>${character.exp}</td>
				 	<td>${character.level}</td>
				 </tr>`
	}
	
	document.querySelector('.gameInfo_table').innerHTML = html;
	return;
	
}

/*
	함수 형태
		1. 일반함수 : function 함수명(){ }
		2. 익명함수 : function(){ }
		3. 람다식함수 : ( ) => { }
		4. 변수함수 : let 변수명 = ( ) => { }
	 Math.random()
	 	 Math.random() : 0 ~ 1 사이의 실수
	 	  Math.random()*10 : 0 ~ 10(10은 안나옴)사이의 실수



*/
