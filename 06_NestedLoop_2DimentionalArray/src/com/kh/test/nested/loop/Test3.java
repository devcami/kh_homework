package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		Test3 ts = new Test3();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		//0 ~ 4행 (증가하는 *)
		for(int i = 0; i < num; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//5 ~ 8행 (감소하는 *)
		for(int i = num; i < (num*2)-1; i++) {
			//" " : 행마다 1 2 3 4 개씩
			for(int j = num; j <= i; j++) {
				System.out.print(" ");
			}
			//* : 행마다 4 3 2 1 개씩
			for(int k = (num*2)-1 ; k > i ; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
