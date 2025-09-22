package kr.or.human4.sevice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.human4.dao.EmpDAO;
import kr.or.human4.dto.EmpDTO;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	EmpDAO empDAO;
	
	@Override
	public List<EmpDTO> getEmpList() {
		List<EmpDTO> result = empDAO.selectEmpList();
		
		return result;
	}
	
	@Override
	public EmpDTO getEmp() {
		EmpDTO result = empDAO.selectEmpOne();
		
		return result;
	}
	
	@Override
	public Map getEmpMap() {
		Map result = empDAO.selectOneEmpMap();
		
		return result;
	}
	
	@Override
	public List getEmpno(int empno) {
		return empDAO.selectEmpno(empno);
	}
	
	@Override
	public List getEname(String ename) {
		return empDAO.selectEname(ename);
	}

}
