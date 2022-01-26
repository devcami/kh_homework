package com.kh.test.loop;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 loopTest = new Test1();
		loopTest.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		for(int i = 0; i <= num; i += 2) {
			sum += i;
		}
		System.out.println("합 : " + sum);
		
	}

}
