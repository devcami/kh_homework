package com.thread.alphabet;

public class AlphabetTest {

	public static void main(String[] args) {
		AlphabetTest test = new AlphabetTest();
		test.test1();
		
		System.out.println("[" + Thread.currentThread().getName() + "종료]");
	}

	private void test1() {
		
		new Thread(new UpperAlphabetThread(),"대문자").start();
		new Thread(new LowerAlphabetThread(),"소문자").start();
	}

}
