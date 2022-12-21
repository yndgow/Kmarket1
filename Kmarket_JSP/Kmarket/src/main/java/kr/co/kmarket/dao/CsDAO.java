package kr.co.kmarket.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.kmarket.db.DBHelper;
import kr.co.kmarket.db.Sql;
import kr.co.kmarket.db.Sql_hong;
import kr.co.kmarket.vo.CsCate1DTO;
import kr.co.kmarket.vo.CsCate2DTO;
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
			psmt = conn.prepareStatement(Sql_hong.INSERT_ARTICLE_QNA_OF_CS);
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
			rs = stmt.executeQuery(Sql_hong.SELECT_CATEGORY1_BY_CS);
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
			psmt = conn.prepareStatement(Sql_hong.SELECT_CATEGORY2_BY_CS);
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
	
	//cs list 출력
	public List<CsQnaVO> selectQnaArticles(String cate1 ,int start) {
		logger.info("selectQnaArticles start...");
		List<CsQnaVO> articles = new ArrayList<>();
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_hong.SELECT_QNA_ARTICLES);
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
				vo.setWdate(rs.getString(8));
				vo.setQnaCond(rs.getString(9));
				vo.setC1Name(rs.getString(10));
				vo.setC2Name(rs.getString(11));
				articles.add(vo);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("articles : "+articles);
		return articles;
	}
	
	// 전체 게시물 쿠은트
	public int selectCountTotal(String cate1) {
		int total = 0;
		try {
			conn = getConnection();
			psmt = conn.prepareStatement(Sql_hong.SELECT_COUNT_TOTAL);
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
			psmt = conn.prepareStatement(Sql_hong.SELECT_QNA_ARTICLE);
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
				vo.setWdate(rs.getString(8));
				vo.setQnaCond(rs.getString(9));
				
			}
			close();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("vo : "+vo);
		return vo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
