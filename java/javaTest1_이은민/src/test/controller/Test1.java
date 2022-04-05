package test.controller;

import java.util.Scanner;

public class Test1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = sc.nextInt();
		String result = "";
		
		if(num > 0 && num <= 100) {
		result = (num % 2 == 0) ? "2의 배수입니다." : "2의 배수가 아닙니다.";
		}
		else System.out.println("1~100 사이의 값을 입력하세요.");
		
		System.out.println(result);
	}

}
