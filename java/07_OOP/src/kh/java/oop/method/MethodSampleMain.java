package kh.java.oop.method;

public class MethodSampleMain {
	int a = 100;
	
	public static void main(String[] args) {
		
		// a를 쓰고싶다면 ?
		//1. static field : static int a field로 변환
		//2. 객체생성 : MethodSampleMain main = new MethodSampleMain(); main.a로 사용
		
		//non-static method 호출
		MethodSample sample = new MethodSample();
		sample.x();
		
		//static method 호출
		MethodSample.y(); 
	}

}
