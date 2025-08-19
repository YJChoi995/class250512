package todo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import todo.DTO.TodoDTO;

// DAO : Date Access Object
public class TodoDAO {
	
	// tbl_todo의 모든 항목을 돌려주는 메소드
	// 메소드명 : selectAll
	// 전달인자 : 없음
	// 리턴타입 : List<TodoDTO>
	public List<TodoDTO> selectAll(){
		
		List<TodoDTO> list = new ArrayList<>();
		
		try {
			Connection conn = getConnection();
			
			// SQL 준비
			String query = "select * from tbl_todo"; // ;(세미콜론) 자체는 sql문이 아님에 주의!
			PreparedStatement ps = conn.prepareStatement(query);
			
			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while( rs.next() ){
				// 전달인자로 컬럼명(대소문자 구분없음)
				int tno = rs.getInt("tno");
				String title = rs.getString("title");
				Date duedate = rs.getDate("duedate");
				int finished = rs.getInt("finished");
				
//				Map map = new HashMap();
//				map.put("tno", tno);
//				map.put("title", title);
//				map.put("duedate", duedate);
//				map.put("finished", finished);
//				list.add(map);
				
				TodoDTO todoDTO = new TodoDTO();
				todoDTO.setTno(tno);
				todoDTO.setTitle(title);
				todoDTO.setDuedate(duedate);
				todoDTO.setFinished(finished);
				list.add(todoDTO);
			}
		
			rs.close();
			ps.close();
			conn.close(); // 커넥션 풀로 반환
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	// DB 접속 메소드
	// 메소드명 : getConnection
	Connection getConnection() {
		Connection conn = null;
		
		try {
			// JNDI 방식으로 (Java Naming and Directory Interface) 
			// context.xml에 있는 DB 정보를 가져온다
			Context ctx = new InitialContext();
			// DataSource : 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			
			// DB 접속
			conn = dataFactory.getConnection();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	// 자료 삽입 메소드
	// 메소드명 : insert
	// 전달인자 : TodoDTO
	// 리턴타입 : int( insert된 행의 수 )
 	public int insert (TodoDTO dto) {
		int result = -1;
		
		try {
			// 접속
			Connection conn = getConnection();
			
			// SQL 준비
			String query = "insert into tbl_todo";
			query += " tbl_todo (tno, title, duedate, finished)";
		  //query += " values (seq_tbl_todo.nextval, '"+  dto.getTitle() + "', '" + dto.getDuedate() + "', " + dto.getFinished() + ")";
			query += " values (seq_tbl_todo.nextval, ?, ?, ?)"; // 변수 방식
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getTitle());
			ps.setDate(2, dto.getDuedate());
			ps.setInt(3, dto.getFinished());
			
			// SQL 실행 및 결과 확보
			// select 실행 : executeQuery();
			// 그 외 실행 : executeUpdate();
			result = ps.executeUpdate();
			
			// 결과 활용
			System.out.println(result + " 행 이(가) 삽입되었습니다.");
			
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
 	
 	
 	// 자료 삭제 메소드
 	public int delete(TodoDTO dto) {
 		int result = -1;
		
 		try {
	 		// 접속
			Connection conn = getConnection();
			
			// SQL 준비
			String query = " delete tbl_todo";
			query 		+= " where tno = ?";	// 변수 방식
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, dto.getTno());
			
			// SQL 실행 및 결과 확보
			result = ps.executeUpdate();
			
			// 결과 활용
 		
			ps.close();
			conn.close();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return result;
 	}
 	
 	// 제목 누르면 상세 페이지로 메소드
 	public TodoDTO selectTodo(TodoDTO dto) {
 		TodoDTO resultDTO = null;
 		
 		try {
 			// DB 접속
 			Connection conn = getConnection();
 			// SQL 준비
 			String sql = "select * from tbl_todo";
 				   sql += " where tno=?";
 			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getTno());
 			// SQL 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
 			// 결과 활용	
			while( rs.next() ) {
				resultDTO = new TodoDTO();
				
				int tno = rs.getInt("tno");
				resultDTO.setTno(tno);
				resultDTO.setTitle( rs.getString("title") );				
				resultDTO.setDuedate( rs.getDate("duedate") );				
				resultDTO.setFinished( rs.getInt("finished") );				
			}
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return resultDTO;
 	}
 	
 	// 상세 페이지에서 수정하는 메소드
 	public int updateTodo(TodoDTO todoDTO) {
 		int result = -1;
 		
 		try {
 			// DB 접속
 			Connection conn = getConnection();
 			
 			// SQL 준비
 			String query = "";
 			query += " update tbl_todo";
 			query += " set title = ?,";
 			query += "     duedate = ?,";
 			query += "     finished = ?";
 			query += " where tno = ?";
 			
 			// SQL 실행 및 결과 확보
 			PreparedStatement ps = conn.prepareStatement(query);
 			ps.setString(1, todoDTO.getTitle());
 			ps.setDate(2, todoDTO.getDuedate());
 			ps.setInt(3, todoDTO.getFinished());
 			ps.setInt(4, todoDTO.getTno());
 			
 			// 결과 활용
 			result = ps.executeUpdate();
 			System.out.println(result + " 행 이(가) 업데이트 되었습니다.");
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		
 		
 		return result;
 	}
}
