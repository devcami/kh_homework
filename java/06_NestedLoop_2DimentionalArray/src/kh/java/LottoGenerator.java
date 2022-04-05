package kh.java;

import java.util.Arrays;
import java.util.Random;

import kh.java.array.sort.ArraySortStudy;


public class LottoGenerator {
	
	/**
	 * 1 ~ 45사이의 랜덤한 수 6개 뽑기
	 *  - 중복이 없는 난수 6개 
	 *  - 오름차순 정렬 처리
	 *  
	 * @param args
	 */

	public static void main(String[] args) {
		LottoGenerator lottoGenerator = new LottoGenerator();
		int[] lotto = lottoGenerator.generate();
		
		System.out.println(Arrays.toString(lotto));
		
		
	}
	public int[] generate() {

		int[] lotto = new int[6];
		
		//중복이 없는 난수 6개
		Random rnd = new Random();
		
		outer :
		for(int i = 0;;) { // 중복이 몇번 발생하냐에 따라서 반복 횟수가 바뀌기 때문에 무한반복으로 설정.
			int n = rnd.nextInt(45) + 1;
			
			//중복검사
			for(int j = 0; j < i; j++) {
				if(lotto[j] == n)
					continue outer;
			}
			
			lotto[i++] = n;
			
			if(i == lotto.length) 
				break;
			
		}
		System.out.println(Arrays.toString(lotto));
		//오름차순 정리
		//선택정렬
		// j = 0 1 2 3 4
		for(int j = 0; j < lotto.length - 1; j++) {
			// 최소값을 j번지 수라고 가정
			int min = j;
			for(int k = j + 1; k < lotto.length; k++) {
				if(lotto[min] > lotto[k]) min = k;
//				System.out.println(Arrays.toString(lotto));
			}
			ArraySortStudy as = new ArraySortStudy();
			as.swap(lotto, min, j);
			

		}
		
		//오름차순 정리
		//순차정렬
//		for(int m = 0; m < lotto.length - 1; m++) {
//			for(int l = m + 1; l < lotto.length; l++ ) {
//				if(lotto[m] > lotto[l]) 
//					as.swap(lotto, m, l);
//			}
//		}
		return lotto;
	}
	
}
