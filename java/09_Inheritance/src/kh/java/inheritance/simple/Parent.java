package kh.java.inheritance.simple;

//모든 클래스는 Object의 후손클래스 (java.lang.Object)
public class Parent extends Object{
	
	String name;
	int age;
	
	public void say() {
		System.out.println("내가 애비다");
	}
	public String info() {
		return "name = " + name + ", age = " + age;
	}
}
