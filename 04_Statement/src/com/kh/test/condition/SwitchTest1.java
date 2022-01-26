package com.kh.test.condition;

import java.util.Scanner;

public class SwitchTest1 {
	
	public static void main(String[] args) {
		SwitchTest1 study = new SwitchTest1();
		study.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		
		String menu = "----------menu----------\n"
					+ "1. 가정용 (50원/liter)\n"
					+ "2. 상업용 (45원/liter)\n"
					+ "3. 공업용 (30원/liter)\n"
					+ "------------------------";
		
		//메뉴 출력
		System.out.println(menu);
		System.out.print("메뉴번호를 입력하세요. ==> \n");
		int num = sc.nextInt(); //용도번호
		
		System.out.print("물 사용량을 입력하세요. ==> \n");
		int amt = sc.nextInt(); //사용량
		
		//변수 설정
		int cost = 0; //사용 요금 : 용도별 가격 * 사용량(amt)
		String guide = ""; // 메뉴안내
		
		switch(num) {
		case 1 : {
			guide = "가정용(가";
			cost = amt * 50;
			break;
		}
		case 2 : {
			guide = "상업용(업소";
			cost = amt * 45;
			break;
		}
		case 3 : {
			guide = "공업용(공업";
			cost = amt * 30;
			break;
		}
		default : System.out.println("메뉴 번호는 1, 2, 3만 가능합니다."); break;
		}
		
		int water = (int)(cost * 0.05); //수도세 : 사용요금의 5% (cost 5%)
		int total = cost + water; //총 수도요금 : 사용요금 + 수도세 (cost + water)
		
		System.out.println("----------<<수도세>>-----------");
		System.out.printf("선택 메뉴 번호 : %d. %s에서 사용하시는 경우)을/를 선택하셨습니다.%n",num,guide);
		System.out.printf("사용 요금 : %d%n",cost);
		System.out.printf("수도세 : %d%n",water);
		System.out.printf("총 수도 요금 : %d원%n",total);
		
	}

}
