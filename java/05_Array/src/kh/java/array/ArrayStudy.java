package kh.java.array;

import java.util.Scanner;

public class ArrayStudy {
	public static void main(String[] args) {
		ArrayStudy study = new ArrayStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
//		study.test5();
		study.test6();
		
	}
	
	/**
	 *  배열의 크기는 변경이 불가하다.
	 *  배열(객체) 삭제 : 주소값을 null로 변경 -> Garbage Collector 기능 사용
	 */
	public void test6() {
		double[] arr = new double[3];
		
		// hashCode : 객체를 관리하기 위한 고유값 ( 주소값은 아님 )
		// double arr[3] 과 double arr[10]의 hash코드는 다르다 
		System.out.println(arr.hashCode());
		
		// 크기 변경이 아닌 크기가 10인 새로운 배열을 할당.
		arr = new double[10];
		System.out.println(arr.hashCode());
		
		// 주소값을 null로 지정해서 객체삭제
		arr = null; // 주소값을 삭제한건 아니고 , static과 연결을 끊은것 -> 이걸 GC가 알아서 삭제해줌
	
		double[] temp = arr;
		arr = null;

		
		// 주의할 것
		// 연결된 배열이 없을 때
		
//		System.out.println(arr.length);  :  java.lang.NullPointerException (앞에 변수가 가리키는게 없다)
//		System.out.println(arr[0]);
		
	}
	
	/**
	 *  String[] 참조형 배열
	 *   - 참조형의 기본값은 null이다.
	 *   
	 *  사용자에게 친구 3명의 이름을 입력받고, 배열에 저장 후 출력
	 */
	public void test5() {
		Scanner sc = new Scanner(System.in);
		
		String[] names = new String[3];
		int num = 1;
		
		// 친구 3명의 이름 입력받고 배열에 저장
		for(int i = 0; i < names.length; i++) {
			System.out.printf("%d번째 친구 이름 입력 : ", num);
			names[i] = sc.next();
			num++;
		}
		// 출력
		// for each 로 출력하기
		// 당신의 친구는 홍길동, 신사임당, 장영실 입니다.
		System.out.print("당신의 친구는 ");
		for(int i = 0; i < names.length; i++) {
			System.out.print(names[i]);
			if( i != (names.length - 1)) 
				System.out.print(", ");
		}
		System.out.print("입니다.");
	}
	/**
	 *  배열 초기화
	 *  
	 *  변수 초기화란 ? 변수선언 + 값대입
	 *  char[] alphabet = new char[26]; < 이건 초기화라고 부르지 않음
	 *  >>
	 *  배열 변수선언 + 배열 할당 + 인덱스별 값대입 한번에 하는것
	 *  
	 */
	public void test4() {
		//길이 값은 따로 주지 않는다
		//int[] scores = new int[] {100, 90, 80, 98, 65};
		
		int[] scores = {100, 90, 80, 98, 65};
		
		// 변수 : 배열 (반복접근할 개체)
		// 알아서 배열의 갯수만큼만 반복 
		
		int sum = 0;
		double avg = 0.0;
		
		for(int i : scores) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + ((double)sum/scores.length));
	}
	
	/**
	 * 관리할 데이터의 규칙이 있다면, 값대입도 반복문을 사용가능하다.
	 * 
	 * char[] : 알파벳 대문자 관리
	 */
	public void test3() {
		// 배열 번수 선언 & 할당
		char[] alphabet = new char[26];
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char)('A' + i);	//값대입		
//			System.out.println(alphabet[i]);
		}
		
		// for each : 향상된 for문
		// 하나의 요소를 담을 변수(배열과 같은 타입)선언  : 반복 접근 할 배열
		// 인덱스를 사용할 수는 없다.
		// 꺼내어 쓸 때 사용
		for(char ch : alphabet) {
			System.out.println(ch);
		}
		
	}
	/**
	 *  홍길동 학생의 점수 
	 *  100, 90, 80, 98, 65
	 */
	public void test2() {
		
		// 1. 배열변수 선언 및 할당
		final int LENGTH = 5;
		int[] grade ;
		
		// 2. 배열할당
		grade = new int[LENGTH];
		
		// 3. 인덱스별 값대입 및 출력
		System.out.println(grade[0] = 100);
		System.out.println(grade[1] = 90);
		System.out.println(grade[2] = 80);
		System.out.println(grade[3] = 98);
		System.out.println(grade[4] = 65);

		System.out.println("배열의 길이 속성 : " + grade.length);
		for(int i = 0; i < grade.length; i++) {
			System.out.println(grade[i]);
		}
		
	}	
	/**
	 *	변수 : 값 하나를 보관
	 *	배열 : 값 여러개를 보관
	 *
	 *	1. 배열선언 : stack영역에 변수(공간)을 생성
	 * 	2. 배열할당 : heap영역에 배열을 실제 생성하고 , 그 주소값을 stack영역의 변수에 대입
	 * 	3. 사용 : 변수와 인덱스를 이용해서 값대입하거나 사용
	 */
	public void test1() {
//		int n; stack 영역의test1 안에 int n (원시형)변수 만들기 ,4byte
		
//		1. 배열 변수 선언 : stack영역의 test1 안에 int[] n (참조형)변수 만들기
//					     4byte - 참조형은 무조건 4byte					
		int[] n;
//		2. 배열 할당 : heap영역에 배열을 생성 , n이라는 공간에 들어가는 주소값을 담는다. 
//					 heap영역에 생성된 int공간 4개는 자동으로 0으로 초기화된다.
//					 stack을 제외한 heap, static영역은 변수 생성시 자동으로 기본값으로 초기화된다.
//		>> stack
		int a;	//stack 영역에 생성된 변수 a  
		a = 10; //자동으로 초기화되지 않아서 값대입 후 사용해야한다.
		System.out.println(a);
		
//		타입별 기본값 (0) 
//		boolean (false) - 0 왜냐 (true) - 1임
//		char : ' ' (null - 빈문자)
//		int (0)
//		double (0.0)
		
		n = new int[4];
		
//		3. 값대입 후 사용
		n[0] = 10;
		n[1] = 20;
		n[2] = 30;
		n[3] = 40;
		
		System.out.println(n[0]);
		System.out.println(n[1]);
		System.out.println(n[2]);
		System.out.println(n[3]); // 마지막 인덱스 : 길이 - 1
		
	}

}
