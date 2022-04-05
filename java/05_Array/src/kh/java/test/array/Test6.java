package kh.java.test.array;

import java.util.Scanner;

public class Test6 {
	
	public static void main(String[] args) {
		Test6 ts = new Test6();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.println("홀수인 양의 정수를 하나 입력하세요. ==> ");
		int arrSize = sc.nextInt();
		String result = " ";
		
		// 짝수, 음수는 조기리턴
		if(arrSize < 0 || (arrSize % 2) == 0) {
			System.out.println("잘못 입력하셨습니다. 0보다 큰 '홀수'만 입력해주세요.");
			return;
		}
		// 배열 선언
		int[] arr = new int[arrSize];
		
		// 배열 값대입 - 중간까지는 1씩 증가, 이후부터 끝까지는 1씩 감소
		int middle = (arrSize / 2) ;

		int i = 0;
		while(i < arrSize) {
			if(i <= middle) {
				arr[i] = i + 1;
			}
			else if(i > middle) {
				arr[i] = middle--;
			}
			i++;
		}
		// 출력	
		for(i = 0; i < arr.length; i++) {
			if(i == (arr.length))
				result += arr[i];
			result += arr[i] + ",";
		}
		System.out.printf("[%s]",result);
			
	}

}
