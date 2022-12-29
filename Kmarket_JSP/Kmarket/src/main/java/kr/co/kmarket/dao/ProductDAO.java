package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.ProductCartVO;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;
import kr.co.kmarket.vo.ProductOrderItemVO;
import kr.co.kmarket.vo.ProductOrderVO;
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

// SELECT
	
	// main index 베스트 상품 출력
	public List<ProductVO> selectMainBestList(){
		logger.info("selectMainBestList start...");
		
		List<ProductVO> products = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAIN_BEST_ARTICLES);
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
				vo.setEtc3(rs.getString(30));
				vo.setDiscountPrice(rs.getInt(33));
				products.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
		
	}
	// main index 히트 상품 출력
	public List<ProductVO> selectHitList(){
		logger.info("selectHitList start...");
		
		List<ProductVO> products = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAIN_HIT_ARTICLES);
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
				vo.setEtc3(rs.getString(30));
				vo.setDiscountPrice(rs.getInt(33));
				products.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
		
	}
	
	// main index 추천 상품 출력
	public List<ProductVO> selectScoreList(){
		logger.info("selectScoreList start...");
		
		List<ProductVO> products = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAIN_SCORE_ARTICLES);
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
				vo.setEtc3(rs.getString(30));
				vo.setDiscountPrice(rs.getInt(33));
				products.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
		
	}
	
	// main index 최신 상품 출력
	public List<ProductVO> selectNewList(){
		logger.info("selectNewList start...");
		
		List<ProductVO> products = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAIN_NEW_ARTICLES);
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
				vo.setEtc3(rs.getString(30));
				vo.setDiscountPrice(rs.getInt(33));
				products.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
		
	}
	
	
	// main index 할인 상품 출력
	public List<ProductVO> selectDisList(){
		logger.info("selectDisList start...");
		
		List<ProductVO> products = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_MAIN_DIS_ARTICLES);
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
				vo.setEtc3(rs.getString(30));
				vo.setDiscountPrice(rs.getInt(33));
				products.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return products;
		
	}
	
	
	
	
	
	// 상품 목록 출력
	public List<ProductVO> selectProductList(String cate1, String cate2, String listSort, int start){
		logger.info("selectProductList");
		
		List<ProductVO> products = new ArrayList<>();
		
		String sql_limit = "LIMIT " + start + ", 10"; 
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_LIST+ listSort + sql_limit);
			logger.info(Sql.SELECT_PRODUCT_LIST);
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
				vo.setEtc3(rs.getString(30));
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
			rs = stmt.executeQuery(Sql.SELECT_CATEGORY_1);
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
			rs = stmt.executeQuery(Sql.SELECT_CATEGORY_2);
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
	public int selectCountTotalProdCate1Cate2(String cate1, String cate2) {
		logger.info("selectCountTotalProdCate1Cate2");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_COUNT_PRODNO);
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
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT);
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
				vo.setEtc3(rs.getString(30));
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
			psmt = conn.prepareStatement(Sql.SELECT_REVIEWS);
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
				vo.setProdName(rs.getString(8));
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
			psmt = conn.prepareStatement(Sql.SELECT_REVIEW_COUNT_PRODNO);
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
	
	// 장바구니 출력
	public List<ProductCartVO> selectProductCarts(String uid) {
		logger.info("selectProductCarts");
		List<ProductCartVO> carts = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCTCARTS);
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
				vo.setEtc3(rs.getString(14));
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
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCTCART);
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

	// 주문 페이지 상품 부분 출력
	public List<ProductCartVO> selectProductCartForOrder(String sql, String uid){
		logger.info("selectProductCartForOrder");
		List<ProductCartVO> carts = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCTCART_FOR_ORDER + sql);
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
				vo.setEtc3(rs.getString(14));
				carts.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("carts : " + carts);
		return carts;
	}
	
	// 주문 페이지 전체합계 출력
	public ProductOrderVO selectOrder(String uid) {
		logger.info("selectOrder");
		ProductOrderVO vo = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_ORDER);
			psmt.setString(1, uid);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ProductOrderVO();
				vo.setOrdNo(rs.getInt(1));
				vo.setOrdUid(rs.getString(2));
				vo.setOrdCount(rs.getInt(3));
				vo.setOrdPrice(rs.getInt(4));
				vo.setOrdDiscount(rs.getInt(5));
				vo.setOrdDelivery(rs.getInt(6));
				vo.setSavePoint(rs.getInt(7));
				vo.setUsedPoint(rs.getInt(8));
				vo.setOrdTotPrice(rs.getInt(9));
				vo.setRecipName(rs.getString(10));
				vo.setRecipHp(rs.getString(11));
				vo.setRecipZip(rs.getString(12));
				vo.setRecipAddr1(rs.getString(13));
				vo.setRecipAddr2(rs.getString(14));
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : " + vo);
		return vo;
	}
	
	// 주문 완료 페이지 출력
	public List<ProductOrderVO> selectProductComplete(String ordNo) {
		logger.info("selectProductComplete");
		List<ProductOrderVO> completes = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_PRODUCT_COMPLETE);
			psmt.setString(1, ordNo);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductOrderVO vo = new ProductOrderVO();
				vo.setOrdNo(rs.getInt(1));
				vo.setOrdUid(rs.getString(2));
				vo.setOrdCount(rs.getInt(3));
				vo.setOrdPrice(rs.getInt(4));
				vo.setOrdDiscount(rs.getInt(5));
				vo.setOrdDelivery(rs.getInt(6));
				vo.setSavePoint(rs.getInt(7));
				vo.setUsedPoint(rs.getInt(8));
				vo.setOrdTotPrice(rs.getInt(9));
				vo.setRecipName(rs.getString(10));
				vo.setRecipHp(rs.getString(11));
				vo.setRecipZip(rs.getString(12));
				vo.setRecipAddr1(rs.getString(13));
				vo.setRecipAddr2(rs.getString(14));
				vo.setOrdPayment(rs.getInt(15));
				vo.setOrdComplete(rs.getInt(16));
				
				vo.setProdNo(rs.getInt(19));
				vo.setCount(rs.getInt(20));
				vo.setPrice(rs.getInt(21));
				vo.setDiscount(rs.getInt(22));
				vo.setPoint(rs.getInt(23));
				vo.setDelivery(rs.getInt(24));
				vo.setTotal(rs.getInt(25));
				vo.setProdName(rs.getString(26));
				vo.setDescript(rs.getString(27));
				vo.setThumb1(rs.getString(28));
				vo.setEtc3(rs.getString(29));
				completes.add(vo);
			}
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("completes : " + completes);
		return completes;
	}
	
	
	
