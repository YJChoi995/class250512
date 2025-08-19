package proj3_dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleJDBCExam {
	
	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
		String user = "scott4_2";
		String password = "tiger";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			// Class.foName() : String을 이용해서 class 생성
			// Oracle 드라이버 로딩
			Class.forName(driver);
			
			// DB 접속
			conn = DriverManager.getConnection(url, user, password);
			
			// SQL 준비
			String query = "select * from EMP"; // ;(세미콜론) 자체는 sql문이 아님에 주의!
			ps = conn.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			rs = ps.executeQuery();
			
			// 결과 활용
			// rs.next() : 다음 줄이 있는가?
			// next가 실행된 이후 rs 변수는 한 줄(포커스가)로 변경 됨
			// 커서(포커스)가 다음 줄로 이동된다
//			if( rs.next() ) {
//				int empno = rs.getInt("EMPNO");
//				System.out.println("첫번째 EMPNO : " + empno);
//				
//				String ename = rs.getString("ENAME");
//				System.out.println("첫번째 ENAME : " + ename);
//			}
//			if( rs.next() ) {
//				int empno = rs.getInt("EMPNO");
//				System.out.println("두번째 EMPNO : " + empno);
//				
//				String ename = rs.getString("ENAME");
//				System.out.println("두번째 ENAME : " + ename);
//			}
			
			while( rs.next() ){
				// 전달인자로 컬럼명(대소문자 구분없음)
				int empno = rs.getInt("EMPNO");
				System.out.print(empno +",");
				String ename = rs.getString("ENAME");
				System.out.println(ename);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if(rs == null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
