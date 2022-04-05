package kh.java.collections.generic;

/**
 * 제네릭 타입변수
 * - T : type
 * - E : element
 * - K : Key
 * - V : value
 * 
 * @param <T>
 */
public class Box<T> {
	
	private T elem; //T타입 요소 elem
	
	public void setElem(T elem) {
		this.elem = elem;
	}
	public T getElem() {
		return elem;
	}
	/**
	 * static자원(field,method)에는 class레벨의 Generic 타입변수를 사용할 수 없다.
	 * - 프로그램 시작 시 static member는 이미 타입이 정해짐.
	 * - 객체 생성 전 타입변수의 타입을 지정할 수 없기 때문이다.
	 * 
	 * Generic method로 처리하면 가능 (static method는 generic method만 사용가능)
	 *  - 리턴타입 앞에 타입 변수 선언 <T> Box<T> 
	 *  - 클래스레벨의 타입변수 T와 다른 지역타입변수 (메소드 안에서만 사용 가능)
	 *  
	 *  
	 * 요소를 인자로 받아서 Box객체를 생성, 필드 설정 후 리턴
	 */
	public static <T> Box<T> getBoxInstance(T elem){
		Box<T> box = new Box<>();
		box.setElem(elem);
		return box;
	}
	@Override
	public String toString() {
		return "Box [elem=" + elem + "]";
	}
	
}
