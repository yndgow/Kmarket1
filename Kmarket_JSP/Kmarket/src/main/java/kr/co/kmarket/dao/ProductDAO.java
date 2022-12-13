package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kjh;
import kr.co.kmarket.vo.ProductCate1VO;
import kr.co.kmarket.vo.ProductCate2VO;
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
		if(listSort == null) listSort = "soldDesc";
		List<ProductVO> products = new ArrayList<>();
		String sort[] = {"soldDesc", "priceAsc", "priceDesc", "scoreDesc", "reviewDesc", "rdateDesc"};
		String sql_txt[] = {"`sold` DESC", "`price` DESC", "`price` ASC", "`score` DESC", "`review` DESC", "`rdate` DESC"};
		String sql_sort= "";
		for(int i=0; i<sort.length; i++) {
			if(listSort.equals(sort[i])) {
				sql_sort = sql_txt[i];
			}
		}
		logger.info(sql_sort);
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_PRODUCT_LIST);
			logger.info(Sql_kjh.SELECT_PRODUCT_LIST);
			psmt.setString(1, cate1);
			psmt.setString(2, cate2);
			psmt.setString(3, sql_sort);
			psmt.setInt(4, start);
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
}
