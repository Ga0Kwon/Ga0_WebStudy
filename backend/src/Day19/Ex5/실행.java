package Day19.Ex5;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
//		
//		boolean musicState = false; //음악 재생 여부
//		boolean movieState = false; //영화 재생 여부
		
		
		while(true) {
			System.out.print("1. 음악 재생/중지 2. 영화 재생/중지 : ");
			int choice = scanner.nextInt();
			
			Music music = new Music();
			Movie movie = new Movie();
			
			//만약에 1번을 입력하면서 음악이 꺼져있으면
			if(choice == 1 && music.play == false) { //1. 음악 재생
				music.start();
//				musicState = true;
				music.play = true;
			}else if(choice == 2 && movie.play == false) { //2. 영화 재생
				movie.start();
//				movieState = true;
				movie.play = true;
			}else if(choice == 1 && music.play == true) {// 1. 음악 중지
				music.play = false;
//				musicState = false;
				music = new Music();
			}
			else if(choice == 2 && movie.play == true) { //2. 영화 중지
//				movieState = false;
				movie.play = false;
				movie = new Movie();
			}
		}
	}
}
