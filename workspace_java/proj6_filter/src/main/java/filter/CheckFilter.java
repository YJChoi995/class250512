package filter;

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
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckFilter() {
        System.out.println("CheckFilter 생성자 실행");
    }

	/**
	 * @see Filter#destroy()
	 * 소멸자
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 시작하기 전에 시간 기록
		long before = System.currentTimeMillis();
		
		System.out.println("doFilter 실행 전");
		
		// 들어오는 정보 한글 처리
		request.setCharacterEncoding("utf-8");
		// 모든 것을 html로 응답하기 때문에 여기에 어울리지 않다
		// JSON 같은 것은 JSON으로 응답해야 한다
//		response.setContentType("text/html; charset=utf-8;");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String path = req.getServletPath();
		System.out.println("path: " + path);
		
		// "/assets/css/login.css"
		if( isExclude(path)) {
			// 로그인 없이 갈 수 있는 곳
			// 세션 없이 접근 허용
			System.out.println("세션 없이 진행");
			chain.doFilter(request, response);
		} else {
			// 로그인 필수
//			HttpSession session = req.getSession();
//			if(session == null) {
//				// 로그인 페이지로 보내기
//			}
			HttpSession session = req.getSession();
			String login = (String)session.getAttribute("login");
			if("Y".equals(login)) {
				// 실제 사용자가 원했던 일
				chain.doFilter(request, response);
			} else {
				System.out.println("로그인 안해서 통과 못함");
				// "/cookie/get"
				resp.sendRedirect(req.getContextPath() + "/login.html");
			}
		}

		System.out.println("doFilter 실행 후");
		
		long after = System.currentTimeMillis();
		System.out.println("걸린 시간: " + (after - before));
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 * 생성자 실행 후 바로 실행됨
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	private boolean isExclude(String path) {
		boolean result = false;
		if(path.equals("/login.html") || path.equals("/login") || path.startsWith("/assets")) {
			result = true;
		} 
		return result;
	}

}
