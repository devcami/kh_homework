package kh.java.thread;

public class SleepThread implements Runnable {
	/**
	 * 1번 출력, 0.5초 휴식
	 */
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.print('-');
			try {
				Thread.sleep(500); //millisecond 1000 : 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}



}
