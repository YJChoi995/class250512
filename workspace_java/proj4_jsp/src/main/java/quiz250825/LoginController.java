package quiz250825;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기존 세션이 없으면 새로 만들어주고, 있으면 그걸 가져옴
		HttpSession session = request.getSession();
		
		// ID 받아오는 getId()
		String id = session.getId();
		
		// 계정 관리
		String userId = request.getParameter("uid");
		String userPw = request.getParameter("pw");
		
		
		if("admin".equals(userId) && "empno".equals(userPw)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", userId);	
			session.setAttribute("userPw", userPw);	
		} else if("ename".equals(userId) && "empno".equals(userPw)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", userId);	
			session.setAttribute("userPw", userPw);
		}	
	}



}
