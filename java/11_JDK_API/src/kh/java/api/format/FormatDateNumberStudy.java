package kh.java.api.format;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDateNumberStudy {

	public static void main(String[] args) throws ParseException {
		FormatDateNumberStudy study = new FormatDateNumberStudy();
		study.test1();
//		study.test2();
		
	}
	/**
	 * 숫자 포맷
	 *  - 세자리마다 콤마찍기
	 *  - 소수점이하 n번째까지 표현
	 *  
	 *  - 0 자리수가 비어있으면 0을 써서 처리
	 *  - # 자리수가 비어있으면 공란 처리
	 *  
	 *  숫자를 잘라 표현해야하는 경우 반올림처리된다.
	 *  올림 , 버림의 경우 Math.ceil floor 사용한다.
	 */
	public void test2() {
		double n = 123.456;
//		DecimalFormat df = new DecimalFormat("0.##"); 123.46 
//		DecimalFormat df = new DecimalFormat("0.#####"); 123.456  비어있는 곳 공란처리 
		DecimalFormat df = new DecimalFormat("0.00000"); //123.45600  비어있는 곳 0처리
		String result = df.format(n);
		System.out.println(result);
		
		//세자리마다 콤마찍기
		df.applyPattern("￦#,###");
		System.out.println(df.format(1234567890));
		
				
	}
	
	
	/**
	 * 날짜 포맷
	 * 1. SimpleDateFormat 포맷형식지정
	 * 2. SimpleDateFormat#format에 Date객체 전달
	 * @throws ParseException 
	 */
	public void test1() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh시 mm분 ss초"); 
		String formattedDate = sdf.format(new Date());
		System.out.println(formattedDate);
		
		Date date = sdf.parse(formattedDate);
		System.out.println(date);
		//요일(한글)은 처리가 안돼서 뺌
	}

}
