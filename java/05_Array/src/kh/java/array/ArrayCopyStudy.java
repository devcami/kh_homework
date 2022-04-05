package kh.java.array;

/**
 * 얕은복사 : 참조 주소값만 복사. heap의 배열 객체를 공유
 * 깊은복사 : 동일한 값을 가진 배열 객체를 heap에 하나 더 생성
 */
public class ArrayCopyStudy {
	
	public static void main(String[] args) {
		ArrayCopyStudy study = new ArrayCopyStudy();
//		study.test1();
//		study.test2();
//		study.test3();
//		study.test4();
		study.test5();
	}
	/**
	 *  System.arraycopy를 이용해 배열 복사 합치기.
	 */
	public void test5() {
		int[] a = {1, 2, 3};
		int[] b = {4, 5, 6};
		int[] c = {7, 8, 9, 10};
		int[] d = new int[10];
		
		int start = 0;
		System.arraycopy(a, 0, d, start, a.length);
		start += a.length;
		System.arraycopy(b, 0, d, start, b.length);
		start += b.length;
		System.arraycopy(c, 0, d, start, c.length);
		
		for(int i : d) {
			System.out.print(i + " ");
		}
	}
	/**
	 * 깊은 복사
	 * 3. clone 
	 */
	public void test4() {
		int[] arr1 = new int [] {1,2,3};
		int[] arr2 = arr1.clone();
		
		printArr(arr1, arr2);
		System.out.println(diffHashCode(arr1, arr2));
		
	}
	
	/**
	 * 깊은 복사
	 * 2. System.arraycopy
	 * void arraycopy(Object src, int srcPos,Object dest, int destPos, int length);
	 * source 배열의 scrPosition번지 부터 destination 배열의 destPos번지 까지 length개 복사한다
	 */
	public void test3() {
		int[] arr1 = new int [] {1,2,3};
		int[] arr2 = new int[arr1.length];
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);
		
		printArr(arr1, arr2);
		System.out.println(diffHashCode(arr1, arr2));
		
		int[] arr3 = new int[10];
		
		System.arraycopy(arr1, 0, arr3, 4, 2);
		
		for(int i : arr3)
			System.out.print(i + " ");

		
		
	}
	
	/**
	 * 깊은 복사 (3가지) 
	 * 1. 직접복사
	 */
	public void test2() {
		int[] arr1 = {1,2,3};
		int[] arr2 = new int[arr1.length];
		
		
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}

		arr1[1] *= 100;
		
		printArr(arr1,arr2);	
		System.out.println(diffHashCode(arr1, arr2));
	}
	
	/**
	 * 얕은 복사
	 */
	public void test1() {
		
		int[] arr1 = {1, 2, 3};
		int[] arr2 = arr1;
		
		arr1[1] *= 100; //arr2[1]도 100으로 바뀐다.
		
		printArr(arr1,arr2);	
		
		System.out.println(diffHashCode(arr1, arr2));
	
	}
	
	public void printArr(int[] arr1, int[] arr2) {
		for(int i = 0; i < arr1.length; i++)
			System.out.printf("%d : %d ,%d%n", i , arr1[i], arr2[i]);	
	}
	
	public boolean diffHashCode(int[] arr1, int[] arr2) {
		System.out.println(arr1.hashCode());
		System.out.println(arr2.hashCode());
		return arr1 == arr2; //참조 주소값 비교
	}

}
