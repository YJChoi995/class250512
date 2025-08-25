package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존 세션이 없으면 새로 만들어주고, 있으면 그걸 가져옴
		HttpSession session = request.getSession();

		// 기존 세션이 없으면 null, 있으면 그걸 가져옴
//		HttpSession session = request.getSession(false);
		
		session.setAttribute("k", "v");
		
		// ID 받아오는 getId()
		String id = session.getId();
		System.out.println("getId(): " + id);
		
		// 세션이 새것인지, 기존 것인지 판단 isNew()
		boolean isNew = session.isNew();
		System.out.println("isNew(): " + isNew);
		
		
		String userId = request.getParameter("id");
		if("id1234".equals(userId)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", userId);		
		} else if("admin".equals(userId)) {
			session.setAttribute("login", true);
			session.setAttribute("userId", userId);
			session.setAttribute("level", "1");
		}
			
		
	}



}
