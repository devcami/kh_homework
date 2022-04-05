package exception;

public class AccountTest {
	public static void main(String[] args) {
		//account 객체 생성
		Account account = new Account("441-0290-1203", 500000, 7.3);
		
		//account 기본 정보 출력
		System.out.printf("계좌정보 : %s %.1f %.1f%n", account.getAccount(), account.getBalance(), account.getInterestRate());
		
		//account에 -10원 입금 Exception처리
		try {
			account.deposit(-10);
		}catch(Exception e){
			System.out.println("입금 금액이 0보다 적습니다.");
		}
		
		//account에 600000원 출금 Exception처리
		try {
			account.withdraw(600000);
		}catch(Exception e) {
			System.out.println("금액이 0보다 적거나 현재 잔액보다 많습니다.");
		}
		
		//이자출력 - 현재 잔고를 기준으로 고객에게 줄 이자 금액을 출력
		System.out.println(account.calculateInterest());
	}

}
