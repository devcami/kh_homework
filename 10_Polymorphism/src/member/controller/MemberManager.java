package member.controller;

import member.model.vo.Member;


public class MemberManager {
	
	private final int MAX_MEMBER = 40;
	Member[] members = new Member[MAX_MEMBER];

	private int index = 0;
	
	
	public void insertMember(Member member) {
		
		members[index++] = member;
		
	}
	public void printData() {
		System.out.println("---------------<<회원정보>>---------------");
		System.out.println("이름\t등급\t\t포인트\t이자포인트");
		System.out.println("----------------------------------------");
		
		for(int i = 0; i < index; i++) {
			System.out.println(members[i].getName() + "\t" + members[i].getGrade() + "\t" + "\t"  +
							   members[i].getPoint() + "\t" + members[i].getEjaPoint() + "\t" );
		}
	}

}
