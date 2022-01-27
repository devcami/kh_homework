package kh.java.loop;

import java.util.Scanner;

import com.kh.test.condition.IfTest5_2;

import kh.java.condition.SwitchStudy;
import kh.java.random.number.RandomStudy;

public class WhileLoopStudy {
	public static void main(String[] args) {
		WhileLoopStudy study = new WhileLoopStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test3_();
//		study.test4();
//		study.test5();
		study.test6();
	
	}
	/**
	 *  다단메뉴 구성 (여러 메뉴 단계 구성하기)
	 */
	public void test6() {
		Scanner sc = new Scanner(System.in);
		String menu = "===== 메인메뉴 =====\n"
					+ "1. 음식주문\n"
					+ "2. 게임\n"
					+ "0. 종료\n"
					+ "-----------------\n"
					+ "입력 : ";
		do {
			//메뉴 노출 및 선택
			System.out.print(menu);
			String choice = sc.next();
			
			//메뉴 선택에 따른 분기
			switch(choice) {
			case "1" : foodMenu();break;
			case "2" : gameMenu();break;
			case "0" : System.out.println("이용해주셔서 감사합니다."); return;
			default : System.out.println("잘못 입력하셨습니다.");
			}
			
		} while (true);
		
	}
	/**
	 * 1. 한식 //SwitchStudy#test2()
	 * 2. 분식 //ForLoopStudy#test4()
	 */
	
	public void foodMenu() {
		Scanner sc = new Scanner(System.in);
		String menu = "===== 음식메뉴 =====\n"
					+ "1. 한식\n" 
					+ "2. 분식\n"  
					+ "0. 음식메뉴 종료\n"
					+ "-----------------\n"
					+ "입력 : ";
		
		do {
			System.out.print(menu);
			String choice = sc.next();
			
			switch(choice) {
			case "1" :
				SwitchStudy food1 = new SwitchStudy();
				food1.test2();
				break;
			case "2" :
				ForLoopStudy food2 = new ForLoopStudy();
				food2.test4();
				break;
			case "0" : return; //test6의 foodMenu 호출코드로 리턴 
			default : System.out.println("잘못 입력하셨습니다.");
						
			}
		}while(true);
	}
	public void gameMenu() {
		Scanner sc = new Scanner(System.in);
		String menu = "===== 게임메뉴 =====\n"
					+ "1. 가위바위보\n"
					+ "2. 동전게임\n"
					+ "0. 게임메뉴 종료\n"
					+ "-----------------\n"
					+ "입력 : ";
		
		do {
			System.out.print(menu);
			String choice = sc.next();
			
			switch(choice) {
			case "1" : 
				IfTest5_2 r = new IfTest5_2();
				r.test();
				;break;
			case "2" : 
				RandomStudy r2 = new RandomStudy();
				r2.test3();
				;break;
			case "0" : return;
			default : System.out.println("잘못 입력하셨습니다.");
			
			}
		}while(true);
	
	}
	
	/**
	 *  do ~ while문
	 *   - while문 실행순서 : 조건식 - 실행코드 
	 *   - do while문 실행순서 : 실행코드 - 조건식 
	 *   
	 *   > do while은 false여도 실행코드가 한번은 무조건 실행된다.
	 */
	public void test5() {
		Scanner sc = new Scanner(System.in);
		RandomStudy coinGame = new RandomStudy();
		char yn = 'y';
		
		do {
//			동전 게임 메소드 가져와 사용하기
//			coinGame.test3();
			
			System.out.print("계속 하시겠습니까? (y/n) : ");
			yn = sc.next().charAt(0);
			
		} while(yn == 'y'); //사용할 변수는 do블럭 밖에 선언되어야 한다.
		
		System.out.println("이용해주셔서 감사합니다.");
	}
	
	
	/**
	 * while문을 반복해두고, 실행시 동적으로 종료/탈출하기.
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		RandomStudy coinGame = new RandomStudy();
		
		while(true) {
			//동전 게임 메소드 가져와 사용하기
			coinGame.test3();
			
			System.out.print("계속 하시겠습니까? (y/n) : ");
			char yn = sc.next().charAt(0);
			if(yn == 'n') break;
		}
		
		System.out.println("이용해주셔서 감사합니다.");
	}
	
	/**
	 * 1부터 사용자 입력 정수 까지의 합
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		
		int i = 1;
		int sum = 0;
		
		while(i <= inputNum) {
			sum += i;
			i++;
		}
		System.out.printf("1부터 %d까지의 합 : %d", inputNum, sum);
		
	}
	
	public void test3_() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int inputNum = sc.nextInt();
		int tem = inputNum; // inputNum 복사
		
		int sum = 0;
		
		while(inputNum > 0)  // 한줄이면 중괄호 생략 가능
			sum += inputNum-- ; // 증감식과 합체
		
		System.out.printf("1부터 %d까지의 합 : %d", tem, sum);
		
	}
	
	public void test2(){
		
		//12345
		int i = 1;
		
		while(i <= 5) {
			System.out.print(i + " ");
			i++;
		}
		System.out.println();//개행
		
		//54321
		while(i > 1) {
			i--;
			System.out.print(i + " ");
			
		}
		System.out.println();//개행
		
		// 1 3 5 7 9 11 13 15 17 19
		i = 1;
		
		while(i < 20) {
			System.out.print(i + " ");
			i += 2;
		}
		System.out.println();//개행
				
		// 2 4 6 8 10 12 14 16 18 20
		i = 1;
		while(i <= 10) {
			System.out.print((i * 2) + " ");
			i ++;
		}
		System.out.println();//개행
		
		// 구구단 7단	
		final int DAN = 7;
		i = 1;
		
		System.out.printf("====%d단====%n",DAN);
		
		while(i < 10) {
			System.out.printf("%d x %d = %d%n",DAN, i, i * DAN);
			i++;
		}
	}
	/**
	 * 1. 초기식
	 * while(2. 조건식){
	 *	  	 3. 실행코드
	 *		 4. 증감식
	 *
	 *  순서 : 1 2 3 4 2 3 4 2 3 4 2
	 * }
	 */
	public void test1() {
		int i = 0; //초기식
		
		while(i < 3) { //조건식
			i++; //증감식
			System.out.println("Hello world " + i); //실행코드
		}
		
		System.out.println(i);
	}

}
