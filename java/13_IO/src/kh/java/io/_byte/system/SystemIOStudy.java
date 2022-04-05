package kh.java.io._byte.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemIOStudy {

	public static void main(String[] args) {
		SystemIOStudy study = new SystemIOStudy();
//		study.test1();
//		study.test2();
		study.test3();
		System.out.println("--- 정상종료 ---");
	}
	
	/**
	 * 사용자로부터 정수를 여러개 입력받고, 입력받은 정수의 합을 출력하세요.
	 *  - Scanner X , System.in과 BufferedReader 사용하기
	 */
	private void test3() {
		//3줄 하나로 합치기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("정수 입력 (exit 입력시 종료): ");

		String input = null;
		int sum = 0;
		
		//이중 try구문
		try {
			while((input = br.readLine()) != null) {
				if("exit".equals(input)) break;
				System.out.print(input + " + ");
				try {
					sum += Integer.parseInt(input);
				} catch(NumberFormatException e) {
					System.out.println("정수만 입력하세요");
				}
			}
			System.out.println("총합 = " + sum);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * System.in 주스트림(표준입력) - byte기반(InputStream)
	 * bridge - InputStreamReader
	 * BufferedReader 보조스트림 사용(줄단위로 읽어오는 메소드 readLine) - 문자기반
	 * 
	 * - 대상과 연결된 주스트림객체를 보조스트림 객체에 전달하고,
	 * - 보조스트림을 통해 제어한다.
	 * 
	 * 사용자 입력값을 개행문자 단위로 읽어온 후 개행문자를 버리고 리턴
	 */
	private void test2() {
		InputStream systemIn = System.in;
		InputStreamReader isr = new InputStreamReader(systemIn);
		BufferedReader br = new BufferedReader(isr);
		
		String input = null;
		try {
			System.out.println("아무말 입력 : ");
			while((input = br.readLine()) != null) {
				if("exit".equals(input))
					break;
				System.out.println(input);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 대상 : 키보드,콘솔
	 *  표준입력 - 사용자 키보드입력 	System.in (InputStream - FileInputStream)
	 *  		 -> Scanner (jdk 1.5)를 사용해서 예외처리 없이 사용 가능
	 *  		 -> BufferedReder (1.5 이전)를 이용해 처리
	 *  표준출력 - Console 출력		System.out
	 *  
	 *  스트림객체는 자원 사용 후 반드시 반납해야함.
	 *  다만, 표준 입출력은 반납하면 안된다 . (한번 반납하면 재사용 불가)
	 */
	private void test1() {
		int input = 0;
		try {
			System.out.println("키보드로 값을 입력하세요 : ");
			while((input = System.in.read()) != -1) {
				System.out.println(input);
			}
		} catch(IOException e) {
			e.printStackTrace(); // 예외 로그(기록)
		}
	
	}

}