// INSERT	
	// 장바구니 입력
	public int insertProductCart(ProductCartVO vo) {
		logger.info("insertProductCart");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCTCART);
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

	// product order 입력
	public int insertProductOrder(ProductOrderVO vo) {
		logger.info("insertProductOrder");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCTORDER);
			psmt.setString(1, vo.getOrdUid());
			psmt.setInt(2, vo.getOrdCount());
			psmt.setInt(3, vo.getOrdPrice());
			psmt.setInt(4, vo.getOrdDiscount());
			psmt.setInt(5, vo.getOrdDelivery());
			psmt.setInt(6, vo.getSavePoint());
			psmt.setInt(7, vo.getOrdTotPrice());
			psmt.setString(8, vo.getRecipName());
			psmt.setString(9, vo.getRecipHp());
			psmt.setString(10, vo.getRecipZip());
			psmt.setString(11, vo.getRecipAddr1());
			psmt.setString(12, vo.getRecipAddr2());
			
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// product order item 입력 장바구니 리스트 입력
	public int insertProductOrderItem(List<ProductCartVO> cartList, String ordNo) {
		int result = 0;
		for(int i=0; i<cartList.size(); i++) {
			logger.info("insertProductOrderItem LIST"+i);
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.INSERT_PRODUCTORDERITEM);
				psmt.setString(1, ordNo);
				psmt.setInt(2, cartList.get(i).getProdNo());
				psmt.setInt(3, cartList.get(i).getCount());
				psmt.setInt(4, cartList.get(i).getPrice());
				psmt.setInt(5, cartList.get(i).getDiscount());
				psmt.setInt(6, cartList.get(i).getPoint());
				psmt.setInt(7, cartList.get(i).getDelivery());
				psmt.setInt(8, cartList.get(i).getTotal());
				
				result += psmt.executeUpdate();
				close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		
		logger.debug("result : " + result);
		return result;
	}
	
	// product order item 입력
	public int insertProductOrderItem(ProductOrderItemVO vo) {
		int result = 0;
			logger.info("insertProductOrderItem VO");
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.INSERT_PRODUCTORDERITEM);
				psmt.setInt(1, vo.getOrdNo());
				psmt.setInt(2, vo.getProdNo());
				psmt.setInt(3, vo.getCount());
				psmt.setInt(4, vo.getPrice());
				psmt.setInt(5, vo.getDiscount());
				psmt.setInt(6, vo.getPoint());
				psmt.setInt(7, vo.getDelivery());
				psmt.setInt(8, vo.getTotal());
				
				result = psmt.executeUpdate();
				close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		
		logger.debug("result : " + result);
		return result;
	}

	// point 입력
	public int insertPoint(String uid, int point, String ordNo) {
		int result = 0;
		logger.info("insertPoint");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_POINT);
			psmt.setString(1, uid);
			psmt.setString(2, ordNo);
			psmt.setInt(3, point);
			
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	
// UPDATE
	// 상품 한개 출력 조회수 증가
	public int updateProductHit(String prodNo) {
		logger.info("updateProductHit");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_PRODUCT_HIT);
			psmt.setString(1, prodNo);
			result = psmt.executeUpdate();
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
			psmt = conn.prepareStatement(Sql.UPDATE_PRODUCTCART_COUNT);
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

	// 주문 정보 업데이트
	public int updateProductOrder(ProductOrderVO vo, String uid, String ordNo) {
		logger.info("updateProductOrder");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_PRODUCTORDER);
			psmt.setInt(1, vo.getUsedPoint());
			psmt.setInt(2, vo.getOrdTotPrice());
			psmt.setString(3, vo.getRecipName());
			psmt.setString(4, vo.getRecipHp());
			psmt.setString(5, vo.getRecipZip());
			psmt.setString(6, vo.getRecipAddr1());
			psmt.setString(7, vo.getRecipAddr2());
			psmt.setInt(8, vo.getOrdPayment());
			psmt.setInt(9, vo.getOrdComplete());
			psmt.setString(10, uid);
			psmt.setString(11, ordNo);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}

	// member DB 포인트 업데이트 추후 멤버로 이동
	public int updateMemberPoint(int point, String uid) {
		logger.info("updateMemberPoint");
		int result = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.UPDATE_MEMBER_POINT);
			psmt.setInt(1, point);
			psmt.setString(2, uid);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}

	// 주문 완료시 재고 감소
	public int updateProductStock(List<ProductOrderVO> completes) {
		int result = 0;
		for(int i=0; i<completes.size(); i++) {
			logger.info("updateProductStock "+i);
			try {
				conn = getConnection();
				psmt = conn.prepareStatement(Sql.UPDATE_PRODUCT_STOCK);
				psmt.setInt(1, completes.get(i).getCount());
				psmt.setInt(2, completes.get(i).getProdNo());
				result += psmt.executeUpdate();
				close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		logger.debug("result : " + result);
		return result;
	}
	
// DELTE
	// 장바구니 체크 삭제
	public int deleteProductCart(String sql) {
		int result = 0;
		logger.info("deleteProductCart");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_PRODUCTCART + sql);
			
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	// 장바구니 주문 물품 삭제
	public int deleteProductCartOrderd(String sql) {
		int result = 0;
		logger.info("deleteProductCartOrderd");
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.DELETE_PRODUCTCART_ORDERED + sql);
			result = psmt.executeUpdate();
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}	
	
	
	
	
}
