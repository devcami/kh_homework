package kh.java.oop.account;

/**
 * 
 * 캡슐화
 * 	- 필드의 접근제한자를 private처리
 *  - 필드를 제어하는 메소드를 public으로 지정
 *  - 필드 + 메소드를 묶어 클래스로 지정 . 관리
 *
 */
public class Account {
	
	private String name;
	private long balance; //잔액
	
	// setter
	// 변수명이 같은 경우 가까운 유효범위에 선언된 변수를 사용한다
	public void setName(String _name) {
		name = _name;
	}
	public void setBalance(long _balance) {
		balance = _balance;
	}
	
	// getter
	// 객체 안에 해당 필드값을 가져오는 것
	public String getName() {
		return name;
	}
	public long getBalance() {
		return balance;
	}
	
	/**
	 * 입금 메소드
	 * - 유효한 금액인지 확인
	 * - 입금액 만큼 더하기 연산을 통한 입금처리
	 */
	public void deposit(long money) {
		if(money > 0) {
			balance += money;
			System.out.println("입금처리 되었습니다.");
		}
		else {
			System.err.println("잘못된 금액이 입력되었습니다.");
		}
			
	}
	/**
	 * 출금 메소드
	 * - 유효한 금액인지 확인 (음수, 계좌보다 많은 금액 입력 시 오류)
	 * - 정확히 마이너스 연산을 통한 출금처리
	 */
	public void withdraw(long money) {
		if(money <= 0) {
			System.err.println("유효한 금액을 입력하세요.");
			return;
		}
		else if(money > balance) {
			System.err.println("출금액이 잔액보다 많습니다.");
			return;
		}
		else {
			balance -= money;
			System.out.println("출금처리 되었습니다.");
		}
			
	}
	
}
