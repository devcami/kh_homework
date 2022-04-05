package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Test2 ts = new Test2();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int row = sc.nextInt();
		
		if(row > 0) {
			for(int i = 0; i < row; i++) {
				for(int j = row; j > i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		else System.out.println("양수가 아닙니다.");
		
	}

}
