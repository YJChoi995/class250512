package quiz250825;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginCheck")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String ename = request.getParameter("ename");  // id
		String sEmpno = request.getParameter("empno"); // pw
		int empno = Integer.parseInt(sEmpno);
		
		EmpDTO dto = new EmpDTO();
		dto.setEname(ename);
		dto.setEmpno(empno);
		
		// DB 다녀오기
		EmpDAO dao = new EmpDAO();
		EmpDTO resultDTO = dao.getEmp(dto);
		
		// 로그인 성공 여부 판단
		if(resultDTO == null) { 
			// 비회원
			// 로그인 페이지로 이동
			response.sendRedirect("login.jsp?msg=1");
		} else {	
			// 회원
			HttpSession session = request.getSession();
			session.setAttribute("dto", resultDTO);
			
			response.sendRedirect("list");
		}
		
		
	}


}
