package kr.or.human4.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.human4.dto.EmpDTO;
import kr.or.human4.sevice.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/listEmp")
	public String listEmp(Model model) {
		
		List<EmpDTO> list = empService.getEmpList();
		
		model.addAttribute("list", list);
		
		return "emp";
	}
	
	@RequestMapping("/empOne")
	public String empOne(Model model) {
		
		EmpDTO empDTO = empService.getEmp();
		
		model.addAttribute("empDTO", empDTO);
		
		return "emp";
	}
	
	@RequestMapping("/empOneMap")
	public String empOneMap(Model model) {
		
		Map map = empService.getEmpMap();
		
		model.addAttribute("map", map);
		
		return "emp";
	}
	
	@RequestMapping("/getEmpno")
	public String getEmpno(Model model, int empno) {
		System.out.println("empno: " + empno);
		List list = empService.getEmpno(empno);
		
		model.addAttribute("list", list);
		return "emp";
	}
	
	@RequestMapping("/getEname")
	public String getEname(Model model, String ename) {
		System.out.println("ename: " + ename);
		List list = empService.getEname(ename);
		
		model.addAttribute("list", list);
		return "emp";
	}
	

}
