package kr.co.kmarket.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kjh;
import kr.co.kmarket.vo.ProductVO;

public class AdminDAO_kjh extends DBHelper {

	private static AdminDAO_kjh instance = new AdminDAO_kjh();
	public static AdminDAO_kjh getInstance() {
		return instance;
	}
	private AdminDAO_kjh() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProductVO selectImg(String prodNo) {
		ProductVO vo = null;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kjh.SELECT_IMG_FILENAME);
			psmt.setString(1, prodNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setThumb1(rs.getString(1));
				vo.setThumb2(rs.getString(2));
				vo.setThumb3(rs.getString(3));
				vo.setDetail(rs.getString(4));
			}
			close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		logger.debug("vo: "+vo);
		return vo;
		
	}
}
