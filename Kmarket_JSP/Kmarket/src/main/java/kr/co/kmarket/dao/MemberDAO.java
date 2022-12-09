package kr.co.kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.Sql_kkj;
import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.vo.MemberTermsVO;

public class MemberDAO extends DBHelper {

	private static MemberDAO instance = new MemberDAO();
	public static MemberDAO getInstance() {
		return instance;
	}
	private MemberDAO() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public MemberTermsVO selectTerms() {
			
		MemberTermsVO vo = null;
			try {
				logger.info("selectTerms start...");
				
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(Sql_kkj.SELECT_TERMS);
				
				if(rs.next()) {
					vo = new MemberTermsVO();
					vo.setTerms(rs.getString(1));
					vo.setFinance(rs.getString(2));
					vo.setPrivacy(rs.getString(3));
					vo.setLocation(rs.getString(4));
					vo.setTax(rs.getString(5));
					
				}
				
				close();
				
			}catch (Exception e) {
				logger.error(e.getMessage());
			}
			
			logger.debug("vo : " + vo);
			return vo;
		} 
	
	
	
	
	
	
}
