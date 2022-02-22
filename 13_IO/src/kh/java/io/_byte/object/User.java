package kh.java.io._byte.object;

import java.io.Serializable;

/**
 * 객체 입출력 할 클래스
 * 반드시 Serializable 인터페이스를 구현
 *
 */
public class User implements Serializable {
	/**
	 * serialVersionUID
	 * 직렬화된 정보와 일치하는 class인지 비교하는 고유 값 
	 * 직접 사용하지 않고 선언만 해두면됨.
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password;
	private int point;
	
	public User() {
		super();
	}
	public User(String id, String password, int point) {
		super();
		this.id = id;
		this.password = password;
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "User [id = " + id + ", password = " + password + ", point = " + point + "]";
	}
	
}
