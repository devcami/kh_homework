package admin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.HelloMvcUtils;
import member.model.dto.Member;
import member.model.service.MemberService;

/**
 *  페이징
 *  1. content 영역
 *  	- cPage 현재페이지 변수 (n)
 *  	- numPerPage 한 페이지당 표시할 컨텐츠 수 (10)
 *  	- paging query
 *  		- start (1, 11, 21 ..)
 *  		- end (10, 20, 30 ..)
 *  2. pagebar 영역
 *  	- totalContents 전체 컨텐츠 수 (116)
 *  	- totalPages 전체 페이지 수 (12p)
 *  	- pagebarSize 페이지 바 길이 - 10 (prev 1 2 3 4 5 6 7 8 9 10 next)
 *  	- pageNo 페이지 증감변수
 *  	- pageStart ~ pageEnd 페이지바 범위
 *  	- url 다음 요청 페이지 url
 */
@WebServlet("/admin/memberList")
public class AdminMemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService = new MemberService();

	/**
	 * select * from member order by enroll_date desc
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 사용자 입력값 처리
			int numPerPage = MemberService.NUM_PER_PAGE;
			int cPage = 1; 
					
			try {
				cPage = Integer.parseInt(request.getParameter("cPage"));
			} catch (NumberFormatException e) {
				// 예외 발생 : cPage가 존재하지 않을 때 , 현재 페이지는 1로 처리
			}
			
			Map<String, Object> param = new HashMap<>();
			int start = ((cPage - 1) * numPerPage ) + 1; 
			int end = cPage * numPerPage;
			param.put("start", start);
			param.put("end", end);
			
			// 2. 업무로직
			// 2.a content영역
			List<Member> list = memberService.findAll(param);
//			System.out.println("list = " + list);
			
			// 2.b pagebar영역
			
			// select count(*) from member
			int totalContents = memberService.getTotalContents();
			String url = request.getRequestURI(); // /mvc/admin/memberList
			String pagebar = HelloMvcUtils.getPagebar(cPage, numPerPage, totalContents, url);
			System.out.println("pagebar = " + pagebar);
			
			
			// 3. view단 처리
			request.setAttribute("list", list);
			request.setAttribute("pagebar", pagebar);
			request.getRequestDispatcher("/WEB-INF/views/admin/memberList.jsp")
				.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
