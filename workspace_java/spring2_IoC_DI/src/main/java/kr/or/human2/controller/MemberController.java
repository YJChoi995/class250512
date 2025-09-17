package kr.or.human2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.human2.service.MemberService;

@Controller
public class MemberController {
	
	// 생성자
	MemberController(){
		System.out.println("MemberController 생성자 실행");
	}
	
	
	// 메소드
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/member")
	String listMember() {
		System.out.println("MemberController listMember() 실행");
		
//		MemberService memberService = new MemberService();
		List list = memberService.getList();
		System.out.println("list: " + list);
		
		return "home";
	}

}
