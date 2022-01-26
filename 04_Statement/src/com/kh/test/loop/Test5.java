package com.kh.test.loop;

import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Test5 loopTest = new Test5();
		loopTest.test1();
	}
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=======회원정보 프로그램=======");
		System.out.print("몇명을 등록하시겠습니까 ? : ");
		int member = sc.nextInt(); //기능추가 2 입력할 회원정보 수	
		int num = 1; //회원 번호
		
		String name = "";
		int age = 0;
		String adr = "";
		double height = 0;
		double weight = 0;
		String phone = "";
		
		//출력란
		
		for(int i = 1; i <= member; i++) {
			System.out.printf("========%d번째 회원정보========%n",num);
			
			//사용자 입력란
			System.out.print("이름 : ");
			name = sc.next();
			System.out.print("나이 : ");
			age = sc.nextInt();
			sc.nextLine();//개행
			System.out.print("주소 : ");
			adr = sc.nextLine();
			System.out.print("키 : ");
			height = sc.nextDouble();
			System.out.print("몸무게 : ");
			weight = sc.nextDouble();
			System.out.print("연락처 : ");
			phone = sc.next();
			
//			최종 입력 후에 3명의 정보를 저장하고 3명을 한번에 호출하기,
//			3명의 정보를 이용해 평균 나이, 키, 몸무게 구하기
//			두개는 아직 나의 능력으로 풀 수 없음 ... ㅠ 
			
			System.out.printf("%d. %s %d세 %s %.1fcm %.1fkg %s%n",
					num, name, age, adr, height, weight, phone);
			num++;
			
		}	

	}
}


