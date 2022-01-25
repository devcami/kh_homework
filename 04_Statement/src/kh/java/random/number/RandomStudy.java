package kh.java.random.number;

import java.util.Random;
import java.util.Scanner;

public class RandomStudy {
	
	public static void main(String[] args) {
		RandomStudy study = new RandomStudy();
//		study.test1();
//		study.test2();
		study.test3();
		
	}
	/**
	 * 1. java.util.Random
	 */
	public void test1() {
		Random rnd = new Random();
//		System.out.println(rnd.nextInt()); //int범위 내의 난수를 반환
		
		//1~10사이의 난수 생성
		//nextInt(경우의 수) + 시작값
		System.out.println(rnd.nextInt(10)); //0~9
		System.out.println(rnd.nextInt(10) + 1); //1~10
		System.out.println(rnd.nextInt(6) + 5); //5~10
		
		System.out.println(rnd.nextDouble()); //0.0이상 1.0미만의 실수 반환
		System.out.println(rnd.nextBoolean()); //true/false를 임의로 반환
		
		System.out.println(rnd.nextBoolean()? "안녕" : "잘가"); //둘중 하나를 임의로 반환
		
		System.out.println((char)(rnd.nextInt(26)+65)); //임의의 알파벳 대문자 출력하기
		System.out.printf("%c %n",rnd.nextInt(26)+65); //임의의 알파벳 대문자 출력하기
		
	}
	/**
	 * 2. Math.random() : double을 리턴
	 *  - 0.0이상 1.0미만의 실수를 반환 : (rnd.nextDouble())과 같은 값.
	 *  
	 */
	public void test2() {
		//System.out.println(Math.random());
		
		double n = Math.random();
		System.out.println(n);
		
		//1~10 사이의 난수 생성 (10을 곱하고 int로 형변환을 해준뒤 +1)
		//(int)(Math.random() * 경우의 수) + 최소값
		System.out.println((int)(n * 10) + 1); 
		
		//임의의 알파벳 대문자 출력하기
		System.out.printf("%c %n",(int)(Math.random() * 26) + 65); 
		System.out.printf("%c %n",(int)(Math.random() * 26) + 'A'); 
		System.out.println((char)((Math.random() * 26) + 65)); 
	}
	/**
	 * 동전 앞뒤 맞히기 게임
	 * - 1. 사용자 입력값 앞뒤
	 * - 2. 컴퓨터 난수값 앞뒤
	 */
	public void test3() {
		Scanner sc = new Scanner(System.in);
		System.out.print( "동전 1. 앞 , 2. 뒤 ? :");
		int userCoin = sc.nextInt();
		
//		Random rnd = new Random();
//		int comCoin = rnd.nextInt(2) + 1;
		
//		int comCoin = rnd.nextBoolean()? 1 : 2 ;
		
		int comCoin = (int)(Math.random()*2)+ 1 ; 
		System.out.println(comCoin);
		
//		결과
		String result = 
				userCoin == comCoin?
						"당신이 이겼습니다." : 
							"컴퓨터가 이겼습니다.";
		
		System.out.println(result);
		
	}

}
