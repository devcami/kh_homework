package com.kh.test;

//실습문제 2-2.

public class Test2 {
	
	public static void main(String[] args) {
		//나의 신상정보 저장할 변수 생성과 대입
		//이름,나이,성별,주소,전화번호,이메일
		
		String name = "이은민"; 
		int age = 27;
		String sex = "여";
		String phoneNumber = "01052037675";
		String email = "juf1015@gmail.com";
		String adress = "경기도 성남시";
		
		//상단부분 출력
		System.out.println("=======================================================================");
		System.out.println("이름 \t 나이 \t 성별 \t 전화번호 \t\t  이메일  \n\t 주소");
		System.out.println("=======================================================================");
		
		//나의 신상정보 출력
		System.out.printf("%s \t %d \t %s \t %s \t %s \t %n\t %s %n",name,age,sex,phoneNumber,email,adress);
		
		//변수를 재사용해 팀메이트 정보를 다시 변수에 대입 및 출력
		//홍길동
		
		name = "홍길동"; 
		age = 22;
		sex = "남";
		phoneNumber = "01012341234";
		email = "hgd@naver.com";
		adress = "경기도 광주시";
		
		System.out.printf("%s \t %d \t %s \t %s \t %s \t %n\t %s %n",name,age,sex,phoneNumber,email,adress);
		
		//홍길순
		
		name = "홍길순"; 
		age = 20;
		sex = "여";
		phoneNumber = "010123412341";
		email = "hgs@gmail.com";
		adress = "전라남도 광주시";
		
		System.out.printf("%s \t %d \t %s \t %s \t %s \t %n\t %s %n",name,age,sex,phoneNumber,email,adress);
		
		
	}

	

}
