package quiz250825;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에서 목록 조회
		EmpDAO dao = new EmpDAO();
		List list = dao.selectAll();
		
		request.setAttribute("list", list);
		// 그대로 list.jsp에 보내기
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}



}
