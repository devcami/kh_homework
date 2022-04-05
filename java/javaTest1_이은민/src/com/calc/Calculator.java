package com.calc;

public class Calculator {
	public static void main(String[] args) {
		
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		
		if((num1 >= 0 && num1 < 10) && (num2 >= 0 && num2 < 10)) {
			System.out.println("합 : " + (num1 + num2));
			System.out.println("차 : " + (num1 - num2));
			System.out.println("곱 : " + (num1 * num2));
			if(num1 <= 0)
				System.out.println("나누기 : 0");
			else
				System.out.println("나누기 : " + (num1 / num2));
		}
	}

}
