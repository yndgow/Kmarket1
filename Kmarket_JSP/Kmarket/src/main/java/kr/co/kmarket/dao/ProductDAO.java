package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kjh;
import kr.co.kmarket.vo.ProductCartVO;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;
import kr.co.kmarket.vo.ProductReviewVO;
import kr.co.kmarket.vo.ProductVO;

public class ProductDAO extends DBHelper {

	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<ProductVO> selectProductList(String cate1, String cate2, String listSort, int start){
		logger.info("selectProductList");
		
		List<ProductVO> products = new ArrayList<>();
		
		String sql_limit = "LIMIT " + start + ", 10"; 
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_PRODUCT_LIST+ listSort + sql_limit);
			logger.info(Sql_kjh.SELECT_PRODUCT_LIST);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
				vo.setDiscountPrice(rs.getInt(33));
				products.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("products : " + products);
		
		return products;
	}
	
	// 카테고리 1 출력
	public List<ProductCate1VO> selectCategory1(){
		logger.info("selectCategory1");
		List<ProductCate1VO> categories = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql_kjh.SELECT_CATEGORY_1);
			while(rs.next()) {
				ProductCate1VO vo = new ProductCate1VO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				categories.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("categories :" + categories);
		return categories;
	}
	
	// 카테고리 2 출력
	public List<ProductCate2VO> selectCategory2(){
		logger.info("selectCategory2");
		List<ProductCate2VO> categories2 = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql_kjh.SELECT_CATEGORY_2);
			while(rs.next()) {
				ProductCate2VO vo = new ProductCate2VO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				categories2.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("categories :" + categories2);
		return categories2;
	}
	
	
	// 상품 최대갯수 출력 
	public int selectCountTotal(String cate1, String cate2) {
		logger.info("selectCountTotal");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_PRODUCT_COUNT_PRODNO);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			rs = psmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1);
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + result);
		return result;
	}
	
	// 상품 한개 출력
	public ProductVO selectProduct(String prodNo) {
		logger.info("selectProduct");
		ProductVO vo = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_PRODUCT);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setProdNo(rs.getInt(1));
				vo.setProdCate1(rs.getInt(2));
				vo.setProdCate2(rs.getInt(3));
				vo.setProdName(rs.getString(4));
				vo.setDescript(rs.getString(5));
				vo.setCompany(rs.getString(6));
				vo.setSeller(rs.getString(7));
				vo.setPrice(rs.getInt(8));
				vo.setDiscount(rs.getInt(9));
				vo.setPoint(rs.getInt(10));
				vo.setStock(rs.getInt(11));
				vo.setSold(rs.getInt(12));
				vo.setDelivery(rs.getInt(13));
				vo.setHit(rs.getInt(14));
				vo.setScore(rs.getInt(15));
				vo.setReview(rs.getInt(16));
				vo.setThumb1(rs.getString(17));
				vo.setThumb2(rs.getString(18));
				vo.setThumb3(rs.getString(19));
				vo.setDetail(rs.getString(20));
				vo.setStatus(rs.getString(21));
				vo.setDuty(rs.getString(22));
				vo.setReceipt(rs.getString(23));
				vo.setBizType(rs.getString(24));
				vo.setOrigin(rs.getString(25));
				vo.setIp(rs.getString(26));
				vo.setRdate(rs.getString(27));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}
	
	// 상품 리뷰 출력
	public List<ProductReviewVO> selectReviews(String prodNo, int start){
		logger.info("selectReviews");
		List<ProductReviewVO> reviews = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_REVIEWS);
			psmt.setString(1, prodNo);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductReviewVO vo = new ProductReviewVO();
				vo.setRevNo(rs.getInt(1));
				vo.setProdNo(rs.getInt(2));
				vo.setContent(rs.getString(3));
				vo.setUid(rs.getString(4).replaceAll("(?<=.{3}).", "*"));
				vo.setRating(rs.getInt(5));
				vo.setRegip(rs.getString(6));
				vo.setRdate(rs.getString(7).substring(0,10));
				reviews.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("reviews : " + reviews);
		return reviews;
	}
	
	// 상품 리뷰 갯수 출력
	public int selectCountTotalReview(String prodNo) {
		logger.info("selectCountTotalReview");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_REVIEW_COUNT_PRODNO);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1);
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + result);
		return result;
	}
	
	// 장바구니 입력
	public int insertProductCart(ProductCartVO vo) {
		logger.info("insertProductCart");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.INSERT_PRODUCTCART);
			psmt.setString(1, vo.getUid());
			psmt.setInt(2, vo.getProdNo());
			psmt.setInt(3, vo.getCount());
			psmt.setInt(4, vo.getPrice());
			psmt.setInt(5, vo.getDiscount());
			psmt.setInt(6, vo.getDelivery());
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// 장바구니 출력
	public List<ProductCartVO> selectProductCarts(String uid) {
		logger.info("selectProductCarts");
		List<ProductCartVO> carts = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_PRODUCTCARTS);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductCartVO vo = new ProductCartVO();
				vo.setCartNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setProdNo(rs.getInt(3));
				vo.setCount(rs.getInt(4));
				vo.setPrice(rs.getInt(5));
				vo.setDiscount(rs.getInt(6));
				vo.setPoint(rs.getInt(7));
				vo.setDelivery(rs.getInt(8));
				vo.setTotal(rs.getInt(9));
				vo.setRdate(rs.getString(10));
				vo.setThumb1(rs.getString(11));
				vo.setDescript(rs.getString(12));
				vo.setProdName(rs.getString(13));
				carts.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("carts : " + carts);
		return carts;
	}
	
	// 장바구니 상품 존재여부
	public int selectProductCart(String uid, int prodNo) {
		logger.info("selectProductCart");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_PRODUCTCART);
			psmt.setString(1, uid);
			psmt.setInt(2, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// 장바구니 이미 있으면 수량 증가 
	public int updateProductCartCount(String uid, int prodNo) {
		logger.info("updateProductCartCount");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.UPDATE_PRODUCTCART_COUNT);
			psmt.setString(1, uid);
			psmt.setInt(2, prodNo);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// 장바구니 체크 삭제
	public int deleteProductCart(String sql) {
		int result = 0;
		logger.info("deleteProductCart");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.DELTE_PRODUCTCART + sql);
			
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	
	
	
	
	
}
