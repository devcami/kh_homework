package com.exception.number;

public class NumberProcess {

	public NumberProcess() {
	}
	
	//임의 정수 두개를 전달받아, 첫번째 수가 두번째 수의 배수인지 확인
	//맞으면 true 리턴, 아니면 false 리턴
	//단, 전달된 정수 두개가 1~100사이의 값이 아니면 exception
	
	public boolean checkDouble(int a, int b) {
		if((a < 1 || a > 100) || (b < 1 || b > 100))
			throw new NumberRangeException("1부터 100사이의 값이 아닙니다.");
		else if(a % b == 0) return true;
		else return false;
	}
	
}
