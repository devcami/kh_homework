package kh.java.condition;

import java.util.Scanner;

public class IfStudy2 {
	public static void main(String[] args) {
		IfStudy2 study = new IfStudy2();
		study.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
		char inputChar = sc.next().charAt(0);
		
		String result = "";
		
		if(Character.isDigit(inputChar)) {
			result = "숫자";
		}
		else if(Character.isUpperCase(inputChar)) {
			result = "대문자";
		}
		else if(Character.isLowerCase(inputChar)) {
			result = "소문자";
		}
		else if(isKoreanCharacter(inputChar)) {
			result = "한글";
		}else {
			result = "특수문자";
		}
		
		System.out.printf("입력하신 [%c]는 %s입니다.",inputChar,result);
	}
	public static boolean isKoreanCharacter(char inputChar){
		return inputChar >= '가' && inputChar <= '힣';
		
	}

}
