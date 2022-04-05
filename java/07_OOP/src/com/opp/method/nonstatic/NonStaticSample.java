package com.opp.method.nonstatic;

import java.util.Arrays;
import java.util.Random;

public class NonStaticSample {
	//1. 반환값 없고 매개변수 없는 메소드
	//실행 요청시 1~45까지의 임의의 정수 6개 중복되지 않게 발생시켜 출력하는 메소드
	//메소드명 : printLottoNumbers
	public void printLottoNumbers() {
		int[] lotto = new int[6];
		
		int i = 0;
		outer :
		while(true) {
			Random rnd = new Random();
			int n = rnd.nextInt(45) + 1;
			lotto[i] = n;
			
			int j = 1;
			while(j < i) {
				if(lotto[i] == lotto[j]) {
					continue outer;
				}
				else j++;
				
			}
			i++;
			if(i == lotto.length) 
				break;
		}
		
		for(i = 0; i < lotto.length - 1; i++) {
			int min = i;
			for(int j = i; j < lotto.length; j++) {
				if(lotto[min] > lotto[j]) {
					min = j;
				}
			}
			int temp = lotto[min];
			lotto[min] = lotto[i];
			lotto[i] = temp;
		}
		
		System.out.println(Arrays.toString(lotto));
	}
	
	
	//2. 반환값 없고 매개변수 있는 메소드
	//실행 요청시 정수 하나, 문자 하나를 전달받아 문자를 정수 갯수만큼 출력하는 메소드
	//메소드명 : outputChar
	public void outputChar(int num, char ch) {
		for(int i = 0; i < num; i++) {
			System.out.print(ch);
		}
	}
	
	//3. 반환값 있고 매개변수 없는 메소드
	//실행 요청시 알파벳 범위의 임의의 영문자를 하나 발생시켜 리턴하는 메소드
	//메소드명 : alphabet
	public char alphabet() {
		char ch = (char)(Math.random()*26 + 65);
		return ch;
	}
	
	//4. 반환값 있고 매개변수 있는 메소드
	//실행 요청시 문자열과 시작인덱스, 끝인덱스를 전달받아 해당 인덱스 범위의 문자열을
	//추출하여 리턴하는 메소드. 단 문자열은 반드시 값이 있어야함. 없으면 null 리턴처리
	//메소드명 : mySubstring
	public String mySubstring(String str, int i, int j) {
		String myStr = str.substring(i, j);
		return myStr;
	}
	
	
	public static void main(String[] args) {
		NonStaticSample sample = new NonStaticSample();
//		sample.printLottoNumbers();
//		sample.outputChar(13, 'ㄱ');
		System.out.println(sample.alphabet());
		System.out.println(sample.mySubstring("NonStaticSample", 0, 6));
	}
}
