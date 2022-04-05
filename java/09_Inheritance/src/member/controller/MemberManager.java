package member.controller;

import member.model.vo.Gold;
import member.model.vo.Silver;
import member.model.vo.Vip;
import member.model.vo.Vvip;

public class MemberManager {
	
	private final int MAX_MEMBER = 10;
	Silver[] silvers = new Silver[MAX_MEMBER];
	Gold[] golds = new Gold[MAX_MEMBER];
	Vip[] vips = new Vip[MAX_MEMBER];
	Vvip[] vvips = new Vvip[MAX_MEMBER];
	
	int silverIndex = 0;
	int goldIndex = 0;
	int vipIndex = 0;
	int vvipIndex = 0;
	
	public void silverInsert(Silver s) {
			silvers[silverIndex++] = s;
	}
	public void goldInsert(Gold g) {
			golds[goldIndex++] = g;
	}
	public void vipInsert(Vip v) {
			vips[vipIndex++] = v;
	}
	public void vvipInsert(Vvip vv) {
			vvips[vvipIndex++] = vv;
	}
	
	public void printData() {
		System.out.println("---------------<<회원정보>>---------------");
		System.out.println("이름\t등급\t\t포인트\t이자포인트");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i < silverIndex; i++) {
			Silver s = silvers[i];
			System.out.printf("%s\t%s\t\t%d\t%.2f%n",
					s.getName(), s.getGrade(), s.getPoint(), s.getEjaPoint());
		}
		for(int i = 0; i < goldIndex; i++) {
			Gold g = golds[i];
			System.out.printf("%s\t%s\t\t%d\t%.2f%n",
					g.getName(), g.getGrade(), g.getPoint(), g.getEjaPoint());
		}
		for(int i = 0; i < vipIndex; i++) {
			Vip v = vips[i];
			System.out.printf("%s\t%s\t\t%d\t%.2f%n",
					v.getName(), v.getGrade(), v.getPoint(), v.getEjaPoint());
		}
		for(int i = 0; i < vvipIndex; i++) {
			Vvip vv = vvips[i];
			System.out.printf("%s\t%s\t\t%d\t%.2f%n",
					vv.getName(), vv.getGrade(), vv.getPoint(), vv.getEjaPoint());
		}
	}

}
