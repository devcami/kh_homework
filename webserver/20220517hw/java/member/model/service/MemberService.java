package member.model.service;

import static common.JdbcTemplate.*;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;

import java.sql.Connection;

import member.model.dao.MemberDao;
import member.model.dto.Member;

/**
 *
 * 1. connection 생성
 * 2. dao요청 (connection 객체 전달)
 * 3. dml경우 transaction 처리
 * 4. 자원반납 (connection)
 * 5. controller(Servlet)으로 특정 값 반환처리
 *
 */
public class MemberService {

	private MemberDao memberDao = new MemberDao();
	
	public Member findByMemberId(String memberId) {
		Connection conn = getConnection();
		Member member = memberDao.findByMemberId(conn, memberId);
		close(conn);
		return member;
	}

	public int enrollMember(Member member) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = memberDao.enrollMember(conn, member);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public int updateMember(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.updateMember(conn, member);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e; //controller 통보용
		} finally {
			close(conn);
		}
		return result;
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = memberDao.deleteMember(conn, memberId);
			commit(conn);
		} catch(Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

}
