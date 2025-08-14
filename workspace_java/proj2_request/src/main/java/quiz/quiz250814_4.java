package quiz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/quiz250814_4")
public class quiz250814_4 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814_4 doGet 실행");
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h3>피자 주문 내역</h3>");
		
		try {
			// 메뉴 선택 : select
			String menu = request.getParameter("menu");
			out.println("<strong>메뉴</strong> : " + menu +"<br>");
			
			// 사이즈 선택 : radio
			String size = request.getParameter("size");
			out.println("<strong>사이즈</strong> : " + size + "<br>");
			
			// 토핑 선택 : checkbox
			String[] ckecks = request.getParameterValues("topping");
			out.println("<strong>토핑</strong> : ");
			if(ckecks != null) {
				for(String chk : ckecks) {
					out.println(chk);
				}
				out.println("<br>");
			} else if(ckecks == null) {
				out.println("없음<br>");
			}
			
			// 요청사항 : textarea
			out.println("<strong>요청사항</strong> :");
			String textarea = request.getParameter("textarea");
			if(textarea != null) {
				out.println(textarea + "<br>");
			} else {
				out.println("없음<br>");
			}
			
			// 가격
			out.println("<hr>");
			out.println("<strong>가격 : </strong>");
			switch (menu) {
				case "고구마 피자" :
					if(size.equals("레귤러")) {
						out.println("20,900원");
					} else {
						out.println("24,900원");
					}
					break;
				case "메이플 베이컨 피자" :
					if(size.equals("레귤러")) {
						out.println("20,900원");
					} else {
						out.println("24,900원");
					}
					break;
				case "불고기 피자" :
					if(size.equals("레귤러")) {
						out.println("20,900원");
					} else {
						out.println("24,900원");
					}
					break;
				case "치즈 피자" :
					if(size.equals("레귤러")) {
						out.println("16,900원");
					} else {
						out.println("20,900원");
					}
					break;
				case "페퍼로니 피자" :
					if(size.equals("레귤러")) {
						out.println("16,900원");
					} else {
						out.println("20,900원");
					}
					break;
			}
			

		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/quiz250814_4 Post 실행");

	}

}
