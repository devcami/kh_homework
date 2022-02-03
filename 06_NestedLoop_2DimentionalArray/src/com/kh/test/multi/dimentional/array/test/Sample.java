package com.kh.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
	public static void main(String[] args) {
		Sample ts = new Sample();
//		ts.exercise1();
		ts.exercise2();
	}
	public void exercise1() {
		int[][] arr = new int[3][5];
		Random rnd = new Random();
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				arr[i][j] = rnd.nextInt(100) + 1;
			}
		}
		
		//값이 5의 배수인 경우 (행,열)
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] % 5 == 0) {
					System.out.printf("(%d행, %d열) = %d%n", i, j, arr[i][j]);
				}
			}
		}
	}
	public void exercise2() {
		int[][] arr = new int[3][4];
		
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length ; j++) {
				arr[i][j] = (int)(Math.random()*100 + 1);
				
				// j = 4 (행의 마지막값 일 때) - 각 행의 값들의 합
				if(j == arr[0].length - 1) {
					for(int k = 0; k < arr.length; k++) {
							arr[k][arr[0].length - 1] += arr[i][j];
					}
				}
			}
			
		}
		
		//출력
		for(int[] ar : arr) {
			for(int a : ar) {
				System.out.print( a + " ");
			}
			System.out.println();
		}
		
	}

}
