package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class LogFilter
 */
@WebFilter("/*")
public class LogFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LogFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 * 
	 * ServletRequest - HttpServletRequest의 부모타입
	 * ServletResponse - HttpServletResponse의 부모타입
	 * 
	 * 다형성이 고려된 거의 동일한 객체라고 보면 됨.
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Servlet 가기 전처리
		
		// DownCasting
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		String uri = httpReq.getRequestURI(); // /mvc/member/memberView이런식으로 나올것
		String method = httpReq.getMethod();
		
		System.out.println();
		System.out.println("===========================================");
		System.out.println(method + " " + uri);
		System.out.println("-------------------------------------------");
		
		// filter chain의 다음 필터 호출 (마지막 filter인 경우는 Servlet을 호출)
		chain.doFilter(request, response);
		
		// servlet, jsp 후처리
		System.out.println("___________________________________________");
		System.out.println(httpRes.getStatus());
		System.out.println();
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
