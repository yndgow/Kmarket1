package kr.co.kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.ProductVO;

public class AdminDAO extends DBHelper {

	private static AdminDAO instance = new AdminDAO();
	public static AdminDAO getInstance() {
		return instance;
	}
	private AdminDAO() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
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
			//psmt.setString(6, vo.getSeller());
			psmt.setInt(6, vo.getPrice());
			result = psmt.executeUpdate();
			close();
		} catch(Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result :" + result);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
}
