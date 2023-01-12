//과제 : 별 피라미드 + 거꾸로된 별 피라미드

let output = "";

let line = Number(prompt("과제 줄 수 :"));

if(line%2 == 0){ //짝수를 입력받을 때 
	for(let i = 1; i <= line; i++){
		if( i <= line/2){ //상단 부분
			for(let b = 1; b <= line/2-i + 1; b++){
				output += " ";
			}
			for(let s = 1; s <= i*2 -1; s++){
				output += "*";
			}
			output += "\n"
		}else{ //하단 부분
			for(let b = 1; b <= i -(line/2); b++){
				output += " "
			}
			for(let s = 1; s <= ((-2*i) + 2*line+1); s++){
				output += "*";
			}
			output += "\n"	
		}
	}
}

if(line%2 != 0){ //홀수를 입력받을 때
	for(let i = 1; i <= line + 1; i++){
		if( i <= line/2 +1 ){ //상단 부분
			for(let b = 1; b <= line/2-i + 1; b++){
				output += " ";
			}
			for(let s = 1; s <= i*2 -1; s++){
				output += "*";
			}
			output += "\n"	
		}else{
			for(let b = 1; b <= i -(line/2); b++){
				output += " "
			}
			for(let s = 1; s<= ((-2*i) + 2*line+1); s++){
				output += "*"
			}
			output += "\n"
		}
		
   }
}
console.log(output);
