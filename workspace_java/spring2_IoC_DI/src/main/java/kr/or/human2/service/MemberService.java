package kr.or.human2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kr.or.human2.dao.MemberDAO;

@Service
public class MemberService {

	// 1. 강한 의존 상태
//	public List getList() {
//		MemberDAO memberDAO = new MemberDAOImpl();
//		
//		return memberDAO.select();
//	}
	
	// 2. 전달 받아서 의존성을 낮춘 상태(약하게 만듦)
//	public List getList(MemberDAO memberDAO) {
//		return memberDAO.select();
//	}
	
//	private MemberDAO memberDAO = null;
	
	@Qualifier("dao1")
	@Autowired
	MemberDAO memberDAO;
	
	
//	public void setMemberDAo(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
//	
//	MemberService(MemberDAO memberDAO){
//		this.memberDAO = memberDAO;
//	}
	
	public List getList() {
		return this.memberDAO.select();
	}

}
