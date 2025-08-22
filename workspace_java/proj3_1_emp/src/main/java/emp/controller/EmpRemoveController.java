package emp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.dto.EmpDTO;
import emp.service.EmpService;

@WebServlet("/remove")
public class EmpRemoveController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/remove doPost 실행");
		
		// detail 페이지에서 삭제 버튼 누르면 동작
		
		// 1. empno 값 가져오기
		int empno = 0;
		try {
			String sEmpno = request.getParameter("empno");
			if(sEmpno != null) {
				empno = Integer.parseInt(sEmpno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. DTO에 담아주기
		EmpDTO empDTO = new EmpDTO();
		empDTO.setEmpno(empno);
		
		// 3. DB에 다녀오기
		EmpService empService = new EmpService();
		int result = empService.removeEmp(empDTO);
		System.out.println(result + "만큼 삭제 되었습니다");
		
		// 4. 전체 목록 페이지 표시
		response.sendRedirect("list");
	}

}
