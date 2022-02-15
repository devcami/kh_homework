package kh.java.polymorphism.animal;

public class Lion extends Animal {

	public void kick() {
		System.out.println("라이언 킥을 날렸습니다.");
	}
	
	@Override
	public void say() {
		System.out.println("안녕하세요. 라이언입니다.");
	}
	
	@Override
	public void attack() {
		kick();
	}
}
