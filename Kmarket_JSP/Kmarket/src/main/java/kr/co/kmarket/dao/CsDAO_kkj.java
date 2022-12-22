package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kkj;
import kr.co.kmarket.vo.CsCate2DTO;
import kr.co.kmarket.vo.CsFaqVO;
import kr.co.kmarket.vo.CsNoticeVO;

public class CsDAO_kkj extends DBHelper {

	private static CsDAO_kkj instance = new CsDAO_kkj();
	public static CsDAO_kkj getInstance() {
		return instance;
	}
	private CsDAO_kkj() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<CsNoticeVO> selectNoticeArticles(String cate1, int start) {
		logger.info("selectNoticeArticles start...");
		List<CsNoticeVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			
			if(cate1 == null) {
				 psmt = conn.prepareStatement(Sql_kkj.SELECT_NOTICE_ARTICLES);
				 psmt.setInt(1, start);
			}else {
				psmt = conn.prepareStatement(Sql_kkj.SELECT_NOTICE_ARTICLES_CATE1);
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
	
	
	public CsNoticeVO selectNoticeArticle(String notNo) {
		logger.info("selectNoticeArticle start...");
		CsNoticeVO vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_NOTICE_ARTICLE);
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
				
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : "+vo);
		return vo;
	}
	
	public int selectCountTotal() {
		int total = 0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(Sql_kkj.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	
	public int selectCountCateTotal(String cate1) {
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_COUNT_CATE_TOTAL);
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
	
	
	
	
	public List<CsFaqVO> selectFaqArticles(String cate1) {
		logger.info("selectFaqArticles start...");
		List<CsFaqVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_FAQ_ARTICLES);
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
	
	public List<CsCate2DTO> selectFaqCates(String cate1) {
		logger.info("selectFaqCates start...");
		List<CsCate2DTO> cates = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_FAQ_CATES);
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
	
	
	
	
	
	
	
	
	public CsFaqVO selectFaqArticle(String faNo) {
		logger.info("selectFaqArticle start...");
		CsFaqVO vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_FAQ_ARTICLE);
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
	
	
	
	
	
	
	
	
	
	
	
}