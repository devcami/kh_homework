package kh.java.thread;

public class GuguDan implements Runnable {
	
	int dan;
	double sec;
	long millis = 500; //기본값
	
	public GuguDan (int dan, double sec) {
		this.dan = dan;
		this.sec = sec;
		this.millis = (long)(sec * 1000);
	}
	@Override
	public void run() {
		for(int i = 1; i < 10; i++) {
			System.out.printf("%d x %d = %d%n", dan, i, dan*i);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
