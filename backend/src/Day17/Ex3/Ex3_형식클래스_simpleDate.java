package Day17.Ex3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex3_형식클래스_simpleDate {
	public static void main(String[] args) {
		Date now = new Date();
		
		//SimpleDateFormat(패턴)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("오늘은 E요일");
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("올해의 D번째 날"); //1년(365일) 기준으로 며칠인지
		System.out.println( sdf.format(now) );

		sdf = new SimpleDateFormat("이달의 d번째 날"); //월기준으로 며칠인지
		System.out.println( sdf.format(now) );
	}
}
