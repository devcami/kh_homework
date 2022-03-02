package com.thread.sleep;

public class SleepThread implements Runnable{
	
	private String[] saying;
	
	public SleepThread(String[] saying) {
		super();
		this.saying = saying;
	}


	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			int rnd = (int)(Math.random() * 10); 
			System.out.println(saying[rnd]);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
