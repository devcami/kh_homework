package com.thread.alphabet;

public class UpperAlphabetThread implements Runnable {

	@Override
	public void run() {
		for(char ch = 'A'; ch <= 'Z'; ch++) {
			System.out.print(ch);
		}
		System.out.println("[" + Thread.currentThread().getName() + "종료]");
	}

}
