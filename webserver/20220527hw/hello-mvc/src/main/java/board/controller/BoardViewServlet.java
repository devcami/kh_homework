package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dto.BoardExt;
import board.model.service.BoardService;

/**
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/board/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 사용자 입력값 처리
			int no = Integer.parseInt(request.getParameter("no"));
			
			// 쿠키처리
			boolean hasRead = false;
			String boardCookieVal = "";
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					String name = cookie.getName();
					String value = cookie.getValue();
					if("boardCookie".equals(name)) {
						boardCookieVal = value; // 기존쿠키값 저장
						if(value.contains("|" + no + "|")) { //현재 글을 읽었다면
							hasRead = true;
						}
						break;
					}
				}
			}
			
			// 2. 업무로직
			// 조회수 증가 : hasRead가 false일 때만 증가 (읽지 않았을 때만)
			if(!hasRead) {
				int result = boardService.updateReadCount(no);
				// boardCookie가 아예 없는경우 | 요청된 boardCookie에 현재 no가 없는 경우 
				// -> 쿠키를 새로 만들어서 전송
				Cookie cookie = new Cookie("boardCookie", boardCookieVal + "|" + no + "|");
				// 이 쿠키를 사용할 경로
				cookie.setPath(request.getContextPath() + "/board/boardView");
				// 이 쿠키가 사용 될 기간 (1년)
				cookie.setMaxAge(365 * 24 * 60 * 60);
				// 응답 header에 set쿠키 전송
				response.addCookie(cookie);
				System.out.println("> boardCookie가 새로 생성되었음");
			}
			
			// 게시글 조회
			BoardExt board = boardService.findByNo(no);
			
			// XSS공격(Cross-site Scripting공격) 대비 변환 : 개행처리 <br> 이전에 나와야됨!
			board.setTitle(board.getTitle().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
			board.setContent(board.getContent().replaceAll("<", "&lt;").replaceAll(">", "&gt;"));
			
			// board#content 개행처리
			board.setContent(board.getContent().replaceAll("\n", "<br/>"));
			
			System.out.println("BoardView@board = " + board);
			
			// 3. view단 위임
			request.setAttribute("board", board);
			request.getRequestDispatcher("/WEB-INF/views/board/boardView.jsp")
				.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
