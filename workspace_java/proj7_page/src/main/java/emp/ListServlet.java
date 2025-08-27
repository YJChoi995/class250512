package emp;

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
		 EmpDAO dao = new EmpDAO();

	    // 현재 페이지 번호 받기
	    int page = 1; // 기본 1페이지
	    if (request.getParameter("page") != null) {
	        page = Integer.parseInt(request.getParameter("page"));
	    }

	    int pageSize = 10; // 한 페이지당 10개
	    int pageBlock = 5; // 한번에 표시할 페이지 번호 개수

	    int startRow = (page - 1) * pageSize + 1;
	    int endRow = page * pageSize;

	    // DB에서 데이터와 전체 개수
	    List<EmpDTO> list = dao.selectPage(startRow, endRow);
	    int totalCount = dao.getTotalCount();
	    int totalPage = (int) Math.ceil(totalCount / (double) pageSize);

	    // 페이지 블록 계산
	    int startPage = Math.max(1, page - 2);          // 현재 페이지를 중간에 두도록
	    int endPage = Math.min(totalPage, startPage + pageBlock - 1);

	    // JSP에 데이터 전달
	    request.setAttribute("list", list);
	    request.setAttribute("page", page);
	    request.setAttribute("totalPage", totalPage);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);

	    request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
