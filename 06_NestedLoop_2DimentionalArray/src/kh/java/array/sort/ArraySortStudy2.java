package kh.java.array.sort;

import java.util.Arrays;
import java.util.Random;

public class ArraySortStudy2 {
	
	public static void main(String[] args) {
		ArraySortStudy2 study = new ArraySortStudy2();
		study.test1();
	}
	
	/**
	 * 순차정렬 : 오름차순 / 내림차순
	 */
	public void test1() {
		int[] arr = new int[6];
		Random rnd = new Random();
		
		outer : 
		for(int i = 0;;) {
			arr[i] = rnd.nextInt(45) + 1;
			
			for(int j = 0; j < i; j++) {
				if(arr[j] == arr[i]) 
					continue outer;
			}
			i++;
			
			if(i == arr.length) break;
		}
		print(arr);
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < arr.length - 1 ; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					swap(arr , i, j);
				}
				print(arr);
			}
			System.out.println();
		}
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public void print(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

}
