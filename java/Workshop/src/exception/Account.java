package exception;

public class Account {
	private String account;
	private double balance;
	private double interestRate;
	
	public Account() {
		super();
		
	}
	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	public double calculateInterest() {
		//이자계산
		return balance * (interestRate * 0.01);
	}
	public void deposit(double money) throws Exception{
		//입금처리 및 예외상황 처리
		if(money > 0) {
			balance += money;
		} else {
			throw new Exception();
		}
	}
	public void withdraw(double money) throws Exception{
		//출금처리 및 예외상황 처리
		if(money > balance || money < 0) {
			throw new Exception();
		}else {
			balance -= money;
		}
	}
	
}
