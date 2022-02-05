package kh.java.two_dimentional.array;

public class TwoDimentionalArrayStudy {
	public static void main(String[] args) {
		TwoDimentionalArrayStudy study = new TwoDimentionalArrayStudy();
//		study.test1();
//		study.test2();
//		study.test3();
	}

	/**
	 * 2차원배열 초기화
	 *  - 배열할당 + 번지수별 초기화 (선언 + 할당 + 값대입)
	 */
	public void test3() {
//		int[][] arr = {{1, 2, 3}, {4, 5, 6}};
		int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}};
		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[0].length; j++) {
//				System.out.print(arr[i][j] + " ");
//			}
//		System.out.println();	
//		}
		
		//for each문
		for(int[] ar : arr) {
			for(int a : ar) {
				System.out.print(a + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 알파벳 배열 char[2][26] 
	 * 0행 - 대문자
	 * 1행 - 소문자
	 */
	public void test2() {
		char[][] alphabet = new char[2][26];
		
		//길이
		System.out.println(alphabet.length); //outer길이 : 2
		System.out.println(alphabet[0].length); //inner길이 : 26
		
		for(int i = 0; i < alphabet.length; i++) {
			for(int j = 0; j < alphabet[0].length; j++) {
				alphabet[i][j] = (char)((i == 0? 'A' : 'a') + j);
			}
		}
		for(int i = 0; i < alphabet.length; i++) {
			for(int j = 0; j < alphabet[0].length; j++) {
				System.out.print(alphabet[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 2차원 배열 (행렬)
	 */
	public void test1() {
		// 1. 배열 참조변수 선언
		int[][] arr;
		
		// 2. 배열 할당 - int의 기본값 0으로 초기화
		arr = new int[3][2]; //3행 2열
		
		// 3. 값대입 & 사용
		// 배열 요소간 규칙성이 발견되는 경우는 중첩반복문과 별도의 증감변수를 이용해 값대입
		int k = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = k++;
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 2; j++) {
				System.out.printf("arr[%d][%d] : %d%n", i, j, arr[i][j]);
			}
		}
	}
}
