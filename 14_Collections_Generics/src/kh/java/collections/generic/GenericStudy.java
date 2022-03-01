package kh.java.collections.generic;

public class GenericStudy {

	public static void main(String[] args) {
		GenericStudy study = new GenericStudy();
//		study.test1();
		study.test2();
	}
	
	/**
	 * 제네릭은 두가지 레벨로 사용 가능
	 * 1. Generic Class생성 : 클래스레벨에 타입변수 사용
	 * 2. Generic Method생성 : 메소드레벨에 타입변수 사용
	 */
	private void test2() {
		//명시적으로 지역타입변수 선언
		Box<Integer> iBox = Box.<Integer>getBoxInstance(123);
		System.out.println(iBox);
		
		//인자("ㅎㅎㅎ")를 보고 암묵적으로 지역타입변수 추론 : 명시 안해도 됨.
		Box<String> strBox = Box.getBoxInstance("ㅎㅎㅎ");
		System.out.println(strBox);
	}

	/**
	 * Generic의 Type safety(타입 안정성)
	 * - 추가할 때 해당 타입의 요소만 추가 가능.
	 * - 꺼내올 때 해당 타입을 리턴 (자동 형변환)
	 */
	private void test1() {
		Box<Integer> iBox = new Box<>();
		iBox.setElem(123);
		Integer elem = iBox.getElem();
		System.out.println(elem);
		System.out.println(iBox);
		
		Box<String> strBox = new Box<>();
		strBox.setElem("Hi");
		String strElem = strBox.getElem();
		System.out.println(strElem);
		System.out.println(strBox);
		
	}

}
