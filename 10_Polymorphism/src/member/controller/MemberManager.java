package member.controller;

import member.model.vo.Member;


public class MemberManager {
	
	private final int MAX_MEMBER = 40;
	Member[] members = new Member[MAX_MEMBER];

	private int index = 0;
	
	
	public void insertMember(Member member) {
		if(index == MAX_MEMBER) { 
			System.out.println("더이상 입력할 수 없습니다.");
			return;
		}
		members[index++] = member;
		
	}
	public void printData() {
		System.out.println("---------------<<회원정보>>---------------");
		System.out.println("이름\t등급\t\t포인트\t이자포인트");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i < index; i++) {
			System.out.println(members[i].getMemberInfo());
		}
		System.out.println("----------------------------------------");
	}
	
	public void printBuyInfo(int price) {

		for(int i = 0; i < index; i++) {
			System.out.println(members[i].getBuyInfo(price));
		}
	}

}
