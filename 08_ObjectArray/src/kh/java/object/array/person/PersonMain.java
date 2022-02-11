package kh.java.object.array.person;

import java.util.Scanner;

public class PersonMain {

	public static void main(String[] args) {
		PersonMain main = new PersonMain();
//		main.test1();
//		main.test2();
//		main.test3();
		main.test4();
	}
	
	/**
	 *  관리자 클래스를 생성해서 Person배열 입출력 관리하기~
	 *  
	 */
	public void test4() {
		PersonManager pm = new PersonManager();
		pm.inputPerson();
		pm.printPerson();
	}
	
	/**
	 * 사용자 입력값으로 VO객체 세팅하기
	 *  - 3명의 인물정보를 사용자로부터 받아서 관리하기
	 */
	public void test3() {
		final int LENGTH = 3;
		Scanner sc = new Scanner(System.in);
		Person[] persons = new Person[LENGTH];
		
		System.out.println(LENGTH + "명의 인물정보를 입력하세요 ...");
		
		
		for(int i = 0; i < persons.length; i++) {
			System.out.println("----- 인물 " + (i + 1)+ "-----");
			
			System.out.print("이름 : ");
			String name = sc.next();
			System.out.print("나이 : ");
			int age = sc.nextInt();
			
			Person p = new Person(name, age);//person 객체생성
			persons[i] = p; // Person객체배열을 해당 인덱스에 할당
		}
		System.out.println("> 입력완료 !!!");
		
		for(Person p : persons) {
			System.out.println(p.getPersonInfo());
		}
	}
	
	/**
	 * 객체 배열 초기화
	 */
	public void test2() {
//		int[] arr = {1,2,3}; 
//		참조변수 선언, 배열 할당, 인덱스별 값대입 (한방에)
		Person[] personArr = {
				new Person("홍길동",33),
				new Person("신사임당",48),
				new Person("주몽",48)
		};
		
		//for each문 출력
		for(Person p : personArr) {
			System.out.println(p.getPersonInfo());
		}
	}
	
	/**
	 * Person객체 관리
	 */
	public void test1() {
		//1. 기본생성자 + setter
		Person p1 = new Person();
		p1.setName("홍길동");
		p1.setAge(33);
		System.out.println(p1.getPersonInfo());
		
		//2. 필드생성자
		Person p2 = new Person("신사임당",48);
		System.out.println(p2.getPersonInfo());
		
		// 객체배열 : 객체 여러개를 묶어서 인덱스를 통해 관리
		Person[] persons; //선언
		persons = new Person[5]; //할당
		
		//null (참조형 Person[]의 인덱스별 Person의 기본값)
//		for(int i = 0; i < persons.length; i++) {
//			System.out.println(i + " : " +persons[i]);
//		}
		
		// 인덱스별 요소 = Person객체 할당
		persons[0] = new Person("세종대왕", 65);
		persons[1] = new Person("유관순", 16);
		persons[2] = new Person("윤봉길", 31);
		persons[3] = p1;
		persons[4] = p2;
		
		// 객체마다 다 다른 주소값을 참조하고 있다.
		for(int i = 0; i < persons.length; i++) {
			Person p = persons[i];
			
			System.out.println(i + " : " + p.getPersonInfo());
		}
	}

}
