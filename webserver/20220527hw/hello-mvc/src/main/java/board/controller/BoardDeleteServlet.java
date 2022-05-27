package board.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dto.Attachment;
import board.model.dto.BoardExt;
import board.model.service.BoardService;

/**
 * Servlet implementation class BoardDeleteServlet
 */
@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BoardService boardService = new BoardService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));

		// 파일 경로로 삭제
		List<Attachment> attachments = boardService.findByNo(no).getAttachments();
		if(attachments != null && !attachments.isEmpty()) {
			for(Attachment attach : attachments) {
				String saveDirectory = getServletContext().getRealPath("/upload/board");
				File delFile = new File(saveDirectory, attach.getRenamedFilename());
				if(delFile.exists()) 
					delFile.delete();
				System.out.println(attach.getRenamedFilename() + " 파일 삭제 완료");
			}
		}
		
		// 파일 삭제 후 글 삭제
		int result = boardService.deleteBoard(no);
		
		request.getSession().setAttribute("msg", "게시글이 삭제되었습니다.");
		response.sendRedirect(request.getContextPath() + "/board/boardList");
		
	}

}
