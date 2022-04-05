package kh.java.object.array.student;

import java.util.Scanner;

/**
 * 	학생 객체배열 관리
 * 	Student[]
 * 
 * 	- has a 포함관계
 * 	- 클래스가 멤버변수(field)로 다른 클래스를 참조하는 경우
 * 	- UML상 : 연관관계(Assciation) (실선)
 * 		StudentManager -----(실선임)-----> Student
 * 		UML상에서 Student가 Student인지 Student[]인지는 알 수 없다.
 * 
 */
public class StudentManager {
	// Has a 포함관계 
	// StudentManager has a Student.
	// Student Manager가 field로 다른 class를 가지고 있다.
	private Scanner sc = new Scanner(System.in);
	private static final int LENGTH = 3;
	private Student[] students = new Student[LENGTH];
	int index = 0;
	
	
	public void menu() {
		String menu = "---학생관리---\n"
					+ "1. 학생정보 입력\n"
					+ "2. 학생정보 출력\n"
					+ "0. 종료\n"
					+ "------------\n"
					+ "번호 입력 > ";
				
		while(true) {
			System.out.print(menu);
			String select = sc.next();
			
			switch(select) {
			case "1" : inputData(); break;
			case "2" : printData(); break;
			case "0" : System.out.println("프로그램을 종료합니다."); return;
			default : System.out.println("번호를 잘못 입력하셨습니다."); break;
			}
			
			
		}
	}
	

	public void inputData() {
		if(index == LENGTH) 
			System.out.println(">>> 공간이 부족합니다 ! ! !");
		
		else{
			while(true) {
				System.out.println("----- 학생" + (index + 1) + " -----");
				System.out.print("학생번호 : ");
				int studentNo = sc.nextInt();
				System.out.print("학생이름 : ");
				String studentName = sc.next();
				System.out.print("자바점수 : ");
				int javaScore = sc.nextInt();
				
				students[index++] = new Student(studentNo, studentName, javaScore);

				if(index < LENGTH) {
					System.out.print("추가 입력 하시겠습니까 ? ( y / n ) >> ");
					char yn = sc.next().charAt(0);
					if(yn == 'n')
						break;
				}
				else 
					break;
			}
			System.out.println(">> 입력 완료 ! ! !");
		}
	}

	public void printData() {
		for(int i = 0; i < index; i++) {
			System.out.println(students[i].getStudentInfo());
		}
	}

}
