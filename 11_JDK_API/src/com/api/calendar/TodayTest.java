package com.api.calendar;

import java.util.Calendar;

public class TodayTest {

	public static void main(String[] args) {
		TodayTest t = new TodayTest();
		Calendar today = Calendar.getInstance();
		
		t.printCalendar(today);
		
	}
	public void printCalendar(Calendar calendar) {
		String[] dow = {"일","월","화","수","목","금","토"};
		System.out.printf("오늘은 %d년 %d월 %d일 %s요일",
				calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONTH)+ 1, 
				calendar.get(Calendar.DATE), 
				dow[calendar.get(Calendar.DAY_OF_WEEK) - 1]);
	}

}
