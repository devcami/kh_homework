package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 ts = new Test3();
//		ts.test();
		ts.test1();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int n = (2 * num) - 1;
		
		//0 ~ 4행 (증가하는 *)
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//5 ~ 8행 (감소하는 *)
		for(int i = num; i < n; i++) {
			//" " : 행마다 1 2 3 4 개씩
			for(int j = num; j <= i; j++) {
				System.out.print(" ");
			}
			//* : 행마다 4 3 2 1 개씩
			for(int k = n ; k > i ; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int n = sc.nextInt();
		int num = n * 2;
		
		if(n < 0) {
			System.out.println("양수가 아닙니다.");
		}
		else {
			outer: 
			for(int i = 1; i < num; i++) {
				if(i > n) {
					for(int k = 1; k < n; k++) {
						for(int m = 0; m < k; m++) {
							System.out.print(" ");
						}
						for(int p = n; p > k; p--) {
							System.out.print("*");
						}
						System.out.println();
					}
					break outer;
				}

				
				for(int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}
	
	public void test2() {
		//행 수 : 2n-1 임을 이해.
		// 다른방법 - 어렵다면 행을 쪼개서 반복문 작성해도 됨
		// 다른방법 - 바깥반복문 : 5열 (-----)씩 반복, 안쪽반복문 : * 이 123454321 반복되도록
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int num = sc.nextInt();
		
		if(num < 1) {
			System.out.println("양의정수가 아닙니다");
			return;
		}
		int row = num * 2 - 1; //전체 행의 수
		for(int i = 0; i < row; i++) {
			//증가하는 모양
			//i = 0 1 2 3 4 
			if(i < num) {
				for(int j = 0; j <= i; j++) {
					System.out.print("*");
				}
			}
			//감소하는 모양 4행 5열 (공백 1234 / 별 4321)
			//	  i = 5 6 7 8  
			//blank = 1 2 3 4  i - (num - 1)
			//	  j = 0 1 2 3
			else {
				int blank = i - (num - 1); 
				for(int j = 0; j < num; j++) { 
					if(j < blank)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				
			}
			System.out.println();
		}
	}
	


}
