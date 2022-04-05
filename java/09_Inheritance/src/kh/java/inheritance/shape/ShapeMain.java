package kh.java.inheritance.shape;

public class ShapeMain {

	public static void main(String[] args) {
		
		Circle c1 = new Circle(new Point(10, 10), 50);
//		c1.calcArea();
		System.out.println(c1); //toString 자동 호출 : 객체가 문자열로 처리되어야 할 때
		c1.draw();
	}

}
