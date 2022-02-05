package kh.java;

public class VariableArgumentsStudy {
	
	public static void main(String[] args) {
		VariableArgumentsStudy study = new VariableArgumentsStudy();
//		study.test1(args);
		
		study.test2("안녕");
		study.test2("안녕",1,2,3);
		study.test2("안녕",30,35);
		study.test2("안녕",1,2,3,4,5,6,7,8,9,10);
		int[] arr = {1,2,3};
		study.test2("안녕",arr);
		
	}
	/**
	 * 가변인자
	 *  - 원래는 선언부, 호출부가 (갯수까지) 동일해야 실행된다.
	 *  - 같은 타입일때 n개 선언부 작성할때 사용
	 *  
	 *  - 매개변수 선언부에서 동일한 타입에 개수제한 없는 매개변수
	 *  - 매개변수가 여러개 일때 마지막에 한번만 사용 가능(String name, int ... arr)
	 *  - 가변인자를 처리할 매개변수는 배열로 사용이 가능함.
	 */
	public void test2(String name, int...arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
	
	/**
	 * 사용자 입력 정수값을 더해 출력하기
	 */
	public void test1(String[] args) {
		int sum = 0;
//		내 방법
//		for(int i = 0; i < args.length; i++) {
//			sum += Integer.parseInt(args[i]); 
//		}
		
		for(String s : args) {
			int n = Integer.parseInt(s);
			sum += n;
		}
		System.out.println(sum);
		
	}

}
