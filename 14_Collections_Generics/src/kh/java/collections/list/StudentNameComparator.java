package kh.java.collections.list;

import java.util.Comparator;

/**
 * Student의 기본정렬(no오름차순)외에 정렬기준을 만드려면
 * 별도의 Comparator 구현 클래스를 작성해야한다.
 *
 */
public class StudentNameComparator implements Comparator<Student>{

	
	/**
	 * 리턴값 
	 * 음수 : 자리교환이 일어남
	 * 0
	 * 양수
	 */
	@Override
	public int compare(Student s1, Student s2) {
		//Student#Name이 String이므로, String타입간 정렬기준메소드(String#compareTo)를 이용
		
		return s1.getName().compareTo(s2.getName());
	}

}
