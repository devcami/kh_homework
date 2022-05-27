package member.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/member/memberDelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력값 처리 - Id로 DML delete
//		Member loginMember = (Member) session.getAttribute("loginMember");
//		String memberId = loginMember.getMemberId();
		
		String memberId = request.getParameter("memberId");
		int result = memberService.deleteMember(memberId);
		
//		request.getSession().invalidate();
//		
//		String msg = null;
//		if(result > 0) {
//			msg = "회원탈퇴가 완료되었습니다.";
//		}
//		request.getSession().setAttribute("msg", msg);
		
		// 탈퇴 후 처리 - 세션 폐기, 쿠키 폐기
		Cookie cookie = new Cookie("saveId", memberId);
		cookie.setPath(request.getContextPath());
		cookie.setMaxAge(0); //응답을 받은 즉시 삭제
		response.addCookie(cookie);
		
		// 모든 세션속성 제거 (session.invalidate() 대신) -> 세션자체가 날라가는게 아님 속성만 날라감
		HttpSession session = request.getSession();
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			session.removeAttribute(name);
		}
		
		// 리다이렉트 처리
		session.setAttribute("msg", "회원탈퇴가 완료되었습니다.");
		response.sendRedirect(request.getContextPath() + "/");
		
		
		// 리다이렉트처리 : 바로 로그인완료 창으로 가지 않고 logout으로 가서 invalidate되게 함. 
//		response.sendRedirect(request.getContextPath() + "/member/logout");
		
	
		
		
	}

}
