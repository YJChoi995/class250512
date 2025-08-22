package emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;

@WebServlet("/detail")
public class EmpDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/detail doGet 실행");
		
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 파라미터 empno를 int로 형변환
		int empno = 0;
		try {
			String sEmpno = request.getParameter("empno");
			if(sEmpno != null) {
				empno = Integer.parseInt(sEmpno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(empno);
		
		// DB 다녀와서 출력하기
		try {
			
			EmpService empService = new EmpService();
			EmpDTO empDTO2 = empService.getOneEmp(empDTO);
			
			PrintWriter out = response.getWriter();
			
			out.println("<table border=1>");
			out.println("	<tr>");
			out.println("		<th>EMPNO</th>");
			out.println("		<th>ENAME</th>");
			out.println("		<th>JOB</th>");
			out.println("		<th>MGR</th>");
			out.println("		<th>HIREDATE</th>");
			out.println("		<th>SAL</th>");
			out.println("		<th>COMM</th>");
			out.println("		<th>DEPTNO</th>");
			out.println("	</tr>");
			
			out.println("	<tr>");
			out.println("		<td>" + empDTO2.getEmpno() + "</td>");
			out.println("		<td>" + empDTO2.getEname() + "</td>");
			out.println("		<td>" + empDTO2.getJob() + "</td>");
			out.println("		<td>" + empDTO2.getMgr() + "</td>");
			out.println("		<td>" + empDTO2.getHiredate() + "</td>");
			out.println("		<td>" + empDTO2.getSal() + "</td>");
			out.println("		<td>" + empDTO2.getComm() + "</td>");
			out.println("		<td>" + empDTO2.getDeptno() + "</td>");
			out.println("	</tr>");
				
			out.println("</table>");
			
			// 삭제하는 버튼
			out.println("<form method='post' action='remove'>");
			out.println("	<input type='hidden' name='empno' value='" + empDTO2.getEmpno() + "'>");
			out.println("	<input type='submit' value='삭제'>");
			out.println("</form>");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}
