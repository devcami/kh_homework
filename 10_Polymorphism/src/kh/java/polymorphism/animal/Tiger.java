package kh.java.polymorphism.animal;

public class Tiger extends Animal {

	public void punch() {
		System.out.println("호랑이 펀치를 날렸습니다.");
	}
	
	@Override
	public void say() {
		System.out.println("안녕하세요. 타이거입니다.");
	}
	
	@Override
	public void attack() {
		punch();
	}
}
