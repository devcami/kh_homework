package kh.java.test.array;

import java.util.Scanner;

public class Test3 {
	
	public static void main(String[] args) {
		Test3 ts = new Test3();
		ts.test();
	}
	public void test() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 >> ");
		String inputStr = sc.next();
		
		System.out.print("검색할 문자를 입력하세요 >> ");
		char inputChar = sc.next().charAt(0);
		
		//char 배열에 inputStr을 한단어씩 넣기
		char[] str = new char[inputStr.length()];
		
		int count = 0;
		
		for(int i = 0; i < inputStr.length(); i++) {
			str[i] = inputStr.charAt(i);
			// inputChar와 str[i]가 같은지 비교하고 갯수 카운트하기 
			if(str[i] == inputChar) {
				count += 1;
			}
		}
		//출력
		System.out.printf("출력 : 입력하신 문자열 %s에서 찾으시는 문자 %c는 %d개 입니다."
							,inputStr, inputChar, count);
		
	
		
	}

}
