package com.kh.test.loop;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 loopTest = new Test3();
		loopTest.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===구구단 프로그램===");
		System.out.print("정수 입력 (단) : ");
		int num = sc.nextInt();
		
		// num = 단 
		// i = 곱해주는 수 (1 ~ 9)
		if(num < 10 && num >= 1) {	
			System.out.printf("====%d단====%n",num);
			
			for(int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d%n", num, i, num*i);
			}			
		}
		else {
			System.out.println("잘못입력하셨습니다. 프로그램을 종료합니다.");
		}
			
	}

}
