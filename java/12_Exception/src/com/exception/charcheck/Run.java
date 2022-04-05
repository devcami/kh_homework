package com.exception.charcheck;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Run run = new Run();
		run.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		CharacterProcess cp = new CharacterProcess();
		while(true) {
			try {
				System.out.print("문자열을 입력하세요 : ");
				String s = sc.nextLine();
				System.out.println("영문자 갯수 = " + cp.countAlpha(s));
				break;
			} catch(RuntimeException e){
				e.printStackTrace();
				sc.next();
			}
		}
		
	}

}
