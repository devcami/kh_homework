package ncs.test5;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TestScore {

	public static void main(String[] args) {
		double [][] score = new double [3][5];
		Scanner sc = new Scanner(System.in);
		
		
		for(int i = 0; i < score.length; i++) {
			double total = 0;
			double avr = 0;
			System.out.println("-----" + ( i + 1 ) + "번입력-----");
			
			for(int j = 0; j < score[i].length; j++) {
				if(j < 3) {
					System.out.print("과목" + (j+1) + " 점수 >> ");
					score[i][j] = sc.nextDouble();
					total += score[i][j];
					avr = total / 3;
				}
				else if(j == 3) {
					score[i][j] = total;
				}
				else {
					score[i][j] = avr;
				}
			}
		}
		//출력
		DecimalFormat df = new DecimalFormat("0.0");
		
		System.out.println("index\t과목1\t과목2\t과목3\t총점\t평균");
		for(int i = 0; i < score.length; i ++) {
			System.out.print(i + "\t");
			for(int j = 0; j < score[i].length; j++) {
					System.out.print(df.format(score[i][j]) + "\t");
			}
			System.out.println();
		}
	
	}

}
