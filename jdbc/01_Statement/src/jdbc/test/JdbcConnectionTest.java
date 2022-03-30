package jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionTest {
	
	String driverClass = "oracle.jdbc.OracleDriver"; // 드라이버 클래스명
	String url = "jdbc:oracle:thin:@DB202203101507_medium?TNS_ADMIN=Wallet_DB202203101507"; //접속할 db서버 주소 . db접속프로토콜@ip:port:sid
	String user = "student";
	String password = "Rkdtmddbs0121";
	
	public static void main(String[] args) {
		JdbcConnectionTest instance = new JdbcConnectionTest();
		instance.test1();
//		instance.test2();
	}
	
	/**
	 * DQL
	 *  - select
	 */
	private void test1() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		try {
			//1. jdbc driver class 등록
			Class.forName(driverClass);
			System.out.println(" > Driver Class 등록완료");
			
			//2. Connection 객체 생성(url, user, password)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(" > Connection 객체 생성 성공!");
			
			//3. Statement 객체(쿼리 실행 객체) 생성 
			stmt = conn.createStatement();
			System.out.println(" > Statement 객체 생성 성공!");
			
			//4. Statement 실행(sql전달) - ResultSet객체를 반환
			String sql = "select * from member";
			rset = stmt.executeQuery(sql); //실행 executeQuery return : ResultSet
			System.out.println(" > Statement 실행 및 ResultSet 반환 성공!");
			
			//5. ResultSet을 1행씩 열람
			//다음행이 존재하면 true를 리턴
			while(rset.next()) {
				// ResultSet.getString("컬럼명")
				String id = rset.getString("id");
				String name = rset.getString("name");
				Date birthday = rset.getDate("birthday");
				
				System.out.printf("%s\t%s\t%n", id, name, birthday);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//6. 자원반납 , 종료
			//객체생성 역순
			try {
				rset.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}

	
	/**
	 * DML
	 * 	- insert
	 * 	- update
	 * 	- delete
	 */
	public void test2() {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//1. jdbc driver class 등록
			Class.forName(driverClass);
			
			//2. Connection 객체 생성(url, user, password)
			// DML 주의!
			// autoCommit(false) : 코드로써 트랜잭션을 직접 관리하기 위해 true(기본값) -> false로 명시
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			
			//3. Statement 객체(쿼리 실행 객체) 생성 - sql전달
			stmt = conn.createStatement();
			
			//4. Statement 실행 - int 반환 (처리된 행 수)
			String sql = "update member set name = '고길동' where id = 'honngd'";
			int result = stmt.executeUpdate(sql); //insert, update, delete 전부 excuteUpdate(sql)임
			System.out.println("> " + result + "행이 수정되었습니다.");
			
			//5.1 Transaction처리 - commit
			if(result > 0)
				conn.commit();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//5.2 Transaction처리 - rollback
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			//6. 자원반납 , 종료
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
