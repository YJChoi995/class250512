package emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import emp.dto.EmpDTO;

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
	
	// 모든 EMP 테이블을 조회하는 메소드
	public List selectAllEMP() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();
		
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String query = "select * from emp2";
			PreparedStatement ps = conn.prepareStatement(query);
			
			// SQL 실행
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while( rs.next() ) {
				EmpDTO dto = new EmpDTO();
				
				int empno = rs.getInt("empno");
				dto.setEmpno(empno);
				
				dto.setEname( rs.getString("ename") );
				dto.setSal( rs.getInt("sal") );
				
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// EMP 테이블의 한명만 조회하는 메소드
	public EmpDTO selectOneEmp(EmpDTO empDTO) {
		EmpDTO resultDTO = null;
		
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String query = "select * from emp2";
				  query += " where empno = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empDTO.getEmpno());
			
			// SQL 실행
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			if(rs.next()) {
				resultDTO = new EmpDTO();
				
				int empno = rs.getInt("empno");
				resultDTO.setEmpno(empno);
				resultDTO.setEname( rs.getString("ename") );
				resultDTO.setJob( rs.getString("job") );
				resultDTO.setMgr( rs.getInt("mgr") );
				resultDTO.setHiredate( rs.getDate("Hiredate") );
				resultDTO.setSal( rs.getInt("sal") );
				resultDTO.setComm( rs.getInt("comm") );
				resultDTO.setDeptno( rs.getInt("deptno") );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultDTO;
	}
	
	// detail에서 삭제하는 메소드
	public int deleteEmp (EmpDTO empDTO) {
		int result = -1;
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String query = "delete emp2";
				   query += " where empno = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, empDTO.getEmpno());
			
			// SQL 실행 (select가 아님)
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
}
