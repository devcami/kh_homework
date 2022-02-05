package com.kh.test.star;

public class Test {
	public static void main(String[] args) {
		Test ts = new Test();
//		ts.test1();
//		ts.test2();
//		ts.test3();
//		ts.test4();
//		ts.test5();
//		ts.test6();
		ts.test7();
	
	}
	
	/**
	    *****
	 	****
 		***
 		**
 		*
	 */
	public void test1() {
		//행
		for(int i = 0; i < 5; i++) {
			//열
			for(int j = 5; j > i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	  	*
	  	**
	  	***
	  	****
	  	*****
	 */
	public void test2() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 		* 
	 	   **
	 	  ***
	 	 ****
	 	*****
	 */
	public void test3() {
			//행  (0 1 2 3 4)
		for(int i = 0; i < 5; i++) { 
			//공백 (4 3 2 1 0)
			for(int j = 4; j > i; j--) {
				System.out.print(" ");
			}
				
			//*	(0 1 2 3 4)
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 		* 
	 	   ***
	 	  *****
	 	 *******
	 	*********
	 	1 3 5 7 9
	 */
	
	public void test4() {
			//행 0 1 2 3 4
		for(int i = 0; i < 5; i++) {
			//공백 4 3 2 1 0
			for(int j = i; j < 5; j++) {
				System.out.print(" ");
			}
			//* 1 3 5 7 9
			for(int j = 0; j < i*2 + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 	*****
	 	  ***
	  		*
	 */
	public void test5() {
			//행 0 1 2
		for(int i = 0; i < 3; i++) {
			//공백 0 2 4
			for(int j = 0; j < i*2 ; j++) {
				System.out.print(" ");
			}
			//* 5 3 1 
			for(int j = (i*2) + 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 		*
	 	  ***
	 	*****
	 	  ***
	  		*
	 */
	public void test6() {
		int row = 5;
		
		
			//행 0 1 2
		for(int i = 0; i <= row / 2; i++) {
			int n = (2 * i) + 1;
			//증가 > 공백 4 2 0 , 별 1 3 5
			
			for(int j = row; j > n ; j--) {
				System.out.print(" ");
			}
			for(int j = 0; j < n ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
			//행 3 4 / i = 1 2
		for(int i = 1 ; i <= row / 2; i++) {
			int n = 2 * i;
			//감소 > 공백 2 4, 별 3 1
			for(int j = 0 ; j < n ; j++) {
				System.out.print(" ");
			}
			for(int j = n; j < row ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 	 	*
	 	   ***
	      *****
	 	   ***
	  		*
	 */
	public void test7() {
		int row = 5;

		//행 0 1 2
		for(int i = 0; i <= row / 2; i++ ) {
			// 공백 2 1 0
			for(int j = i; j < row / 2; j++) {
				System.out.print(" ");
			}
			// 별 1 3 5
			for(int j = 0; j < (i*2) + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//행 3 4 / i = 1 2
		for(int i = 1 ; i <= row / 2 ; i++) {
			// 공백 1 2
			for(int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			// 별 3 1
			for(int j = row; j >= (i*2) + 1 ; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
