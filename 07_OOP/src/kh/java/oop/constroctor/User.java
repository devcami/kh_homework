package kh.java.oop.constroctor;

import java.util.Date;

/**
 * 생성자
 * 	- new 연산자와 함께 호출하는 메소드
 * 	- 객체 생성시, 필드값 초기화를 담당한다.
 * 	- return 타입 없고, 클래스명과 생성자명은 동일해야한다.
 * 	- 기본 생성자 (parameter가 없는 것) / 파라미터 생성자(생성자 오버로딩을 지원)로 구분
 * 	
 * 	- 어떠한 생성자도 만들지 않은 경우 , JVM은 기본생성자를 자동으로 생성한다.
 *	- parameter생성자를 하나라도 만들면, 기본생성자를 자동으로 생성해주지 않는다.
 *	- parameter생성자를 만들 때 기본생성자를 반.드.시 작성해둔다.
 *	
 * 기본생성자는 꼭 필요하다.
 * 	- 상속 시 자식클래스가 부모클래스의 기본생성자를 자동으로 호출
 * 	- JSP/springframework의 웹앱 만들 때 bean객체를 생성시에 기본생성자를 호출
 */
public class User {
	
	//필드
	private String id;
	private String password;
	private String name;
	private Date enrollDate;
	
	//기본 생성자 (파라미터 생성자를 만들면 기본생성자가 자동으로 생기지않아 오류가남)
	public User() {
		//객체를 만들 때 호출된다. ( new User(); 에서 )
		System.out.println("User 생성자 호출");
	}
	/**
	 * this() : 생성자this
	 * 	- 다른 생성자를 호출해서 반복된 코드를 제거 가능
	 * 	- 생성자 코드 몸통 첫줄에 딱 한번만 사용가능.
	 * 
	 */
	//파라미터 생성자
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public User(String id, String password, String name) {
		this(id,password);
		this.name = name;
	}
	public User(String id, String password, String name, Date enrollDate) {
		this(id,password,name);
		this.enrollDate = enrollDate;
	}
	
	//메소드
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	
	public String getUserInfo() {
		return "id = " + id + ", password = " + password + 
			   ", name = " + name + ", enrollDate = " + enrollDate;
	}
	
	
}
