package emp.service;

import java.util.List;

import emp.dao.EmpDAO;
import emp.dto.EmpDTO;

public class EmpService {

	EmpDAO empDAO = new EmpDAO();
	
	public List<EmpDTO> getAllEmp() {
		List list = empDAO.selectAllEMP();
		return list;
	}
	
	public EmpDTO getOneEmp(EmpDTO empDTO) {
		EmpDTO dto = empDAO.selectOneEmp(empDTO);
		return dto;
	}
	
	public int removeEmp(EmpDTO empDTO) {
		return empDAO.deleteEmp(empDTO);
	}

}
