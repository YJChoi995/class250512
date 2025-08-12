package sec01.exam01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/ip")
public class IpServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/ip doGet 실행");
		
		// ip 주소를 가져오는 것 중에 하나
		String ip = request.getRemoteAddr();
		System.out.println("ip: " + ip);
		
		// 접근 method 확인
		System.out.println("getMethod: " + request.getMethod());
		
		// 접근 주소 전체. 단, 쿼리스트링 제외
		System.out.println("getRequestURL: " + request.getRequestURL());
		
		// ip, port, 쿼리스트링만 가져오기
		System.out.println("getQueryString: " + request.getQueryString());
		
		System.out.println("getRequestURI: " + request.getRequestURI());
		
		// 프로젝트를 구분하는 주소
		System.out.println("getContextPath: " + request.getContextPath());
		
		// 서블릿 주소만 나오는 
		System.out.println("getServletPath: " + request.getServletPath());
	}





}
