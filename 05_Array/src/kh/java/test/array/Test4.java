package kh.java.test.array;

import java.util.Scanner;

public class Test4 {
	
	public static void main(String[] args) {
		Test4 ts = new Test4();
		ts.test1();
//		ts.test2();
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("핸드폰번호를 입력하세요(공백없이) >> ");
		String phoneStr = sc.next();
		String result = " ";
		
		// 11자리의 문자형 배열에 저장
		char[] phone = new char[phoneStr.length()];
		for(int i = 0; i < phoneStr.length(); i++)
			phone[i] = phoneStr.charAt(i);
				
		// 복사할 배열
		char[] outputPhone = phone.clone();

		//가운데 4자리를 *로 바꾸기
		for(int i = 3; i < 7 ; i++) {
			outputPhone[i] = '*';
		}
		//출력하기
		for(int i = 0; i < outputPhone.length; i++)
			result += outputPhone[i];
			
		System.out.printf("입력하신 번호는 %s 입니다. ",result);
	}
	
	public void test2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("핸드폰번호를 입력하세요(공백없이) >> ");
		String phoneStr = sc.next();
		
		//배열복사 없이 문자열 차원에 4자리를 교체하기
		//java.lang.String.substring(beginIndex, endIndex) method
		
		String newPhoneStr = phoneStr.substring(0, 3) + "****" +
							phoneStr.substring(7, phoneStr.length());
		
		System.out.printf("입력하신 번호는 %s 입니다. ", newPhoneStr);
	}

}
