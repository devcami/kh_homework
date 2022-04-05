package kh.java.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ThrowExceptionStudy {

	Scanner sc = new Scanner(System.in);
	/**
	 *  main 메소드에서 throws 사용은 예외처리를 안하는 것과 같음 
	 *  - 예외발생시 비정상종료
	 */
	public static void main(String[] args) {
		ThrowExceptionStudy study = new ThrowExceptionStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
		System.out.println("----- 프로그램 정상 종료 -----");
	}
	
	/**
	 * 1. 예외처리
	 * 2. 예외던지기
	 * 
	 *  - checked 예외는 예외처리(간단한 선처리)후에 예외를 다시 던진다.
	 *  - 프로그램 흐름을 분기(예외처리의 책임)할 수 있는 메소드까지 던진다. 
	 *  	--> 그렇지 않으면 어디서 예외가 발생했는지 알수가없음
	 */
	private void test4() {
		// 프로그램의 처리를 분기하는 곳일 경우
		try{
			a();
			normalFlow();
		} catch(Exception e) {
			errorFlow();
		}
	}
	public void normalFlow() {
		System.out.println("정상흐름");
	}
	public void errorFlow() {
		System.out.println("오류가 발생했을 경우 흐름");
	}
	
	// method 호출부에 예외처리 책임을 전가
	public void a() throws FileNotFoundException {
		System.out.println("---- a 시작 ----");
		b();
		System.out.println("---- a 끝 ----");
	}
	
	// method 호출부에 예외처리 책임을 전가
	public void b() throws FileNotFoundException {
		System.out.println("---- b 시작 ----");
		try{
			FileReader fr = new FileReader("non-exist.txt");
		} catch (Exception e) {
			System.out.println("선처리!");
			throw e; //예외 다시 던지기 -> 프로그램 흐름을 분기할 수 있는 곳까지 던져야한다.
		}
		System.out.println("---- b 끝 ----");
	}

	/**
	 * Checked Exception - RuntimeException 후손클래스 외, 예외처리 강제화
	 * Unchecked Exception - RuntimeException의 후손클래스, 예외처리 강제화하지 않는다. (여태까지한것들)
	 */
	private void test3() {
		// 해당 경로의 파일을 읽어내는 객체
		// FileNotFoundException은 Checked예외 : 예외처리를 만드시 해야한다.
		try {
			FileReader fr = new FileReader("helloworld.txt");
			System.out.println("helloworld.txt 파일이 존재합니다.");
		} catch(FileNotFoundException e) {
			//파일이 존재하지 않을 경우 후처리 코드
			e.printStackTrace();
			//java.io.FileNotFoundException: helloworld.txt (No such file or directory)
		}
	}
	/**
	 * exception을 통한 분기처리
	 */
	private void test2() {
		try {
			checkAge2(); //사용자 나이 검사
			startGame();
		} catch(Exception e) {
			e.printStackTrace(); // 확인용 (사용자 노출되지 않는다고 가정)
			System.out.println("\n게임을 즐길 수 있는 적정연령이 아닙니다. 종료합니다.");
		}
	}
	/**
	 *  나이 검사 후 20세 미만이면 예외를 던지는 메소드
	 *  - 현재 메소드를 호출한 쪽에 예외를 던지게된다. >> test2의 try블록 안으로 예외를 던지게됨
	 *  
	 *  커스텀 예외클래스
	 *  - 현재 오류상황을 잘 설명할 수 있는 예외클래스를 작성할 것 !
	 *  - UnderAgeException 
	 */
	public void checkAge2() {
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		if(age < 20)
			throw new UnderAgeException("미성년자 : " + age); //()사이에 문자열 : 예외 메세지
	}
	/**
	 * if...else를 통한 분기처리
	 */
	private void test1() {
		//나이 확인
		boolean bool = checkAge1();
		if(bool) {
			startGame();
		}
		else {
			System.out.println("게임을 즐길 수 있는 적정연령이 아닙니다. 종료합니다.");
		}
	}
	
	public boolean checkAge1() {
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		if(age >= 20)
			return true;
		else
			return false;
		
	}
	/**
	 * 성인 게임
	 */
	public void startGame() {
		System.out.println("게임시작 ...");
	}
}
