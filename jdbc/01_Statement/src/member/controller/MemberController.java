package member.controller;

import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberController {
	
	private MemberDao memberDao = new MemberDao();
	/**
	 * 사용자의 회원가입 요청을 처리하는 메소드
	 * 1. Dao에 회원가입 요청 후 int반환받음(DML)
	 * 2. 반환받은 int를 Menu에 다시반환
	 */
	public int insertMember(Member newMember) {
		int result = memberDao.insertMember(newMember);
		System.out.println("result@MemberController = " + result);
		return result;
	}
	
	/**
	 * Dao에서 List를 리턴받는다. 
	 */
	public List<Member> selectAll() {
		List<Member> list = memberDao.selectAll();
		return list;
	}
	
	/**
	 * 사용자의 입력 id를 받아 검색 처리하는 메소드
	 * 1. Dao에 ID 전달 후 member반환받음
	 * 2. 반환받은 member를 Menu에 다시 반환 
	 */
	public Member selectOne(String id) {
		Member member = memberDao.selectOne(id);
		return member;
	}
	
	/**
	 * 사용자의 입력 name을 받아 검색 처리하는 메소드
	 * 1. Dao에 name 전달 후 member반환받음
	 * 2. 반환받은 member를 Menu에 다시 반환
	 */
	public Member searchName(String name) {
		Member member = memberDao.searchName(name);
		return member;
	}
	/**
	 * 사용자의 입력 id를 가진 객체를 받아 업데이트 처리하는 메소드
	 * 1. Dao에 id 전달 후 반환받은 member를 사용하여 Dao에 member전달
	 * 2. 반환받은 결과가 1이면 수정 행 O  0이면 삭제 행 X
	 */
	public int updateMemberInfo(Member updateMember) {
		int result = memberDao.updateInfo(updateMember);
		return result;
	}

	/**
	 * 사용자의 입력 id를 가진 객체를 받아 삭제처리하는 메소드 
	 * 1. Dao에 id 전달 후 반환받은 member를 사용하여 Dao에 member전달
	 * 2. 반환받은 결과가 1이면 삭제 행 O  0이면 삭제행 X
	 */
	public int deleteMemberInfo(Member deleteMember) {
		int result = memberDao.deleteMemberInfo(deleteMember);
		return result;
	}

}
