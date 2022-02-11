package member.controller;

import member.model.vo.Gold;
import member.model.vo.Silver;
import member.model.vo.VVip;
import member.model.vo.Vip;

public class MemberManager {
	private static final int LENGTH = 10;
	Silver[] silver = new Silver[LENGTH];
	Gold[] gold = new Gold[LENGTH];
	Vip[] vip = new Vip[LENGTH];
	VVip[] vvip = new VVip[LENGTH];
	
	private int sIndex = 0;
	private int gIndex = 0;
	private int vIndex = 0;
	private int vvIndex = 0;
	
	
	public void vipInsert(Vip v) {
		vip[vIndex++] = v;
	}
	public void vvipInsert(VVip vv) {
		vvip[vvIndex++] = vv;
		
	}
	public void silverInsert(Silver s) {
		silver[sIndex++] = s;
	}
	
	public void goldInsert(Gold g) {
		gold[gIndex++] = g;
	}
	
	public void printData() {
		System.out.println("---------------<<회원정보>>---------------");
		System.out.println("이름\t등급\t\t포인트\t이자포인트");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i < sIndex; i++) {
			Silver s = silver[i];
			System.out.printf("%s\t%s\t\t%d\t%.2f%n",
							s.getName(), s.getGrade(), s.getPoint(), s.getInterest());
		}
		for(int i = 0; i < gIndex; i++) {
			Gold g = gold[i];
			System.out.printf("%s\t%s\t\t%d\t%.2f%n",
					g.getName(), g.getGrade(), g.getPoint(), g.getInterest());
		}
	}

}
