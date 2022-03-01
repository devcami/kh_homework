package kh.java.collections.map;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kh.java.collections.list.Student;

public class HashMapStudy {

	public static void main(String[] args) {
		HashMapStudy study = new HashMapStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	
	/**
	 * containsKey
	 * containsValue
	 */
	private void test5() {
		Map<Integer, Student> studentMap = new HashMap<>();
		studentMap.put(1, new Student(1, "홍길동"));
		studentMap.put(2, new Student(2, "신사임당"));
		studentMap.put(3, new Student(3, "논개"));
		
		
		//해당 객체가 equals/hashCode Override를 통해 동등성 비교가 가능한 경우여야한다.
		//동일하지는 않지만 동등함. = 주소값이 같진 않지만 안의 내용은 같다.
		//Student Class에 equals와 hashCode가 Override 되어있기 때문에 True가 나온것.
		//equals와 hashCode를 주석하면 동일성 비교를 하기 때문에 false가 나온다.
		
		//특정 key값 검사 = boolean
		System.out.println(studentMap.containsKey(1)); //Key중에 1이 있나 True
		System.out.println(studentMap.containsKey(100)); //Key중에 100이 있나 False
		
		//특정 value값 검사 = boolean
		System.out.println(studentMap.containsValue(new Student(3, "논개"))); //value중 new Student(3, "논개"))가 있나 True
		
	}

	/**
	 * 학생객체 관리
	 * - Map<Key(Integer : Student#no), Student>
	 * - key값 : Student의 field(value)중 고유한 값으로 사용한다.
	 */
	private void test4() {
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, new Student(1, "홍길동"));
		map.put(2, new Student(2, "신사임당"));
		map.put(3, new Student(3, "이순신"));
		
//		System.out.println(map);
		
		//학생번호 1번, 이름은 [홍길동]학생입니다.
		
		//keySet
		Set<Integer> keySet = map.keySet();
//		for(Integer key : keySet) {
//			String value = map.get(key).getName();
//			System.out.println("학생번호 " + key + "번, 이름은 [" + value + "]학생 입니다.");
//			
//		}
		//Iterator
		Iterator<Integer> iter = keySet.iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			Student value = map.get(key);
			System.out.printf("학생번호 %d번, 이름은 [%s]학생 입니다.%n", value.getNo(), value.getName());
		}
		
		
		//entrySet
		Set<Map.Entry<Integer, Student>> entrySet = map.entrySet();
//		for(Map.Entry<Integer, Student> entry : entrySet) {
//			Student value = entry.getValue();
//			System.out.println("학생번호 " + value.getNo() + "번, 이름은 [" + value.getName() + "]학생 입니다.");
//		}
		//Iterator
		Iterator<Map.Entry<Integer, Student>> iter2 = entrySet.iterator();
		while(iter2.hasNext()) {
			Map.Entry<Integer, Student> entry = iter2.next();
			Student value = entry.getValue();
			System.out.printf("학생번호 %d번, 이름은 [%s]학생 입니다.%n", value.getNo(), value.getName());
			
		}
	}

	/**
	 * Map의 요소를 순회 열람(toString말고 하나씩 꺼내서 봄)
	 * - 1. keySet	: key를 별도의 Set으로 반환 (Key -> Set -> 하나씩 접근)
	 * - 2. entrySet: entry(Key+Value)를 별도의 Set으로 반환 (entry -> Set -> 하나씩 접근)
	 */
	private void test3() {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "홍길동");
		map.put(2, "신사임당");
		map.put(3, "세종대왕");
		
		//1. keySet
		Set<Integer> keySet = map.keySet();
		//for each로 하나씩 꺼내기
//		for(Integer key : keySet) {
//			String value = map.get(key);
//			System.out.println(key + " = " + value);
//		}
		//Iterator
		Iterator<Integer> iter = keySet.iterator();
		while(iter.hasNext()) {
			Integer key = iter.next();
			String value = map.get(key);
			System.out.println(key + " = " + value);
		}
		
		//2. entrySet
		//entry : key+value 한쌍의 요소
		Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
		
//		for(Map.Entry<Integer, String> entry : entrySet) {
//			Integer key = entry.getKey();
//			String value = entry.getValue();
//			System.out.println(key + " = " + value);
//		}
		//Iterator
		Iterator<Map.Entry<Integer, String>> iter2 = entrySet.iterator();
		while(iter2.hasNext()) {
			Map.Entry<Integer, String> entry = iter2.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " = " + value);
		}
		
	}

	/**
	 * 다른 Map 병합하기
	 */
	private void test2() {
		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1, "홍길동");
		map1.put(2, "신사임당");
		map1.put(3, "세종대왕");
		
		Map<Integer, String> map2 = new HashMap<>();
		map2.put(3, "논개");
		map2.put(4, "이화주");
		map2.put(5, "유관순");
		
		System.out.println("map1 = " + map1); //{1=홍길동, 2=신사임당, 3=세종대왕}
		System.out.println("map2 = " + map2); //{3=논개, 4=이화주, 5=유관순}
		
		// map1에 map2내용을 추가
		map1.putAll(map2);
		System.out.println("map1 = " + map1); //{1=홍길동, 2=신사임당, 3=논개, 4=이화주, 5=유관순}
		
		// 다른 Map을 인자로 하는 생성자
		Map<Integer, String> map3 = new HashMap<>(map2);
		System.out.println("map3 = " + map3);
	}

	/**
	 * Map<K, V>
	 * 	- K key타입
	 * 	- V value타입
	 * -> K ,V를 하나로 묶어 요소로 관리
	 */
	private void test1() {
		Map<String, Object> map = new HashMap<>();
		//value -> Object타입이기 때문에 모든 타입이 다 올 수 있다.
		
		
		//요소추가 put
		//기존 요소가 있다면, 삭제된 요소를 반환
		map.put("hello", "안녕하세요");
		map.put("num", 123);
		map.put("today", new Date());
		System.out.println(map.put("name", "홍길동"));
		System.out.println(map.put("name", "신사임당")); //동일한 Key값의 경우 기존값을 치환
		
		//요소 가져오기 get(K)
		//.get(K) -> Object(Value) return
		System.out.println(map.get("num"));
		System.out.println(map.get("hello"));
		System.out.println(map.get("today"));
		System.out.println(map.get("name"));
		
		//요소 삭제 remove(K)
		System.out.println("remove : " + map.remove("num"));
		
		//저장된 요소 전체 개수확인 size
		System.out.println(map.size());
		
		//toString Override 되어있음
		System.out.println(map);
		
	}

}
