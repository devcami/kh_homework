package com.kh.test.loop;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 loopTest = new Test2();
//		loopTest.test1();
		loopTest.test2();
	}
	
	/**
	 * while version
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		int i = 1;
		String sum = "";
		
		while(i <= inputNum) {
			if(i % 2 == 0) 
				sum += "박";
			else if(i % 2 == 1)
				sum += "수";
			i++;
		} System.out.println(sum);
		
	}
	/**
	 * for version
	 */
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		String sum = "";
		
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) {
				sum = "박";
			}
			else if (i % 2 == 1){
				sum = "수";
			}
			System.out.print(sum);			
		}
	}

}
