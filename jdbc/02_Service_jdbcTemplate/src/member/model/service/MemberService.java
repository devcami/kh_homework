package member.model.service;

import static common.JdbcTemplate.close;
import static common.JdbcTemplate.commit;
import static common.JdbcTemplate.getConnection;
import static common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import member.model.dao.MemberDao;
import member.model.vo.Member;

/**
 *  ServiceClass
 *  
 * 	- Dao에서 중복된 코드가 너무 많고, 일이 너무 많아 Service와 쪼개서 하도록 한다.
 * 	Service 시작
 * 	1. 드라이버클래스 등록
 *  2. Connection객체 생성(setAutoCommit(false))
 *  ---------------------------------------------- 
 *  Dao 시작
 *      3. PreparedStatement객체 생성(미완성 sql 값대입)
 *      4. 실행 및 ResultSet처리
 *      5. 자원반납(pstmt, rset)
 *  Dao 끝
 *  ----------------------------------------------
 *  6. 트랜잭션처리
 *  7. 자원반납 (conn)
 *	Service 끝
 *
 *	import static common.JdbcTemplate.*; !!!!
 *	 -> static method 호출 시 static Class 매번 언급할 필요 X
 */
public class MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	/**
	 * mainMenu_2
	 * DQL All Member Info
	 * @return list:Member
	 */
	public List<Member> selectAll() {
		//1. Connection 생성
		Connection conn = getConnection();
		//2. dao요청
		List<Member> list = memberDao.selectAll(conn);
		//3. 자원반납
		close(conn);
		
		return list;
	}
	
	/**
	 * mainMenu_2
	 * DQL One Member Info
	 * @return member:Member
	 */
	public Member selectOne(String id) {
		Connection conn = getConnection();
		Member member = memberDao.selectOne(conn, id);
		close(conn);
		return member;
	}
	
	/**
	 * mainMenu_3
	 * DQL Service
	 * @return list:Member
	 */
	public List<Member> findMemberByName(String name) {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. dao요청
		List<Member> list = memberDao.findMemberByName(conn, name);
		// 3. 자원반납
		close(conn);
		return list;
	}
	
	/**
	 * mainMenu_4
	 * DML insert Service
	 * @return result:int
	 */
	public int insertMember(Member member) {
		int result = 0;
		// 1. Connection 생성(가져오기)
		Connection conn = getConnection();
		
		try {
			// 2. dao요청
			result = memberDao.insertMember(conn, member);
			// 3. 트랜잭션처리
			commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			// 4. 자원반납
			close(conn);
		}
		
		return result;
	}

	
	/**
	 * mainMenu_6
	 * DML delete Service 
	 * @return result:int
	 */
	public int deleteMember(Member member) {
		int result = 0;
		Connection conn = getConnection();
		
		try {
			result = memberDao.deleteMember(conn, member);
			commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(conn);
		}
		
		return result;
	}

	/**
	 * mainMenu_5
	 * DML update Service 
	 * @return result:int
	 */
	//5.1
	public int updateName(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.updateName(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	//5.2
	public int updateBirthday(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.updateBirthday(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}

	//5.3
	public int updateEmail(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.updateEmail(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	//5.4
	public int updateAddress(Member member) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = memberDao.updateAddress(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return result;
	}
	
	
	
	
	
	
	
//	public int insertMember(Member member) {
//		Connection conn = null;
//		int result = 0; 
//		try {
//			//1. 드라이버 클래스 등록
//			Class.forName(driverClass);
//			
//			//2. Connection 객체 생성 (setAutoCommit(false))
//			conn = DriverManager.getConnection(url, user, password);
//			conn.setAutoCommit(false);
//			
//			//3. Dao 요청 및 리턴
//			result = memberDao.insertMember(conn, member); 
//			
//			//4. 트랜잭션 처리
//			conn.commit();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			try {
//				conn.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		} finally {
//			//5. 자원반납
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		return result;
//	}
	
}
