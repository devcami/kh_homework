package kh.java.oop.field;

/**
 * 변수
 * a. 전역변수 (global variable | field) : 클래스영역에 선언된 변수, 접근제한자 사용 가능
 * 		1. static field : 클래스변수 - 클래스별로 지정해서 객체간 공유
 * 		2. non - static field : 멤버변수 | 인스턴스변수 - 객체별로 지정해서 따로 관리
 * b. 지역변수 (local variable): 메소드영역에 선언된 변수, 접근제한자 사용 불가
 * 		- 매개변수도 지역변수다.
 *
 * 변수별 생명주기
 * 1. 클래스변수	: 프로그램 시작 (프로그램에서 최초 사용 시 - 동적로딩)~ 프로그램 종료
 * 2. 인스턴스변수	: 객체 생성(new연산자 사용 시) ~ 
 * 					객체 소멸(참조가 끊어졌을 때 - null /garbage collector에 의해 반환될 때)
 * 3. 지역변수		: 메소드 호출 시 생성되어 메소드 반환 시 소멸
 * 
 */
public class IPhone13 {
	
	//static field (객체마다 공통적인 특성) 
	//직접 접근이 가능하기 때문에 getter/setter를 쓰지않음
	public static final int WIDTH = 5; //너비
	public static final int HEIGHT = 15; //높이
	
	//non-static field , 캡슐화 (객체마다 다른 특성)
	private String owner;
	private String number;
	
	//private field 사용을 위해 setter/getter 만듦
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwner() {
		return owner;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}
	
	public void printInfo() {
		System.out.printf("%s님의 전화기 : %s%n", owner, number);
	}
	
	/**
	 * this -> p
	 * 
	 * p의 타입 : 같은 IPhone13 클래스이므로 private필드에도 직접 접근할 수 있다.
	 * @param p
	 */
	public void callTo(IPhone13 p) {
		System.out.printf("%s(%s)님이 %s(%s)님으로 전화를 겁니다...", 
							this.owner, this.number, 
							p.owner, p.number);
							//private field에 바로 접근이 가능하기 때문에 get안써도 됨
	}
	
}
