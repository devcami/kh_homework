package kh.java.api.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Date class - 기본생성자, Long타입생성자를 제외하고는 거의 deprecated
 * Calendar class
 * 
 * java.time package에서 LocalDate, LocalDateTime...을 제공
 *
 */
public class CalendarDateStudy {

	public static void main(String[] args) {
		CalendarDateStudy study = new CalendarDateStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
	}
	/**
	 * Calendar -> Date
	 * Date -> Calendar
	 */
	public void test4() {
		// 1. Calendar -> Date
		Calendar cal = Calendar.getInstance();
		
		//Date생성자에는 () 혹은 (long)
		long epochTime = cal.getTimeInMillis();
		Date date = new Date(epochTime);
		
		System.out.println(cal + "\n");
		System.out.println(date);
		
		// 2. Date -> Calendar
		Date now = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		printCalendar(calendar);
		
	}
	/**
	 * 날짜 차이 계산하기 (디데이)
	 * 
	 *  - Epoch Time
	 *  - 정밀한 날짜를 위한 약속 
	 *  - 1970년 1월 1일 자정 기준으로 누적된 밀리초를 정수로 반환
	 *  
	 *  올림 		Math.ceil
	 *  반올림 	Math.round
	 *  내림		Math.floor
	 */
	public void test3() {
		//오늘
		Calendar today = Calendar.getInstance();
		
		//D-day 2/21 자정(0시 0분 0초) 기준
		Calendar dday = new GregorianCalendar(2022, 2 - 1, 21);
		
		//milli second 단위로 변환 후 계산
		//millisecond -> second : /1000
		//second -> minute : /60
		//minute -> hour : /60
		//hour -> day : /24
		long future = dday.getTimeInMillis();
		long past = today.getTimeInMillis();
		double diff = (double)(future - past) / 1000 / 60 / 60 / 24 ; //밀리초 -> 초 -> 분 -> 시간 -> 일
		System.out.println(diff);
		//3.47 ....
		//올림처리 Math.ceil 
		System.out.println("오늘은 D" + (diff > 0 ? "-" : "+") + (int)(Math.ceil(diff)) + "입니다.");
		
	}
	
	/**
	 * 특정 일자를 가리키는 Calendar객체 만들기
	 * 
	 * 2022/8/29
	 */
	public void test2() {
		//1. Calender의 setter를 이용하는 방식
		//시분초 : 현재 정보 유지
		Calendar dday1 = Calendar.getInstance();
		dday1.set(2022, 8 - 1, 29);
		printCalendar(dday1);
		
		//2. Gregorian 객체를 생성할 때 생성자에 셋팅
		//시분초 : 기본값 0
		Calendar dday2 = new GregorianCalendar(2022, 8-1, 29);
		printCalendar(dday2);
		
		
	}
	
	public void printCalendar(Calendar cal) {
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초%n",
							cal.get(Calendar.YEAR),
							cal.get(Calendar.MONTH) + 1,
							cal.get(Calendar.DATE),
							cal.get(Calendar.HOUR_OF_DAY),
							cal.get(Calendar.MINUTE),
							cal.get(Calendar.SECOND));
	}
	/**
	 * Calendar
	 * OS가 가진 시간정보를 가져와서 나타내는 것.
	 * 현재 일자를 나타내는 Calendar객체 만들기
	 */
	public void test1() {
		//Calendar 객체 생성
		//new 연산자로 생성 X -> Calendar는 추상클래스
		
		//1. getInstance
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1);
		
		//2. 자식클래스인 GregorianCalendar로 만들기
		Calendar cal2 = new GregorianCalendar();
		System.out.println(cal2);
		
		//년 월 일 시 분 초 불러오기
		System.out.println(cal1.get(Calendar.YEAR));
		System.out.println(cal1.get(Calendar.MONTH) + 1); // MONTH는 0부터 시작
		System.out.println(cal1.get(Calendar.DATE));
		System.out.println(cal1.get(Calendar.DAY_OF_MONTH)); 
		System.out.println(cal1.get(Calendar.DAY_OF_WEEK)); // 일요일이 1부터 시작
		String[] weeks = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(weeks[cal1.get(Calendar.DAY_OF_WEEK) - 1]);
		
		System.out.println(cal1.get(Calendar.HOUR)); //12시간제 ( 0 ~ 11 )
		System.out.println(cal1.get(Calendar.HOUR_OF_DAY)); //24시간제 ( 0 ~ 23 )
		System.out.println(cal1.get(Calendar.MINUTE)); 
		System.out.println(cal1.get(Calendar.SECOND)); 
		System.out.println(cal1.get(Calendar.MILLISECOND)); 
		
		System.out.println(cal1.getActualMaximum(Calendar.MONTH)); //이번 년 말월
		System.out.println(cal1.getActualMaximum(Calendar.DATE)); //이번 달 말일
		
	}

}
