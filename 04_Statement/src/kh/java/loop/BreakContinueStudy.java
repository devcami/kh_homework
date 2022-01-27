package kh.java.loop;

public class BreakContinueStudy {
	public static void main(String[] args) {
		BreakContinueStudy study = new BreakContinueStudy();
//		study.test1();
		study.test2();
	}
	
	/**
	 * continue
	 *  - 반복문의 이하 코드를 실행하지 않고, 다시 반복문을 시작.
	 *  - for문 : 증감식으로 이동 후 재시작
	 *  - while문 : 조건식으로 이동 후 재시작
	 *  - while문주의 : continue 밑에 증감식을 위치시켜서는 안된다 !
	 *  
	 */
	//1 ~ 20까지의 홀수만 출력
	public void test2() {
//		for(int i = 1; i <= 20; i++) {
//			if(i % 2 == 0)
//				continue;
//			System.out.println(i);
//		}
		int i = 0;
		while(i < 20) {
			i++;
			if(i % 2 == 0)
				continue;
			System.out.println(i);
		}
	}
	
	/**
	 * break
	 *  - 실행시 반복문 블럭 탈출(중지)
	 *  
	 */
	public void test1() {
		int i = 1;
		while(i <= 10) {
			System.out.println(i++); // 출력 후 i++
			if(i > 5) {
				break; // 반복문 탈출 (while)
			}
		}
		System.out.println();
		
		// 1부터 n까지의 합 : 무한반복 사용
		int j = 1;
		int n = 10;
		int sum = 0;
		
		while(true) {
			sum += j;
			if(j == n) {
				break;
			}
			j++;
		}
		System.out.println(sum);
	}

}
