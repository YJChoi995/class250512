package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz250814")
public class quiz250814 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814 doGet 실행");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		response.setContentType("text/html; charset=UTF-8;");
        PrintWriter out = response.getWriter();
		
		try {
			// null 체크 + 빈 문자열 체크
	        if (id == null || id.isEmpty() || pw == null || pw.isEmpty()) {
	            out.println("<script>");
	            out.println("alert('아이디 또는 비밀번호를 확인해주세요');");
	            out.println("history.back();"); // 이전 페이지로 돌아가기
	            out.println("</script>");
	        } 
	        // 문자열 비교는 equals() 사용
	        else if (id.equals("admin") && pw.equals("1234")) {
	            response.sendRedirect("quiz250814_1.html"); // 페이지 이동
	        } 
	        else {
	        	System.out.println("id: " + id + " pw: " + pw);
	        }
	    
		} catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814 doPost 실행");
	}

}
