package kh.java.polymorphism.animal;

public class Bear extends Animal {

	/**
	 * 메소드 재작성 (Method Overriding, Method Implementation)
	 * 
	 */
	@Override
	public void say() {
		System.out.println("안녕하세요. 곰입니다.");
	}

	@Override
	public void attack() {
		tear();
	}
	
	public void tear() {
		System.out.println("곰은 사람을 찢어");
	}

	@Override
	public void run() {
		System.out.println("곰이 " + LEG_NUM + "발로 달립니다.");		
	}

	@Override
	public String getSound() {
		return "우르~";
	}

	
}
