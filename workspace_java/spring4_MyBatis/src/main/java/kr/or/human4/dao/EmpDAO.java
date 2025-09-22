package kr.or.human4.dao;

import java.util.List;
import java.util.Map;

import kr.or.human4.dto.EmpDTO;

public interface EmpDAO {
	
	public List<EmpDTO> selectEmpList();
	public EmpDTO selectEmpOne();
	public Map selectOneEmpMap();
	public List selectEmpno(int empno);
	public List selectEname(String ename);

}
