package kh.java.api.string;

import java.util.StringTokenizer;

public class StringStudy {

	public static void main(String[] args) {

		StringStudy study = new StringStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
		study.test6();
		
	}
	
	/**
	 *  String api
	 */
	public void test6() {
		String str = "application";
		System.out.println(str.indexOf("ca"));// 5
		System.out.println(str.indexOf("k")); // -1 : 존재하지 않는경우
	}
	
	/**
	 * split : 여러 문자를 동시에 처리
	 */
	public void test5() {
		String data = "a,1,가\n"
					+ "b,2,나\n"
					+ "c,3,다";
		
		// split인자는 정규표현식 (문자열 검색 표현식)
		// 대괄호 안에 여러 문자를 한번에 쓴다. []
		// []는 문자하나의 옵션 -> ,나 \n을 구분자로 사용하겠다.
		String[] result = data.split("[,\n]");
		for(String str : result) {
			System.out.println(str);
		}
	}
	
	public void test4() {
		String data = "a,1,가\n"
					+ "b,2,나\n"
					+ "c,3,다";

		// 2차원배열처럼 풀이
		String[] result1 = data.split("\n");
		for(int i = 0; i < result1.length; i++) {
			String[] result2 = result1[i].split(",");
			for(int j = 0; j < result2.length; j++) {
				System.out.println(result2[j]);
			}
		}
		System.out.println();
		
		// 1차원배열처럼 풀이
		StringTokenizer st = new StringTokenizer(data, ",\n");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
	
	/**
	 * 문자열 쪼개기
	 *  - "java,oracle,html,css,javascript"
	 *  - CSV Comma Seperated Value
	 *  
	 *  1. String#split
	 *  2. StringTokenizer
	 */
	public void test3() {
		String data = "java,oracle,html,css,javascript";
		String[] result1 = data.split(",");
		System.out.println(result1.length);
		for(String s : result1) {
			System.out.println(s);
		}
		
		// tokenizer는 문자기준으로 사용된다. " " "/"
		// 값이 없는 token은 버려진다.
		// tokenizer.countTokens : tokenizer의 토큰 수
		// tokenizer.hasMoreTokens : boolean , tokenizer가 토큰을 더 가지고 있는가
		// tokenizer.nextToken : 다음 토큰을 tokenizer의 객체로부터 제거하면서 가져온다.
		
		/*
		 * java
		 * 
		 * /
		 * oracle
		 * 
		 * /
		 * ...
		 */
		StringTokenizer tokenizer = new StringTokenizer(data, ",");
		System.out.println(tokenizer.countTokens()); //5
		
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken(); 
			System.out.println("[" + token +"] - "+ tokenizer.countTokens());
		}
	}
	
	/**
	 * 변경되는 String을 메모리효율적으로 관리하기 위해 mutable한 String class
	 *  - String Builder : 싱글쓰레드용
	 *  - String Buffer : 멀티쓰레드용 동기화지원 (여러 쓰레드에서 공유 시 안전한 사용을 보장함)
	 */
	public void test2() {
		StringBuilder sb = new StringBuilder("java");
		System.out.println(sb);
		System.out.println(sb.hashCode());
		
		sb.append("oracle");
		System.out.println(sb);
		System.out.println(sb.hashCode());
		
	}
	
	/**
	 * String은 immutable이다.
	 *  - 변경불가
	 *  - Literal Pool : 리터럴 값을 하나 만들면 heap영역에 Literal저장소에 생성되어 관리된다.
	 *  - 중복된 메모리를 줄이기 위해서 리터럴은 따로 저장함
	 */
	public void test1() {
		String s1 = "java";
		String s2 = "java";
		String s3 = new String("java");
		String s4 = new String("java");
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		// 동일성 (주소값 비교) ==
		System.out.println(s1 == s2); //true
		System.out.println(s1 == s3); //false
		System.out.println(s3 == s4); //false
		
		// 동등성 (객체 정보(값) 비교) equals -> 문자열 값 비교
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		
		// 해쉬코드 값 비교
		// equals결과가 true라면 hashCode가 동일해야한다.
		System.out.println(s1.hashCode()); //3254818
		System.out.println(s2.hashCode()); //3254818
		System.out.println(s3.hashCode()); //3254818
		System.out.println(s4.hashCode()); //3254818
		
		System.out.println();
		// immutable
		// 문자열은 수정 불가
		// "java"를 수정하는 것이 아니라, "javaoracle"을 literal Pool에 추가로 생성되고 주소값을 새로 가진다.
		s1 += "oracle"; 
		s3 += "oracle";
		
		System.out.println(s1.hashCode()); //87819808
		System.out.println(s2.hashCode()); //3254818
		System.out.println(s3.hashCode()); //87819808
		System.out.println(s4.hashCode()); //3254818
		
	}

}
