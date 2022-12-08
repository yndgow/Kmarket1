package kr.co.kmarket.service;

import kr.co.kmarket.dao.AdminDAO;
import kr.co.kmarket.vo.ProductVO;

public enum AdminService {
	INSTANCE;
	AdminDAO dao = AdminDAO.getInstance();
	
	public int insertProductByAdmin(ProductVO vo) {
		return dao.insertProductByAdmin(vo);
		
	}
}
