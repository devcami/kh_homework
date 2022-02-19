package ncs.test1;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("5개의 점수를 입력하시오 (예 100 90 80 70 60) : ");
		String score = sc.nextLine();
		String[] splitArr = score.split(" ");
		//5개보다 적거나 많게 입력한 경우 종료
		if(splitArr.length > 5 || splitArr.length < 5) {
			System.out.println("다시 입력하세요.");
		}
		//String[] -> int[]
		int[] scoreArr = new int[splitArr.length];
		outer :
		for(int i = 0; i < scoreArr.length; i++) {
			scoreArr[i] = Integer.parseInt(splitArr[i]);
			//하나라도 10~99 사이의 정수가 아닌경우 종료
			if(scoreArr[i] < 10 || scoreArr[i] > 100) {
				System.out.println("다시 입력하세요.");
				break outer;
			}
		}
		
		double scoreResult = (((scoreArr[0] + scoreArr[1]) / 2) * 0.6)
					  + (((scoreArr[2] + scoreArr[3]) / 2) * 0.2)
					  +   (scoreArr[4] * 0.2);
		String classResult;
		
		if(scoreResult >= 90) 
			classResult = "Gold Class";
		else if(scoreResult >= 80 && scoreResult < 90) 
			classResult = "Silver Class";
		else if(scoreResult >= 70 && scoreResult < 80) 
			classResult = "Bronze Class";	
		else
			classResult = "Normal Class";
		
		System.out.println("-----------------------");
		System.out.println("평가점수 : " + scoreResult + "점");
		System.out.println("Class : " + classResult);
		System.out.println("-----------------------");
	}
		

}
