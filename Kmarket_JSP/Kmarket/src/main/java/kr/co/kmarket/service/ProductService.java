package kr.co.kmarket.service;

import java.util.List;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;
import kr.co.kmarket.vo.ProductVO;

public enum ProductService {
	INSTANCE;
	
	ProductDAO dao = ProductDAO.getInstance();

	// product list 
	public List<ProductVO> selectProductList(String cate1, String cate2, String listSort, int start){
		return dao.selectProductList(cate1, cate2, listSort, start);
	}
	
	// category1 list
	public List<ProductCate1VO> selectCategory1(){
		return dao.selectCategory1();
	}
	
	// category2 list
	public List<ProductCate2VO> selectCategory2(){
		return dao.selectCategory2();
	}
	
	// 전체 게시물 갯수 where cate1, cate2
	public int selectCountTotal(String cate1, String cate2) {
		return dao.selectCountTotal(cate1, cate2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 == 0){
			lastPageNum = total / 10;
		}else{
			lastPageNum = total / 10 + 1;
		}
		return lastPageNum;
	}
	
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
		int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
		int pageGroupEnd = currentPageGroup * 10;
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		int[] result = {pageGroupStart, pageGroupEnd};
		return result;
	}
	
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 10;
		return total - start;
	}
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null){
			currentPage = Integer.parseInt(pg);	
		}
		return currentPage;
	}
	
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 10;
	}
}
