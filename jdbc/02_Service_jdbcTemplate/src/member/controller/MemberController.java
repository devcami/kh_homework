package member.controller;

import java.util.List;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Controller Class
 * - Service단에 업무요청 (어제처럼 Dao에 바로 전달 X)
 * 
 *
 */
public class MemberController {
	
	private MemberService memberService = new MemberService();

	// mainMenu_1	
	public List<Member> selectAll() {
		List<Member> list = memberService.selectAll();
		return list;
	}

	// mainMenu_2	
	public Member selectOne(String id) {
		Member member = memberService.selectOne(id);
		return member;
	}

	// mainMenu_3	
	public List<Member> findMemberByName(String name) {
		List<Member> list = memberService.findMemberByName(name);
		return list;
	}
	
	// mainMenu_4	
	public int insertMember(Member member) {
		int result = memberService.insertMember(member);
		return result;
	}
	
	// mainMenu_6
	public int deleteMember(Member member) {
		int result = memberService.deleteMember(member);
		return result;
	}
	
	// mainMenu_5.1
	public int updateName(Member member) {
		int result = memberService.updateName(member);
		return result;
	}

	// mainMenu_5.2
	public int updateBirthDay(Member member) {
		int result = memberService.updateBirthday(member);
		return result;
	}

	// mainMenu_5.3
	public int updateEmail(Member member) {
		int result = memberService.updateEmail(member);
		return result;
	}

	// mainMenu_5.4
	public int updateAddress(Member member) {
		int result = memberService.updateAddress(member);
		return result;
	}
}
