package member.model.vo;

public abstract class Member implements Buyable {
	
	private String name;
	private String grade;
	private int point;
	
	public Member() {
		super();
	}

	public Member(String name, String grade, int point) {
		super();
		this.name = name;
		this.grade = grade;
		this.point = point;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	public abstract double getEjaPoint();
	
	public String getMemberInfo() {
		return name + "\t" + grade + "\t" + "\t" + point + "\t";
	}
	
	public String getBuyInfo(int price) {
		return grade + "등급회원 " + name + "은/는 " + price + "원 상품을 ";
	}
	
	
}
