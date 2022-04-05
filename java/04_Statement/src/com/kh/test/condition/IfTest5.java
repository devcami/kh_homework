package com.kh.test.condition;

import java.util.Scanner;

public class IfTest5 {
/**
 * 가위바위보 게임
 */
	public static void main(String[] args) {
		IfTest5 ts = new IfTest5();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 선택하세요. (1.가위 / 2.바위 / 3.보) : ");	
		int userRsp = sc.nextInt();
		//컴퓨터 가위바위보 중 랜덤값
		int comRsp = (int)(Math.random()*3+1);
		
		String userResult = " ";
		String comResult = " ";
		
		String win = "당신이 이겼습니다 !";
		String lose = "당신이 졌습니다 !";
		String draw = "당신과 컴퓨터는 비겼습니다 !";
				
		String endResult = " ";
		
		
		if(userRsp == 1) {
			userResult = "가위"; 
			if(comRsp == 1) { //둘다 가위인 경우
				comResult = "가위";
				endResult = draw;
			}
			else if(comRsp == 2) { //컴 바위
				comResult = "바위";
				endResult = lose;
			}
			else if(comRsp == 3) { //컴 보자기
				comResult = "보";
				endResult = win;
			}
		}
		else if(userRsp == 2) {
			userResult = "바위";
			if(comRsp == 1) { 
				comResult = "가위";
				endResult = win;
			}
			else if(comRsp == 2) { 
				comResult = "바위";
				endResult = draw;
			}
			else if(comRsp == 3) { 
				comResult = "보";
				endResult = lose;
			}
			
		}
		else if(userRsp == 3) {
			userResult = "보";
			if(comRsp == 1) { 
				comResult = "가위";
				endResult = lose;
			}
			else if(comRsp == 2) { 
				comResult = "바위";
				endResult = win;
			}
			else if(comRsp == 3) { 
				comResult = "보";
				endResult = draw;
			}
			
		}
		System.out.println("======== 결과 ========");
		System.out.printf("당신은 %s를 냈습니다.%n", userResult);
		System.out.printf("컴퓨터는 %s를 냈습니다.%n", comResult);		
		System.out.println("=====================");
		System.out.println(endResult);
	}
	

}
