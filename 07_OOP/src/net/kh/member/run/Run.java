package net.kh.member.run;

import net.kh.member.model.Member;

public class Run {

	public static void main(String[] args) {
		Member member = new Member();
		
		member.setMemberId("id123");
		member.setMemberPwd("password123");
		member.setMemberName("홍길동");
		member.setAge(22);
		member.setGender('남');
		member.setPhone("01012345678");
		member.setEmail("id123@gmail.com");
		
		System.out.printf("ID : %s%n"
						+ "Password : %s%n"
						+ "Name : %s%n"
						+ "age : %d세%n"
						+ "gender : %c자%n"
						+ "phone number : %s%n"
						+ "email : %s%n"
						, member.getMemberId()
						, member.getMemberPwd()
						, member.getMemberName()
						, member.getAge()
						, member.getGender()
						, member.getPhone()
						, member.getEmail());
	}

}
