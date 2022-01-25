package kh.java.condition;

import java.util.Scanner;

public class IfStudy {
	
	/**
	 * 조건문
	 * 
	 * 1. if(조건식){}
	 * 2. if(조건식){} else {}
	 * 3. if(조건식1){} else if{조건식2}.. (else{})
	 * 
	 */
	
	public static void main(String[] args) {
		IfStudy study = new IfStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
		study.test6();
		
	}
	/**
	 * 중첩된 if문
	 *  - nested if문
	 */
	public void test6() {
		int n = 100;
		String grade = "F"; 

		if(n >= 90) {
			grade = "A";
			
			if(n >= 95) {
				grade += "+"; //grade = grade + "+"
			}
		}
		else if (n >= 80) {
			grade = "B";
			
			if(n >= 85) {
				grade += "+";
			}
		}
		else if (n >= 70) {
			grade = "C";
			
			if(n >= 75) {
				grade += "+";
			}
		}
		else if (n >= 60) {
			grade = "D";
			
			if(n >= 65) {
				grade += "+";
			}
		}
		System.out.printf("점수 : %d, 학점 : %s%n", n, grade);
	}
		
	/**
	 * - multiple if 블럭
	 */
	
	public void test5() {
		int n = 100;
		char grade = 'F';
		
		if (n >= 90) {
			grade = 'A';
		}
		
		if (n >= 80 && n < 90) {
			grade = 'B';
		}
		
		if (n >= 70 && n <80) {
			grade = 'C';
		}
		
		if (n >= 60 && n <70) {
			grade = 'D';
		}
		//test3의 내용을 복사하여 else를 다 지워보았다 > 100, D가 나온다
		//모든 if문을 지나가게됨 (F > A > B > C > D) 그래서 맨 마지막 if문을 실행하여 D가 출력
		// -> &&을 사용하여 정확한 범위를 정해주면 된다.
		System.out.printf("점수 : %d, 학점 : %c%n", n, grade);
		
	}
	
	/**
	 * 나이를 입력받고, 연령대를 출력하시오
	 * - 70~ 노인
	 * - 40~ 중년
	 * - 20~ 젊은이
	 * - 14~ 청소년
	 * - 어린이
	 */
	public void test4() {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		String strAge = " ";
		
		if(age >= 70) {
			strAge = "노인";
		}
		else if(age >= 40) {
			strAge = "중년";
		}
		else if(age >= 20) {
			strAge = "젊은이";
		}
		else if(age >= 14) {
			strAge = "청소년";
		}
		else{
			strAge = "어린이";
		}
		
		System.out.printf("나이 : %d, %s입니다.", age, strAge);
	}
	/**
	 * if(조건식1){ 1 } else if (조건식2){ 2 } ...
	 *  - 조건식 1이 참인 경우, 1 블럭 실행
	 *  - 조건식 1이 거짓인 경우,
	 *  	- 조건식 2가 참인 경우, 2 블럭 실행 
	 *  	- 조건식 2가 거짓인 경우,
	 *  		- 조건식 3이 참인 경우, ... 
	 *  		- 갯수 제한이 없다.
	 *  
	 *  true 가 나오면 해당 블럭의 실행구문을 실행하고 
	 *  나머지 조건문은 검사하지 않고 if구문 전체를 빠져나온다. 
	 *  
	 *  ex) 
	 *  A : 90 ~ 100
	 *  B : 80 ~ 89
	 *  C : 70 ~ 79
	 *  D : 60 ~ 69
	 *  F : 60미만
	 */
	public void test3() {
		int n = 100;
		char grade = ' '; //char의 기본값 ,int 0 double 0.0 boolean false 
		
		if(n >= 90) {
			grade = 'A';
			// 만약 char를 선언 안하고 여기서 한다면?
			// char grade = 'A';
			// 안됨 > 이 if블럭 안에서만 char이기 때문
			// 변수는 그 블럭 안에 선언되어 그 안에서 작동한다.
		}
		else if (n >= 80) {
			grade = 'B';
		}
		else if (n >= 70) {
			grade = 'C';
		}
		else if (n >= 60) {
			grade = 'D';
		}
		else {
			grade = 'F';
		}
		System.out.printf("점수 : %d, 학점 : %c%n", n, grade);
	}
	
	
	/**
	 * if(){} else {}
	 *  - 참인 경우, if블럭 실행
	 *  - 거짓인 경우, else블럭 실행
	 */
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		
		if((n % 2) == 1) {
			System.out.println("홀수");
		}
		else {
			System.out.println("짝수");
		}
		System.out.println("TEST2 끝");	
	}
	
	/**
	 * if(조건식){}
	 *  - 참인 경우, if블럭 실행
	 *  - 거짓인 경우, 그냥 통과한다.
	 */
	public void test1() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int n = sc.nextInt();
		if(n > 0) {
			System.out.println("참참참!");
		}
		System.out.println("TEST1 끝");
		
	}
	
	

}
