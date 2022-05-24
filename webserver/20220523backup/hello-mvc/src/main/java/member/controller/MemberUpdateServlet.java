package member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dto.Member;
import member.model.service.MemberService;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 인코딩처리 (filter)
//			request.setCharacterEncoding("utf-8");
			// 2. 사용자 입력값처리
			String memberId = request.getParameter("memberId");
			String memberName = request.getParameter("memberName");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			
			String _birthday = request.getParameter("birthday");
			String[] _hobby = request.getParameterValues("hobby");
			
			Date birthday = null;
			if(_birthday != null & !"".equals(_birthday)) {
				birthday = Date.valueOf(_birthday);
			}
			
			String hobby = null;
			if(_hobby != null) {
				hobby = String.join(",", _hobby);
			}
			
			Member member = new Member(memberId, null, memberName, null, gender, birthday, email, phone, address, hobby, null);
			System.out.println("member@MemberUpdateServlet = " + member);
			
			// 3. 업무로직 - Service에 updateMember정보 요청
			int result = memberService.updateMember(member);
			String msg = "회원정보를 성공적으로 수정했습니다.";
			
			// 세션정보 갱신
			Member updateMember = memberService.findByMemberId(memberId);
			request.getSession().setAttribute("loginMember", updateMember);
			
			// 4. jsp- view단처리, redirect - msg(session에 저장)  
			request.getSession().setAttribute("msg", msg); // redirect후에 header.jsp에서 꺼내서 출력.
			response.sendRedirect(request.getContextPath() + "/member/memberView");
			
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
