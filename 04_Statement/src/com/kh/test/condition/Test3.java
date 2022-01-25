package com.kh.test.condition;

import java.util.Scanner;

public class Test3 {
	/**
	 * 홀짝
	 */

	public static void main(String[] args) {
		Test3 ts = new Test3();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1~10 사이의 정수 입력 : ");
		int num = sc.nextInt();
		
		if(num > 10 || num < 1) {
			System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
		}
		else if (num % 2 == 0) {
			System.out.println("짝수다.");
		}
		else if (num % 2 == 1) {
			System.out.println("홀수다.");
		}
		
//		String result = ( num > 10 || num < 1) ? "반드시 1~10사이의 정수를 입력해야합니다." :
//									 ((num % 2 == 0)? "짝수다." : "홀수다.") ; 
//		System.out.println(result);

	
	}
	

}
