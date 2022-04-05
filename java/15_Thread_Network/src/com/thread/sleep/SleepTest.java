package com.thread.sleep;

public class SleepTest {

	public static void main(String[] args) {
		SleepTest test = new SleepTest();
		test.sendAphorism();
	}

	public void sendAphorism() {
		//박명수 어록 10개
		String[] saying = {	"티끌모아 티끌", "늦었다고 생각할 때가 진짜 늦었다", "일찍 일어나는 새가 피곤하다",
							"감사의 표시는 돈으로 하라", "가는말이 고우면 얕본다", "고생끝에 골병난다",
							"지금 공부 안하면 더울 때 더운데서 일하고 추울 때 추운데서 일한다", "참을인이 세번이면 호구",
							"즐길 수 없으면 피하라", "사람이 배고플 때 뭐가 나온다"};
		
		for(int i = 0; i < saying.length; i++) {
			int rnd = (int)(Math.random() * 10); 
			System.out.println(saying[rnd]);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	

}
