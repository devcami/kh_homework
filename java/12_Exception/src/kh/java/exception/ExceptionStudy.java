package kh.java.exception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Exception
 *  - 프로그램 오류 중 적절한 코드에 의해서 정상적인 처리 흐름으로 수습가능한 미약한 오류.
 *  
 *  처리방법
 *  - 1. 예외처리 try~catch
 *  - 2. 예외던지기 throws
 *
 * 예외의 종류
 *  - 1. Unchecked Exception 예외처리 강제화 없음 , RuntimeException 후손클래스 모두.
 *  - 2. Checked Exception 예외처리 강제화 , RuntimeException 후손 외 모두.
 */
public class ExceptionStudy {
		
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ExceptionStudy study = new ExceptionStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
		System.out.println("----프로그램 정상 종료----");
	}
	
	/**
	 * 	try... catch 블럭
	 * 	변수 유효범위
	 * 	try따로 catch따로 finally따로
	 */
	private void test5() {
		int a = 0;
		try {
//			int a = 10;
			a = 10;
		} catch(Exception e) {
			System.out.println(a);
		} finally {
			System.out.println(a);
		}
		System.out.println(a);
	}

	/**
	 * 사용자로부터 정수 2개를 입력받아 합을 출력
	 * 예외가 발생할 수 있는 상황을 고려해 예외처리 구문을 작성하시오.
	 */
	private void test4() {
		
		int a = 0;
		int b = 0;
		while(true) {
			try {
				System.out.print("첫번째 정수 입력 : ");
				a = sc.nextInt();
				System.out.print("두번째 정수 입력 : ");
				b = sc.nextInt();

				break;
			} catch(Exception e) {
				System.out.println("정수만 입력하실 수 있습니다!");
				System.out.println(e);
				sc.next(); // 버퍼비우기용 > 정수로 변할 수 없는 입력값 비우기
			}
		}
		System.out.println("a + b = " + (a + b));
	}

	/**
	 * catch절 작성순서
	 * 	- 상속관계가 없을때는 순서 상관없다.
	 *  - 부모/자식클래스 catch블럭을 모두 작성해야하는 경우 : 자식 -> 부모 순서로 작성해야한다.
	 */
	private void test3() {
		try {
			//예외 1 : ArithmeticException
			System.out.println(100 / 0);
			
			//예외 2 : NullPointerException
			String s = null;
			System.out.println(s.hashCode());
			
			//예외 3 : ArrayIndexOutOfBoundsException
			int[] arr = new int[3];
			System.out.println(arr[100]);
//		} catch(ArithmeticException e) {
//			System.out.println("ArithmeticException!");
//		} catch(NullPointerException e) {
//			System.out.println("NullPointerException!");
//		} catch(ArrayIndexOutOfBoundsException e) {
//			System.out.println("ArrayIndexOutOfBoundsException!");
//		} catch(RuntimeException e) {
//			System.out.println("RuntimeException!");
//			System.out.println(e);
		} catch(Exception e) {
			System.out.println("Exception!");
			System.out.println(e);
		}
	}

	/**
	 * try...catch 흐름
	 * 
	 * 
	 * finally 블럭
	 *  - 예외가 발생하든 안하든 무조건 실행되는 블럭
	 *  - try에서 사용한 자원을 반납하는 코드등을 작성
	 */
	private void test2() {
		System.out.println(1);
		try {
			System.out.println(2);
			
			System.out.println(100 / 10); //ArithmeticException 유발코드
			
			System.out.println(3); //실행X 바로 catch로 
		} catch (ArithmeticException e) {
			// 예외 객체가 던져진다. (e)
//			System.out.println(e);
//			System.out.println(e.getMessage());
//			
//			// stack trace
//			e.printStackTrace();
			
			System.out.println(4);
		} finally {
			System.out.println(5);
		}
		System.out.println(6);
	}

	/**
	 * try...catch 예외처리
	 *  - try : 예외가 발생할 수 있는 구문 작성
	 *  - catch : 예외가 발생했을 때 처리할 구문 작성
	 */
	public void test1() {
		while(true){
			try {
				String s = null;
				if(new Random().nextBoolean())
					s = "hello";
				System.out.println(s.length());

				System.out.print("정수1 입력 : ");
				int a = sc.nextInt();
				System.out.print("정수2 입력 : ");
				int b = sc.nextInt();
				System.out.printf("%d / %d => %d%n", a, b, a/b);
				break;
				//분모에 0이 입력되었을 때 >> java.lang.ArithmeticException: / by zero 
				//RuntimeException
			} catch(ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			} catch(InputMismatchException e) {
				System.out.println("숫자만 입력하세요.");
				sc.next();
			} catch(NullPointerException e) {
				System.out.println("NPE가 발생했습니다.");
				break;
			}
			System.out.println("반복문 끝!");
		}
	} 

}
