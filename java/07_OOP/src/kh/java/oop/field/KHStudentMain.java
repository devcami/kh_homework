package kh.java.oop.field;

public class KHStudentMain {

	public static void main(String[] args) {
		// kh정보교육원 학생 2명 생성 후 각각 출력
		// student1
		KHStudent student1 = new KHStudent();
		student1.SetName("홍길동");
		student1.SetNumber("01012341234");
		student1.printKHStudent();
		
		// student1
		KHStudent student2 = new KHStudent();
		student2.SetName("신사임당");
		student2.SetNumber("01022223333");
		student2.printKHStudent();
		
	
	}

}
