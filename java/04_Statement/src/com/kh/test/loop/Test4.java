package com.kh.test.loop;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Test4 loopTest = new Test4();
//		loopTest.test1();
		loopTest.test2();
	}
	/**
	 * while version
	 * 문자열 길이 메소드 : java.lang.String.length()
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 입력 : ");
		String str = sc.next();
		System.out.print("검색할 문자 입력 : ");
		char ch = sc.next().charAt(0);
		//문자열 길이 변수
		int sum = 0;
		
		int i = 0;
		while(i < str.length()) {
			if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
			{			if(ch == str.charAt(i)) {
					sum++;
				}
			}else {
				System.out.println("영문자가 아닙니다."); break;
			}
			i++;
		}
		System.out.printf("%c가 포함된 횟수 : %d개", ch, sum);
		
	}
	
	/**
	 * for version
	 * 문자열 길이 method : java.lang.String.length()
	 */

	public void test1() {
		Scanner sc = new Scanner(System.in);

		//문자열입력
		System.out.print("문자열 입력 : ");
		String inputStr = sc.next();
		//문자입력
		System.out.print("검색할 문자 입력 : ");
		char inputChar = sc.next().charAt(0);

		//검색한 문자 포함 갯수
		int sum = 0;

		for (int i = 0; i < inputStr.length(); i++) {
			if((inputChar >= 'a' && inputChar <= 'z') || (inputChar >= 'A' && inputChar <= 'Z')) {
				if(inputChar == inputStr.charAt(i)) {
					sum++;
				}	
			}
			else {
				System.out.println("영문자가 아닙니다.");
				return;
			}
		}
		System.out.printf("'%c'가 포함된 갯수 : %d개%n",inputChar,sum);


	}
}
