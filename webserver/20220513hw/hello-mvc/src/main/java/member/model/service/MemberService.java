package member.model.service;

import static common.JdbcTemplate.*;

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

}
