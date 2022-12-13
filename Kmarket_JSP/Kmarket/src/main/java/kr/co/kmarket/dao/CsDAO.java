package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.db.Sql_hong;
import kr.co.kmarket.vo.CsCate1VO;
import kr.co.kmarket.vo.CsCate2VO;
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
			psmt.setString(2, vo.getQc1Name());
			psmt.setString(3, vo.getQc2Name());
			psmt.setString(4, vo.getQnaTitle());
			psmt.setString(5, vo.getQnaContent());
			psmt.setString(6, vo.getRegip());

			result = psmt.executeUpdate();
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	
	//cs cate1 출력
	public List<CsCate1VO> selectCate1ByCs(){
		logger.info("select cate1 start...");
		List<CsCate1VO> cates = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql_hong.SELECT_CATEGORY1_BY_CS);
			while(rs.next()){
				CsCate1VO vo = new CsCate1VO();
				vo.setQnaCate1(rs.getInt(1));
				vo.setQc1Name(rs.getString(2));
				cates.add(vo);
				
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cates : "+cates);
		return cates;
		
		
	}
	
	//cs cate2 출력
	public List<CsCate2VO> selectCate2ByCs(String cate2){
		logger.info("select cate2 start...");
		List<CsCate2VO> cates = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_hong.SELECT_CATEGORY2_BY_CS);
			psmt.setString(1, cate2);
			rs = psmt.executeQuery();
			while(rs.next()){
				CsCate2VO vo = new CsCate2VO();
				vo.setQnaCate1(rs.getInt(1));
				vo.setQnaCate2(rs.getInt(2));
				vo.setQc2Name(rs.getString(3));
				cates.add(vo);
				
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cates : "+cates);
		return cates;
		
	}
	
	//cs list 출력
	public List<CsQnaVO> selectQnaArticles() {
		logger.info("selectQnaArticles start...");
		List<CsQnaVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql_hong.SELECT_QNA_ARTICLES);
			while(rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo.setUid(rs.getString(1));
				vo.setQc1Name(rs.getString(2));
				vo.setQc2Name(rs.getString(3));
				vo.setQnaTitle(rs.getString(4));
				vo.setQnaContent(rs.getString(5));
				vo.setRegip(rs.getString(6));
				vo.setWdate(rs.getString(7));
				vo.setQnaCond(rs.getString(8));
				articles.add(vo);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
