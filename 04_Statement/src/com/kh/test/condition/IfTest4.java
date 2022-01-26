package com.kh.test.condition;

import java.util.Scanner;

public class IfTest4 {
	/**
	 * bmi test 
	 */

	public static void main(String[] args) {
		IfTest4 ts = new IfTest4();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("키 입력 (단위 m): ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게 입력 (단위 kg): ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		String result = " ";
		
		if(bmi < 18.5) {
			result = "저체중";
		}
		else if(bmi >= 18.5 || bmi < 23) {
			result = "정상체중";
		}
		else if(bmi >= 23 || bmi < 25) {
			result = "과체중";
		}
		else if(bmi >= 25 || bmi < 30) {
			result = "비만";
		}
		else {
			result = "고도비만";
		}
		System.out.printf("체질량지수 %.1f로 %s입니다.%n",bmi,result);
	}

}
