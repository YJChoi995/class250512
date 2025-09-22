package kr.or.human3;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {
	
	@RequestMapping("/join.do")
	public void joinForm(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/join2.do")
	public ModelAndView joinForm2() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		
		return mav;
	}
	
	@RequestMapping("/join3.do")
	public ModelAndView joinForm3() {
		// 들어는 왔다
		System.out.println("/join3.do 실행");
		
		// 나가지는 못했다
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping("/join1")
	public void join1(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id: " + id);
	}
	
	@RequestMapping("/join2")
	public ModelAndView join2(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id: " + id);
		
		request.setAttribute("id", id);
		
		ModelAndView mav = new ModelAndView("result");
		return mav;
	}
	
	@RequestMapping("/join3")
	public ModelAndView join3(HttpServletRequest request) {
		String id = request.getParameter("id");
		System.out.println("id: " + id);
	
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("id", id);
		return mav;
	}
	
	@RequestMapping("/join4")
	public ModelAndView join4(HttpServletRequest request) {
		MemberDTO memberDTO = new MemberDTO();
	
		try {
			String id = request.getParameter("id");
			System.out.println("id: " + id);
			String pw = request.getParameter("pw");
			String sAge = request.getParameter("age");
			int age = Integer.parseInt(sAge);
			
			memberDTO.setId(id);
			memberDTO.setPw(pw);
			memberDTO.setAge(age);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("memberDTO", memberDTO);
		return mav;
	}
	
	
	/////////////////////////////////////
	// @ParamMapping
	/////////////////////////////////////
	
	@RequestMapping("/join5")
	public ModelAndView join5(
			
			// String id - request.getParameter("id"); 와 같음
			// 기본적으로 필수 값. 그래서 없으면 400 Bad Request 코드 발생
			// 즉 required = true가 기본 값
			@RequestParam("id")
			String id,
			
			// @RequestParam("pw") String pw,
			@RequestParam(value="pw", required=false) 
			String pw,
			
			// 필수가 아님, 값이 없으면 null
			@RequestParam(value="name", required=false) 
			String name,
			
			@RequestParam("age") 
			int age,
			
			// parameter의 key가 변수명과 같다면 @RequestParam을 생략할 수 있다
			// key 없으면 null
			// 이 경우 아래줄이 생략된다. 필수가 아님에 주의!
            // @RequestParam(value="tel", required=false)
			String tel,
			
			String t, // null
//			int a    // null이고 형 변환 안되서 400 코드
			
			@RequestParam
			Map map
//			, @RequestParam에서 DTO는 사용할 수 없다
//			MemberDTO dto
			
			) {
		
		System.out.println("id: " + id);
		System.out.println("pw: " + pw);
		System.out.println("name: " + name);
		System.out.println("age: " + age);
		System.out.println("tel: " + tel);
		System.out.println("t: " + t);
		
		System.out.println("map: " + map);
//		System.out.println("dto: " + dto);
		ModelAndView mav = new ModelAndView("result");
		return mav;
	}
	
	
	/////////////////////////////////////////////////////////////////
	// @ModelAttribute
	/////////////////////////////////////////////////////////////////
	@RequestMapping("/join6")
	public ModelAndView join6(
			
			// parameter에서 꺼내서 DTO에 알어서 넣어 줌
			@ModelAttribute
			MemberDTO dto1,
			
			// DTO를 자동으로 채우고
			// 모델에 넣어주기 까지 함
			// 아랫줄을 대신해 줌
			// mav.addObject("memberDTO2", dto2);
			@ModelAttribute("memberDTO2")
			MemberDTO dto2,
			
			// @ModelAttribute 생략 가능함
			// 생략하면 타입(클래스)의 앞글자를 소문자로 변경한 key로
			// 모델에 넣어줌
			MemberDTO dto3
			
	) {
		System.out.println("dto1:" + dto1);
		System.out.println("dto2:" + dto2);
		System.out.println("dto3:" + dto3);
		
		ModelAndView mav = new ModelAndView("result");
//		mav.addObject("memberDTO", dto1);
//		mav.addObject("memberDTO2", dto2);
		
		return mav;		
	}
	
	
	@RequestMapping("/join7")
	public void join7(String id, MemberDTO dto) {
		
	}

	
	@RequestMapping("/cal/1")
	public void cal() {
		System.out.println("1월! 달력");
	}
	
	@RequestMapping("/cal/{month}")
	public void cal2(
			
			@PathVariable("month") // 생략 불가능
			int mon
			
			) {
		System.out.println(mon + "월 달력");
	}
	
	@RequestMapping("/lunch/{store}/order/{menu}/start")
	public void lunch(
			
			@PathVariable("store")
			String store,
			
			@PathVariable("menu")
			String menu
			
			) {
		System.out.println(store + "에서 " + menu + "를 준비합니다");
	}

	
	@RequestMapping("/join8")
	public String join8() {
		return "join";
	}
	
	@RequestMapping("/join9")
	public String join9() {
		return "redirect:join3.do";
	}
	
	@RequestMapping("/join10")
	public String join10() {
		return "forward:join3.do";
	}
	
	
	@RequestMapping("/join11")
	public String join11(Model model, String id) {
		
		System.out.println("/join11 실행, id: " + id);
		
		model.addAttribute("id", id);
		
		return "result";
	}
	
	
	@RequestMapping("/join12")
	public String join12() {
		return "join";
	}
	
	@RequestMapping(value={"/join13", "/join14"})
	public String join13() {
		return "join";
	}
	
	
	@RequestMapping(value="/join15", method=RequestMethod.POST)
	public String join15() {
		return "join";
	}
	
	@RequestMapping(value="/join15_1", method=RequestMethod.GET)
	public String join15_1() {
		return "join";
	}
	
	
	@RequestMapping(value="/join16", method= {RequestMethod.GET, RequestMethod.POST})
	public String join16() {
		return "join";
	}
	
	@RequestMapping("/join")
	public void join17() {
		System.out.println("/join 실행");
	}
}
