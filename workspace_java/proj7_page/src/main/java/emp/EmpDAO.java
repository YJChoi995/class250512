package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class EmpDAO {
		
	// DB 접속하는 메소드
	private Connection getConn() {
		Connection conn = null;
		
		try {
			// JNDI : 글씨로 가져오는 방식
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// EMP 테이블 불러오는 메소드
	public EmpDTO getEmp(EmpDTO dto) {
		EmpDTO resultDTO = null;
		
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String query = "select * from emp2";
				   query += " where empno = ? and ename = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, dto.getEmpno());
			ps.setString(2, dto.getEname());
				 
			// 실행
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if( rs.next() ) {
				resultDTO = new EmpDTO();
				resultDTO.setEmpno( rs.getInt("empno"));
				resultDTO.setEname( rs.getString("ename"));
				resultDTO.setJob( rs.getString("job"));
				resultDTO.setMgr( rs.getInt("mgr"));
				resultDTO.setHiredate( rs.getDate("hiredate"));
				resultDTO.setSal( rs.getInt("sal"));
				resultDTO.setComm( rs.getInt("comm"));
				resultDTO.setDeptno( rs.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultDTO;
	}
	
	public List<EmpDTO> selectAll() {
		List<EmpDTO> list = new ArrayList();
		
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String query = "select count(*) from emp2";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			// 실행
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while( rs.next() ) {
				EmpDTO resultDTO = new EmpDTO();
				resultDTO.setEmpno( rs.getInt("empno"));
				resultDTO.setEname( rs.getString("ename"));
				resultDTO.setJob( rs.getString("job"));
				resultDTO.setMgr( rs.getInt("mgr"));
				resultDTO.setHiredate( rs.getDate("hiredate"));
				resultDTO.setSal( rs.getInt("sal"));
				resultDTO.setComm( rs.getInt("comm"));
				resultDTO.setDeptno( rs.getInt("deptno"));
				
				list.add(resultDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 전체 데이터 개수 구하기
	public int getTotalCount() {
	    int count = 0;
	    String query = "SELECT COUNT(*) FROM emp2";

	    try (Connection conn = getConn();
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {

	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}

	// 특정 구간(startRow ~ endRow) 데이터만 조회
	public List<EmpDTO> selectPage(int startRow, int endRow) {
	    List<EmpDTO> list = new ArrayList<>();
	    String query = "SELECT * FROM (" 
	        		 + "  SELECT ROWNUM AS rnum, a.* " 
	    		     + "  FROM (SELECT * FROM emp2 ORDER BY empno) a" 
	        		 + ") WHERE rnum BETWEEN ? AND ?";

	    try (Connection conn = getConn();
	         PreparedStatement ps = conn.prepareStatement(query)) {

	        ps.setInt(1, startRow);
	        ps.setInt(2, endRow);

	        ResultSet rs = ps.executeQuery();
	        while (rs.next()) {
	            EmpDTO dto = new EmpDTO();
	            dto.setEmpno(rs.getInt("empno"));
	            dto.setEname(rs.getString("ename"));
	            dto.setJob(rs.getString("job"));
	            dto.setMgr(rs.getInt("mgr"));
	            dto.setHiredate(rs.getDate("hiredate"));
	            dto.setSal(rs.getInt("sal"));
	            dto.setComm(rs.getInt("comm"));
	            dto.setDeptno(rs.getInt("deptno"));

	            list.add(dto);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return list;
	}
}
