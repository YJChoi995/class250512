package kr.or.human2.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("memberDAOImpl2")
@Primary
public class MemberDAOImpl2 implements MemberDAO {
	
	@Override
	public List select() {
		List list = new ArrayList();
		list.add("하나");
		list.add("둘");
		list.add("셋");
		
		return list;
	}

}
