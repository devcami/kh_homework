package kh.java.two_dimentional.array;

public class JaggedArrayStudy {
	
	public static void main(String[] args) {
		JaggedArrayStudy study = new JaggedArrayStudy();
		study.test1();
	}
	
	
	/**
	 *  가변배열
	 *  - 2차원 배열의 길이가 각각 다르다.
	 */
	public void test1() {
		
		// 1. 선언 : 1차원 배열까지 생성 [n][](공백)
		int[][] arr = new int[3][];
		
		// 2. 할당 : 2차원 배열은 행별로 각각 다른 길이의 배열 생성
		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[10];
		int v = 1;
		// 배열 출력해 담긴 값 확인 (0으로 초기화되어 있음)
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = v++;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
