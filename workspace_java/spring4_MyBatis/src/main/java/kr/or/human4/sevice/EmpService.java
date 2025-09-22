package kr.or.human4.sevice;

import java.util.List;
import java.util.Map;

import kr.or.human4.dto.EmpDTO;

public interface EmpService {
	
	public List<EmpDTO> getEmpList();
	public EmpDTO getEmp();
	public Map getEmpMap();
	public List getEmpno(int empno);
	public List getEname(String ename);

}
