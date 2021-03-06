package jdbc.test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JdbcConnectionTestServlet
 */
@WebServlet("/test/dbConnection")
public class JdbcConnectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String driverClass = "oracle.jdbc.OracleDriver"; // 드라이버 클래스명
	String url = "jdbc:oracle:thin:@DB202203101507_medium?TNS_ADMIN=/Users/camilee/wallet/Wallet_DB202203101507"; //지갑주소는 절대경로로
	String user = "web";
	String password = "Rkdtmddbs0121";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// db연결테스트
		test();
		response.setContentType("text/plain; charset=utf-8");
		response.getWriter().append("db 연결테스트 - 서버콘솔을 확인하세요!");
	}
	/**
	 * DQL
	 *  - select
	 */
	private void test() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "select * from member";
		
		try {
			//1. jdbc driver class 등록
			Class.forName(driverClass);
			System.out.println(" > Driver Class 등록완료");
			
			//2. Connection 객체 생성(url, user, password)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(" > Connection 객체 생성 성공!");
			
			//3. PreparedStatement 객체(쿼리 실행 객체) 생성 
			pstmt = conn.prepareStatement(sql);
			System.out.println(" > Statement 객체 생성 성공!");
			
			//4. PreparedStatement 실행 - ResultSet객체를 반환
			rset = pstmt.executeQuery();
			System.out.println(" > Statement 실행 및 ResultSet 반환 성공!");
			
			//5. ResultSet을 1행씩 열람
			//다음행이 존재하면 true를 리턴
			while(rset.next()) {
				// ResultSet.getString("컬럼명")
				String id = rset.getString("member_id");
				String name = rset.getString("member_name");
				Date birthday = rset.getDate("birthday");
				
				System.out.printf("%s\t%s\t%s%n", id, name, birthday);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			//6. 자원반납 , 종료
			//객체생성 역순
			try {
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
	}

	

}
