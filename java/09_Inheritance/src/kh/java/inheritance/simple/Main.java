package kh.java.inheritance.simple;

public class Main {

	public static void main(String[] args) {
		
		Parent parent = new Parent();
		parent.name = "홍금보";
		parent.age = 50;
		parent.say();
		System.out.println(parent.info());
		
		System.out.println();
		
		Child child = new Child();
		//Parent - field
		child.name = "홍길동";
		child.age = 19;
		//Parent - method
		child.say();
		System.out.println(child.info());
		//Child - method
		child.game();
				
		System.out.println();
		
		GrandChild grandChild = new GrandChild();
		grandChild.name = "홍진경";
		grandChild.age = 3;
		grandChild.say();
		System.out.println(grandChild.info());
		grandChild.game();
		
	}

}
