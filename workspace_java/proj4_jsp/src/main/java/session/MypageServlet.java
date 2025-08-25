package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		
		HttpSession session = request.getSession(false);
		
		if(session == null) {
			System.out.println("로그인 안함1");
			System.out.println("아예 처음 방문");
			// 로그인 안한 상태
			response.sendRedirect("cookie_5.jsp");
		} else {
			System.out.println("로그인 안함2");
			System.out.println("처음 방문은 아님");
			// getAttribute는 없으면 항상 null
			Boolean login = (Boolean)session.getAttribute("login");
			if(login == null || login != true) {
				// 로그인 안함
				response.sendRedirect("cookie_5.jsp");
			} else {
				response.getWriter().println("로그인해야 들어올 수 있는 페이지");
				response.getWriter().println("<br>아이디: " + session.getAttribute("id"));
			}
		}
		
		
	}
}
