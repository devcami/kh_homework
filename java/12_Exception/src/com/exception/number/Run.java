package com.exception.number;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Run run = new Run();
		run.test();
	}

	private void test() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("첫번째 정수 입력 : ");
			int a = sc.nextInt();
			System.out.print("두번째 정수 입력 : ");
			int b = sc.nextInt();

			NumberProcess np = new NumberProcess();
			String result = np.checkDouble(a, b) ? "의 배수이다" : "의 배수가 아니다";
			System.out.printf("%d는 %d%s", a, b, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
