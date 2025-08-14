package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz250814_2")
public class quiz250814_2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814_2 doGet 실행");
		
		String id2 = request.getParameter("id2");
		String pw2 = request.getParameter("pw2");
		
		response.setContentType("text/html; charset=UTF-8;");
        PrintWriter out = response.getWriter();
		
		try {
			if (id2 == null || id2.isEmpty()) {
	            out.println("<script>");
	            out.println("alert('아이디 또는 비밀번호를 확인해주세요');");
	            out.println("history.back();"); // 이전 페이지로 돌아가기
	            out.println("</script>");
	        } 
			if (pw2 == null || pw2.isEmpty()) {
				
			}

	    
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814 doPost 실행");
	}

}
