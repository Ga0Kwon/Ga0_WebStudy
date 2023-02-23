package Day17.Ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex2_날짜와시간클래스 {
	public static void main(String[] args) {
		//1. Date, SimpleDateFormat
			//1) Date : Date 객체명 = new Date();
		Date now = new Date(); // 현재 시스템[컴퓨터] 날짜
		System.out.println(now);
			// ==
		String strNow1 = now.toString(); 
		System.out.println(strNow1);

			//2) SimpleDateFormat 객체명 = new SimpleDateFormat(패턴);
			// 객체명.format(날짜 객체) : 해당날짜객체가 패턴 형식으로 변환 [문자열로]
			/*
				  y : 연도	M : 월	d : 일
				  H : 시		m : 분	s : 초
			 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		String strNow2 = sdf.format(now);
		System.out.println(strNow2);
		
		
	}
}
