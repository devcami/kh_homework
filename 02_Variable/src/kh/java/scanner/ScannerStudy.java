package kh.java.scanner;

import java.util.Scanner;

public class ScannerStudy {
	
	public static void main(String[] args) {	
		ScannerStudy study = new ScannerStudy();
		study.test1();
	}
	
	/**
	 * 1. next | nextInt | nextDouble | nextBoolean ...
	 *  - 자료형 변환기능 있는 메소드 모두
	 *  - 입력 버퍼에서 실제 문자열 이전에 만나는 공백/개행 문자는 무시하고, 
	 *    실제 문자열 이후 공백/개행 문자 전까지 읽어 반환한다. 
	 * 
	 * 2. nextLine
	 *  - 입력 버퍼에서 개행문자까지 읽어온 후, 개행문자를 제외하고 반환한다.
	 * 
	 */
	
	public void test1() {		
		//사용자 입력은 무조건 문자열이다.
		//Scanner는 적절한 타입으로 변환해서 값을 return한다.
		
		Scanner sc = new Scanner(System.in);

		System.out.print("이름을 입력하세요 : ");
		String name = sc.next(); //사용자 입력 값(문자열)을 name변수에 대입해라	
//		
//		
//		System.out.print("나이 : ");
//		int age = sc.nextInt(); //사용자의 숫자 입력을 int로 변환해서 리턴
//		
//		System.out.println("키 (예 : 165.5) : ");
//		double height = sc.nextDouble();
//		
//		System.out.println("결혼 여부 (true | false) : ");
//		boolean married = sc.nextBoolean();
//		
//		//char = 먼저 string (temp)을 만들어서 첫번째 글자(char.At)만 가져오게 만든다
//		System.out.print("성별 (남|여) : ");
//		String temp = sc.next();
//		char gender = temp.charAt(0); //char.At(인덱스) : 문자열 메소드
		
		sc.nextLine();//개행문자 버리기용
		System.out.print("주소를 입력하세요 : ");
		String adr = sc.nextLine(); //nextLine : 공백이 포함된 문자열
//		
		System.out.printf("반갑습니다. %s님!%n",name);
//		System.out.printf("당신은 %d살 입니다.%n",age);
//		System.out.printf("당신의 키는 %.2fcm입니다.%n",height);
//		System.out.printf("결혼 여부는 %b입니다.%n",married);
//		System.out.printf("당신은 %c자 입니다.%n",gender);
//		
		System.out.printf("주소는 [%s] 입니다.%n",adr);
	}

}
