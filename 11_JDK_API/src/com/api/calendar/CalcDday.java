package com.api.calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class CalcDday {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("계산하고싶은 날짜를 입력하세요 (예시 : 1990-01-01) >> ");
		String input = sc.nextLine();
		String[] inputStrArr = input.split("-");
		
		int[] ydd = new int[inputStrArr.length];
		for(int i = 0; i < inputStrArr.length; i++) {
			ydd[i] = Integer.parseInt(inputStrArr[i]);
		}
		
		Calendar todayCalendar = new GregorianCalendar();
		Calendar ddayCalendar = new GregorianCalendar(ydd[0],ydd[1] - 1,ydd[2]);
		
		long today = todayCalendar.getTimeInMillis();
		long dday = ddayCalendar.getTimeInMillis();
		
		double diff = (double)(dday - today) / 1000 / 60 / 60 / 24;
		
		if(diff == 0) {
			System.out.println("D-DAY입니다");
		}
		else if(diff > 0) {
			System.out.println((int)(Math.ceil(diff)) + "일 남았습니다.");
		}
		else if(diff < 0){
			System.out.println(-(int)(Math.ceil(diff)) + "일 지났습니다.");
		}
	}

}
