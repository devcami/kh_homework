package kh.java.condition;

import java.util.Scanner;

/**
 * switch문 - 값에 따라 분기처리하는 제어문
 * 
 * - 괄호 안에는 값으로 처리되는 변수 또는 계산식이 들어와야한다.
 * - byte, short, int, char, String, enum타입.
 * - 실수 X, boolean X (if 써라), long X
 * - 위에서부터 아래로 case문을 검사, 해당하는 case구문 실행.
 * - break를 만나면 실행중지, switch블록을 빠져나오게 된다.
 * - 제시한 case문을 모두 만족하지 않는다면 ?  - 실행되지 않고 default구문을 실행한다.
 * 
 */
public class SwitchStudy {
	public static void main(String[] args) {
		SwitchStudy study = new SwitchStudy();
//		study.test1();
//		study.test2();
//		study.test3();
		study.test4();
		
	}
	
	/**
	 * 회원관리
	 * 1. Gold		- 스마트 TV, 전자렌지, 전기다리미
	 * 2. Silver	- 전자렌지, 전기다리미
	 * 3. Bronze	- 전기다리미
	 * 
	 */
	
	public void test4() {
		
		String menu = "회원등급을 입력하세요.\n"
					+ "1. Gold  2. Silver  3. Bronze\n"
					+ "입력 : ";
		System.out.println(menu);
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		String present = "";
		switch(num){
		case 1 : present += "스마트 TV,";
		case 2 : present += " 전자렌지,"; 
		case 3 : present += " 전기다리미"; break;
		default : System.out.println("잘못 입력하셨습니다."); return;
			
		}
		System.out.printf("축하합니다. [%s]를 드립니다.%n",present);
		
	}
	
	/**
	 * fall through
	 */
	
	public void test3() {
		int n = 100;
		char grade = ' '; 
		
		switch(n / 10) {
		case 10 : //작성하지 않아도 fall through 이기 때문에 결과는 같다.
		case 9 : grade = 'A'; break;
		case 8 : grade = 'B'; break;
		case 7 : grade = 'C'; break;
		case 6 : grade = 'D'; break;
		}
			
		System.out.printf("점수 : %d, 학점 : %c%n", n, grade);
	}
	
	
	public void test2() {
		String menu = "=======================\n"
					+ "a. 된장찌개 ------- 5000원\n"
					+ "b. 김치찌개 ------- 6000원\n"
					+ "c. 순대국  ------- 7000원\n"
					+ "=======================\n"
					+ "선택 : ";
		System.out.println(menu);
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		
		String menuName = "";
		int price = 0;
		
		switch(choice) {
		case 'a' :
			menuName = "된장찌개";
			price = 5000;
			break;
			
		case 'b' :
			menuName = "김치찌개";
			price = 6000;
			break;
			
		case 'c' :
			menuName = "순대국";
			price = 7000;
			break;
		default : 
			System.out.println("잘못 선택 하셨습니다.");
			return;
		}
		System.out.printf("%s를 선택하셨습니다. %n가격은 %d원 입니다.%n",menuName,price);
	}
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.print("과일을 선택하세요 \n"
				+ "1. 사과 (500원) 2. 바나나 (700원) 3. 키위 (600원) 4. 아보카도(1300원) \n > ");
		
		int num = sc.nextInt();
		
		// 변수 선언과 초기화
		// 값 대입 하지 않고 선언만 하게되는경우 - initiallize 오류 발생
		String fruitName = " ";
		int price = 0;
		
		switch(num) {
		case 1 : 
			fruitName = "사과";
			price = 500;
			break; 
		case 2 : 
			fruitName = "바나나";
			price = 700;
			break; 		
		case 3 : 
			fruitName = "키위";
			price = 600;
			break; 
		case 4 : 
			fruitName = "아보카도";
			price = 1300;
			break;
		default : 
			System.out.println("잘못된 번호입니다.");
			return; //조기리턴 : 현재 메소드 호출부로 돌아간다. > Main의 study.test1() 으로
		}
//		문자열 값 비교는 equals메소드를 사용할 것
//		if(price != 0 && " ".equals(fruitName)) {
//		System.out.printf("%s를 선택하셨네요~%n",fruitName); 
//		System.out.printf("%d원입니다.%n",price);
//		}
		System.out.printf("%s를 선택하셨네요~%n",fruitName); 
		System.out.printf("%d원입니다.%n",price);
	}
}
