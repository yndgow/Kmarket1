package kr.co.kmarket.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_hong;
import kr.co.kmarket.vo.CsQnaVO;

public class CsDAO extends DBHelper {

	private static CsDAO instance = new CsDAO();
	public static CsDAO getInstance() {
		return instance;
	}
	private CsDAO() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//cs 문의하기 등록
	public int InserArticleQna(CsQnaVO vo) {
		logger.info("InserArticleQna start...");
		int result = 0;
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_hong.INSERT_ARTICLE_QNA_OF_CS);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getQnaTitle());
			psmt.setString(3, vo.getQnaContent());
			psmt.setString(4, vo.getRegip());

			result = psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	
	
	
}
