package com.kh.test.condition;

import java.util.Scanner;

public class IfTest1 {
	
	public static void main(String[] args) {
		IfTest1 ts = new IfTest1();
		ts.test();
		ts.test1();
	}
	
	public void test1() {
		
		
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char input = sc.next().charAt(0);
		
		String result = " ";
		
		if(input >= '0' && input <= '9')  //숫자
			result = "숫자";
		else if(input >= 'A' && input <= 'Z') 
			result = "대문자 알파벳";
		else if(input >= 'a' && input <= 'z') 
			result = "소문자 알파벳";
		else if(input >= '가' && input <= '힣')
			result = "한글";
		else 
			result = "특수문자";
		
		System.out.printf("입력하신 문자 %c은/는 %s입니다.",input,result);
	
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		char input = sc.next().charAt(0);
		
		String result = " ";
		
		if(Character.isDigit(input))  //숫자
			result = "숫자";
		else if(Character.isUpperCase(input)) 
			result = "대문자 알파벳";
		else if(Character.isLowerCase(input)) 
			result = "소문자 알파벳";
		else if(isKoreanCharacter(input))
			result = "한글";
		else 
			result = "특수문자";
		
		System.out.printf("입력하신 문자 %c은/는 %s입니다.",input,result);
	
	}
	
	public static boolean isKoreanCharacter(char input) {
		boolean bool = input >= '가' && input <= '힣';
		return bool;
		//return input >= '가' && input <= '힣'; 이렇게 한줄로도 가능
	}

}
