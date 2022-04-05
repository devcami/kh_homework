package kh.java.array.sort;

import java.util.Arrays;
import java.util.Random;

public class ArraySortStudy3 {
	
	public static void main(String[] args) {
		ArraySortStudy3 study = new ArraySortStudy3();
		study.test1();
	}
	
	/**
	 * 선택정렬
	 */
	public void test1() {
		Random rnd = new Random();
		int[] arr = new int[6];
		
		outer:
		for(int i = 0;;) {
			arr[i] = rnd.nextInt(45) + 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] == arr[i])
					continue outer;
			}
			i++;
			
			if(i == arr.length)
				break;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println();
		System.out.println();
		
		
		for(int i = 0; i < arr.length - 1; i++) {
			int min = i;
			
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j])
					min = j;
				System.out.println(Arrays.toString(arr));
			}
			swap(arr, min, i);
			System.out.println();
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
