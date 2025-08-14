package sec01.exam01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req")
public class RequestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/req doGet 실행");
		
		// 요청할 때 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		// 응답할 때 한글 깨짐 방지
		response.setContentType("text/html; charset=utf-8;");
		

		// getParameter(). 전달받은 파라미터의 key값을 적어서 해당 값을 얻어오기
		String num1 = request.getParameter("num1");
		System.out.println("num1: " + num1);
		
		// getParameter값 없으면 null
		String num2 = request.getParameter("num2");
		System.out.println("num2: " + num2);
		
		// 
		System.out.println("pw: " + request.getParameter("pw"));
		
		// querySelector처럼 name이 여러개이면 처음꺼 하나만 가져옴
		System.out.println("check: " + request.getParameter("check"));
	
		// getParameterValues() 배열로 값들을 가져옴
		String[] ckecks = request.getParameterValues("check");
		System.out.println("ckecks: " + ckecks);
		if(ckecks != null) {
			for(String chk : ckecks) {
				System.out.println(chk);
			}
		}
		
		// hidden
		System.out.println("hidden1: " + request.getParameter("hidden1"));
		
		// button : 버튼은 값이 전달되지 않음 -> 서버용X, 사용자용
		System.out.println("btn1: " + request.getParameter("btn1"));
		System.out.println("btn2: " + request.getParameter("btn2"));
		
		// radio
		System.out.println("radio1: " + request.getParameter("radio1"));
		
		// date
		System.out.println("date1: " + request.getParameter("date1"));
		
		// number
		System.out.println("number1: " + request.getParameter("number1"));
	
		// div는 전송되지 않음
		System.out.println("div1: " + request.getParameter("div1"));
		
		// select
		System.out.println("select1: " + request.getParameter("select1"));
		
		// textarea
		System.out.println("textarea1: " + request.getParameter("textarea1"));
		
		
		
		
		// ajax
		response.getWriter().println("{\"k\":123}");
		
	}
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/req doPost 실행");
		
		// number
		System.out.println("num2: " + request.getParameter("num2"));
		
		// JSON
		response.getWriter().println("{\"k\":123}");

	}

}
