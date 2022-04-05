package kh.java.random.number;

import java.util.Random;

public class RandomStudy2 {

	public static void main(String[] args) {
		RandomStudy2 study = new RandomStudy2();
//		study.test1();
		study.test2();
	}
	//1~50까지 랜덤
	//a~z까지 랜덤
	public void test1() {
		Random rnd = new Random();
		System.out.println(rnd.nextInt(50)+1);
		System.out.println((char)(rnd.nextInt(26)+97));
		System.out.printf("%c",rnd.nextInt(26)+97);
		
	}
	
	public void test2() {
		System.out.println(Math.random());
		System.out.println((int)(Math.random()*50)+1);
		System.out.printf("%c",(int)(Math.random()*26)+97);
		
	}
	
	//정리
	// 
	// 1. java.utill.Random(클래스) : import
	// Random 객체 생성
	// random변수.nextInt(경우의수) + 시작값
	
	// 2. Math.random (Math 클래스의 random 메소드를 가져와서 쓴다)
	// 객체 생성할필요 없음
	// Math.random()* 경우의수 + 시작값

	
}
