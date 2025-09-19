package kr.or.human3;

import org.springframework.web.bind.annotation.RequestMapping;

public class MesController {

//	@RequestMapping("/mes/bom")
//	public String bom() {
//		return "bom";
//	}
//	
//	@RequestMapping("/mes/standard")
//	public String standard() {
//		return "standard";
//	}
	
	
	
	@RequestMapping("/bom")
	public String bom() {
		return "bom";
	}
	
	
	@RequestMapping("/standard")
	public String standard() {
		
		
		return "standard";
	}
}
