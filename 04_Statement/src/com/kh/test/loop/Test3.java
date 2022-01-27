package com.kh.test.loop;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 loopTest = new Test3();
//		loopTest.test1();
		loopTest.test2();
	}
	/**
	 * while version
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("===구구단 프로그램===");
		System.out.print("구구단 단수 입력 : ");
		final int DAN = sc.nextInt();
		int i = 1;
		
		if(DAN < 10 && DAN > 1) {
			System.out.printf("===%d단===\n",DAN);
			while(i < 10) {
				System.out.printf("%d x %d = %d\n", DAN, i , DAN * i);
				i++;
			}
		}else 
			System.out.println("1~9 까지의 정수를 입력해주세요.");
	}
	/**
	 * for version
	 */
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
