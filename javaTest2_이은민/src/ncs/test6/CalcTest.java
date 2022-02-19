package ncs.test6;

import java.util.Scanner;

public class CalcTest {

	public static void main(String[] args) {
		Calculate c = new Calculate();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		
		System.out.print("연산 기호 입력 ( + - * / ) : ");
		char op = sc.next().charAt(0);
		
		System.out.print("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		switch(op) {
		case '+' :
			System.out.println("합 : " + c.sum(num1, num2));
			break;
		case '-' : 
			System.out.println("차 : " + c.subtract(num1, num2));
			break;
		case '*' :
			System.out.println("곱 : " + c.multiply(num1, num2));
			break;
		case '/' :
			System.out.println("나누기 : " + c.divide(num1, num2));
			break;
		default : 
			System.out.println("기호를 잘못 입력하셨습니다. ");
			break;
		}
	}

}
