package member.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import member.model.vo.Member;

public class MemberDao {
	
	String driverClass = "oracle.jdbc.OracleDriver"; // 드라이버 클래스명
	String url = "jdbc:oracle:thin:@DB202203101507_medium?TNS_ADMIN=Wallet_DB202203101507"; //접속할 db서버 주소 . db접속프로토콜@ip:port:sid
	String user = "student";
	String password = "Rkdtmddbs0121";
	
	/**
	 * DB에 접속, 쿼리를 실행하는 메소드
	 * 처리 결과 int를 controller에 반환 
	 */
	// DML용 DB접속
	public int insertMember(Member newMember) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
//		String sql = "insert into member values(newMember.getId() + "', '" ..... 귀찮아서 Statement안씀)";
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)"; //미완성쿼리
		
		try {
			// 1. driver class 등록
			Class.forName(driverClass);
			// 2. Connection 객체 생성(setAutoCommit(false))
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			// 3. PreparedStatement 객체 생성(미완성 쿼리 전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newMember.getId());
			pstmt.setString(2, newMember.getName());
			pstmt.setString(3, newMember.getGender());
			pstmt.setDate(4, newMember.getBirthday());
			pstmt.setString(5, newMember.getEmail());
			pstmt.setString(6, newMember.getAddress());
			
			// 4. Statement 실행 및 int 처리행수 반환
			result = pstmt.executeUpdate();
			
			// 5. Transaction처리
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			// 6. 자원 반납
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
	}
	
	/**
	 * DB에 접속
	 * member table의 모든 행을 리턴하는 메소드
	 * 처리결과 list를 controller에 전달
	 */
	public List<Member> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member order by reg_date desc";
		List<Member> list = new ArrayList<>();
		
		try {
			// 1. driver class 등록
			Class.forName(driverClass);
			// 2. Connection 객체 생성
			conn = DriverManager.getConnection(url, user, password);
			// 3. PreparedStatement 객체 생성 (미완성 sql전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			// 4. PreparedStatement 실행 및 ResultSet반환
			rset = pstmt.executeQuery();
			// 5. ResultSet을 한행씩 fetch. Member객체로 전환 후 list에 추가
			// 한 행씩 접근해 처리
			while(rset.next()) {
				String id = rset.getString("id");
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				
				Member member = new Member(id, name, gender, birthday, email, address, regDate);
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 6. 자원반납
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	/**
	 * DB에 접속
	 * member table의 전달받은 id가 같은 행을 리턴하는 메소드
	 * 처리결과 member객체를 controller에 전달
	 */
	public Member selectOne(String id) {
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		try{
			//1. jdbc driver class 등록
			Class.forName(driverClass);
			//2. Connection 객체 생성(url, user, password)
			conn = DriverManager.getConnection(url, user, password);
			//3. Statement 객체(쿼리 실행 객체) 생성 - sql전달 & 값대입
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//4. Statement 실행 - ResultSet객체를 반환(DQL) | int 처리된 행수를 반환
			rset = pstmt.executeQuery();
			//5. ResultSet을 1행씩 열람(DQL) | 트랜잭션처리(DML) + rollback catch절
			while(rset.next()) {
				String name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				
				member = new Member(id, name, gender, birthday, email, address, regDate);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			//6. 자원반납 , 종료
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return member;
	}
	
	/**
	 * DB에 접속
	 * member table의 전달받은 이름을 가진 행을 리턴하는 메소드
	 * 처리결과 member객체를 controller에 전달
	 */
	public Member searchName(String name) {
		String sql = "select * from member where name like '%" + name + "%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		try{
			//1. jdbc driver class 등록
			Class.forName(driverClass);
			//2. Connection 객체 생성(url, user, password)
			conn = DriverManager.getConnection(url, user, password);
			
			//3. Statement 객체(쿼리 실행 객체) 생성 - 미완성 sql전달 & 값대입
			pstmt = conn.prepareStatement(sql);
			
			//4. Statement 실행 - ResultSet객체를 반환(DQL) | int 처리된 행수를 반환
			rset = pstmt.executeQuery();
			
			//5. ResultSet을 1행씩 열람(DQL) | 트랜잭션처리(DML) + rollback catch절
			while(rset.next()) {
				String id = rset.getString("id");
				name = rset.getString("name");
				String gender = rset.getString("gender");
				Date birthday = rset.getDate("birthday");
				String email = rset.getString("email");
				String address = rset.getString("address");
				Timestamp regDate = rset.getTimestamp("reg_date");
				
				member = new Member(id, name, gender, birthday, email, address, regDate);
			}
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			//6. 자원반납 , 종료
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	/**
	 * DB에 접속
	 * DML
	 * member table의 전달받은 id와 일치하는 행을 수정하는 메소드
	 * 처리결과 member객체를 controller에 전달
	 */
	public int updateInfo(Member updateMember) {
		String sql = "update member set name = ?, birthday = ?, email = ?, address = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try{
				//1. jdbc driver class 등록
				Class.forName(driverClass);
				//2. Connection 객체 생성(url, user, password)
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false);
				//3. Statement 객체(쿼리 실행 객체) 생성 - 미완성 sql전달 & 값대입
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, updateMember.getName());
				pstmt.setDate(2, updateMember.getBirthday());
				pstmt.setString(3, updateMember.getEmail());
				pstmt.setString(4, updateMember.getAddress());
				pstmt.setString(5, updateMember.getId());
				//4. Statement 실행 - ResultSet객체를 반환(DQL) | int 처리된 행수를 반환
				result = pstmt.executeUpdate();
				// 5. Transaction처리
				conn.commit();
				
			} catch (Exception e){
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} finally {
				//6. 자원반납 , 종료
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		return result;
	}
	/**
	 * DB에 접속
	 * DML
	 * member table의 전달받은 id와 일치하는 행을 삭제하는 메소드
	 * 처리결과 member객체를 controller에 전달
	 */
	public int deleteMemberInfo(Member deleteMember) {
		String sql = "delete from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//1. jdbc driver class 등록
			Class.forName(driverClass);
			//2. Connection객체 생성(url, user, password), setAutoCommit(false)
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			//3. PreparedStatement 객체 생성(미완성 sql전달 & 값대입)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deleteMember.getId());
			//4. Statement 실행 및 int 반환
			result = pstmt.executeUpdate();
			//5. 트랜잭션처리
			conn.commit();
				
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			//6. 자원반납, 종료
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
