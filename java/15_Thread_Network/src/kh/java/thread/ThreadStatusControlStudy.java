package kh.java.thread;

import java.util.Scanner;

/**
 * 
 * Thread 상태제어
 * 
 * - 실행/실행대기 : RUNNABLE
 * - 일시정지 : WAITING, TIMED-WAITING, BLOCKED
 *
 */
public class ThreadStatusControlStudy {

	public static void main(String[] args) {
		ThreadStatusControlStudy study = new ThreadStatusControlStudy();
//		study.test1();
//		study.test2();
		study.test3();
//		study.test4();
//		study.test5();
		
		System.out.println("[" + Thread.currentThread().getName() + " 종료 !]");
	}
	
	/**
	 * interrupt
	 * - 특정 쓰레드 종료
	 */
	private void test5() {
		Thread th = new Thread(new CountDownThread(),"카운트다운");
		th.start();
		System.out.println("엔터 입력시 카운트다운 종료!");
		new Scanner(System.in).nextLine();
		th.interrupt(); //특정쓰레드 종료
	}

	/**
	 * join
	 * - 특정 쓰레드 종료시 or 지정한 시간까지 기다린다.
	 */
	private void test4() {
		Thread th = new Thread(new CountDownThread(),"카운트다운");
		th.start();
		
		//메인쓰레드가 카운트다운 쓰레드에 조인
		try {
			//현재쓰레드가(main)가 th쓰레드에 join
//			th.join(); //이 라인에서 main은 대기상태였다가 카운트다운이 종료되면 main종료
			th.join(3000); //3초만 기다렸다가 main은 종료
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 대몬쓰레드 daemon thread
	 * - 백그라운드 쓰레드
	 * - 일반 쓰레드가 종료하면 따라서 종료
	 */
	private void test3() {
		Thread th = new Thread(new CountDownThread(),"카운트다운");
		th.setDaemon(true);
		th.start();
		System.out.println("엔터 입력 시 카운트다운 종료 !!!");
		
		new Scanner(System.in).nextLine();
	}


	/**
	 * 구구단 쓰레드
	 * - 사용자 입력값 (2~9)
	 * - 구구단을 출력(쓰레드) : 각 수는 0.7초 간격으로 출력
	 */
	private void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		System.out.print("몇초 간격으로 출력할까요? : ");
		double sec = sc.nextDouble(); //0.1초, 3초, 10초 ..
		
		new Thread(new GuguDan(dan, sec)).start();
	}

	/**
	 * sleep
	 * (TIMED-WAITING - RUNNABLE)반복
	 */
	private void test1() {
		//new Thread(Runnable)
		Thread th = new Thread(new SleepThread());
		th.start();
	}

}
