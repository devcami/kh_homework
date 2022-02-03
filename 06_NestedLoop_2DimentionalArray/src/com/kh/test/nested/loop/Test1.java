package com.kh.test.nested.loop;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Test1 ts = new Test1();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 하나 입력 : ");
		int row = sc.nextInt();
		int k = 1;
		
		if(row > 0) {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j <= i; j++) {
					System.out.print(j + 1);
				}
				System.out.println();
			}
		}
		else {
			System.out.println("양의 정수가 아닙니다.");
		}
	}

}
