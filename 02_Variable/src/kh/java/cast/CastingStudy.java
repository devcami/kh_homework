package kh.java.cast;


/**
 * 컴퓨터 연산 원리
 * 1. 값 (literal)은 같은 타입의 변수에만 대입할 수 있다.
 * 2. 같은 타입끼리만 연산할 수 있다.
 * 3. 같은 타입간 연산 결과 값의 타입 또한 동일하다.
 */
public class CastingStudy {
	
	public static void main(String[] args) {
		CastingStudy study = new CastingStudy();
		study.test1();
		study.test2();
		study.test3();
		
	}
	/**
	 * 연산간 자동 형변환
	 * 
	 * >	크다			gt / greater than 
	 * <	작다			lt / less than
	 * >=	크거나 같다	ge / greater than or equal to
	 * <=	작거나 같다	le / less than or equal to
	 * 
	 * ==	같다
	 * != 	같지 않다
	 * 
	 */
	public void test3() {
		// true / false 로 평가될 수 있는 어떤 계산식
		boolean bool = 5 > 2; //true
		
		bool = ( 5 / 2 ) == 2.0; // (int/int) == double  / 2 == 2.0 / int가 double로 바뀌어서 연산된다.
		// 연산식을 먼저 계산 한 후에 그에 대한 답을 변수에 대입한다.
		// 5/2는 2.0과 같은가? 의 답을 bool에 대입한다.
		System.out.println(bool); //true
		
		bool = 'C' ==67; // (char == int / char가 int로 바뀌어서 연산된다.)
		System.out.println(bool); 
		
		bool = 'A'+2 == 'B'+1; // char + int == char + int
		System.out.println(bool); 
		
		System.out.println(">" + !true); 
		System.out.println(">" + !false);
		
		bool = 'a' != 98; 
		System.out.println(bool); 
		
	}
	/**
	 * 명시적 형변환 (강제 형변환)
	 * 	- 형 변환에 따라 값이 유실될 수 있다.
	 * 	- 큰 값을 작은 공간에 담는 상황 /반대 상황도 강제로 가능
	 */
	public void test2() {
		// 1. 작은 타입으로 형변환
		int num = (int) 3.7; //double을 int로 강제 형변
		System.out.println(num);
		
		// 2. 큰 타입으로 형변환
		int k = 10;
		int m = 3;
		System.out.println(k / m); //int / int -> int (몫)
		System.out.println( ((double)k) / m); // double / int(double로 자동형변환) -> double (몫)
		
		int i = Integer.MAX_VALUE;
		System.out.println((long)i + 1); // long + int(long으로 자동형변환) -> long (몫)
		System.out.println(i + 1L);
		
		//3. 예외적인 형변환
		// byte, short, char (int보다 작은 자료형) 연산 시 자동으로 int로 변환되어 처리
		byte b1 = 10;
		byte b2 = 20;
		byte b3 = (byte)(b1 + b2); // byte + byte => int + int 
		
		//int 값에 char에 명시적 형변환 없이 대입가능
		char ch = 97; //int값 -> char공간
		System.out.println(ch);
		
	}
	
	
	/**
	 * 암묵적 형변환 (자동 형변환)
	 * 	- 형 변환에 따라 값을 유실하지 않는다.
	 * 	- 작은 값을 큰 공간에 담는 상황
	 * 	-(long -> float) 실수는 지수 표현식 방식으로 적은 공간에서 훨씬 많은 수를 표현할 수 있다.
	 * byte(1) -> short(2) -> int(4) -> long(8) -> float(4) -> double(8)
	 * 			  char(2)
	 */
	public void test1() {
		//다른 타입끼리 연산하는 경우, 크기가 큰 타입으로 자동 형변환 된다.
		System.out.println( 1 + 3.3 ); //int + double > double형으로 자동 형변환
		
		//다른 타입의 변수에 값 대입 하는 경우 (대입연산도 연산)
		double d = 3; //double 변수에 int 값 넣기 > double형으로 자동 형변환
//		double d = 3.0;
		System.out.println(d);
		
		char ch = 'a';
		int aNum = ch; //aNum 공간에 ch 값을 대입한다.
		System.out.println(aNum); //97 , char 'a' > int형(ascii table)으로 자동 형변환
		
		//char는 정수형과는 숫자연산, 문자열과는 문자열 더하기 연산처리 된다.
		System.out.println(ch + 100); //197
		System.out.println(ch + "A"); //aA
	}
}
