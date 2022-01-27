package com.kh.test.loop;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Test5 loopTest = new Test5();

		
		
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		String name = "";
		int age = 0;
		String addr = "";
		int height = 0;
		int weight = 0;
		String phone = "";
		
		// 기능추가2 : 회원수 지정
		System.out.print("몇명의 회원을 등록할까요? => ");
		int memberCnt = sc.nextInt();
		
		String result = "=================== 저장회원 ==================\n";
		
		// 기능추가1 : 평균 구하기
		int sumAge = 0;
		int sumHeight = 0;
		int sumWeight = 0;

		double avgAge = 0;
		double avgHeight = 0;
		double avgWeight = 0;
		
		
		for(int i = 0; i < memberCnt ; i++) {
			System.out.println("-------------- " + (i + 1) + " -----------------");
			
			System.out.print("이름을 입력하세요 : ");
			name = sc.next();
			
			System.out.print("나이를 입력하세요 : ");
			age = sc.nextInt();
			
			sc.nextLine();
			System.out.print("주소를 입력하세요 : ");
			addr = sc.nextLine();
			
			System.out.print("키를 입력하세요 : ");
			height = sc.nextInt();
			
			System.out.print("몸무게를 입력하세요 : ");
			weight = sc.nextInt();
			
			System.out.print("연락처를 입력하세요 : ");
			phone = sc.next();
			
			result += (i + 1) + "\t" 
					+ name + "\t" 
					+ age + "\t"
					+ addr + "\t"
					+ height + "cm\t"
					+ weight + "kg\t"
					+ phone + "\n";
			// 기능추가 1 : 평균구하기
			sumAge += age;
			sumHeight += height;
			sumWeight += weight;
		}
		
		// 기능추가 1 : 평균구하기
		avgAge = (double) sumAge / memberCnt;
		avgHeight = (double) sumHeight / memberCnt;
		avgWeight = (double) sumWeight / memberCnt;
		
		result += "============================================\n";
		System.out.println(result);	
		// 기능추가 1 : 평균구하기
		System.out.printf("평균나이 : %.1f세 | 평균신장 : %.1fcm | 평균몸무게 : %.1fkg", avgAge, avgHeight, avgWeight);
	}	
	
}


