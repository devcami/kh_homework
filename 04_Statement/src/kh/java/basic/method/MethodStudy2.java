package kh.java.basic.method;

import java.util.Scanner;

public class MethodStudy2 {
	public static void main(String[] args) {
		MethodStudy2 study = new MethodStudy2();
		study.test1();
		
	}
	/**
	 * 정수값 3개를 받아서 그 정수 3개를 더하는 프로그램
	 * method를 호출해서 값 가져오기
	 * 
	 */
	public void test1() {
		int n1 = inputNum(1);
		int n2 = inputNum(2);
		int n3 = inputNum(3);
		
		System.out.printf("%d + %d + %d = %d%n", n1, n2, n3, (n1 + n2 + n3));
	}
	public int inputNum(int i) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%d번째 정수 입력 : ",i);
		int n = sc.nextInt();
		return n;
	}

}
