package com.kh.test.multi.dimentional.array.test;

import java.util.Random;

public class Sample {
	public static void main(String[] args) {
		Sample ts = new Sample();
//		ts.exercise1();
//		ts.exercise2();
		ts.exercise3();
		
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
	public void exercise3() {
		//3행 4열
		//0행 0열부터 2행 2열까지 : 랜덤값
		//각 행 3열 : 각행의 0,1,2 열의 합
		
		int[][] arr = new int[3][4];
		for(int i = 0; i < arr.length; i++) {
			// 3열 값 : 행마다 초기화시킨다.
			int rowSum = 0;
			
			for(int j = 0; j < arr[i].length; j++) {
				int rnd = (int)(Math.random()*100 + 1);
				
				//0 1 2열
				if(j != arr[i].length - 1) { // 3열이 아니라면
					arr[i][j] = rnd;		  // 0,1,2에 랜덤값 3개를 넣고
					rowSum += rnd; 			  // 3개의 합을 더해라
				}
				//3열
				else { 
					arr[i][j] = rowSum;
				}
			}			
		}
		//값 읽기
		String header = "\t0열\t1열\t2열\t3열\n" + 
						"-----------------------------------------------------------";
		System.out.println(header);
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "행\t");
			
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
