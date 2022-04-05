package kh.java.scanner;

import java.util.Scanner;

public class ScannerStudy2 {
	public static void main(String[] args) {	
		ScannerStudy study = new ScannerStudy();
		study.test1();
	}
	
	public void test1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		
		sc.nextLine();
		System.out.print("주소를 입력하세요 : ");
		String adr = sc.nextLine();
		
		System.out.printf("반갑습니다 %s님 ! %n",name);
		System.out.printf("주소는 [%s]입니다. %n",adr);
			
	}
	

}
