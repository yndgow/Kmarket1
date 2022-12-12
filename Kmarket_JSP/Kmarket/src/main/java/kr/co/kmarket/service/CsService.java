package kr.co.kmarket.service;

import kr.co.kmarket.dao.CsDAO;
import kr.co.kmarket.vo.CsQnaVO;

public enum CsService {
	INSTANCE;
	CsDAO dao = CsDAO.getInstance();
	
	//cs 문의하기 등록 홍민준
	public int InsertArticleQnaOfCs(CsQnaVO vo){
		return dao.InserArticleQna(vo);
	}
	
}
