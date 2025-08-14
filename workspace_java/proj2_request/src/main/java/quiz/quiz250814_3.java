package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz250814_3")
public class quiz250814_3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		System.out.println("/quiz250814_3 doGet 실행");
		
		String num1 = request.getParameter("num1");
		
		try {
			int n1 = Integer.parseInt(num1);
			PrintWriter out = response.getWriter();
			
			out.println("<h1>" + n1 + "단 생성</h1>");
			
			for(int i=1; i<=9; i++) {
				out.println(n1 + " x " + i + " = " + (n1*i) + "<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814_3 doPost 실행");
	}

}
