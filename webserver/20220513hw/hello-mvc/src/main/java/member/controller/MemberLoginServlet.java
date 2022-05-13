package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dto.Member;
import member.model.service.MemberService;

/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩처리
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자 입력값 처리
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		System.out.println("memberId@MemberLoginServlet = " + memberId);
		System.out.println("password@MemberLoginServlet = " + password);
		
		// 3. 업무로직
		Member member = memberService.findByMemberId(memberId);
		System.out.println("member@MemberLoginServlet = " + member);
		
		// session 가져오기
		// getSession(create:boolean) 
		// true(기본값 : 생략가능) : 존재하면 해당 session객체를, 존재하지 않으면 새로 생성해서 리턴
		// false : 존재하면 해당 session객체를, 존재하지 않으면 null을 리턴.
		HttpSession session = request.getSession(true);
		
		if(member != null && password.equals(member.getPassword())) {
			//로그인 성공 : login form -> 안녕하세요 ~님
			System.out.println(session.getId()); // JSESSIONID
			session.setAttribute("loginMember", member);	
			
		}
		else {
			//로그인 실패 : session에 msg를 담아 보여주도록 함.
			session.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		// 4. 응답처리 (view단으로 , JSP에 위임처리)
//		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/index.jsp");
//		reqDispatcher.forward(request, response);
		
		// 4. 응답처리 : 리다이렉트
		response.sendRedirect(request.getContextPath() + "/"); // /mvc/로 하드코딩 하지 않고 변수 사용.
		
	}

}
