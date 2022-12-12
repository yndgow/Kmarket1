package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.ProductVO;

public enum ProductService {
	INSTANCE;
	
	ProductDAO dao = ProductDAO.getInstance();

	// product list 
	public List<ProductVO> selectProductList(String listSort){
		return dao.selectProductList(listSort);
	}
	
	
}
