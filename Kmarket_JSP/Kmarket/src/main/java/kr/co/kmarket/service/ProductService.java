package kr.co.kmarket.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.dao.ProductDAO;
import kr.co.kmarket.vo.ProductCartVO;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;
import kr.co.kmarket.vo.ProductOrderVO;
import kr.co.kmarket.vo.ProductReviewVO;
import kr.co.kmarket.vo.ProductVO;

public enum ProductService {
	INSTANCE;
	
	ProductDAO dao = ProductDAO.getInstance();

	// product list 
	public List<ProductVO> selectProductList(String cate1, String cate2, String listSort, int start){
		if(listSort == null || listSort.equals("")) listSort = "soldDesc";
		
		for(int i=0; i<listSort.length(); i++) {
			if(listSort.charAt(i)<= 90) {
				listSort = listSort.substring(0, i)+" "+listSort.substring(i)+" ";
				break;
			}
		}
		
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

	// 상품 한개 출력
	public ProductVO selectProduct(String prodNo) {
		return dao.selectProduct(prodNo);
	}
	
	// 리뷰 출력
	public List<ProductReviewVO> selectReviews(String prodNo, int start){
		return dao.selectReviews(prodNo, start);
	}
	
	// 리뷰 해당상품 전체갯수 출력
	public int selectCountTotalReview(String prodNo) {
		return dao.selectCountTotalReview(prodNo);
	}
	// 장바구니 입력
	public int insertProductCart(ProductCartVO vo) {
		
		// 장바구니에 이미 존재하는지 체크
		int result = dao.selectProductCart(vo.getUid(), vo.getProdNo());
		
		if(result > 0) {
			// 있으면
			return dao.updateProductCartCount(vo.getUid(), vo.getProdNo());
		}else {
			// 없으면 
			return dao.insertProductCart(vo);
		}
	}
	// 장바구니 출력
	public List<ProductCartVO> selectCarts(String uid) {
		return dao.selectProductCarts(uid);
	}
	
	// 장바구니 삭제
	public int deleteProductCart(String[] cartNo) {
		String sql = "";
		for(int i=0; i<cartNo.length; i++) {
			sql += cartNo[i];
			if(i != cartNo.length-1) {
				sql += ", ";
			}
		}
		sql += ")";
		return dao.deleteProductCart(sql);
	}
	
	// 상품 주문 입력
	public int insertProductOrder(ProductOrderVO vo) {
		return dao.insertProductOrder(vo);
	}
	
	// 주문 페이지 장바구니 부분 출력
	public List<ProductCartVO> selectProductCartForOrder(String[] cartNo){
		String sql = "";
		for(int i=0; i<cartNo.length; i++) {
			sql += cartNo[i];
			if(i != cartNo.length-1) {
				sql += ", ";
			}
		}
		sql += ")";
		
		return dao.selectProductCartForOrder(sql);
	}
	
	// 주문 페이지 전체 합계 출력
	public ProductOrderVO selectOrder(String uid) {
		return dao.selectOrder(uid);
	}
	// product order item 입력
	public int insertProductOrderItem(List<ProductCartVO> list) {
		return dao.insertProductOrderItem(list);
	}
	
	


	
	
	
	
	
	
	
	
	
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 5 == 0){
			lastPageNum = total / 5;
		}else{
			lastPageNum = total / 5 + 1;
		}
		return lastPageNum;
	}
	
	public int[] getPageGroupNum(int currentPage, int lastPageNum) {
		int currentPageGroup = (int)Math.ceil(currentPage / 5.0);
		int pageGroupStart = (currentPageGroup - 1) * 5 + 1;
		int pageGroupEnd = currentPageGroup * 5;
		if(pageGroupEnd > lastPageNum){
			pageGroupEnd = lastPageNum;
		}
		int[] result = {pageGroupStart, pageGroupEnd};
		return result;
	}
	
	public int getPageStartNum(int total, int currentPage) {
		int start = (currentPage - 1) * 5;
		return total - start;
	}
	
	public int getCurrentPage(String pg) {
		int currentPage = 1;
		if(pg != null && !pg.equals("")){
			currentPage = Integer.parseInt(pg);	
		}
		return currentPage;
	}
	
	public int getStartNum(int currentPage) {
		return (currentPage - 1) * 5;
	}
	
	// list json 변환 메서드 김지홍
	public void gsonTojson(Object obj, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/x-json; charset=UTF-8");
		Gson gson = new Gson();
		String jsonData = gson.toJson(obj);
		PrintWriter writer = resp.getWriter();
		writer.print(jsonData);
	}
	
	// json property 추가 후 json 반환
	public void jsonObj(String key, int value, HttpServletResponse resp) throws IOException {
		JsonObject json = new JsonObject();
		json.addProperty(key, value);
		PrintWriter writer = resp.getWriter();
		writer.print(json.toString());
	}
	
	public String getBody(HttpServletRequest request) throws IOException {
		 
		BufferedReader input = new BufferedReader(new InputStreamReader(request.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = input.readLine()) != null) {
            if (builder.length() > 0) {
                builder.append("\n");
            }
            builder.append(buffer);
        }
        return builder.toString();
    }
}
