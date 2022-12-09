package kr.co.kmarket.service;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberTermsVO;

public enum MemberService {
	INSTANCE;
	
	MemberDAO dao = MemberDAO.getInstance();
	
	public MemberTermsVO selectTerms() {
		return dao.selectTerms();
	}
}
