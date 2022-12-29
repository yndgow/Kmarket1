package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
import kr.co.kmarket.vo.CsFaqVO;
import kr.co.kmarket.vo.CsNoticeVO;
import kr.co.kmarket.vo.CsQnaVO;

public class CsDAO extends DBHelper {

	private static CsDAO instance = new CsDAO();
	public static CsDAO getInstance() {
		return instance;
	}
	private CsDAO() {}

	// 정규식 (3자 뒤 부터 마스킹 처리)
	String pattern = "(?<=.{3}).";
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//cs 문의하기 등록
	public int InserArticleQna(CsQnaVO vo) {
		logger.info("InserArticleQna start...");
		int result = 0;
		
		try{
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.INSERT_ARTICLE_QNA_OF_CS);
			psmt.setString(1, vo.getUid());
			psmt.setInt(2, vo.getCate1());
			psmt.setInt(3, vo.getCate2());
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
	public List<CsCate1DTO> selectCate1ByCs(){
		logger.info("select cate1 start...");
		List<CsCate1DTO> cates = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(Sql.SELECT_CATEGORY1_BY_CS);
			while(rs.next()){
				CsCate1DTO vo = new CsCate1DTO();
				vo.setCate1(rs.getInt(1));
				vo.setC1Name(rs.getString(2));
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
	public List<CsCate2DTO> selectCate2ByCs(String cate2){
		logger.info("select cate2 start...");
		List<CsCate2DTO> cates = new ArrayList<>();
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_CATEGORY2_BY_CS);
			psmt.setString(1, cate2);
			rs = psmt.executeQuery();
			while(rs.next()){
				CsCate2DTO vo = new CsCate2DTO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				cates.add(vo);
				
			}
			
			close();
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("cates : "+cates);
		return cates;
		
	}
	
	
	//index list 출력
		public List<CsQnaVO> selectIndexQnaArticles() {
			logger.info("selectIndexQnaArticles start...");
			List<CsQnaVO> articles = new ArrayList<>();
			try {
				conn = getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(Sql.SELECT_INDEX_QNA_ARTICELS);
				while(rs.next()) {
					CsQnaVO vo = new CsQnaVO();
					vo.setQnaNo(rs.getInt(1));
					vo.setUid(rs.getString(2).replaceAll(pattern, "*"));
					vo.setCate1(rs.getInt(3));
					vo.setCate2(rs.getInt(4));
					vo.setQnaTitle(rs.getString(5));
					vo.setQnaContent(rs.getString(6));
					vo.setRegip(rs.getString(7));
					vo.setRdate(rs.getString(8));
					vo.setQnaCond(rs.getString(9));
					vo.setAnswer(rs.getString(10));
					vo.setC2Name(rs.getString(11));
					articles.add(vo);
				}
				close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
			logger.debug("articles : "+articles);
			return articles;
		}
	
	
	//cs list 출력
	public List<CsQnaVO> selectQnaArticles(String cate1 ,int start) {
		logger.info("selectQnaArticles start...");
		List<CsQnaVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_QNA_ARTICLES);
			psmt.setString(1, cate1);
			psmt.setInt(2, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsQnaVO vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt(1));
				vo.setUid(rs.getString(2).replaceAll(pattern, "*"));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setQnaTitle(rs.getString(5));
				vo.setQnaContent(rs.getString(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				vo.setQnaCond(rs.getString(9));
				vo.setC1Name(rs.getString(10));
				vo.setC2Name(rs.getString(11));
				articles.add(vo);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("articles : "+articles);
		return articles;
	}
	
	// 전체 게시물 쿠은트 /// ????
	public int selectCountTotalQnaCate1(String cate1) {
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL_QNA_CATE1);
			psmt.setString(1, cate1);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	//cs view 출력
	public CsQnaVO selectQnaArticle(String qnaNo) {
		logger.info("selectQnaArticle start...");
		CsQnaVO vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_QNA_ARTICLE);
			psmt.setString(1, qnaNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsQnaVO();
				vo.setQnaNo(rs.getInt(1));
				vo.setUid(rs.getString(2).replaceAll(pattern, "*"));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setQnaTitle(rs.getString(5));
				vo.setQnaContent(rs.getString(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				vo.setQnaCond(rs.getString(9));
				vo.setAnswer(rs.getString(10));
				vo.setC2Name(rs.getString(11));
				
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : "+vo);
		return vo;
	}
	
	
	
	/////// kkj
	// notice list
	public List<CsNoticeVO> selectNoticeArticles(String cate1, int start) {
		logger.info("selectNoticeArticles start...");
		List<CsNoticeVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			
			if(cate1 == null) {
				 psmt = conn.prepareStatement(Sql.SELECT_NOTICE_ARTICLES);
				 psmt.setInt(1, start);
			}else {
				psmt = conn.prepareStatement(Sql.SELECT_NOTICE_ARTICLES_CATE1);
				psmt.setString(1, cate1);
				psmt.setInt(2, start);
			}
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNotNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setNotTitle(rs.getString(4));
				vo.setNotContent(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				articles.add(vo);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	
	// notice view
	public CsNoticeVO selectNoticeArticle(String notNo) {
		logger.info("selectNoticeArticle start...");
		CsNoticeVO vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_NOTICE_ARTICLE);
			psmt.setString(1, notNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsNoticeVO();
				vo.setNotNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setNotTitle(rs.getString(4));
				vo.setNotContent(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				vo.setC1Name(rs.getString(9));
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : "+vo);
		return vo;
	}
	
	
	// notice list 전체 페이징작업
	public int selectCountTotalNotice() {
		int total = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(Sql.SELECT_COUNT_TOTAL_NOTICE);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	
	// notice list 카테고리별 페이징작업
	public int selectCountCateTotal(String cate1) {
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_COUNT_TOTAL_NOTICE_CATE1);
			psmt.setString(1, cate1);
			
			rs = psmt.executeQuery();
			
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	
	
	// faq list
	public List<CsFaqVO> selectFaqArticles(String cate1) {
		logger.info("selectFaqArticles start...");
		List<CsFaqVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_FAQ_ARTICLES);
			psmt.setString(1, cate1);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsFaqVO vo = new CsFaqVO();
				vo.setFaNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setFaTitle(rs.getString(5));
				vo.setFaContent(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9));
				vo.setC1Name(rs.getString(10));
				vo.setC2Name(rs.getString(11));
				articles.add(vo);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	// faq list 카테고리 정보 불러오기
	public List<CsCate2DTO> selectFaqCates(String cate1) {
		logger.info("selectFaqCates start...");
		List<CsCate2DTO> cates = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_FAQ_CATES);
			psmt.setString(1, cate1);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsCate2DTO vo = new CsCate2DTO();
				vo.setCate1(rs.getInt(1));
				vo.setCate2(rs.getInt(2));
				vo.setC2Name(rs.getString(3));
				
				cates.add(vo);
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return cates;
	}
	
	
	
	
	
	
	
	// faq view
	public CsFaqVO selectFaqArticle(String faNo) {
		logger.info("selectFaqArticle start...");
		CsFaqVO vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql.SELECT_FAQ_ARTICLE);
			psmt.setString(1, faNo);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsFaqVO();
				vo.setFaNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setCate2(rs.getInt(4));
				vo.setFaTitle(rs.getString(5));
				vo.setFaContent(rs.getString(6));
				vo.setHit(rs.getInt(7));
				vo.setRegip(rs.getString(8));
				vo.setRdate(rs.getString(9));
				
				
				
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : "+vo);
		return vo;
	}
	
	// index화면에 notice 최신글 5개 불러오기
	public List<CsNoticeVO> selectIndexNoticeArticles() {
		logger.info("selectIndexNoticeArticles start...");
		List<CsNoticeVO> articles = new ArrayList<>();
		
		try {
			
			conn = getConnection();
			
			psmt = conn.prepareStatement(Sql.SELECT_INDEX_NOTICES);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNotNo(rs.getInt(1));
				vo.setUid(rs.getString(2));
				vo.setCate1(rs.getInt(3));
				vo.setNotTitle(rs.getString(4));
				vo.setNotContent(rs.getString(5));
				vo.setHit(rs.getInt(6));
				vo.setRegip(rs.getString(7));
				vo.setRdate(rs.getString(8));
				articles.add(vo);
			}
			close();
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return articles;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
