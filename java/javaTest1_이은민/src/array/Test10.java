package array;

import java.util.Arrays;

public class Test10 {
	public static void main(String[] args) {
		int[][] array = {{12, 41, 36, 56}, {82, 10, 12, 61}, {14, 16, 18, 78}, {45, 26, 72, 23}};
		int[] copyAr = new int[array.length * array[0].length];
		
		int a = 0;
		
		for(int i = 0; i < array.length; i++) {

			inner : 
			for(int j = 0; j < array[i].length; j++) {
				
				// 3의배수일때
				if(array[i][j] % 3 == 0) {
					//copyAr에 전에 담긴 값과 같은지 확인
					for(int k = 0; k < copyAr.length; k++) {
						//같으면 j++ 로 돌아가서 j for문 처음부터 다시
						if(copyAr[k] == array[i][j])
							continue inner;
					}
					//전에 담긴 값과 다르면 a번째에 저장 a는 증가 
					copyAr[a] = array[i][j];
					a++;
				}
			}
		}
		
		//출력
		System.out.print("copyAr : ");
		for(int copy : copyAr) {
			//0은 출력안함
			if(copy == 0) continue;
			
			System.out.print(copy + " ");
			
		}
		
	}

}
