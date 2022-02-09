package kh.java.oop.init.block;

import java.util.Random;

/**
 *  초기화블럭 : 필드값 세팅을 위한 코드 작성 구간
 *	
 *	멤버변수 값대입 순서 - 처리되는 순서
 *	(객체를 만들어야 멤버변수가 들어갈 수 있음)
 *	1. 타입별 기본값 세팅 (선언부에 값 대입 하지 않은 경우)
 *	2. 초기값 (선언부에 초기화 한 경우)
 *	3. 초기화블럭 설정값
 *	4. 생성자에서 설정값
 *
 *	클래스변수의 값대입 순서
 *	1. 타입별 기본값
 *	2. 초기값
 *	3. static 초기화블럭 설정값
 *	객체를 생성하지 않기 때문에 생성자 x
 */
public class InitBlockSample {
	
	//1.2.
	static int y = 7;
	//3. static변수의 초기화 블럭
	static {
		System.out.println("static초기화블럭 y = " + y);
		y = 77;
	}
	
	//System.out.println(); 
	//여기엔 실행구문 못옴 
	//field만 올 수 있음 
	public void test() {
		System.out.println();
	}
	
	//1. 2.
	int x = 100;
	int[] lotto;
	//3. 멤버변수의 초기화 블럭
	{
		System.out.println("초기화 블럭 전 x = " + x);
		x = 200;
		
		lotto = new int[6];
		Random rnd = new Random();
		int i = 0;
		while(true) {
			int n = rnd.nextInt(45) + 1 ;
			lotto[i++] = n;
			if(i == lotto.length){
				break;
			}
		}
	}
	//4. 생성자(하나의 메소드임)
	//	- 리턴타입 없음
	//  - 클래스명과 생성자 메소드명은 동일
	public InitBlockSample() {
		System.out.println("생성자 전 x = " + x);
		x = 300;
	}
}
