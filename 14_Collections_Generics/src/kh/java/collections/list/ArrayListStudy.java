package kh.java.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ArrayListStudy {

	public static void main(String[] args) {
		ArrayListStudy study = new ArrayListStudy();
//		study.test0();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
	}
	/**
	 * List api
	 */
	private void test4() {
		List<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(25);
		list.add(77);
		list.add(77);
		list.add(77);
		list.add(100);
		
		//삭제
		Integer removed = list.remove(0);
		System.out.println(removed);
		//인덱스 77인가 요소 77인가 ?
//		list.remove(77); //인덱스
//		list.remove(Integer.valueOf(77));
		
		//중복된 요소가 있을경우 첫번째 요소만 삭제.
		boolean isRemoved = list.remove(Integer.valueOf(77));
		System.out.println(isRemoved);
		
		//요소 포함여부
		boolean contained = list.contains(100);		
		System.out.println(contained);
		
		//Integer 77 찾기
		//존재하지 않으면 index = -1
		int index = list.indexOf(77);
		System.out.println(index);
		//뒤에서 부터 조회해서 마지막 Integer 77 찾기
		index = list.lastIndexOf(77);
		System.out.println(index);
		
		//다른 list와 합치기 (같은 타입이어야 함)
		List<Integer> other = new ArrayList<>();
		other.add(9);
		other.add(99);
		//맨뒤에 병합
//		list.addAll(other);
		//중간 병합
		list.addAll(2, other);
		
		System.out.println("------------");
		
		//개별요소 확인
		//1. 일반 for문 index
		//2. for each문
		//3. Iterator객체 : 요소를 순차적으로 접근해 목록화 해주는 객체
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext()) {
			Integer i = iter.next();
			System.out.println(i);
		}

		System.out.println("------------");
		
		// clear : 모든요소 제거 
		list.clear();
		
		// isEmpty : 요소가 0개면 true 리턴
		System.out.println(list.isEmpty());
		
		//toString Override 되어있음 -> 모든 요소 확인
		System.out.println(list);
	}

	/**
	 * List<Student> 관리하기
	 */
	private void test3() {
		//학생 3명 관리
		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student(1, "홍길동"));
		listStudents.add(new Student(2, "신사임당"));
		listStudents.add(new Student(3, "세종대왕"));
		
		//학생 2명 추가
		listStudents.add(new Student(4, "이순신"));
		listStudents.add(new Student(5, "장영실"));
		
		//2번지 학생 제거
		listStudents.remove(2);
		
		//2번지에 학생 추가
		listStudents.add(2, new Student(6, "논개"));
		
		//2번지에 학생 대체
		listStudents.set(2, new Student(7, "유비"));
		
		for(int i = 0; i < listStudents.size(); i++) {
			System.out.println(i + " " + listStudents.get(i));
		}
	}



	/**
	 * Generics
	 * - 컬렉션의 요소타입을 제한하는 기능
	 * - 지정한 타입만 추가 가능할 수 있도록 한다.
	 * - 그 외 타입은 compile오류
	 * - Generic을 쓰면 getter사용 시 리턴될 타입을 한정할 수 있다.(형변환 불필요)
	 * - generics에 기본형을 가질 수 없다
	 */
	private void test2() {
		
		List<String> list = new ArrayList<String>();
		//특정한 데이터끼리 모아서 관리 (String, int, double.. 객체는 객체끼리)
		list.add("홍길동");
		list.add("신사임당");
//		list.add(Integer.valueOf(123)); 요소추가시 타입검사 O
		
//		Generic을 사용하지 않으면
//		String name0 = list.get(0); 요소를 Object로 처리(모든타입을 담을 수 있게)
//		사용할 타입으로 형변환을 해주어야 한다.
		String name0 = list.get(0);
		String name1 = list.get(1); // getter이용 시 generic타입으로 자동 리턴
		System.out.println(name0);
		System.out.println(name1);
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(3); // int -> Integer auto boxing처리 후 추가
		intList.add(Integer.valueOf(3));
		Integer i0 = intList.get(0); //Integer -> int auto unboxing
		int i1 = intList.get(1);
		System.out.println(i0);
		System.out.println(i1);
		
		//객체 생성부의 generic은 생략가능 : 1.7부터
		List<Double> dList = new ArrayList<>();
		
	}

	/**
	 * java.util.ArrayList implements List implements Collection
	 *  - ArrayList 구현클래스
	 *  - LinkedList
	 *  	사용은 똑같고, 동작방법만 다름
	 *  
	 *  중복저장 가능, 저장된 순서 유지 
	 */
	private void test1() {
		//list다형성 적용
		ArrayList list1 = new ArrayList();
		List list2 = list1;
		Collection list3 = list1;
		
		//요소 추가
		list1.add("apple");
		list1.add(123); //기본형이 아닌 Wrapper객체가 전달된다 : Integer.valueOf(123) auto boxing 
		list1.add(34.56);
		list1.add(true);
		list1.add(new Date());
		
		//중간에 추가 : add(index,요소)
		list1.add(3, false); //3번지 이후의 값은 하나씩 뒤로 자동 이동
		//중간에 삭제 : remove(index)
		list1.remove(0); //뒤 요소는 자동으로 하나씩 자동 땡겨짐
		//중복된 요소 : 저장가능
		list1.add(true);
		
		
		//요소 가져오기(인덱스) : 값 입력한 순서대로 저장된다.
		//list.size() : 저장된 요소의 개수
		System.out.println(list1.size());
		for(int i = 0; i < list1.size(); i++) {
			System.out.println(i + " " + list1.get(i));
		}
		
	}


	/**
	 * 배열의 단점
	 * 	- 크기변경 불가능
	 *  - 중간에 요소 추가/삭제가 불편함
	 */
	private void test0() {
		Student[] students = new Student[3];
		students[0] = new Student(1, "홍길동");
		students[1] = new Student(2, "신사임당");
		students[2] = new Student(3, "세종대왕");
		
		//학생 2명 추가
		Student[] students2 = new Student[10];
		System.arraycopy(students, 0, students2, 0, students.length);
		students2[3] = new Student(4, "이순신");
		students2[4] = new Student(5, "장영실");
		
		//학생 1명 제거 -2번지 요소 제거한다면, 3번지를 미리 땡겨와야됨.
		students2[2] = students2[3];
		students2[3] = students2[4];
		students2[4] = null;
		
		//다시 1명 추가 -2번지에 추가
		students2[4] = students2[3];
		students2[3] = students2[2];
		students2[2] = new Student(6, "논개");
		
		//현재 관리되고 있는 학생현황
		for(int i = 0; i < students2.length; i++) {
			System.out.println(i + " " + students2[i]);
		}
	}

}
