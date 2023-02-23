package Day17.Ex2;

import java.util.Calendar;
import java.util.TimeZone;

public class Ex2_캘린더클래스 {
	public static void main(String[] args) {
		//1. Calendar 클래스
		Calendar now = Calendar.getInstance();
		
		int year    = now.get(Calendar.YEAR); // 현재 연도 가져오기              
		int year2 = now.get(1);
		System.out.println(year2);
		
		int month  = now.get(Calendar.MONTH) + 1;   //현재 월 가져오기 0부터 시작하기때문에 +1 (0~11 => 1~12)
		int month2 = now.get(2) + 1;
		System.out.println(month2);
		
		int day    = now.get(Calendar.DAY_OF_MONTH); //현재 일 가져오기
		int day2    = now.get(Calendar.DAY_OF_YEAR); // 1년 365일 기준으로 현재 일 수가 나옴.
		System.out.println(day2);
		
		
		int week    = now.get(Calendar.DAY_OF_WEEK);  
		
		String strWeek = null;
		switch(week) {
			case Calendar.MONDAY: 		strWeek = "월"; 	break;
			case Calendar.TUESDAY: 		strWeek = "화"; break;
			case Calendar.WEDNESDAY: 	strWeek = "수"; break;
			case Calendar.THURSDAY: 	strWeek = "목"; break;
			case Calendar.FRIDAY: 		strWeek = "금"; break;
			case Calendar.SATURDAY: 	strWeek = "토"; break;
			default: 							strWeek = "일";
		}
		
		if(week == 2) {System.out.println("월");}
		else if(week == 3) {System.out.println("화");}
		else if(week == 4) {System.out.println("수");}
		else if(week == 5) {System.out.println("목");}
		else if(week == 6) {System.out.println("금");}
		else if(week == 7) {System.out.println("토");}
		else if(week == 1) {System.out.println("일");}
		
		// 오전 : 0   오후 : 1
		int amPm  = now.get(Calendar.AM_PM);   
		String strAmPm = null;
		
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour    = now.get(Calendar.HOUR);                 
		int minute  = now.get(Calendar.MINUTE);             
		int second  = now.get(Calendar.SECOND);              

		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.println(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.println(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초 ");
		
		// 각국의 표준시ID 얻기
		for(String timeId : TimeZone.getAvailableIDs()) {
			System.out.println(timeId);
		}
	}
}
