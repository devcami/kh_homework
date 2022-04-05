package kh.java.oop.method;

/**
 * 재귀 메소드
 *	- 함수 안에서 스스로를 다시 호출해 작동
 *	- 종료 조건을 잘 명시하는 것이 중요
 */
public class RecursiveMethodStudy {

	public static void main(String[] args) {
		RecursiveMethodStudy study = new RecursiveMethodStudy();
		
		study.test1();
	}
	/**
	 * factorial
	 *  5! = 5 * 4 * 3 * 2 * 1
	 */
	
	public void test1() {
		int result = factorial(5);
		System.out.println(result);
	}
	public int factorial(int n) {
		//종료 조건
		if(n == 1)
			return 1;
		return n * factorial(n - 1);
	}

}
