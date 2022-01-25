package com.kh.test.condition;

import java.util.Scanner;

public class Test2 {
	/**
	 * 계산기 
	 */
	
	public static void main(String[] args) {
		Test2 ts = new Test2();
		ts.test();	
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		System.out.print("연산자 입력 (+,-,*,/): ");
		char opt = sc.next().charAt(0);
		
		int result;
		
		if(opt == '+') {
			result = num1 + num2;
			System.out.printf("%d%c%d = %d 입니다.%n", num1, opt, num2, result);
			
		}
		else if (opt == '-') {			
			result = num1 - num2;
			System.out.printf("%d%c%d = %d 입니다.%n", num1, opt, num2, result);
			
		}
		else if (opt == '*') {
			result = num1 * num2;
			System.out.printf("%d%c%d = %d 입니다.%n", num1, opt, num2, result);
			
		}
		else if (opt == '/') {
			result = num1 / num2;
			System.out.printf("%d%c%d = %d 입니다.%n", num1, opt, num2, result);
			
		}
		else {
			System.out.println("잘못 입력 하셨습니다. 프로그램을 종료합니다.");
		}
		
		
	}

}
