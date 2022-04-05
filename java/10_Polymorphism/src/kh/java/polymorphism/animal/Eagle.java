package kh.java.polymorphism.animal;

public class Eagle extends Animal implements Flyable{

	@Override
	public void run() {
		
	}

	@Override
	public void say() {
		System.out.println("안녕하세요. 독수리입니다.");
	}

	@Override
	public void attack() {
		tornado();
	}
	public void tornado() {
		System.out.println("독수리 토네이도 공격!");
	}
	@Override
	public void fly() {
		System.out.println("독수리가 " + WING + "날개로 날아갑니다.");
	}

	@Override
	public String getSound() {
		return "이글이글";
	}

}
