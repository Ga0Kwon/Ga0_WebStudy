let line = Number(prompt("총 줄 수를 입력"));

let output ="";

if(line%2 != 0){ //입력받은 줄의 수가 홀수일 경우
    //i는 현재 줄이 된다.
    for(let i = 1; i<= line; i++){ //입력받은 줄의 수만큼 출력해야하기때문에 반복[홀수]
        if(i <= line/2 +1){ //상단 if start -> 홀수이기 때문에 상단이 하나더 많아야해서 +1

            //b는 공백을 의미 -> line/2+1이 상단에 해당되는 부분 MAX
            for(let b = 1; b <= line/2+1-i; b++){ //상단 공백 for start
                output += " "; //공백 추가
            }//상단 공백 for end
            
            //s는 별을 의미 ->그냥 i*2-1를 사용하는 것은 if문에서 상단MAX부분을 넘어가게되면 실행을 안하기 때문
            for(let s = 1; s <= i*2 -1; i++){ // 상단 별 for start
                output += "*"; //별 추가
            } //상단 별 for end
            
            //if(i <= line/2+1){안에 있는 모든 for문은 한줄에 있는 공백 몇개, 별 몇개를 변수에 저장하는 코드}
            //따라서, 한줄이 끝날 때는 줄바꿈은 필수이다.
            output = "\n"
            
        }//상단 if end
        else{ // i(현재 줄이)line/2 + 1보다 클 경우 -> 하단! else start
            //b는 공백을 의미 -> 입력받은 줄이 홀수 일 경우는 line = line/2 + line/2 + 1;
            //line/2 + 1 : 상단 부분 / line/2 : 하단 부분 
            for(let b = 1; b <=i - line/2; b++){ //상단은 하단의 반대이기때문에 조건식의 내용을 거꾸로
                output += " " //공백 추가
            }
            //s는 별 출력을 의미
            for(let s = 1; s <= ((line*2 +1) - (i*2)); s++){
                output += "*"; //별 추가 
            }

            //if(i <= line/2+1){안에 있는 모든 for문은 한줄에 있는 공백 몇개, 별 몇개를 변수에 저장하는 코드}
            //따라서, 한줄이 끝날 때는 줄바꿈은 필수이다.
            output += "\n";

        }//else end
        
    } //줄의 수만큼 반복하는 for문 end[홀수]

} // if end
else{// 입력받은 줄의 수가 홀수가 아닐 경우 -> 짝수일 경우
    for(let i = 1; i<=line; i++){ //입력받은 줄의 수만큼 출력 for문 start[짝수]
        //짝수일 경우는 딱 반으로 나눌 수 있기때문에 line/2 그리고, i는 현재줄이 된다.
        if(i <= line/2){ //상단 if start

            //b는 공백을 의미 -> 상단부분 line/2 
            for(let b = 1; b <= line/2 - i; b++){
                output += " ";
            }

            //s는 별을 의미 ->그냥 i*2-1를 사용하는 것은 if문에서 상단MAX부분을 넘어가게되면 실행을 안하기 때문
            for(let s = 1; s<= 2*i -1; s++){
                output += "*";
            }

            //if(i <= line/2+1){안에 있는 모든 for문은 한줄에 있는 공백 몇개, 별 몇개를 변수에 저장하는 코드}
            //따라서, 한줄이 끝날 때는 줄바꿈은 필수이다.
            output = "\n"

        }//상단 if end
        else{ //i(=현재줄이) line/2보다 클 경우 -> 하단! else start
            //b는 공백을 의미 -> 하단 line/2
            for(let b = 1; b <= i -(line/2)-1; i++){//상단식과 반대이므로 거꾸로 하되, -1을 해준다.
                output += " " //공백 추가
            }
            //s는 별 출력을 의미 -> 짝수와 홀수 부분이 동일하므로 동일한 코드를 사용한다.
            for(let s = 1; s <= ((line*2 +1) - (i*2)); s++){
                output += "*"; //별 추가 
            }
            //if(i <= line/2+1){안에 있는 모든 for문은 한줄에 있는 공백 몇개, 별 몇개를 변수에 저장하는 코드}
            //따라서, 한줄이 끝날 때는 줄바꿈은 필수이다.
            output += "\n";
        }//else end
    } //줄의 수만큼 반복하는 for문 end[짝수]
} //else ends
