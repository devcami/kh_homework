package com.api.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcYourDays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("생년월일을 입력하세요 (예시 : 1990-01-01) >> ");
		String input = sc.nextLine();
		String[] inputStrArr = input.split("-");
		
		int[] ydd = new int[inputStrArr.length];
		for(int i = 0; i < inputStrArr.length; i++) {
			ydd[i] = Integer.parseInt(inputStrArr[i]);
		}
		
		Calendar birthday = new GregorianCalendar(ydd[0],ydd[1] - 1,ydd[2]);
		Calendar today = new GregorianCalendar(); 
		
		long now = today.getTimeInMillis();
		long bday = birthday.getTimeInMillis();
		
		double diff = (double)(now - bday) / 1000 / 60 / 60 / 24 ;
		
		// bday ~ now ( now - bday = 0일.xxx시간 -> 첫날이 0일이면 내림,1일이면 올림 )
		System.out.printf("오늘은 태어난지 " + (int)(Math.floor(diff)) + "일째 입니다.");
		
		
		
	}

}
