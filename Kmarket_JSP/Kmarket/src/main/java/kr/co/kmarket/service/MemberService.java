package kr.co.kmarket.service;

import kr.co.kmarket.dao.MemberDAO;
import kr.co.kmarket.vo.MemberTermsVO;
import kr.co.kmarket.vo.MemberVO;

public enum MemberService {
	INSTANCE;
	
	MemberDAO dao = MemberDAO.getInstance();
	
	// 약관
	public MemberTermsVO selectTerms() {
		return dao.selectTerms();
	}
	
	// 로그인
	public MemberVO selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
}
