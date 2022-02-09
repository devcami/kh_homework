package kh.java.oop.field;

/**
 * KH정보교육원 학생정보 관리
 * 
 * - 교육원이름
 * - 학생이름
 * - 전화번호
 * 
 * printKHStudent 출력method
 *  예) KH정보교육원 - 홍길동(01012341234)
 *
 */
public class KHStudent {
	
	public static final String ACADEMY_NAME = "KH정보교육원";
	private String name;
	private String number;
	
	public void printKHStudent() {
		System.out.printf("%s - %s(%s)%n"
				 		,ACADEMY_NAME, name, number);
	}
	
	public void SetName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void SetNumber(String number) {
		this.number = number;
	}
	public String getNumber() {
		return number;
	}

}
