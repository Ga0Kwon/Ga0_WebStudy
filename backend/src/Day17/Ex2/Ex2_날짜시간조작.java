package Day17.Ex2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ex2_날짜시간조작 {
	public static void main(String[] args) {
		
		//localDateTime => 날짜 제공과 동시에 조작할 수 있음
		LocalDateTime now = LocalDateTime.now(); //LocalDateTime.now()는 static 함수이므로 new안써도 됨
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss"); // 패턴을 넣을 수 있음
		System.out.println("현재 시간: " + now.format(dtf));
			
		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 덧셈: " + result1.format(dtf));
		
		LocalDateTime result2 = now.minusMonths(2);
		System.out.println("2월 뺄셈: " + result2.format(dtf));
				
		LocalDateTime result3 = now.plusDays(7);
		System.out.println("7일 덧셈: " + result3.format(dtf));
		
		LocalDateTime result4 = now.plusHours(10);
		System.out.println("10시간 덧셈: " + result4.format(dtf));
		
		LocalDateTime 시작일 = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
		LocalDateTime 종료일 = LocalDateTime.of(2021, 12, 31, 0, 0, 0);
		
		
		System.out.println("종료일이 시작일 이후: " + 시작일.isBefore(종료일));
		System.out.println("종료일이 시작일 이전: " + 시작일.isAfter(종료일));
		
		System.out.println("종료일과 시작일이 같은: " + 시작일.isEqual(종료일));
		
		System.out.println("연도 차이: " + (시작일.until(종료일, ChronoUnit.YEARS)));
		System.out.println("월 차이: " + (시작일.until(종료일, ChronoUnit.MONTHS)));
		System.out.println("일 차이: " + (시작일.until(종료일, ChronoUnit.DAYS)));
		System.out.println("시 차이: " + (시작일.until(종료일, ChronoUnit.HOURS))); // 364*24
		System.out.println("분 차이: " + (시작일.until(종료일, ChronoUnit.MINUTES))); // 364*24*60
		System.out.println("초 차이: " + (시작일.until(종료일, ChronoUnit.SECONDS))); // 364*24*60*60
		
		
	}
}
