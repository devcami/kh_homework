package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * jdbc api 사용간에 공통된 처리를 담당하는 static method 모음 클래스
 * 
 */
public class JdbcTemplate {

	static String driverClass = "oracle.jdbc.OracleDriver"; // 드라이버 클래스명
	static String url = "jdbc:oracle:thin:@DB202203101507_medium?TNS_ADMIN=Wallet_DB202203101507"; //접속할 db서버 주소 . db접속프로토콜@ip:port:sid
	static String user = "student";
	static String password = "Rkdtmddbs0121";
	
	static {
		// Driver 클래스 등록
		// 프로그램 실행 시 한번만 하면 되기 때문에 static초기화 블록을 사용하여 최초 1회 등록
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//Connection객체 생성(url, user, password) / DML setAutoCommit(false)
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//자원반환
	public static void close(Connection conn) {
		try {
			//conn이 null이 아니고 닫히지 않았을 때 만 close하도록 조건문 작성
			if(conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			//pstmt이 null이 아니고 닫히지 않았을 때 만 close하도록 조건문 작성
			if(pstmt != null && !pstmt.isClosed())
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rset) {
		try {
			//rset이 null이 아니고 닫히지 않았을 때 만 close하도록 조건문 작성
			if(rset != null && !rset.isClosed())
				rset.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//트랜잭션처리
	public static void commit(Connection conn) {
		try {
			//conn이 null이 아니고 닫히지 않았을 때 만 commit하도록 조건문 작성
			if(conn != null && !conn.isClosed())
				conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			//conn이 null이 아니고 닫히지 않았을 때 만 rollback하도록 조건문 작성
			if(conn != null && !conn.isClosed())
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
