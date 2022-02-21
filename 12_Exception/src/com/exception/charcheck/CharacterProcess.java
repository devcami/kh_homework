package com.exception.charcheck;

public class CharacterProcess {

	public CharacterProcess() {
	}
	
	//전달된 문자열 값에서 영문자가 몇개인지 카운트해서 리턴
	//단, 공백문자가 있으면 CharCheckException발생
	public int countAlpha(String s) {
		char[] charArray = s.toCharArray();
		int sum = 0;
		
		for(int i = 0; i < charArray.length; i++) {
			if(charArray[i] == ' ') {
				throw new CharCheckException("체크할 문자열 안에 공백 포함할 수 없습니다.");
			}
			else if((charArray[i] >= 'a' && charArray[i] <= 'z') || (charArray[i] >= 'A' && charArray[i] <= 'Z')) {
				sum += 1;
			}
		}
		return sum;
	}
}
