package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql_kkj;
import kr.co.kmarket.vo.CsNoticeVO;

public class CsDAO_kkj extends DBHelper {

	private static CsDAO_kkj instance = new CsDAO_kkj();
	public static CsDAO_kkj getInstance() {
		return instance;
	}
	private CsDAO_kkj() {}
	
	// 로거 생성
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<CsNoticeVO> selectNoticeArticles(int start) {
		logger.info("selectNoticeArticles start...");
		List<CsNoticeVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_NOTICE_ARTICLES);
			psmt.setInt(1, start);
			rs = psmt.executeQuery();
			while(rs.next()) {
				CsNoticeVO vo = new CsNoticeVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setCate1(rs.getInt(4));
				vo.setC1Name(rs.getString(5));
				vo.setC2Name(rs.getString(6));
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
	
	
	public CsNoticeVO selectNoticeArticle(String no) {
		logger.info("selectNoticeArticle start...");
		CsNoticeVO vo = null;
		
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_kkj.SELECT_NOTICE_ARTICLE);
			psmt.setString(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo = new CsNoticeVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setCate1(rs.getInt(4));
				vo.setC1Name(rs.getString(5));
				vo.setC2Name(rs.getString(6));
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}