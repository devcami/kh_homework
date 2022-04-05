package kh.java.inheritance.shape;

public class Shape extends Object{
	
	//Field
	private double area; //도형의 넓이

	//Constructor
	public Shape() {
		super();
	}
	public Shape(double area) {
		super();
		this.area = area;
	}
	//getter setter
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public void draw() {
		System.out.println("도형을 그린다");
	}
	public void calcArea() {
		// 도형별로 넓이를 구해서 area field에 대입
		
	}
	/**
	 *  Object의 toString method Override
	 *  - 객체 정보(필드)를 문자열로 return
	 *  - 
	 */
	public String toString() {
		return "area = " + area;
	}
	
	
}
