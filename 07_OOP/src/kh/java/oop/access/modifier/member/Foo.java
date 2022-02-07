package kh.java.oop.access.modifier.member;

/**
 *  member level 접근제한자
 *  
 *  1. public : 모든 패키지에서 접근 가능
 *  2. protected : 같은 패키지에서 접근 가능, 다른 패키지에서 상속관계는 접근 가능
 *  3. default : 같은 패키지에서 접근 가능
 *  4. private : 현재 클래스에서 접근 가능
 *
 */
public class Foo {
	
	public int a;
	protected int b;
	int c; //default 키워드는 생략함.
	private int d;

}
