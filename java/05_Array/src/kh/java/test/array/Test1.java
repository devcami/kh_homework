package kh.java.test.array;

public class Test1 {
	
	public static void main(String[] args) {
		Test1 ts = new Test1();
		ts.test();
	}
	public void test() {
		int[] arr = new int[100];
		
//		for(int i = 0; i < arr.length; i++) {
//			arr[i] += (i + 1);
//			System.out.println(arr[i]);
//		}
		
		//for each 출력
		for(int i : arr) {
			arr[i] += ( i + 1 );
			System.out.println(arr[i]);
		}
	}

}
