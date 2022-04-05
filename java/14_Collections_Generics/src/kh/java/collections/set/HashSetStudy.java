package kh.java.collections.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import kh.java.collections.list.Student;

public class HashSetStudy {

	public static void main(String[] args) {
		HashSetStudy study = new HashSetStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
		study.test6();
	}
	
	/**
	 * 로또 번호 생성
	 *  - 1 ~ 45 사이의 중복없는 난수
	 *  - 오름차순 정렬
	 */
	private void test6() {
		Set<Integer> lotto = new TreeSet<>();
		while(lotto.size() < 6) {
			int n = (int)(Math.random() * 45 )+ 1 ;
			lotto.add(n);
		}
		System.out.println(lotto);
		
	}


	/**
	 * 중복 허용 X
	 * LinkedHashSet 저장된 순서 기억 (인덱스는 없음)
	 * TreeSet 기본정렬처리(요소로 사용된 클래스 implements Comparable)
	 * 
	 */
	private void test5() {
//		Set<Student> set = new LinkedHashSet<>();
		Set<Student> set = new TreeSet<>();
		set.add(new Student(3, "홍길동"));
		set.add(new Student(2, "신사임당"));
		set.add(new Student(1, "이순신"));
		
		System.out.println(set);
	}
	/**
	 *  커스텀객체 Set으로 관리하기
	 *  - 동일한 데이터를 가진 객체를 중복처리하기
	 *  - equals & HashCode 오버라이드 필수
	 */
	private void test4() {
		Set<Student> set = new HashSet<>();
		set.add(new Student(1, "홍길동"));
		set.add(new Student(2, "신사임당"));
		set.add(new Student(3, "이순신"));
		set.add(new Student(1, "홍길동"));
		
		for(Student s : set) {
			System.out.println(s);
		}
	}

	/**
	 *  List --> Set
	 *   - 중복을 제거하기 위해서
	 *   
	 *  Set --> List
	 *   - 순서(정렬)를 생성하기 위해서
	 *   - 인덱스를 적용 (하나씩 접근)
	 */
	private void test3() {
		List<Integer> list = Arrays.asList(2,3,4,5,2,3,4,1,3);
		System.out.println(list);
		
		//Set으로 변환
		Set<Integer> set = new HashSet<>(list);
		System.out.println(set);
		
		//List로 변환
		List<Integer> newList = new ArrayList<>(set);
		System.out.println(newList);
		System.out.println(newList.get(3));
	}


	/**
	 * Set API
	 */
	private void test2() {
		Set<String> set = new HashSet<>(); //타입추론에 의한 <> 생략 (1.7)
		set.add("홍길동");
		set.add("고길동");
		set.add("마길동");
		
		//포함여부 (boolean)
		System.out.println(set.contains("홍길동")); //T
		System.out.println(set.contains("최길동")); //F
		
		//isEmpty() (boolean)
		System.out.println(set.isEmpty()); //F
		
		//요소제거 
//		set.clear();
//		System.out.println(set.isEmpty()); //T
		
		//다른 set과 병합
		Set<String> other = new HashSet<>();
		other.add("조길동");
		other.add("하길동");
		other.add("홍길동");
		
		set.addAll(other);
		
		
		
		System.out.println(set);
		
	}
	/**
	 * Collection 
	 * 	-set
	 * 		-HashSet
	 * 중복허용 X
	 * 저장된 순서를 관리 X (index가 없음)
	 * 
	 * Reason of using generics 
	 * 1. add type check
	 * 2. get no need to cast
	 */
	private void test1() {
		HashSet<Integer> set1 = new HashSet<Integer>();
		Set<Double> set2 = new HashSet<Double>();
		Collection<String> set3 = new HashSet<String>();
		
		//.add : 저장된 순서 무시 - boolean 리턴
		//기본형 정렬처리되는것은 무시할 것
		set1.add(3); 
		set1.add(2);
		set1.add(1);
		set1.add(1); //중복허용 X
		set1.add(1);
		set1.add(1);
		set1.add(1);
		
		//요소하나를 집어서 가져올 수 있는 기능이 없음
		//get(index) 없음
		
		//모든 요소를 순차열람 가능
		// 일반 for문 X
		// 1. for each
		// 2. Iterator
//		Iterator<Integer> iter = set1.iterator();
//		while(iter.hasNext()) {
//			Integer i = iter.next();
//			System.out.println(i); // 1 2 3
//		}
		for(Integer i : set1) {
			System.out.println(i);
		}
		
		//요소제거 (autoboxing : int 2 --> Integer 2 -> Boolean)
		set1.remove(2);
		
		//요소개수
		System.out.println(set1.size()); 
		
		//.toString
		System.out.println(set1); 
	}

}
