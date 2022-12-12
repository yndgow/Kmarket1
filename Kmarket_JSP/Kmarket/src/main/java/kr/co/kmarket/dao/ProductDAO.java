package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kjh;
import kr.co.kmarket.vo.ProductVO;

public class ProductDAO extends DBHelper {

	private static ProductDAO instance = new ProductDAO();
	public static ProductDAO getInstance() {
		return instance;
	}
	private ProductDAO() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<ProductVO> selectProductList(String listSort){
		logger.info("selectProductList");
		if(listSort == null) listSort = "soldDesc";
		List<ProductVO> products = new ArrayList<>();
		String sort[] = {"soldDesc", "priceAsc", "priceDesc", "scoreDesc", "reviewDesc", "rdateDesc"};
		String sql_txt[] = {
							Sql_kjh.SELECT_PRODUCT_LIST_SOLD_DESC, 
							Sql_kjh.SELECT_PRODUCT_LIST_PRICE_ASC,
							Sql_kjh.SELECT_PRODUCT_LIST_PRICE_DESC, 
							Sql_kjh.SELECT_PRODUCT_LIST_SCORE_DESC,
							Sql_kjh.SELECT_PRODUCT_LIST_REVIEW_DESC, 
							Sql_kjh.SELECT_PRODUCT_LIST_RDATE_DESC,
							};
		String sql_list = "";
		for(int i=0; i<sort.length; i++) {
			if(listSort.equals(sort[i])) {
				sql_list = sql_txt[i];
			}
		}
		logger.info(sql_list);
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_list);
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
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("products : " + products);
		return products;
	}
}
