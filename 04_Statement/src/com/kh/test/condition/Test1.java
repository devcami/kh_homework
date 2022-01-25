package com.kh.test.condition;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Test1 ts = new Test1();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char input = sc.next().charAt(0);
		int inputNum = (int)input;
		String result = " ";
		
		if(inputNum >= 48 && inputNum <= 57) { //숫자
			result = "숫자";
		}
		else if(inputNum >= 65 && inputNum <= 90) {
			result = "대문자 알파벳";
		}
		else if(inputNum >= 97 && inputNum <= 122) {
			result = "소문자 알파벳";
		}
		else {
			result = "특수문자";
		}
		
		System.out.printf("입력하신 문자 %c은/는 %s입니다.",input,result);
	
	}

}
