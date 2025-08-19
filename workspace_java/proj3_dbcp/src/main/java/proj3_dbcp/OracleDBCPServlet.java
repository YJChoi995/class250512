package proj3_dbcp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/dbcp")
public class OracleDBCPServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// JNDI 방식으로 (Java Naming and Directory Interface) 
			// context.xml에 있는 DB 정보를 가져온다
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			Connection conn = dataFactory.getConnection();
			
			// SQL 준비
			String query = "select * from EMP"; // ;(세미콜론) 자체는 sql문이 아님에 주의!
			PreparedStatement ps = conn.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			PrintWriter out = response.getWriter();
			
			// 결과 활용
			while( rs.next() ){
				// 전달인자로 컬럼명(대소문자 구분없음)
				int empno = rs.getInt("EMPNO");
				System.out.print(empno + ", ");
				out.print(empno + ", ");
				
				Date hiredate = rs.getDate("HIREDATE");
				System.out.print(hiredate.toLocalDate() + ", ");
				out.print(hiredate + ", ");
				
				String ename = rs.getString("ENAME");
				System.out.println(ename);
				out.println(ename);
				
				
				
			}
			
			rs.close();
			ps.close();
			conn.close(); // 커넥션 풀로 반환
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	


}
