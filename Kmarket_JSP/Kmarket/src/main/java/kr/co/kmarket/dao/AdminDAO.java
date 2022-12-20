package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.db.Sql_Kbs;
import kr.co.kmarket.vo.ProductCate1VO;

import kr.co.kmarket.vo.ProductOrderVO;
import kr.co.kmarket.vo.ProductCate2VO;

import kr.co.kmarket.vo.ProductVO;

public class AdminDAO extends DBHelper {

	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	private AdminDAO() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// admin 상품 등록	
	public int insertProductByAdmin(ProductVO vo) {
		logger.info("insertProductByAdmin...");
		int result = 0;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_PRODUCT_BY_ADMIN);
			psmt.setInt(1, vo.getProdCate1());
			psmt.setInt(2, vo.getProdCate2());
			psmt.setString(3, vo.getProdName());
			psmt.setString(4, vo.getDescript());
			psmt.setString(5, vo.getCompany());
			psmt.setInt(6, vo.getPrice());
			psmt.setInt(7, vo.getDiscount());
			psmt.setInt(8, vo.getPoint());
			psmt.setInt(9, vo.getStock());
			psmt.setInt(10, vo.getDelivery());
			psmt.setString(11, vo.getThumb1());
			psmt.setString(12, vo.getThumb2());
			psmt.setString(13, vo.getThumb3());
			psmt.setString(14, vo.getDetail());
			psmt.setString(15, vo.getSeller());
			psmt.setString(16, vo.getStatus());
			psmt.setString(17, vo.getDuty());
			psmt.setString(18, vo.getReceipt());
			psmt.setString(19, vo.getBizType());
			psmt.setString(20, vo.getOrigin());
			psmt.setString(21, vo.getIp());
			
			result = psmt.executeUpdate();
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + result);
		return result;
	}
	
	// admin 등록한 상품 리스트 김지홍
	public List<ProductVO> selectProductByAdmin(String uid) {
		logger.info("selectProductByAdmin...");
		List<ProductVO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_PRODUCT_BY_ADMIN);
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	
	// admin 카테고리 리스트 출력 	

	public List<ProductCate1VO> selectCategory1ByAdmin() {
		logger.info("selectCategory1ByAdmin...");
		List<ProductCate1VO> cates = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_CATEGORY1_BY_ADMIN);
			while(rs.next()) {
				ProductCate1VO vo = new ProductCate1VO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
				cates.add(vo);
			}
			
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cates :" + cates);
		return cates;
	}

	// admin 카테고리2 리스트 출력 	
	public List<ProductCate2VO> selectCategory2ByAdmin(String cate2) {
		logger.info("selectCategory2ByAdmin...");
		List<ProductCate2VO> cates = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CATEGORY2_BY_ADMIN);
			psmt.setString(1, cate2);
			rs = psmt.executeQuery();
			while(rs.next()) {
				ProductCate2VO vo = new ProductCate2VO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				cates.add(vo);
			}
			
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cates :" + cates);
		return cates;
	}
	
	// admin 리스트 페이지
	public List<ProductVO> selectProducts(String seller, int start) {
		logger.info("selectProducts...");
		List<ProductVO> products = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_Kbs.SELECT_PRODUCTS);
			psmt.setString(1, seller);
			psmt.setInt(2, start);
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	
	public int selectCountTotal() {
		int result = 0;
		try {
			logger.info("selectCountTotal...");
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql_Kbs.SELECT_COUNT_TOTAL);
			if(rs.next()) result = rs.getInt(1);
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	public int selectCountTotal(String keyword, String searchCate) {
		int result = 0;
		try {
			logger.info("selectCountTotalkeyword...");
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_Kbs.SELECT_COUNT_TOTAL_FOR_SEARCH +searchCate +" LIKE ?" + "LIMIT 0, 10");
			psmt.setString(1, "%" + keyword + "%");
			rs = psmt.executeQuery();
			if(rs.next()) result = rs.getInt(1);
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result : " + result);
		return result;
	}
	
	public List<ProductVO> selectproductByKeyword(String keyword, int start, String searchCategory) {
		logger.info("selectProductByAdmin...");
		List<ProductVO> products = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement("SELECT * FROM `km_product` WHERE "+ searchCategory + " LIKE ? LIMIT ?,10");
			psmt.setString(1, "%"+keyword+"%");
		
			psmt.setInt(2, start);
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
				products.add(vo);
			}
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + products);
		return products;
	}
	
	// 선택삭제
	public int deleteAdmin(String prodNo) {
		int result1 = 0;
		
		try {
			logger.info("deleteAdmin...");
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql_Kbs.DELETE_ADMIN);
			psmt.setString(1, prodNo);
			result1 = psmt.executeUpdate();
			
			close();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result1 : " + result1);
		return result1;
	}
	
	
	
	
	
	
	
}
