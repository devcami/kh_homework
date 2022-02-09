package kh.java.oop.method;

/** 변수별 생명주기
 * 1. 클래스변수	: 프로그램 시작 (프로그램에서 최초 사용 시 - 동적로딩)~ 프로그램 종료
 * 2. 인스턴스변수	: 객체 생성(new연산자 사용 시) ~ 
 * 					객체 소멸(참조가 끊어졌을 때 - null /garbage collector에 의해 반환될 때)
 * 3. 지역변수		: 메소드 호출 시 생성되어 메소드 반환 시 소멸
 */

public class MethodSample {
	
	private int a; //멤버변수
	public static final int b = 10; //클래스변수
	
	/**
	 * non-static method : static, non-static field 둘다 참조 가능
	 */
	public void x() {
		System.out.println("a = " + a);
		System.out.println("b = " + MethodSample.b);
	}
	
	/**
	 * static method 또한 공유의 성격을 가지고 있고, 객체생성 없이 클래스명으로 직접 호출이 가능
	 * 
	 * static method : static field만 참조 가능 
	 * this 참조 없음(this 는 객체를 만들어서 사용해야 하는데 객체생성 하지 않고 사용하기 때문) 
	 */
	public static void y() {
//		System.out.println("a = " + a);
		System.out.println("b = " + MethodSample.b);
	}
}
