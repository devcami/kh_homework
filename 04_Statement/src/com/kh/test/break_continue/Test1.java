package com.kh.test.break_continue;

import java.util.Scanner;

public class Test1 {
	public static void main (String[] args) {
		Test1 ts = new Test1();
//		ts.test1();
		ts.test2();
	}
	public void test1(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		int i = 0;
		int sum = 1;
		
		// 1부터 입력받은 정수까지
		while(i <= inputNum) {
			i++;
			
			// 홀수일 때의 곱
			if(i % 2 == 0) {
				continue; //continue를 썼으니 증감식을 위에
			}
			sum *= i;
		}
		System.out.println(sum);	
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		//정수 두개를 입력받아서 
		System.out.print("정수를 하나 입력하세요. => ");
		int num1 = sc.nextInt();
		
		System.out.print("다른 정수를 하나 입력하세요. => ");
		int num2 = sc.nextInt();
		
		int sum = 0;
		
		// 큰수/작은수에 해당하는 변수
		int minNum = Math.min(num1, num2);
		int maxNum = Math.max(num1, num2);
		
		// 작은 정수에서 큰 정수까지 홀수의 합
		for(int i = minNum ; i <= maxNum; i++) {
			if(i % 2 ==0) continue;
			sum += i;
		}
		
		System.out.println("====================");
		System.out.printf("%d부터 %d까지의 홀수의 합은 %d입니다.", 
							Math.min(num1, num2),
							Math.max(num1, num2),
							sum);
	}

}
