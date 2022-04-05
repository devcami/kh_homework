package kh.java.polymorphism.animal;

/**
 * 인터페이스
 *  - 인터페이스도 하나의 클래스
 *  - 컴파일된 결과는 동일하게 .class임
 *  - 일반필드/ 메소드를 가질 수 없다. -> 객체를 생성할 수 없다. new Runnable() X
 *  - 상수/추상메소드만 가질 수 있다. (무조건 상수, 추상메소드로 만든다)
 * 	- JDK8부터 default, static method를 사용할 수 있다. (규격이 필요없는 메소드)
 * 		- default method : 일반메소드처럼 사용가능. 자식객체에서 호출가능
 * 		- static method 
 * 
 *  - 자식클래스 (구현클래스) 에서는 implements키워드를 사용한다.
 *  - 다중 구현을 지원한다.
 */
public interface Runnable {

	// 상수
	// public static final 생략가능
	int LEG_NUM = 4;
	
	// 추상메소드
	// public abstract 생략 가능 
	void run();
	
	/**
	 *  인터페이스의 default메소드
	 *  - 인터페이스의 일반 메소드(Override 강제X)
	 */
	public default void walk() {
		System.out.println("뛰는 자는 걸을 수도 있지~");
	}
	
	/**
	 *  인터페이스의 static메소드
	 *  - 일반 static메소드와 동일
	 */
	public static void warmup() {
		System.out.println("뛰기 전에 몸을 풉니다~");
	}
}
