package kh.java.test.array;

import java.util.Scanner;

public class Test5 {
	
	public static void main(String[] args) {
		Test5 ts = new Test5();
		ts.test();
	}
	public void test() {
		// 주민번호 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호를 입력하세요 \n(예 : 990101-1234567) >> ");
		String inputNum = sc.next();
		
		String result = "";
				
		// string -> char[] 로 만들기
		char[] charNum = new char[inputNum.length()];
		for(int i = 0; i < inputNum.length(); i++) {
			charNum[i] = inputNum.charAt(i);
		}
		
		// 복사하기
		char[] outputNum = new char[charNum.length];
		System.arraycopy(charNum, 0, outputNum, 0, charNum.length);
		
		// 주민번호 뒷자리 6자리를 *로 바꾸기
		for(int i = 0; i < outputNum.length ; i++) {
			if(i > 7)
				outputNum[i] = '*';
			result += outputNum[i];
		}
		// 결과 출력 
		
		System.out.printf("입력하신 주민등록번호는 %s입니다.",result);
		
	}

}
