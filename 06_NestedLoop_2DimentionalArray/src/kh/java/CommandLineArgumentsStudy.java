package kh.java;

public class CommandLineArgumentsStudy {
	
	/**
	 *  프로그램 실행시에 사용자 입력값 받아서 처리하기
	 *  - 하나의 문자열 형태로 입력
	 *  - 공백을 기준으로 잘라서 String[] 형태로 main메소드의 매개인자로 전달한다.
	 */
	public static void main(String[] args) {
//		CSV data (Comma Separated Value : 콤마로 구분된 값)
		
//		String data = "안녕 잘가 123 abc"; 
//		String[] arr = data.split(" "); //return type : String[]
//		for(int i = 0; i < arr.length; i++)
//			System.out.println(i + " : [" + arr[i] +"]");
		
//		System.out.println(args);
//		System.out.println(args.length);
//		for(int i = 0; i < args.length; i++) 
//			System.out.println(i + " : [" + args[i] +"]");
		
		CommandLineArgumentsStudy study = new CommandLineArgumentsStudy();
		study.test1(args);
	}
	
	/**
	 * 사용자 정보 출력
	 * - 이름 나이 성별 키 
	 * 
	 * - 홍길동 33 남 177.5
	 * @param args
	 */
	public void test1(String[] args) {
		String name = "";
		int age = 0;
		char gender = ' ';
		double height = 0.0;
		
		//args의 입력값은 모두 String으로 넘어오기 때문에 형변환 해준다.
		//형변환 메소드 자료형.parse자료형
		name = args[0];
		age = Integer.parseInt(args[1]); // String > Int
		gender = args[2].charAt(0); // String > char
		height = Double.parseDouble(args[3]); // String > double
		
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age + "세");
		System.out.println("성별 : " + gender + "자");
		System.out.println("키 : " + height + "cm");
	}

}
