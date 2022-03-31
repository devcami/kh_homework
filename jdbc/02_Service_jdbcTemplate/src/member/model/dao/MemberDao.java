package member.model.dao;

import static common.JdbcTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;


public class MemberDao {
	/**
	 * mainMenu_1
	 * DQL - select All member
	 * @param conn
	 * @return list : Member
	 */
	public List<Member> selectAll(Connection conn) {
		List<Member> list = new ArrayList<Member>();
		String sql = "select * from member";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			//1. PreparedStatement 객체 생성 (미완성sql 전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			//2. 실행
			rset = pstmt.executeQuery();
			//3. ResultSet처리
			while(rset.next()) {
				Member member = new Member();
				member.setId(rset.getString("id"));
				member.setName(rset.getString("name"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setAddress(rset.getString("address"));
				member.setRegDate(rset.getTimestamp("reg_date"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4. 자원반납
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	/**
	 * mainMenu_2
	 * DQL - select One member
	 * @param conn
	 * @return member
	 */
	public Member selectOne(Connection conn, String id) {
		String sql = "select * from member where id = ?";
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				member = new Member(id, name, gender, birthday, email, address, regDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return member;
	}
	
	/**
	 * mainMenu_3
	 * DQL - select some member name like ?
	 * @param conn, name
	 * @return list : Member 
	 */
	public List<Member> findMemberByName(Connection conn, String name) {
		String sql = "select * from member where name like ?";
		List<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			//1. PreparedStatement 객체 생성(미완성 sql전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"%" + name + "%");
			//2. 실행
			rset = pstmt.executeQuery();
			
			//3. ResultSet처리 -> 한행씩 Member객체로 변환 후 리스트에 추가
			while(rset.next()) {
				Member member = new Member();
				member.setId(rset.getString("id"));
				member.setName(rset.getString("name"));
				member.setGender(rset.getString("gender"));
				member.setBirthday(rset.getDate("birthday"));
				member.setEmail(rset.getString("email"));
				member.setAddress(rset.getString("address"));
				member.setRegDate(rset.getTimestamp("reg_date"));
				
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//4. 자원반납(pstmt, rset)
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	/**
	 * mainMenu_4
	 * DML - insert member
	 * @param conn, member
	 * @return result
	 */
	public int insertMember(Connection conn, Member member) {
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			//1. PreparedStatement 생성(미완성 sql전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			pstmt.setDate(4, member.getBirthday());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getAddress());
			
			//2. 실행 및 resultSet처리-DQL
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// checked예외는처리가 어렵다.. 
			// -> Unchecked예외로 바꿔서 던진다
			//원래 발생한 예외를 전환(감싸서)해서 호출한 쪽에 던져준다 -> service transaction처리용
			throw new RuntimeException(e); 
		} finally {
			//3. 자원반납(pstmt, rset반납-DQL) *주의* conn반납XX 트랜잭션 처리 전 입니다~
			close(pstmt);
		}
		
		return result;
	}

	
	/**
	 * mainMenu_6
	 * DML - delete member
	 * @param conn, member
	 * @return result
	 */
	public int deleteMember(Connection conn, Member member) {
		String sql = "delete from member where id = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt);
		}
	
		return result;
	}

	/**
	 * Update 
	 * @param conn
	 * @param member
	 * @return
	 */
	//5.1 upate name
	public int updateName(Connection conn, Member member) {
		String sql = "update member set name = ? where id = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	//5.2 update birthday
	public int updateBirthday(Connection conn, Member member) {
		String sql = "update member set birthday = ? where id = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, member.getBirthday());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	//5.3 update email
	public int updateEmail(Connection conn, Member member) {
		String sql = "update member set email = ? where id = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getEmail());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt);
		}
		return result;
	}

	//5.4 update address
	public int updateAddress(Connection conn, Member member) {
		String sql = "update member set address = ? where id = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getAddress());
			pstmt.setString(2, member.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			close(pstmt);
		}
		return result;
	}

}
