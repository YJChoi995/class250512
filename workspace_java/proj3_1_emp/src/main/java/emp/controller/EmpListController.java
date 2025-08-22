package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;


@WebServlet("/list")
public class EmpListController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/list doGet 실행");
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// DB 조회
		EmpService empService = new EmpService();
		List<EmpDTO> list = empService.getAllEmp();
		
		///////////////////////////////////////////////
		
		// 화면에 출력(응답 정적 자원 만들기)
		PrintWriter out = response.getWriter();
		
		out.println("<table border=1>");
		out.println("	<tr>");
		out.println("		<th>EMPNO</th>");
		out.println("		<th>ENAME</th>");
		out.println("		<th>SAL</th>");
		out.println("	</tr>");
		
		for(EmpDTO dto : list) {
			System.out.println(dto);
			out.println("<tr>");
			out.println("	<td>" + dto.getEmpno() + "</td>");
			out.println("	<td><a href='/proj3_1_emp/detail?empno=" + dto.getEmpno() + "'>" + dto.getEname() + "</a></td>");
			out.println("	<td>" + dto.getSal() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		
	}

	

}
