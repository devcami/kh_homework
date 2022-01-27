package com.kh.test.loop;

import java.util.Scanner;

public class Test8 {
	public static void main(String[] args) {
		Test8 ts = new Test8();
//		ts.test1();
		ts.test2();
		
	}
	public void test2() { // while로 풀어보기
		Scanner sc = new Scanner(System.in);
		String menu = "메뉴\n\n"
					+ "김밥류 ===================\n"
					+ "1.원조김밥===========1500원\n"
					+ "2.치즈김밥===========2000원\n"
					+ "3.참치김밥===========2300원\n\n"
					+ "라면류 ===================\n"
					+ "4.그냥라면===========3000원\n"
					+ "5.치즈라면===========3500원\n"
					+ "6.짬뽕라면===========4000원\n"
					+ "분식류 ===================\n\n"
					+ "7.떡볶이=============2500원\n"
					+ "8.순대==============2500원\n"
					+ "9.오뎅==============1000원\n\n"
					+ "기타 ====================\n"
					+ "10.음료수===========1000원\n\n"	
					+ "========================\n";
		int choice = 0; 
		int amount = 0;
		int sum = 0; // 고른 메뉴 x 갯수 가격
		
		char yn = ' ';
		
		String menuName = ""; 
		
		String result = "결과 \n" 
					+ "주문하신 정보는 다음과 같습니다. \n"
					+ "----------------------------\n\n";
		
		int totalPrice = 0; // 총 가격합산
		
		do { 
			System.out.println(menu);
			System.out.print("메뉴 선택 >> ");
			choice = sc.nextInt();
			System.out.print("갯수 선택 >> ");
			amount = sc.nextInt();
			
			switch(choice) {
			case 1:
				menuName = "원조김밥";
				sum = (1500 * amount);
				break;
			case 2:
				menuName = "치즈김밥";
				sum = (2000 * amount);
				break;
			case 3:
				menuName = "참치김밥";
				sum = (2300 * amount);
				break;
			case 4:
				menuName = "그냥라면";
				sum = (3000 * amount);
				break;
			case 5:
				menuName = "치즈라면";
				sum = (3500 * amount);
				break;
			case 6:
				menuName = "짬뽕라면";
				sum = (4000 * amount);
				break;
			case 7:
				menuName = "떡볶이";
				sum = (2500 * amount);
				break;
			case 8:
				menuName = "순대";
				sum = (2500 * amount);
				break;
			case 9:
				menuName = "오뎅";
				sum = (1000 * amount);
				break;
			case 10:
				menuName = "음료수";
				sum = (1000 * amount);		
				break;
			default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.\n");	 continue;
			}
			 
			result += menuName + " : " + amount + "개 - " + sum + "원\n"; 
			totalPrice += sum;
			
			System.out.println("추가 주문 하시겠습니까 ? (y/n)");
			yn = sc.next().charAt(0);
			if(yn == 'y') continue;
			else if(yn == 'n') break;
			else System.out.println("잘못 입력하셨습니다. (y/n)중에서 입력해주세요.\n");
						
		}
		while(true);
		
		System.out.println(result);
		System.out.println("----------------------------");
		System.out.printf("합계 : %d원", totalPrice);
		
	}
	public void test1() { // for로 풀어보기 
		Scanner sc = new Scanner(System.in);
		String menu = "메뉴\n\n"
					+ "김밥류 ===================\n"
					+ "1.원조김밥===========1500원\n"
					+ "2.치즈김밥===========2000원\n"
					+ "3.참치김밥===========2300원\n\n"
					+ "라면류 ===================\n"
					+ "4.그냥라면===========3000원\n"
					+ "5.치즈라면===========3500원\n"
					+ "6.짬뽕라면===========4000원\n"
					+ "분식류 ===================\n\n"
					+ "7.떡볶이=============2500원\n"
					+ "8.순대==============2500원\n"
					+ "9.오뎅==============1000원\n\n"
					+ "기타 ====================\n"
					+ "10.음료수===========1000원\n\n"	
					+ "========================\n";
		int choice = 0; 
		int amount = 0;
		int sum = 0; // 고른 메뉴 x 갯수 가격
		
		char yn = ' ';
		
		String menuName = ""; 
		
		String result = "결과 \n" 
					+ "주문하신 정보는 다음과 같습니다. \n"
					+ "----------------------------\n\n";
		
		int totalPrice = 0; // 총 가격합산
		
		for(;;) {
			System.out.println(menu);
			System.out.print("메뉴 선택 : ");
			choice = sc.nextInt();
			
			System.out.print("갯수 선택 : ");
			amount = sc.nextInt();

			switch(choice) {
			case 1 : 
				menuName = "원조김밥";
				sum = (1500 * amount); break;
			case 2 : 
				menuName = "치즈김밥";
				sum = (2000 * amount); break;
			case 3 : 
				menuName = "참치김밥";
				sum = (2300 * amount); break;
			case 4 : 
				menuName = "그냥라면";
				sum = (3000 * amount); break;
			case 5 : 
				menuName = "치즈라면";
				sum = (3500 * amount); break;
			case 6 : 
				menuName = "짬뽕라면";
				sum = (4000 * amount); break;
			case 7 : 
				menuName = "떡볶이";
				sum = (2500 * amount); break;
			case 8 : 
				menuName = "순대";
				sum = (2500 * amount); break;
			case 9 : 
				menuName = "오뎅";
				sum = (1000 * amount); break;
			case 10 : 
				menuName = "음료수";
				sum = (1000 * amount); break;
				
			default : System.out.println("잘못 입력하셨습니다 . 다시 입력해주세요."); 

			}
			result += menuName + " : " + amount + "개" + " - " + sum + "원\n";
			totalPrice += sum;
			
			System.out.println("추가주문 하시겠습니까 ? (y/n)");
			yn = sc.next().charAt(0);
			if(yn == 'y') continue;
			else if(yn == 'n') break;
			else System.out.println("잘못 입력하셨습니다. (y/n) 중 하나만 입력해주세요.");
		}
		//주문결과서 출력
		System.out.println(result);
		System.out.println("----------------------------");
		System.out.printf("합계 : %d원",totalPrice);
	}

}
