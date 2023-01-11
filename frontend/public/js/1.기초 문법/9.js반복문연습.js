//예1) 1부터 10이하까지 1씩 증가 반복[한줄씩 출력]
console.log("-------------------------예1-------------------------");
for(let i = 0; i <= 10; i++){ //for start
	console.log(i);
} //for end

//예2) i는 1부터 10이하까지 1씩 증가 반복하면서 [한줄에 모두 출력]
console.log("-------------------------예2-------------------------");
let output = ' ' //문자 변수로 받을려고 공백[깡통] 넣음 -> 이거 안넣으면 진짜 숫자 더하기가 되버림.
for(let i = 1; i <= 10; i++){ //for start
	output += i + " " // vs. output = output + i; -> 누적 기록
} //for end
console.log(output);

//예3) i를 1부터 10이하까지 1씩 증가 반복 [html 출력]
console.log("-------------------------예3-------------------------");
output = ' ' //위에서 사용했기때문에 공백으로 다시 초기화[깡통]
for(let i = 1; i <= 10; i++){//for start
	output += i + "\t"
}//for end
document.querySelector('body').innerHTML = output;

//예4) i는 1부터 10이하까지 1씩 증가 반복 누계
console.log("-------------------------예4-------------------------");
let sum = 0 ; //숫자 변수
for(let i = 1; i <= 10; i++){ //for start
	sum += i
} //for end
console.log(sum);

console.log("-------------------------예5-------------------------");
//예5) i는 1부터 100까지의 7배수 누적 합계
//1>
sum = 0;
for(let i = 7; i<=100; i+=7){
	sum += i;
}
console.log(sum);

//2>
sum = 0;
for(let i = 1; i<=100; i++){ //for start
	if((i%7) == 0){ //if start
		sum += i;
	} //if end
} //for end
console.log(sum);