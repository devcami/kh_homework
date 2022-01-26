package com.kh.test.condition;

import java.util.Scanner;

public class IfTest5_2 {
	public static void main(String[] args) {
		IfTest5_2 ts = new IfTest5_2();
		ts.test();//여기로 리턴 후 종료
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 선택하세요. (1.가위 / 2.바위 / 3.보) : ");
		
		int userInput = sc.nextInt();
		int comInput = (int)(Math.random()*3+1);
		
		// 1, 2, 3이 아닌 경우 무효처리 하기 (3가지)
		if(userInput != 1 && userInput != 2 && userInput != 3) {
			// if(userInput < 1 || userInput > 3)
			// if(!(userInput == 1 || userInput ==2 || userInput ==3))
			System.out.println("잘못 입력하셨습니다. 게임을 종료합니다.");
			return; // 조기리턴 : 현재 메소드를 실행중지하고, 호출부로 즉시 리턴.
		}
		
		String user = userInput == 1 ? "가위" : userInput == 2 ? "바위" : "보";
		String com = comInput == 1 ? "가위" : comInput == 2 ? "바위" : "보";
		
		
		System.out.println("======== 결과 ========");
		System.out.printf("당신은 %s를 냈습니다.%n", user);
		System.out.printf("컴퓨터는 %s를 냈습니다.%n", com);		
		System.out.println("=====================");
		
		
		//비겼을때
		if(userInput == comInput)	
			{
			System.out.println("비겼습니다.");
			}
		//이겼을때
		else if((userInput == 1 && comInput == 3)||
				(userInput == 2 && comInput == 1)||
				(userInput == 3 && comInput == 2))
			{
			System.out.println("당신이 이겼습니다.");
			}
		else {
			System.out.println("당신이 졌습니다.");
		}
				
	}

}
