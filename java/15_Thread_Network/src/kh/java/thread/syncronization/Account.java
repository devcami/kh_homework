package kh.java.thread.syncronization;

public class Account {
	
	private int balance = 1000; //잔액
	
	public int getBalance() {
		return balance;
	}

	/**
	 * 출금 method
	 * - 여러Thread에 의해 호출
	 * - 현재 balance field에서 전달된 money만큼 차감처리
	 * 
	 * 
	 * 동기화 처리
	 * - 동기화 대상은 늘 특정 객체가 된다.
	 * 1. 동기화 메소드 처리 - acc.withdraw() -> acc가 동기화 대상
	 * 		public synchronized void withdraw(int money) {}
	 * 2. 동기화 블럭 메소드 안에 생성 
	 *  	- synchronized(this){}
	 * 		- 국지적으로 지정가능
	 * 		- 성능이 좋을 수 있다 : method처리보다 범위를 더 작게 지정 가능 
	 */
	public void withdraw(int money) {
		//this 현재 객체를 동기화처리
		synchronized(this) {
			String threadName = Thread.currentThread().getName();
			System.out.printf("[%s]출금시도 %d원, 현재잔액 %d원%n",threadName, money, balance);
			if(money <= balance) {
				balance -= money;
				System.out.printf("[%s]출금성공 -> 현재잔액 %d원%n",threadName, balance);
			}
			else {
				System.out.printf("[%s]출금실패 -> 잔액부족%n",threadName);
			}
		}
	}
	
}
